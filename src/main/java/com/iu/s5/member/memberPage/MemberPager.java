package com.iu.s5.member.memberPage;

public class MemberPager {
	private Long curPage; //현재
	private Integer perPage;  //페이지당 글 개수
	
	
	private Long totalPage;

	
	private Long totalBlock;
	
	
	
	
	private Long curBlock;
	
	
	private Long startNum;
	private Long lastNum;
	
	
	
	private Long startRow;
	private Long lastRow;
	
	
	

	public Long getStartRow() {
		return startRow;
	}


	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}


	public Long getLastRow() {
		return lastRow;
	}


	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}


	public Long getStartNum() {
		return startNum;
	}


	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}


	public Long getLastNum() {
		return lastNum;
	}


	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}


	public Long getCurBlock() {
		return curBlock;
	}


	public void setCurBlock(Long curBlock) {
		this.curBlock = curBlock;
	}


	public Long getTotalBlock() {
		return totalBlock;
	}


	public void setTotalBlock(Long totalBlock) {
		this.totalBlock = totalBlock;
	}


	public Long getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}


	public Long getCurPage() {
		return curPage;
	}


	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}


	public Integer getPerPage() {
		return perPage;
	}


	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}



	
	
	
	public void makePage(long totalCount) {
	
	//1. totalCount   :   전체 글의 개수
	//2. totalCount로 totalPage 계산
		this.totalPage = totalCount/this.getPerPage();

	
	
	//3. totalPage로 totalBlock 계산
		long perBlock = 5L;
		this.totalBlock = totalPage/perBlock;
		
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		
	//4. curPage로 curBlock 찾기
		
		//현재 몇블럭?
		this.curBlock = curPage/perBlock;
		
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		
	//현재 2블럭이라 치면
	//5. curBlcok으로 startNum, lastNum 계산
		

		
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock*perBlock;
		
		if(this.curBlock==this.totalBlock) {
			this.lastNum = this.totalPage;
		}
		

		
	}
	
	public void makeRow(){
		this.startRow = (this.getCurPage()-1) *this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
}
