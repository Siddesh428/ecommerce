package com.jspider.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.ecommerce.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
	boolean existsByEmail(String email);

	Merchant findByEmail(String email);
}