package com.sql.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;
import com.sql.DB.DBUtil;

public class Dao2 {
	public static void select_nofilter() throws SQLException{
		//获得连接
		Connection con=DBUtil.getConnection();
		//获得callablestatement
		CallableStatement cs=con.prepareCall("call sp_select_nofilter()");
		//执行操作
		cs.execute();
		//返回结果集
		ResultSet re=cs.getResultSet();
	}
}
