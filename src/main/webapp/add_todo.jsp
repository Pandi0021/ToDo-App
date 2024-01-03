

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
	<div class="container mt-5">
		<div class="mb-3 mt-3">
			<div class="card">
				<div class="card-body col md-6">
					<h1 class="text-success text-center">Add ToDo</h1>
					<form action="Add_todo" action="post">
						<div class="">
							<label for="todo" class="form-label">Name:</label> <input
								type="text" class="form-control" id="name"
								placeholder="Enter Name" name="name">
						</div>
						<div class="">
							<label for="todo" class="form-label">ToDo:</label> <input
								type="text" class="form-control" id="todo"
								placeholder="Enter ToDo" name="todo">
						</div>
						<div class="">
							<label for="pwd" class="form-label">Status:</label> <select
								class="form-select" name="status">
								<option value="Complete">Complete</option>
								<option value="Pending">Pending</option>
							</select>
						</div>
						<br>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>