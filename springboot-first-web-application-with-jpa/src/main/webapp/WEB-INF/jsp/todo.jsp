<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
<div class="container">
		<h3>Add TODOs</h3>
	<form:form method="post" modelAttribute="todo">
	<!-- adding the hidden field for the id here -->
			<form:hidden path="id"></form:hidden>
			<fieldset class="form-group">
				<form:label path="desc">Description </form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning"></form:errors>
			</fieldset>
			<!-- replicating hereby the target date field so as to get populated -->
			<fieldset class="form-group">
				<form:label path="targDate">Date </form:label>
				<form:input path="targDate" type="text" class="form-control" required="required"/>
				<form:errors path="targDate" cssClass="text-warning"></form:errors>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
		</div>
<%@ include file="common/footer.jspf" %>		