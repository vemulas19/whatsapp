package com.whatsapp.dao;

import com.whatsapp.pojo.User;

//Animal interface (polymorphism concept)
public interface IRegisterDao {
	
	public void saveUser(User user) throws Exception;

}
