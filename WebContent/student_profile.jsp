<%@page import="com.profile_package.Profile"%>
<%@page import="com.profile_package.Profile_model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STUDETN PROFILE</title>
</head>
<body>
	<%
	Profile pobj=(Profile)session.getAttribute("fb_session");
	%>
 <center>
	 Name : <%=pobj.getUser_name()%><br>
	 Email:<%=pobj.getEmail()%><br>
	 college name:<%=pobj.getCollege_name()%><br>
	 Pic :<img src="<%=pobj.getProf_pic()%>"></imag>
	 <form action="Read_question" method="post">
	 <input type="submit" value="start_game/resume_game">
  	</form>
  </center>
</body>
</html>
