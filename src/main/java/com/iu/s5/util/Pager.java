package com.iu.s5.util;

public class Pager {
	private Long curPage;
	private Integer perPage;
	
	
	private long startRow;
	private long lastRow;
	
	
	
	private long totalPage;  //여기에 totalPAge 들ㄱ감
	
	
	
	private long totalBlock;
	
	private long curBlock;
	
	
	
	private long startNum;
	private long lastNum;
	
	
	
	//------------------- search
	private String kind;
	private String search;
	
	
	
	
	
	
	
	
	
	
	
	
	public long getTotalBlock() {
		return totalBlock;
	}





	public long getCurBlock() {
		return curBlock;
	}





	public long getStartNum() {
		return startNum;
	}





	public long getLastNum() {
		return lastNum;
	}





	public void makeRow() {

		if(this.curPage == null || this.curPage ==0) {
			this.curPage = 1L;
		}
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		
		
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getKind() {
		return kind;
	}





	public void setKind(String kind) {
		this.kind = kind;
	}





	public String getSearch() {
		if(this.search==null){
			this.search="";
		}
		return search;
	}





	public void setSearch(String search) {
		this.search = search;
	}





	public void makePage(long totalCount) {
		//1. totalCount   :   전체 글의 개수
		
		//2. totalCount로 totalPage 계산
		this.totalPage = totalCount/this.getPerPage();  //87  / 10
		System.out.println("perPage : " + this.getPerPage());
		System.out.println("totalPage : " +totalPage);
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		//--------------------------------
		
		//3. totalPage로 totalBlock 계산
		long perBlock = 5L;  //block당 Page 수! 지금은 5개씩 묶음
		//totalPage
		
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		
		
		//4. curPage로 curBlock 찾기
		
		this.curBlock = curPage/perBlock;
		
		if(this.curPage%perBlock != 0) {
			this.curBlock++;
		}
		
		
		
		
		//5. curBlcok으로 startNum, lastNum 계산
		
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock*perBlock;
		
		
		if(this.curBlock==this.totalBlock) {
			this.lastNum=this.totalPage;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public long getTotalPage() {
		return totalPage;
	}





	public long getStartRow() {
		return startRow;
	}






	public long getLastRow() {
		return lastRow;
	}






	public Long getCurPage() {
		return curPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10;
		}
		
		
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
	
	
	
}
