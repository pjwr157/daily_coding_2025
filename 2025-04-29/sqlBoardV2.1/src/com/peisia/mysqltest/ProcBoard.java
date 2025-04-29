package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcBoard {
	void run() {
		Disp.showTitle();
		Db.dbInit();
		loop:while(true) {
			Db.dbPostCount();
			Disp.showMainMenu();
			String cmd=Ci.r("명령입력: ");
			switch(cmd) {
			case "1":	//글리스트
				ProcList.run();
				break;
			case "2":	//글읽기
				String readNo = Ci.r("읽을 글 번호를 입력해주세요:");
				try {
					Db.result = Db.st.executeQuery("select * from board where b_no ="+readNo);
					Db.result.next();	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
					String title = Db.result.getString("b_title");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					String content = Db.result.getString("b_text");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					Cw.wn("글제목: "+title);
					Cw.wn("글내용: "+content);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3":	//글쓰기
				String title = Ci.rl("제목을 입력해주세요:");
				String content = Ci.rl("글내용을 입력해주세요:");
				String id = Ci.rl("작성자id를 입력해주세요:");
				try {
					Db.st.executeUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit)"
							+" values ('"+title+"','"+id+"',now(),'"+content+"',0)");
					Cw.wn("글등록 완료");
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				break;
			case "4":	//글삭제
				String delNo = Ci.r("삭제할 글번호를 입력해주세요:");
				Db.dbExecuteUpdate("delete from board where b_no="+delNo);
				break;
			case "5":	//글수정
				String editNo = Ci.r("수정할 글번호를 입력해주세요:");
				String edTitle = Ci.rl("제목을 입력해주세요:");
				String edId = Ci.rl("작성자id를 입력해주세요:");				
				String edContent = Ci.rl("글내용을 입력해주세요:");
				Db.dbExecuteUpdate("update board set b_title='"+edTitle+"',b_id='"+edId+"',b_datetime=now(),b_text='"+edContent+"' where b_no="+editNo);
				break;
			case "0":	//관리자
				break;
			case "e":	//프로그램 종료
				Cw.wn("프로그램종료");
				break loop;
			}
		}
	}
}