package com.microservice.post.service;

import com.microservice.post.config.RestTemplateConfig;
import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepo;

    @Autowired
    private RestTemplateConfig restTemplate;

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

    public PostDto getPostWithComments(String postId) {
        Post post=postRepo.findById(postId).get();

        ArrayList comments = restTemplate.getRestTemplate().getForObject("http://localhost:8082/api/comments/" + postId, ArrayList.class);
        PostDto postDto =new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());

        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setComments(comments);

        return postDto;
    }
}
