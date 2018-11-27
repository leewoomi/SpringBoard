package com.lee.SpringBoard.service;


import java.util.Date;
import java.util.List;

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
		// 입력받은 파라미터 읽기
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// ip구하기
		String ip = request.getRemoteAddr();

		// 세션에 있는 email 가져오기
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String email = user.getEmail();

		// Dao 파라미터 만들기
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setIp(ip);
		board.setEmail(email);
		// Dao 메소드 호출
		return boardDao.write(board);

	}

	@Override
	public List<Board> list(HttpServletRequest request) {
		// DAO 메소드가 파라미터가 없기 때문에 바로 결과르 가져오기
		List<Board> list = boardDao.list();

		// 글 작성한 날짜와 오늘 날짜가 같으면 시간을 출력하고
		// 같지 않으면 날짜를 출력

		// 년 월 일 찾아오기
		Date today = new Date();
		System.out.println(today.toString());
		String year = today.toString().substring(24);
		String month = today.toString().substring(4, 7);
		String day = today.toString().substring(8, 10);
		for (Board board : list) {
			// 작성한 글의 년 월 일 찾아오기
			String myYear = board.getRegdate().toString().substring(24);
			String myMonth = board.getRegdate().toString().substring(4, 7);
			String myDay = board.getRegdate().toString().substring(8, 10);
			if (year.equals(myYear) && month.equals(myMonth) && day.equals(myDay)) {
				board.setDispdate(board.getRegdate().toString().substring(11, 16));
			} else {
				board.setDispdate(myYear + "/" + myMonth + "/" + myDay);
			}
		}

		return list;
	}

	@Override
	public Board detail(int bno) {

		Board board = boardDao.detail(bno);
	System.out.println("boardDetail:"+ board);

		return board;
	}

}
