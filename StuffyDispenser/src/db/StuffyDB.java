package db;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Stuffy;

public class StuffyDB implements DAO<Stuffy> {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/sda";
		String username = "sda_user";
		String pwd = "sesame";
		Connection connection = DriverManager.getConnection(dbUrl, username, pwd);
		return connection;
	}

	@Override
	public Stuffy get(int id) {
		String sql = "SELECT ID, Type, Color, Size, Limbs " 
					+ "FROM Stuffy "
					+ "WHERE ID = ?";
		try (Connection connection = getConnection(); 
			 PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("ID");
				String type = rs.getString("Type");
				String color = rs.getString("Color");
				String size = rs.getString("Size");
				int limbs = rs.getInt("Limbs");
				Stuffy s = new Stuffy(id, type, color, size, limbs);
				rs.close();
				return s;
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
	public List<Stuffy> getAll() {
		String sql = "SELECT ID, Type, Color, Size, Limbs " + "FROM Stuffy";
		List<Stuffy> stuffies= new ArrayList<>();
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id =rs.getInt("ID");
				String type = rs.getString("Type");
				String color = rs.getString("Color");
				String size = rs.getString("Size");
				int limbs = rs.getInt("Limbs");

				Stuffy s = new Stuffy(id, type, color, size, limbs);
				stuffies.add(s);
			}

		} catch (SQLException e) {
			System.err.println(e);
			stuffies = null;
		}
		return stuffies;
	}

	@Override
	public boolean add(Stuffy t) {
		String sql = "INSERT INTO Stuffy (Type, Color, Size, Limbs) " + "VALUES (?, ?, ?, ?)";
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, t.getType());
			ps.setString(2, t.getColor());
			ps.setString(3, t.getSize());
			ps.setInt(4, t.getLimbs());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	@Override
	public boolean update(Stuffy t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Stuffy t) {
		String sql= "DELETE from Stuffy " +
					"WHERE ID = ?";
		try(Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)){
		   ps.setInt(1, t.getId());
		   ps.executeUpdate();
		   return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

}
