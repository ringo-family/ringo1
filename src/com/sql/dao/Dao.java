package com.sql.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sql.DB.DBUtil;
import com.sql.modle.Modle;

//用来操控数据库的类（增删改查）
public class Dao {
	//增加表中的对象
	public void add(Modle g) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql = " " + "insert into imooc_goddess" + "(user_name," + "sex,"
				+ "age," + "birthday," + "email," + "mobile," +
				"create_user,create_date,update_user,update_date,isdel )"+
				"value("+
				"?,?,?,?,?,?,?,current_time(),?,current_time(),?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, g.getUser_name());
		pst.setInt(2, g.getSex());
		pst.setInt(3, g.getAge());
		pst.setDate(4, new Date(g.getBirthday().getTime()));
		pst.setString(5, g.getEmail());
		pst.setString(6, g.getMobile());
		pst.setString(7, g.getCreater_user());
		pst.setString(8, g.getUpdate_user());
		pst.setInt(9, g.getIsdel());
		pst.execute();
	}
	//更新表中对象的内容
	public void update(Modle g,int id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql ="update imooc_goddess"+
					" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"+
					" update_user=?,update_date=current_date(),isdel=?"+
					" where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, g.getUser_name());
		pst.setInt(2, g.getSex());
		pst.setInt(3, g.getAge());
		pst.setDate(4, new Date(g.getBirthday().getTime()));
		pst.setString(5, g.getEmail());
		pst.setString(6, g.getMobile());
		pst.setString(7, g.getUpdate_user());
		pst.setInt(8, g.getIsdel());
		pst.setInt(9, id);
		pst.execute();
	}
	//删除对象
	public void delete(int id) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql ="delete from imooc_goddess"+
					" where id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.execute();
	}
	//获得对象集合
	public List<Modle> query(String taget) throws Exception {
		List<Modle> gs = new ArrayList<Modle>();
		String sql = "select "+taget+" from imooc_goddess";//定义查询语句
		PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sql);//通过连接获得语句对象
		ResultSet result = pstmt.executeQuery();//查询数据库并返回结果集
		Modle god=null ;
		//将结果集中的数据储存到gs集合中
		while (result.next()) {
			god = new Modle();
			god.setId(result.getInt("id"));
			god.setUser_name(result.getString("user_name"));
			god.setSex(result.getInt("sex"));
			god.setAge(result.getInt("age"));
			gs.add(god);
		}
		return gs;
	}
	
	//通过名字获得对象集合
		public List<Modle> queryByName(String name) throws Exception {
			List<Modle> gs = new ArrayList<Modle>();
			String sql = "select* from imooc_goddess"+
						" where user_name=?";//定义查询语句
			PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sql);//通过连接获得语句对象
			pstmt.setString(1, name);
			System.out.println(sql);
			ResultSet result = pstmt.executeQuery();//查询数据库并返回结果集
			Modle god=null ;
			//将结果集中的数据储存到gs集合中
			while (result.next()) {
				god = new Modle();
				god = new Modle();
				god.setId(result.getInt("id"));
				god.setUser_name(result.getString("user_name"));
				god.setSex(result.getInt("sex"));
				god.setAge(result.getInt("age"));
				god.setBirthday(result.getDate("birthday"));
				god.setCreater_date(result.getDate("create_date"));
				god.setCreater_user(result.getString("create_user"));
				god.setIsdel(result.getInt("isdel"));
				god.setMobile(result.getString("mobile"));
				gs.add(god);
			}
			return gs;
		}
		
		//通过自定义条件获得对象
				public List<Modle> queryByYou(List<Map<String,Object>> params,int[] ao) throws Exception {
					List<Modle> gs = new ArrayList<Modle>();
					StringBuilder sql = new StringBuilder();
					sql.append("select* from imooc_goddess where 1=1");//定义初步查询语句
					if(params!=null&&params.size()>0){
						//完善查询语句
						for (int i = 0; i < params.size(); i++) {
							Map<String,Object> param=params.get(i);
							if(ao[i]==0){
								sql.append(" or");
							}else{
								sql.append(" and");
							}
							sql.append(" "+param.get("name")+" "+param.get("rela")+" "+param.get("value"));
						}
					}
					PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sql.toString());//通过连接获得语句对象
					System.out.println(sql);
					ResultSet result = pstmt.executeQuery();//查询数据库并返回结果集
					Modle god=null ;
					//将结果集中的数据储存到gs集合中
					while (result.next()) {
						god = new Modle();
						god = new Modle();
						god.setId(result.getInt("id"));
						god.setUser_name(result.getString("user_name"));
						god.setSex(result.getInt("sex"));
						god.setAge(result.getInt("age"));
						god.setBirthday(result.getDate("birthday"));
						god.setCreater_date(result.getDate("create_date"));
						god.setCreater_user(result.getString("create_user"));
						god.setIsdel(result.getInt("isdel"));
						god.setMobile(result.getString("mobile"));
						gs.add(god);
					}
					return gs;
				}
	//获得单个对象
	public Modle querySingle(int id) throws SQLException {
		//定义查询语句
		String sql = "select * from imooc_goddess"+
					" where id=?";
		PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sql);//通过连接获得语句对象
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();//查询数据库并返回结果集
		Modle god=null ;
		while (result.next()) {
			god = new Modle();
			god.setId(result.getInt("id"));
			god.setUser_name(result.getString("user_name"));
			god.setSex(result.getInt("sex"));
			god.setAge(result.getInt("age"));
			god.setBirthday(result.getDate("birthday"));
			god.setCreater_date(result.getDate("create_date"));
			god.setCreater_user(result.getString("create_user"));
			god.setIsdel(result.getInt("isdel"));
			god.setMobile(result.getString("mobile"));
	}
		return god;
	}
}