<%@page import="com.profile_package.Profile_model"%>
<%@page import="com.profile_package.Profile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
 String access_token=(String)request.getParameter("access_token");
 Profile_model obj=new Profile_model();
	Profile pobj=obj.call_me(access_token);
	pobj.store_info();
	session.setAttribute("fb_session",pobj);
 %>
 <script>
   // code for rdirecting the page to student profile
   window.location.href="student_profile.jsp";
 </script>
</body>
</html>