package com.hand.Exam3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exam3_1 {
	
	public static Connection getCoonection(){
		Connection conn =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?characterEncoding=utf8", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	} 
	
	public static void check(int id)  {
		Connection conn=getCoonection();
		Statement st=null;
		ResultSet rs=null;
	try {
		String sql="select country,city_id,city from country a,city b where a.country_id="+id+" and a.country_id=b.country_id";
		 st =conn.createStatement();
		 rs = null ;
		rs= st.executeQuery(sql);
		//int count=0;
		//System.out.println("城市：");
		rs.first();
		System.out.println("Country"+" "+rs.getString("country")+"的城市->");
		System.out.println("城市 ID|城市名称");
		rs.beforeFirst();
		while (rs.next()) {
			//System.out.println("Country"+" "+rs.getString("country")+"的城市->");
			//System.out.println("城市 ID|城市名称");
			System.out.print(rs.getString("city_id")+"  ");
			System.out.print("|");
			System.out.print(rs.getString("city"));
			System.out.println();
		}
		//System.out.println("done");
		//System.out.print("记录："+count);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			rs.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		try {
			st.close();
		} catch (Exception e3) {
			// TODO: handle exception
		}
		try {
			conn.close();
		} catch (Exception e4) {
			// TODO: handle exception
		}
	}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入：");
		System.out.print("请输入Country ID:");
		System.out.println();
		Scanner a1=new Scanner(System.in); 
		int Country_ID =a1.nextInt();
		System.out.println("输出：");
		check(Country_ID);
	}
	
	

}

