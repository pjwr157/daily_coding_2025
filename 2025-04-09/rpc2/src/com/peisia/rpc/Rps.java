package com.peisia.rpc;

import java.util.Scanner;

public class Rps {
	void run() 	{
		Scanner sc = new Scanner(System.in);
		int r = 0;
		String cmd = "";
		String result = "";
		
		xx:
		while(true) {
			System.out.println("가위바위보 내! [종료=x] :");
			cmd = sc.next();
			r = (int)(Math.random() * 3 + 1);	//1~3
			switch(cmd) {
			case "가위":
				switch(r) {
				case 1:
					result = "비김";
					break;
				case 2:
					result = "짐";
					break;
				case 3:
					result = "이김";
					break;
				}
				break;
			
			case "바위":
				switch(r) {
				case 1:
					result = "이김";
					break;
				case 2:
					result = "비김";
					break;
				case 3:
					result = "짐";
					break;
				}
				
				break;
			case "보":
				switch(r) {
				case 1:
					result = "짐";
					break;
				case 2:
					result = "이김";
					break;
				case 3:
					result = "비김";
					break;
				}
				
				break;
			case "x":
				// 라벨이라는 기능으로 
				// 위에 xx: 라고 표시(라벨)을 하면 
				// 바로 밑의 while문 (for도 가능함) 에 라벨이 매겨지게 되고
				// break 나 continue 문 사용 시 뒤에 라벨명을 붙이면
				// 자신을 감싼 가장 까가운 반복문 또는 switch 문경우
				// switch 문에서의 break 가 아닌 while 문의 break로 작동하게 됨.
				break xx;
			}
			System.out.println(result);
			//todo 양쪽 뭐 냈는지 표시하면 더 좋공..
		}
		System.out.println("프로그램 종료");
	}
}
