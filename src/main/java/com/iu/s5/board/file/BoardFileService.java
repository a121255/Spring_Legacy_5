package com.iu.s5.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.util.FileSaver;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Autowired
	private ServletContext servletContext;  
	
	@Autowired
	private FileSaver fileSaver;
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception {
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
		//System.out.println("service: "+fileNum);
		boardFileVO = boardFileDAO.fileSelect(boardFileVO);
		
		int result = boardFileDAO.fileDelete(boardFileVO);
		
		
		
		
		//1. DB에서 지우기 전에 HDD 파일도 지워주기
		//원래는 DB 지우고 성공하면 HDD 지우는 게 좋음
		String board = "uploadnotice";
		if(boardFileVO.getBoard()==2) {
			board="uploadQna";
		}
		
		String path = servletContext.getRealPath("/resources/"+board);
		
		fileSaver.deleteFile(boardFileVO.getFileName(), path);
		
		
		
		
		return result;
	}
}
