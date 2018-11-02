package com.lee.SpringBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.SpringBoard.domain.Board;
import com.lee.SpringBoard.domain.User;
import com.lee.SpringBoard.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "board/write",method=RequestMethod.GET)
	public String write(HttpSession session) {
		User user =(User)session.getAttribute("user");
		//로그인이 안된 경우 
	
		if(user == null) {
			//user/login으로 리다이렉트
			return "redirect:../user/login";
		}else {
		//servlet-context.xml 파일의 ViewResolver를 확인해서 결과 페이지를 결정 
		return "board/write";
	}
	}
	
	@RequestMapping(value="board/write",method=RequestMethod.POST)
	public String write(HttpServletRequest request,HttpSession session) {
		//로그인 확인 
		User user =(User)session.getAttribute("user");
		if(user == null) {
			return "redirect:../user/login";
		}else {
			int result = boardService.write(request);
			if(result == 1) {
				//성공하면 목록보기 페이지로 이동 
				return "redirect:list";
				
			}else {
				return"redirect:write";
			}
		}
	}
	
	@RequestMapping(value="board/list",method=RequestMethod.GET)
	public String list(Model model) {
		Board board= new Board();
		
		return "board/list";
	}
	
}
