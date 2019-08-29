package io.egen.app.repository;



import io.egen.app.entity.Ratings;

public interface RatingsRepository {

	

	public Ratings findOne(String rId);

	public Ratings create(Ratings r);

	
}
