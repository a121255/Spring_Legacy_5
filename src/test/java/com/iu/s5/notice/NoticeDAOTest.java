package com.iu.s5.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;
import com.iu.s5.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	

	@Test
	public void daoTest()throws Exception{
		this.boardWriteTest();
	}
	
	

	
	//@Test
	public void daoIsnull() {
		assertNotNull(noticeDAO);
		
	}

	
	
	 @Test
	 public void boardWriteTest() throws Exception {
		 String writer="";
		 String title="";
		 String contents="";
		 
		 
		 for(int i=0; i<150; i++) {
			 NoticeVO noticeVO = new NoticeVO();
			 
			 if(i%3==0) {
				 writer="iu";
				 title="Alert";
				 contents="Samsung";
			 }else if(i%3==1) {
				 writer="coco";
				 title="computer";
				 contents ="apple";
			 }else {
				 writer="kh";
				 title="os";
				 contents="linux";
			 }
			 
			 
			 
			 noticeVO.setTitle(title+i);
			 noticeVO.setWriter(writer);
			 noticeVO.setContents(contents+i);
			 noticeDAO.boradWrite(noticeVO);
			 int result = noticeDAO.boradWrite(noticeVO);
			 
			 if(i==50 || i==100) {
				 Thread.sleep(1000);
			 }
			 
		 }
	
	  }
	  
	 
	
	/*
	 * @Test public void boardUpdateTest() throws Exception{ NoticeVO noticeVO = new
	 * NoticeVO(); noticeVO.setTitle("totototo"); noticeVO.setContents("cocococo");
	 * noticeVO.setNum(8); int result = noticeDAO.boardUpdate(noticeVO);
	 * assertNotEquals(0, result); }
	 */

	//@Test
	public void boardHit() throws Exception{
		int result = noticeDAO.hitUpdate(4);
		assertNotEquals(0, result);
	}
	
	
	
	//@Test
	public BoardVO  boardSelectTest() throws Exception{
		BoardVO boardVO = noticeDAO.boardSelect(2);
		return boardVO;
		//assertNotNull(boardVO);
	}
	
	
	//만들 때는 noticeVO였지만 담을 때는 boardVO로 해주었음. 나중에 차이점 알게됨
	//@Test
	public List<BoardVO> boardListTest()throws Exception{
		return noticeDAO.boardList();
	}
	
	
	
	
}
