package com.example.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatisUtil {
	// singleton
	private myBatisUtil() {
		init();
	}

	private static myBatisUtil instance = new myBatisUtil();

	public static myBatisUtil getInstance() {
		return instance;
	}

	// 2. init ==> config.xml파일 로딩 -> factory 생성
	private SqlSessionFactory factory;

	private void init() {
		// 환경 설정 xml 파일의 위치
		String res = "config/mybatis-config.xml";
		try {
			// res를 읽어들일 inputstream 획득
			InputStream inputStream = Resources.getResourceAsStream(res);
			// FactioyBuilder을 통해 Factory 생성
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 3. factory를 통해서 sqlSession 제공
	public SqlSession getSession() {
		return factory.openSession();
	}
}
