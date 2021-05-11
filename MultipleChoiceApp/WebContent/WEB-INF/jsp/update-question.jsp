<%@page import="usolv.com.vn.entitys.QuestionEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Question</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<link href="<c:url value="/resources/css/styleQuestion.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styleAddQuestion.css" />"
	rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
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
	<div class="navbar container navbarb">
		<label class="navText">Question Managerment >> Update</label>
	</div>
	<div class="content container" style="margin-bottom: 15px">
		<div class="row">
			<div class="col-sm-7">
				<div class="navbarb"
					style="text-align: center; width: 100%; background-color: #5b9bd5">
					<p class="infomation" style="margin: 0">Question Information</p>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="navbarb"
					style="text-align: center; width: 100%; background-color: #5b9bd5">
					<p class="infomation" style="margin: 0">Answers</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form:form action="update-question-succ" method="post"
					modelAttribute="listAnswers">
					<div class="row">
						<div class="col-sm-7">
							<ul class="form-style-1">

								<%
									QuestionEntity questionEntity = (QuestionEntity) request.getAttribute("questionEntity");
										int questionId = questionEntity.getQuestionId();
										String questionID = "";
										int count = Integer.toString(questionId).length();
										for (int i = 0; i < 7 - count; i++) {
											questionID = questionID + "0";
								%>
								<%
									}
								%>

								<li style="display: none;"><label>Quest ID</label> <input
									type="text" name="questionId" class="field-divided"
									placeholder="Quest ID" value="${questionEntity.questionId}"
									readonly style="background: #dcdcdc; text-align: center;" /></li>

								<li><label class="lableQ">Quest ID</label> <input
									type="text" name="" class="field-divided"
									placeholder="Quest ID" value="Q<%=questionID%><%=questionId%>"
									readonly style="background: #dcdcdc; text-align: center;" /></li>

								<li><label class="lableQ">Text</label> <textarea
										name="contentQuestion" class="field-long field-textarea">${questionEntity.contentQuestion}</textarea></li>
								<li><label class="lableQ">Category</label> <select
									name="categoryId" class="field-select">
										<c:forEach items="${listCategoriesEntity}"
											var="listCategoriesEntity">
											<option value="${listCategoriesEntity.categoryId}">${listCategoriesEntity.categoryName}</option>
										</c:forEach>
								</select></li>
								<li><label class="lableQ">Type</label> <select name="type"
									class="field-select">
										<option value="false">Single</option>
										<option value="true">Multi</option>
								</select></li>
								<li><label class="lableQ">Status</label> <select
									name="status" class="field-select">
										<option value="true">Display</option>
										<option value="false">Hide</option>
								</select></li>
								<li><input type="submit" value="Update" class="btnUpdate" /></li>
								<li><input type=button value="Delete"
									onclick="show('${questionEntity.questionId}')"
									class="btnUpdate" /></li>
								<li><input type=button value="Cancel"
									onclick="history.go(-1)" class="btnUpdate" /></li>
							</ul>
						</div>
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
								window.location.href = "deleteQuestion?questionId="
										+ id;
							}
						</script>
						<div class="col-sm-5">
							<div style="display: none; width: 100%; height: 35px">
								<a onclick=""
									style="background: #5b9bd5; padding: 5px 15px; color: white; float: right; font-weight: bold;">Add</a>
							</div>
							<c:forEach items="${listAnswers}" var="answerEntitys"
								varStatus="status">
								<div class="form-style-1 divblock">
									<div style="width: 100%">
										<div class="lableAnswer">
											<label class="lableA">Answers ${status.count}</label> <input
												type="text" name="answerEntitys[${status.index}].answerId"
												value="${answerEntitys.answerId}" class="field-divided"
												placeholder="Answer ID" style="display: none;" />
										</div>
										<div class="textareaA">
											<textarea name="answerEntitys[${status.index}].contentAnswer"
												class="field-long field-textarea-left">${answerEntitys.contentAnswer}</textarea>
										</div>
										<div class="radioA">
											<div style="height: 25px">
												<label class="container lableA">True <input
													type="radio" value="true"
													name="answerEntitys[${status.index}].correctAnswer">
												</label>
											</div>
											<div style="height: 25px">
												<label class="container lableA">False <input
													type="radio" value="false"
													name="answerEntitys[${status.index}].correctAnswer">
												</label>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</form:form>
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
</html>