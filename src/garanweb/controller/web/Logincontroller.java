package garanweb.controller.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import garanweb.dao.UserDao;
import garanweb.entity.Account;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/login")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logincontroller() {
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
		request.getRequestDispatcher("view/web/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			String user_session = (String) session.getAttribute("user_session");
			if (user_session != null) {
				session.removeAttribute("user_session");
			}
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (dao.validate(email, password)) {
				Account tmp = dao.getItem1(email);
				session.setAttribute("user_session", tmp);

				if (tmp.getAdmin() == 0) {
					response.sendRedirect(request.getContextPath() + "/admin-trang-chu");
				} else {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}

			} else {
				request.setAttribute("notify", false);
				request.getRequestDispatcher("view/web/login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("notify", false);
			request.getRequestDispatcher("view/web/login.jsp").forward(request, response);
		}
	}

}
