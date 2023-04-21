package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.CheckProfile;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.ShowService;
import com.example.demo.service.TransferService;

@Controller
public class OtherController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CheckProfile checkProfile;

	@Autowired
	TransferService transferService;

	@Autowired
	RegistrationService registrationService;

	@Autowired
	ShowService showService;

	@GetMapping(path = "/showimage")
	public String showHome() {
		return "showimage";
	}

	@GetMapping(path = "/getDetails")
	public String showDetails(@RequestParam String username, ModelMap model) {
		System.out.println("------ ----------------------------" + username + "-------");
		model.put("user", checkProfile.getDetails(username));
		System.out.println(checkProfile.getDetails(username).toString());
		return "showdetails";
	}

	@GetMapping(path = "/transfer")
	public String transferMoney() {
		return "transfer";
	}

	@PostMapping(path = "/"
			+ "transfer")
	public String transferMoney(@RequestParam String username, @RequestParam int amount, @RequestParam String user,
			ModelMap model, RedirectAttributes redirAttrs) {
		System.out.println("##########" + username + "######");
		int s = transferService.transfer(username, user, amount);
		if (s == 0) {
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		} else if (s == 1) {
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}
		return "redirect:/transfer";
	}

	@GetMapping(path = "/deposit")
	public String depositMoney() {
		return "deposit";
	}

	@PostMapping(path = "/"
			+ "deposit")
	public String depositMoney(@RequestParam String username, @RequestParam int amount, ModelMap model,
			RedirectAttributes redirAttrs) {
		int s = transferService.deposit(username, amount);
		if (s == 0) {
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		} else if (s == 1) {
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}
		return "redirect:/deposit";
	}

	@GetMapping(path = "/withdraw")
	public String withdrawMoney() {
		return "withdraw";
	}

	@PostMapping(path = "/"
			+ "withdraw")
	public String withdrawMoney(@RequestParam String username, @RequestParam int amount, ModelMap model,
			RedirectAttributes redirAttrs) {
		int s = transferService.deposit(username, amount);
		if (s == 0) {
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		} else if (s == 1) {
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}
		return "redirect:/withdraw";
	}

	@GetMapping(path = "/about")
	public String showAbout() {
		return "about";
	}

	@GetMapping(path = "/home-admin")
	public String showHomeAdmin() {
		return "home-admin";
	}

	@GetMapping(path = "/contact")
	public String showContact() {
		return "contact";
	}

	@GetMapping(path = "/loanRegister")
	public String loanRegister() {
		return "loanRegister";
	}

	@PostMapping(path = "/"
			+ "loanRegister")
	public String loanRegister(@RequestParam String name, @RequestParam String username, @RequestParam long accno,
			@RequestParam String address, @RequestParam long ifsc, @RequestParam int term, @RequestParam int principal,
			ModelMap model, RedirectAttributes redirAttrs) {
		System.out.println("##########" + username + "######");
		int s = transferService.loanRegister(name, username, accno, address, ifsc, principal, term);
		if (s == 0) {
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		} else if (s == 1) {
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}
		return "redirect:/loanRegister";
	}

	@GetMapping(path = "/addcust")
	public String addCust() {
		return "custregister";
	}

	@PostMapping(path = "/addcust")
	public String regCust(@RequestParam String name, @RequestParam String username, @RequestParam String address,
			@RequestParam long mobno, @RequestParam String email, @RequestParam long aadhar) {

		registrationService.addCustomer(name, username, address, mobno, email, aadhar);
		// int ss=registrationService.addAdminLogin(username,password,"cust");
		return "custregister";
	}

	@GetMapping(path = "/showtransaction")
	public String showTransaction(ModelMap model) {
		model.put("transaction", showService.showTransaction());
		return "showtransaction";
	}

	@GetMapping(path = "/logout")
	public String showLogout() {
		System.out.println(LoginController.uname);
		LoginController.uname = "";
		return "logout";
	}
}