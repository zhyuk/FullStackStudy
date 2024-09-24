package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.CommentDAO;

public class CommentDeleteService {
public boolean isCommentWriter(int comment_no, String id) throws Exception {
		
		boolean isCommentWriter = false;
		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		isCommentWriter = commentDAO.isCommentWriter(comment_no, id);
		close(con);
		return isCommentWriter;
		
	}

	public boolean removeComment(int comment_no) throws Exception{
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		CommentDAO commentDAO = CommentDAO.getInstance();
		commentDAO.setConnection(con);
		int deleteCount = commentDAO.deleteComment(comment_no);
		
		if(deleteCount > 0){
			commit(con);
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}

}
