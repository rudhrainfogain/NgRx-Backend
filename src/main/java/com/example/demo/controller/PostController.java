package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@RestController
@CrossOrigin
public class PostController {

	@Autowired
	PostRepository pr;

	@PostMapping(path = "/add", consumes = "application/json")
	public Post addPost(@RequestBody Post post) {
		return pr.save(post);
	}

	@GetMapping("/get")
	public List<Post> get() {
		return pr.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public Optional<Post> delete(@PathVariable("id") long id) {
		Optional<Post> post = pr.findById(id);
		pr.deleteById(id);
		return post;
	}

	@PutMapping(path = "/update", consumes = "application/json")
	public Post update(@RequestBody Post post) {
		return pr.save(post);
	}
}
