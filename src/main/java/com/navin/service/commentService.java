package com.navin.service;

import java.util.List;

import com.navin.entity.Comment;

public interface commentService {

	public Comment saveComment(Comment comment);
	public Comment updateComment(Integer commentId,Comment comment);
	public List<Comment> getAllComment();
	public Comment getByCommentId(Integer commentId);
	public void deleteByCommentId(Integer commentId);
}
