package com.whatsapp.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.whatsapp.dao.ILoginDao;
import com.whatsapp.pojo.User;

public class LoginDaoImpl implements ILoginDao{

	public List<User> getUserDetails(String mailid, String password) {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from User where mailid = :mail and pword = :password");
		//select *from user where mailid = 'dhoni@gmail.com' and pword='sakshi@123'
		query.setParameter("mail", mailid);
		query.setParameter("password", password);
		List list = query.list();
		
		session.close();
		return list;
		
		
	}

	public List<User> getAllUsers() {

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Query queryAllUsers = session.createQuery("from User");
		
		List<User> userList = queryAllUsers.list();
		
		session.close();
		
		return userList;
	}

}
