import javax.servlet.*;

import dal.DataManager;
import dal.IDataManager;

import model.Beer;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		//IDataManager dm=(IDataManager)e.getServletContext().getAttribute("dm");
		//dm.putConnection(conn)
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext c = e.getServletContext();
		Beer beer = new Beer();
		beer.setBrand(c.getInitParameter("brand"));
		beer.setName( c.getInitParameter("name"));
		c.setAttribute("beer", beer);
		// creation du data manager disponible dans l'app via le servlet context
		IDataManager dm = new DataManager(c.getInitParameter("jdbcDriver"), c.getInitParameter("dbUrl"), c.getInitParameter("dbUsername"),c.getInitParameter("dbPassword"));
		c.setAttribute("dm",dm);
	}

}
