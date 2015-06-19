package com.projects.ing.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projects.ing.db.domain.Account;
import com.projects.ing.db.domain.ConnectedAccount;


@Component
public class ConnectedAccountDaoImpl implements ConnectedAccountDao {

	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public List<Account> fetchAccountsByUserId(int userId) {
		String sql = "SELECT * FROM Connected_Accounts WHERE user_id = ?";

		Connection conn = null;
		List<Account> accountList = new ArrayList<Account>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			Account account = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new Account();
				account.setUserId(userId);
				
				account.setAccountId(rs.getLong("Account_Id"));
				account.setBankId(rs.getLong("Bank_Id"));
				
				accountList.add(account);
			}
			rs.close();
			ps.close();
			return accountList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	public void insertConnectedAccount(int userId, int accountId, int categoryCode, String  connectedIban, String connectedAccountBankName, String connectedUserName, int connectedUserId) {
		// TODO insert statement & connection 
		String sql = "Insert Into Connected_Accounts (User_Id, Connected_Account_Id, Category, Connected_Account_IBAN, Connected_Account_Bank_Name, Connected_User_Name, Connected_User_ID)  Values (16101, 1005, 4, 'NL14INGX0003903559', 'ING Bank NV', 'RaghuEbolaReliefFund', 16105)";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			/*ps.setInt(1, userId);
			ps.setInt(2, accountId);
			ps.setInt(3, categoryCode); 
			ps.setString(4, connectedIban);
			ps.setString(5, connectedAccountBankName);
			ps.setString(6, connectedUserName);
			ps.setInt(7, connectedUserId);*/
			
			ps.execute();
			
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}



	/**
	 * One user can follow many accounts 
	 */
	public List<ConnectedAccount> fetchConnectedAccountsByUserId(int userId) {
		String sql = "SELECT * FROM Connected_Accounts WHERE user_id = ?";

		Connection conn = null;
		List<ConnectedAccount> connectedAccountList = new ArrayList<ConnectedAccount>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ConnectedAccount connectedAccount = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				connectedAccount = new ConnectedAccount();
				connectedAccount.setUserId(userId);
				
				connectedAccount.setConnectedAccountId(rs.getLong("Connected_Account_Id"));
				connectedAccount.setCategory(rs.getInt("Category"));
				connectedAccount.setConnectedAccountIBAN(rs.getString("Connected_Account_IBAN"));
				connectedAccount.setConnectedAccountsBank(rs.getString("Connected_Account_Bank_Name"));
				connectedAccount.setConnectedUserName(rs.getString("Connected_User_Name"));
				connectedAccount.setConnectedUserId(rs.getLong("Connected_User_ID"));
				connectedAccountList.add(connectedAccount);
			}
			rs.close();
			ps.close();
			return connectedAccountList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	/**
	 * One account can be followed by many users 
	 */
	public List<ConnectedAccount> fetchConnectedAccountsByAccountId(
			int accountId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Connected_Accounts WHERE user_id = ?";

		Connection conn = null;
		List<ConnectedAccount> connectedAccountList = new ArrayList<ConnectedAccount>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			ConnectedAccount connectedAccount = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				connectedAccount = new ConnectedAccount();
				connectedAccount.setConnectedAccountId(accountId);
				
				connectedAccount.setUserId(rs.getLong("User_Id"));
				connectedAccount.setCategory(rs.getInt("Category"));
				connectedAccount.setConnectedAccountIBAN(rs.getString("Connected_Account_IBAN"));
				connectedAccount.setConnectedAccountsBank(rs.getString("Connected_Account_Bank_Name"));
				connectedAccount.setConnectedUserName(rs.getString("Connected_User_Name"));
				connectedAccount.setConnectedUserId(rs.getLong("Connected_User_ID"));
				connectedAccountList.add(connectedAccount);
			}
			rs.close();
			ps.close();
			return connectedAccountList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	public List<ConnectedAccount> fetchConnectedAccountsByUserIdAndCategory(
			int userId, int category) {
		// 
		String sql = "SELECT * FROM Connected_Accounts WHERE user_id = ? and category = ?";

		Connection conn = null;
		List<ConnectedAccount> connectedAccountList = new ArrayList<ConnectedAccount>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, category);
			ConnectedAccount connectedAccount = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				connectedAccount = new ConnectedAccount();
				connectedAccount.setConnectedAccountId(rs.getLong("Connected_Account_Id"));
				
				connectedAccount.setUserId(userId);
				connectedAccount.setCategory(category); 
				connectedAccount.setConnectedAccountIBAN(rs.getString("Connected_Account_IBAN"));
				connectedAccount.setConnectedAccountsBank(rs.getString("Connected_Account_Bank_Name"));
				connectedAccount.setConnectedUserName(rs.getString("Connected_User_Name"));
				connectedAccount.setConnectedUserId(rs.getLong("Connected_User_ID"));
				connectedAccountList.add(connectedAccount);
			}
			rs.close();
			ps.close();
			return connectedAccountList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
