package com.peisia.c.member;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcMemberRegister {

	/* 회원가입 처리 */
	// 일단은 id와 pw만 회원 정보로 입력하게 처리
	static private String cmd = "";
	static public void run() {
		Cw.wn("======== 회원가입 =========");
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
		Db.dbExecuteUpdate("insert into member values('"+id+"','"+pw+"')");
		Cw.wn("[가입완]");
	}
}