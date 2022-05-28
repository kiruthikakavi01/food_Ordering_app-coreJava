package com.foodapp.dao;

import java.sql.SQLException;

public interface MenuDAO {
	void menuAdd() throws ClassNotFoundException, SQLException;
	void menuVegUpdatePrice() throws ClassNotFoundException, SQLException;
	void menuNonVegUpdatePrice()throws ClassNotFoundException, SQLException;
	void menuDelete()throws ClassNotFoundException,SQLException;
}
