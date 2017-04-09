<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="ru" scope="session" />
<fmt:setBundle basename="resources.pagecontent" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<fmt:message key="welcome" />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="Login" />
			Enter login:<br/>
		<input type="text" name="login" value="" /><br/>
			Enter password:<br/>
		<input type="password" name="password" value="" /><br/>
		<input type="submit" value="Log in" /><br/>
		${errorLoginPassMessage}<br/>
		${wrongAction}<br/>
		${nullPage}<br/>
	</form>
	
</body>
</html>
