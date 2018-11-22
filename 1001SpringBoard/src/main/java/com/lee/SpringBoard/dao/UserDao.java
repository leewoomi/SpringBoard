package com.lee.SpringBoard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lee.SpringBoard.domain.User;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	// select 구문을 수행하는 메소드는 결과가 0개나 1개인지
	// 아니면 2개 이상도 나올 수 있는지를 확인하고
	// 2개 이상 나올 수 있으면 resultType의 List
	// 0개 나 1개 이면 resultType으로 리턴 타입을 만듭니다.
	// 매개변수가 있으면 매개변수를 만들고 없으면 안 만들면 됩니다.
	// 아이디 중복 체크 메소드

	public String idcheck(String email) {
		// 이름 확인을 잘하고 파라미터 존재 여부를 확인
		return sqlSession.selectOne("user.idcheck", email);
	}

	// 회원가입을 처리할 메소드
	public void register(User user) {
		sqlSession.insert("user.userRegister", user);
	}

//로그인을 처리할 메소드 
	public User login(String email) {
		return sqlSession.selectOne("user.userLogin", email);

	}

	// mypage
	public User mypage(String email) {
		return sqlSession.selectOne("user.userGet", email);
	}

	//회원정보 수정 
	public void userUpdate(User user) {
		sqlSession.update("user.userUpdate", user );
	}

	
	//탈퇴
	public void userDelete(User user) {
	System.out.println("userDao.userDelete :"+ sqlSession.delete("user.userDelete", user));
		 sqlSession.delete("user.userDelete", user);
	
	}
}
