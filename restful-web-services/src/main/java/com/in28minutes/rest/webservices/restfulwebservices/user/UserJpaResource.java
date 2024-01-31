package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	//private UserDaoService service;
	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository,PostRepository postRepository) {
		super();
		//this.service = service;
		this.repository = repository;
		this.postRepository = postRepository;
	}
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers()
	{
		return repository.findAll();
	}
	
  
  @PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();	}
  
  @GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
	  Optional<User> user =  repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		EntityModel<User> entityModel= EntityModel.of(user.get());
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrievelAllUsers());
		entityModel.add(link.withRel("all-users"));
		return user;}
  
  @DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
	  repository.deleteById(id);
  }
  @GetMapping("/jpa/users/{id}")
	public ResponseEntity<Post> createPostsForUser(@PathVariable int id,@Valid @RequestBody Post post) {
	  Optional<User> user = repository.findById(id);
	  if(user.isEmpty()) 
			throw new UserNotFoundException("id:"+id);
			post.setUser(user.get());
			Post savedPost = postRepository.save(post);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
			return ResponseEntity.created(location).build();
	  ///return user.get().getPosts();
}

}