package com.navin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navin.Constants.serviceCommentMessages;
import com.navin.entity.Comment;
import com.navin.exception.commentNotFoundException;
import com.navin.repo.commentRepository;

@Service
public class commentServiceImpl implements commentService {

	@Autowired
//	@Qualifier("commentRepository")
	private commentRepository commentRepository;

	@Override
	public Comment saveComment(Comment comment) {
		try {
			return commentRepository.save(comment);
		} catch (Exception e) {
			throw new commentNotFoundException(serviceCommentMessages.GET_BY_COMMENTID + comment.getCommentid());
		}
	}

	@Override
	public Comment updateComment(Integer commentId, Comment comment) {
		Optional<Comment> commentById = commentRepository.findById(commentId);
		if (commentById.isPresent()) {
			Comment existingComment = commentById.get();
			existingComment.setComment_postid(existingComment.getComment_postid());
			existingComment.setComment_name(existingComment.getComment_name());
			existingComment.setComment_body(existingComment.getComment_body());
			Comment CommentUpdate = commentRepository.save(existingComment);
			return CommentUpdate;
		} else {
			Comment saveComment = commentRepository.save(comment);
			return saveComment;
		}
	}

	@Override
	public List<Comment> getAllComment() {
		try {
		List<Comment> allComments = commentRepository.findAll();
		return allComments;
		}catch(Exception e) {
			throw new commentNotFoundException(serviceCommentMessages.GETAll_COMMENT + e );
		}
	}

	@Override
	public Comment getByCommentId(Integer commentId) {
		try {
			Optional<Comment> commentById = commentRepository.findById(commentId);
			if (commentById.isPresent()) {
				Comment comment = commentById.get();
				return comment;
			} else {
				throw new commentNotFoundException(serviceCommentMessages.GET_BY_COMMENTID + commentId);
			}
		} catch (Exception e) {
			throw new commentNotFoundException(serviceCommentMessages.GET_BY_COMMENTID + commentId);
		}
	}

	@Override
	public void deleteByCommentId(Integer commentId) {
		try {
			commentRepository.deleteById(commentId);
		} catch (Exception e) {
			throw new commentNotFoundException(serviceCommentMessages.DELETE_BY_COMMENTID + commentId);
		}
	}

}
