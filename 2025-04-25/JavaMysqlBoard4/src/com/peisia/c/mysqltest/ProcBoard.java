package com.peisia.c.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {					// (37番問題)
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	void run() {
		Display.showTitle();
		Display.showMainMenu();
		dbInit();
		Scanner sc=new Scanner(System.in);
		System.out.println("제목을 입력해주세요:");
		String title = sc.next();
		System.out.println("글내용을 입력해주세요:");
		String content = sc.next();
		System.out.println("작성자id를 입력해주세요:");
		String id = sc.next();
		
		String x = String.format(
				"insert into board (b_title,b_id,b_datetime,b_text,b_hit) "
				+ "values ('%s','%s',now(),'%s',0);"
				,title,id,content) ;
		System.out.println("sql로그:"+x);
		dbExecuteUpdate(x);			
		
		System.out.println("글등록 완료");			//여기 주의!!!
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

