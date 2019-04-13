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
		String username = "Test";
		String walletAdress = "WalletHashCode";
		User user = userService.createUser(username, walletAdress);
		User created = userService.getUser(user.getUsername());
		assertEquals(user.getUsername(), created.getUsername());
		assertEquals(user.getWalletAdress(), created.getWalletAdress());
		userService.deleteUser(created);
	}
	
	@Test
	public void testGetActiveUsers() {
		String username1 = "Test1";
		String username2 = "Test2";
		String username3 = "Test3";
		String walletAdress = "WalletHashCode";
		User user1 = userService.createUser(username1, walletAdress);
		User user2 = userService.createUser(username2, walletAdress);
		User user3 = userService.createUser(username3, walletAdress);
		User created1 = userService.getUser(user1.getUsername());
		User created2 = userService.getUser(user2.getUsername());
		User created3 = userService.getUser(user3.getUsername());
		assertEquals(created1.isActiveParticipant(), true);
		assertEquals(created2.isActiveParticipant(), true);
		assertEquals(created3.isActiveParticipant(), true);
		userService.deleteUser(created1);
		userService.deleteUser(created2);
		userService.deleteUser(created3);
	}
}