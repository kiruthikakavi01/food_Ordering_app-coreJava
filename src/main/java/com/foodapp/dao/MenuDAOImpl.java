package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.foodapp.util.ConnectionUtil;

public class MenuDAOImpl implements MenuDAO{

	public void menuAdd() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Veg Dish:");
		String vegDish = sc.next();
		System.out.println("Enter the Veg Dish Price:");
		int vegDishPrice = sc.nextInt();
		System.out.println("Enter the Non Veg Dish:");
		String nonVegDish = sc.next();
		System.out.println("Enter the Non Veg Dish Price:");
		int nonVegDishPrice = sc.nextInt();

		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		connection = ConnectionUtil.getConnection();
		String sql = "INSERT INTO Food_Ordering_App_Menus (Veg_dishes,Veg_Dishes_price,Non_Veg_dishes,Non_Veg_dishes_price) VALUES (?,?,?,?)";
		statement = connection.prepareStatement(sql);
		statement.setString(1, vegDish);
		statement.setInt(2, vegDishPrice);
		statement.setString(3, nonVegDish);
		statement.setInt(4, nonVegDishPrice);
		rows = statement.executeUpdate();
		if (rows == 1) {
			System.out.println("Menu Inserted Sucessfully");
		}

		
	}

	public void menuVegUpdatePrice() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Veg Dish:");
		String vegDish = sc.next();
		System.out.println("Enter the Updated Price:");
		int vegDishPrice = sc.nextInt();
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		connection = ConnectionUtil.getConnection();
		String sql = "UPDATE Food_Ordering_App_Menus SET Veg_Dishes_price= ? Where Veg_dishes= ?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, vegDishPrice);
		statement.setString(2, vegDish);
		rows = statement.executeUpdate();
		if(rows==1) {
			System.out.println("Veg Dish Price Updated Sucessfully");
		}

		
	}

	public void menuNonVegUpdatePrice() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Non Veg Dish:");
		String nonVegDish = sc.next();
		System.out.println("Enter the Updated Price:");
		int nonVegDishPrice = sc.nextInt();
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		connection = ConnectionUtil.getConnection();
		String sql = "UPDATE Food_Ordering_App_Menus SET Non_Veg_dishes_price= ? Where Non_Veg_dishes= ?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1,nonVegDishPrice);
		statement.setString(2,nonVegDish);
		rows = statement.executeUpdate();
		if(rows==1) {
			System.out.println("Non Veg Dish Price Updated Sucessfully");
		}
		
	}

	public void menuDelete() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Menu id:");
		int menuId= sc.nextInt();
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		connection = ConnectionUtil.getConnection();
		String sql = "DELETE FROM Food_Ordering_App_Menus WHERE id=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1,menuId);
		rows = statement.executeUpdate();
		if(rows==1) {
			System.out.println("Dish Deleted Sucessfully");
		}

		
	}

}
