package com.peisia.c.mysqltest;

import java.sql.Connection;			//자바 ↔ MySQL 연결을 관리하는 객체 (데이터 전송 통로)
import java.sql.DriverManager;		//연결을 실제로 열어주는 도우미 (운전기사 느낌)
import java.sql.Statement;			//SQL 문장을 실행하는 객체 (SQL 실행기)

public class ProcBoard {			// (32.5番問題) (삽입/수정/삭제 (INSERT/UPDATE/DELETE용)
	Connection con = null;			//DB 연결용 객체(con)	미리 준비
	Statement st = null;			//SQL 실행 객체(st) 	미리 준비
	
	void run() {
		dbInit();
		dbExecuteUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('콘솔프로그램에서쓴글','kitty',now(),'콘솔프로그램에서 작성한 글입니다. 글글.....글....',0)");
	}
	
	//initDb()과 (물론 이건 그냥 생략 당한거임 자동이니) dbRun()의 국룰 2문장 쓴 것! 앞으로도 이렇게만 쓰면 될듯
	
	private void dbInit() { //// MySQL 연결 + 실행 Statement 객체를 생성 및 준비
		try {
			// (1/n) 디비 접속 정보 넣어서 접속하기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BoardTest", "root", "root");
			// (2/n) Statement 객체 얻어오기.
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
			// 	SQL 실행기 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dbExecuteUpdate(String query) { // 전달받은 쿼리 실행
		//삽입/수정/삭제 (INSERT/UPDATE/DELETE용!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
		try {
			// (3/n) Statement 객체의 executeUpdate함수에 sql문 실어서 디비에서 실행되게 하기
			int resultCount = st.executeUpdate(query); // 이거 하는 순간 디비에 sql(쿼리) 날아감. (디비에 반영됨)
			//st(=statement).executeUpdate(query)는 int 타입을 리턴(return) 하도록, 내부적으로 그렇게 동작하도록 설계되어 있기 때문!!!!!!!
			//즉, 자바 문법이 아니라, JDBC 라이브러리(Statement 클래스) 가 그렇게 만든 함수인거임!!!!!!!!
			System.out.println("처리된 행 수:"+resultCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
