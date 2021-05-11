<%@page import="usolv.com.vn.DAO.Impl.QuestionDAOImpl"%>
<%@page import="usolv.com.vn.entitys.QuestionEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Question</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<link href="<c:url value="/resources/css/styleQuestion.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styleAddQuestion.css" />"
	rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<label class="navText">Question Managerment >> Add new</label>
	</div>
	<div class="content container" style="margin-bottom: 15px">
		<div class="row">
			<div class="col-sm-7">
				<div class="navbarb"
					style="text-align: center; width: 100%; background-color: #5b9bd5;">
					<p class="infomation" style="margin: 0">Question Information</p>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="navbarb"
					style="text-align: center; width: 100%; background-color: #5b9bd5;">
					<p class="infomation" style="margin: 0">Answers</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form:form action="add-question-succ" method="post" name="myForm"
					onsubmit="return validateForm()" modelAttribute="listAnswers">
					<div class="row">
						<div class="col-sm-7">
							<ul class="form-style-1">
								<%
									List<QuestionEntity> listQuestionEntity = new QuestionDAOImpl().GetAllQuestions1();
										int litQ = listQuestionEntity.size() + 1;
										int check = 0;
										String questionID = "";
										int count = Integer.toString(litQ).length();
										for (int i = 0; i < 7 - count; i++) {
											questionID = questionID + "0";
								%>
								<%
									}
								%>
								<li><label class=lableQ>Quest ID</label> <input type="text"
									name="questionId" class="field-divided" placeholder="Quest ID"
									readonly style="background: #dcdcdc; text-align: center;"
									value="Q<%=questionID%><%=litQ%>" /></li>
								<li><label class="lableQ">Text</label> <textarea
										name="contentQuestion" class="field-long field-textarea"></textarea></li>
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
								<li class=""><input type="submit" value="Add"
									class="btnadd" /></li>
								<li class=""><input type=button value="Cancel"
									class="btnadd" onclick="history.go(-1)" /></li>
							</ul>
						</div>
						<div class="col-sm-5">
							<div style="display: block; width: 100%; height: 35px">
								<a onclick="myFunction()"
									style="background: #5b9bd5; padding: 5px 15px; color: white; float: right; font-weight: bold;">Add</a>
							</div>
							<div class="form-style-1 divnone" id="1">
								<div style="width: 100%">
									<div class="lableAnswer">
										<label class="lableA">Answers 1</label>
									</div>
									<div class="textareaA">
										<textarea name="answerEntitys[0].contentAnswer"
											class="field-long field-textarea-left"></textarea>
									</div>
									<div class="radioA">
										<div style="height: 25px">
											<label class="container lableA"> <input type="radio"
												value="true" name="answerEntitys[0].correctAnswer"
												style="margin-right: 5px;">True
											</label>
										</div>
										<div style="height: 25px">
											<label class="container lableA"> <input type="radio"
												value="false" name="answerEntitys[0].correctAnswer"
												style="margin-right: 5px;">False
											</label>
										</div>
									</div>
								</div>
								<div class="fa-closeA">
									<div style="height: 15px"></div>
									<div style="height: 35px">
										<a onclick="hide1()" id=""><i class='fa fa-close'
											style='font-size: 15px; color: #5b9bd5'></i></a>
									</div>
								</div>
							</div>
							<div class="form-style-1 divnone" id="2">
								<div style="width: 100%">
									<div class="lableAnswer">
										<label class="lableA">Answers 2</label>
									</div>
									<div class="textareaA">
										<textarea name="answerEntitys[1].contentAnswer"
											class="field-long field-textarea-left"></textarea>
									</div>
									<div class="radioA">
										<div style="height: 25px">
											<label class="container lableA"> <input type="radio"
												value="true" name="answerEntitys[1].correctAnswer"
												style="margin-right: 5px;">True
											</label>
										</div>
										<div style="height: 25px">
											<label class="container lableA"> <input type="radio"
												value="false" name="answerEntitys[1].correctAnswer"
												style="margin-right: 5px;">False
											</label>
										</div>
									</div>
									<div class="fa-closeA">
										<div style="height: 15px"></div>
										<div style="height: 35px">
											<a onclick="hide2()" id=""><i class='fa fa-close'
												style='font-size: 15px; color: #5b9bd5'></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="form-style-1 divnone" id="3">
								<div style="width: 100%">
									<div class="lableAnswer">
										<label class="lableA">Answers 3</label>
									</div>
									<div class="textareaA">
										<textarea name="answerEntitys[2].contentAnswer"
											class="field-long field-textarea-left"></textarea>
									</div>
									<div class="radioA">
										<div style="height: 25px">
											<label class="container lableA"> <input type="radio"
												value="true" name="answerEntitys[2].correctAnswer"
												style="margin-right: 5px;">True
											</label>
										</div>
										<div style="height: 25px">
											<label class="container lableA"> <input type="radio"
												value="false" name="answerEntitys[2].correctAnswer"
												style="margin-right: 5px;">False
											</label>
										</div>
									</div>
									<div class="fa-closeA">
										<div style="height: 15px"></div>
										<div style="height: 35px">
											<a onclick="hide3()" id=""><i class='fa fa-close'
												style='font-size: 15px; color: #5b9bd5'></i></a>
										</div>
									</div>
								</div>
							</div>
							<div class="form-style-1 divnone" id="4">
								<div style="width: 100%">
									<div class="lableAnswer">
										<label class="lableA">Answers 4</label>
									</div>
									<div class="textareaA">
										<textarea name="answerEntitys[3].contentAnswer"
											class="field-long field-textarea-left"></textarea>
									</div>
									<div class="radioA">
										<div style="height: 25px">
											<label class="container lableA"><input type="radio"
												value="true" name="answerEntitys[3].correctAnswer"
												style="margin-right: 5px;">True </label>
										</div>
										<div style="height: 25px">
											<label class="container lableA"><input type="radio"
												value="false" name="answerEntitys[3].correctAnswer"
												style="margin-right: 5px;">False </label>
										</div>
									</div>
									<div class="fa-closeA">
										<div style="height: 15px"></div>
										<div style="height: 35px">
											<a onclick="hide4()" id=""><i class='fa fa-close'
												style='font-size: 15px; color: #5b9bd5'></i></a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
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
	<script>
		function validateForm() {
			var contentQuestion = document.forms["myForm"]["contentQuestion"].value;
			if (contentQuestion == "") {
				document.getElementById('id01').style.display = 'block';
				document.getElementById("idQuestion").innerHTML = " content question";
				return false;
			}

		}
	</script>
	<script>
		var counter = 1;
		function count() {
			if (counter < 4) {
				counter++
			} else {
				counter = 1;
			}
			return counter;
		}
		function myFunction() {
			var x = document.getElementById(count());
			x.style.display = "block";
		}
		function hide1() {
			var x = document.getElementById("1");
			x.style.display = "none";
		}
		function hide2() {
			var x = document.getElementById("2");
			x.style.display = "none";
		}
		function hide3() {
			var x = document.getElementById("3");
			x.style.display = "none";
		}
		function hide4() {
			var x = document.getElementById("4");
			x.style.display = "none";
		}
	</script>
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