package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Ratings;


@Repository
public class RatingsRepositoryImp implements RatingsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Ratings findOne(String mId) {
		TypedQuery<Ratings> query = em.createNamedQuery("Ratings.findBymId", Ratings.class);
		query.setParameter("umid", mId);
		List<Ratings> ratings = query.getResultList();
		if (ratings.size() == 1) {
			return ratings.get(0);
		} else {
			return null;
		}
	}

	
	@Override
	public Ratings create(Ratings r) {
		em.persist(r);
		return r;
	}

}