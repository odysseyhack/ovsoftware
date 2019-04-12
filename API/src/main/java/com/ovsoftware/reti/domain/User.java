package com.ovsoftware.reti.domain;

import org.springframework.data.annotation.Id;

/**
 * Responsible for representing a User.
 */

public class User {
	
	@Id
	private long _id;
	private String username;
	private String walletAdress;
	
	public User() {
		super();
	}

	public User(String username, String walletAdress) {
		super();
		this.username = username;
		this.walletAdress = walletAdress;
	}

	public User(long _id, String username, String walletAdress) {
		super();
		this._id = _id;
		this.username = username;
		this.walletAdress = walletAdress;
	}

	public long getId() {
		return _id;
	}

	public void setId(long _id) {
		this._id = _id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWalletAdress() {
		return walletAdress;
	}

	public void setWalletAdress(String walletAdress) {
		this.walletAdress = walletAdress;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", walletAdress=" + walletAdress + "]";
	}
}
