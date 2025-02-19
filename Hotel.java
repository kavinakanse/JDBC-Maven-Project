package com.preparedstatementdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Hotel {
	public static void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps = c.prepareStatement("insert into hotel values(?, ?, ?)");
		ps.setInt(1, 104);
		ps.setString(2, "kavina");
		ps.setString(3, "9876543212");
		ps.executeUpdate();
		System.out.println("Data is inserted");
		c.close();
		
	}
	public static void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps = c.prepareStatement("update hotel set client_name=? where room_no=?");
		ps.setInt(2, 103);
		ps.setString(1, "shitika");
		ps.executeUpdate();
		System.out.println("Data is updated...");
		c.close();		
	}
	
	public static void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps = c.prepareStatement("delete from hotel where room_no=?");
		ps.setInt(1, 101);
		ps.executeUpdate();
		System.out.println("Data is deleted...");
		c.close();		
	}
	
	public static void getAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch204","root","root");
		PreparedStatement ps = c.prepareStatement("select * from hotel");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"| "+rs.getString(2)+" | "+rs.getString(3));
		}
		c.close();		
	}
}
