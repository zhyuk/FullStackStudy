package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/OracleDB");
            con = ds.getConnection();
            con.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection con) {
        if (con != null) {
            try {
                con.commit();
                System.out.println("commit success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
                System.out.println("rollback success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
