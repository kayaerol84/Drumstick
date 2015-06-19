package com.projects.ing.db.domain;

public class ConnectedAccount {

	private long userId;
	// connected account
	private String connectedUserName;
	private long connectedUserId;
	private long connectedAccountId;
	private String connectedAccountIBAN;
	private String connectedAccountsBank;
	private int category;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long user_id) {
		this.userId = user_id;
	}
	public long getConnectedAccountId() {
		return connectedAccountId;
	}
	public void setConnectedAccountId(long connectedAccountId) {
		this.connectedAccountId = connectedAccountId;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getConnectedUserName() {
		return connectedUserName;
	}
	public void setConnectedUserName(String userName) {
		this.connectedUserName = userName;
	}
	public String getConnectedAccountsBank() {
		return connectedAccountsBank;
	}
	public void setConnectedAccountsBank(String connectedAccountsBank) {
		this.connectedAccountsBank = connectedAccountsBank;
	}
	public String getConnectedAccountIBAN() {
		return connectedAccountIBAN;
	}
	public void setConnectedAccountIBAN(String connectedAccountIBAN) {
		this.connectedAccountIBAN = connectedAccountIBAN;
	}
	public long getConnectedUserId() {
		return connectedUserId;
	}
	public void setConnectedUserId(long connectedUserId) {
		this.connectedUserId = connectedUserId;
	}
	
	
}
