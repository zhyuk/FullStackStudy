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
import svc.NoticeModifyProService;
import vo.ActionForward;
import vo.NoticeBean; 

public class NoticeModifyProAction implements Action {

    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        boolean isModifySuccess = false;
        
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
        
        
        int notice_id = 0;
        String notie_pass = null;
        
        for (FileItem item : formItems) {
        	if (item.getFieldName().equals("NOTICE_ID")) {
            	notice_id = Integer.parseInt(item.getString("UTF-8"));
        	}
        	if(item.getFieldName().equals("NOTICE_PASS")) {
        		notie_pass = item.getString("UTF-8");
        	}
        }
        
        // 세션에서 로그인한 사용자 id 가져오기
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");  // 로그인한 사용자의 id (admin인지 확인)
        
        boolean isRightUser = false; // 사용자 권한 플래그
        
        // 로그인한 사용자가 admin인 경우 수정 권한을 부여
        if ("admin".equals(userId)) {
            isRightUser = true;
        } else {
            // admin이 아닌 경우 기존 방식으로 수정 권한 확인
            NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
            isRightUser = noticeModifyProService.isNoticeWriter(notice_id, notie_pass);
        }
        
        if (!isRightUser) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('수정할 권한이 없습니다.');");
            out.println("history.back();");
            out.println("</script>");
        } else {
        	// 공지 수정 로직
        	NoticeBean notice = new NoticeBean();
            
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
                    	notice.setNotice_title(item.getString("UTF-8"));	 
                    }
                    if (item.getFieldName().equals("NOTICE_WRITER")) {
                    	notice.setNotice_writer(item.getString("UTF-8"));
                    }
                    if (item.getFieldName().equals("NOTICE_CONTENT")) {
                    	notice.setNotice_content(item.getString("UTF-8"));
                    }
                    
                    notice.setNotice_id(notice_id);
                    
                 // '공지로 설정' 체크박스 처리
                    if (item.getFieldName().equals("IS_NOTICE")) {
                        String isNotice = item.getString();
                        notice.setIs_notice(isNotice != null && isNotice.equals("1") ? "Y" : "N");
                    }
                }
            }
            
            // 공지로 설정 체크박스가 전송되지 않은 경우 기본값 "N" 설정
            if (notice.getIs_notice() == null) {
            	notice.setIs_notice("N");
            }

            // 공지사항 내용에 이미지 태그 추가
            notice.setNotice_content( imageTagsBuilder.toString() + notice.getNotice_content());
            notice.setNotice_file(fileNamesBuilder.toString());
            
            
            
            //공지사항 수정 쿼리문 실행
        	NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
            isModifySuccess = noticeModifyProService.modifyNotice(notice);

            
            // 공지사항 수정여부
            if (!isModifySuccess) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('수정실패');");
                out.println("history.back()");
                out.println("</script>");
            } else {
                forward = new ActionForward();
                forward.setRedirect(true);
                forward.setPath("noticeDetail.nt?notice_id=" + notice.getNotice_id() + "&page=" + request.getParameter("page"));
            }
        }
        return forward;
    }
}