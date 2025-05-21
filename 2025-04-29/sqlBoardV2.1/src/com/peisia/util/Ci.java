package com.peisia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 입력을 담당하는 클래스. (Scanner 등)
 */
public class Ci {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	BufferedReader: 한 줄(line) 전체 입력을 받을 수 있는 도구
//	InputStreamReader(System.in): 키보드 입력을 바이트에서 문자로 변환해서 읽는 다리 역할
	static public String r() {
		return sc.next();
	}
	static public String r(String comment) {
		Cw.w(comment+":");
		return sc.next();
	}
	static public String rl(String comment) {
		Cw.w(comment+":");
		try {
			return reader.readLine();		//한 줄을 통째로 입력받는다
		} catch (IOException e) {			//입출력 에러가 생기면 잡는다
			e.printStackTrace();			//에러 내용을 자세히 출력해준다.
			return null;
		}
	}
}
