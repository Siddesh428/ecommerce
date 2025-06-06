package com.jspider.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jspider.ecommerce.dto.UserDto;
import com.jspider.ecommerce.repository.AdminRepository;
import com.jspider.ecommerce.repository.CustomerRepository;
import com.jspider.ecommerce.repository.MerchantRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	MerchantRepository merchantRepository;

	@Override
	public String register(UserDto userDto, Model model) {
		model.addAttribute("userDto", userDto);
		return "customer-register.html";
	}

	@Override
	public String register(UserDto userDto, BindingResult result) {
		if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
			result.rejectValue("confirmPassword", "error.confirmPassword",
					"* Password and Confirm password not matching");
		if (adminRepository.existsByEmail(userDto.getEmail()) || customerRepository.existsByEmail(userDto.getEmail())
				|| merchantRepository.existsByEmail(userDto.getEmail()))
			result.rejectValue("email", "error.email", "* Email Already Exists");
		
		if (result.hasErrors()) {
			return "customer-register.html";
		}
		
		return "redirect:/";
	}
}
