package com.rest.webservice.restful_web_services.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restful_web_services.dao.UserDaoSevice;
import com.rest.webservice.restful_web_services.entity.HelloWorldBean;
import com.rest.webservice.restful_web_services.entity.Users;
import com.rest.webservice.restful_web_services.exceptions.UserNotFoundException;

@RestController
public class Controller {
	@Autowired
	private UserDaoSevice userDaoSevice;

//	public Controller(UserDaoSevice userDaoSevice) {
//		super();
//		this.userDaoSevice = userDaoSevice;
//	}
	@GetMapping("hello")
	public String helloWorld() {
		return "Hello Welcome to rest api";
	}

	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello_world");
	}

	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("hello world, %s", name));
	}

	@GetMapping("users")
	public List<Users> allUsers() {
		return userDaoSevice.findAll();
	}

	@PostMapping("users")
	public ResponseEntity<Users> CreateUser(@RequestBody Users user) throws URISyntaxException {
		Users savedUser = userDaoSevice.saveUsers(user);

		// Build the location URI for the newly created user
//        URI location = new URI("/users/" + savedUser.getId());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).body(savedUser);
	}

	@GetMapping("users/{id}")
	public Users allUsers(@PathVariable int id) {
		Users user = userDaoSevice.findById(id);
		if(user == null) {
			throw new UserNotFoundException("id:"+ id);
		}
		return user;
	}
////	@DeleteMapping("users/{id}")
////	public Users allUsers(@PathVariable int id) {
////		return new Users();
////	}
////	@GetMapping("users/{id}/posts")
////	public Users allUsers(@PathVariable int id) {
////		return new Users();
////	}
////	@PostMapping("users/{id}/posts")
////	public Users allUsers(@PathVariable int id) {
////		return new Users();
////	}
//
//	
//	@GetMapping("users/{id}/posts/{post_id}") 

}
