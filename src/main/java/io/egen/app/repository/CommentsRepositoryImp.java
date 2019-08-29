package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Comments;


@Repository
public class CommentsRepositoryImp implements CommentsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Comments findOne(String mId) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findBymId",Comments.class);
		query.setParameter("umid", mId);
		List<Comments> comments = query.getResultList();
		if (comments.size() == 1) {
			return comments.get(0);
		} else {
			return null;
		}
	}

	
	@Override
	public Comments create(Comments c) {
		em.persist(c);
		return c;
	}

}