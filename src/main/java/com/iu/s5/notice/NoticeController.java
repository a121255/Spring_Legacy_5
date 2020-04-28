package com.iu.s5.notice;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.board.BoardVO;
import com.iu.s5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "notice";
	}
	
	
	@RequestMapping(value="noticeSelect", method = RequestMethod.GET)
	public ModelAndView boardSelect(long num, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		
		BoardVO boardVO = noticeService.boardSelect(num);
		session.setAttribute("vo", boardVO);

		
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="noticeList", method = RequestMethod.GET)
	public ModelAndView boardList(Pager pager, ModelAndView mv) throws Exception{ //Pager pager 같은 주소값

		System.out.println("kind : " + pager.getKind());
		System.out.println("search : " + pager.getSearch());
		
		
		
		
		
		
		//getCurPage 아무것도 안 넣으면 첫번째 페이지가 나오게끔
		
		
		List<BoardVO> ar = noticeService.boardList(pager);
		

		System.out.println(pager.getTotalPage());
		
		
		mv.addObject("list", ar);
		//mv.addObject("board","notice"); 이 기능을 만들어준 게 있음! 위에 쓰겟다
		mv.addObject("pager",pager);
		
		
		
		mv.setViewName("board/boardList");
		return mv;
		
	}
	

	
	
	
	
	@RequestMapping(value="noticeWrite", method = RequestMethod.GET)
	public String boardWrite() throws Exception{
		
		return "board/boardWrite";
	}
	
	
	
	
	@RequestMapping(value="noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(HttpServletRequest request, NoticeVO noticeVO, MultipartFile [] files, ModelAndView mv) throws Exception{
		Enumeration<String> er = request.getParameterNames();
		
		while(er.hasMoreElements()) {
			System.out.println(er.nextElement());
		}
		
		
		for(MultipartFile file:files) {
			System.out.println(file.getOriginalFilename());
		}
		int result = noticeService.boardWrite(noticeVO, files);
		
		//글쓰기 성공 그냥 go, 실패 했을 땐 실패했단 messege 띄우고 List로 돌아감

		if(result>0) {
			mv.setViewName("redirect:noticeList");
		
		}else {
			mv.addObject("path", "./noticeList");
			mv.addObject("result", "글쓰기를 실패했습니다.");
			mv.setViewName("common/result");
		}
		
		
		return mv;
		
	}
	
	
	@RequestMapping(value="noticeUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num, Model model) throws Exception{
		BoardVO boardVO = noticeService.boardSelect(num);
		model.addAttribute("vo", boardVO);
		
		
		 NoticeVO noticeVO = (NoticeVO)boardVO;
		 model.addAttribute("size", noticeVO.getBoardFileVOs().size());


		return "board/boardUpdate";
	}
	
	
	
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST)
	public String boardUpdate(HttpServletRequest request, NoticeVO noticeVO, MultipartFile [] files) throws Exception{


		int result = noticeService.boardUpdate(noticeVO, files);
		String path ="";

		if(result>0) {
			path = "redirect:./noticeList";
		}else {
			path = "redirect:./noticeSelect?num="+noticeVO.getNum();  //파라미터로 num을 줘야 함. 안 주면 exception.
		}
	
		
		for(MultipartFile file:files) {
			System.out.println(file.getOriginalFilename());
		}
	
		
		
		
		
		
		
		return path;
	}
	
	
	@RequestMapping(value="noticeDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception {
		
		int result = noticeService.boardDelete(num);
		
		if(result>0) {
			mv.addObject("result", "삭제 성공");
		}else {
			mv.addObject("result", "삭제 실패");
		}
		
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
}
