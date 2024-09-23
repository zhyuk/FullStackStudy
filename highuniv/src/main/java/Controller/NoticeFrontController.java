package Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.NoticeDetailAction;
import action.NoticeDeleteProAction;
import action.NoticeListAction;
import action.NoticeWriteProAction;
import action.SetNoticeAsPrivateAction;
import action.SetNoticeAsPublicAction;
import action.NoticeModifyFormAction;
import action.NoticeModifyProAction;

import vo.ActionForward;

@WebServlet("*.nt")
public class NoticeFrontController extends javax.servlet.http.HttpServlet  {
   private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());

        ActionForward forward = null;
        Action action = null;

        if (command.equals("/professor/noticeWriteForm.nt")) {
            forward = new ActionForward();
            forward.setPath("/professor/notice_write.jsp");
        }
        else if (command.equals("/professor/noticeWritePro.nt")) {
            action = new NoticeWriteProAction();
            
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (command.equals("/professor/noticeList.nt")) {
            action = new NoticeListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(command.equals("/professor/noticeModifyForm.nt")){
         action = new NoticeModifyFormAction();
         try{
            forward=action.execute(request, response);
         }catch(Exception e){
            e.printStackTrace();
         }
      }else if(command.equals("/professor/noticeModifyPro.nt")){
         action = new NoticeModifyProAction();
         try{
            forward=action.execute(request, response);
         }catch(Exception e){
            e.printStackTrace();
         }
      }else if(command.equals("/professor/noticeDeleteForm.nt")){
         String nowPage = request.getParameter("page");
         request.setAttribute("page", nowPage);
         int notice_id=Integer.parseInt(request.getParameter("notice_id"));
         request.setAttribute("notice_id",notice_id);
         forward=new ActionForward();
         forward.setPath("/professor/notice_delete.jsp");
      }else if(command.equals("/professor/noticeDeletePro.nt")){
         action = new NoticeDeleteProAction();
         try{
            forward=action.execute(request, response);
         }catch(Exception e){
            e.printStackTrace();
         }
      }else if (command.equals("/professor/noticeDetail.nt")) {
            action = new NoticeDetailAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/professor/setNoticeAsPublic.nt")) {
            action = new SetNoticeAsPublicAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }else if (command.equals("/professor/setNoticeAsPrivate.nt")) {
            action = new SetNoticeAsPrivateAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
         //파일 다운로드 하기
           try {
               // fileName 파라미터로 파일명을 가져온다 (콤마로 분리)
               String fileNamesParam = request.getParameter("fname");
               String[] fileNames = fileNamesParam.split(",");

               ServletContext context = request.getServletContext();
               String filePath = context.getRealPath("/noticeUpload/"); // 동적으로 파일 경로 설정

               // 여러 개의 파일 처리
               for (String fileName : fileNames) {
                   File dFile = new File(filePath, fileName.trim());

                   // 파일이 존재하는지 확인
                   if (dFile.exists()) {
                       int fSize = (int) dFile.length();

                       if (fSize > 0) {
                           // 파일명을 URLEncoder 하여 attachment, Content-Disposition Header로 설정
                           String encodedFilename = "attachment; filename*=" + "UTF-8" + "''" + URLEncoder.encode(fileName, "UTF-8");

                           // ContentType 설정 (application/octet-stream: 8비트 바이너리 데이터)
                           response.setContentType("application/octet-stream; charset=utf-8");
                           response.setHeader("Content-Disposition", encodedFilename);
                           response.setContentLengthLong(fSize);

                           try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(dFile));
                                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream())) {

                               byte[] buffer = new byte[4096];
                               int bytesRead;
                               while ((bytesRead = in.read(buffer)) != -1) {
                                   out.write(buffer, 0, bytesRead);
                               }
                               out.flush();
                           }
                       } else {
                           throw new FileNotFoundException("파일이 없습니다.");
                       }
                   } else {
                       throw new FileNotFoundException("파일이 없습니다: " + fileName);
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }

          
        }

        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
      }
        
      
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doProcess(request, response);
    }
    
}
