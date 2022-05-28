package com.foodapp.validator;

import java.util.Scanner;

import com.foodapp.dao.UserDAO;
import com.foodapp.dao.UserDAOImpl;
import com.foodapp.model.User;

public class UserValidatorRegister {
	public static void userRegister() throws Exception {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name: ");
		String name = sc.next();
		user.setName(name);
		System.out.println("Enter your Email: ");
		String email = sc.next();
		user.setEmail(email);
		System.out.println("Enter your Contact Number: ");
		String contactNumber = sc.next();
		user.setContactNumber(contactNumber);
		System.out.println("Enter the Password: ");
		String createPassword = sc.next();
		user.setCreatePassword(createPassword);
		System.out.println("Enter Conform Password: ");
		String conformPassword = sc.next();
		user.setConformPassword(conformPassword);

		UserValidator.validatorUserDetails(user);
		UserDAO userDAO = new UserDAOImpl();
		userDAO.register(user);
	}
}
