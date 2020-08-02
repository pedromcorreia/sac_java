/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductModel;

/**
 *
 * @author pedro
 */
@WebServlet(name = "ProductId", urlPatterns = {"/ProductId"})
public class ProductId extends HttpServlet {

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
			out.println("<title>Servlet ProductId</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet ProductId at " + request.getContextPath() + "</h1>");
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
			request.getRequestDispatcher("Login").include(request, response);
		} else {
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			ProductDAO productDAO = new ProductDAO();
			ProductModel product = productDAO.get_by_id(product_id);

			request.setAttribute("product", product);
			request.getRequestDispatcher("views/product_id.jsp").forward(request, response);
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
			request.getRequestDispatcher("Login").include(request, response);
		} else {
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			ProductDAO productDAO = new ProductDAO();
			if (request.getParameter("button").equals("delete")) {
				productDAO.delete(product_id);
			} else {
				ProductModel productModel = new ProductModel();
				productModel.setProduct_id(product_id);
				productModel.setDescription(request.getParameter("description"));
				productModel.setName(request.getParameter("name"));
				productModel.setWeight(Integer.parseInt(request.getParameter("weight")));
				productModel.setCategory_id(Integer.parseInt(request.getParameter("category_id")));

				productDAO.update(productModel);
			}

			response.sendRedirect("Product");
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
