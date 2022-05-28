package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.foodapp.home.ListMenus;
import com.foodapp.util.ConnectionUtil;

public class UserLoginDAO {
	public static void login() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the email: ");
		String email=sc.next();
		System.out.println("Enter the Password: ");
		String password=sc.next();
		Connection connection = null;
		PreparedStatement statement = null;
		connection = ConnectionUtil.getConnection();
		String query = "select S_N0,Email,Conform_Password from Food_Ordering_App_User_Register_Form where Email= ?";
		statement = connection.prepareStatement(query);
		statement.setString(1,email);
		ResultSet result = statement.executeQuery();
		
		int id=0;
		String userEmail = null;
		String userPassword = null;
		while (result.next()) {
			id=result.getInt("S_N0");
			userEmail = result.getString("Email");
			userPassword = result.getString("Conform_Password");
		}
		if (userEmail == null) {
			System.err.println("No records found - please register");
		} else if (userPassword.equals(password)) {
			System.out.println("Login Sucessful.."+"\n");
			System.out.println("WELCOME TO FOOD ORDERING APP"+"\n");
			ListMenus.listMenu(id);
	
			
		} 
		else{
			System.err.println("Invalid Data");
			
			login();
		}
	}
}
