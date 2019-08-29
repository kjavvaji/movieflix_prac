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
		@NamedQuery(name = "Comments.findBymId", query = "SELECT c from Comments c where c.mId=:umid")
})

public class Comments {
	@Id
	private String cId;

	private String comments;
	
	private String mId;
	
	public Comments(){
    	cId = UUID.randomUUID().toString();
    }

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}



	@Override
	public String toString() {
		return "Comments [cId=" + cId + ", comments=" + comments + ", mId=" + mId + "]";
	}

	
	
}
