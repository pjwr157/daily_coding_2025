package com.peisia.c.site;

import com.peisia.c.member.ProcMemberRegister;
import com.peisia.c.mysqlboard.ProcBoard;
import com.peisia.c.site.display.DispSite;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class SiteMain {
	static private String cmd = "";

	static public void run() {
		Db.dbInit();	//주의
		
		loop: while (true) {
			DispSite.entranceTitle();
			cmd = Ci.r("[r]회원가입 [l]로그인 [a]관리자 [e]프로그램종료 [b]게시판(임시입구)");
			switch (cmd) {
			case "r":
				ProcMemberRegister.run();
				break;
			case "l":
				break;
			case "a":
				break;
			case "e":
				Cw.wn("프로그램 종료");
				break loop;
			case "b":
				ProcBoard.run();
				break;
			default:
				Cw.wn("장난x");
			}
		}
	}
}