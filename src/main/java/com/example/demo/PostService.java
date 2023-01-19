package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;

    public List<Post> getAllPostsLimit(int maxSize){
        return postRepository.findAll().stream().limit(maxSize).collect(Collectors.toList());
    }
}
