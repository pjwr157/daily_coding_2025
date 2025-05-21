package com.peisia.c.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;	
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {					// (38番問題)
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	Scanner sc=new Scanner(System.in);
	
	void run() {
		Display.showTitle();
		Display.showMainMenu();
		dbInit();
		
		loop:
		while(true) {
			System.out.println("명령입력: ");
			String cmd=sc.next();
			switch(cmd) {
			case "1":	//글리스트
				break;
			case "2":	//글읽기
				break;
			case "3":	//글쓰기
				System.out.println("제목을 입력해주세요:");
				String title = sc.next();
				System.out.println("글내용을 입력해주세요:");
				String content = sc.next();
				System.out.println("작성자id를 입력해주세요:");
				String id = sc.next();
				String sql;
				sql = String.format("insert into board (b_title,b_id,b_datetime,b_text,b_hit)"
						+" values ('%s','%s',now(),'%s',0)"
						,title, id, content);
				System.out.println("sql로그:"+sql);
				dbExecuteUpdate(sql);						
				break;
			case "4":	//글삭제
				break;
			case "0":	//관리자
				break;
			case "e":	//프로그램 종료
				System.out.println("프로그램종료");
				break loop;
			}
		}
	}
	
	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BoardTest", "root", "root");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수:"+resultCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}