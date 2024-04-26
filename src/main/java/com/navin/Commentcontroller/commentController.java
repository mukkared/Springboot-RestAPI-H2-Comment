package com.navin.Commentcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.navin.reponse.commentResponseHandler;
import com.navin.service.commentService;

@RestController
@RequestMapping("/comment")
public class commentController {

	@Autowired
//	@Qualifier("commentService")
	private commentService commentService;
	

	@GetMapping("/msg")
	public String getMessage(String msg) {
		return "Welcome Comments Rest Controller";
	}
	
	@PostMapping("/createComment")
	public ResponseEntity<Object> createComment(@RequestBody Comment comment){
		try {
			Comment com = commentService.saveComment(comment);
			return commentResponseHandler.commentReponseBuilder(controllerCommentMessages.SAVE_COMMENT_DETAILS, HttpStatus.CREATED, com);
//			return new ResponseEntity<Comment>(com, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{updateById}")
	public ResponseEntity<Object> updateComment(@PathVariable Integer commentId, @RequestBody Comment comment){
		try {
			Comment updateComment = commentService.updateComment(commentId, comment);
			return commentResponseHandler.commentReponseBuilder(controllerCommentMessages.UPDATE_COMMENT_DETAILS, HttpStatus.CREATED, updateComment);
//			return new ResponseEntity<Comment>(updateComment, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllComments(){
		List<Comment> allComment = commentService.getAllComment();
		return commentResponseHandler.commentReponseBuilder(controllerCommentMessages.GET_COMMENT_DETAILS, HttpStatus.CREATED, allComment);
//		return new ResponseEntity<List<Comment>>(allComment, HttpStatus.OK);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Object> getByCommentId(@PathVariable Integer commentId){
		Comment commentById = commentService.getByCommentId(commentId);
		return commentResponseHandler.commentReponseBuilder(controllerCommentMessages.COMMENT_BY_ID, HttpStatus.OK, commentById);
//		return new ResponseEntity<Comment>(commentById,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<Object> deleteByCommentId(@PathVariable Integer commentId){
		commentService.deleteByCommentId(commentId);
		return commentResponseHandler.commentReponseBuilder(controllerCommentMessages.DELETE_COMMENT_DETAILS, HttpStatus.CREATED, commentId);
//		return  ResponseEntity.noContent().build();
	}
}
