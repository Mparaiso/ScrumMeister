import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BeerExpert;

/**
 * Servlet implementation class SelectBeerServlet
 */
@WebServlet(description = "Select a beer", urlPatterns = { "/SelectBeer" })
public class SelectBeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		// @note @servlet récuperer les données de formulaire
		String beerColor = request.getParameter("color");
		BeerExpert beerExpert = new BeerExpert();
		List<String> beerList = beerExpert.getBrands(beerColor);
		// @note @servlet @java passer un paramètre à la vue
		request.setAttribute("color", beerColor);
		request.setAttribute("beers", beerList);
		// @note @servlet @java appeler un template jsp
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("form.jsp");
		view.forward(request, response);
	}

}
