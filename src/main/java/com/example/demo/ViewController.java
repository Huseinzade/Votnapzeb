package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class ViewController {
    @GetMapping("/")
    public String homepage (){
        return "index";
    }

}
