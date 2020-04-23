package com.iu.s5.notice;

import java.util.List;

import com.iu.s5.board.BoardVO;
import com.iu.s5.board.file.BoardFileVO;





public class NoticeVO extends BoardVO{  //noticeVO는 BoardVO도 된다
	
	
	private List<BoardFileVO> boardFileVOs;

	public List<BoardFileVO> getBoardFileVOs() {
		return boardFileVOs;
	}

	public void setBoardFileVOs(List<BoardFileVO> boardFileVOs) {
		this.boardFileVOs = boardFileVOs;
	}
	
	
	
	
	
	
//	private MultipartFile [] files;
//
//	public MultipartFile[] getFiles() {
//		return files;
//	}
//
//	public void setFiles(MultipartFile[] files) {
//		this.files = files;
//	}
	

	
}
