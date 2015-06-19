package com.projects.ing.database;

import java.util.List;
import com.projects.ing.domain.User;

public interface UserDao {
	
	public void insertUser();
	public User fetchUser(int id);
	public List<User> fetchUsers();

}
