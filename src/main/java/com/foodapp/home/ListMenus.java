package com.foodapp.home;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.foodapp.dao.MenuSearchDAO;
import com.foodapp.dao.MenuSearchDAOImpl;
import com.foodapp.model.Menu;



public class ListMenus {
	public static void listMenu(int id) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.err.println("You can Search by below option:"+"\n");
		System.out.println("1.To List Veg Dishes");
		System.out.println("2.To List Non Veg dishes");
		System.out.println("3.Search by nonVeg items");
		System.out.println("4.Search by Veg items"+"\n");
		System.out.println("Enter the opition to search:");
		int n = sc.nextInt();
		MenuSearchDAO menuSearch = new MenuSearchDAOImpl();
		 if (n == 1) {
			List<Menu> menu= menuSearch.displayVegDishes();
			for(Menu menus : menu) {
				System.out.println(menus);			}
			 System.out.println("\n");
			 BackOrNext.backOrNext(id);
			
		} else if (n == 2) {
			menuSearch.displayNonVegdishes();
			System.out.println("\n");
			BackOrNext.backOrNext(id);

		} else if (n == 3) {
			System.out.println("Enter the Non Veg Dish Name: ");
			String nonVegName = sc.next();
			menuSearch.findByNonVegDishes(nonVegName);
			BackOrNext.backOrNext(id);
			
		}else if(n==4) {
			System.out.println("Enter the Veg Dish Name:");
			String vegName=sc.next();
			menuSearch.findByVegDishes(vegName);
			BackOrNext.backOrNext(id);
			
		}
		
	}
}
