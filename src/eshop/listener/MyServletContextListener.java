package eshop.listener;

import javax.servlet.*;
import javax.servlet.ServletContextListener;
import dal.*;

import model.Beer;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// IDataManager
		// dm=(IDataManager)e.getServletContext().getAttribute("dm");
		// dm.putConnection(conn)
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		ServletContext c = e.getServletContext();
		// creation du data manager disponible dans l'app via le servlet context
		IDataManager dm = new DataManager(c.getInitParameter("jdbcDriver"),
				c.getInitParameter("dbUrl"), c.getInitParameter("dbUsername"),
				c.getInitParameter("dbPassword"));
		c.setAttribute("dm", dm);
		BookPeer bp = new BookPeer(dm, "eshop_books");
		c.setAttribute("BookPeer", bp);
	}

}
