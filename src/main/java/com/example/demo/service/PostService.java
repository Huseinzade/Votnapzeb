package com.example.demo.service;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void savePost(Post post){
        postRepository.save(post);
    }

    public Post getRepositoryById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public List<Post> getAllPostsSearchFiltered(String key){
        if(key == null)
            return postRepository.findAll();
        if(key.isBlank())
            return postRepository.findAll();
        return postRepository.findAll().stream().filter(e-> e.getTitle().toLowerCase().contains(key.toLowerCase())
                || e.getContent().toLowerCase().contains(key.toLowerCase())).toList();
    }
}
