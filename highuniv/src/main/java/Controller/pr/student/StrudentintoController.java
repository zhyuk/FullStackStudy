package Controller.pr.student;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.StudentService;
import vo.StudentVO;

@WebServlet("/professor/student_info/studentinto.pr")
public class StrudentintoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		StudentVO student = new StudentVO();
		
		String saveFolder = "/image/studentimg";
		int fileSize = 5 * 1024 * 1024;
		ServletContext context = request.getServletContext();
//		String realFolder = context.getRealPath(saveFolder);
		String realFolder = "C:\\jspwork\\highuniv\\src\\main\\webapp\\"+saveFolder;
		
		
		File f = new File(realFolder);
		if(!f.exists()) f.mkdirs();
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",new DefaultFileRenamePolicy()); 
		
		student.setStudent_id(multi.getParameter("student_id"));
		student.setStudent_pw(multi.getParameter("student_pw"));
		student.setStudent_name(multi.getParameter("student_name"));
		student.setStudent_email(multi.getParameter("student_email"));
		student.setStudent_ph(multi.getParameter("student_ph"));
		student.setStudent_birth(multi.getParameter("student_birth"));
		student.setStudent_intoday(multi.getParameter("student_intoday"));
		student.setStudent_year(Integer.parseInt(multi.getParameter("student_year")));
		student.setStudent_major(multi.getParameter("student_major"));
		student.setStudent_address(multi.getParameter("student_address"));
		student.setStudent_gender(multi.getParameter("student_gender"));
		student.setStudent_status(multi.getParameter("student_status"));
		student.setStudent_use("Y");
		
	    // 이미지 파일 처리
	    String originalFileName = multi.getOriginalFileName((String) multi.getFileNames().nextElement()); // 원래 파일 이름
	    String filesystemName = multi.getFilesystemName((String) multi.getFileNames().nextElement()); // 저장된 파일 이름 (중복되면 변경된 이름)
	    
	    if (filesystemName != null) {
	        student.setStudent_image(filesystemName); // 저장된 파일 이름을 설정
	    } else {
	        student.setStudent_image(originalFileName); // 변경되지 않았을 경우 원래 파일 이름을 설정
	    }
	    	
		StudentService studentintoservice = new StudentService();
		int insertCount = studentintoservice.insertStudent(student);
		
		response.setContentType("text/html;charset=UTF-8"); // 추가
		PrintWriter out = response.getWriter();
		
		if (insertCount>0) {
			out.println("<script>");
			out.println("alert('입력성공');");
			out.println("location.href='studentlist.pr';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('입력실패');");
			out.println("window.history.back();");
			out.println("</script>");
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 String student_id = request.getParameter("student_id");
		 StudentService studentService = new StudentService();

		 
		 int chkCount = studentService.studentid_chk(student_id);
		 String meg = student_id + "학번은 사용이 가능합니다.";
		 
		 if(chkCount>0) {
			 meg = student_id + "학번은 중복입니다.";
		 }else if(student_id.equals("")){
			 meg = "학번을 입력해주세요.";
		 }
		  
		  JSONObject jObject = new JSONObject();
		  jObject.put("meg", meg);
		    
		  response.setContentType("application/json; charset=utf-8"); // 수정된 부분
		  response.getWriter().print(jObject); // 데이터 보냄
	 }

}
