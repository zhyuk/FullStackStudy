package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//데이터베이스 작업을 할 때 반복적으로 수행해야 하는 작업을 정의하는 클래스
public class JdbcUtil {
	private static Connection conn = null;
	
	public static Connection getConnection(){
		try {
			Context itx = new InitialContext();
			DataSource ds = (DataSource)itx.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("connect succes");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection con){
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con){
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con){
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











