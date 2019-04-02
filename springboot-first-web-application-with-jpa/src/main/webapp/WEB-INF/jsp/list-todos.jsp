<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
	<div class="container">
		<h2>Welcome, ${name}</h2>
		<br>
		<h3>Your TODOs List</h3>
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>Description</th>
					<th>Date</th>
					<th>Is it Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a class="btn btn-primary" 
						href="/update-todo?id=${todo.id}">Update</a> </td>
						<td><a class="btn btn-warning" 
						href="/delete-todo?id=${todo.id}">Delete</a> </td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div><a class="button" href="/add-todo">Add a TODOs </a></div>
	</div>
<%@ include file="common/footer.jspf" %>	