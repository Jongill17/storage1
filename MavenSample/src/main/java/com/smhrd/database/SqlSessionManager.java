package com.smhrd.database;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	
	public static SqlSessionFactory sqlSessionFactory ;   
	                //↑↑  try  안의 지역변수를 필드로 올려버림
	
	// 객채를 생성하는 순간 실행되는 부분  // 생성자와 유사한 영역    
	//	여러개의 객체를 만들어도 고정된 값을 주는게  static 따라서 바뀌면 안되는 값(주로 상수)을 넣는다
	// -----> 하나의 설계도면으로 여러개의 객체를 만들더라도
	//        각각의 객체는 모두 동일한 값을 공유한다.
	
	static {
		//1. 어떤 설정 파일을 읽을 건지 경로를 문자열로 지정    . 말고 / 로 작성
		String resource ="com/smhrd/database/mybatis-config.xml";
		//2. 설정 파일을 읽어서 실제로 데이터 베이스 연결하기  (빨간줄 해결하기)_
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// sqlsessionfactory를 사용해서 db연결, 종료, 실행 관리 해주는 sqlsession 이라는 메소드를 생성
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
	
	
	
	
}
