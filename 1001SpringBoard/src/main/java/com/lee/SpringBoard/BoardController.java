package com.lee.SpringBoard;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lee.SpringBoard.domain.Board;
import com.lee.SpringBoard.domain.User;
import com.lee.SpringBoard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "board/write", method = RequestMethod.GET)
	public String write(HttpSession session) {
		User user = (User) session.getAttribute("user");
		// 로그인이 안된 경우

		if (user == null) {
			// user/login으로 리다이렉트
			return "redirect:../user/login";
		} else {
			// servlet-context.xml 파일의 ViewResolver를 확인해서 결과 페이지를 결정
			return "board/write";
		}
	}

	@RequestMapping(value = "board/write", method = RequestMethod.POST)
	public String write(HttpServletRequest request, HttpSession session) {
		// 로그인 확인
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:../user/login";
		} else {
			int result = boardService.write(request);
			if (result == 1) {
				// 성공하면 목록보기 페이지로 이동
				return "redirect:list";

			} else {
				return "redirect:write";
			}
		}
	}

	// 목록보기 요청을 처리하기 위한 메소드
	@RequestMapping(value = "board/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		List<Board> list = boardService.list(request);
		model.addAttribute("list", list);

		return "board/list";
	}

	// 글 읽기
	@RequestMapping(value = "board/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("bno") int bno, Model model) {

		Board board = boardService.detail(bno);
System.out.println("boardDetailController:"+ board);
System.out.println("bno:"+bno);
		return "board/detail";
	}
}
