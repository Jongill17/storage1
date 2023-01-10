package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.database.MemberDAO;
import com.smhrd.dto.MemberDTO;

@WebServlet("/Login")
public class ex02Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//1. 한글인코딩 잡기
		request.setCharacterEncoding("UTF-8");
	//2. 요청받은 데이터 꺼내오기(id, pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	//3. 요청받은 데이터를 하나로 묶어주기(MemberDTO 사용)
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);              // <-- getter setter 로 채우기 위해서 dto. set id,pw 가져온다
	//4. DAO 생성하기
		MemberDAO dao = new MemberDAO();
		
	//5. DAO 안에 Login이라는 메소드를 생성(매개변수로 dto 가져가기)  후 실행	
		MemberDTO result = dao.login(dto);
	//6. 로그인 성공했다면 ex02LoginSuccess.jsp로 이동
		if(result != null){
			//6-1. session에 로그인 사용자 정보 저장하기 서블릿이므로 꺼내와야됨 내장x
			HttpSession session = request.getSession();
			session.setAttribute("user", result);
			
			response.sendRedirect("ex02LoginSuccess.jsp");
		}else {
			response.sendRedirect(("ex02LoginFail.jsp"));
		}
	//7. 로그인 실패했다면 ex02LoginFail.jsp로 이동	
	
	}

}
