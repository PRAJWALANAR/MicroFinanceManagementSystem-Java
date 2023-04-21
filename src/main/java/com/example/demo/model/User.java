package com.example.demo.model;




public class User {
	String name;
	String username;
	String email;
	Long mobno;
	String address;
	Long aadhar;
	int accno;
	int balance;

	public User(String name, String username, String address, Long mobno, String email, Long aadhar, int accno,
			int balance) {
		super();
		this.name = name;
		this.username = username;
		this.address = address;
		this.email = email;
		this.mobno = mobno;
		this.aadhar = aadhar;
		this.accno = accno;
		this.balance = balance;

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public int getAccno() {
		return accno;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public Long getMobno() {
		return mobno;
	}

	public void setMobno(Long mobno) {
		this.mobno = mobno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAadhar() {
		return aadhar;
	}

	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address="
				+ address + ", mobno=" + mobno + ", email=" + email + ", aadhar=" + aadhar + "]";
	}

}
