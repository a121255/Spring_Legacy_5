package com.iu.s5.board.file;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private String NAMESPACE = "com.iu.s5.board.file.BoardFileDAO.";
	
	public int fileInsert(BoardFileVO boardFileVO) {
		return sqlSession.insert(NAMESPACE+"fileInsert", boardFileVO);
	}
	
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect", boardFileVO);
	}
	
	public int fileDelete(Long fileNum) throws Exception{
		System.out.println("dao: "+fileNum);
		return sqlSession.delete(NAMESPACE+"fileDelete",fileNum);
	}
}
