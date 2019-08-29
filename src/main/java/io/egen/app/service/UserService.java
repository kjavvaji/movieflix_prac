package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findOne(String usrId);

	public User create(User usr);

	public User update(String usrId, User usr);

	public void remove(String usrId);
}