package com.iu.s5.board;

import java.util.List;

import com.iu.s5.board.page.Pager;

public interface BoardDAO {
	//멤버변수 상수
	//추상메서드
	//public abstract
	//생략해도 자동으로 만들어짐
	
	//List
//	public abstract
	//qna도 담을 수 있고 notice도 담을 수 있는 데이터타입 BoardVO
	//public ArrayList<BoardVO>  부모형태   List<BoardVO>
	
	//count
	public long boardCount(Pager pager) throws Exception;
	
	
	
	//List
	public List<BoardVO> boardList(Pager pager) throws Exception; 
	
	
	//select
	public BoardVO boardSelect(long num) throws Exception;
	
	
	//insert
	public int boradWrite(BoardVO boardVO) throws Exception;
	
	//delete
	public int boardDelete(long num)throws Exception;
	
	
	//update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hit
	public int hitUpdate(long num) throws Exception;
	
}
