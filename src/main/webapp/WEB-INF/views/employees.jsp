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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<c:url value="/resources/ajax.js" />"></script>
<title>Employees Page</title>
</head>

<body>
	<%@ include file="../jspf/languagebar.jspf"%>
	<h2>
		<s:message code="employees.list" />
	</h2>
	<br />
	<br />
	<%-- <security:authorize access="hasRole('ROLE_ADMIN')"> --%>
	<span><a href="<c:url value="/employee/register" />"><s:message
				code="home.add.new" /></a></span>
	<br />
	<br />
	<%-- </security:authorize> --%>
	<c:choose>
		<c:when test="${employeeList.size()==0}">
			<span><s:message code="employees.no" /></span>
		</c:when>
		<c:otherwise>
			<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for names..">
			<table id="employeesTable" align="center" cellpadding="10">
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
						<td>
							<%-- <security:authorize access="hasRole('ROLE_ADMIN')"> --%>
							<form method="get" action="<c:url value="/employee/edit" />">
								<input type="hidden" value="${employee.id}" name="id" /> <input
									class="ui-button ui-widget ui-corner-all" type="submit"
									value="Edit">
							</form> <%-- </security:authorize> --%>
						</td>
						<td>
							<%-- <security:authorize access="hasRole('ROLE_ADMIN')"> --%> <c:if
								test="${employee.salary==0}">
								<form method="post" action="<c:url value="/employee/delete" />">
									<input type="hidden" value="${employee.id}" name="id" /> <input
										class="ui-button ui-widget ui-corner-all" type="submit"
										value="Delete"
										onclick="return confirm('Are you sure you want to delete this Employee?')">
								</form>
							</c:if> <%-- </security:authorize> --%>
						</td>
						<td><button class="ui-button ui-widget ui-corner-all"
								id="employeeDetails" value="${employee.id}">view more</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

	<div id="dialog" title="Basic dialog">
		<p>This is an animated dialog which is useful for displaying
			information. The dialog window can be moved, resized and closed with
			the 'x' icon.</p>
	</div>
</body>
</html>
