/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoryModel;

/**
 *
 * @author pedro
 */
@WebServlet(name = "CategoryId", urlPatterns = {"/CategoryId"})
public class CategoryId extends HttpServlet {

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
			out.println("<title>Servlet CategoryId</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet CategoryId at " + request.getContextPath() + "</h1>");
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
		if (null == session.getAttribute("name") || !session.getAttribute("role").equals("employee")) {
			request.getRequestDispatcher("views/new_user.jsp").include(request, response);
		} else {
			int category_id = Integer.parseInt(request.getParameter("category_id"));
			CategoryDAO categoryDAO = new CategoryDAO();
			CategoryModel category = categoryDAO.get_by_id(category_id);

			request.setAttribute("category", category);
			request.getRequestDispatcher("views/category_id.jsp").forward(request, response);
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
		if (null == session.getAttribute("name") || !session.getAttribute("role").equals("employee")) {
			request.getRequestDispatcher("views/new_user.jsp").include(request, response);
		} else {
			int category_id = Integer.parseInt(request.getParameter("category_id"));
			CategoryDAO categoryDAO = new CategoryDAO();
			if (request.getParameter("button").equals("delete")){
				categoryDAO.delete(category_id);
			}else{
			CategoryModel category = categoryDAO.get_by_id(category_id);
				categoryDAO.update(category_id, request.getParameter("name"));
			}
			
			response.sendRedirect("Category");
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
