package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcList {
	static public final int PER_PAGE = 3;

	static public void run() {
		int startIndex = 0;		// 현재 페이지의 첫 글 인덱스
		int currentPage = 1;	// 현재 페이지
		
		////	전체 페이지 수를 구하기	////
		int totalPage = 0;
		if(Db.getPostCount() % PER_PAGE > 0) {
			totalPage = Db.getPostCount() / PER_PAGE + 1;
		}else {
			totalPage = Db.getPostCount() / PER_PAGE;
		}
		
		Cw.wn("총 페이지 수:"+totalPage);
		
		String cmd;
		while(true) {
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]:");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");
				continue;
			}

			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			Disp.titleList();
//			select count(*) from board where b_reply_ori is null;
			String sql = "select * from board where b_reply_ori is null limit "+startIndex+","+PER_PAGE;
			try {
				Cw.wn("전송한sql문:"+sql);
				Db.result = Db.st.executeQuery(sql);
				while(Db.result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
					String no = Db.result.getString("b_no");
					String title = Db.result.getString("b_title");
					String id = Db.result.getString("b_id");
					String datetime = Db.result.getString("b_datetime");
					Cw.wn(no+" "+title+" "+id+" "+datetime);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			
		}
		


	}
}
