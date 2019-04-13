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
	private boolean activeParticipant;
	
	public User() {
		super();
	}

	public User(String username, String walletAdress) {
		super();
		this.username = username;
		this.walletAdress = walletAdress;
	}

	public User(String username, String walletAdress, boolean isActiveParticipant) {
		super();
		this.username = username;
		this.walletAdress = walletAdress;
		this.activeParticipant = isActiveParticipant;
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

	public boolean isActiveParticipant() {
		return activeParticipant;
	}

	public void setActiveParticipant(boolean isActiveParticipant) {
		this.activeParticipant = isActiveParticipant;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", walletAdress=" + walletAdress + "]";
	}
}
