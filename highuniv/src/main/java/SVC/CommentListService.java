package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CommentDAO;
import vo.CommentBean;


public class CommentListService {

	public int getListCount(int board_no) throws Exception {
	    int listCount = 0; // 글의 개수
	    Connection con = getConnection();
	    
	    try {
	        CommentDAO commentDAO = CommentDAO.getInstance();
	        commentDAO.setConnection(con);
	        listCount = commentDAO.getCommentCount(board_no);
	    } finally {
	        close(con);
	    }
	    
	    return listCount;
	}


public ArrayList<CommentBean> getcommentList(int board_no) throws Exception{
		
		ArrayList<CommentBean> commentList = null;
		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		commentList = commentDAO.selectCommentList(board_no);
		close(con);
		return commentList;
		
	}

}
