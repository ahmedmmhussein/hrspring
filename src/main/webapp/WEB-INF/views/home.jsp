<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<html>
<head>
<title>Hr System</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<div>
		<p>
			<a href="<c:url value="?locale=en" />"><s:message
					code="home.english" /></a> | <a href="<c:url value="?locale=de" />"><s:message
					code="home.german" /></a>
		</p>
	</div>
	<h1>
		<s:message code="home.welcome" />
	</h1>
	<div>
		<h3>
			<a href="<c:url value="/employees" />"><s:message
					code="home.view.all" /></a> | <a
				href="<c:url value="/employee/register" />"><s:message
					code="home.add.new" /></a>
		</h3>
	</div>
</body>
</html>
