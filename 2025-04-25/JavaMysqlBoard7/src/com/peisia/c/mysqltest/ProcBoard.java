package com.peisia.c.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {					// (40番問題)
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
			case "2":	//글읽기!
				System.out.println("읽을 글 번호를 입력해주세요:");
				String readNo = sc.next();
				String sql2 = "select * from board where b_no ="+readNo;
				System.out.println("sql로그:"+sql2);
				try {
					result = st.executeQuery(sql2);
					result.next();	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
					String title = result.getString("b_title");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					String content = result.getString("b_text");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					System.out.println("글제목: "+title);
					System.out.println("글내용: "+content);
				} catch (Exception e) {
					e.printStackTrace();
				}				
				break;
			case "3":	//글쓰기
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
				dbExecuteUpdate(x);
				System.out.println(x);
				break;
			case "4":	//글삭제
				System.out.println("삭제할 글번호를 입력해주세요:");
				String delNo = sc.next();
				
				String sql = "delete from board where b_no="+delNo;
				System.out.println(sql);
				
				dbExecuteUpdate(sql);
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
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수:"+resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
