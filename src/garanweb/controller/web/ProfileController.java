package garanweb.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import garanweb.dao.UserDao;
import garanweb.entity.Account;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet({ "/user-profile", "/user-edit-profile" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new UserDao();
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
		request.getRequestDispatcher("view/web/user-profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String cmd = request.getParameter("command");
			Account user = null;
			HttpSession session = request.getSession();
			user = (Account) session.getAttribute("user_session");
			if (cmd.equals("EDIT")) {
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");

				String email = request.getParameter("email");
				String password = request.getParameter("password");

				if (!email.equals(user.getEmail())) {
					if (dao.checkDupEmail(email)) {
						request.setAttribute("error", "Email is exist");
						request.getRequestDispatcher("view/web/update-profile.jsp").forward(request, response);
					} else {
						name = new String(name.getBytes("ISO8859_1"), "UTF-8");
						user.setName(name);
						user.setPassword(password);
						password = new String(password.getBytes("ISO8859_1"), "UTF-8");
						user.setPhone(phone);
						user.setEmail(email);
						email = new String(email.getBytes("ISO8859_1"), "UTF-8");
						dao.update(user);
						session.setAttribute("user_session", user);
						request.setAttribute("user", user);
						request.getRequestDispatcher("view/web/user-profile.jsp").forward(request, response);
					}
				} else {
					user.setName(name);
					name = new String(name.getBytes("ISO8859_1"), "UTF-8");
					user.setPassword(password);
					password = new String(password.getBytes("ISO8859_1"), "UTF-8");
					user.setPhone(phone);
					dao.update(user);
					session.setAttribute("user_session", user);
					request.setAttribute("user", user);
					request.getRequestDispatcher("view/web/user-profile.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("user", user);
				request.getRequestDispatcher("view/web/update-profile.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getRequestDispatcher("view/web/user-profile.jsp").forward(request, response);
		}
	}

}
