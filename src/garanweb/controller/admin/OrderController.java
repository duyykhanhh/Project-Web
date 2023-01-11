package garanweb.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import garanweb.dao.*;
import garanweb.entity.*;

/**
 * Servlet implementation class OrderController
 */
@WebServlet(name = "AdminOrderController", urlPatterns = { "/admin-order", "/admin-add-order", "/admin-edit-order",
		"/admin-delete-order" })
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao dao;
	private UserDao userdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new OrderDao();
		userdao = new UserDao();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			Account user = null;
			HttpSession session = request.getSession();
			user = (Account) session.getAttribute("user_session");
			if (user != null) {
				String url = request.getRequestURL().toString();
				if (url.contains("add")) {
					List<Account> listuser = userdao.getAllUser();
					request.setAttribute("listUser", listuser);
					request.getRequestDispatcher("view/admin/add/add-order.jsp").forward(request, response);
				} else if (url.contains("edit")) {
					load(request, response);
				} else if (url.contains("delete")) {
					delete(request, response);
				} else {
					list(request, response);
				}
			}else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			String address = request.getParameter("address");
			address = new String(address.getBytes("ISO8859_1"), "UTF-8");

			String phone = request.getParameter("phoneNumber");
			phone = new String(phone.getBytes("ISO8859_1"), "UTF-8");

			BigDecimal price = new BigDecimal(request.getParameter("totalPrice"));
			int status = request.getParameter("status").equals("true") ? 1 : 0;
			int user_id = Integer.parseInt(request.getParameter("userId"));
			Order item = new Order(0, address, phone, price, status, user_id);
			dao.add(item);
			response.sendRedirect(request.getContextPath() + "/admin-order");
		} catch (Exception e) {
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Order> list = null;
		list = dao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("view/admin/admin-order.jsp").forward(request, response);
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		Integer id = Integer.parseInt(request.getParameter("id"));
		String address = request.getParameter("address");
		address = new String(address.getBytes("ISO8859_1"), "UTF-8");

		String phone = request.getParameter("phoneNumber");
		phone = new String(phone.getBytes("ISO8859_1"), "UTF-8");

		BigDecimal price = new BigDecimal(request.getParameter("totalPrice"));
		int status = request.getParameter("status").equals("true") ? 1 : 0;
		int user_id = Integer.parseInt(request.getParameter("userId"));
		Order item = new Order(0, address, phone, price, status, user_id);
		item.setId(id);
		dao.update(item);
		response.sendRedirect(request.getContextPath() + "/admin-order");
	}

	public void load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Order item = dao.getItem(id);
		System.out.println(item.toString());
		List<Account> listuser = userdao.getAllUser();
		request.setAttribute("listUser", listuser);
		request.setAttribute("item", item);
		request.getRequestDispatcher("view/admin/edit/edit-order.jsp").forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		dao.delete(id);
		response.sendRedirect(request.getContextPath() + "/admin-order");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String cmd = request.getParameter("command");
			if (cmd == null) {
				cmd = "LIST";
			}
			switch (cmd) {
			case "ADD":
				add(request, response);
				break;
			case "LIST":
				list(request, response);
				break;
			case "EDIT":
				edit(request, response);
				break;
			case "LOAD":
				load(request, response);
				break;
			case "DELETE":
				delete(request, response);
				break;

			default:
				list(request, response);
			}
		} catch (Exception e) {
		}
	}

}
