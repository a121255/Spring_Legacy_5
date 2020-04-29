package com.iu.s5.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.board.BoardService;
import com.iu.s5.board.BoardVO;
import com.iu.s5.board.file.BoardFileDAO;
import com.iu.s5.board.file.BoardFileVO;
import com.iu.s5.member.memberFile.MemberFileDAO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private ServletContext servletContext;
	
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	
	@Autowired
	private MemberFileDAO memberFileDAO; 
	
	
	public int boardReply(BoardVO boardVO) throws Exception {
		int result = qnaDAO.boardReplyUpdate(boardVO);
		result = qnaDAO.boardReply(boardVO);
		return result;
	}
	

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow(); //10개 가지고 오기
		pager.makePage(qnaDAO.boardCount(pager));  //페이징처리
		
		return qnaDAO.boardList(pager);  //스택?
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] files) throws Exception {
		//1. sequence num qna table insert
		//qna 글번호를 fileNum에다 넣고 싶음
		//시퀀스라 가지고 올 방법 없기 때무넹 시퀀스를 먼저 해줌
		int result = qnaDAO.boradWrite(boardVO);
		
		
		//3. HDD에 파일 저장하고 boardFile table insert
		String path = servletContext.getRealPath("/resources/uploadQna");
		
		System.out.println(path);
	
	
		//파일이 여러 개니 반복문을 돌린다
		
		
		for(MultipartFile file:files) {
			
			
			if(file.getSize()>0) {
			BoardFileVO boardFileVO = new BoardFileVO();
			
			String fileName = fileSaver.saveByTransfer(file, path);
			
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(2);
			
			
			boardFileDAO.fileInsert(boardFileVO);
			}
		}
		
		
		
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
