package com.peisia.memory;

import java.util.ArrayList;

public class Main_Arranged {

	public static void main(String[] args) {
		//자동임포트 ctrl+shift+o(영문자O)
//		ArrayList<Product> xx = new ArrayList<Product>();
//		
//		Product p1 = new Product();
//		
//		xx.add(p1);
		
		//자바
		
		//메모리. 기억. 저장. 
		
		//1.스택동네
		int n = 100;	//기본형.원시형.p65.소문자로 시작하는 자료형들.
//		Cat kitty;	//명함
		
		//2.힙한동네
//		new Cat();		//객체들. 5장의 참조 자료형들. etc. 위 원시형 외 전부
		
		Cat kitty = new Cat();	//100번지
		kitty.name = "야옹이";
//		System.out.println(kitty.name);
		
		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(kitty);
		cats.add(kitty);
		cats.add(kitty);
		
		for(int i=0;i<cats.size();i=i+1) {
			System.out.println(cats.get(i).name);
		}
		
		//종합박스. 박스-박스-박스-박스-
		//박스 : <Cat>들 명함집
		
		
		
		

	}

}
