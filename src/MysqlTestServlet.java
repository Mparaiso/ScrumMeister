import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MysqlTest
 */
@WebServlet("/MysqlTest")
public class MysqlTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		String connectionString = request.getServletContext().getInitParameter(
				"connectionString");
		String dbUsername = request.getServletContext().getInitParameter(
				"dbUsername");
		String dbPassword = request.getServletContext().getInitParameter(
				"dbPassword");
		try {
			Class.forName(request.getServletContext().getInitParameter(
					"jdbcDriver"));
			conn = DriverManager.getConnection(connectionString, dbUsername,
					dbPassword);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from test.eshop_books");
			ResultSetMetaData meta = rs.getMetaData();
			int cols = meta.getColumnCount();
			request.setAttribute("subtitle", "All the books in the shop");
			request.setAttribute("rs", rs);
			request.setAttribute("meta", meta);
			request.setAttribute("cols", cols);
			RequestDispatcher view = request
					.getRequestDispatcher("mysqltest.jsp");
			view.forward(request, response);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
