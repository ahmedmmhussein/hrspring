<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Hr System</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Welcome to Hr</h1>

	<a href="<c:url value="/employees" />">View all Employees</a> |
	<a href="<c:url value="/employee/register" />">Register new Employee</a>
</body>
</html>
