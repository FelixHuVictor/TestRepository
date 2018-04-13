package com.aowin.finance.util;
import jaa.sql.*;
public class DBUtil{
	public static String url = "jdbc:mysql://localhost:3306/scm";
	public static String user= "root";
	public static String pwd = "167910";
	
	/*
	public static void main(String args[]){
	
		System.out.println(".exrc vi环境配置，缩写模式syso输出"); 
	
	} 
	*/	

	static{
		try{
			class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功！");
		}catch(ClassNotFoundException exc){
			System.err.println(exc.getMessage());
		}
	}
	
	public static Connection getConn(){

		Connection conn = null;		

		try {
			conn = DriverManager.getConnection(url, user, pwd);

			System.out.println("数据库连接成功");

		} catch (SQLException e) {

			System.err.println(e.getMessage()); 

		}    

		return conn;
	}

	public static void close(ResultSet rs,Statement stmt,Connection conn){

		try {

			if(rs!=null){

				rs.close();

				rs = null;

			}

			if(stmt!=null){

				stmt.close();

				stmt=null;

			}

			if(conn!=null){

				conn.close();

				conn = null;

			}

			System.out.println("数据库关闭成功");

		} catch (SQLException e) {

			System.err.println(e.getMessage());

		}

	}
}
