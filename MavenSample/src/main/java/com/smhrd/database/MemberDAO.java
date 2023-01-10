package com.smhrd.database;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.dto.MemberDTO;

public class MemberDAO {

	// 1. 쿼리문을 전송할 수 있게끔 도와주는 도구를 가져오기
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// 2. 회원가입을 할 수 있는 insert 메소드 생성
	public int join(MemberDTO dto) {

		// 1) sqlSession 열어주기
		SqlSession sqlSession = sqlSessionFactory.openSession(true); //-> 자동커밋
		
		// 2) sql구문 실행하기
		int row = sqlSession.insert("com.smhrd.database.MemberDAO.join", dto);
		
		// 3) sqlSession 자원반납
		sqlSession.close();
		
		return row;
		
		
	}

	public MemberDTO login(MemberDTO dto) {
		// 1) sqlSession 열어주기(auto commit 가능하게)
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// 2) sqlSession 활용해서 select 구문 실행 실행하기
		// sqlSession.selectOne("mapper의 식별자.쿼리문의id , xml로 넘길 매개변수)
		MemberDTO resultDto = sqlSession.selectOne("com.smhrd.database.MemberDAO.login", dto);
		// ↑↑↑ 원하는 대로 들어갈 수 있다(제너릭기법<object>)
		// 3) 자원 반납
		sqlSession.close();
		return resultDto;
	}
	
	
	
}
