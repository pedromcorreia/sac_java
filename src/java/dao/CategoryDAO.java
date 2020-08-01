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
import model.CategoryModel;

/**
 *
 * @author pedro
 */
public class CategoryDAO {

	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ArrayList<CategoryModel> categories = new ArrayList<>();

	public CategoryDAO() {
		conn = new ConnetionFactory().getConn();
	}
	public void create(String name) {
			String sql = "INSERT INTO public.category (name) VALUES (?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<CategoryModel> all() {
		String sql = "SELECT * FROM public.category ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategory_id(rs.getInt("category_id"));
				category.setName(rs.getString("name"));
				categories.add(category);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return categories;
	}

	public CategoryModel get_by_id(int category_id) {
		String sql = "SELECT * FROM public.category where category_id = ?";
		CategoryModel category = new CategoryModel();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			rs = ps.executeQuery();

			if (rs.next()) {
				category.setName(rs.getString("name"));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return category;
	}
}
