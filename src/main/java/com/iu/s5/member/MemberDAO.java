package com.iu.s5.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.member.memberPage.MemberPager;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s5.member.MemberDAO.";
	
	public List<MemberVO> memberList(MemberPager paper) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList", paper);
	}
	
	
	
	public int memberWrite(MemberVO memberVO) {
		System.out.println(memberVO.getId());
		return sqlSession.insert(NAMESPACE+"memberWrite", memberVO);
	}

}
