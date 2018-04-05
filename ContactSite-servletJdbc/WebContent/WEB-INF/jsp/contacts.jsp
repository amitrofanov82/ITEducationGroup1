<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<title>Contacts</title>
</head>
<body>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Login</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
		</thead>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>
					<p>${contact.name}</p>
				</td>
				<td>
					<p>${contact.surname}</p>
				</td>
				<td>
					<p>${contact.login}</p>
				</td>
				<td>
					<p>${contact.email}</p>
				</td>
				<td>
					<p>${contact.phoneNumber}</p>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-info" href="${pageContext.request.contextPath}">On
		start page</a>

	<c:if test="${paginator.pagesCount > 1}">
		<div
			style="position: fixed; height: 100px; bottom: 0; width: 100%; text-align: center;">
			<div class="pagingDiv">
				<ul class="pagination">
					<c:forEach var="count" begin="1" end="${paginator.pagesCount}">
						<li><a
							href="${pageContext.request.contextPath}/contacts?currentPageNumber=${count}">${count}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>
</body>
</html>