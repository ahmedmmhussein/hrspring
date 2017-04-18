<%-- 
    Document   : registerationForm
    Created on : Apr 6, 2017, 10:29:48 AM
    Author     : ahussein
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://poet.com/jsp/tlds/mytags" prefix="mytags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
<title>Registration Page</title>
</head>
<body>
	<%@ include file="../jspf/languagebar.jspf"%>
	<table align="center" cellpadding="10">

		<!----- ID ---------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="employees.id" />
				</mytags:customLabel></td>
			<td><span><c:out value="${employee.id}" /></span></td>
		</tr>
		<!----- First Name ---------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="register.name" />
				</mytags:customLabel></td>
			<td><span><c:out value="${employee.name}" /></span></td>
		</tr>

		<!----- Date Of Birth -------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="register.date" />
				</mytags:customLabel></td>
			<td><span><fmt:formatDate type="date"
						value="${employee.dataofBirth}" /></span></td>
		</tr>

		<!----- Age -------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="employees.age" />
				</mytags:customLabel></td>
			<td><span><c:out value="${employee.age}" /></span></td>
		</tr>

		<!----- Salary ---------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="register.salary" />
				</mytags:customLabel></td>
			<td><span><fmt:setLocale value="${info.locale}"
						scope="session" /> <fmt:formatNumber value="${employee.salary}"
						type="currency" /></span></td>
		</tr>

		<!----- Job title ---------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="register.title" />
				</mytags:customLabel></td>
			<td><span><c:out value="${employee.jobTitle}" /></span></td>
		</tr>

		<!----- Department ---------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="register.department" />
				</mytags:customLabel></td>
			<td><span><c:out value="${employee.department}" /></span></td>
		</tr>


		<!----- Email ---------------------------------------------------------->
		<tr>
			<td><mytags:customLabel>
					<s:message code="register.email" />
				</mytags:customLabel></td>
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
