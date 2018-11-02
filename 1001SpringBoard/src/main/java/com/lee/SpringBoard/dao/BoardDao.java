package com.lee.SpringBoard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lee.SpringBoard.domain.Board;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//게시글 저장을 위한 메소드
	public int write(Board board) {
		return sqlSession.insert("board.write", board);
	}
}
