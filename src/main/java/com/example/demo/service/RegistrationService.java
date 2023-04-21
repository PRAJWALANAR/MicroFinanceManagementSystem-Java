package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;


@Service
public class RegistrationService {

	@Autowired
	UserRepository userRepository;
	

	public int addCustomer(String name, String username,String address, Long mobno, String email, Long aadhar)
	{
		return userRepository.addCustomer(name,username,address,mobno,email,aadhar);
	}
}
