package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String empId) {
		return em.find(User.class, empId);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("uEmail", email);
		List<User> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User create(User emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public User update(User emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(User existing) {
		em.remove(existing);
	}
}