<%@page import="java.util.ArrayList"%>
<%@page import="usolv.com.vn.DTO.QuestionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>List Questions</title>
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
<style type="text/css">
</style>
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
				<li><a class="active" href="get-all-question"
					style="padding: 5px 15px">Questions</a></li>
				<li><a href="get-all-categories">Categories</a></li>
				<li><a href="get-all-users">Users</a></li>
				<li><a href="get-all-exams">Exams</a></li>
			</ul>
			<div style="margin-right: 15px">
				<a href="logout" style="color: white" class="linka headerText">Logout</a>
			</div>
		</div>
	</div>
	<div class="">
		<div class="navbar container navbarb">
			<label class="navText">Question Managerment >> List</label>
		</div>
		<div class="container" style="margin-bottom: 15px">
			<div class="row">
				<div class="col-sm-8">
					<div class="navbarNew container">
						<a class="headerText" href="add-question">Add new</a>
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
			<table id="" class="table-style-three"
				style="width: 100%; height: 200px; overflow: scroll;">
				<thead>
					<tr class="">
						<th style="width: 5%">No</th>
						<th style="width: 10%">Quest ID</th>
						<th style="width: 45%; text-align: left;">Text</th>
						<th style="width: 10%">Category</th>
						<th style="width: 10%">Type</th>
						<th colspan="2" style="width: 10%">Management</th>
					</tr>
				</thead>
				<tbody id="myTable">
					<%
						int check = 0;
					%>
					<c:forEach items="${listQuestionsDTO}" var="listQuestionsDTO">
						<tr class="content">
							<td style="text-align: center">${listQuestionsDTO.id}</td>
							<%
								String questionID = "";
									List<QuestionDTO> listQuestionsDTO = (ArrayList<QuestionDTO>) request.getAttribute("listQuestionsDTO");
									int size = listQuestionsDTO.get(check).getCount();
									for (int i = 0; i < 7 - size; i++) {
										questionID = questionID + "0";
							%>
							<%
								}
							%>
							<td style="text-align: center"><a class="linka"
								href="updateQuestion?questionId=${listQuestionsDTO.questionId}">Q<%=questionID%>${listQuestionsDTO.questionId}</a>
							</td>
							<%
								check = check + 1;
							%>
							<td>${listQuestionsDTO.contentQuestion}</td>
							<td style="text-align: center">${listQuestionsDTO.categoryName}</td>
							<td style="text-align: center">${listQuestionsDTO.type}</td>
							<td style="text-align: center; border-right: none"><a
								href="updateQuestion?questionId=${listQuestionsDTO.questionId}">
									<img src="<c:url value="/resources/image/edit_blue.png"/>"
									alt="Avatar" class="Logo" style="width: 55%;">
							</a></td>
							<td style="text-align: center">
								<button onclick="show('${listQuestionsDTO.questionId}')">
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
									<p>Do you want to delete this question?</p>
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
				document.getElementById('id01').style.display = "block";
				var n = id.length;
				var questionID = "";
				for (var i = 0; i < 7 - n; i++) {
					questionID = questionID + "0";
				}
				document.getElementById("idQuestion").innerHTML = "Q"
						+ questionID + id;

				document.getElementById("inputQ").value = id;
			}
			function del() {
				var id = document.getElementById("inputQ").value
				window.location.href = "deleteQuestion?questionId=" + id;
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