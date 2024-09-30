package vo;

public class PageInfo {
	
	private int page; //현재 선택된 페이지(nowBtn버튼)
	private int maxPage; //필요한 전체 페이지(totalBtnCnt전체 버튼 개수)
	private int startPage; //현재 페이지에서 보여줄 시작 페이지번호(starBtn 시작 버튼 버튼번호)
	private int endPage; //현재 페이지에 보여줄 마지막 페이지 번호(endBtn 마지막 버튼 버튼번호)
	private int listCount; //전체 목록 개수(totalListCnt해당)
	
	public PageInfo() {}
	
	public PageInfo(int page, int maxPage, int startPage, int endPage, int listCount) {
		this.page = page;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.listCount = listCount;
	}

	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getMaxPage() {
		return maxPage;
	}
	
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getListCount() {
		return listCount;
	}
	
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

}
