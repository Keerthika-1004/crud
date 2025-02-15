package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
private int id;
public User() {
		super();
		// TODO Auto-generated constructor stub
	}
private String name;
private int salary;
private String address;
private String emailid;
public User(int id, String name, int salary, String address, String emailid) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.address = address;
	this.emailid = emailid;
}
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
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
	
}
