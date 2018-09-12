package com.sql.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sql.action.Action;
import com.sql.modle.Modle;

public class RunTest {
	public static void main(String[] args) throws Exception {
		Action ac=new Action();
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
		List<Modle> god=ac.query(params, ao);
		for (Modle modle : god) {
			System.out.println(modle.toString());
		}
	}
}
