package com.iu.s5.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.util.FileSaver;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Autowired
	private ServletContext servletContext;  
	
	@Autowired
	private FileSaver fileSaver;
	
	
	
	public int fileDelete(String fileName) throws Exception{
		String path = servletContext.getRealPath("/resources/summer");
		return fileSaver.deleteFile(fileName, path);
	}
	
	
	
	
	
	
	public String fileInsert(MultipartFile files) throws Exception{
		//어느 경로에 어떤 이름으로 저장?
		String path = servletContext.getRealPath("/resources/summer"); //경로
		System.out.println(path);
		path = fileSaver.saveByTransfer(files, path);
		path = servletContext.getContextPath()+"/resources/summer/"+path;
		//DB 연결 안 하니 굳이 DAO 갈 필요 없다
		
		return path;
	}
	
	
	
	
	
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
