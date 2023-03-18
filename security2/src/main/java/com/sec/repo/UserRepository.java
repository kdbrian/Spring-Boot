package com.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	Optional<User> findByEmail(String mail);
	
}
