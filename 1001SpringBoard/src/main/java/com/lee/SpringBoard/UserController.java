package com.lee.SpringBoard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value="/user/register", method=RequestMethod.GET)
	
	//단순 page이동은 리턴없이 생성해도 됩니다.
	//뷰 이름이 user/register가됩니다.
	public void register(Model model) {}
}
