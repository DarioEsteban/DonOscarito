package com.usm.donoscarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usm.donoscarito.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
