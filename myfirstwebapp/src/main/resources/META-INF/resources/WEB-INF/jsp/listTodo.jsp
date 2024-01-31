<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="webjar/bootstrap/5.1.3/css/boostrap.min.css" rel="stylesheet">
<title>ListTodo Page</title></head>
<body>

<div class="container">
	<div>Welcome to the {name}todo page!</div>
<hr><H1>Your Todos are</H1>
	<div>Your todo are ${todos}</div>
	<table>
	<thead>
		<tr>
			<th>id</th>
			<th>Description</th>
			<th>Target Date</th>
			<th>Is Done?</th>
		<tr>
</thead>
<tbody>
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.description}</td>
			<td>${todo.targetDate}</td>
			<td>${todo.done}</td>
			<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
			<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
			
		</tr>
	</c:forEach>
</tbody>
</table>
<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<script scr="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script scr="webjars/query/3.6.0/jquery.min.js"></script>
</body></html>