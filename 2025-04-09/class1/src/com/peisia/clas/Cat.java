package com.peisia.clas;

public class Cat {
	int age;
	String name;
	String hobby;
	
	void x() {
		
	}
	int y() {
		return 100;
	}
	int add(int a, int b) {
		int sum = a + b;
		return sum;
	}
	
	//js
	//생성자 함수 오버로딩
	public Cat() {
		
	}
	public Cat(int age, String name, String hobby) {
		this.age = age;
		this.name = name;
		this.hobby = hobby;
	}
	public Cat(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
}
