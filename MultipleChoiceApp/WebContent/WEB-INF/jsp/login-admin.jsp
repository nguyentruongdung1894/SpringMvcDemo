<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add User</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="<c:url value="/resources/css/styleQuestion.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styleLogin.css" />"
	rel="stylesheet">
</head>

<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- /.Header -->
	<div class="container" style="margin-top: 170px">
		<div class="formLogin">
			<!-- login-succ -->
			<form action="login-succ" method="post" name="myForm"
				onsubmit="return validateForm()">
				<div>
					<p class="titleLogin">Login</p>
				</div>
				<table style="margin: 0 auto;">
					<tr>
						<td style="height: 70px"><b class="lable">User name</b></td>
						<td><input type="text" class="input" name="adminId" size="55"><label
							class="validate">(*)</label></td>
					</tr>
					<tr>
						<td style="height: 70px"><b class="lable">Password</b></td>
						<td><input type="Password" class="input" name="password"
							size="55"><label class="validate">(*)</label></td>
					</tr>
				</table>
				<div style="text-align: center; margin-bottom: 10px;">
					<input type="submit" name="login" value="Login" class="buttonSub">
				</div>
			</form>
		</div>
		<p id="message"
			style="text-align: center; color: red; font-size: 15px; margin-top: 10px; display: none;">${message }</p>
		<div id="id01" class="modal">
			<div class="model-bottom">
				<div class="headerModel">
					<p class="headerModelP">Error</p>
				</div>
				<div style="text-align: center; width: 100%; height: 100px">
					<span style="font-weight: normal;">Please input</span> <span
						id="idQuestion"></span> <input type="hidden" id="inputQ">
				</div>
				<div style="text-align: center; width: 100%">
					<div class="">
						<div class="okBtn">
							<a style="color: white"
								onclick="document.getElementById('id01').style.display='none'">Ok</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="id02" class="modal">
			<div class="model-bottom">
				<div class="headerModel">
					<p class="headerModelP">Error</p>
				</div>
				<div style="text-align: center; width: 100%; height: 100px">
					<span style="font-weight: normal; display: block;">Username
						or Password incorrect.</span> <span
						style="font-weight: normal; display: block;">Please try
						again!!</span>

				</div>
				<div style="text-align: center; width: 100%">
					<div class="">
						<div class="okBtn">
							<a style="color: white" onclick="acc()">Ok</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function validateForm() {
			var x = document.forms["myForm"]["adminId"].value;
			var y = document.forms["myForm"]["password"].value;
			if (x == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = "User name";
				return false;
			}
			if (y == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = "Password";
				return false;
			}
			var span = document.getElementById("message").textContent.trim();
			console.log(span);
			if (span == "error") {
				document.getElementById('id02').style.display = 'block';
				return false;
			} else {
				return true;
			}

		}
	</script>
	<script type="text/javascript">
		function acc() {
			document.getElementById("message").innerHTML = "";
			document.getElementById("id02").style.display = "none";
		}
	</script>
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- /.Footer -->
</body>
</html>