package garanweb.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import garanweb.dao.OrderDao;
import garanweb.dao.OrderDetailDao;
import garanweb.dao.ProductDao;
import garanweb.entity.Account;
import garanweb.entity.Order;
import garanweb.entity.OrderItem;
import garanweb.entity.Product;

/**
 * Servlet implementation class OrderDetailController
 */
@WebServlet({ "/admin-order-detail", "/admin-add-order-detail", "/admin-delete-order-detail",
		"/admin-edit-order-detail" })
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailDao dao;
	private ProductDao productdao;
	private OrderDao orderdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDetailController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new OrderDetailDao();
		productdao = new ProductDao();
		orderdao = new OrderDao();
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
			if(user != null) {
				String url = request.getRequestURL().toString();
				if (url.contains("add")) {
					List<Order> listOrder = orderdao.findAll();
					List<Product> listProduct = productdao.findAll();
					request.setAttribute("listOrder", listOrder);
					request.setAttribute("listProduct", listProduct);
					request.getRequestDispatcher("view/admin/add/add-order-detail.jsp").forward(request, response);
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
			
			int productId = Integer.parseInt(request.getParameter("productId"));
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			OrderItem item = new OrderItem(0, quantity, price, orderId, productId);
			dao.add(item);
			response.sendRedirect(request.getContextPath() + "/admin-order-detail");
		} catch (Exception e) {
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<OrderItem> list = null;
		list = dao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("view/admin/admin-order-detail.jsp").forward(request, response);
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		OrderItem item = new OrderItem(0, quantity, price, orderId, productId);
		item.setId(id);
		dao.update(item);
		response.sendRedirect(request.getContextPath() + "/admin-order-detail");
	}

	public void load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		OrderItem item = dao.getItem(id);
		System.out.println(item.toString());
		List<Order> listOrder = orderdao.findAll();
		List<Product> listProduct = productdao.findAll();
		request.setAttribute("listOrder", listOrder);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("item", item);
		request.getRequestDispatcher("view/admin/edit/edit-order-detail.jsp").forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		dao.delete(id);
		response.sendRedirect(request.getContextPath() + "/admin-order-detail");
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
