package dal;

import java.sql.*;

public class DataManager implements IDataManager {
	private String dbPassword;
	private String dbUsername;
	private String dbUrl;
	private String driver;

	/**
	 * créer un nouveau data manager
	 * 
	 * @param driver
	 * @param dbUrl
	 * @param dbUsername
	 * @param dbPassword
	 */
	public DataManager(String driver, String dbUrl, String dbUsername,
			String dbPassword) {
		this.setDriver(driver);
		this.setDbUrl(dbUrl);
		this.setDbUsername(dbUsername);
		this.setDbPassword(dbPassword);
	}

	/* (non-Javadoc)
	 * @see dal.IDataManager#putConnection(java.sql.Connection)
	 */
	@Override
	public void putConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see dal.IDataManager#getConnection()
	 */
	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(getDbUrl(), getDbUsername(),
					getDBPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	private String getDBPassword() {
		return dbPassword;
	}

	private String getDbUrl() {
		return dbUrl;
	}

	private String getDbUsername() {
		return dbUsername;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
}
