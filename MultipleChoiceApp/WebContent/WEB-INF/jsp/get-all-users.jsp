<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>List Users</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<link href="<c:url value="/resources/css/styleQuestion.css" />"
	rel="stylesheet">
<script src=<c:url value="/resources/js/fontawesome.js" />></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="<c:url value="/resources/css/styleSearch.css" />"
	rel="stylesheet">
<script>
	$(document).ready(
			function() {
				$("#myInput").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#myTable tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});
</script>
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
	<div class="">
		<div class="navbar container navbarb">
			<label class="navText">User Managerment >> List</label>
		</div>

		<div class="container" style="margin-bottom: 15px">
			<div class="row">
				<div class="col-sm-8">
					<div class="navbarNew container">
						<a class="headerText" href="add-user">Add new</a>
					</div>
				</div>
				<div class="col-sm-4">
					<form class="example" action=""
						style="margin: auto; width: 85%; float: right;">
						<input type="text" placeholder="Typing to search" name="search2"
							id="myInput">
						<button type="submit">
							<img src="<c:url value="/resources/image/search_blue.png"/>"
								alt="Avatar" class="Logo" style="width: 40%;">
						</button>
					</form>
				</div>
			</div>
		</div>
		<div class="container" id="jar" style="margin-bottom: 20px">
			<table id="" class="table-style-three" style="width: 100%">
				<thead>
					<tr class="">
						<th style="width: 5%">No</th>
						<th style="width: 10%">Admin ID</th>
						<th style="width: 10%">Password</th>
						<th style="width: 15%">FullName</th>
						<th style="width: 10%">Phone</th>
						<th style="width: 15%">Email</th>
						<th style="width: 20%">Address</th>
						<th style="width: 5%">Status</th>
						<th colspan="2" style="width: 10%">Management</th>
					</tr>
				</thead>
				<tbody id="myTable">
					<c:forEach items="${listUsersDTO}" var="listUsersDTO">
						<tr class="content">
							<td style="text-align: center">${listUsersDTO.id}</td>
							<td style="text-align: center"><a class="linka"
								href="updateUser?adminId=${listUsersDTO.adminId}">${listUsersDTO.adminId}</a>
							</td>
							<td style="text-align: center">${listUsersDTO.password}</td>
							<td style="text-align: center">${listUsersDTO.fullName}</td>
							<td style="text-align: center">${listUsersDTO.phone}</td>
							<td style="text-align: center"><a href="" class="linka">${listUsersDTO.email}</a>
							</td>
							<td style="text-align: center">${listUsersDTO.address}</td>
							<td style="text-align: center">${listUsersDTO.status}</td>
							<td style="text-align: center"><a
								href="updateUser?adminId=${listUsersDTO.adminId}"><img
									src="<c:url value="/resources/image/edit_blue.png"/>"
									alt="Avatar" class="Logo" style="width: 55%;"></a></td>
							<td style="text-align: center">
								<button onclick="show('${listUsersDTO.adminId}')">
									<img src="<c:url value="/resources/image/delete_blue.png"/>"
										alt="Avatar" class="Logo" style="width: 55%;">
								</button>
							</td>
						</tr>
						<div id="id01" class="modal">
							<div class="model-bottom">
								<div class="headerModel">
									<p class="headerModelP">Confirm delete</p>
								</div>
								<div style="text-align: center; width: 100%; height: 100px">
									<p>Do you want to delete this user?</p>
									<span id="idQuestion"></span> <input type="hidden" id="inputQ">
								</div>
								<div style="text-align: center; width: 100%">
									<div class="" style="float: left; width: 50%">
										<div class="okBtn">
											<a onclick="del()" href="#" style="color: white">OK</a>
										</div>
									</div>
									<div class="" style="float: left; width: 50%">
										<div class="okBtn">
											<a style="color: white"
												onclick="document.getElementById('id01').style.display='none'">Cancel</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script type="text/javascript">
			function show(id) {
				//show id01
				document.getElementById('id01').style.display = "block";
				//xet gia tri cho the span khi click vao show(id)
				document.getElementById("idQuestion").innerHTML = id;
				//xet gia tri cho input = hide bang id
				document.getElementById("inputQ").value = id;
			}
			function del() {
				var id = document.getElementById("inputQ").value
				window.location.href = "deleteUser?adminId=" + id;
			}
		</script>
		<nav>
			<ul class="pagination justify-content-center pagination-sm">
			</ul>
		</nav>
	</div>
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- /.Footer -->
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js'></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
</body>
</html>