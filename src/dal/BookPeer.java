package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import eshop.model.Book;

public class BookPeer extends Peer<Book> {

	public BookPeer(IDataManager dataManager, String tableName) {
		super(dataManager, tableName);
	}

	@Override
	Book resultSetToModel(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt(rs.findColumn("id")));
		book.setTitle(rs.getString(rs.findColumn("title")));
		book.setAuthor(rs.getString(rs.findColumn("author")));
		book.setPrice(rs.getDouble(rs.findColumn("price")));
		book.setCategory_id(rs.getInt(rs.findColumn("category_id")));
		return book;
	}

	@Override
	HashMap<String, Object> ModelToSet(Book model) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", model.getId());
		hash.put("title", model.getTitle());
		hash.put("author", model.getAuthor());
		hash.put("price", model.getPrice());
		hash.put("category_id", model.getCategory_id());
		return hash;
	}

}
