package com.pjwr.mysqltest;

import java.sql.Connection;			//MySQL과 "연결을 유지"하는 객체를 가져옴
import java.sql.DriverManager;		//DB랑 실제로 연결을 시도할 때 사용하는 도우미
import java.sql.ResultSet;			//SELECT 같은 쿼리를 날렸을 때 결과값을 받아오는 바구니
import java.sql.SQLException;		//DB 관련된 문제가 생겼을 때, 예외 처리를 해주는 클래스
import java.sql.Statement;			//SQL 문장을 만들고, MySQL에 보내고, 결과를 받아오는 역할

//	[MySQL 연결]
//		  ↓
//	[SQL 실행 준비]
//		  ↓
//	[SELECT 전송]
//		  ↓
//	[결과 받기(ResultSet)]				// (32番問題, with 토트넘 SQL) (조회 (SELECT용))
//		  ↓							// 또한, 용어 공부용
//	[한 줄씩 읽어서 출력]
//		  ↓
//	[에러 생기면 잡아서 로그 출력]

public class Main {
	public static void main(String[] args) {
		initDb();
		dbRun();
	}
	
	static private void initDb() {  //자바에서 MySQL을 사용할 수 있도록 "JDBC 드라이버 (자바가 MySQL과 대화할 수 있게 해주는 연결 도우미 (번역기))"
									//를 메모리에 불러오는 함수
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //"MySQL 드라이버 클래스를 메모리에 로딩해라! (JDBC를 연결하는 코드)"
			//문자열로 클래스 이름을 받아서 강제로 메모리에 로딩하는 기능													// "꼭 필요하지 않다." 자동 로딩
			System.out.println("잘연결됨");
		} catch (ClassNotFoundException e1) {  //클래스 못 찾을 때 발생하게함
			e1.printStackTrace();  //에러가 발생한 이유와 위치를 콘솔에 상세하게 출력해줌
		}
	}
	
	static private void dbRun() {  //실제 DB(MySQL) 연결 → SQL 실행 → 결과 출력
		try {	// 아래 코드들을 이 try{ 블럭 안에 안쓰면 에러남.
			//																		   *db명*   *id*     *암호*				
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			// {DB와 연결된 통로 객체 - 실제 연결 시도 메서드 - 접속 주소 (DB종류 + 위치 + 포트 + DB명) - DB 접속 계정과 비밀번호} = 실제로 연결
			java.sql.Statement st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체!
			//Statement = SQL 실행기							// Statement하나당 한개의 ResultSet 객체만을 열 수있다.
			//createStatement() = 새로운 명령 실행기 생성	(=연결했으니 실행 준비 완료!!!)
			//!!!위에 까지는 매번 뻔하게 작성해주는 실행문!!!
			//이 아래부터는 보낼 SQL 문 종류에 따라 차이가 생김
			ResultSet result = st.executeQuery("select * from tottenham_squad where p_number=10");	//SELECT 쿼리를 보내고 결과를 받아오기
			//executeQuery(...)	= SELECT전용!!!!!!!!!!!!!!!!!!!!!!!! SQL 실행		 <=> executeUpdate
			//ResultSet	= 결과가 담기는 바구니 (행 단위 저장)
			while (result.next()) {	// 결과를 한 줄씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				//result.next() → 다음 줄이 있으면 true, 없으면 false
				String name = result.getString("p_name");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				//getString() = 문자열로 꺼내기
				System.out.println(name);
			}
		} catch (SQLException e) {	// java try-catch 문. p.14장 참고. 일단 그냥 복붙.
//			SQLException	SQL 관련 에러가 생기면 잡아주는 예외
//			getMessage()	에러 설명 보여줌
//			getSQLState()	SQL 상태 코드 (오류 종류를 알려줌)
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			//전화를 잘못 걸었을 때 안내음 나오는 것처럼, 에러 설명해줌
		}
	}
}
