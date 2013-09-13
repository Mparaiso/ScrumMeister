package dal;

import java.sql.*;
import java.util.*;

public interface IPeer<Model> {
	Model find(int id) throws SQLException;

	ArrayList<Model> findAll() throws SQLException;
}
