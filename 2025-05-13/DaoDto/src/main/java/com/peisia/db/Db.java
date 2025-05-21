package com.peisia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {
	

	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";	//mysql
//	static private String DB_JDBC_DRIVER_PACKAGE_PATH = "oracle.jdbc.OracleDriver";	//오라클
	
	static private String DB_NAME = "my_cat";
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/"+DB_NAME;	//mysql
//	static private String DB_URL_ORACLE = "jdbc:oracle:thin:@127.0.0.1:1521:"+DB_NAME;	//오라클
	static public String DB_URL = DB_URL_MYSQL;	//디비 바뀌면 여기 바꾸시오.
	static public String DB_ID = "root";
	static public String DB_PW = "root";
	
	/* table들 */
	////	FantasyTrip
	public static final String TABLE_PLAYER = "FT_INS_PLAYER";
	public static final String TABLE_CITY = "FT_INS_CITY";
	public static final String TABLE_GOODS = "FT_GOODS";
	public static final String TABLE_SHIP_CARGO = "FT_INS_SHIP_CARGO";
	
	////	회원
	public static final String TABLE_PS_MEMBER = "PS_MEMBER";	//peisia.com 회원 테이블명
	
	////	게시판
	public static final String TABLE_PS_BOARD_FREE = "PS_BOARD_FREE";	//자유게시판
	
//	static public String tableNameBoard = "board";	
	
	static public Connection con = null;
	static public Statement stmt = null;
	static public ResultSet rs = null;
	static public int result = 0;
	
	static public void connectDb() throws Exception{
		Class.forName(DB_JDBC_DRIVER_PACKAGE_PATH);
		con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
		stmt=con.createStatement();
	}
	static public void disconnectDb() throws Exception{
		rs.close();		//db 연결 종료처리
		stmt.close();	//db 연결 종료처리
		con.close();	//db 연결 종료처리
	}	
}
