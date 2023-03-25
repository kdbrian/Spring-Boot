package com.library.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.users.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
