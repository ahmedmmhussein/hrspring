<%-- 
    Document   : listEmployees
    Created on : Apr 6, 2017, 11:08:47 AM
    Author     : ahussein
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
<title>Employees Page</title>
</head>

<body>
	<h2>
		<s:message code="employees.list" />
	</h2>
	<br />
	<br />
	<span><a href="<c:url value="/employee/register" />"><s:message
				code="home.add.new" /></a></span>
	<br />
	<br />

	<c:choose>
		<c:when test="${employeeList.size()==0}">
			<span><s:message code="employees.no" /></span>
		</c:when>
		<c:otherwise>
			<table align="center" cellpadding="10">
				<tr>
					<th><s:message code="employees.id" /></th>
					<th><s:message code="register.name" /></th>
					<th><s:message code="employees.age" /></th>
					<th><s:message code="register.salary" /></th>
					<th><s:message code="register.title" /></th>
					<th><s:message code="register.department" /></th>
					<th><s:message code="register.email" /></th>
					<th></th>
				</tr>
				<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td><c:out value="${employee.id}" /></td>
						<td><c:out value="${employee.name}" /></td>
						<td><c:out value="${employee.age}" /></td>
						<td><c:out value="${employee.salary}" /></td>
						<td><c:out value="${employee.jobTitle}" /></td>
						<td><c:out value="${employee.department}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><form method="post"
								action="<c:url value="/employee/delete" />">
								<input type="hidden" value="${employee.id}" name="id" /> <input
									type="submit" value="Delete">
							</form></td>
						<td><form method="get"
								action="<c:url value="/employee/edit" />">
								<input type="hidden" value="${employee.id}" name="id" /> <input
									type="submit" value="Edit">
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
