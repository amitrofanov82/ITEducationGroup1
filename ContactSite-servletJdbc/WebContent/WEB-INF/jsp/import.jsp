<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Import contacts</title>
</head>
<body>
	<div class="container">
		<label>Import it!</label>
		<form action="import" method="post" enctype="multipart/form-data">
			<input type="file" id="myFile" name="filePath" class="file">
			<input type="submit" class="btn btn-default" value="Import">
		</form>
		<h2>${uploadMessage}</h2>
		<br> <a class="btn btn-info"
			href="${pageContext.request.contextPath}">On start page</a>
	</div>
</body>
</html>