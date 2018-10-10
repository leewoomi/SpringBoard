package com.lee.SpringBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.SpringBoard.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public String idcheck(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
