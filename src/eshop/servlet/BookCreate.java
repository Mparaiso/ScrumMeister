package eshop.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import eshop.model.Book;

/**
 * Servlet implementation class BookCreate
 */
public class BookCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("bookcreate.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		RequestDispatcher view = request.getRequestDispatcher("bookcreate.jsp");
		view.forward(request, response);
	}

}
