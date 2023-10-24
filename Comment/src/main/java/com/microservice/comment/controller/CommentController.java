package com.microservice.comment.controller;

import com.microservice.comment.entity.Comment;
import com.microservice.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Endpoint to save a new comment
    // http://localhost:8082:api/comments
    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        // Call the service to save the comment
        Comment comment1 = commentService.saveComment(comment);
            return new ResponseEntity<>(comment1, HttpStatus.OK);
    }

    // Endpoint to get all comments by postId
    @GetMapping("{postId}")
    public ResponseEntity<List<Comment>> getAllCommentsByPostId(@PathVariable String postId){
        // Call the service to retrieve all comments for the specified postId
        List<Comment> comments=commentService.getAllTheCommentByPostId(postId);
        return new ResponseEntity<>(comments,HttpStatus.OK);

    }

}
