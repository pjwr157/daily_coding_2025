package com.peisia.c.member;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcMemberLogin {
	static public String run() {	/* 로그인 처리 */
		Cw.wn("======== 로그인 =========");
		String id="";
		String pw="";
		while(true) {
			id=Ci.r("아이디");
			if(id.length()>0) {
				break;
			}else {
				Cw.wn("장난x");
			}
		}
		while(true) {
			pw=Ci.r("암호");
			if(pw.length()>0) {
				break;
			}else {
				Cw.wn("장난x");
			}
		}
		//id,pw 를 디비에 저장. ex. insert into member values('nyang','1234');
		if(Db.isProcLogin(id,pw)) {	//로그인 처리
			return id;
		}else {	//로그인 실패 처리
			Cw.wn("로그인 실패");
			return null;
		}
	}
}