package io.egen.app.repository;

import io.egen.app.entity.Comments;

public interface CommentsRepository {

	public Comments findOne(String rId);

	public Comments create(Comments r);

}
