package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import todoMethods.TodoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dbConn.DBconn;

/**
 * Servlet implementation class Add_todo
 */
public class Add_todo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add_todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean f = false;
		String name = request.getParameter("name");
		String todo = request.getParameter("todo");
		String status = request.getParameter("status");
		TodoDAO d = new TodoDAO(DBconn.getConn());
		if (name.length() >= 3 && todo.length() != 0
				&& (status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("complete"))) {
			f = d.addTodo(name, todo, status);
		}
		HttpSession session = request.getSession();
		if (f) {
			session.setAttribute("sucMsg", "Todo Add Sucessfully");
			response.sendRedirect("index.jsp");
		} else {
			session.setAttribute("fMsg", "Field is requird");
			response.sendRedirect("add_todo.jsp");
		}
	}

}
