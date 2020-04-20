package com.iu.s5.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.board.page.Pager;


@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception { //Pager pager >> 주소값을 받는것
		
		pager.makeRow();
		long totalCount = noticeDAO.boardCount(pager);
		System.out.println("totalCount : "+totalCount);
		pager.makePage(totalCount);  //리턴 안해줘도 가는 이유  >> 이미 static 영역에 올려져있음
		
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		
		return noticeDAO.boradWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
	
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		
		return noticeDAO.boardDelete(num);
	}

}
