package com.restfulwebservices.users;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;
	
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}


	//GET/Users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
			return service.findAll();
	}
	
	//http://localhost:8080/users
	 
	//EntityModel
	//WebMvcLinkBuilder
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUsers(@PathVariable int id){
			User user = service.findOne(id);
			
			if(user==null) {
				throw new UserNotFoundException("id:"+id);
			}
			
			EntityModel<User> entittModel=EntityModel.of(user);
			
			WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
			return entittModel.add(link.withRel("all-users"));
	}
	
	//delete
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id){
			service.deleteById(id);	
	}
	
	
	//Post
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid   @RequestBody User user) {
		User savedUser = service.save(user);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(location).build();
	}
}
