package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;
import com.model.Player;
import com.model.PlayerMapper;

@Repository
public class PlayerDao {
	private static final List<Player> giamMap = new ArrayList<Player>();
	static {
        try {
			initEmps();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	 
	 private static void initEmps() throws Exception {
		 PlayerMapper giamMapper = new PlayerMapper();
		 giamMapper.connect();
		 ArrayList<Player> list = giamMapper.list;
		 for(Player a:list)
		 {
			 giamMap.add(a);
		 }
	 }
	 	public Player getPlayer(int ID) {
	        return giamMap.get(ID-1);
	    }
//	 	public Player getPlayer2(int Age,String name) {
//	 		int	dem = 0;
//	 		for(int i=0;i<giamMap.size();i++) {
//	 			if(Age==giamMap.get(i).getAge()&&name.equals(giamMap.get(i).getName())) {
//	 				dem=i;
//	 			}		
//	 		}
//	 		System.out.println("dem:"+dem);
//	 		System.out.println("size:"+giamMap.size());
//			return giamMap.get(dem);
//	 	}
//	 	public Giamkhao getGiamkhao1(int ID,int Age) {
//	 		return giamMap.get(ID-1);
//	 	}
	 
	    public Player addPlayer(Player giam) {
	    	try {
	    	PlayerMapper giamMapper = new PlayerMapper();
	    	Connection conn= giamMapper.get();
	    	Calendar calendar = Calendar.getInstance();
	        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	        String query = " insert into player(id,name,clb,nation,position,image)"
	                + " values (?,?,?,?,?,?)";
	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	        preparedStmt.setInt(1, giam.getId());
	        preparedStmt.setString(2,giam.getName());
	        preparedStmt.setString(3,giam.getClb());
	        preparedStmt.setString(4,giam.getNation());
	        preparedStmt.setString(5,giam.getPosition());
	        preparedStmt.setString(6,giam.getImage());
	        preparedStmt.execute();
	        conn.close();
	    	}catch(Exception e){
	    		System.out.println("Add false");
	    	}
	        giamMap.add(giam);
	        return giam;
	    }
	 
	    public Player updatePlayer(Player giam) {
	    	try {
		    	PlayerMapper giamMapper = new PlayerMapper();
		    	Connection conn= giamMapper.get();
		    	Calendar calendar = Calendar.getInstance();
		        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		        String query = "update player set name = ?,clb= ?,nation=?,positon=? where id=?";
		        PreparedStatement preparedStmt = conn.prepareStatement(query);
		        preparedStmt.setString(1, giam.getName());
		        preparedStmt.setString(2,giam.getClb());
		        preparedStmt.setString(3,giam.getNation());
		        preparedStmt.setString(4,giam.getPosition());
		        preparedStmt.setInt(5,giam.getId());  
		        preparedStmt.executeUpdate();
		        conn.close();
		    	}catch(Exception e){
		    		System.out.println("Update false");
		    	}
	        giamMap.set(giam.getId()-1, giam);
	        return giam;
	    }
	 
	    public void deletePlayer(int ID) {
	    	try {
	    	PlayerMapper giamMapper = new PlayerMapper();
	    	Connection conn= giamMapper.get();
	    	PreparedStatement st = conn.prepareStatement("DELETE FROM player WHERE id=" +ID+ ";");
	    	st.executeUpdate();
	    	}catch(Exception e) {
	    		System.out.println("Delete That Bai");
	    	}
	    	int	dem = 0;
	 		for(int i=0;i<giamMap.size();i++) {
	 			if(giamMap.get(i).getId()==ID) {
	 				dem=i;
	 			}		
	 		}
	 		giamMap.remove(dem);
	    }
	 
	    public List<Player> getAllgiamkhao() {
	        List<Player> list= new ArrayList<Player>();
	        list=giamMap;
	        return list;
	    }
}
