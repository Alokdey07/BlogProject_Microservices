package com.microservice.post.payload;


import lombok.Data;

import java.util.List;

@Data
public class PostDto {
private String id;
private String title;
private String description;
private String content;
private List<Comment> comments;


}
