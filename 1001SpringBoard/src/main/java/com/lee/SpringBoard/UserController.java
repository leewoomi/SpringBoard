package com.lee.SpringBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lee.SpringBoard.domain.User;
import com.lee.SpringBoard.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)

	// 단순 page이동은 리턴없이 생성해도 됩니다.
	// 뷰 이름이 user/register가됩니다.
	public void register(Model model) {
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String register(MultipartHttpServletRequest request) {
		userService.register(request);
		// 회원가입을 처리하고 메인으로 리다이렉트
		// 데이터베이스에 변화를 주면 반드시 리다이렉트
		return "redirect:/";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	// 단순 page이동은 리턴없이 생성해도 됨.
	// 뷰 이름이 /user/login 이 됩니다.
	public void login(Model model) {
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)

	public String login(HttpServletRequest request, HttpSession session, RedirectAttributes attr) {
		User user = userService.login(request);
		if (user == null) {
			// 로그인 실패하면 null
			session.setAttribute("user", null);
			// RedirectAttributes는 리다이렉트 될 때 한 번만 데이터를 전달
			attr.addFlashAttribute("msg", "없는 이메일이거나 잘못된 비밀번호 입니다.");
			return "redirect:login";
		} else {
			// 로그인 성공하면 user에 로그인 정보를 저장
			session.setAttribute("user", user);
			return "redirect:../";
		}

	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	// 단순 page이동은 리턴없이 생성해도 됨.
	// 뷰 이름이 /user/login 이 됩니다.
	public String logout(HttpSession session) {

		// 세션을 초기
		session.invalidate();
		return "redirect:../";
	}
	
	
	
	@RequestMapping(value = "/user/mypage", method = RequestMethod.GET)
	public void mypage(Model model) {
	}

	@RequestMapping(value = "/user/mypage", method = RequestMethod.POST)
	public String mypage(@RequestParam("email") String email) {
		User user = userService.mypage(email);

	
		return "/user/mypage";
	}

}
