package com.microservice.comment.repository;

import com.microservice.comment.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {

    List<Comment> findByPostId(String postId);
}
