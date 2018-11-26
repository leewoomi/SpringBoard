package com.lee.SpringBoard.service;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lee.SpringBoard.domain.User;

public interface UserService {
	
	//아이디 중복 체크 메소드 
	public String idcheck(String email);
	
	//파일 업로드가 있을 때는 MultipartHttpServletRequest를 매개변수로 만든다.
	public void register(MultipartHttpServletRequest request);
	


	//로그인 체크 메소드 
	public User login(HttpServletRequest request);

	//마이페이지 
	public User mypage(MultipartHttpServletRequest request);

	//회원정보 수정 
	public void userUpdate(MultipartHttpServletRequest request);
 
	//탈퇴 
	public int userDelete(HttpServletRequest request);


}
