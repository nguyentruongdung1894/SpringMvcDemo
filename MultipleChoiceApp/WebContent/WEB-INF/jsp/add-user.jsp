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
<link href="<c:url value="/resources/css/styleQuestion.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styleAddQuestion.css" />"
	rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style type="text/css">
.lableC {
	width: 150px;
	color: #5b9bd5;
}

.inputUser {
	width: 255px;
	border: 1px black solid;
	padding: 7px;
}
</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- /.Header -->
	<!-- Header -->
	<jsp:include page="welcomeAdmin.jsp"></jsp:include>
	<!-- /.Header -->
	<div style="background-color: #5b9bd5;">
		<div class="navbar container">
			<ul class="headerText">
				<li><a href="get-all-question" style="padding: 5px 15px">Questions</a></li>
				<li><a href="get-all-categories">Categories</a></li>
				<li><a class="active" href="get-all-users">Users</a></li>
				<li><a href="get-all-exams">Exams</a></li>
			</ul>
			<div style="margin-right: 15px">
				<a href="logout" style="color: white" class="linka headerText">Logout</a>
			</div>
		</div>
	</div>
	<div class="navbar container navbarb">
		<label class="navText">User Managerment >> Add new</label>
	</div>
	<div class="content container" style="margin-bottom: 15px">
		<div class="row">
			<div class="col-sm-12">
				<div class="navbarb"
					style="text-align: center; width: 100%; background-color: #5b9bd5;">
					<p class="infomation" style="margin: 0">User Information</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form:form action="add-user-succ" method="post" name="myForm"
					onsubmit="return validateForm()" modelAttribute="userEntity">
					<div class="row">
						<div class="col-sm-6">
							<div style="text-align: left; padding: 10px">
								<label class="lbelLeft lableC">Admin ID</label> <input
									type="text" name="adminId" style="background: #dcdcdc" readonly
									class="inputUser" placeholder="Admin ID" value="${userId}" /><span
									style="color: red">(*)</span>
							</div>
							<div style="text-align: left; padding: 10px">
								<label class="lbelLeft lableC">Password</label> <input
									type="text" name="password" class="inputUser"
									placeholder="Password" /><span style="color: red">(*)</span>
							</div>
							<div style="text-align: left; padding: 10px">
								<label class="lbelLeft lableC">FullName</label> <input
									type="text" name="fullName" class="inputUser"
									placeholder="FullName" /><span style="color: red">(*)</span>
							</div>
							<div style="text-align: left; padding: 10px">
								<label class="lbelLeft lableC">Status</label> <select
									name="status" class="inputUser">
									<option value="true">Display</option>
									<option value="false">Hide</option>
								</select> <span style="color: red">(*)</span>
							</div>
							<div style="text-align: left; padding: 10px">
								<input type="submit" value="Add" class="btnClick" /> <input
									type=button value="Cancel" onclick="history.go(-1)"
									class="btnClick" />
							</div>
						</div>
						<div class="col-sm-6">
							<div style="text-align: left; padding: 10px">
								<label class="lbelRight lableA">Phone</label> <input type="text"
									name="phone" class="inputUser" placeholder="Phone" /><span
									style="color: red">(*)</span>
							</div>
							<div style="text-align: left; padding: 10px">
								<label class="lbelRight lableA">Email</label> <input type="text"
									name="email" class="inputUser" placeholder="Email" /><span
									style="color: red">(*)</span>
							</div>
							<div style="text-align: left; padding: 10px">
								<label class="lbelRight lableA">Address</label> <input
									type="text" name="address" class="inputUser"
									placeholder="Address" /><span style="color: red">(*)</span>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div id="id01" class="modal">
				<div class="model-bottom">
					<div class="headerModel">
						<p class="headerModelP">Error</p>
					</div>
					<div style="text-align: center; width: 100%; height: 100px">
						Please input<span id="idQuestion"></span> <span id="idQuestion"></span>
						<input type="hidden" id="inputQ">
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
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- /.Footer -->
	<!-- partial -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js'></script>
	<script>
		function validateForm() {
			var password = document.forms["myForm"]["password"].value;
			var fullName = document.forms["myForm"]["fullName"].value;
			var phone = document.forms["myForm"]["phone"].value;
			var email = document.forms["myForm"]["email"].value;
			var address = document.forms["myForm"]["address"].value;

			if (password == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = " password";
				return false;
			}
			if (fullName == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = " fullname";
				return false;
			}
			if (phone == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = " phone";
				return false;
			}
			if (address == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = " address";
				return false;
			}
		}
	</script>
</body>
</html>