package com.navin.entity;

import javax.persistence.*; 

@Entity
@Table(name="COMMENT")
public class Comment {
	@Id
	private Integer commentid;
	@Column
	private Long comment_postid;
	@Column
	private String comment_name;
	@Column
	private String comment_body;
	public Comment(Integer commentid, Long comment_postid, String comment_name, String comment_body) {
		super();
		this.commentid = commentid;
		this.comment_postid = comment_postid;
		this.comment_name = comment_name;
		this.comment_body = comment_body;
	}
	public Integer getCommentid() {
		return commentid;
	}
	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	public Long getComment_postid() {
		return comment_postid;
	}
	public void setComment_postid(Long comment_postid) {
		this.comment_postid = comment_postid;
	}
	public String getComment_name() {
		return comment_name;
	}
	public void setComment_name(String comment_name) {
		this.comment_name = comment_name;
	}
	public String getComment_body() {
		return comment_body;
	}
	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}	
	
	

}
