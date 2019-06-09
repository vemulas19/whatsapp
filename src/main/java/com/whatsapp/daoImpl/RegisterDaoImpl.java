package com.whatsapp.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


import com.whatsapp.controllers.RegisterController;
import com.whatsapp.dao.IRegisterDao;
import com.whatsapp.pojo.User;

//Dog class which implements Animal

public class RegisterDaoImpl implements IRegisterDao {
	
	final static Logger logger=Logger.getLogger(RegisterDaoImpl.class);
	
	public void saveUser(User user) throws  Exception {
		logger.info("entered in to save user :: RegisterDaoImpl");
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		logger.debug("session factory opened");
		Session session = sf.openSession();
		logger.debug("session opened");
		session.save(user);
		logger.debug("parsed user object in to database" + user.getMailid());
		session.beginTransaction().commit();
		session.close();
		logger.info("exited in to save user :: RegisterDaoImpl");
		
		
		
	}

}
