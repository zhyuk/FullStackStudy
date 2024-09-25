package Controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardSearchAction;
import action.BoardWriteProAction;
import action.CommentDeleteAction;
import action.CommentWriteAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

//		게시판글쓰기 클릭
		if (command.equals("/boardWriteForm.bo")) {
			forward = new ActionForward();
//			/board/qna_board_write.jsp로 이동
			forward.setPath("/board/board_write.jsp");
			
		}else if (command.equals("/boardWritePro.bo")) {
			// BoardWriteProAction.java 객체 생성
			action = new BoardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/commentWrite.bo")) {
			// BoardWriteProAction.java 객체 생성
			action = new CommentWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		BoardWriteProAction.java에서 등록
		else if (command.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/boardModifyForm.bo")) { //수정
			action = new BoardModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyPro.bo")) { //수정2
			action = new BoardModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDelete.bo")) { //글 삭제
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/commentDelete.bo")) { //댓글 삭제
			action = new CommentDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardSearch.bo")) { //글 검색
			action = new BoardSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else {
			// 파일 다운로드 하기
			try {
				// fileName 파라미터로 파일명을 가져온다.
				String fileName = request.getParameter("fname");

				// 파일이 실제 업로드 되어있는(파일이 존재하는) 경로를 지정한다._경로수정
				String filePath = "C:\\jwork\\highuniv\\src\\main\\webapp\\boardUpload\\";

				// 경로와 파일명으로 파일 객체를 생성한다.
				File dFile = new File(filePath, fileName);

				// 파일 길이를 가져온다.
				int fSize = (int) dFile.length();

				// 파일이 존재
				if (fSize > 0) {

					// 파일명을 URLEncoder 하여 attachment, Content-Disposition Header로 설정
					String encodedFilename = "attachment; filename*=" + "UTF-8" + "''"
							+ URLEncoder.encode(fileName, "UTF-8");

					// ContentType 설정 (8비트로 된 데이터라는 의미임. 1바이트 단위의 데이터들을 핸들링하는 타입을 의미함.)
					response.setContentType("application/octet-stream; charset=utf-8");

					// Header 설정
					response.setHeader("Content-Disposition", encodedFilename);

					// ContentLength 설정
					response.setContentLengthLong(fSize);

					BufferedInputStream in = null;
					BufferedOutputStream out = null;

					in = new BufferedInputStream(new FileInputStream(dFile));
					out = new BufferedOutputStream(response.getOutputStream());

					try {
						byte[] buffer = new byte[4096];
						int bytesRead = 0;

						/*
						 * 모두 현재 파일 포인터 위치를 기준으로 함 (파일 포인터 앞의 내용은 없는 것처럼 작동) int read() : 1byte씩 내용을 읽어
						 * 정수로 반환 int read(byte[] b) : 파일 내용을 한번에 모두 읽어서 배열에 저장 int read(byte[] b. int
						 * off, int len) : 'len'길이만큼만 읽어서 배열의 'off'번째 위치부터 저장
						 */
						while ((bytesRead = in.read(buffer)) != -1) {
							out.write(buffer, 0, bytesRead);
						}

						// 버퍼에 남은 내용이 있다면, 모두 파일에 출력
						out.flush();
					} finally {
						/*
						 * 현재 열려 in,out 스트림을 닫음 메모리 누수를 방지하고 다른 곳에서 리소스 사용이 가능하게 만듬
						 */
						in.close();
						out.close();
					}
				} else {
					throw new FileNotFoundException("파일이 없습니다.");
				}
			} catch (Exception e) {
				e.getMessage();
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