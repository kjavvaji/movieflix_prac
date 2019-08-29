package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	//@Override
	//public Movie findOne(String mveId) {
	//	return em.find(Movie.class, mveId);
	//}

	@Override
	public Movie findByMovieTitle(String movieTitle) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByMovieTitle", Movie.class);
		query.setParameter("mtitle", movieTitle);
		List<Movie> movies = query.getResultList();
		if (movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie create(Movie mve) {
		em.persist(mve);
		return mve;
	}

	@Override
	public Movie update(Movie mve) {
		return em.merge(mve);
	}

	@Override
	public void delete(Movie existing) {
		em.remove(existing);
	}
}