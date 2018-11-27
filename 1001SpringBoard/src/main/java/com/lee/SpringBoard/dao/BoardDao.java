package com.lee.SpringBoard.dao;

import java.util.List;

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
		return sqlSession.insert("board.boardWrite", board);
	}
	
	//게시물 목록 보기를 구현하기 위한 메소드 
	public List<Board> list() {
		return sqlSession.selectList("board.boardList");
	}
	
	//상세보기를 위한 메소드 
	public Board detail(int bno) {
		return 	 sqlSession.selectOne("board.boardDetail",bno);
		
	}
}
