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
import model.QuestionModel;

/**
 *
 * @author pedro
 */
public class QuestionDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private PreparedStatement ps;

	private ResultSet rs;
	private ArrayList<QuestionModel> question_list = new ArrayList<>();

	public QuestionDAO() {
		conn = new ConnetionFactory().getConn();
	}

	public void create(QuestionModel question) {
		String sql = "INSERT INTO public.question (user_id, product_id, type, description, active, created_at) VALUES (?,?,?,?, true, current_timestamp)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, question.getUser_id());
			stmt.setInt(2, question.getProduct_id());
			stmt.setString(3, question.getType());
			stmt.setString(4, question.getDescription());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public QuestionModel get_by_id(Integer id) {
		String sql = "SELECT * FROM public.question where question_id = ? ORDER BY created_at DESC";
		QuestionModel question = new QuestionModel();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				question.setDescription(rs.getString("description"));
				question.setQuestion_id(rs.getInt("question_id"));
				question.setSolution(rs.getString("solution"));
				question.setActive(rs.getBoolean("active"));
				question.setType(rs.getString("type"));
				question.setCreated_at(rs.getDate("created_at"));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return question;
	}

	public ArrayList<QuestionModel> all(Integer id) {
		String sql = "SELECT * FROM public.question where user_id = ? ORDER BY created_at DESC";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionModel question = new QuestionModel();
				question.setQuestion_id(rs.getInt("question_id"));
				question.setProduct_id(rs.getInt("product_id"));
				question.setActive(rs.getBoolean("active"));
				question.setType(rs.getString("type"));
				question.setDescription(rs.getString("description"));
				question.setSolution(rs.getString("solution"));
				question.setCreated_at(rs.getDate("created_at"));
				question_list.add(question);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return question_list;
	}

	public ArrayList<QuestionModel> all_top() {
		String sql = "SELECT count(product_id), product_id FROM public.question group by product_id limit 3";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionModel question = new QuestionModel();
				question.setQuestion_id(rs.getInt("count"));
				question.setProduct_id(rs.getInt("product_id"));
				question_list.add(question);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return question_list;
	}

	public void update(Integer id) {
		try {
			String sql = "UPDATE public.question set active = false WHERE question_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<QuestionModel> all_for_employee() {

		ArrayList<QuestionModel> questions_opened = new ArrayList<>();
		String sql = "SELECT * FROM public.question ORDER BY created_at DESC";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionModel question = new QuestionModel();
				question.setQuestion_id(rs.getInt("question_id"));
				question.setProduct_id(rs.getInt("product_id"));
				question.setActive(rs.getBoolean("active"));
				question.setType(rs.getString("type"));
				question.setDescription(rs.getString("description"));
				question.setSolution(rs.getString("solution"));
				question.setCreated_at(rs.getDate("created_at"));
				questions_opened.add(question);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return questions_opened;
	}

	public void update_employee(QuestionModel questionModel) {
		try {
			String sql = "UPDATE public.question set solution = ?, active = false WHERE question_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, questionModel.getSolution());
			ps.setInt(2, questionModel.getQuestion_id());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<QuestionModel> all_opened() {
		String sql = "SELECT * FROM public.question where active = true "
			+ " ORDER BY created_at DESC";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionModel question = new QuestionModel();
				question.setQuestion_id(rs.getInt("question_id"));
				question.setProduct_id(rs.getInt("product_id"));
				question.setActive(rs.getBoolean("active"));
				question.setType(rs.getString("type"));
				question.setDescription(rs.getString("description"));
				question.setSolution(rs.getString("solution"));
				question.setCreated_at(rs.getDate("created_at"));
				question_list.add(question);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return question_list;
	}

	public ArrayList<QuestionModel> all_by_type(String active) {
		String sql = "";
		try {
			if (active.isEmpty()) {
				sql = "SELECT * FROM public.question ORDER BY created_at DESC";
			} else if (active.equals("true")) {
				sql = "SELECT * FROM public.question where active = true ORDER BY created_at DESC";
			} else {
				sql = "SELECT * FROM public.question where active = false ORDER BY created_at DESC";
			}
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionModel question = new QuestionModel();
				question.setQuestion_id(rs.getInt("question_id"));
				question.setProduct_id(rs.getInt("product_id"));
				question.setActive(rs.getBoolean("active"));
				question.setType(rs.getString("type"));
				question.setDescription(rs.getString("description"));
				question.setSolution(rs.getString("solution"));
				question.setCreated_at(rs.getDate("created_at"));
				question_list.add(question);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return question_list;
	}

	public ArrayList<QuestionModel> all_dates(String date_init, String date_end) {

		String sql = "";
		try {
			sql = "SELECT * FROM public.question where created_at > ? and createad_at <= ? ORDER BY created_at DESC";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, date_init);
			
			ps.setString(1, date_end);

			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionModel question = new QuestionModel();
				question.setQuestion_id(rs.getInt("question_id"));
				question.setProduct_id(rs.getInt("product_id"));
				question.setActive(rs.getBoolean("active"));
				question.setType(rs.getString("type"));
				question.setDescription(rs.getString("description"));
				question.setSolution(rs.getString("solution"));
				question.setCreated_at(rs.getDate("created_at"));
				question_list.add(question);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return question_list;
	}
}
