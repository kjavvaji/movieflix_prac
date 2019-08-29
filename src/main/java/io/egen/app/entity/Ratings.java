package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Ratings.findBymId", query = "SELECT r from Ratings r where r.mId=:umid")
})

public class Ratings {
	@Id
	private String rId;

	private String ratingRange;
	
	private String mId;
	
	
	
	@Override
	public String toString() {
		return "Ratings [rId=" + rId + ", ratingRange=" + ratingRange + ", mId=" + mId + "]";
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}


	



	public Ratings(){
    	rId = UUID.randomUUID().toString();
    }

	
	public String getId() {
		return rId;
	}


	public void setId(String rId) {
		this.rId = rId;
	}


	public String getRatingRange() {
		return ratingRange;
	}


	public void setRatingRange(String ratingRange) {
		this.ratingRange = ratingRange;
	}


	



	
}
