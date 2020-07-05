package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {
	String signup = "insert into USERS VALUES (?,?)";
	String login = "select * from USERS where EMAIL = ? and PASSWORD= ?";

	public int signUp(User user) throws ClassNotFoundException, SQLException {
		System.out.println("Signup");
		// TODO Auto-generated method stub
		Connection c = ConnectionManager.GetConnection();
		// access the string
		PreparedStatement ps = c.prepareStatement(signup);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		return ps.executeUpdate();
	}

	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean statuscheck = false;
		Connection c = null;
		c = ConnectionManager.GetConnection();
		PreparedStatement ps = c.prepareStatement(login);
		// System.out.println(ps);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		System.out.println("Status" + rs.next());
		return rs.next();
	}

}