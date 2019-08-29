package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String usrId);

	public User findByEmail(String email);

	public User create(User emp);

	public User update(User emp);

	public void delete(User existing);
}
