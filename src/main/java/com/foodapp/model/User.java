package com.foodapp.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String contactNumber;
	private String createPassword;
	private String conformPassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCreatePassword() {
		return createPassword;
	}
	public void setCreatePassword(String createPassword) {
		this.createPassword = createPassword;
	}
	public String getConformPassword() {
		return conformPassword;
	}
	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}
	@Override
	public String toString() {
		return  id + "\t\t\t" + name + "\t\t\t" + email + "\t\t\t" + contactNumber
				 + "\t\t\t" + conformPassword ;
	}
	
}
