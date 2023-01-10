package garanweb.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import garanweb.context.*;
import garanweb.entity.*;

public class ProductDao {
	static final String INSERT = "INSERT INTO products(name, image, price) VALUES(?, ?, ?)";
	static final String GET_ALL = "SELECT * FROM products";
	static final String LOAD_ITEM = "SELECT * FROM products where id = ?";
	static final String UPDATE_ITEM = "UPDATE products SET name = ?, image = ?, price = ? WHERE id = ?";
	static final String DELETE_ITEM  = "DELETE FROM products where id = ?";
	public boolean add(Product item) throws SQLException {
		boolean success = false;
		Connection cnt = null;
		PreparedStatement psmt = null;
		try {
			cnt = Dbcontext.getConnection();
			if (cnt != null) {
				psmt = cnt.prepareStatement(INSERT);
				psmt.setString(1, item.getName());
				psmt.setString(2, item.getImage());
				psmt.setBigDecimal(3, item.getPrice());
				success = psmt.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (psmt != null) {
				psmt.close();
			}
			if (cnt != null) {
				cnt.close();
			}
		}
		return success;
	}

	// Hien thi danh sach item
	public List<Product> findAll() throws SQLException {
		List<Product> list = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = Dbcontext.getConnection();
			if (cn != null) {
				pst = cn.prepareStatement(GET_ALL);
				rs = pst.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String image = rs.getString("image");
					BigDecimal price = rs.getBigDecimal("price");
					Product item = new Product(id, name, image, price);
					list.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (cn != null) {
				cn.close();
			}
		}
		return list;
	}
	public List<Product> findAll(int maxResult) throws SQLException {
		List<Product> list = new ArrayList<>();
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int i = 1;
		try {
			cn = Dbcontext.getConnection();
			if (cn != null) {
				pst = cn.prepareStatement(GET_ALL);
				rs = pst.executeQuery();
				while (rs.next() && i <= 9) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String image = rs.getString("image");
					BigDecimal price = rs.getBigDecimal("price");
					Product item = new Product(id, name, image, price);
					i++;
					list.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (cn != null) {
				cn.close();
			}
		}
		return list;
	}
	public Product getItem(int id) throws Exception {

		Product item = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// get connection to database
			myConn = Dbcontext.getConnection();

			// create sql to get selected student
			String sql = LOAD_ITEM;

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, id);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				int ID = myRs.getInt("id");
				String name = myRs.getString("name");
				String image = myRs.getString("image");
				BigDecimal price = myRs.getBigDecimal("price");
				item = new Product(ID, name, image, price);
			}
		} finally {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}
		return item;
	}

	public void update(Product item) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = Dbcontext.getConnection();

			// create SQL update statement
			String sql = UPDATE_ITEM;

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, item.getName());
			myStmt.setString(2, item.getImage());
			myStmt.setBigDecimal(3, item.getPrice());
			myStmt.setInt(4, item.getId());

			// execute SQL statement
			myStmt.execute();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	public void delete(int id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get connection to database
			myConn = Dbcontext.getConnection();

			// create SQL delete statement
			String sql = DELETE_ITEM;

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, id);

			// execute SQL statement
			myStmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			close(myConn, myStmt, null);
		}

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
