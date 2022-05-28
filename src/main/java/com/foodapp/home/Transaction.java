package com.foodapp.home;

import java.sql.SQLException;
import java.util.Scanner;

import com.foodapp.dao.OrderFoodDAO;
import com.foodapp.dao.TransactionDAO;


public class Transaction {
	public static int paymentType=0;
	public static void transactionDetails(int totalAmount) throws SQLException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the transaction mode:");
		System.out.println("1.Cash on Delivery");
		System.out.println("2.upi id:");
		int n=sc.nextInt();
		//int paymentType=
		if(n==1) {
			paymentType=n;
			OrderFoodDAO order=new OrderFoodDAO();
			TransactionDAO transactionDAO=new TransactionDAO();
			transactionDAO.transaction(order);
			//System.out.println("Ordered Sucessfull...");
		}else if(n==2) {
			paymentType=n;
			Transaction.upiId(totalAmount);
		}
	}
	public static void upiId(int totalAmount) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the upi pin:");
		String upiPin=sc.next();
		if(upiPin.contains("@")&&upiPin.contains(".")) {
			System.out.println("Enter the amount:");
			int amount=sc.nextInt();
			if(amount==totalAmount) {
			System.out.println("Payment and Ordered Successfull");
			}else {
				System.out.println("enter the valid amount");
				int amount1=sc.nextInt();
				if(amount1==totalAmount) {
					System.out.println("Payment and Ordered Successfull");
				}else {
				Transaction.upiId(totalAmount);
				}
			}
		}else {
			System.out.println("Enter valid upi pin");
			Transaction.upiId(totalAmount);
		}
	}
}
