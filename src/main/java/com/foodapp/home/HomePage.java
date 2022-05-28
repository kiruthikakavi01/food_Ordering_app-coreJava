package com.foodapp.home;

import java.util.Scanner;

import com.foodapp.dao.AdminLoginDAO;
import com.foodapp.dao.UserLoginDAO;

import com.foodapp.validator.UserValidatorRegister;

public class HomePage {
	public static void homePage() throws Exception {
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.signUp");
		System.out.println("2.Login");
		System.out.println("3.Admin Login"+"\n");
		System.out.println("Enter the signUp/login number:");
		
		int n=sc.nextInt();
		if(n==1) {
			UserValidatorRegister.userRegister();
		}
		else if(n==2) {
			UserLoginDAO.login();
		}else if(n==3) {
			AdminLoginDAO.adminLogin();
		}
		sc.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	
	}
}
