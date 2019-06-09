package com.whatsapp.jdbc.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.whatsapp.dao.ILoginDao;
import com.whatsapp.dao.IRegisterDao;
import com.whatsapp.daoImpl.RegisterDaoImpl;
import com.whatsapp.pojo.User;

//Cat class which implements Animal
public class RegisterJdbcDaoImpl implements IRegisterDao{
	final static Logger logger=Logger.getLogger(RegisterJdbcDaoImpl.class);

	
	ILoginDao logindao=new LoginJdbcImpl();
	
	public void saveUser(User user) throws  Exception {
		logger.info("entered in to save user :: RegisterjdbcDaoImpl");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/whatsapp","root","root");		
		PreparedStatement ps = connection.prepareStatement("insert into user values (?,?,?,?,?,?)");
			
			       ps.setString(1, user.getMailid());
			       ps.setString(2, user.getCity());
			       ps.setString(3, user.getMobile());
			       ps.setString(4, user.getName());
			       ps.setString(5, user.getPword());
			       ps.setString(6, user.getRole());
			       
			    ps.executeUpdate();
			    
			    logger.debug("record is inserted in to data base using jdbc successfully");
			    
			    logger.info("exiting from saveuser :: RegisterjdbcDaoImpl" );

}
}