package com.lee.SpringBoard;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.SpringBoard.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardTest {

  	@Inject
	private SqlSession sqlSession;

	@Test
	public void sqlSessionTest()throws Exception{
	
	System.out.println(sqlSession);

		
	}

}

