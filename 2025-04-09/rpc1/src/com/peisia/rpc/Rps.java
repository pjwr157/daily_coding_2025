package com.peisia.rpc;

import java.util.Scanner;

public class Rps {

	void run() {
		// 가위바위보 로직을 코딩...
		System.out.println("==가위바위보==");
		
		//1 가위 2 바위 3 보
		int com = (int)(Math.random() * 3 + 1);
		
//		int player = 1;
		//입력
		//자동 임포트 단축키 : ctrl + shift + o (영문자 오)
		System.out.println("가위 바위 보 중 하나를 입력하세요:");
		Scanner sc = new Scanner(System.in);
		String cmd = sc.next();
		
		String r = ""; 
		
		switch(cmd) {
		case "가위":
			System.out.println("가위를 냈음");
			switch(com) {
			case 1:
				r = "비김";
				break;
			case 2:
				r = "짐";
				break;
			case 3:
				r = "이김";
				break;
			}
			
			break;
		case "바위":
			System.out.println("바위를 냈음");
			switch(com) {
			case 1:
				r = "이김";
				break;
			case 2:
				r = "비김";
				break;
			case 3:
				r = "짐";
				break;
			}
			break;
		case "보":
			System.out.println("보를 냈음");
			switch(com) {
			case 1:
				r = "짐";
				break;
			case 2:
				r = "이김";
				break;
			case 3:
				r = "짐";
				break;
			}
			break;
		default:
			System.out.println("엉뚱한거 냈음");
			break;
		}
		System.out.println("결과:"+r);
	}
}