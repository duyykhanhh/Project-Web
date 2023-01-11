package garanweb.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import garanweb.context.Dbcontext;
import garanweb.entity.Order;
import garanweb.entity.OrderItem;

public class OrderDetailDao {
	static final String INSERT = "INSERT INTO orderitem(quantity, price, orderId, productId) VALUES(?, ?, ?, ?)";
	static final String GET_ALL = "SELECT * FROM orderitem";
	static final String COUNT = "SELECT COUNT(*) FROM orderitem";
	static final String LOAD_ITEM = "SELECT * FROM orderitem where id = ?";
	static final String UPDATE_ITEM = "UPDATE orderitem SET quantity = ?, price = ?, orderId = ?, productId = ? WHERE id = ?";
	static final String DELETE_ITEM = "DELETE FROM orderitem where id = ?";

	public int count() {
		int count = 0;
		try {
			Connection cnt = Dbcontext.getConnection();
			Statement st = cnt.createStatement();
			ResultSet rs = st.executeQuery(COUNT);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean add(OrderItem item) throws SQLException {
		boolean success = false;
		Connection cnt = null;
		PreparedStatement psmt = null;
		try {
			cnt = Dbcontext.getConnection();
			if (cnt != null) {
				psmt = cnt.prepareStatement(INSERT);
				psmt.setInt(1, item.getQuantity());
				psmt.setBigDecimal(2, item.getPrice());
				psmt.setInt(3, item.getOrderId());
				psmt.setInt(4, item.getProductId());
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
	public List<OrderItem> findAll() throws SQLException {
		List<OrderItem> list = new ArrayList<>();
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
					int quantity = rs.getInt("quantity");
					BigDecimal price = rs.getBigDecimal("price");
					int orderId = rs.getInt("orderId");
					int productId = rs.getInt("productId");
					OrderItem item = new OrderItem(id, quantity, price, orderId, productId);
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

	public OrderItem getItem(int id) throws Exception {

		OrderItem item = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;

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
			rs = myStmt.executeQuery();

			// retrieve data from result set row
			if (rs.next()) {
				int quantity = rs.getInt("quantity");
				BigDecimal price = rs.getBigDecimal("price");
				int orderId = rs.getInt("orderId");
				int productId = rs.getInt("productId");
				item = new OrderItem(id, quantity, price, orderId, productId);
			}
		} finally {
			if (rs != null) {
				rs.close();
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

	public void update(OrderItem item) throws Exception {

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
			myStmt.setInt(1, item.getQuantity());
			myStmt.setBigDecimal(2, item.getPrice());
			myStmt.setInt(3, item.getOrderId());
			myStmt.setInt(4, item.getProductId());
			myStmt.setInt(5, item.getId());
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
