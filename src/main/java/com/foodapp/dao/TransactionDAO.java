package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.foodapp.home.Transaction;
import com.foodapp.util.ConnectionUtil;

public class TransactionDAO {
	private static java.sql.Date getCurrentDate(){
		java.util.Date today=new java.util.Date();
		return new java.sql.Date(today.getTime());
		
	}
	public void transaction(OrderFoodDAO order) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		int rows = 0;
		connection = ConnectionUtil.getConnection();
		String sql = "INSERT INTO Transactiion_Details (user_id,food_id,User_name,payment_type,date) VALUES (?,?,?,?,?)";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, order.id);
		statement.setInt(2, order.fid);
		statement.setString(3,order.userName);
		statement.setInt(4, Transaction.paymentType);
		statement.setDate(5,getCurrentDate());
		rows=statement.executeUpdate();
		if (rows == 1) {
			System.out.println("Order sucessfull");
		}
		
	}
}
