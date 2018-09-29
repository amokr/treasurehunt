<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question loading_page</title>
</head> 
<body>
<center>
	<div>
            <h3> Choose File to Upload in Server </h3>
            <form action="http://localhost:6060/login_page/Uploade_quesiton" method="post" enctype="multipart/form-data">
                <input type="file" name="file" multiple/><br>
                <input type="submit" value="upload" />
            </form>          
        </div>
        </center>
</body>
</html>