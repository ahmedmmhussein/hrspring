<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false"%>
<html>
<head>
<title>Hr System</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1><s:message code="hr.welcome" /></h1>

	<a href="<c:url value="/spittles" />">View all Employees</a> |
	<a href="<c:url value="/spitter/register" />">Register new Employee</a>
</body>
</html>
