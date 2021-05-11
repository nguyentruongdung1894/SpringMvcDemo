<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<script src=<c:url value="/resources/js/fontawesome.js" />></script>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<script language="JavaScript" type="text/javascript">
	var t = setTimeout("document.myform.submit();", 1800000); //2 seconds measured in miliseconds
</script>
</head>
<body>
	<div class="">
		<div class="row">
			<div class="col-sm-9">
				<img alt="" src="<c:url value="/resources/images/logo.png" />"
					class="logo">
			</div>
			<%
				Date dNow = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			%>
			<div class="col-sm-3">
				<div class="row">
					<div class="col-sm-12 timeDate">
						<div class="row">
							<div class="col-sm-2">
								<b>Date</b>
							</div>
							<div class="col-sm-10">
								<div class="square">
									<div class="" id=""><%=ft.format(dNow)%></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12 timeDate">
						<div class="row">
							<div class="col-sm-2">
								<b>Time</b>
							</div>
							<div class="col-sm-10">
								<div class="countdown">
									<div class="square">
										<div class="digits" id="cd-min">00</div>
									</div>
									<div class="square">
										<div class="" id="">:</div>
									</div>
									<div class="square">
										<div class="digits" id="cd-sec">00</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				var h = document.getElementById("cd-min").textContent.trim();
				console.log(h);
			</script>
			<div class="col-sm-12">
				<b class="textHeader">CHALLENGE FOR CHANGE</b>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" style="margin-bottom: 10px;">
			<div class="col-sm-9"></div>
			<div class="col-sm-3" style="padding-right: 0">
				<span class="" style="float: right;">Hi: ${userName}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 title">
				<input value="${categoryName}" style="display: none;"
					id="spanCategoryName"> <b>Theary test: <span
					id="nameTest">${categoryName}</span> (<span id="countQ">20</span>
					Question)

				</b>
			</div>
		</div>
		<form:form method="post" action="welcome"
			modelAttribute="listQuestionsDTO" name="myform">
			<input type="text" name="fullName" value="${examEntity.fullName}"
				style="display: none;">
			<input type="text" name="phone" value="${examEntity.phone}"
				style="display: none;">
			<input type="text" name="email" value="${examEntity.email}"
				style="display: none;">
			<div class="">
				<c:forEach var="content"
					items="${listQuestionsDTO.listQuestionEntity}" varStatus="status">
					<div class="mySlides" style="width: 100%; height: 400px">
						<div class="row">
							<div class="col-sm-12">
								<input type="text"
									name="listQuestionEntity[${status.index}].questionId"
									value="${content.questionId}" style="display: none;"> <b>Question
									${status.count}: ${content.contentQuestion} </b>
							</div>
						</div>
						<div class="row contentAnswer">
							<c:forEach items="${content.listAnswerEntity}" var="contact"
								varStatus="statusa">
								<div class="col-sm-6 childcontentAnswer">
									<c:if test="${content.type==false }">
										<c:if test="${contact.answerId%4==1}">
											<input type="radio"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${contact.answerId }">A. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${content.type==true }">
										<c:if test="${contact.answerId%4==1}">
											<input type="checkbox"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${contact.answerId }">A. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>

									<c:if test="${content.type==false }">
										<c:if test="${contact.answerId%4==2}">
											<input type="radio"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${contact.answerId }">B. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${content.type==true }">
										<c:if test="${contact.answerId%4==2}">
											<input type="checkbox"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${contact.answerId }">B. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>

									<c:if test="${content.type==false }">
										<c:if test="${contact.answerId%4==3}">
											<input type="radio"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${contact.answerId }">C. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${content.type==true }">
										<c:if test="${contact.answerId%4==3}">
											<input type="checkbox"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${contact.answerId }">C. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>

									<c:if test="${content.type==false }">
										<c:if test="${contact.answerId%4==0}">
											<input type="radio"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${contact.answerId }">D. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${content.type==true }">
										<c:if test="${contact.answerId%4==0}">
											<input type="checkbox"
												name="listQuestionEntity[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${contact.answerId }">D. ${contact.contentAnswer}<br>
										</c:if>
									</c:if>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
				<c:forEach var="questionSQL"
					items="${listQuestionsDTO.listQuestionEntitySQL}"
					varStatus="status">
					<div class="mySlides" style="width: 100%; height: 400px">
						<div class="row">
							<div class="col-sm-12">
								<input type="text"
									name="listQuestionEntitySQL[${status.index}].questionId"
									value="${questionSQL.questionId}" style="display: none;">
								<b>Question ${status.count + 20}:
									${questionSQL.contentQuestion} </b>
							</div>
						</div>
						<div class="row contentAnswer">
							<c:forEach items="${questionSQL.listAnswerEntity}"
								var="answerSQL" varStatus="statusa">
								<div class="col-sm-6 childcontentAnswer">
									<c:if test="${questionSQL.type==false }">
										<c:if test="${answerSQL.answerId%4==1}">
											<input type="radio"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${answerSQL.answerId }">
									A. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==true }">
										<c:if test="${answerSQL.answerId%4==1}">
											<input type="checkbox"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${answerSQL.answerId }">
									A. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==false }">
										<c:if test="${answerSQL.answerId%4==2}">
											<input type="radio"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${answerSQL.answerId }">
									B. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==true }">
										<c:if test="${answerSQL.answerId%4==2}">
											<input type="checkbox"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${answerSQL.answerId }">
									B. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==false }">
										<c:if test="${answerSQL.answerId%4==3}">
											<input type="radio"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${answerSQL.answerId }">
									C. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==true }">
										<c:if test="${answerSQL.answerId%4==3}">
											<input type="checkbox"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${answerSQL.answerId }">
									C. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==false }">
										<c:if test="${answerSQL.answerId%4==0}">
											<input type="radio"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${status.index}].answerId"
												value="${answerSQL.answerId }">
									D. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
									<c:if test="${questionSQL.type==true }">
										<c:if test="${answerSQL.answerId%4==0}">
											<input type="checkbox"
												name="listQuestionEntitySQL[${status.index}].listAnswerEntity[${statusa.index}].answerId"
												value="${answerSQL.answerId }">
									D. ${answerSQL.contentAnswer}<br>
										</c:if>
									</c:if>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
				<div style="text-align: center;">
					<div class="row">
						<div class="col-sm-6">
							<button type="button" class="btn btnPrev" onclick="plusDivs(-1)"
								id="btnP" disabled="disabled">
								<span id="prev" style="font-weight: bold;">Prev</span>
							</button>
						</div>
						<div class="col-sm-6">
							<button type="button" class="btn btnNext" onclick="plusDivs(1)"
								id="btnNext">
								<span id="next" style="font-weight: bold;">Next</span>
							</button>
							<button type="button" class="btn btnSubmit" id="btnSubmit"
								style="display: none;"
								onclick="document.getElementById('myModal').style.display='block'">
								<span id="next" style="font-weight: bold;">Submit</span>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div id="myModal" class="modal">
				<div class="modal-content">
					<div
						style="border-bottom: 1px black solid; padding: 5px; background: #ee7c04">
						<b>Confirm</b>
					</div>
					<div style="text-align: center; margin-top: 30px">
						<span>Will not be able to change the result after
							submitting.</span>
					</div>
					<div style="text-align: center; margin-top: 5px">
						<span>Do you want to continue?</span>
					</div>
					<div style="text-align: center; margin: 35px;">
						<button type="submit" class="btn"
							style="margin-right: 90px; font-weight: bold;">OK</button>
						<button type="button" class="btn"
							style="margin-left: 90px; font-weight: bold;"
							onclick="document.getElementById('myModal').style.display='none'">Cancel</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js'></script>
	<script src="<c:url value="/resources/js/sketch.js" />"></script>
	<script type="text/javascript">
		var modal = document.getElementById("myModal");
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
	<script>
		var slideIndex = 1;
		showDivs(slideIndex);

		function plusDivs(n) {
			var value = document.getElementById("spanCategoryName").value;
			console.log(value);
			showDivs(slideIndex += n);
			if (slideIndex == 1) {
				document.getElementById("btnP").disabled = true;
			} else {
				document.getElementById("btnP").disabled = false;
			}
			if (slideIndex == 30) {
				document.getElementById("btnNext").style.display = "none";
				document.getElementById("btnSubmit").style.display = "inline-block";
				document.getElementById("btnSubmit").style.background = "#92d050";
			} else {
				document.getElementById("btnNext").style.display = "inline-block";
				document.getElementById("btnSubmit").style.display = "none";
			}
			if (slideIndex < 21) {
				document.getElementById("nameTest").innerHTML = value;
				document.getElementById("countQ").innerHTML = "20";
			} else {
				document.getElementById("nameTest").innerHTML = "SQL";
				document.getElementById("countQ").innerHTML = "10";
			}
		}

		function showDivs(n) {
			var i;
			var x = document.getElementsByClassName("mySlides");
			if (n > x.length) {
				slideIndex = 30
			}
			if (n < 1) {
				slideIndex = 1
			}
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			x[slideIndex - 1].style.display = "block";
		}
	</script>

</body>

</html>