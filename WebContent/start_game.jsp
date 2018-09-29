<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <meta http-equiv="refresh" content="5" url="google.com"/> --%>
<title>Insert title here</title>

<style>
* {
    box-sizing: border-box;
}

.row {
    display: flex;
}

/* Create three equal columns that sits next to each other */
.column {
    flex: 33.33%;
    padding: 5px;
}
</style>
</head>
<body>
<center>
	Question no: 
		<div class="row">
			<h4>Base image :</h4>
			<img src="D:/ignite/login_page/WebContent/questions_image/11.jpg" height="500" width="500">
		</div>
</center>
	<form action="Question_update" method="post">
	
	<div class="row">
  		<div class="column">
  			<h4> hint_image 1:</h4>
    		<img src="D:/ignite/login_page/WebContent/questions_image/13.jpg" alt="wait" style="width:100%">
 		 </div>
  		<div class="column">
  			<h4> hint_image 1:</h4>
    		<img src="D:/ignite/login_page/WebContent/questions_image/13.jpg" alt="wait" style="width:100%">
  		</div>
  		<div class="column">
  			<h4> hint_image 1:</h4>
    		<img src="D:/ignite/login_page/WebContent/questions_image/13.jpg" alt="wait" style="width:100%">
  		</div>
	</div>
	<br>Enter your answer: <input type="text" name="info">
	<button type="submit" value="Submit">Submit</button>
	</form>
</body>
</html>