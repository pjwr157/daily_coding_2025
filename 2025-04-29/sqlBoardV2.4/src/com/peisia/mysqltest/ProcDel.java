package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcDel {
	static public void run() {
		String delNo = Ci.r("삭제할 글번호를 입력해주세요:");
		Db.dbExecuteUpdate("delete from board where b_no="+delNo);		
	}
}
