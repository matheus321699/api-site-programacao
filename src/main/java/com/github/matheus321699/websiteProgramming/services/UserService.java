package com.github.matheus321699.websiteProgramming.services;

import java.util.Optional;


import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Users insert(@Valid Users obj) {
		// Setar Id para garantir que o objeto inserido é um novo registro
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Users update(Users obj) {
		Users newObj = findByUser(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}

	private void updateDate(Users newObj, Users obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	public void delete(Integer id) {
		findByUser(id);
		/*
		 * Capturando exceção que é lançada quando um objeto que está associado
		 * a outro objeto sofre uma tentativa de deleção, não permitindo que o
		 * o objeto seja deletado.
		 */
		try {
		repo.deleteById(id);
		} 
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir porque há pedidos"
					+ " relacionados!");
		}
		
	}
	
}
