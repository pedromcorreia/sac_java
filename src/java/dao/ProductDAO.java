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
import model.ProductModel;

/**
 *
 * @author pedro
 */
public class ProductDAO {

	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Integer> categories = new ArrayList<>();

	public ProductDAO() {
		conn = new ConnetionFactory().getConn();
	}
	public void create(ProductModel productModel) {
			String sql = "INSERT INTO public.category (name, description, weight) VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, productModel.getName());
			ps.setString(2, productModel.getDescription());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
