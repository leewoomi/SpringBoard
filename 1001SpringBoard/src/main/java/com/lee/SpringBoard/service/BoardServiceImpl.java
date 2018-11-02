package com.lee.SpringBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.SpringBoard.dao.BoardDao;

import com.lee.SpringBoard.domain.Board;
import com.lee.SpringBoard.domain.User;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int write(HttpServletRequest request) {
		//입력받은 파라미터 읽기 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		//ip구하기 
		String ip = request.getRemoteAddr();
		
		//세션에 있는 email 가져오기 
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		String email = user.getEmail();
		
		
		//Dao 파라미터 만들기
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setIp(ip);
		board.setEmail(email);
		//Dao 메소드 호출
		return boardDao.write(board);

	}

}
