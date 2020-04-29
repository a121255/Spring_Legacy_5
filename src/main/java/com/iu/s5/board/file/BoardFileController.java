package com.iu.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boardFile/**")
public class BoardFileController {
	
	@Autowired
	private BoardFileService boardFileService;
	
	
	@PostMapping("summerDelete")
	public ModelAndView fileDelete(String fileName) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = boardFileService.fileDelete(fileName);
		
		//result >> success
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	
	
	
	
	@PostMapping("fileInsert")
	public ModelAndView fileInsert(MultipartFile files, ModelAndView mv) throws Exception{
		System.out.println(files.getOriginalFilename());
		//HDD에 저장, DB에는 저장 안 함
		String fileName = boardFileService.fileInsert(files);
		//ajax의 imageName으로 보내주어야함 >>> java를 html로 바꾸는 과정 필요
		System.out.println();
		
		mv.addObject("result",fileName);
		mv.setViewName("common/ajaxResult");
		
		return mv;
		
	}
	
	

	
	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(BoardFileVO boardFileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
	
		int result = boardFileService.fileDelete(boardFileVO);
		
		System.out.println("result:" + result);
		
		mv.addObject("result",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	
	
	
	@GetMapping("fileDown")
	public ModelAndView fileDownload(BoardFileVO boardFileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardFileVO = boardFileService.fileSelect(boardFileVO);
		mv.addObject("file",boardFileVO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	
	
	
	
}
