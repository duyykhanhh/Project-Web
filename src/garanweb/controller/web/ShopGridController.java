package garanweb.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import garanweb.dao.ProductDao;
import garanweb.entity.Product;

/**
 * Servlet implementation class ShopGridController
 */
@WebServlet("/thuc-don")
public class ShopGridController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopGridController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new ProductDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Product> list = dao.findAll();
			int totalProduct = list.size();
			request.setAttribute("totalProduct", totalProduct);
			request.setAttribute("list", list);
			request.getRequestDispatcher("view/web/shop-grid.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
