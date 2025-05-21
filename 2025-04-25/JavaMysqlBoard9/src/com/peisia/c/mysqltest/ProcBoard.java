package com.peisia.c.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcBoard {							// (42番問題) (연습 계속 해보기)
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);

	void run() {
		Display.showTitle();
		dbInit();
		loop: while (true) {
			dbPostCount();
			Display.showMainMenu();
			System.out.println("명령입력: ");
			String cmd = sc.next();
			switch (cmd) {
			case "1": // 글리스트
				System.out.println("==========================================");
				System.out.println("================= 글리스트 ==================");
				System.out.println("==========================================");
				System.out.println("글번호 글제목 작성자id 작성시간");
				try {
					result = st.executeQuery("select * from board");
					while (result.next()) { // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
						String no = result.getString("b_no");
						String title = result.getString("b_title");
						String id = result.getString("b_id");
						String datetime = result.getString("b_datetime");
						System.out.println(no + " " + title + " " + id + " " + datetime);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "2": // 글읽기
				System.out.println("읽을 글 번호를 입력해주세요:");
				String readNo = sc.next();
				try {
					result = st.executeQuery("select * from board where b_no =" + readNo);
					result.next(); // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
					String title = result.getString("b_title"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					String content = result.getString("b_text"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					System.out.println("글제목: " + title);
					System.out.println("글내용: " + content);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3": // 글쓰기
				sc.nextLine(); // 위에 sc.next() 쓴거 때문에 추가함.
				System.out.println("제목을 입력해주세요:");
				String title = sc.nextLine();
				System.out.println("글내용을 입력해주세요:");
				String content = sc.nextLine(); // 이거 전에는 쓸 필요 없음. 바로 전에서 쓰인건 nextLine() 이기 때문.
				System.out.println("작성자id를 입력해주세요:");
				String id = sc.next();
				try {
					st.executeUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit)" + " values ('" + title
							+ "','" + id + "',now(),'" + content + "',0)");
					System.out.println("글등록 완료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "4": // 글삭제
				System.out.println("삭제할 글번호를 입력해주세요:");
				String delNo = sc.next();
				dbExecuteUpdate("delete from board where b_no=" + delNo);
				break;
			case "5": // 글수정
				System.out.println("수정할 글번호를 입력해주세요:");
				String editNo = sc.next();
				System.out.println("제목을 입력해주세요:");
				// 주의. 이전에 sc.next() 등을 호출한적이 있으면 엔터 문자열이 남게 되는데 이거 때문에 다음에 나오는 nextLine()가
				// 입력을 이미 한것으로 인식하고 입력처리를 해버림(공백 입력이 된걸로 인식)
				// 그래서 sc.nextLine()을 한번 더 추가해주어 이 내용이 없는 엔터 문자열을 입력처리 하게끔하고
				sc.nextLine();
				String edTitle = sc.nextLine(); // << 여기에서 다시 정상적으로 쓰면됨.
				System.out.println("작성자id를 입력해주세요:");
				String edId = sc.next();
				System.out.println("글내용을 입력해주세요:");
				sc.nextLine(); // 위에 sc.next() 쓴거 때문에 추가함.
				String edContent = sc.nextLine();

				dbExecuteUpdate("update board set b_title='" + edTitle + "',b_id='" + edId
						+ "',b_datetime=now(),b_text='" + edContent + "' where b_no=" + editNo);
				break;
			case "0": // 관리자
				break;
			case "e": // 프로그램 종료
				System.out.println("프로그램종료");
				break loop;
			}
		}
	}

	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "admin");
			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열
										// 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수:" + resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void dbPostCount() {
		try {
			result = st.executeQuery("select count(*) from board");
			result.next();
			String count = result.getString("count(*)");
			System.out.println("글 수:" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
