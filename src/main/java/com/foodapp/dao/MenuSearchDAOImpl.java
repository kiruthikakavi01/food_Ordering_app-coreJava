package com.foodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Menu;
import com.foodapp.util.ConnectionUtil;

public class MenuSearchDAOImpl implements MenuSearchDAO {

	public List<Menu> findAll() throws SQLException, ClassNotFoundException {
		List<Menu> menuList = new ArrayList<Menu>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		connection = ConnectionUtil.getConnection();
		String sql = "select id,Veg_dishes,Veg_Dishes_price,Non_Veg_dishes,Non_Veg_dishes_price from Food_Ordering_App_Menus";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		System.err.println("\nId \t\t Veg_Dishes \t\t Veg_Dishes_Price \t\t Non_Veg_Dishes \t\t Non_Veg_Dishes_Price");
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String vegDishes = rs.getString("Veg_dishes");
			Integer vegDishesPrice = rs.getInt("Veg_Dishes_price");
			String nonVegDishes = rs.getString("Non_Veg_dishes");
			Integer nonVegDishesPrice = rs.getInt("Non_Veg_dishes_price");

			Menu menuObj = new Menu();
			menuObj.setId(id);
			menuObj.setVegDishes(vegDishes);
			menuObj.setVegDishesPrice(vegDishesPrice);
			menuObj.setNonVegDishes(nonVegDishes);
			menuObj.setNonVegDishesPrice(nonVegDishesPrice);
			//System.out.format("\n%d \t\t %s \t\t %d \t\t %s \t\t %d\n", id, vegDishes, vegDishesPrice, nonVegDishes,
					//nonVegDishesPrice);
			menuList.add(menuObj);

		}
		return menuList;	
	}

	public Menu findById(int id) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Menu menuObj = null;
		connection = ConnectionUtil.getConnection();
		String sql = "select * from Food_Ordering_App_Menus where id=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		rs = statement.executeQuery();
		if (rs.next()) {
			Integer menuId = rs.getInt("id");
			String vegDishe = rs.getString("Veg_dishes");
			Integer vegDishesPrice = rs.getInt("Veg_Dishes_Price");
			String nonVegDishes = rs.getString("Non_Veg_dishes");
			Integer nonVegDishesPrice = rs.getInt("Non_Veg_dishes_price");

			menuObj = new Menu();
			menuObj.setId(menuId);
			menuObj.setVegDishes(vegDishe);
			menuObj.setVegDishesPrice(vegDishesPrice);
			menuObj.setNonVegDishes(nonVegDishes);
			menuObj.setNonVegDishesPrice(nonVegDishesPrice);
		}
		return menuObj;	
	}

	public Menu findByVegDishes(String vegDishes) throws SQLException {
		
		try {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet rs = null;

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,Veg_dishes,Veg_Dishes_price FROM Food_Ordering_App_Menus WHERE Veg_dishes=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, vegDishes);
			rs = statement.executeQuery();
			System.err.println("\nId \t\t Veg_Dishes \t\t Veg_Dishes_Price");
			if (rs.next()) {
				Integer id = rs.getInt("id");
				String vegDishe = rs.getString("Veg_dishes");
				Integer vegDishesPrice = rs.getInt("Veg_Dishes_Price");

				// menuObj = new Menu();
				// menuObj.setId(id);
				// menuObj.setVegDishes(vegDishe);
				// menuObj.setVegDishesPrice(vegDishesPrice);
				System.out.format("\n%d \t\t %s \t\t %d\n", id, vegDishe, vegDishesPrice);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Menu findByNonVegDishes(String nonVegDishes) throws SQLException {
		
		try {

			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet rs = null;

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,Non_Veg_dishes,Non_Veg_dishes_price FROM Food_Ordering_App_Menus Where Non_Veg_dishes=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, nonVegDishes);
			rs = statement.executeQuery();
			System.err.println("\nId \t\t Non_Veg_Dishes \t\t Non_Veg_Dishes_Price");
			if (rs.next()) {
				Integer id = rs.getInt("id");
				String nonVegDishe = rs.getString("Non_Veg_dishes");
				Integer nonVegDishesPrice = rs.getInt("Non_Veg_dishes_price");

				System.out.format("\n%d \t\t %s \t\t %d\n", id, nonVegDishe, nonVegDishesPrice);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public int count() throws SQLException, ClassNotFoundException {
		
		Integer count = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		connection = ConnectionUtil.getConnection();
		String sql = "select count(*) AS cnt from Food_Ordering_App_Menus";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		if (rs.next()) {
			count = rs.getInt("cnt");
		}
		return count;
	}

	public List<Menu> displayVegDishes() throws SQLException, ClassNotFoundException {
		
		List<Menu> menuList = new ArrayList<Menu>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		connection = ConnectionUtil.getConnection();
		String sql = "select id,Veg_dishes,Veg_Dishes_price from Food_Ordering_App_Menus";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		System.err.println("\nId \t\t Veg_Dishes \t\t Veg_Dishes_Price");
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String vegDishes = rs.getString("Veg_dishes");
			Integer vegDishesPrice = rs.getInt("Veg_Dishes_Price");

			Menu menuObj = new Menu();
			menuObj.setId(id);
			menuObj.setVegDishes(vegDishes);
			menuObj.setVegDishesPrice(vegDishesPrice);

			//System.out.format("\n%d \t\t %s \t\t %d\n", id, vegDishes, vegDishesPrice);
			menuList.add(menuObj);

		}
		return menuList;
	}

	public List<Menu> displayNonVegdishes() throws SQLException, ClassNotFoundException {
		
		List<Menu> menuList = new ArrayList<Menu>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		connection = ConnectionUtil.getConnection();
		String sql = "select id,Non_Veg_dishes,Non_Veg_dishes_price FROM Food_Ordering_App_Menus";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		System.err.println("\nId \t\t Non_Veg_Dishes \t\t Non_Veg_Dishes_Price");
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String nonVegDishes = rs.getString("Non_Veg_dishes");
			Integer nonVegDishesPrice = rs.getInt("Non_Veg_dishes_price");

			Menu menuObj = new Menu();
			menuObj.setId(id);
			menuObj.setNonVegDishes(nonVegDishes);
			menuObj.setNonVegDishesPrice(nonVegDishesPrice);

			System.out.format("\n%d \t\t %s \t\t %d\n", id, nonVegDishes, nonVegDishesPrice);
			menuList.add(menuObj);

		}
		return menuList;
	}
}
