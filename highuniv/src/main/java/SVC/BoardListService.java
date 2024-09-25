package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;

public class BoardListService {

	public int getListCount() throws Exception{
		int listCount = 0; // 글의 개수
		Connection con = getConnection();
		
//		BoardDAO 객체 생성
		BoardDAO boardDAO = BoardDAO.getInstance();
//		BoardDAO의 setConnection메소드 실행
		boardDAO.setConnection(con);
//		BoardDAO의 selectListCount 메소드 실행 (글의 개수)
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<BoardBean> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page, limit);
		close(con);
		return articleList;
		
	}
	
	public ArrayList<BoardBean> searchArticles(String type, String keyword, int page, int limit) {
		ArrayList<BoardBean> articleList = new ArrayList<>();
	    Connection con = getConnection();
	    BoardDAO boardDAO = BoardDAO.getInstance();
	    boardDAO.setConnection(con);
	    articleList = boardDAO.searchArticleList(type, keyword, page, limit);
		close(con);
		return articleList;
	}

}
