package dal;

import java.sql.Connection;

public interface IDataManager {

	/**
	 * Ferme la connection
	 * 
	 * @param conn
	 */
	public abstract void putConnection(Connection conn);

	public abstract Connection getConnection();

}