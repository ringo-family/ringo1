package com.sql.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sql.dao.Dao;
import com.sql.modle.Modle;

//搭建控制层的操作
public class Action {
	public void add(Modle g) throws Exception{
		Dao da=new Dao();
		da.add(g);
	}
	public void delete(int id) throws SQLException{
		Dao da=new Dao();
		da.delete(id);
	}
	public void edit(Modle g,int id) throws SQLException{
		Dao da=new Dao();
		da.update(g, id);
	}
	public List<Modle> query(List<Map<String,Object>> params,int[] ao) throws Exception{
		Dao da=new Dao();
		return da.queryByYou(params, ao);
	}
	public Modle get(int id) throws SQLException{
		Dao da=new Dao();
		return da.querySingle(id);
	}
}
