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

public class OrderDao {
	static final String INSERT = "INSERT INTO orders(address, phone, totalPrice, status, user_id) VALUES(?, ?, ?, ?, ?)";
	static final String GET_ALL = "SELECT * FROM orders";
	static final String COUNT = "SELECT COUNT(*) FROM orders";
	static final String LOAD_ITEM = "SELECT * FROM orders where id = ?";
	static final String UPDATE_ITEM = "UPDATE orders SET address = ?, phone = ?, totalPrice = ?, status = ?, user_id = ? WHERE id = ?";
	static final String DELETE_ITEM = "DELETE FROM orders where id = ?";

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

	public boolean add(Order item) throws SQLException {
		boolean success = false;
		Connection cnt = null;
		PreparedStatement psmt = null;
		try {
			cnt = Dbcontext.getConnection();
			if (cnt != null) {
				psmt = cnt.prepareStatement(INSERT);
				psmt.setString(1, item.getAddress());
				psmt.setString(2, item.getPhone());
				psmt.setBigDecimal(3, item.getTotalPrice());
				psmt.setInt(4, item.getStatus());
				psmt.setInt(5,item.getUser_id());
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
	public List<Order> findAll() throws SQLException {
		List<Order> list = new ArrayList<>();
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
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					BigDecimal price = rs.getBigDecimal("totalPrice");
					int status = rs.getInt("status");
					int userId = rs.getInt("user_id");
					Order item = new Order(id, address, phone, price, status, userId);
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

	public Order getItem(int id) throws Exception {

		Order item = null;
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
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				BigDecimal price = rs.getBigDecimal("totalPrice");
				int status = rs.getInt("status");
				int userId = rs.getInt("user_id");
			 item = new Order(id, address, phone, price, status, userId);
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

	public void update(Order item) throws Exception {

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
			myStmt.setString(1, item.getAddress());
			myStmt.setString(2, item.getPhone());
			myStmt.setBigDecimal(3, item.getTotalPrice());
			myStmt.setInt(4, item.getStatus());
			myStmt.setInt(5, item.getUser_id());
			myStmt.setInt(6, item.getId());
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
