package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.database.MemberDAO;
import com.smhrd.dto.MemberDTO;

@WebServlet("/Insert")
public class ex01Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//0.한글인코딩 잡아주기
		request.setCharacterEncoding("UTF-8");
	//1. 요청받은 데이터 꺼내오기
		String name =request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
	//1-1. 꺼내온 데이터를  DTO로 하나로 묶어주기
		MemberDTO dto = new MemberDTO(name, age, id, pw);
		
	//2. 진짜로 DAO 사용하기(데이터베이스에 값 집어넣기)
		MemberDAO dao = new MemberDAO();
		int row = dao.join(dto);
	//3. 성공했다면 페이지 이동
		if(row>0) {
			response.sendRedirect("ex02Login.jsp");
		}else {
			//4. 실패했다면 다시 ex01Insert.jsp 페이지 이동
			response.sendRedirect("ex01Insert.jsp");
		}
	
	
	}

}
