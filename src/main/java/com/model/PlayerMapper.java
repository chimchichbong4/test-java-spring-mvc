package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerMapper {
	public static ArrayList<Player> list = new ArrayList<Player>();
	public static Connection get() {
		final String url="jdbc:mysql://localhost:3306/locpham";
		final String user= "root";
		final String password= "maboy918";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("That bai 1"+e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("That bai 2"+e);
		}
		return null;
	}
	public static void connect() throws Exception
	{
		Connection connection= get();
		if(connection != null) {
			System.out.println("Successful server connection!");
		}
		else {
			System.out.println("That Bai!");
		}
			java.sql.Statement statement = connection.createStatement();
		if(statement != null) {
			System.out.println("Successful server connection!");
		}
		else {
			System.out.println("That Bai!");
		}
		String sql = "select id,name,clb,nation,position,image from player";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			 	Player play= new Player();
			 	play.setId(rs.getInt(1));
				play.setName(rs.getString(2));
				play.setClb(rs.getString(3));
				play.setNation(rs.getString(4));
				play.setPosition(rs.getString(5));
				play.setImage(rs.getString(6));
				System.out.println("ID:"+play.getId());
				System.out.println("Name:"+play.getName());
				System.out.println("Age:"+play.getClb());
				System.out.println("Diem 1:"+play.getNation());
				System.out.println("Diem 2:"+play.getPosition());
				System.out.println("Diem 2:"+play.getImage());
				list.add(play);
		 }
	}

}
