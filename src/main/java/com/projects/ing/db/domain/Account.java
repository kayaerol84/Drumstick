package com.projects.ing.db.domain;

public class Account {

	private long accountId;
	private long userId;
	private long bankId;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long account_id) {
		this.accountId = account_id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long user_id) {
		this.userId = user_id;
	}
	public long getBankId() {
		return bankId;
	}
	public void setBankId(long bank_id) {
		this.bankId = bank_id;
	}
	
	

}
