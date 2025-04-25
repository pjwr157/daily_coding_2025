package com.peisia.c.mysqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main { 							// (42番問題)
	public static void main(String[] args) {
		ProcBoard procBoard = new ProcBoard();
		procBoard.run();
	}
}