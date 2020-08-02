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
	private ArrayList<ProductModel> products = new ArrayList<>();

	public ProductDAO() {
		conn = new ConnetionFactory().getConn();
	}
	public void create(ProductModel productModel) {
			String sql = "INSERT INTO public.product (name, description, weight) VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, productModel.getName());
			ps.setString(2, productModel.getDescription());
			ps.setInt(3, productModel.getWeight());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<ProductModel> all() {
			String sql = "SELECT * FROM public.product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProduct_id(rs.getInt("product_id"));
				product.setDescription(rs.getString("description"));
				product.setWeight(rs.getInt("weight"));
				products.add(product);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return products;
	}

	public ProductModel get_by_id(int product_id) {
		String sql = "SELECT * FROM public.product where product_id = ?";
		ProductModel product = new ProductModel();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product_id);
			rs = ps.executeQuery();

			if (rs.next()) {
				product.setDescription(rs.getString("description"));
				product.setProduct_id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setWeight(rs.getInt("weight"));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return product;
	}

	public void delete(int product_id) {
		try {
			String sql = "DELETE FROM public.product WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product_id);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(ProductModel productModel) {
		try {
			String sql = "UPDATE public.product set name = ?, weight = ?, description = ?, category_id = ? "
				+ "WHERE product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, productModel.getName());
			ps.setInt(2, productModel.getWeight());
			ps.setString(3, productModel.getDescription());
			ps.setInt(4, productModel.getWeight());
			ps.setInt(5, productModel.getProduct_id());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
