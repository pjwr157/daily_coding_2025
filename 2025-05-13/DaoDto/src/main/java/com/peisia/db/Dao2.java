package com.peisia.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Dao2 {
	Connection con=null;
	Statement st = null;
	/* 삭제 */
	public void del(int no) {
		try {
			////고정 1
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////고정 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3
			st=con.createStatement();
			
			//코딩하시오:
			String sql = String.format("delete from %s where b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, no);
			st.executeUpdate(sql);
			
			////고정 4
			st.close();
			////고정 5
			con.close();		// 데이터베이스 연결 관련 자원(resource)을 해제하는 기능
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* 쓰기 */
	public void write(String title,String writerId,String text) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정 1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정 2]			
			st=con.createStatement();	// [고정 3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			insert into ps_board_free (b_title,b_id,b_text) values ('야옹','cat','aaa');
			String sql = String.format(
					"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s');"
					,Db.TABLE_PS_BOARD_FREE, title,writerId,text);
			st.executeUpdate(sql);
			
			st.close();		// [고정 4]
			con.close();	// [고정 5]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}