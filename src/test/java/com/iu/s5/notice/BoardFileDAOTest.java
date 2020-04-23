package com.iu.s5.notice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s5.AbstractTestCase;
import com.iu.s5.board.file.BoardFileDAO;
import com.iu.s5.board.file.BoardFileVO;

public class BoardFileDAOTest extends AbstractTestCase {

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	
	@Test
	public void test() throws Exception{

		BoardFileVO boardFileVO = new BoardFileVO();
		
		boardFileVO.setNum(10);
		boardFileVO.setFileName("ff12sdklnw92s5da55");
		boardFileVO.setOriName("file0102");
		boardFileVO.setBoard(1);
		
		
		boardFileDAO.fileInsert(boardFileVO);


		assertNotNull(boardFileDAO);
	}

}
