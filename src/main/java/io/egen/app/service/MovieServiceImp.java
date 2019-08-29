package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Movie;
import io.egen.app.exception.EntityAlreadyExistException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findByMovieTitle(String movieTitle) {
		Movie mve = repository.findByMovieTitle(movieTitle);
		if (mve == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return mve;
	}

	@Transactional
	@Override
	public Movie create(Movie mve) {
		Movie existing = repository.findByMovieTitle(mve.getTitle());
		if (existing != null) {
			throw new EntityAlreadyExistException("Movie already exists with this title");
		}
		return repository.create(mve);
	}

	@Transactional
	@Override
	public Movie update(String movieTitle, Movie mve) {
		Movie existing = repository.findByMovieTitle(movieTitle);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(mve);
	}

	@Transactional
	@Override
	public void remove(String movieTitle) {
		Movie existing = repository.findByMovieTitle(movieTitle);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}
}