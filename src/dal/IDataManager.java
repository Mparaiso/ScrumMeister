package dal;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataManager {

	/**
	 * Ferme la connection
	 * 
	 * @param conn
	 */
	public abstract void putConnection(Connection conn);

	public abstract Connection getConnection() throws SQLException;

}