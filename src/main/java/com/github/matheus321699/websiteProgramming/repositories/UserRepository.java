package com.github.matheus321699.websiteProgramming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.matheus321699.websiteProgramming.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
