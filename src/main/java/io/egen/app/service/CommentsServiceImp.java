package io.egen.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Comments;

import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.CommentsRepository;

@Service
public class CommentsServiceImp implements CommentsService {

	@Autowired
	private CommentsRepository repository;

	
	@Override
	public Comments findOne(String rId) {
		Comments c = repository.findOne(rId);
		if (c == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		return c;
	}

	@Transactional
	@Override
	public Comments create(Comments c) {
		
		return repository.create(c);
	}

}