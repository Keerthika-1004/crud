package com.example.demo.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.pojo.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;

	public ArrayList<User> findAll() {
		ArrayList<User> alist = (ArrayList<User>) repo.findAll();
		return alist;
	}

	public String save(User emp) {
		User existingEmployee = repo.findById(emp.getId()).orElse(null);
		if (existingEmployee == null) {
			repo.save(emp);
			return "User added successfully";
		} else
			throw new UserAlreadyExistsException("User already exists!");
	}

	public User find(int id) {
		User existingEmployee = repo.findById(id).orElse(null);
		if (existingEmployee == null)
			throw new NoSuchElementException("No data found");
		else
			return repo.findById(id).get();

	}

	public String delete(int id) {
		User existingEmployee = repo.findById(id).orElse(null);

		if (existingEmployee != null) {
//			throw new NoSuchElementException("No Such Employee exists!");
			repo.deleteById(id);
			return "employee deleted successfully";

		} else
			throw new NoSuchElementException("none");
	}

//	public String delete(int id) {
//		repo.deleteById(id);
//		return "employee deleted successfully";
//	}

//	public ResponseEntity<User> delete(int id) {
//		repo.deleteById(id);
//		return new ResponseEntity<User>(HttpStatus.OK);
//	}
//	
	public String update(User emp) {
		User existingEmployee = repo.findById(emp.getId()).orElse(null);
		if (existingEmployee != null) {
			repo.save(emp);
			return "User updated successfully";
		} else
			throw new NoSuchElementException("User does not exists!");
	}

}
