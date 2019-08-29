package io.egen.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Ratings;

import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.RatingsRepository;

@Service
public class RatingsServiceImp implements RatingsService {

	@Autowired
	private RatingsRepository repository;

	
	@Override
	public Ratings findOne(String rId) {
		Ratings r = repository.findOne(rId);
		if (r == null) {
			throw new EntityNotFoundException("Ratings not found");
		}
		return r;
	}

	@Transactional
	@Override
	public Ratings create(Ratings r) {
		
		return repository.create(r);
	}

}