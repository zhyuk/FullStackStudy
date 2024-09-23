package Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.StudentService;
import vo.StudentVO;

@WebServlet("/professor/studentinto.pr")
public class StudentintoController extends HttpServlet {
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
		student.setStudent_image(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		
		System.out.println(student);
		
		StudentService studentintoservice = new StudentService();
		studentintoservice.insertStudent(student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
	    dispatcher.forward(request, response);
		
	}

}
