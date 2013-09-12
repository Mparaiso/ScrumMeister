package dal;

import java.sql.*;
import java.util.*;

public abstract class Peer<Model> implements IPeer {
	protected IDataManager dataManager;
	protected String tableName;

	public Peer(IDataManager dataManager, String tableName) {
		this.dataManager = dataManager;
		this.tableName = tableName;
	}

	abstract Model resultSetToModel(ResultSet rs) throws SQLException;

	ArrayList<Model> findAll() throws SQLException {
		ArrayList<Model> a = new ArrayList<Model>();
		Connection conn = dataManager.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from " + tableName);
		while (rs.next()) {
			a.add(resultSetToModel(rs));
		}
		return a;
	}

	Model find(int id) throws SQLException {
		Model model = null;
		Connection conn = dataManager.getConnection();
		// @note @java @servlet requetes préparées
		// http://stackoverflow.com/questions/3451269/parameterized-oracle-sql-query-in-java
		String sql = "select * from " + tableName + " where id = ? ";
		PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		if (rs.next()) {
			model = resultSetToModel(rs);
		}
		dataManager.putConnection(conn);
		return model;
	}

}
