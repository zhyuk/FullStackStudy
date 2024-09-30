
package dao;

import static util.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vo.NoticeBean;

public class NoticeDAO {
    Connection con;
    private static NoticeDAO noticeDAO;

    private NoticeDAO() {
        // 생성자
    }

    public static NoticeDAO getInstance(){
        if(noticeDAO == null){
            noticeDAO = new NoticeDAO();
        }
        return noticeDAO;
    }

    public void setConnection(Connection con){
        this.con = con;
    }
    
    // 공지사항 목록의 개수 구하기
    public int selectListCount() {
        int listCount = 0;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(*) FROM notice";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                listCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return listCount;
    }

    

    // 공지사항 상세 보기
    public NoticeBean selectNotice(int noticeId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        NoticeBean notice = null;

        try {
            pstmt = con.prepareStatement("SELECT * FROM notice WHERE notice_id = ?");
            pstmt.setInt(1, noticeId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                notice = new NoticeBean();
                notice.setNotice_id(rs.getInt("notice_id"));
                notice.setNotice_writer(rs.getString("notice_writer"));
                notice.setNotice_writer_id(rs.getString("notice_writer_id"));
                notice.setNotice_title(rs.getString("notice_title"));
                notice.setNotice_content(rs.getString("notice_content"));
                notice.setNotice_date(rs.getString("notice_date"));
                notice.setNotice_view(rs.getInt("notice_view"));
                notice.setNotice_file(rs.getString("notice_file"));
                notice.setIs_notice(rs.getString("is_notice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return notice;
    }

    public int insertNotice(NoticeBean notice) {
        PreparedStatement pstmt = null;
        int insertCount = 0;

        try {
            // 현재 날짜를 yyyy-MM-dd 형식으로 변환
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = sdf.format(new Date());

            // 공지 여부(is_notice)도 포함한 쿼리
            String sql = "INSERT INTO notice (notice_id, notice_writer, notice_title, notice_content, notice_date, notice_view, notice_writer_id, notice_file, is_notice) "
                       + "VALUES (notice_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, notice.getNotice_writer());  // 작성자 이름
            pstmt.setString(2, notice.getNotice_title());   // 제목
            pstmt.setString(3, notice.getNotice_content()); // 내용
            pstmt.setString(4, currentDate);                // 작성 날짜
            pstmt.setInt(5, notice.getNotice_view());       // 조회수 (기본값 0)
            pstmt.setString(6, notice.getNotice_writer_id()); // 작성자 ID (세션에서 가져온 값)
            pstmt.setString(7, (notice.getNotice_file() != null) ? notice.getNotice_file() : ""); // 파일 첨부 여부
            pstmt.setString(8, notice.getIs_notice());      // 공지 여부 ("Y" 또는 "N")
            
            insertCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return insertCount;
    }

    // 공지사항 수정
    public int updateNotice(NoticeBean notice) {
        PreparedStatement pstmt = null;
        int updateCount = 0;

        // 공지 여부(is_notice)를 업데이트하는 쿼리로 수정
        String sql = "UPDATE notice SET notice_title = ?, notice_content = ?, notice_writer = ?, is_notice = ? , notice_file = ? WHERE notice_id = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, notice.getNotice_title());
            pstmt.setString(2, notice.getNotice_content());
            pstmt.setString(3, notice.getNotice_writer());
            pstmt.setString(4, notice.getIs_notice());  // 공지 여부 설정
            pstmt.setString(5, (notice.getNotice_file() != null) ? notice.getNotice_file() : ""); // 파일 첨부 여부
            pstmt.setInt(6, notice.getNotice_id());

            updateCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return updateCount;
    }


    // 공지사항 삭제
    public int deleteNotice(int noticeId) {
        PreparedStatement pstmt = null;
        int deleteCount = 0;

        try {
            String sql = "DELETE FROM notice WHERE notice_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, noticeId);

            deleteCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return deleteCount;
    }

    // 조회수 업데이트
    public int updateNoticeView(int notice_id) {
        PreparedStatement pstmt = null;
        int updateCount = 0;

        try {
            String sql = "UPDATE notice SET notice_view = notice_view + 1 WHERE notice_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, notice_id);

            updateCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return updateCount;
    }

    // 글쓴이인지 확인
    public boolean isNoticesWriter(int notice_id, String pass) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isWriter = false;
        
        String notice_sql = "SELECT p.professor_pw " +
                "FROM notice n " +
                "JOIN professor p ON n.notice_writer_id = p.professor_id " +
                "WHERE n.notice_id = ?";

        try {
            pstmt = con.prepareStatement(notice_sql);
            pstmt.setInt(1, notice_id);
            rs = pstmt.executeQuery();

         // professor_pw와 입력한 비밀번호를 비교
            if (rs.next() && pass.equals(rs.getString("professor_pw"))) {
                isWriter = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(pstmt);
        }

        return isWriter;
    }
    
    
    

//     [공지] 공지사항 조회 (is_notice = 'Y')
    	public ArrayList<NoticeBean> selectAllNotices() {
    		
        ArrayList<NoticeBean> noticeList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // 페이징 없이 공지사항 우선 정렬하는 SQL
        String sql = "SELECT * FROM notice"
                   + " ORDER BY DECODE(is_notice, 'Y', 1, 'N', 2) ASC, notice_id DESC";

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                NoticeBean notice = new NoticeBean();
                notice.setNotice_id(rs.getInt("notice_id"));
                notice.setNotice_writer(rs.getString("notice_writer"));
                notice.setNotice_title(rs.getString("notice_title"));
                notice.setNotice_date(rs.getString("notice_date"));
                notice.setNotice_view(rs.getInt("notice_view"));
                notice.setIs_notice(rs.getString("is_notice"));
                noticeList.add(notice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return noticeList;
    }
    	
    	public ArrayList<NoticeBean> selectNoticeList(int page, int limit) {
    	    ArrayList<NoticeBean> noticeList = new ArrayList<>();
    	    PreparedStatement pstmt = null;
    	    ResultSet rs = null;

    	    // 공지사항이 위에 먼저 출력되도록 수정한 SQL
    	    String sql = "SELECT * FROM ("
    	               + "SELECT ROWNUM RNUM, A.* FROM ("
    	               + "SELECT * FROM notice "
    	               + "ORDER BY DECODE(is_notice, 'Y', 1, 'N', 2) ASC, notice_id DESC"
    	               + ") A"
    	               + ") WHERE RNUM BETWEEN ? AND ?";

    	    int startrow = (page - 1) * 10 + 1;
    	    int endrow = startrow + limit - 1;

    	    try {
    	        pstmt = con.prepareStatement(sql);
    	        pstmt.setInt(1, startrow);
    	        pstmt.setInt(2, endrow);
    	        rs = pstmt.executeQuery();

    	        while (rs.next()) {
    	            NoticeBean notice = new NoticeBean();
    	            notice.setNotice_id(rs.getInt("notice_id"));
    	            notice.setNotice_writer(rs.getString("notice_writer"));
    	            notice.setNotice_title(rs.getString("notice_title"));
    	            notice.setNotice_content(rs.getString("notice_content"));
    	            notice.setNotice_date(rs.getString("notice_date"));
    	            notice.setNotice_view(rs.getInt("notice_view"));
    	            notice.setIs_notice(rs.getString("is_notice"));
    	            noticeList.add(notice);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        close(rs);
    	        close(pstmt);
    	    }

    	    return noticeList;
    	}

    

    // 일반 게시글에만 페이지네이션 적용
    public ArrayList<NoticeBean> selectGeneralNotices(int page, int limit) {
        ArrayList<NoticeBean> noticeList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM notice WHERE is_notice = 'N' ORDER BY notice_id DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        int startRow = (page - 1) * limit; // 시작 행 계산

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, limit);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                NoticeBean notice = new NoticeBean();
                notice.setNotice_id(rs.getInt("notice_id"));
                notice.setNotice_writer(rs.getString("notice_writer"));
                notice.setNotice_title(rs.getString("notice_title"));
                notice.setNotice_date(rs.getString("notice_date"));
                notice.setNotice_view(rs.getInt("notice_view"));
                notice.setIs_notice(rs.getString("is_notice"));
                noticeList.add(notice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return noticeList;
    }

    
    // 공지사항 검색 메서드
 // 공지사항 검색 메서드
    public ArrayList<NoticeBean> searchNoticeList(String type, String keyword, int page, int limit) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<NoticeBean> noticeList = new ArrayList<NoticeBean>();

        int startrow = (page - 1) * limit + 1; // 시작 번호
        int endrow = page * limit; // 끝 번호
        String[] typeArr = type.split(",");

        String sql = "";
        sql += "SELECT * FROM (";
        sql += "  SELECT * FROM (";
        sql += "    SELECT rownum rnum, A.* FROM (";
        sql += "      SELECT * FROM notice WHERE 1=1 ";

        // 검색 조건 추가
        if (typeArr.length <= 1) {
            sql += " AND " + type + " LIKE ? ";  // 단일 검색 조건
        } else {
            for (int i = 0; i < typeArr.length; i++) {
                if (i == 0) sql += " AND ( " + typeArr[i] + " LIKE ? ";  // 첫 번째 조건
                else if (i != typeArr.length - 1) sql += " OR " + typeArr[i] + " LIKE ? ";  // 중간 조건
                else sql += " OR " + typeArr[i] + " LIKE ? )";  // 마지막 조건
            }
        }

        // 정렬: 공지사항 상단, 나머지 내림차순
        sql += "      ORDER BY CASE WHEN IS_NOTICE = 'Y' THEN 0 ELSE 1 END, ";
        sql += "               NOTICE_ID DESC ";
        sql += "    ) A";
        sql += "  ) WHERE rownum <= ?";  // endrow, 페이지 끝 번호
        sql += ") WHERE rnum >= ?";  // startrow, 페이지 시작 번호

        try {
            pstmt = con.prepareStatement(sql);

            // 파라미터 설정
            if (typeArr.length <= 1) {
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setInt(2, endrow);
                pstmt.setInt(3, startrow);
            } else {
                int i = 1;
                for (; i <= typeArr.length; i++) {
                    pstmt.setString(i, "%" + keyword + "%");
                }
                pstmt.setInt(i, endrow);
                pstmt.setInt(++i, startrow);
            }

            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                NoticeBean notice = new NoticeBean();
                notice.setNotice_id(rs.getInt("NOTICE_ID"));
                notice.setNotice_writer(rs.getString("NOTICE_WRITER"));
                notice.setNotice_title(rs.getString("NOTICE_TITLE"));
                notice.setNotice_content(rs.getString("NOTICE_CONTENT"));
                notice.setNotice_date(rs.getString("NOTICE_DATE"));
                notice.setNotice_view(rs.getInt("NOTICE_VIEW"));
                notice.setNotice_writer_id(rs.getString("NOTICE_WRITER_ID"));
                notice.setNotice_file(rs.getString("NOTICE_FILE"));
                notice.setIs_notice(rs.getString("IS_NOTICE"));
                noticeList.add(notice);
            }

        } catch (Exception ex) {
            System.out.println("searchNoticeList 에러 : " + ex);
        } finally {
            close(rs);
            close(pstmt);
        }

        return noticeList;
    }



    
}
