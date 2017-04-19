<%-- 
    Document   : listEmployees
    Created on : Apr 6, 2017, 11:08:47 AM
    Author     : ahussein
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
<title>Employees Page</title>
</head>

<body>
	<%@ include file="../jspf/languagebar.jspf"%>
	<h2>
		<s:message code="employees.list" />
	</h2>
	<br />
	<br />
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<span><a href="<c:url value="/employee/register" />"><s:message
					code="home.add.new" /></a></span>
		<br />
		<br />
	</security:authorize>
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
						<td><a href="<c:url value="/employees/${employee.id}" />"><c:out
									value="${employee.name}" /></a></td>
						<td><c:out value="${employee.age}" /></td>
						<td><fmt:setLocale value="${info.locale}" scope="session" />
							<fmt:formatNumber value="${employee.salary}" type="currency" /></td>
						<td><c:out value="${employee.jobTitle}" /></td>
						<td><c:out value="${employee.department}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><security:authorize access="hasRole('ROLE_ADMIN')">
								<form method="get" action="<c:url value="/employee/edit" />">
									<input type="hidden" value="${employee.id}" name="id" /> <input
										type="submit" value="Edit">
								</form>
							</security:authorize></td>
						<td><security:authorize access="hasRole('ROLE_ADMIN')">
								<c:if test="${employee.salary==0}">
									<form method="post" action="<c:url value="/employee/delete" />">
										<input type="hidden" value="${employee.id}" name="id" /> <input
											type="submit" value="Delete"
											onclick="return confirm('Are you sure you want to delete this Employee?')">
									</form>
								</c:if>
							</security:authorize></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
