package com.microservice.post.service;

import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepo;

    public Post savePost(Post post) {
        String randomPostId= UUID.randomUUID().toString();
        post.setId(randomPostId);
        Post savePost = postRepo.save(post);
        return savePost;
    }

    public Post getPostById(String postId) {
        Post post = postRepo.findById(postId).get();
        return post;

    }
}
