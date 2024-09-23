package action;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		BoardBean boardBean = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 5 * 1024 * 1024; //바이트 단위로 지정 5MB
		
		//실제 톰캣 서버에 배포할 경우 변경해야하는 경로
//		ServletContext context = request.getServletContext();
//		realFolder = context.getRealPath(saveFolder);
		
//		_수정
		
//		이미지 파일 업로드 C:\\jspwork\\servletproject05\\src\\main\\webapp\\boardUpload
		realFolder = "C:\\jspwork\\highuniv\\src\\main\\webapp\\"+saveFolder;
		File f = new File(realFolder);
		if(!f.exists()) f.mkdirs();
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy()); 
		boardBean = new BoardBean();
//		boardBean.setBOARD_NAME(multi.getParameter("BOARD_NAME")); 접속된 아이디(세션 받아와야함)
		boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_MAIN(multi.getParameter("BOARD_MAIN"));
		boardBean.setBOARD_FILE(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);

		if (!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");	
			out.println("history.back();");
			out.println("</script>");
		} else {
			//등록에 성공하면 BoardFrontController에 boardList.bo로 이동
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		}
		
		return forward;

	}

}