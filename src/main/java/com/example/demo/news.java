package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class news {
    private PostRepository postRepo;
    private PostService postService;

    @ModelAttribute("getPostService")
    public PostService getPostService(){
        return postService;
    }

    @GetMapping("/news")
    public String getNews (Model model){
        model.addAttribute("postObject",new Post());
        return "news";
    }

    @PostMapping("/news/post")
    public String postNews(@ModelAttribute("postObject")Post post){
        postRepo.save(post);
        return "redirect:/news";
    }
}
