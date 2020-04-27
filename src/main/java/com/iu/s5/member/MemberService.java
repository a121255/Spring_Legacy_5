package com.iu.s5.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s5.member.memberFile.MemberFileDAO;
import com.iu.s5.member.memberFile.MemberFileVO;
import com.iu.s5.util.FileSaver;
import com.iu.s5.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberFileDAO memberFileDAO; 
	
	@Autowired
	private FileSaver fileSaver;
	
	public List<MemberVO> memberList(Pager memberPager)throws Exception{
		memberPager.makeRow();
		long totalCount = memberDAO.memberCount(memberPager);
		memberPager.makePage(totalCount);
		return memberDAO.memberList(memberPager);
	}

	public int memberUpdate(MemberVO memberVO)throws Exception{
		return memberDAO.memberUpdate(memberVO);
	}
	
	public int memberDelete(MemberVO memberVO) throws Exception{
		return memberDAO.memberDelete(memberVO);
	}
	
	
	public int memberDeletes(List<String> list) throws Exception{
		return memberDAO.memberDeletes(list);
	} 
	
	
	
	public MemberVO memberLogin(MemberVO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberVO memberVO, MultipartFile avata, HttpSession session)throws Exception{
		//HDD에 저장 (프로젝트 폴더 안에 ﻿resources/memberUpload/
		//1. 파일을 HDD에 저장
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		System.out.println(path);
		String fileName = fileSaver.saveByUtils(avata, path);
		
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(avata.getOriginalFilename());
		
		
		int result = memberDAO.memberJoin(memberVO, avata);
		memberFileDAO.fileInsert(memberFileVO);
		
		return result;
	}
	
	public MemberVO memberIdCheck(MemberVO memberVO) {
		return memberDAO.memberIdCheck(memberVO);
	}
	
	//왜..지운거지?
	/*
	 * public MemberFileVO fileSelect(String id) throws Exception{ return
	 * memberFileDAO.fileSelect(id); }
	 */
	
	
	public int fileDelete(String id, HttpSession session) throws Exception{
		MemberFileVO memberFileVO = memberFileDAO.fileSelect(id);
		int result = memberFileDAO.fileDelete(id);
		if(result>0) {
			String path = session.getServletContext().getRealPath("/resources/memberUpload");
			fileSaver.deleteFile(memberFileVO.getFileName(), path);
		}
		
		return result;
	}

}
