package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB extends DBConnection implements DAO<User> {
	
	
	@Override
	public User get(int id) {
		String sql = "SELECT ID, Username, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin "
					+ "FROM User "
					+ "WHERE ID = ?";
		try (Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String username = rs.getString("Username");
				String pwd = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("IsReviewer");
				boolean isAdmin = rs.getBoolean("IsAdmin");
				User u = new User(id, username, pwd, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
				rs.close();
				return u;	
			} else {
				rs.close();
				return null;
			}
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * "
					+ "FROM User";
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {
		  while (rs.next()) {
			  int id = rs.getInt("ID");
			  String username = rs.getString("Username");
			  String pwd = rs.getString("Password");
			  String firstName = rs.getString("FirstName");
			  String lastName = rs.getString("LastName");
			  String phoneNumber = rs.getString("PhoneNumber");
			  String email = rs.getString("Email");
			  boolean isReviewer = rs.getBoolean("IsReviewer");
			  boolean isAdmin = rs.getBoolean("IsAdmin");
			  User u = new User(id, username, pwd, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
			  users.add(u);
		  }
		  return users;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public boolean add(User t) {
		String sql = "INSERT INTO User (Username, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin) "
					 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPwd());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getPhoneNumber());
			ps.setString(6, t.getEmail());
			ps.setBoolean(7, t.isReviewer());
			ps.setBoolean(8, t.isAdmin());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		String sql = "DELETE FROM User "
					+ "WHERE ID = ?";
		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1,  t.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;			
		}
	}

}
