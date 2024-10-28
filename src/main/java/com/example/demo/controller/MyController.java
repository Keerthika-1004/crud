package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.pojo.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/EMS")
public class MyController {

	@Autowired
   UserService Service;
//	UserRepo repo;
	
//	Logger logger =LoggerFactory.getLogger(MyController.class);
	@GetMapping(path="/User")
	public ArrayList<User> getUser(){
		ArrayList<User> list=(ArrayList<User>)Service.findAll();
//		logger.debug("getting all the user details");
		return list;
	}
	@PostMapping(path="/CreateUser")
	public void insertUser(@RequestBody User emp) {
		//logger.debug("save the user details");
		Service.save(emp);
	}
	@GetMapping(path="/Users/{id}")
	public User getUser(@PathVariable int id){
//		logger.info("getting the particular user id",id);
		 return Service.find(id);
		
	}
	@DeleteMapping(path="/DeleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
//		logger.info("delete user details");
		return Service.delete(id);
	}
	@PutMapping(path="/UpdateUser")
	public String updateUser(@RequestBody User employee){
//		logger.info("update the user details");
		return Service.update(employee);
	
	}
}

