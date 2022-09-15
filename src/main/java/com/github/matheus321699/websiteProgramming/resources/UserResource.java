package com.github.matheus321699.websiteProgramming.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.matheus321699.websiteProgramming.domain.Users;
import com.github.matheus321699.websiteProgramming.services.UserService;

@RestController
@RequestMapping(value="/usuarios")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/{id}", method =RequestMethod.GET)
	public ResponseEntity<Users> find(@PathVariable Integer id) {
		Users obj = service.findByUser(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
