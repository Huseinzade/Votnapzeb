package com.example.demo.controller;

import com.example.demo.dto.SearchFilterDTO;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@AllArgsConstructor
@Controller
public class ViewController {
    private final PostService postService;

    @ModelAttribute("getPostService")
    public PostService getPostService(){
        return postService;
    }
    @GetMapping("/")
    public String homepage (@ModelAttribute("searchFilterDTO") SearchFilterDTO searchFilterDTO, Model model){
        String searchFilterKey = "";
        if(searchFilterDTO == null)
            model.addAttribute("searchFilterDTO",new SearchFilterDTO());
        else {
            model.addAttribute("searchFilterDTO", searchFilterDTO);
            searchFilterKey = searchFilterDTO.getSearchKey();
        }
        model.addAttribute("searchFilterKey",searchFilterKey);
        return "index";
    }

}
