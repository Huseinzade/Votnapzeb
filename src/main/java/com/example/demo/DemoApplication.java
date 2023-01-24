package com.example.demo;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication {
	private final PostService postService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomething(){
		Post post = new Post();
		post.setTitle("This is my first post!");
		post.setContent("Ismail is a cockhold");
		postService.savePost(post);

		Post post1 = new Post();
		post1.setTitle("This is my second Post1!!@$!@");
		post1.setContent("Eldar loves arabic disks.");
		postService.savePost(post1);

		Post post2 = new Post();
		post2.setTitle("This is my third post!");
		post2.setContent("Ismail claimed that arabic dicks are very painful and tasty.");
		postService.savePost(post2);

		Post post3 = new Post();
		post2.setTitle("This is my third post!");
		post2.setContent("Ismail claimed that arabic dicks are very painful and tasty.");
		postService.savePost(post2);
	}

}
