package com.whatsapp.jdbc.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.whatsapp.controllers.LoginController;
import com.whatsapp.dao.ILoginDao;
import com.whatsapp.pojo.User;

public class LoginJdbcImpl implements ILoginDao{
	
	
	
	public final static Logger logger=Logger.getLogger(LoginJdbcImpl.class);

	public List<User> getUserDetails(String mailid, String password) {
		
		List<User> list=new ArrayList<User>();
	    
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsapp","root","root");		
		PreparedStatement ps = connection.prepareStatement("select *from whatsapp.user where mailid=? and pword=?");
		
	       
		  ps.setString(1,mailid);
	       ps.setString(2,password);
	      
	       
	    ResultSet resultSet = ps.executeQuery();
	    
	    
	    while(resultSet.next()){
	    	User user=new User();
	    	
	    	user.setMailid(resultSet.getString("mailid"));
	    	user.setCity(resultSet.getString("city"));
	    	user.setMobile(resultSet.getString("mobile"));
	    	user.setName(resultSet.getString("name"));
	    	user.setPword(resultSet.getString("pword"));
	    	
	    	list.add(user);
	    	
	    }
		}
		catch(Exception e){
         
			logger.error("exception occured while processing user name and password"+ e );
		
		}
		return list;
	}

	public List<User> getAllUsers() {
		
		logger.info("entered into all user list :: loginjdbcdaoimpl");
       List<User> list=new ArrayList<User>();
	    
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsapp","root","root");		
		PreparedStatement ps = connection.prepareStatement("select *from whatsapp.user");
		
	     
	       
	    ResultSet resultSet = ps.executeQuery();
	    
	    
	    while(resultSet.next()){
	    	User user=new User();
	    	
	    	user.setMailid(resultSet.getString("mailid"));
	    	user.setCity(resultSet.getString("city"));
	    	user.setMobile(resultSet.getString("mobile"));
	    	user.setName(resultSet.getString("name"));
	    	user.setPword(resultSet.getString("pword"));
	    	
	    	list.add(user);
	    	
	    }
		}
		
		catch(Exception e){
         
			logger.error("exception occured while processing user name and password"+ e );
		
		}
		logger.info("exited from  user list :: loginjdbcdaoimpl");
		return list;
	}
}


