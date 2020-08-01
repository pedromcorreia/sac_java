/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author pedro
 */
public class UserDAO {

	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ArrayList<User> user_list = new ArrayList<>();

	public UserDAO() {
		conn = new ConnetionFactory().getConn();
	}

	public void create(User user) {
		String sql = "INSERT INTO public.user (name, password, email, cpf, role) VALUES (?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getCpf());
			ps.setString(5, "client");
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<User> all() {
		String sql = "SELECT * FROM user";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user_list.add(user);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user_list;
	}

	public User get_by_id(Integer id) {
		String sql = "SELECT * FROM public.user where user_id = ?";
		User user = new User();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCpf(rs.getString("cpf"));
				user.setPhone(rs.getString("phone"));
				user.setStreet(rs.getString("street"));
				user.setNumber(rs.getString("number"));
				user.setComplement(rs.getString("complement"));
				user.setNeighborhood(rs.getString("neighborhood"));
				user.setZipcode(rs.getString("zipcode"));
				user.setCity(rs.getString("city"));
				user.setState(rs.getString("state"));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

	public void update(User user) {
		try {
			String sql = "UPDATE public.user set name = ?, phone = ?, "
				+ "street = ?, number = ?, complement = ?, "
				+ "neighborhood = ?, zipcode = ?, city = ?, state = ? "
				+ "WHERE user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getStreet());
			ps.setString(4, user.getNumber());
			ps.setString(5, user.getComplement());
			ps.setString(6, user.getNeighborhood());
			ps.setString(7, user.getZipcode());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getState());
			ps.setInt(10, user.getId());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
