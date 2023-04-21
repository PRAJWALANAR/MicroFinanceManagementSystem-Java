package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.DataRepository;
import com.example.demo.repository.UserRepository;


@Service
public class ShowService {

	@Autowired
	DataRepository dataRepository;
	@Autowired
	UserRepository userRepository;
	public int addCustomer(String name,String username,String accno,
			int mobno,String address, int ifsc, int balance)
	{
		return userRepository.addCustomer(name,username,accno,mobno,address,ifsc);
	}

	public List<Transaction> showTransaction() {
		return dataRepository.showTransaction();
	}


	
}
