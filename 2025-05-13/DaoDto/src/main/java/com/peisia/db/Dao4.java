package com.peisia.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Dao4 {
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
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* 쓰기 */
	public void write(Dto d) {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();	// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			insert into ps_board_free (b_title,b_id,b_text) values ('야옹','cat','aaa');
			String sql = String.format(
					"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s');"
					,Db.TABLE_PS_BOARD_FREE, d.title,d.id,d.text);
			st.executeUpdate(sql);
			
			st.close();		// [고정-4]
			con.close();	// [고정-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* 글 읽기 */
	public Dto2 read(String no) {
		Dto2 post = null;
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);	// [고정-1]
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);	// [고정-2]			
			st=con.createStatement();	// [고정-3]
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select * from %s where b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, no);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto2(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
			st.close();		// [고정-4]
			con.close();	// [고정-5]
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}	
}