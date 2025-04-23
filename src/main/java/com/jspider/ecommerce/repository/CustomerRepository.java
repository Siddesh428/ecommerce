package com.jspider.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	boolean existsByEmail(String email);
}
