package com.iu.s5.notice;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;
import com.iu.s5.board.BoardVO;
import com.iu.s5.member.MemberDAO;
import com.iu.s5.member.MemberVO;

public class NoticeDAOTest extends AbstractTestCase {
	

	
	@Autowired
	private MemberDAO memberDAO;
	
	
	
	

	@Test
	public void daoTest()throws Exception{
		this.boardWriteTest();
	}
	
	

	
	//@Test
	/*
	 * public void daoIsnull() { assertNotNull(noticeDAO);
	 * 
	 * }
	 */
	
	
	 @Test
	 public void boardWriteTest() throws Exception {
		 String id="";
		 String name="";
		 String phone="";
		 String email="";
		 
		 for(int i=0; i<150; i++) {
			 MemberVO memberVO = new MemberVO();
			 
			 if(i%3==0) {
				 id="iuiiou";
				 name="kkk";
				 phone="0101121000";
				 email= "ass@naver.com";
			 }else if(i%3==1) {
				 id="wasdss";
				 name="mmm";
				 phone="010112187";
				 email= "buynn@naver.com";
			 }else {
				 id="apple";
				 name="ooo";
				 phone="0101125525";
				 email= "qwr@naver.com";
			 }
			 
			 
			 memberVO.setId(id+i);
			 memberVO.setName(name+i);
			 memberVO.setPhone(phone);
			 memberVO.setEmail(email);
			 System.out.println(memberVO.getId());
	
			 memberDAO.memberWrite(memberVO);
			 
			 if(i==50 || i==100) {
				 Thread.sleep(1000);
			 }
			 
			 assertNotNull(memberDAO);
		 }
	
	  }
	  
	 
	
	/*
	 * @Test public void boardUpdateTest() throws Exception{ NoticeVO noticeVO = new
	 * NoticeVO(); noticeVO.setTitle("totototo"); noticeVO.setContents("cocococo");
	 * noticeVO.setNum(8); int result = noticeDAO.boardUpdate(noticeVO);
	 * assertNotEquals(0, result); }
	 */

	//@Test
		/*
		 * public void boardHit() throws Exception{ int result = noticeDAO.hitUpdate(4);
		 * assertNotEquals(0, result); }
		 */
	
	
	
	//@Test
	/*
	 * public BoardVO boardSelectTest() throws Exception{ BoardVO boardVO =
	 * noticeDAO.boardSelect(2); return boardVO; //assertNotNull(boardVO); }
	 */
	
	
	//만들 때는 noticeVO였지만 담을 때는 boardVO로 해주었음. 나중에 차이점 알게됨
	//@Test
	/*
	 * public List<BoardVO> boardListTest()throws Exception{ return
	 * noticeDAO.boardList(); }
	 */
	
	
	
}
