package com.ovsoftware.reti;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ovsoftware.reti.domain.User;
import com.ovsoftware.reti.service.UserService;

/**
 * Responsible for running User tests.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RetiApplication.class,}, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void testUserFlow() {
		User user = new User("Test", "WalletHashCode");
		userService.createUser(user);
		User created = userService.getUser(user.getUsername());
		assertEquals(user.getUsername(), created.getUsername());
		assertEquals(user.getWalletAdress(), created.getWalletAdress());
		userService.deleteUser(created);
	}
}