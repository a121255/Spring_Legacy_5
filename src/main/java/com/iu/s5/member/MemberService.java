package com.iu.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.member.memberPage.MemberPager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberVO> memberList(MemberPager paper) throws Exception {
		return memberDAO.memberList(paper);
	}
	
	
	
	public int memberWrite(MemberVO memberVO) {
		return memberDAO.memberWrite(memberVO);
	}
}
