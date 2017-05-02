<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://poet.com/jsp/tlds/mytags" prefix="mytags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Hr System</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>

	<%@ include file="../jspf/languagebar.jspf"%>
	<security:authorize access="isAuthenticated()">
		<p>
			Hello
			<security:authentication property="principal.username" />
			!
		</p>
	</security:authorize>
	<h1>
		<s:message code="home.welcome" />
	</h1>
	<div>
		<h3>
			<a href="<c:url value="/employees" />"><s:message
					code="home.view.all" /></a>
			<%-- <security:authorize access="hasRole('ROLE_ADMIN')"> --%> | <a
					href="<c:url value="/employee/register" />"><s:message
						code="home.add.new" /></a>
			<%-- </security:authorize> --%>
		</h3>
	</div>
</body>
</html>
