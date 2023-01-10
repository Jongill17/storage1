<%@page import="com.smhrd.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. session 안에 저장되어있는 데이터 꺼내오기
		MemberDTO dto =(MemberDTO)session.getAttribute("user");      // 강제형변환
		// 2. 이름만 가져오기
		String name = dto.getName();	
	%>
	
	<h1>로그인 성공!</h1>
	<h4><%=name%>  님 환영합니다!</h4>
	<button> main으로 돌아가기</button>

</body>
</html>