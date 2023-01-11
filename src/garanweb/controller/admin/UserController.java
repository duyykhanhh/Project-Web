package garanweb.controller.admin;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import garanweb.dao.UserDao;
import garanweb.entity.*;
import java.util.*;

@WebServlet(urlPatterns = { "/admin-user", "/admin-edit-user", "/admin-delete-user" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new UserDao();
	}

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
		try {
			Account user = null;
			HttpSession session = request.getSession();
			user = (Account) session.getAttribute("user_session");
			if (user != null) {
				String url = request.getRequestURL().toString();
				if (url.contains("edit")) {
					load(request, response);
				} else if (url.contains("delete")) {
					delete(request, response);
				} else {
					list(request, response);
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}

		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Account> list = null;
		list = dao.getAllUser();
		request.setAttribute("list", list);
		request.getRequestDispatcher("view/admin/admin-user.jsp").forward(request, response);
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("fullName");
		name = new String(name.getBytes("ISO8859_1"), "UTF-8");
		String email = request.getParameter("email");
		String phone = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		int admin = 1;
		Account item = new Account(id, name, phone, email, password, admin);
		dao.update(item);
		response.sendRedirect(request.getContextPath() + "/admin-user");
	}

	public void load(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Account item = dao.getItem(id);
		System.out.println(item.toString());
		request.setAttribute("item", item);
		request.getRequestDispatcher("view/admin/edit/edit-user.jsp").forward(request, response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		dao.delete(id);
		response.sendRedirect(request.getContextPath() + "/admin-user");
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
