package com.iu.s5.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardDAO;
import com.iu.s5.board.BoardVO;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s5.notice.NoticeDAO.";


	@Override
	public List<BoardVO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO boardSelect() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	@Override
	//public int boradWrite(NoticeVO noticeVO) throws Exception { 
	//부모의 형태와 같아야 하기 때문에 오류가 난다. 부모를 수정하자
	//부모에 notice만 쓰면 notice만 쓸 수 있다. notice, qna 모두 쓸 수 있는  BoardVO를 쓴다
	public int boradWrite(BoardVO boardVO) throws Exception {
		

		//int result = sqlSession.insert(NAMESPACE+"boardWrite");
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
	
		
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}

	
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"boardUpdate", boardVO);
	}


	


	//noticeList
	//약속은 boardList로 하기로 함 >> implement 해준다
	
	
	
}
