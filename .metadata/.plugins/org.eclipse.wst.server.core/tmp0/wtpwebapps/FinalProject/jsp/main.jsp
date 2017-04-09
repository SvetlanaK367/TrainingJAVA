<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome</h1>
		<h3> ${user}, hello!</h3>

	<div class="container">
		<a class="navbar-brand" href="#">Menu</a>
		  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		    <ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href="jsp/fileUpload.jsp">Upload File</a>
		      </li>
		     </ul>
		     <ul>
		      <li class="nav-item">
		        <a class="nav-link" href="jsp/validation.jsp">Validate XML</a>
		      </li>		     
		      <li class="nav-item dropdown">
		        Parsers
		        <div class="dropdown-menu">
		          <a class="dropdown-item" href="parsed?parser=SAX">SAX</a>
		          <a class="dropdown-item" href="parsed?parser=DOM">DOM</a>
		          <a class="dropdown-item" href="parsed?parser=STAX">StAX</a>
		        </div>
		      </li>
		    </ul>
		  </div>
			<form action="index.jsp">
				<input class="btn btn-primary" type="submit" value="Back">
			</form>
	</div>

		
	<p style="color:red"><a href="Controller?command=logout">Logout</a></p>
</body>
</html>