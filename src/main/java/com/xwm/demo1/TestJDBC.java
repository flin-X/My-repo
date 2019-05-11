package com.xwm.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Hongkong",
				"root", "123qwe@QWE");
		System.out.println(con);
	}
}
