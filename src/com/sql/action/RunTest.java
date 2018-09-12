package com.sql.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sql.dao.Dao;
import com.sql.modle.Modle;
//调用Dao的方法来操作数据库
public class RunTest {
	public static void main(String[] args) throws Exception {
		Dao da = new Dao();
//		//添加一个新成员到表中
//				Modle g=new Modle();
//				g.setAge(20);
//				g.setBirthday(new Date());
//				g.setCreater_user("Ringo");
//				g.setEmail("13922924658@163.com");
//				g.setId(3);
//				g.setMobile("13922924658");
//				g.setSex(2);
//				g.setUpdate_user("Ringo");
//				g.setUser_name("小舞");
//				g.setIsdel(1);
//				da.add(g);
		//删除对象
		//da.delete(36);
		//查询并输出
//		List<Modle> god = da.query("id,user_name,sex,age");
//		for (Modle modle : god) {
//			System.out.println(modle.getId()+" "+modle.getUser_name() + " "
//					+ modle.getSex() + " " + modle.getAge());
//		}
		//更新对象信息
		Modle g=new Modle();
		g.setAge(20);
		g.setBirthday(new Date());
		g.setCreater_user("Ringo");
		g.setEmail("13922924658@163.com");
		g.setId(3);
		g.setMobile("13922924658");
		g.setSex(2);
		g.setUpdate_user("Ringo");
		g.setUser_name("小舞");
		g.setIsdel(1);
		da.update(g, 1);
//		//查询单个对象
//		Modle god=da.querySingle(1);
//		System.out.println(god.toString());
		//通过名字来查询对象
//		List<Modle> god=da.queryByName("小舞");
//		for (Modle modle : god) {
//			System.out.println(god.toString());
//		}
		//通过自定义条件来查询对象
		List<Map<String,Object>> params=new ArrayList<Map<String,Object>>();
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("name", "user_name");
		param.put("rela", "=");
		param.put("value", "'小舞'");
		params.add(param);
		param=new HashMap<String,Object>();
		param.put("name", "mobile");
		param.put("rela", "like ");
		param.put("value", "'%139%'");
		params.add(param);
		param=new HashMap<String,Object>();
		param.put("name", "birthday");
		param.put("rela", "=");
		param.put("value", "'2018-8-28'");
		params.add(param);
		int[] ao={1,1,0};
		System.out.println(da.queryByYou(params,ao).toString());
	}
}
