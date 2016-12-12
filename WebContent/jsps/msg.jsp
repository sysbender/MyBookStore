<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Starter Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">
		<!-- top and navbar -->
		<div class="row">
			<jsp:include page="/jsps/top.jsp" />
		</div>
		<!-- content -->
		<div class="row">

			<!--  left -->
			<div class="col-md-3 sidebar">
				<ul class="nav nav-sidebar">
					<jsp:include page="/jsps/left.jsp" />
				</ul>
			</div>

			<div class="col-md-9">
				<h1>${msg }</h1>
			</div>
		</div>
	</div>
	
	
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
