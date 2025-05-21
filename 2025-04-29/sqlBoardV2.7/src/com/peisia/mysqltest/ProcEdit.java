package com.peisia.mysqltest;

import com.peisia.util.Ci;
import com.peisia.util.Db;

public class ProcEdit {
	static public void run() {
		String editNo = Ci.r("수정할 글번호를 입력해주세요:");
		String edTitle = Ci.rl("제목을 입력해주세요:");
		String edId = Ci.rl("작성자id를 입력해주세요:");				
		String edContent = Ci.rl("글내용을 입력해주세요:");
		Db.dbExecuteUpdate("update board set b_title='"+edTitle+"',b_id='"+edId+"',b_datetime=now(),b_text='"+edContent+"' where b_no="+editNo);		
	}
}
