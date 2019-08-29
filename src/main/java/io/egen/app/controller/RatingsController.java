package io.egen.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Ratings;
import io.egen.app.service.RatingsService;

@RestController
@RequestMapping(value = "ratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingsController {

	@Autowired
	private RatingsService service;

	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Ratings findOne(@PathVariable("id") String rId) {
		return service.findOne(rId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ratings create(@RequestBody Ratings rId) {
		return service.create(rId);
	}

	
}