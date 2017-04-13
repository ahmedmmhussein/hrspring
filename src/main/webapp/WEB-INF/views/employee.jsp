<%-- 
    Document   : registerationForm
    Created on : Apr 6, 2017, 10:29:48 AM
    Author     : ahussein
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
<title>Registration Page</title>
</head>
<body>
	<table align="center" cellpadding="10">

		<!----- ID ---------------------------------------------------------->
		<tr>
			<td><s:message code="employees.id" /></td>
			<td><span><c:out value="${employee.id}" /></span></td>
		</tr>
		<!----- First Name ---------------------------------------------------------->
		<tr>
			<td><s:message code="register.name" /></td>
			<td><span><c:out value="${employee.name}" /></span></td>
		</tr>

		<!----- Date Of Birth -------------------------------------------------------->
		<tr>
			<td><s:message code="register.date" /></td>
			<td><span><fmt:formatDate type="date"
						value="${employee.dataofBirth}" /></span></td>
		</tr>

		<!----- Age -------------------------------------------------------->
		<tr>
			<td><s:message code="employees.age" /></td>
			<td><span><c:out value="${employee.age}" /></span></td>
		</tr>

		<!----- Salary ---------------------------------------------------------->
		<tr>
			<td><s:message code="register.salary" /></td>
			<td><span><fmt:setLocale value="${info.locale}"
						scope="session" />
					<fmt:formatNumber value="${employee.salary}" type="currency" /></span></td>
		</tr>

		<!----- Job title ---------------------------------------------------------->
		<tr>
			<td><s:message code="register.title" /></td>
			<td><span><c:out value="${employee.jobTitle}" /></span></td>
		</tr>

		<!----- Department ---------------------------------------------------------->
		<tr>
			<td><s:message code="register.department" /></td>
			<td><span><c:out value="${employee.department}" /></span></td>
		</tr>


		<!----- Email ---------------------------------------------------------->
		<tr>
			<td><s:message code="register.email" /></td>
			<td><span><c:out value="${employee.email}" /></span></td>
		</tr>
	</table>
	<br />
	<br />
	<a href="<c:url value="/employees" />"><s:message
			code="home.view.all" /></a>
	<br />
</body>
</html>
