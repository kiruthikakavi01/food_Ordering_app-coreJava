package com.foodapp;

import java.util.List;
import java.util.Scanner;

import com.foodapp.dao.MenuSearchDAO;
import com.foodapp.dao.MenuSearchDAOImpl;
import com.foodapp.dao.UserLoginDAO;
import com.foodapp.model.Menu;


public class UserLoginTest {
	
		public static void main(String[] args) throws Exception {
			//UserLoginDAO.login();
			MenuSearchDAO menuSearch=new MenuSearchDAOImpl();
			List<Menu> menus=menuSearch.findAll();
			for(Menu menu:menus) {
				System.out.println(menu);
			}
		}
}
