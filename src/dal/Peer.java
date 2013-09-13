package dal;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;

public abstract class Peer<Model> implements IPeer<Model> {
	protected IDataManager dataManager;
	protected String tableName;

	public Peer(IDataManager dataManager, String tableName) {
		this.dataManager = dataManager;
		this.tableName = tableName;
	}

	abstract Model resultSetToModel(ResultSet rs) throws SQLException;

	abstract HashMap<String, Object> ModelToSet(Model model);

	public ArrayList<Model> findAll() throws SQLException {
		ArrayList<Model> a = new ArrayList<Model>();
		Connection conn = null;
		conn = dataManager.getConnection();

		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from " + tableName);
		while (rs.next()) {
			a.add(resultSetToModel(rs));
		}
		dataManager.putConnection(conn);
		return a;
	}

	public Model insert(Model model) throws SQLException {
		Connection conn = null;
		conn = dataManager.getConnection();
		HashMap<String, Object> hash = ModelToSet(model);
		String placeholders = "";
		String sql = "insert into " + tableName + "(";
		for (String col : hash.keySet()) {
			sql += col + ",";
			placeholders += "?,";
		}
		sql = sql.substring(0, sql.length() - 2);
		placeholders = placeholders.substring(0, placeholders.length() - 2);
		sql += ") values(" + placeholders + ")";
		//System.out.print(sql);
		PreparedStatement s = conn.prepareStatement(sql);
		Object[] vals=hash.values().toArray();
		int valLenght=vals.length;
		for(int i=1;i<=valLenght;i++){
			s.setObject(i, vals[i-1]);
		}
		s.executeUpdate();
		return model;
	}

	public Model find(int id) throws SQLException {
		Model model = null;
		Connection conn = null;
		conn = dataManager.getConnection();
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
