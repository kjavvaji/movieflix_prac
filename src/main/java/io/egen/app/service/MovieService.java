package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findByMovieTitle(String movieTitle);

	public Movie create(Movie mve);

	public Movie update(String mveId, Movie mve);

	public void remove(String mveId);
}