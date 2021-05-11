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
	var t = setTimeout("document.myform.submit();", 1500000); //2 seconds measured in miliseconds
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
				<b>Theary test: Finished</b>
			</div>
		</div>
	</div>
	<div class="container"
		style="margin: 58px 285px; font-size: 23px; line-height: 40px;">
		<div>
			<b>Congratulations, you've just completed the theory test.</b>
		</div>
		<div>
			<b>Thank you for choosing USOL-V as the next company.</b>
		</div>
		<div>
			<b>Hope to be working with you soon.</b>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js'></script>
	<script src="<c:url value="/resources/js/sketch.js" />"></script>

</body>

</html>