package com.whatsapp.dao;

import java.util.List;

import com.whatsapp.pojo.User;

public interface ILoginDao {

	public List<User> getUserDetails(String mailid , String password);
	
	public List<User> getAllUsers();


}
