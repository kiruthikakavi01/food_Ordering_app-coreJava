package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.foodapp.model.User;
import com.foodapp.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	public void register(User user) throws ClassNotFoundException, SQLException, Exception {
		
	    Connection connection = null;
		PreparedStatement statement = null;

		connection = ConnectionUtil.getConnection();
	    String sql="INSERT INTO Food_Ordering_App_User_Register_Form(Full_name,Email,Contact_number,Create_Password,Conform_Password) VALUES(?,?,?,?,?)";
	    statement=connection.prepareStatement(sql);
	    statement.setString(1,user.getName());
	    statement.setString(2,user.getEmail());
	    statement.setString(3,user.getContactNumber());
	    statement.setString(4,user.getCreatePassword());
	    statement.setString(5,user.getConformPassword());
	
	    int rows=statement.executeUpdate();
	    if(rows==1) {
	    	System.out.println("Register sucessful"+"\n");
	    	System.out.println("WELCOME TO LOGIN PAGE"+"\n");
	    	//UserLoginTest userLoginTest = new UserLoginTest();
	    	//userLoginTest.userLogin();
	    	UserLoginDAO.login();
	
	    }
	    
	    statement.close();
	    connection.close();
	    
	    		
		
	}

	public List<User> findAllUser() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
        List<User> listUser=new ArrayList<User>();
		connection = ConnectionUtil.getConnection();
		String query=" SELECT S_N0,Full_name,Email,Contact_number,Conform_Password FROM Food_Ordering_App_User_Register_Form";
		statement = connection.prepareStatement(query);
		rs = statement.executeQuery();
		System.err.println("\nS.No \t\t\t Full_Name \t\t\t Email \t\t\t\t ContactNumber \t\t Conform_Password");
		while (rs.next()) {
			Integer id = rs.getInt("S_N0");
			String fullName = rs.getString("Full_name");
			String email = rs.getString("Email");
			String contactNumber = rs.getString("Contact_number");
			String conformPassword = rs.getString("Conform_Password");
            User user=new User();
            user.setId(id);
            user.setName(fullName);
            user.setEmail(email);
            user.setContactNumber(contactNumber);
            user.setConformPassword(conformPassword);
			listUser.add(user);
			//System.out.format("\n%d \t\t %s \t\t %s \t\t %s \t\t %s\n", id, fullName, email, contactNumber,
					//conformPassword);
			
		}
		return listUser;
		
	}

}
