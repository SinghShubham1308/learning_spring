package com.rest.webservice.restful_web_services.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import jakarta.validation.Valid;

@RestController
public class Controller {
	@Autowired
	private UserDaoSevice userDaoSevice;
	private MessageSource messageSource;

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
	public ResponseEntity<Users> CreateUser(@Valid @RequestBody Users user) throws URISyntaxException {
		Users savedUser = userDaoSevice.saveUsers(user);

		// Build the location URI for the newly created user
//        URI location = new URI("/users/" + savedUser.getId());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).body(savedUser);
	}

// localhost:8080/users/1
//	EntityModel
//	WebMvcLinkBuilder
	@GetMapping("users/{id}")
	public EntityModel<Users> searchUsersById(@PathVariable int id) {
		Users user = userDaoSevice.findById(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		EntityModel<Users> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(getClass()).allUsers());  
		entityModel.add(linkBuilder.withRel("all-users"));
		return entityModel;

	}

	@DeleteMapping("users/{id}")
	public Users DeleteUser(@PathVariable int id) {
		Users user = userDaoSevice.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		return user;
	}

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
	@GetMapping("helloInternational")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default Message", locale);
//		return "Hello Welcome to rest api";
	}

	public Controller(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

}
