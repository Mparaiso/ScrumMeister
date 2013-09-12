import javax.servlet.*;

import model.Beer;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext c = e.getServletContext();
		Beer beer = new Beer();
		beer.setBrand(c.getInitParameter("brand"));
		beer.setName( c.getInitParameter("name"));
		c.setAttribute("beer", beer);
	}

}
