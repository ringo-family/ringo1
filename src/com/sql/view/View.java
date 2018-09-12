package com.sql.view;

import java.util.Scanner;

public class View {
	private static final String CONTEXT="下面是功能列表：\n"+
			"[MAIN/M]:主菜单\n"+
			"[QUERY/Q]:查看女神全部信息\n"+
			"[GET/G]:查看某位女神的详细信息\n"+
			"[ADD/A]:添加女神\n"+
			"[UPDATE/U]:更新女神信息\n"+
			"[DELETE/D]:删除女神\n"+
			"[SEARCH/S]:查询女神信息（根据姓名和手机号来查询）\n"+
			"[EXIT/E]:退出女神禁区\n"+
			"[BREAK/B]:退出当前功能，返回主菜单\n";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args) {
		System.out.println(CONTEXT);
		Scanner sc=new Scanner(System.in);
		String head="你输入的操作是：";
		while(sc.hasNext()){
			String in=sc.next().toString();
			System.out.println(head+in);
			if(OPERATION_EXIT.equals(in.toUpperCase())||"E".equals(in.toUpperCase())){
				System.out.println("欢迎下次光临");
				break;
			}
		}
		
	}
}
