package com.rest.webservice.restful_web_services.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservice.restful_web_services.entity.Users;

public interface UserServiceImplementation extends JpaRepository<Users,Integer>{

}
