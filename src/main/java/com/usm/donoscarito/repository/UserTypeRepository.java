package com.usm.donoscarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usm.donoscarito.entities.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
	
}
