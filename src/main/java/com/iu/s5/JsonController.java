package com.iu.s5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iu.s5.board.BoardVO;
import com.iu.s5.notice.NoticeService;
import com.iu.s5.util.Pager;

@Controller

@RequestMapping("json")
public class JsonController {

	@Autowired
	private NoticeService noticeService;
	
	
	@GetMapping("json1")
	@ResponseBody
	public List<BoardVO> json1(Pager pager) throws Exception{
		//ModelAndView mv = new ModelAndView();
		
		BoardVO boardVO = noticeService.boardSelect(30);
		//boardVO에 있는 애를 변환해서 json으로 보내고 싶음
		//글번호랑 title만 보내겟음
		//변수명을 key, 값은 거기 들어가 있는 거 쓰면 됨
		//String json = "{";
		//json = json + "\"num\":\""+boardVO.getNum()+"\",";
		//json = json + "\"title\":\""+boardVO.getTitle()+"\"}";

		
		//mv.addObject("result", "{\"name\":\"iu\"}");
		//mv.addObject("result", json);
		//mv.setViewName("common/ajaxResult");
		
		//리턴이 뷰 형태가 아니라서 에러날거임
		//@ResponseBody : 뷰로 보내지 말고 @ResponseBody에 담아 호출한 클라이언트로 때려넣자 >> ajax 요청했을 때만 사용 가능
		//잭슨이 boardVO를 제이슨으로 바꿔서 바디에 담아줄거임

		List<BoardVO> ar = noticeService.boardList(pager);
		
		
		
		return ar;
	}
}
