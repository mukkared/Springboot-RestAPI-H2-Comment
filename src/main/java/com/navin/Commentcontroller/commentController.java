package com.navin.Commentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navin.entity.Comment;
import com.navin.service.commentService;

@RestController
@RequestMapping("/comment")
public class commentController {

	@Autowired(required = true)
	@Qualifier("commentService")
	private commentService commentService;
	

	@GetMapping("/msg")
	public String getMessage(String msg) {
		return "Welcome Comments Rest Controller";
	}
	
	@PostMapping("/createComment")
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
//		try {
			Comment com = commentService.saveComment(comment);
//			if(com!=null) {
				return new ResponseEntity<Comment>(com, HttpStatus.CREATED);
//			}else {
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
//		catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
	}
}
