package io.egen.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Comments;
import io.egen.app.service.CommentsService;

@RestController
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentsController {

	@Autowired
	private CommentsService service;

	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Comments findOne(@PathVariable("id") String cId) {
		return service.findOne(cId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments create(@RequestBody Comments cId) {
		return service.create(cId);
	}

	
}