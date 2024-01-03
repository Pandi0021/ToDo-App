<%@ page import="dbConn.DBconn"%>
<%@ page import="todoMethods.TodoDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="tododataList.TodoDtls"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add-Todo</title>
<jsp:include page="component/css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="component/header.jsp"></jsp:include>
	<%
	String sMsg = (String) session.getAttribute("sucMsg");
		if (sMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=sMsg%></div>
	<%
	session.removeAttribute("sucMsg");
		}
	%>
	<%
	String fMsg = (String) session.getAttribute("fMsg");
		if (fMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=fMsg%></div>
	<%
	session.removeAttribute("fMsg");
		}
	%>
	<div class="p-1 text-success text-center">
		<h1>ToDo</h1>
	</div>
	<div class="container mt-5">

		<table class="table table-hover table-striped text-white ">
			<thead class="table-success text-white">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>TODO</th>
					<th>STATUS</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<tbody>
				<%
				TodoDAO dao = new TodoDAO(DBconn.getConn());
						List<TodoDtls> d = dao.getTodo();
						for (TodoDtls t : d) {
				%>
				<tr>
					<td><%=t.getId()%></td>
					<td><%=t.getName()%></td>
					<td><%=t.getTodo()%></td>
					<td><%=t.getStatus()%></td>
					<td><a href="edit.jsp?id=<%=t.getId()%>"
						class="btn btn-sm btn-success">Edit</a> <a
						href="Delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	</div>

	<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
