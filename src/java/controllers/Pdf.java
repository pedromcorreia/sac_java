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
import utils.PdfUtils;

/**
 *
 * @author pedro
 */
@WebServlet(name = "Document", urlPatterns = {"/Document"})
public class Pdf extends HttpServlet {

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
			out.println("<title>Servlet Document</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Document at " + request.getContextPath() + "</h1>");
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

			request.getRequestDispatcher("views/document.jsp").forward(request, response);
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
			if (request.getParameter("pdf").equals("users")) {
				UserDAO userDAO = new UserDAO();
				PdfUtils.GenerateUser(userDAO.all((Integer) request.getSession().getAttribute("id")));
			}
			if (request.getParameter("pdf").equals("questions")) {
				QuestionDAO questionDAO = new QuestionDAO();
				PdfUtils.GenerateQuestions(questionDAO.all_top());
			}
			if (request.getParameter("pdf").equals("sac")) {
				request.getParameter("type");
				QuestionDAO questionDAO = new QuestionDAO();
				PdfUtils.GenerateQuestionsAll(questionDAO.all_by_type(request.getParameter("type")));
			}
			if (request.getParameter("pdf").equals("question_date")) {
				
				String date_init = request.getParameter("datepicker");
				String date_end = request.getParameter("datepickere");
				QuestionDAO questionDAO = new QuestionDAO();
				PdfUtils.GenerateQuestionsAll(questionDAO.all_dates(date_init, date_end));
			}

			response.sendRedirect("QuestionManager");
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
