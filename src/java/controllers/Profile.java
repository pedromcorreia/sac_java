/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.LoginDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserModel;

/**
 *
 * @author pedro
 */
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

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
			out.println("<title>Servlet Profile</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Profile at " + request.getContextPath() + "</h1>");
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
		if (null == session.getAttribute("name")) {
			request.getRequestDispatcher("Login").include(request, response);
		} else {
			UserDAO userDAO = new UserDAO();
			Integer id = (Integer) request.getSession().getAttribute("id");

			UserModel user = userDAO.get_by_id(id);

			request.setAttribute("user", user);
			request.getRequestDispatcher("views/profile.jsp").forward(request, response);
			processRequest(request, response);
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
		if (null == session.getAttribute("name")) {
			request.getRequestDispatcher("Login").include(request, response);
		} else {
			UserDAO userDAO = new UserDAO();
			UserModel user = new UserModel();
			user.setId((Integer) request.getSession().getAttribute("id"));
			user.setName(request.getParameter("name"));
			user.setPhone(request.getParameter("phone"));
			user.setStreet(request.getParameter("street"));
			user.setNumber(request.getParameter("number"));
			user.setComplement(request.getParameter("complement"));
			user.setNeighborhood(request.getParameter("neighborhood"));
			user.setZipcode(request.getParameter("zipcode"));
			user.setCity(request.getParameter("city"));
			user.setState(request.getParameter("state"));
			userDAO.update(user);
			response.sendRedirect("Profile");
			processRequest(request, response);
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
