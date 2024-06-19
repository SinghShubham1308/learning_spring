package com.rest.webservice.restful_web_services.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservice.restful_web_services.entity.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("filtering")
	public MappingJacksonValue filtering() {
				
		SomeBean someBean = new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		extracted(mappingJacksonValue);
		return mappingJacksonValue;
	}
	@GetMapping("filtering-list")
	public MappingJacksonValue filteringList() {
		List<SomeBean> asList = Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value4","value5","value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		extracted(mappingJacksonValue);
		return mappingJacksonValue;
	}
	private void extracted(MappingJacksonValue mappingJacksonValue) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2","value3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFiletr", filter );
		mappingJacksonValue.setFilters(filters );
	}
}
