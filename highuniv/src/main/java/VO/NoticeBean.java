package vo;


public class NoticeBean  {

    private int notice_id;
    private String notice_writer;
    private String notice_title;
    private String notice_content;
    private String notice_date;
    private int notice_view;
    private String notice_pass;
    private String notice_file;
    private String notice_writer_id;
    private String is_notice;


	// 기본 생성자
    public NoticeBean() {}

 // 모든 필드를 사용하는 생성자
    public NoticeBean(int notice_id, String notice_writer, String notice_title, String notice_content, String notice_date, int notice_view, String notice_writer_id, String notice_file, String is_notice) {
        this.notice_id = notice_id;
        this.notice_writer = notice_writer;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
        this.notice_view = notice_view;
        this.notice_writer_id = notice_writer_id;
        this.notice_file = notice_file; 
        this.is_notice = is_notice; 
        
    }


    // Getter & Setter 메서드
    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_writer() {
        return notice_writer;
    }

    public void setNotice_writer(String notice_writer) {
        this.notice_writer = notice_writer;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(String notice_date) {
        this.notice_date = notice_date;
    }

    public int getNotice_view() {
        return notice_view;
    }

    public void setNotice_view(int notice_view) {
        this.notice_view = notice_view;
    }
    public String getNotice_pass() {
        return notice_pass;
    }

    public void setNotice_pass(String notice_pass) {
        this.notice_pass = notice_pass;
    }

    public String getNotice_file() {
        return notice_file;
    }

    public void setNotice_file(String notice_file) {
        this.notice_file = notice_file;
    }
    
    public String getNotice_writer_id() {
    	return notice_writer_id;
    }
    
    public void setNotice_writer_id(String notice_writer_id) {
    	this.notice_writer_id = notice_writer_id;
    }

	public String getIs_notice() {
		return is_notice;
	}

	public void setIs_notice(String is_notice) {
		this.is_notice = is_notice;
	}
    
    

}
