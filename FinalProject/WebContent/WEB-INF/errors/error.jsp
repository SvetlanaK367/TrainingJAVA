<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Runtime Error</title>
</head>
<body>
	Request from ${pageContext.errorData.requestURI} is failed<br/>
	Servlet name: ${pageContext.errorData.servletName}<br/>
	Status code: ${pageContext.errorData.statusCode}<br/>
	Exception: ${pageContext.exception}<br/>
	Message from exception: ${pageContext.exception.message}<br/>
</body>
</html>
