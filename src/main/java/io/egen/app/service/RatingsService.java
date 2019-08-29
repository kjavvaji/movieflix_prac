package io.egen.app.service;



import io.egen.app.entity.Ratings;

public interface RatingsService {

	

	public Ratings findOne(String rId);

	public Ratings create(Ratings r);

	
}