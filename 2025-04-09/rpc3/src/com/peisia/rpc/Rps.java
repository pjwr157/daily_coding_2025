package com.peisia.rpc;

import java.util.Scanner;

public class Rps {
	//함수 = 작은 프로그램
	//입력, 처리, 출력
	
	// 보너스 처리 : 무한루프 걸고 x 입력시 무한루프 빠져나가게까지도 처리한 버전. (참고로만 보세요)
	void run() {
		while(true) {
			int n = procRps();
			if(n == 1) {
				System.out.println("게임끝!!!");
				break;
			} else {
				
			}
		}
	}
	
	int procRps() {
		// 가위바위보 로직을 코딩
		System.out.println("가위바위보 게임");
		
		// 1:가위 2:바위 3:보
		int com = (int)(Math.random() * 3 + 1); //랜덤함수 : 가짓수+1
		
		//입력창 생성
		//자동 임포트 단축키 : ctrl + shift + o (영문자 오)
		System.out.println("가위 바위 보중 하나를 입력 하세요[게임종료:x]");
		Scanner sc = new Scanner(System.in);
		String cmd = sc.next();
		
		String r = "";
		
		switch(cmd) {
		case "가위":
			System.out.println("내가 가위를 냈음");
			switch(com) {
			case 1:
				System.out.println("컴퓨터가 가위를 냈음");
				r = "비겼다";
				break;
			case 2:
				System.out.println("컴퓨터가 바위를 냈음");
				r = "졌다";
				break;
			case 3:
				System.out.println("컴퓨터가 보를 냈음");
				r = "이겼다";
				break;
			}
			break;
			
		case "바위":
			System.out.println("내가 바위를 냈음");
			switch(com) {
			case 1:
				System.out.println("컴퓨터가 가위를 냈음");
				r = "이겼다";
				break;
			case 2:
				System.out.println("컴퓨터가 바위를 냈음");
				r = "비겼다";
				break;
			case 3:
				System.out.println("컴퓨터가 보를 냈음");
				r = "졌다";
				break;
			}
			break;
			
		case "보":
			System.out.println("내가 보를 냈음");
			switch(com) {
			case 1:
				System.out.println("컴퓨터가 가위를 냈음");
				r = "졌다";
				break;
			case 2:
				System.out.println("컴퓨터가 바위를 냈음");
				r = "이겼다";
				break;
			case 3:
				System.out.println("컴퓨터가 보를 냈음");
				r = "비겼다";
				break;
			}
			break;
		case "x":
			return 1;
		default:
			System.out.println("도전자가 엉뚱한거 냈음");
			break;
		}
		System.out.println("결과:"+r);
		return 2;
	}
}
