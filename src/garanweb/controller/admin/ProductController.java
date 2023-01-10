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

import garanweb.dao.ProductDao;
import garanweb.entity.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet({ "/admin-product", "/admin-edit-product", "/admin-add-product", "/admin-delete-product" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new ProductDao();
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

			String url = request.getRequestURL().toString();
			if (url.contains("add")) {
				request.getRequestDispatcher("view/admin/add/add-product.jsp").forward(request, response);
			} else if (url.contains("edit")) {
				load(request, response);
			} else if (url.contains("delete")) {
				delete(request, response);
			} else {
				list(request, response);
			}
		} catch (Exception e) {
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			String name = request.getParameter("productName");
			name = new String(name.getBytes("ISO8859_1"), "UTF-8");
			String image = request.getParameter("image");
			image = new String(image.getBytes("ISO8859_1"), "UTF-8");
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			Product item = new Product(name, image, price);
			System.out.println(item.toString());
			dao.add(item);
//			list(request, response);
			response.sendRedirect(request.getContextPath() + "/admin-product");
		} catch (Exception e) {
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> list = null;
		list = dao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("view/admin/admin-product.jsp").forward(request, response);
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("productName");
		name = new String(name.getBytes("ISO8859_1"), "UTF-8");
		String image = request.getParameter("image");
		image = new String(image.getBytes("ISO8859_1"), "UTF-8");
		BigDecimal price = new BigDecimal(request.getParameter("price"));
		Product item = new Product(name, image, price);
		item.setId(id);

		dao.update(item);
		list(request, response);
	}

	public void load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product item = dao.getItem(id);
		request.setAttribute("item", item);
		System.out.println(item.toString());
		request.getRequestDispatcher("view/admin/edit/edit-product.jsp").forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id.toString());
		dao.delete(id);
		response.sendRedirect(request.getContextPath() + "/admin-product");
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
