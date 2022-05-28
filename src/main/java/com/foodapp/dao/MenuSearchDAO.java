package com.foodapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.foodapp.model.Menu;

public interface MenuSearchDAO {
	List<Menu> findAll() throws SQLException, ClassNotFoundException;
	Menu findById(int id) throws SQLException, ClassNotFoundException;
	Menu findByVegDishes(String vegDishes) throws SQLException;
	Menu findByNonVegDishes(String nonVegDishes) throws SQLException;
	int count() throws SQLException, ClassNotFoundException;
	List<Menu> displayVegDishes() throws SQLException, ClassNotFoundException;
	List<Menu> displayNonVegdishes() throws SQLException, ClassNotFoundException;
}
