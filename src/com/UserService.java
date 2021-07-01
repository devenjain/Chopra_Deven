package com;

public interface UserService {
	
	public boolean signUp(UserBean bean);
	
	public boolean checkLogin(String email, String password);
}
