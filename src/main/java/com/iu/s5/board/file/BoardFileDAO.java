package com.iu.s5.board.file;

import java.util.List;

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
	
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
		//System.out.println("dao: "+fileNum);
		return sqlSession.delete(NAMESPACE+"fileDelete",boardFileVO);
	}
	
	
	public int fileDeleteAll(Long num) throws Exception{
		System.out.println("dao: "+num);
		return sqlSession.delete(NAMESPACE+"fileDeleteAll",num);
	}
	
	
	
	
	public List<BoardFileVO> fileList(Long num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList", num);
	}
	
	
	
	
	
	
	
}
