//package Controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import scv.CourseService;
//
//@WebServlet("/course_register/Courselist.cl")
//public class CourseRegisterCount extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//            throws ServletException, IOException {
//        
//        // 요청으로부터 courseId 가져오기
//        String courseId = request.getParameter("courseId");
//        System.out.println("courseId: " + courseId);
//        
//        // CourseService를 통해 등록된 수강생 수 가져오기
//        CourseService courseService = new CourseService();
//        int registrationCount = courseService.getCourseRegisterCount(courseId);
//        
//        // 결과를 request 객체에 저장
//        request.setAttribute("registrationCount", registrationCount);
//        
//        // JSP로 포워딩
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/course_register/course_list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//}