package com.microservice.post.controller;

import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        Post savePost = postService.savePost(post);

        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable String postId){
        postService.getPostById(postId);
    }


}
