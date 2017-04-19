<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form action="../Controller" method="post" enctype="multipart/form-data">
			<input type="hidden" name="command" value="ValidateSAX" />
            Select XML File:<br/>
            <input type="file" name="fileXML" id="file" /> <br/>
            Select Validator (xsd):<br/>
            <input type="file" name="fileXSD" id="file" /> <br/>           
            <p><input type="submit" value="  Check  " name="check" /></p>
        </form>
        
</body>
</html>