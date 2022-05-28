package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.foodapp.home.BackOrNext;
import com.foodapp.home.Transaction;
import com.foodapp.util.ConnectionUtil;

public class OrderFoodDAO {
	public static int id;
	public static int fid;
	public static String userName;

	public void foodOderingVeg(int id) throws SQLException {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter foodId to Order:");
			fid = sc.nextInt();
			this.id=id;
			Connection connection = null;
			PreparedStatement statement = null;
			Statement statement1 = null;
			ResultSet rs = null;
			ResultSet rs1 = null;

			connection = ConnectionUtil.getConnection();
			String query1 = "SELECT Veg_dishes,Veg_Dishes_price FROM Food_Ordering_App_Menus WHERE id=?";
			statement = connection.prepareStatement(query1);
			statement.setInt(1, fid);
			rs = statement.executeQuery();
			String vegDish = null;
			Integer vegDishPrice = 0;
			while (rs.next()) {
				vegDish = rs.getString("Veg_dishes");
				vegDishPrice = rs.getInt("Veg_Dishes_price");

			}

			String query2 = "SELECT Full_name FROM Food_Ordering_App_User_Register_Form WHERE S_N0=?";
			statement = connection.prepareStatement(query2);
			statement.setInt(1, id);
			rs1 = statement.executeQuery();
			if (rs1.next()) {
				userName = rs1.getString("Full_name");

			}
			System.out.println("Enter the address:");
			//Scanner sc=new Scanner(System.in);
			String address = sc.nextLine();

			String query3 = "insert into Order_Food(food_id,user_id,Username,User_address,Ordered_food,Bill_Amount)values("
					+ fid + "," + id + ",'" + userName + "','" + address + "','" + vegDish + "'," + vegDishPrice + ")";

			statement1 = connection.createStatement();
			int rows = statement1.executeUpdate(query3);
			if (rows == 1) {
				System.out.println("Ordered" + "\n");
			}
			System.out.println("Enter 1 for continue odering:");
			System.out.println("Enter 2 for Payment");
			int n = sc.nextInt();
			int countOfOrdered=0;
			int totalAmount=0;
			if (n == 1) {
				BackOrNext.backOrNext(id);
			} else if (n == 2) {
				OrderFoodDAO orderFood = new OrderFoodDAO();
				countOfOrdered=orderFood.OrderFoodCount(id);
				totalAmount = orderFood.OrderFoodAmount(id);
				System.out.println("Ordered items count:"+countOfOrdered);
				System.out.println("Your total Amount:" + totalAmount);
				Transaction.transactionDetails(totalAmount);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void foodOderingNonVeg(int id) {

		try {
			Scanner sc1 = new Scanner(System.in);

			System.out.println("Enter foodId to Order:");
			fid = sc1.nextInt();
			this.id=id;
			Connection connection = null;
			PreparedStatement statement = null;
			Statement statement1 = null;
			ResultSet rs = null;
			ResultSet rs1 = null;

			connection = ConnectionUtil.getConnection();
			String query1 = "SELECT Non_Veg_dishes,Non_Veg_dishes_price FROM Food_Ordering_App_Menus WHERE id=?";
			statement = connection.prepareStatement(query1);
			statement.setInt(1, fid);
			rs = statement.executeQuery();
			String nonVegDish = null;
			Integer nonVegDishPrice = 0;
			while (rs.next()) {
				nonVegDish = rs.getString("Non_Veg_dishes");
				nonVegDishPrice = rs.getInt("Non_Veg_dishes_price");
				// System.out.format("%d \t\t %s \t\t %d",fId,vegDish,vegDishPrice);
			}

			String query2 = "SELECT Full_name FROM Food_Ordering_App_User_Register_Form WHERE S_N0=?";
			statement = connection.prepareStatement(query2);
			statement.setInt(1, id);
			rs1 = statement.executeQuery();
			String userName = null;
			if (rs1.next()) {
				userName = rs1.getString("Full_name");

			}
			Scanner sc1Obj=new Scanner(System.in);
			System.out.println("Enter the address:");
			String address = sc1Obj.nextLine();

			String query3 = "insert into Order_Food(food_id,user_id,Username,User_address,Ordered_food,Bill_Amount)values("
					+ fid + "," + id + ",'" + userName + "','" + address + "','" + nonVegDish + "'," + nonVegDishPrice
					+ ")";

			statement1 = connection.createStatement();
			int rows = statement1.executeUpdate(query3);
			if (rows == 1) {
				System.out.println("Ordered" + "\n");
			}
			System.out.println("Enter 1 for continue odering:");
			System.out.println("Enter 2 for Payment");
			int n = sc1.nextInt();
			int countOfOrdered=0;
			int totalAmount=0;
			if (n == 1) {
				BackOrNext.backOrNext(id);
			} else if (n == 2) {
				OrderFoodDAO orderFood = new OrderFoodDAO();
				countOfOrdered=orderFood.OrderFoodCount(id);
				totalAmount = orderFood.OrderFoodAmount(id);
				System.out.println("Ordered items count:"+countOfOrdered);
				System.out.println("Your total Amount:" + totalAmount);
				Transaction.transactionDetails(totalAmount);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int OrderFoodAmount(int id) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		connection = ConnectionUtil.getConnection();
		String query = "SELECT SUM(Bill_Amount) As Total_Amount FROM Order_Food WHERE user_id=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		rs = statement.executeQuery();
		int totalAmount = 0;
		if (rs.next()) {
			totalAmount = rs.getInt("Total_Amount");
		}
		return totalAmount;

	}
	public int OrderFoodCount(int id) throws SQLException, ClassNotFoundException{
		Connection connection=null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		connection = ConnectionUtil.getConnection();
		String query = "SELECT COUNT(user_id) AS OrderedFood FROM Order_Food WHERE user_id=?";
		statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		rs = statement.executeQuery();
		int countOfOrdered=0;
		if(rs.next()) {
			countOfOrdered=rs.getInt("OrderedFood");
		}
		return countOfOrdered;
		
	}
}
