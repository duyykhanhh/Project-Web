package garanweb.controller.admin;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import garanweb.dao.*;
import garanweb.entity.Account;
import garanweb.entity.Product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(name = "HomeAdminController", urlPatterns = { "/admin-trang-chu" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
	private ProductDao productdao;
	private OrderDao orderdao;
	private OrderDetailDao orderdetaildao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
		userdao = new UserDao();
		productdao = new ProductDao();
		orderdao = new OrderDao();
		orderdetaildao = new OrderDetailDao();
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
		try {
			Account user = null;
			HttpSession session = request.getSession();
			user = (Account)session.getAttribute("user_session");
			if(user != null) {
				int numberUser = userdao.count();
				int numberProduct = productdao.count();
				int numberOrder = orderdao.count();
				int numberOrderdetail = orderdetaildao.count();
				request.setAttribute("totalProduct", numberProduct);
				request.setAttribute("totalUser", numberUser);
				request.setAttribute("totalOrder", numberOrder);
				request.setAttribute("numberOrderdetail", numberOrderdetail);
				request.getRequestDispatcher("view/admin/index.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
