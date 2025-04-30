package com.peisia.c.mysqlboard;

import com.peisia.c.mysqlboard.display.DispBoard;
import com.peisia.c.site.SiteMain;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcReply {
	static public void list(int oriNo) {	/* 댓글 리스트 출력하는 함수 */
		DispBoard.replyBar();
		String sql = "select * from "+Db.tableNameBoard+" where b_reply_ori="+oriNo;
		try {
			Cw.wn("전송한sql문:"+sql);
			Db.result = Db.st.executeQuery(sql);
			while(Db.result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				String b_reply_text = Db.result.getString("b_reply_text");
				String b_id = Db.result.getString("b_id");	//댓글 작성자 id도 구해서.. JavaMysqlSitePeisia_v0.0.5
				Cw.wn(b_reply_text+" - "+b_id);				//댓글 작성자 id도 표시.
			}
		} catch (Exception e) {
		}		
	}
	static public void write(int b_reply_ori) {	/* 댓글 작성 함수 */
		String b_reply_text = Ci.rl("댓글입력");
		Db.dbExecuteUpdate("insert into "+Db.tableNameBoard
				+ " (b_id,b_datetime,b_reply_ori,b_reply_text) values"
				+ "('"
				+ SiteMain.loginedId	//댓글 작성 시 로그인 한 id로 자동 입력. JavaMysqlSitePeisia_v0.0.5
				+"',now(),"+b_reply_ori+",'"+b_reply_text+"')");
	}
}