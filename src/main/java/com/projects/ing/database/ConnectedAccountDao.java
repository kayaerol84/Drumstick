package com.projects.ing.database;

import java.util.List;

import com.projects.ing.db.domain.ConnectedAccount;


public interface ConnectedAccountDao {
	
	public void insertConnectedAccount(int userId, int accountId, int categoryCode, String  connectedIban, String connectedAccountBankName, String connectedUserName, int connectedUserId);
	// One user can follow many accounts
	public List<ConnectedAccount> fetchConnectedAccountsByUserId(int userId);
	// One account can be followed by many users
	public List<ConnectedAccount> fetchConnectedAccountsByAccountId(int AccountId);
	
	// Fetch user's connects by Category (Family/Friends/Public)
	public List<ConnectedAccount> fetchConnectedAccountsByUserIdAndCategory(int userId, int category);


}
