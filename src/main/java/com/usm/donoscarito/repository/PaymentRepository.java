package com.usm.donoscarito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usm.donoscarito.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	
	
}
