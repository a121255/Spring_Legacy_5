package com.iu.s5.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	

//	
//	@Test
//	public void daoIsnull() {
//		assertNotNull(noticeDAO);
//		
//	}
//	
	
	/*
	 * @Test public void boardWriteTest() throws Exception { NoticeVO noticeVO = new
	 * NoticeVO(); noticeVO.setTitle("testTitle"); noticeVO.setWriter("testWriter");
	 * noticeVO.setContents("testContents"); int result =
	 * noticeDAO.boradWrite(noticeVO);
	 * 
	 * assertEquals(1, result); }
	 * 
	 */
	
	@Test
	public void boardUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("dd");
		noticeVO.setContents("cocococo");
		noticeVO.setNum(2);
		int result = noticeDAO.boardUpdate(noticeVO);
		assertNotEquals(0, result);
	}

}
