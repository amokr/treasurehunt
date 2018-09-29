<!DOCTYPE html>
<html>
<head>
<title>Facebook Login page</title>
<meta charset="UTF-8">
</head>
<body>
<script>
 // This is called with the results from from FB.getLoginStatus().
 function statusChangeCallback(response) {
	 console.log('statusChangeCallback');
	 console.log(response);
	 console.log(response.authResponse.accessToken);
 //alert(response.authResponse.accessToken);
	 if (response.status === 'connected') {
	 window.location.href='Get_Access_controller.jsp?access_token='+response.authResponse.accessToken; 
	 } else {
	 // The person is not logged into your app or we are unable to tell.
	 document.getElementById('status').innerHTML = 'Please log ' +
	 'into this app.';
	 	}
 }
 // This function is called when someone finishes with the Login
 // Button. See the onlogin handler attached to it in the sample
 // code below.
 function checkLoginState() {
	 // reading the college name
	var e = document.getElementById("college_name");
	var college_name = e.options[e.selectedIndex].value;
	// writing college name on console
	console.log("college_name");
 	FB.getLoginStatus(function(response) {
 	statusChangeCallback(response);
 	});
 }
 // code for initilize SDK of facebook
 window.fbAsyncInit = function() {
	 FB.init({
		 appId : '2174875302791476',
		 cookie : true, // enable cookies to allow the server to access the session
		 xfbml : true, // parse social plugins on this page
		 version : 'v2.8' // use graph api version 2.8
 	});
// function call for checking status of login 
	// FB.getLoginStatus(function(response) {
	 //	statusChangeCallback(response);
    //});
 };
 
 // Load the SDK asynchronously
 (function(d, s, id) {
	 var js, fjs = d.getElementsByTagName(s)[0];
	 if (d.getElementById(id)) return;
	 js = d.createElement(s); js.id = id;
	 js.src = "https://connect.facebook.net/en_US/sdk.js";
	 fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));
 
 // Here we run a very simple test of the Graph API after login is
 // successful. See statusChangeCallback() for when this call is made.
</script>
<center>
<select id="college_name">
  <option value="NITK">NITK</option>
  <option value="Trichy">TRICHY</option>
  <option value="MNIT">MNIT</option>
  <option value="Calicut">CALICUT</option>
</select>
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>
</center>
<div id="status">
</div>
</body></html>