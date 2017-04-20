<%-- 
    Document   : registerationForm
    Created on : Apr 6, 2017, 10:29:48 AM
    Author     : ahussein
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
	<c:choose>
		<c:when test="${employee.getId()!=0}">
			<h2>
				<s:message code="register.edit.head" />
			</h2>
		</c:when>
		<c:otherwise>
			<h2>
				<s:message code="register.head" />
			</h2>
		</c:otherwise>
	</c:choose>
	<sf:form method="POST" commandName="employee">
		<table align="center" cellpadding="10">

			<!----- First Name ---------------------------------------------------------->
			<tr>
				<td><mytags:customLabel>
						<s:message code="register.name" />
					</mytags:customLabel></td>
				<td><sf:input path="name" /> <sf:errors path="name"
						cssClass="error" /></td>
			</tr>

			<!----- Date Of Birth -------------------------------------------------------->
			<tr>
				<td><mytags:customLabel>
						<s:message code="register.date" />(dd/MM/yyyy)</mytags:customLabel></td>

				<td><sf:input path="dataofBirth" /> <sf:errors
						path="dataofBirth" cssClass="error" /></td>
			</tr>

			<!----- Salary ---------------------------------------------------------->
			<tr>
				<td><mytags:customLabel>
						<s:message code="register.salary" />
					</mytags:customLabel></td>
				<td><sf:input type="number" path="salary" /> <sf:errors
						path="salary" cssClass="error" /></td>
			</tr>

			<!----- Job title ---------------------------------------------------------->
			<tr>
				<td><mytags:customLabel>
						<s:message code="register.title" />
					</mytags:customLabel></td>
				<td><sf:input path="jobTitle" /> <sf:errors path="jobTitle"
						cssClass="error" /></td>
			</tr>

			<!----- Department ---------------------------------------------------------->
			<tr>
				<td><mytags:customLabel>
						<s:message code="register.department" />
					</mytags:customLabel></td>
				<td><sf:select path="department.departmentId">
						<c:forEach items="${departmentsList}" var="department">
							<sf:option value="${department.departmentId}">${department.departmentName}</sf:option>
						</c:forEach>
					</sf:select> <sf:errors path="department" cssClass="error" /></td>
			</tr>


			<!----- Email ---------------------------------------------------------->
			<tr>
				<td><mytags:customLabel>
						<s:message code="register.email" />
					</mytags:customLabel></td>
				<td><sf:input path="email" /> <sf:errors path="email"
						cssClass="error" /></td>
			</tr>



			<!----- Submit and Reset ------------------------------------------------->
			<tr>
				<td colspan="2" align="center"><c:choose>
						<c:when test="${employee.getId()!=0}">
							<input type="submit" value=<s:message code="register.save" />>
						</c:when>
						<c:otherwise>
							<input type="submit" value=<s:message code="register.submit" />>
							<input type="reset" value=<s:message code="register.reset" />>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</sf:form>
	<a href="<c:url value="/employees" />"><s:message
			code="home.view.all" /></a>
	<br />
</body>
</html>
