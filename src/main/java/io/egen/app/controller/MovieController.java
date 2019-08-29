package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Movie;
import io.egen.app.service.MovieService;
@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

@Autowired
private MovieService service;
@RequestMapping(method = RequestMethod.GET)
public List<Movie> findAll() {
	return service.findAll();
}

@RequestMapping(method = RequestMethod.GET, value = "{mId}")
public Movie findOne(@PathVariable("mId") String movieTitle) {
	return service.findByMovieTitle(movieTitle);
}

@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Movie create(@RequestBody Movie mve) {
	return service.create(mve);
}

@RequestMapping(method = RequestMethod.PUT, value = "{mId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public Movie update(@PathVariable("mId") String mveId, @RequestBody Movie mve) {
	return service.update(mveId, mve);
}

@RequestMapping(method = RequestMethod.DELETE, value = "{mId}")
public void delete(@PathVariable("mId") String mveId) {
	service.remove(mveId);
}



}
