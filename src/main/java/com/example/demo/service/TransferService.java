package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;


@Service
public class TransferService {

	@Autowired
	UserRepository userRepository;
	public int transfer(String source,String dest,int amount)
	{
		String timestamp=userRepository.getDate();
		return userRepository.transfer(source,dest,timestamp,amount);
	}

	public int deposit(String dest, int amount)
	{
		String timestamp=userRepository.getDate();
		return userRepository.deposit(dest,timestamp, amount);
	}

	public int withdraw(String dest, int amount)
	{
		String timestamp=userRepository.getDate();
		return userRepository.deposit(dest,timestamp, amount);
	}

	public int loanRegister(String name, String username, long accno, String address, long ifsc,int principal, int term )
	{
		return userRepository.loanRegister(name, username, accno, address, ifsc,principal, term);
	}


}
