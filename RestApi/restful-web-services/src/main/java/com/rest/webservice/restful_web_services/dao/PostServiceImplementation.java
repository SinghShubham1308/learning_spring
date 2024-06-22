package com.rest.webservice.restful_web_services.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservice.restful_web_services.entity.Post;

public interface PostServiceImplementation extends JpaRepository<Post,Integer>{

}
