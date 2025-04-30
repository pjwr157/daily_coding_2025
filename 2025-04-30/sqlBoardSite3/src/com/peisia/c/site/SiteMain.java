package com.peisia.c.site;

import com.peisia.c.member.ProcMemberLogin;
import com.peisia.c.member.ProcMemberRegister;
import com.peisia.c.mysqlboard.ProcBoard;
import com.peisia.c.site.display.DispSite;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class SiteMain {
	static private String cmd = "";
	static private String loginedId = null;

	static public void run() {
		Db.dbInit();	//주의
		
		loop: while (true) {
			DispSite.entranceTitle();
			if(loginedId==null) {
				cmd = Ci.r("[r]회원가입 [l]로그인 [a]관리자 [e]프로그램종료 [b]게시판(임시입구)");
			} else {
				Cw.wn(loginedId+" 고객님 환영합니다.");
				cmd = Ci.r("[r]회원가입 [l]로그아웃 [a]관리자 [e]프로그램종료 [b]게시판(임시입구)");
			}
			switch (cmd) {
			case "r":
				ProcMemberRegister.run();
				break;
			case "l":
				if(loginedId==null) {	// 로그인 상태가 아니면
					loginedId = ProcMemberLogin.run();
				} else {	// 로그인 상태면. 로그인 아이디를 null 로 바꿔주는 식으로 로그아웃 처리
					Cw.wn("[로그아웃 됨]");
					loginedId = null;
				}
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