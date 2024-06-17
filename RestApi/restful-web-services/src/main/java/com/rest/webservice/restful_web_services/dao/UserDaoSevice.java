package com.rest.webservice.restful_web_services.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.webservice.restful_web_services.entity.Users;

@Component
public class UserDaoSevice {
	private static List<Users> users = new ArrayList<Users>();
	private static int countUser = 0;
	static {
		users.add(new Users(++countUser, "Shubham", LocalDate.now().minusYears(30)));
		users.add(new Users(++countUser, "Ritik", LocalDate.now().minusYears(35)));
		users.add(new Users(++countUser, "Abhishek", LocalDate.now().minusYears(25)));
	}

	public List<Users> findAll() {
		return users;
	}

	public Users findById(int id) {
		Predicate<? super Users> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public Users deleteById(int id) {
		 Predicate<? super Users> predicate = user -> user.getId() == id;
		    Optional<Users> userToDelete = users.stream().filter(predicate).findFirst();
		    
		    if (userToDelete.isPresent()) {
		        users.removeIf(predicate);
		        return userToDelete.get();
		    }
		    
		    return null; // or throw an exception if preferred
	}
	public Users saveUsers(Users user) {
		user.setId(++countUser);
		users.add(user);
		return user;
	}
}
