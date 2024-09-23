package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filedown.nt")
public class FileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fname"); // 파일명 파라미터로 전달받기
        
        
     // 동적으로 파일 경로 설정
        ServletContext context = request.getServletContext();
        String filePath = context.getRealPath("/noticeUpload/") + fileName; // 파일 경로

        File downloadFile = new File(filePath);
        if (downloadFile.exists()) {
            // 파일 다운로드 응답 설정
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            // 파일을 클라이언트로 전송
            FileInputStream inStream = new FileInputStream(downloadFile);
            ServletOutputStream outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            inStream.close();
            outStream.close();
        } else {
            response.getWriter().println("파일을 찾을 수 없습니다.");
        }
    }
}
