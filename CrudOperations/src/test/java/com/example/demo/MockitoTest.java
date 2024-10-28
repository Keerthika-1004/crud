package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class MockitoTest {
	@InjectMocks
	private UserService Service;
	@Mock
	private UserRepo repo;

	public User myemployee;

	@Test
	@Order(1)
	public void getAll() {
		ArrayList<User> emp = new ArrayList<>();
		emp.add(new User(1, "Sailesh", 2000, "sail@gmail.com", "Atlantic"));
		emp.add(new User(2, "Dk", 3000, "dk@gmail.com", "Royapetah"));
		when(repo.findAll()).thenReturn(emp);
		assertEquals(emp, Service.findAll());	
	}

	@Test
	@Order(2)
	public void save() {
		User employee = new User(2, "Dk", 3000, "dk@gmail.com", "Royapetah");
//		myemployee = new User(2, "Dk", 3000, "dk@gmail.com", "Royapetah");
		when(repo.save(employee)).thenReturn(employee);
		assertEquals("User added successfully", Service.save(employee));

	}


	 @Test
	@Order(3)
//	 public void find() {
//		 User employee = new User();
//		 employee.setId(2);
//		 when(repo.findById(employee.getId())).thenReturn(Optional.of(employee));
//		 User expected = Service.find(employee.getId());
//		 assertThat(expected).isSameAs(employee);
//	 }
	 
	 public void find() {
		 User employee = new User(2, "Dk", 4000, "dk@gmail.com", "Royapetah");
		 when(repo.findById(employee.getId())).thenReturn(Optional.of(employee));
		 assertEquals(employee, Service.find(employee.getId()));
	 }

	@Test
	@Order(4)
	public void update() {
		User myemployee = new User(2, "Dk", 4000, "dk@gmail.com", "Royapetah");
		when(repo.findById(myemployee.getId())).thenReturn(Optional.of(myemployee));
		assertEquals("User updated successfully", Service.update(myemployee));
	}
	
	@Test
	@Order(5)
	public void delete() {
		User emp = new User(2, "Dk", 3000, "dk@gmail.com", "Royapetah");
		when(repo.findById(emp.getId())).thenReturn(Optional.of(emp));
		assertEquals("employee deleted successfully", Service.delete(emp.getId()) );
	}
	
}
