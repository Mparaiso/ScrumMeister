package dal;

import java.sql.*;

import eshop.Book;

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

}
