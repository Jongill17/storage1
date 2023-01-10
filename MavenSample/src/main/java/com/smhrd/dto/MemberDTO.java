package com.smhrd.dto;

public class MemberDTO {

	// Data transfer object 회원정보를 저장 할 때 사용할 나만의 자료형
	// 1. field 
		private String name;
		private int age;
		private String id;
		private String pw;
		
	// 2. method
	// ---> 생성자
		public MemberDTO(String name, int age, String id, String pw) {
			super();
			this.name = name;
			this.age = age;
			this.id = id;
			this.pw = pw;
		}		
		
		//id,pw 만 있는 생성자 만들지 말고 ↓↓↓↓↓↓↓ 기본생성자 만들어서 그안에다가 getter setter 로 채우기
		public MemberDTO() {
			// TODO Auto-generated constructor stub
		}

		// ---> getter, setter 메소드 생성
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
	
	
}
