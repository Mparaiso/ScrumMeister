package eshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.*;
import eshop.*;
import eshop.model.Book;

import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class BookServlet
 */
// @WebServlet("/BookServlet")
public class BookIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BookPeer bp = (BookPeer) getServletContext().getAttribute("BookPeer");
		try {
			ArrayList<Book> books = bp.findAll();
			request.setAttribute("books", books);
			RequestDispatcher view = request.getRequestDispatcher("books.jsp");
			view.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
