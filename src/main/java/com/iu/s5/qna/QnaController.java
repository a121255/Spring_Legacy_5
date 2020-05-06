package com.iu.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;
import com.iu.s5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	

	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}
	
	
	@GetMapping("qnaUpdate")
	public ModelAndView boardUpdate(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = qnaService.boardSelect(num);
		mv.addObject("vo", boardVO);
		
		
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	
	
	@PostMapping("qnaUpdate")
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	
	
	
	@GetMapping("qnaList")
//	@RequestMapping(value="qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(Pager pager, ModelAndView mv) throws Exception {
		
		
		List<BoardVO> ar = qnaService.boardList(pager);
		mv.setViewName("board/boardList");
		mv.addObject("list", ar);
		mv.addObject("pager", pager); //머지?
		
		
		
		return mv;
		
	}
	
	
	@GetMapping("qnaWrite")
	public ModelAndView qnaWrite(ModelAndView mv) throws Exception {
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	
	@PostMapping("qnaWrite")
	public ModelAndView boardWrite(QnaVO qnaVO,  MultipartFile [] files, ModelAndView mv) throws Exception{
		int result = qnaService.boardWrite(qnaVO, files);
		String msg = "Qna Write Fail!";
		if(result>0) {
			msg = "Qna Write Success!";
		}
		
		mv.addObject("result", msg);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		return mv;
	}
	
	
	
	
	
	@GetMapping("qnaSelect")
	public ModelAndView boardSelect(long num,ModelAndView mv) throws Exception {
		BoardVO boardVO = qnaService.boardSelect(num);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
		
	}
	
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, long num) throws Exception {
		
		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		
		return mv;
	}
	
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv, QnaVO qnaVO) throws Exception{
		int result = qnaService.boardReply(qnaVO);
		
		
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("result","Reply write fail");
			mv.addObject("path","./qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	
	
	
	
}
