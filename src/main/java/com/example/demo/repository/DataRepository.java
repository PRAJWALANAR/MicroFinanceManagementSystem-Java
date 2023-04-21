package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Transaction;
import com.example.demo.model.User;

@Repository
public class DataRepository {

 // we are autowiring jdbc template, 
 // using the properties we have configured spring automatically 
 // detects and creates jdbc template using the configuration
 @Autowired
 JdbcTemplate jdbcTemplate;
 
 public List<Transaction> showTransaction() {
	 List<Transaction> transaction = new ArrayList<Transaction>() ;
	 transaction.addAll(jdbcTemplate.query("select * from transaction;", 
			 (rs, rowNum) ->
     			new Transaction(
             rs.getString("from"),
             rs.getString("to"),
             rs.getString("date"),
             rs.getInt("amount"))));
	 System.out.println("--------");
	 System.out.println(transaction.toString());
	 System.out.println("--------");
	 return transaction;
	 }

public List<User> getAll() {
	
	List<User> user=new ArrayList<User>() ;
	
		user.addAll(jdbcTemplate.query("select * from userdata;", 
				 (rs, rowNum) ->
				 new User(
					rs.getString("name"),
					rs.getString("username"),
					rs.getString("address"),
					rs.getLong("mobno"),
					rs.getString("email"),
					rs.getLong("aadhar"),
					rs.getInt("accno"),
					rs.getInt("balance")
					
					
					)));
	
	 return user;
}




}