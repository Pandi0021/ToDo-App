package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import todoMethods.TodoDAO;
import tododataList.TodoDtls;

import java.io.IOException;

import dbConn.DBconn;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TodoDAO d = new TodoDAO(DBconn.getConn());
		TodoDtls l = new TodoDtls();
		l.setId(id);
		boolean f = d.deleteTodo(l);
		HttpSession session = request.getSession();
		if (f) {
			session.setAttribute("sucMsg", "Todo delete Sucessfully");
			response.sendRedirect("index.jsp");
		} else {
			session.setAttribute("fMsg", "Todo delete Failed");
			response.sendRedirect("index.jsp");
		}
	}

}
