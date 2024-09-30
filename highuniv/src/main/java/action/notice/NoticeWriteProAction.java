package action.notice;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import action.Action;
import svc.NoticeWriteProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeWriteProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        NoticeBean noticeBean = new NoticeBean();

        // 파일 및 이미지 저장 경로 설정
        String realFolder = "";
        String saveFileFolder = "/noticeUpload"; // 파일 저장 폴더
        String saveImgFolder = "/noticeImages";  // 이미지 저장 폴더
        int fileSize = 100 * 1024 * 1024; // 100MB
        ServletContext context = request.getServletContext();
        realFolder = context.getRealPath(""); 
        String realFileFolder = realFolder + saveFileFolder; // 실제 파일 저장 경로
        String realImgFolder = realFolder + saveImgFolder;   // 실제 이미지 저장 경로

        // 파일 저장 폴더와 이미지 저장 폴더 생성
        File fileUploadDir = new File(realFileFolder);
        File imgUploadDir = new File(realImgFolder);
        if (!fileUploadDir.exists()) {
            fileUploadDir.mkdirs();
        }
        if (!imgUploadDir.exists()) {
            imgUploadDir.mkdirs();
        }

        // 다중 파일 및 이미지 업로드 처리
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(fileSize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(fileSize);

        List<FileItem> formItems = upload.parseRequest(request);
        StringBuilder fileNamesBuilder = new StringBuilder();
        StringBuilder imageTagsBuilder = new StringBuilder();

        for (FileItem item : formItems) {
            if (!item.isFormField()) {
                String fileName = FilenameUtils.getName(item.getName());
                if (fileName != null && !fileName.isEmpty()) {
                    // 파일 첨부
                    if (item.getFieldName().equals("NOTICE_FILE[]")) {
                        String filePath = realFileFolder + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);

                        if (fileNamesBuilder.length() > 0) {
                            fileNamesBuilder.append(",");
                        }
                        fileNamesBuilder.append(fileName);
                    }
                    // 이미지 첨부
                    if (item.getFieldName().equals("NOTICE_IMG[]")) {
                        String imgPath = realImgFolder + File.separator + fileName;
                        File storeImg = new File(imgPath);
                        item.write(storeImg);

                        String imgUrl = request.getContextPath() + saveImgFolder + "/" + fileName;
                        String imageTag = "<p><img src='" + imgUrl + "' alt='Uploaded Image' style='max-width: 100%; height: auto;'/></p>";
                        imageTagsBuilder.append(imageTag);
                    }
                }
            } else {
                // 폼 필드 처리
                if (item.getFieldName().equals("NOTICE_TITLE")) {
                    noticeBean.setNotice_title(item.getString("UTF-8"));
                }
                if (item.getFieldName().equals("NOTICE_WRITER")) {
                    noticeBean.setNotice_writer(item.getString("UTF-8"));
                }
                if (item.getFieldName().equals("NOTICE_CONTENT")) {
                    noticeBean.setNotice_content(item.getString("UTF-8"));
                }
             // '공지로 설정' 체크박스 처리
                if (item.getFieldName().equals("IS_NOTICE")) {
                    String isNotice = item.getString();
                    noticeBean.setIs_notice(isNotice != null && isNotice.equals("1") ? "Y" : "N");
                }
            }
        }
        
        // 공지로 설정 체크박스가 전송되지 않은 경우 기본값 "N" 설정
        if (noticeBean.getIs_notice() == null) {
            noticeBean.setIs_notice("N");
        }

        // 공지사항 내용에 이미지 태그 추가
        // 이미지가 먼저 나오고 그 뒤에 텍스트 내용이 오도록 설정
        noticeBean.setNotice_content(imageTagsBuilder.toString() + noticeBean.getNotice_content());
        noticeBean.setNotice_file(fileNamesBuilder.toString());


        // 세션에서 professor_id 가져오기
        HttpSession session = request.getSession();
        String professorId = (String) session.getAttribute("id");
        noticeBean.setNotice_writer_id(professorId);

        // 공지사항 작성 처리
        NoticeWriteProService noticeWriteProService = new NoticeWriteProService();
        boolean isWriteSuccess = noticeWriteProService.writeNotice(noticeBean);

        if (!isWriteSuccess) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('등록 실패');");
            out.println("history.back();");
            out.println("</script>");
        } else {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("noticeList.nt");
        }

        return forward;
    }
}
