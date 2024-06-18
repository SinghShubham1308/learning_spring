package com.rest.webservice.restful_web_services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservice.restful_web_services.entity.Name;
import com.rest.webservice.restful_web_services.entity.PersonV1;
import com.rest.webservice.restful_web_services.entity.PersonV2;

@RestController
public class VersioningController {

	@GetMapping("v1/person")
	public PersonV1 getVersionOfPersonV1() {
		return new PersonV1("bob Charlie");
	}
	@GetMapping("v2/person")
	public PersonV2 getVersionOfPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "person",params = "version=1")
	public PersonV1 getVersionOfPersonRequestParamV1() {
		return new PersonV1("bob Charlie");
	}
	@GetMapping(path = "person",params = "version=2")
	public PersonV2 getVersionOfPersonRequestParamV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	@GetMapping(path = "person/header",headers = "X-API-version=1")
	public PersonV1 getVersionOfPersonRequestHeaderV1() {
		return new PersonV1("bob Charlie");
	}
}
