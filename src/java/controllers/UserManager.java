/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.QuestionDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.QuestionModel;
import model.UserModel;

/**
 *
 * @author pedro
 */
@WebServlet(name = "UserManager", urlPatterns = {"/UserManager"})
public class UserManager extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet UserManager</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet UserManager at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (null == session.getAttribute("name") || !session.getAttribute("role").equals("manager")) {
			request.getRequestDispatcher("Login").include(request, response);
		} else {
			QuestionDAO questionDAO = new QuestionDAO();
			ArrayList<QuestionModel> questions = questionDAO.all_for_employee();
			request.setAttribute("questions", questions);
			ArrayList<QuestionModel> questions_opened = questionDAO.all_opened();
			request.setAttribute("questions_opened", questions_opened);
			Integer percentual = 0;
			if (questions_opened.isEmpty()) {
				request.setAttribute("percentual", percentual);
			} else {
				Float percentuals = (float) questions_opened.size() / questions.size();
				request.setAttribute("percentual", (percentuals * 100));
			}

			UserDAO userDAO = new UserDAO();
			ArrayList<UserModel> users = userDAO.all((Integer) request.getSession().getAttribute("id"));
			request.setAttribute("users", users);
			request.getRequestDispatcher("views/user.jsp").forward(request, response);
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (null == session.getAttribute("name") || !session.getAttribute("role").equals("manager")) {
			request.getRequestDispatcher("Login").include(request, response);
		} else {
			UserModel user = new UserModel();
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setCpf(request.getParameter("cpf"));
			user.setRole(request.getParameter("role"));
			UserDAO userDAO = new UserDAO();
			userDAO.create_manager(user);
			response.sendRedirect("UserManager");
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
