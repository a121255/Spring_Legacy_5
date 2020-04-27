package com.iu.s5.member;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s5.util.Pager;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberIdCheck")
	public ModelAndView memberIdCheck(MemberVO memberVO, ModelAndView mv) {
	
		memberVO = memberService.memberIdCheck(memberVO);
		//null --> 가입가능
		//null 아니면 중복
		
		int result=0;
		if(memberVO==null) {
			result=1;
		}
		
		
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	
	
	
	
	
	@RequestMapping(value="memberList", method = RequestMethod.GET)
	public ModelAndView memberList(Pager memberPager, ModelAndView mv)throws Exception{
		List<MemberVO> ar = memberService.memberList(memberPager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", memberPager);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	
	
	@GetMapping("memberLists")
	public ModelAndView memberLists(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<MemberVO> ar = memberService.memberList(pager);
		
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("member/memberLists");
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}

	@RequestMapping(value= "memberJoin")
	public void memberJoin() {
		
	}
	
	@RequestMapping(value= "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile avata, ModelAndView mv, HttpSession session) throws Exception {
		
		
		System.out.println("파일업로드 시 실제 이름 : " + avata.getOriginalFilename());
		System.out.println("파라미터 이름 : " + avata.getName() );
		System.out.println("파일의 크기 : " + avata.getSize());
		System.out.println("파일 형식 : " + avata.getContentType());
		avata.getInputStream();
		
		
		int result = memberService.memberJoin(memberVO, avata, session);
		String msg ="Member Join Fail";
		if(result>0) {
			msg = "Member Join Success";
		}
		
		mv.addObject("result", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@RequestMapping(value= "memberLogin")
	public void memberLogin(@CookieValue(value="cId", required = false) String cId, Model model) { //required = false 꼭 없어두 댄다
		System.out.println("cId : " +cId);
//		model.addAttribute("cId", cId);
	}
	
	@RequestMapping(value= "memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, String remember, HttpServletResponse response, MemberVO memberVO, HttpSession session) throws Exception {
		
		System.out.println(remember + "rmb");  //null이냐 아니냐로 체크 했는지를 판단
		
		
		Cookie cookie = new Cookie("cId", ""); 
		
		
		// if(remember.equals("remember")) {
		 if(remember != null) {
			 //기억하게따
//			 cookie = new Cookie("cid",memberVO.getId());
			 cookie.setValue(memberVO.getId());  //new를 안 해도 됨
		 }
		 
		
		 response.addCookie(cookie);
	
		 
		 
		 
		 
		
		 memberVO = memberService.memberLogin(memberVO);
		
		 if(memberVO != null) {
			 session.setAttribute("member", memberVO);
			 mv.setViewName("redirect:../");
		 }else {
			 mv.addObject("result", "Login Fail");
			 mv.addObject("path", "./memberJoin");
			 mv.setViewName("common/result");
		 }
		 
		//로그인 성공이면 index
		//로그인 실패 하면 로그인 실패 alert login form 이동		 
				 
				 
		return mv;
	}
	
	@RequestMapping(value= "memberPage")
	public void memberPage(/*HttpSession session, Model model*/) throws Exception {
		/*
		 * MemberVO memberVO = (MemberVO) session.getAttribute("member"); MemberFileVO
		 * memberFileVO = memberService.fileSelect(memberVO.getId());
		 * model.addAttribute("file",memberFileVO);
		 */
		//이미 session으로 보냈기 때문에 지워주어도 된다...왜지운거지?
	}
	
	
	
	@RequestMapping(value ="fileDelete")
	public String fileDelete(HttpSession session) throws Exception{
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		memberService.fileDelete(memberVO.getId(), session);
		//DB에도 남고 서버에도 남으니 둘 다 지워줘야 한다
		return "redirect:./memberPage";
	}
	
	
	
	
	
	

	
	@RequestMapping(value= "memberUpdate")
	public void memberUpdate() {
		
	}
	
	@RequestMapping(value= "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		String id = ((MemberVO)session.getAttribute("member")).getId();
		memberVO.setId(id);
		
		int result = memberService.memberUpdate(memberVO);
		
		if(result>0) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:./memberPage");
		}else {
			 mv.addObject("result", "Update Fail");
			 mv.addObject("path", "./memberPage");
			 mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@RequestMapping(value= "memberDelete")
	public ModelAndView memberDelete(ModelAndView mv, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = memberService.memberDelete(memberVO);
		if(result>0) {
			session.invalidate();
			mv.addObject("result", "Delete Success");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}else {
			mv.addObject("result", "Delete Fail");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	
	
	@RequestMapping(value="memberDeletes")
	public ModelAndView memberDeletes(String[] ids) throws Exception{
	
		/*
		 * for(String id : ids) { System.out.println(id); MemberVO memberVO = new
		 * MemberVO(); memberVO.setId(id); memberService.memberDelete(memberVO); }
		 */
		
		ModelAndView mv = new ModelAndView();
		
		List<String> list = Arrays.asList(ids);
		int result = memberService.memberDeletes(list);
		
		mv.addObject("result",result);
		mv.setViewName("/common/ajaxResult");
		System.out.println(result);
		
		return mv;
		
		
	}
	
	
	
	
	
	
	
	
}
