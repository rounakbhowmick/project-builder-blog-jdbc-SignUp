package dao;

import java.sql.SQLException;

import model.User;

public interface UserDaoInterface {
	public int signUp(User user) throws ClassNotFoundException, SQLException;

	public boolean loginUser(User user) throws ClassNotFoundException, SQLException;
}