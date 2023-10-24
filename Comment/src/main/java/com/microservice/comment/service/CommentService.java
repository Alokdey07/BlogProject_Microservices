package com.microservice.comment.service;

import com.microservice.comment.config.RestTemplateConfig;
import com.microservice.comment.entity.Comment;
import com.microservice.comment.payload.Post;
import com.microservice.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RestTemplateConfig restTemplate;


    // Save a new comment
    public Comment saveComment(Comment comment){
        // Get the associated post from a RESTful API based on the postId
        Post post = restTemplate.getRestTemplate().getForObject("http://localhost:8081/api/post/" + comment.getPostId(), Post.class);
       // System.out.println("post=  "+post);
        // Check if the post exists
      if(post!=null){
          // Generate a random commentId using UUID
          String commentId = UUID.randomUUID().toString();
          comment.setCommentId(commentId);
          //comment.setPostId(post.getPostId());
          // Save the comment to the repository
          Comment saveComment =
                  commentRepository.save(comment);
         // System.out.println(saveComment);
          return saveComment;

      }else{
          // If the associated post doesn't exist, return null
          return null;

      }
    }

    // Get all comments for a given postId
    public List<Comment> getAllTheCommentByPostId(String postId) {
        // Retrieve all comments for the specified postId from the repository
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments;
    }
}
