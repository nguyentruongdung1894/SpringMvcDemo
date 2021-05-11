<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Category</title>
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

.inputCate {
	width: 300px;
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
				<li><a class="active" href="get-all-categories">Categories</a></li>
				<li><a href="get-all-users">Users</a></li>
				<li><a href="get-all-exams">Exams</a></li>
			</ul>
			<div style="margin-right: 15px">
				<a href="logout" style="color: white" class="linka headerText">Logout</a>
			</div>
		</div>
	</div>

	<div class="navbar container navbarb">
		<label class="navText">Category Managerment >> Add new</label>
	</div>
	<div class="content container" style="margin-bottom: 15px">
		<div class="row">
			<div class="col-sm-12">
				<div
					style="text-align: center; width: 100%; background-color: #5b9bd5;">
					<p class="infomation navbarb" style="margin: 0">Category
						Information</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form:form action="add-category-succ" method="post" name="myForm"
					onsubmit="return validateForm()" modelAttribute="categoryEntity">
					<ul class="form-style-1">
						<li><label class="lableC">Category ID </label> <input
							type="text" style="background: #dcdcdc" name="categoryId"
							class="inputCate" placeholder="Category ID" readonly
							value="${categoryId}" /><span style="color: red">(*)</span></li>
						<li><label class="lableC">Category Name </label> <input
							type="text" name="categoryName" class="inputCate"
							placeholder="Category Name" /><span style="color: red">(*)</span></li>
						<li><label class="lableC">Status </label> <select
							name="status" class="inputCate">
								<option value="true">Display</option>
								<option value="false">Hide</option>
						</select><span style="color: red">(*)</span></li>
						<li><input type="submit" value="Add" class="btnadd" /></li>
						<li><input type=button value="Cancel" class="btnadd"
							onclick="history.go(-1)" /></li>
					</ul>
				</form:form>
			</div>
			<div id="id01" class="modal">
				<div class="model-bottom">
					<div class="headerModel">
						<p class="headerModelP">Error</p>
					</div>
					<div style="text-align: center; width: 100%; height: 100px">
						Please input <span id="idQuestion"></span> <span id="idQuestion"></span>
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
</body>
<script>
	function validateForm() {
		var y = document.forms["myForm"]["categoryName"].value;
		if (y == "") {
			document.getElementById('id01').style.display = 'block';
			document.getElementById("idQuestion").innerHTML = " Category Name";
			return false;
		}
	}
</script>
</html>