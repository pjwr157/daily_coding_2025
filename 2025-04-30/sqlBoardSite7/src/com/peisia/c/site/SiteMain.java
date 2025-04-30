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
	static public String loginedId = null;

	static public void run() {
		Db.dbInit();	//주의
		
		loop: while (true) {
			DispSite.entranceTitle();
			if(loginedId==null) {	// 로그아웃 상태일 때
				cmd = Ci.r("[r]회원가입 [l]로그인 [e]프로그램종료");
			} else {
				Cw.wn(loginedId+" 고객님 환영합니다.");
				cmd = Ci.r("[l]로그아웃 [b]게시판 [a]관리자 [e]프로그램종료 ");
			}
			switch (cmd) {
			case "r":
				if(loginedId==null) {	// 로그인 상태가 아니면. JavaMysqlSitePeisia_v0.0.4
					ProcMemberRegister.run();
				} else {	// 로그인 상태면
					Cw.wn("장난x");
				}				
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
				if(loginedId==null) {	// 로그인 상태가 아니면. JavaMysqlSitePeisia_v0.0.4
					Cw.wn("장난x");
				} else {	// 로그인 상태면
					ProcBoard.run();
				}				
				break;
			default:
				Cw.wn("장난x");
			}
		}
	}
}