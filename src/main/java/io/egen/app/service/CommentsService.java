package io.egen.app.service;

import io.egen.app.entity.Comments;

public interface CommentsService {

	public Comments findOne(String rId);

	public Comments create(Comments c);

}
