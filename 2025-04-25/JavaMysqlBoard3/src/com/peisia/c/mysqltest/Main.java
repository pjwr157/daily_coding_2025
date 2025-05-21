package com.peisia.c.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		//(36番問題)
		Display.showTitle();
		Connection con = null;
		Statement st = null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("글제목을 입력해주세요:");
		String title = sc.next();
		System.out.println("글내용을 입력해주세요:");
		String content = sc.next();
		System.out.println("작성자 id를 입력해주세요:");
		String id = sc.next();
		

		try {
			// (1/n) 디비 접속 정보 넣어서 접속하기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BoardTest", "root", "root");
			// (2/n) Statement 객체 얻어오기.
			st = con.createStatement();	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		try {
			// (3/n) Statement 객체의 executeUpdate함수에 sql문 실어서 디비에서 실행되게 하기
			// 이거 하는 순간 디비에 sql(쿼리) 날아감. (디비에 반영됨)
			
//			String sql = "insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('콘솔프로그램에서쓴글','kitty',now(),'콘솔프로그램에서 작성한 글입니다. 글글.....글....',0);";
//			String sql = "insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('" + title + "','" + id + "',now(),'" + content + "',0);";
			String sql = String.format("insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('%s','%s',now(),'%s',0);", title, id, content);
			
			System.out.println("sql 로그:"+sql);
			
			st.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}