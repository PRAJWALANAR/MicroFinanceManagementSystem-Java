package com.example.demo.repository;

import java.util.Random;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {

	// we are autowiring jdbc template,
	// using the properties we have configured spring automatically
	// detects and creates jdbc template using the configuration
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<String> getAllUserNames() {
		List<String> userNameList = new ArrayList<>();
		userNameList.addAll(jdbcTemplate.queryForList("select name from user;", String.class));
		return userNameList;
	}

	public List<User> getDetails(String username) {
		// List<String> userNameL = new ArrayList<>();
		List<User> user = new ArrayList<User>();
		// userNameList.addAll(jdbcTemplate.queryForList("select name from user;",
		// String.class));
		user.addAll(jdbcTemplate.query("select * from userdata;",
				(rs, rowNum) -> new User(
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("address"),
						rs.getLong("mobno"),
						rs.getString("email"),
						rs.getLong("aadhar"),
						rs.getInt("accno"),
						rs.getInt("balance")
						
						
						)));
		System.out.println("--------");
		System.out.println(user);
		System.out.println("--------");
		return user;
	}

	public void add() {
		String sql = "INSERT INTO USER " +
				"(NAME, CLASS) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[] { "hari", "vilas" });
	}

	public boolean search(String username, String password) {
		String query = "select userid from logindata where userid='" + username + "' and password='" + password + "';";
		List<String> userNameList = new ArrayList<>();
		userNameList = jdbcTemplate.queryForList(query, String.class);
		if (userNameList.size() == 1)
			return true;
		else
			return false;
	}

	public String getDate() {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts.toString();
	}

	public int transfer(String source, String dest, String date, int amount) {
		System.out.println("--" + source + "--" + dest + "--" + date + "--" + amount + "--");
		jdbcTemplate.update("insert into transaction values(?,?,?,?);", source, dest, date, amount);
		int samt = jdbcTemplate.queryForObject("select balance from userdata where username=\"" + source + "\";",
				Integer.class);
		int damt = jdbcTemplate.queryForObject("select balance from userdata where username=\"" + dest + "\";",
				Integer.class);
		if (samt - amount > 0) {
			samt -= amount;
			damt += amount;
		} else
			return 0;
		System.out.println("--" + source + "--" + dest + "--" + date + "--" + amount + "--");
		jdbcTemplate.update("update userdata set balance=" + samt + " where username=\"" + source + "\";");
		System.out.println("##source##" + source + "#dest#" + dest + "--" + date + "--" + amount + "--yes");
		jdbcTemplate.update("update userdata set balance=" + damt + " where username=\"" + dest + "\";");
		return 1;
	}

	public int deposit(String dest, String timestamp, int amount) {
		jdbcTemplate.update("insert into transaction values(?,?,?,?);", "Deposit", dest, timestamp, amount);
		int balance = jdbcTemplate.queryForObject("select balance from userdata where username=\"" + dest + "\";",
				Integer.class);
		if (balance > amount) {
			balance -= amount;
			jdbcTemplate.update("update userdata set balance=" + balance + " where username=\"" + dest + "\";");

		} else
			return 0;

		return 1;
	}

	public int withdraw(String dest, String timestamp, int amount) {
		jdbcTemplate.update("insert into transaction values(?,?,?,?);", "Withdraw", dest, timestamp, amount);
		int balance = jdbcTemplate.queryForObject("select balance from userdata where username=\"" + dest + "\";",
				Integer.class);

		balance -= amount;
		jdbcTemplate.update("update userdata set balance=" + balance + " where username=\"" + dest + "\";");

		return 1;
	}

	public int addadmin(String source, String dest, String date, int amount) {
		System.out.println("--" + source + "--" + dest + "--" + date + "--" + amount + "--");
		jdbcTemplate.update("insert into transaction values(?,?,?,?);", source, dest, date, amount);
		int samt = jdbcTemplate.queryForObject("select balance from userdata where email=\"" + source + "\";",
				Integer.class);
		int damt = jdbcTemplate.queryForObject("select balance from userdata where email=\"" + dest + "\";",
				Integer.class);
		if (samt - amount > 0) {
			samt -= amount;
			damt += amount;
		} else
			return 0;
		System.out.println("--" + source + "--" + dest + "--" + date + "--" + amount + "--");
		jdbcTemplate.update("update userdata set balance=" + samt + " where email=\"" + source + "\";");
		System.out.println("##source##" + source + "#dest#" + dest + "--" + date + "--" + amount + "--yes");
		jdbcTemplate.update("update userdata set balance=" + damt + " where email=\"" + dest + "\";");
		return 1;
	}

	@Override
	public String toString() {
		return "UserRepository [jdbcTemplate=" + jdbcTemplate + "]";
	}

	public int gen() {
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextInt(20000);
	}

	public int addCustomer(String name, String username, String address, long mobno, String email, long aadhar) {
		int acc = gen();
		int s = jdbcTemplate.update("insert into userdata values(?,?,?,?,?,?,?, ?);", name, username, address, mobno,
				email, aadhar, acc, 1000);
		System.out.println("----- " + s + "----- ");
		return s;
	}

	public int loanRegister(String name, String username, long accno, String address, long ifsc, int principal,
			int term) {
		double emi = principal * 7 * (Math.pow((8), (term * 12))) / Math.pow((8), ((term * 12) - 1));

		int samt = jdbcTemplate.queryForObject("select count(*) from userdata where username=\"" + username + "\";",
				Integer.class);

		if (samt >= 0) {
			jdbcTemplate.update("insert into loandata values(?,?,?,?,?,?,?, ?, ?);", name, username, accno, address,
					ifsc, principal, term, emi, principal);
		} else
			return 0;

		return 1;
	}

}