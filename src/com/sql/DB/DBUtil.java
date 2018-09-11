package com.sql.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String URL = "jdbc:mysql://127.0.0.1:3306/imooc?characterEncoding=UTF-8";
	private static String NAME = "root";
	private static String PASSWORD = "";
	private static Connection conn = null;
	static {
		//加载驱动程序
		//获得数据库的连接
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//返回数据库连接
	public static Connection getConnection() {
		return conn;
	}
}
