package com.github.matheus321699.websiteProgramming.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.matheus321699.websiteProgramming.domain.Users;
import com.github.matheus321699.websiteProgramming.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;

	public Users findByUser(Integer id) {

		Optional<Users> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Users.class.getName(), null));
	}
	
}
