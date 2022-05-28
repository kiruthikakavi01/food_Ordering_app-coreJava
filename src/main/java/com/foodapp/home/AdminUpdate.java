package com.foodapp.home;

import java.sql.SQLException;
import java.util.Scanner;

import com.foodapp.dao.*;




public class AdminUpdate {
	public static void adminUpdate() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.err.println("You can Insert/Update/Delete/List all menu and user by below steps:");
		System.out.println("1.To Insert Menu");
		System.out.println("2.To Update Veg Menu Price");
		System.out.println("3.To Update Non Veg Menu Price");
		System.out.println("4.To Delete Menu");
		System.out.println("5.To List all Menu");
		System.out.println("6.To List all User"+"\n");
		System.out.println("Enter the option:");
		int n = sc.nextInt();
		MenuDAO menuDAO=new MenuDAOImpl();
		if (n == 1) {
			menuDAO.menuAdd();
			System.out.println("\n");
			BackOrNext.adminGoBack();
		}else if(n==2) {
			menuDAO.menuVegUpdatePrice();
			System.out.println("\n");
			BackOrNext.adminGoBack();
		}else if(n==3) {
			menuDAO.menuNonVegUpdatePrice();
			System.out.println("\n");
			BackOrNext.adminGoBack();
			
		}else if(n==4) {
			menuDAO.menuDelete();
			System.out.println("\n");
			BackOrNext.adminGoBack();
		}else if(n==5) {
			MenuSearchDAO menuSearch = new MenuSearchDAOImpl();
			menuSearch.findAll();
			System.out.println("\n");
			BackOrNext.adminGoBack();
		}else if(n==6) {
			UserDAO userDAO=new UserDAOImpl();
			userDAO.findAllUser();
			System.out.println("\n");
			BackOrNext.adminGoBack();
		}
	}
}
