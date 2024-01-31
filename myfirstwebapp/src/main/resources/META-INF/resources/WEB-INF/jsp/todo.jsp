<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="webjar/bootstrap/5.1.3/css/boostrap.min.css" rel="stylesheet">
<link href="webjar/bootstrap-datepicker/1.9.0/css/boostrap-datepicker.standalone.min.css" rel="stylesheet">

<title>Add Todos Page</title></head>
<body>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h1>Enter Todo Details</h1>
	<form:form  method="post" modelAttribute="todo">
	<fieldset class="mb-3">
	<form:label path="description">Description</form:label>
		<form:input type="text" path="description" required="required"/>
		<form:errors  path="description" cssClass="text-warning"/>
		
	</fieldset>
	<fieldset class="mb-3">
	<form:label path="targetDate">Target Date</form:label>
		<form:input type="text" path="targetDate" required="required"/>
		<form:errors  path="targetDate" cssClass="text-warning"/>
		
	</fieldset>
		<form:input type="hidden" path="id" />
		<form:input type="text" path="done"/>
		<input type="submit" class="btn" />
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
$('#targetDate').datepicker({
	format:'yyyy-mm-dd'
});
</script>

</body></html>