package com.navin.Commentcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navin.Constants.controllerCommentMessages;
import com.navin.entity.Comment;
import com.navin.reponse.CommentResponseHandler;
import com.navin.service.commentService;

@RestController
@RequestMapping("/comment")
public class commentController {

	@Autowired
	private commentService commentService;
	
	private ResponseEntity<?> message = null;

	@GetMapping("/msg")
	public String getMessage(String msg) {
		return "Welcome Comments Rest Controller";
	}

	@PostMapping("/saveComment")
	public ResponseEntity<?> createComment(@RequestBody Comment comment) {
		Comment com = null;
		try {
			com = commentService.saveComment(comment);
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.SAVE_COMMENT_SUCCESS_DETAILS,
					HttpStatus.CREATED, com.getCommentid());
//			return new ResponseEntity<Comment>(com, HttpStatus.CREATED);
		} catch (Exception e) {
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.SAVE_COMMENT_ERROR_DETAILS,
					HttpStatus.INTERNAL_SERVER_ERROR, com.getCommentid());
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@GetMapping("/getAllComment")
	public ResponseEntity<?> getAllComments() {
		List<Comment> allComment = null;
		allComment = commentService.getAllComment();
		if (allComment != null && allComment.isEmpty()) {
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.GETALL_COMMENT_SUCCESS_DETAILS,
					HttpStatus.CREATED, allComment);
		} else {
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.GETALL_COMMENT_ERROR_DETAILS,
					HttpStatus.NO_CONTENT, allComment);
		}
		return message;
//			return new ResponseEntity<List<Comment>>(allComment, HttpStatus.OK);
	}
	
	@GetMapping("/getByIdComment/{commentId}")
	public ResponseEntity<?> getByCommentId(@PathVariable Integer commentId) {
		Comment commentById = null;
		try {
			commentById = commentService.getByCommentId(commentId);
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.GETBYID_COMMENT_SUCCESS_DETAILS,
					HttpStatus.OK, commentById);
//		return new ResponseEntity<Comment>(commentById,HttpStatus.OK);
		} catch (Exception e) {
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.GETBYID_COMMENT_ERROR_DETAILS,
					HttpStatus.BAD_REQUEST, commentById);
		}
		return message;
	}

	@PutMapping("/updateByIdComment")
	public ResponseEntity<?> updateComment(@PathVariable Integer commentId, @RequestBody Comment comment) {
		Comment updateComment = null;
		try {
			updateComment = commentService.updateComment(commentId, comment);
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.UPDATE_COMMENT_SUCCESS_DETAILS,
					HttpStatus.CREATED, updateComment);
//			return new ResponseEntity<Comment>(updateComment, HttpStatus.OK);
		} catch (Exception e) {
			message = CommentResponseHandler.commentReponseBuilder(
					controllerCommentMessages.UPDATE_COMMENT_ERROR_DETAILS, HttpStatus.INTERNAL_SERVER_ERROR, updateComment);
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return message;
	}

	@DeleteMapping("/deleteById/{commentId}")
	public ResponseEntity<?> deleteByCommentId(@PathVariable Integer commentId) {
		try {
		commentService.deleteByCommentId(commentId);
		message =  CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.DELETE_COMMENT_SUCESS_DETAILS,
				HttpStatus.CREATED, commentId);
		}catch(Exception e) {
			message = CommentResponseHandler.commentReponseBuilder(controllerCommentMessages.DELETE_COMMENT_ERROR_DETAILS,
					HttpStatus.CREATED, commentId);
		}
		return message;
//		return  ResponseEntity.noContent().build();
	}
}
