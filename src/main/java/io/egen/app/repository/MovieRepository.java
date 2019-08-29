package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	

	public Movie findByMovieTitle(String movieTitle);

	public Movie create(Movie emp);

	public Movie update(Movie emp);

	public void delete(Movie existing);
}
