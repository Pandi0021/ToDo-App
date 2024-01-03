
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
<title>Todo-App</title>
<jsp:include page="component/css.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="component/header.jsp"></jsp:include>
	<div class="container mt-5">
		<div class="mb-3 mt-3">
			<div class="card">
				<div class="card-body col md-6">
					<h1 class="text-success text-center">Edit ToDo</h1>
					<%
					int i=Integer.parseInt(request.getParameter("id"));
								TodoDAO dao = new TodoDAO(DBconn.getConn());
								TodoDtls t = dao.getTodoById(i);
					%>
					<form action="Update" action="post" style="">
						<input type="hidden" class="form-control" placeholder="Enter id"
							name="id" value="<%=t.getId()%>">
						<div class="">
							<label for="todo" class="form-label">Name:</label> <input
								type="text" class="form-control" placeholder="Enter Name"
								name="name" value="<%=t.getName()%>">
						</div>
						<div class="">
							<label for="todo" class="form-label">ToDo:</label> <input
								type="text" class="form-control" placeholder="Enter ToDo"
								name="todo" value="<%=t.getTodo()%>">
						</div>
						<div class="">
							<label for="pwd" class="form-label">Status:</label> <select
								class="form-select" name="status">
								<%
								if ("Pending".equals(t.getStatus())) {
								%>
								<option value="Pending">Pending</option>
								<option value="Complete">Complete</option>
								<%
								} else {
								%>
								<option value="Complete">Complete</option>
								<option value="Pending">Pending</option>
								<%
								}
								%>
							</select>
						</div>
						<br>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>