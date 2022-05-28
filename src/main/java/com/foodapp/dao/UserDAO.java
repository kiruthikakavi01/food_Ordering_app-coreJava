package com.foodapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.foodapp.model.User;

public interface UserDAO {
	void register(User user) throws ClassNotFoundException, SQLException, Exception;
	//find all user
	List<User> findAllUser() throws SQLException, ClassNotFoundException;
}
