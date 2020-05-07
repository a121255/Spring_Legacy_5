package com.iu.s5.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.board.file.BoardFileDAO;
import com.iu.s5.board.file.BoardFileVO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;


@Service
@Transactional
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BoardFileDAO boardFileDAO;

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
	@Transactional
	public int boardWrite(BoardVO boardVO, MultipartFile [] files) throws Exception {
		String path = servletContext.getRealPath("/resources/uploadnotice");
		System.out.println(path);
		
		
		//sequence 번호 받기
		boardVO.setNum(noticeDAO.boardNum());
		
		
		
		int result = noticeDAO.boradWrite(boardVO);
		
		for(MultipartFile file:files) {
			
			if(file.getSize()>0) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(1);
			
			result = boardFileDAO.fileInsert(boardFileVO);
			if(result<1) {
				throw new Exception();
			}
			
			}
			
		}

		
		
		return result;
	}
	
	
	
	
	

	@Override
	@Transactional
	public int boardUpdate(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		
		
		//DB에 넣기 전 파일을 HDD에 저장
		String path = servletContext.getRealPath("/resources/uploadnotice");
		System.out.println(path);
		
	
		
		int result = noticeDAO.boardUpdate(boardVO);
		
		for(MultipartFile file:files) {
			
			if(file.getSize()>0) {
			BoardFileVO boardFileVO = new BoardFileVO();
			String fileName = fileSaver.saveByTransfer(file, path);
			
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(1);
			
			result = boardFileDAO.fileInsert(boardFileVO);
			}
			
		}

		return result;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		
		List<BoardFileVO> list = boardFileDAO.fileList(num);
		//1. HDD에서 해당 파일들을 삭제
		String path = servletContext.getRealPath("/resources/uploadnotice");
		System.out.println(path);
		
		for(BoardFileVO boardFileVO:list) {
			fileSaver.deleteFile(boardFileVO.getFileName(), path);
		}

		//2. DB에 삭제
		boardFileDAO.fileDeleteAll(num);
		
		
		
		
		return noticeDAO.boardDelete(num);
	}

}
