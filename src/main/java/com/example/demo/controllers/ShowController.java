package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.service.CheckProfile;
import com.example.demo.service.ShowService;

@Controller
public class ShowController {

@Autowired
CheckProfile checkProfile;

@Autowired
ShowService showService;



 @GetMapping(path="/showcust")
 public String showCust(ModelMap model) {
	 model.put("allcust",checkProfile.getAll());
	return "showcust";
 }



 
}