package com.peisia.c.mysqlboard;

import com.peisia.c.mysqlboard.display.DispBoard;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcList {
	static public final int PER_PAGE = 3;
	static int startIndex = 0;		// 현재 페이지의 첫 글 인덱스
	static int currentPage = 1;		// 현재 페이지
	static boolean isSearchMode = false;	// 현재 리스트가 검색 모드인지 구분하는 값
	static int totalPage = 0;
	static int count = 0;
	static String cmd = "";
	static public void run() {
		////	전체 페이지 수를 구하기	////
		count = Db.getPostCount(); 
		if(count % PER_PAGE > 0) {
			totalPage = count / PER_PAGE + 1;
		}else {
			totalPage = count / PER_PAGE;
		}
		Cw.wn("총 페이지 수:"+totalPage);
		while(true) {
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");
				continue;
			}
			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			DispBoard.titleList();
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
			} catch (Exception e) {
			}			
		}
	}
	/* 검색어를 입력받아 리스트-검색 처리 */
	static public void search() {
		cmd=Ci.rl("검색어[x:나가기]");
		if(cmd.equals("x")) {
			return;
		}else {
			searchList(cmd);
		}
	}
	/* 리스트-검색 처리 */
	static public void searchList(String searchWord) {
		////	전체 페이지 수를 구하기	////
		count = Db.getPostCountSearch(searchWord); 
		if(count % PER_PAGE > 0) {
			totalPage = count / PER_PAGE + 1;
		}else {
			totalPage = count / PER_PAGE;
		}
		Cw.wn("총 페이지 수<검색모드>:"+totalPage);
		while(true) {
			cmd = Ci.r("페이지번호입력<검색모드>[이전 메뉴로:x]:");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");
				continue;
			}
			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			DispBoard.titleList();
			String sql = "select * from board where b_reply_ori is null"
					+ " and b_title like '%" + searchWord + "%'"
					+ " limit "+startIndex+","+PER_PAGE;
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
			} catch (Exception e) {
			}			
		}		
	}
}