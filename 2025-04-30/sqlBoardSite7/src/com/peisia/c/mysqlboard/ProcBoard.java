package com.peisia.c.mysqlboard;

import com.peisia.c.mysqlboard.display.DispBoard;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcBoard {
	static public void run() {
		DispBoard.title();
//		Db.dbInit();
		Db.getPostCount();
		loop:while(true) {
			Db.dbPostCount();
			DispBoard.menuMain();
			String cmd=Ci.r("명령입력");
			switch(cmd) {
			case "1":	//글리스트
				ProcList.run();
				break;
			case "2":	//글읽기
				ProcRead.run();
				break;
			case "3":	//글쓰기
				ProcWrite.run();
				break;
			case "4":	//글삭제
				ProcDel.run();
				break;
			case "5":	//글수정
				ProcEdit.run();
				break;
			case "6":	//글리스트-검색
				ProcList.search();
				break;
			case "x":	//게시판 종료
				Cw.wn("사이트 메인으로 이동");
				break loop;
			}
		}
	}
}