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
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean f=false;
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String todo=request.getParameter("todo");
		String status=request.getParameter("status");
		TodoDAO d=new TodoDAO(DBconn.getConn());
		TodoDtls l=new TodoDtls();
		l.setId(id);
		l.setName(name);
		l.setTodo(todo);
		l.setStatus(status);
		if(name.length()>=3&&todo.length()!=0&&(status.equalsIgnoreCase("pending")||status.equalsIgnoreCase("complete"))) {
		f=d.updateTodo(l);
		}
		HttpSession session=request.getSession();
		if(f) {
			session.setAttribute("sucMsg","ToDo Update Sucessfully");
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("fMsg","Field is requird");
			response.sendRedirect("index.jsp");
		} 
	}

	
}
