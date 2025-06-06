package com.jspider.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.ecommerce.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	boolean existsByEmail(String email);
}
