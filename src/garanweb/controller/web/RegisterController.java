package garanweb.controller.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import garanweb.dao.UserDao;
import garanweb.entity.Account;
import garanweb.entity.UserError;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
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
		request.getRequestDispatcher("view/web/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		try {
			String email = request.getParameter("email");
			if (dao.checkDupEmail(email)) {
				request.setAttribute("USER_ERROR", "This email has been registered!");
				request.getRequestDispatcher("view/web/register.jsp").forward(request, response);
			} else {
				String name = request.getParameter("name");
				name = new String(name.getBytes("ISO8859_1"), "UTF-8");
				String passWord = request.getParameter("password");
				String phone = request.getParameter("phone");
				Account account = new Account(name, passWord, email, phone);
				dao.add(account);
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("USER_ERROR", "Can not register, please try again later!");
			request.getRequestDispatcher("view/web/register.jsp").forward(request, response);
		}
	}

}
