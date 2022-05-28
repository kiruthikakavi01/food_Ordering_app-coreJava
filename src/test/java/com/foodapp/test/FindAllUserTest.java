package com.foodapp.test;

import java.sql.SQLException;
import java.util.List;

import com.foodapp.dao.UserDAO;
import com.foodapp.dao.UserDAOImpl;
import com.foodapp.model.User;

public class FindAllUserTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		UserDAO userDAO=new UserDAOImpl();
       List<User> userLists=userDAO.findAllUser();
       for(User userList:userLists) {
    	   System.out.println(userList);
       }
	}

}
