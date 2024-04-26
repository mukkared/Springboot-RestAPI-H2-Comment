package com.navin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navin.entity.Comment;

@Repository
public interface commentRepository extends JpaRepository<Comment, Integer> {

}
