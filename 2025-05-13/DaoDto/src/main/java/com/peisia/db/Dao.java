package com.peisia.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Dao {
	Connection con=null;
	Statement st = null;
	public void del() {
		try {
			////고정 1
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////고정 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3
			st=con.createStatement();
			
			//todo:
			//코딩하시오:
			String sql = String.format("delete from %s where b_no=2"
					,Db.TABLE_PS_BOARD_FREE);
			st.executeUpdate(sql);
			
			////고정 4
			st.close();
			////고정 5
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}