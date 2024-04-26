package com.navin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.navin.entity.Comment;
import com.navin.repo.commentRepository;

@Service
public class commentServiceImpl implements commentService{
	
	@Autowired(required = true)
	@Qualifier("commentRepository")
	private commentRepository commentRepository;

	@Override
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
