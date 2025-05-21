package com.peisia.clas;
// 주석임
/* 여러줄 주석임 */ 
public class Main {	//접근제한자 public . 클래스임을 표시하는 키워드 class. 클래스이름인 Xxx (첫 대문자 주의. 해당 파일이름도 Xxx.java 로 똑같아야 함 주의)
	
	// 이게 자바의 함수임. 멤버 함수 맞음. 단, 이 main 함수는 특수 함수임.
	// 이 main 함수부터 코드 실행 흐름이 시작됨.
	// 각 키워드들은 일단 무시하시고 그냥 복붙해서 쓰거나 main 이라고 타이핑 하고 ctrl + space 하면 vsc 에밋 기능처럼 코드 자동완성되니 이걸 이용하시오.
	
//	main치고 ctrl + space
	
	public static void main(String[] args) {
		
		Cat cat1 = new Cat();	// 객체 생성. js 랑 거의 똑같쥬?		
		Cat cat2 = new Cat();			
		Cat cat3 = new Cat();	
		
		cat1.info();//객체의 run 함수 실행. 똑...
		
		cat2.name = "키티";
		cat2.age = 10;
		
		cat2.info();

	}
}