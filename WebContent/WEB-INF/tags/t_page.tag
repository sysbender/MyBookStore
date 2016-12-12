<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>



<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>MyBookStore</title>
<!-- 
${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/
 -->
<!-- Bootstrap core CSS -->
<link
	href="resources/css/bootstrap.css"	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/style.css" 	rel="stylesheet">
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
				<!-- body -->
 					<jsp:doBody/>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>
