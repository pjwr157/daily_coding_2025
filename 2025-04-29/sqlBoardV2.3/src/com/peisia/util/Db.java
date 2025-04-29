package com.peisia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	static public Connection con = null;
	static public Statement st = null;
	static public ResultSet result = null;
	static public void dbInit() {
		try {
			Db.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			Db.st = Db.con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	static public void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			Cw.wn("처리된 행 수:"+resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public void dbPostCount() {	
		try {
			Db.result = Db.st.executeQuery("select count(*) from board where b_reply_ori is null");
			Db.result.next();
			String count = Db.result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public int getPostCount() {
		String count = "";
		try {
			Db.result = Db.st.executeQuery("select count(*) from board where b_reply_ori is null");
			Db.result.next();
			count = Db.result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}
}
