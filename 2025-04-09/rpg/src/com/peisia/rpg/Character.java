package com.peisia.rpg;
public class Character {
	//변수모음을 자바에서는 멤버 변수. 필드. 라고 부름
	String name;
	int hp;
	int attack;
	String race;
	
	//생성자 함수라고 함. 객체가 태어날 때 이 함수가 실행 됨.
	Character(String name, int hp, int attack, String race){
//		String x = "엠피스"
//		int y = 10;
//		int z = 20;
		
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.race = race;
		System.out.println(this.name+"이(가) 태어남");
	}
	
	//함수모음을 자바에서는 멤버 함수 라고 부름
	//선언법
	
	//void 뜻은 return 이 없는 함수라는 뜻.
	//리턴 없는 일반 함수 선언하려면 void 키워드를 붙여야 함.
	String info() {
		System.out.println("이름:"+this.name+"["+this.hp+"]"
				+" 공격력:"+this.attack);
		return "고양이";
	}
}