package com.foodapp.home;

import java.sql.SQLException;
import java.util.Scanner;

import com.foodapp.dao.OrderFoodDAO;


public class BackOrNext {
	public static void backOrNext(int id) throws SQLException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("\n");
		System.out.println("Enter 1 for Go back");
		System.out.println("Enter 2 for Veg Odering");
		System.out.println("Enter 3 for Non Veg Ordering:");
		
		System.out.println("Enter Option:");
		int n=sc.nextInt();
		OrderFoodDAO orderFood=new OrderFoodDAO();
		if(n==1) {
			ListMenus.listMenu(id);
		}
		else if(n==2) {
			orderFood.foodOderingVeg(id);
		}else if(n==3) {
			orderFood.foodOderingNonVeg(id);
			
			
		}
		
	}
	public static void adminGoBack() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for Go Back :");
		System.out.println("Enter 2 for To exist page");
		int n=sc.nextInt();
		if(n==1) {
			AdminUpdate.adminUpdate();
		}else if(n==2) {
			System.out.println("Thanks for coming.... ");
		}
	}
}
