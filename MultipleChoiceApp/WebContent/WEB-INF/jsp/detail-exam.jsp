<%@page import="usolv.com.vn.entitys.ExamEntity"%>
<%@page import="usolv.com.vn.entitys.AnswerChooseEntity"%>
<%@page import="usolv.com.vn.entitys.ExamDetailEntitySQL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="usolv.com.vn.entitys.ExamDetailEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Exam</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/styleQuestion.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styleDetail.css" />"
	rel="stylesheet">
<style type="text/css">
.cont {
	width: 300px;
}

.btn {
	margin-left: 80px;
	background: #5b9bd5;
	padding: 10px 0px;
	color: white
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
				<li><a href="get-all-users">Users</a></li>
				<li><a class="active" href="get-all-exams">Exams</a></li>
			</ul>
			<div style="margin-right: 15px">
				<a href="logout" style="color: white" class="linka headerText">Logout</a>
			</div>
		</div>
	</div>

	<%
		ExamEntity examEntity = (ExamEntity) request.getAttribute("examEntity");
		int examId = examEntity.getExamId();
		String examID = "";
		int count = Integer.toString(examId).length();
		for (int i = 0; i < 7 - count; i++) {
			examID = examID + "0";
	%>
	<%
		}
	%>

	<div class="navbar container navbarb">
		<label class="navText">Exams Managerment > E<%=examID%>${examEntity.examId}</label>
	</div>
	<div id="content" class="container">
		<div class="row">
			<div id="post" class="col-sm-6">
				<table id="bang" border="1">
					<tr>
						<td colspan="2" style="text-align: center; color: white">Candidate
							Information</td>
					</tr>
					<tr>
						<td style="color: white">Exam ID</td>
						<td>E<%=examID%>${examEntity.examId}</td>
					</tr>
					<tr>
						<td style="color: white">Full name</td>
						<td id="fullname" class="cont">${examEntity.fullName}</td>
					</tr>
					<tr>
						<td style="color: white">Email</td>
						<td class="cont">${examEntity.email}</td>
					</tr>
					<tr>
						<td style="color: white">Phone</td>
						<td class="cont">${examEntity.phone}</td>
					</tr>
					<tr>
						<td style="color: white">Exam Date</td>
						<td class="cont">${examEntity.examDate}</td>
					</tr>
					<tr>
						<td style="color: white">Result</td>
						<td class="cont">${examEntity.result}/30</td>
					</tr>
					<tr>
						<td style="color: white">Status</td>
						<c:if test="${examEntity.result >= 15}">
							<td style="text-align: center; color: green" class="cont"><b>Passed</b></td>
						</c:if>
						<c:if test="${examEntity.result < 15}">
							<td style="text-align: center; color: red" class="cont"><b>Fail</b></td>
						</c:if>
					</tr>
				</table>
				<br> <input value="Delete"
					onclick="show('${examEntity.examId}')" class="btn" />
			</div>
			<div class="col-sm-6">
				<div style="background: #5b9bd5; text-align: center;"
					class="navbarb">
					<label style="padding: 5px 10px; margin: 0; color: white">Result
						Detail (${examEntity.result} / 30)</label>
				</div>
				<div style="height: 405px; overflow: auto;">
					<div style="">
						<label style="padding: 5px 10px; margin: 0; font-weight: bold;">Elective
							section: ${categoryName} (${examEntity.result - countSQL}/20)</label>
					</div>
					<table style="width: 85%; float: right; text-align: center;">
						<tr style="background-color: #5b9bd5; margin-right: 10px">
							<th style="color: white; padding: 5px 10px;">No</th>
							<th style="color: white">Correct</th>
							<th style="color: white">Answer</th>
							<th style="color: white">Result</th>
						</tr>
						<%
							List<ExamDetailEntity> listExamDetailEntity = (ArrayList<ExamDetailEntity>) request
									.getAttribute("listExamDetailEntity");
							for (int index = 0; index < listExamDetailEntity.size(); index++) {
						%>
						<tr>
							<td><%=index + 1%></td>
							<td>
								<%
									for (int i = 0; i < listExamDetailEntity.get(index).getListCorrectChooseEntity().size(); i++) {
											if (listExamDetailEntity.get(index).getListCorrectChooseEntity().get(i).getCorrect() % 4 == 1) {
												out.print("A ");
											} else if (listExamDetailEntity.get(index).getListCorrectChooseEntity().get(i).getCorrect()
													% 4 == 2) {
												out.print("B ");
											} else if (listExamDetailEntity.get(index).getListCorrectChooseEntity().get(i).getCorrect()
													% 4 == 3) {
												out.print("C ");
											} else {
												out.print("D ");
											}
										}
								%>
							</td>
							<td>
								<%
									for (int i = 0; i < listExamDetailEntity.get(index).getListAnswerChooseEntity().size(); i++) {
											if (listExamDetailEntity.get(index).getListAnswerChooseEntity().get(i).getAnswer() % 4 == 1) {
												out.print("A ");
											} else if (listExamDetailEntity.get(index).getListAnswerChooseEntity().get(i).getAnswer()
													% 4 == 2) {
												out.print("B ");
											} else if (listExamDetailEntity.get(index).getListAnswerChooseEntity().get(i).getAnswer()
													% 4 == 3) {
												out.print("C ");
											} else {
												out.print("D ");
											}
										}
								%>
							</td>
							<td>
								<%
									String check = "<font style=\"color: red;\">Incorrect</font>";
										int size = 0;
										List<AnswerChooseEntity> lAnswerChooseEntity = listExamDetailEntity.get(index)
												.getListAnswerChooseEntity();
										if (listExamDetailEntity.get(index).getListCorrectChooseEntity().size() == lAnswerChooseEntity.size()) {
											for (int i = 0; i < listExamDetailEntity.get(index).getListCorrectChooseEntity().size(); i++) {
												for (int x = 0; x < lAnswerChooseEntity.size(); x++) {
													if (listExamDetailEntity.get(index).getListCorrectChooseEntity().get(i)
															.getCorrect() == lAnswerChooseEntity.get(x).getAnswer()) {
														size++;
													}
												}
											}
											if (size == lAnswerChooseEntity.size()) {
												check = "<font style=\"color: green;\">Correct</font>";
											}

										}
										size = 0;
										out.print(check);
										check = "<font style=\"color: red;\">Incorrect</font>";
								%>
							</td>
							<%
								}
							%>
						</tr>
					</table>
					<div style="">
						<label style="padding: 5px 10px; margin: 0; font-weight: bold;">Required
							section: SQL (${countSQL}/10)</label>
					</div>
					<table style="width: 85%; float: right; text-align: center;">
						<tr style="background-color: #5b9bd5; margin-right: 10px">
							<th style="color: white; padding: 5px 10px;">No</th>
							<th style="color: white">Correct</th>
							<th style="color: white">Answer</th>
							<th style="color: white">Result</th>
						</tr>
						<%
							List<ExamDetailEntitySQL> listExamDetailEntitySQL = (ArrayList<ExamDetailEntitySQL>) request
									.getAttribute("listExamDetailEntitySQL");
							for (int index = 0; index < listExamDetailEntitySQL.size(); index++) {
						%>
						<tr>
							<td><%=index + 21%></td>
							<td>
								<%
									for (int i = 0; i < listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size(); i++) {
											if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().get(i).getCorrect() % 4 == 1) {
												out.print("A ");
											} else if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().get(i).getCorrect()
													% 4 == 2) {
												out.print("B ");
											} else if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().get(i).getCorrect()
													% 4 == 3) {
												out.print("C ");
											} else {
												out.print("D ");
											}
										}
								%>
							</td>
							<td>
								<%
									for (int i = 0; i < listExamDetailEntitySQL.get(index).getListAnswerChooseEntity().size(); i++) {
											if (listExamDetailEntitySQL.get(index).getListAnswerChooseEntity().get(i).getAnswer() % 4 == 1) {
												out.print("A ");
											} else if (listExamDetailEntitySQL.get(index).getListAnswerChooseEntity().get(i).getAnswer()
													% 4 == 2) {
												out.print("B ");
											} else if (listExamDetailEntitySQL.get(index).getListAnswerChooseEntity().get(i).getAnswer()
													% 4 == 3) {
												out.print("C ");
											} else {
												out.print("D ");
											}
										}
								%>
							</td>
							<td>
								<%
									String check = "<font style=\"color: red;\">Incorrect</font>";
										int size = 0;
										List<AnswerChooseEntity> lAnswerChooseEntity = listExamDetailEntitySQL.get(index)
												.getListAnswerChooseEntity();
										if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size() == lAnswerChooseEntity
												.size()) {
											for (int i = 0; i < listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size(); i++) {
												for (int x = 0; x < lAnswerChooseEntity.size(); x++) {
													if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().get(i)
															.getCorrect() == lAnswerChooseEntity.get(x).getAnswer()) {
														size++;
													}
												}
											}
											if (size == lAnswerChooseEntity.size()) {
												check = "<font style=\"color: green;\">Correct</font>";
											}

										}
										size = 0;
										out.print(check);
										check = "<font style=\"color: red;\">Incorrect</font>";
								%>
							</td>

							<%
								}
							%>
						</tr>
					</table>
				</div>
				<div id="id01" class="modal">
					<div class="model-bottom">
						<div class="headerModel">
							<p class="headerModelP">Confirm delete</p>
						</div>
						<div style="text-align: center; width: 100%; height: 100px">
							<p>Do you want to delete this exam?</p>
							<span id="idQuestion"></span> - <span id="idFullname"></span> <input
								type="hidden" id="inputQ">
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
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- /.Footer -->
</body>
<script type="text/javascript">
	function show(id) {
		var fullname = document.getElementById("fullname").textContent.trim();
		document.getElementById('id01').style.display = "block";
		var n = id.length;
		var questionID = "";
		for (var i = 0; i < 7 - n; i++) {
			questionID = questionID + "0";
		}
		document.getElementById("idQuestion").innerHTML = "E" + questionID + id;
		document.getElementById("idFullname").innerHTML = fullname;
		document.getElementById("inputQ").value = id;
	}
	function del() {
		var id = document.getElementById("inputQ").value
		window.location.href = "deleteExam?examId=" + id;
	}
</script>
</html>
