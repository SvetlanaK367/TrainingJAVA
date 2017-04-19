<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date Format</title>
</head>
<body>
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:setLocale value="en-EN"/>
	Вывод даты в формате English<br/>
	Сегодня: <fmt:formatDate value="${now}" /><br/>
	<fmt:setLocale value="ru-RU"/>
	Вывод даты в формате Russian<br/>
	Сегодня: <fmt:formatDate value="${now}" /><br/>
	Стиль времени:
	(short): <fmt:formatDate value="${now}" type="time" timeStyle="short" /><br/>
	(medium):<fmt:formatDate value="${now}" type="time" timeStyle="medium" /><br/>
	(long): <fmt:formatDate value="${now}" type="time" timeStyle="long" /><br/>
</body>
</html>

