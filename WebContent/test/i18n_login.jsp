<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />

<fmt:setLocale value="${language }" />
<fmt:setBundle basename="com.voxwalker.bookstore.i18n.text" />


<!DOCTYPE html>
<html lang="${language }">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> hello</h1>
${pageContext.response.locale}<br>
${pageContext.request.locale}<br>


	<form action="">
		<select id="language" name="language" onchange="submit()">
			<option value="en" ${language=='en' ? 'selected' : '' }>English</option>
			<option value="fr" ${language=='fr' ? 'selected' : '' }>French</option>

		</select>

	</form>

	<form action="" method="post">
		<label for="username"> <fmt:message key="login.label.username" />:
		</label> <input type="text" id="username" name="username" /> <br> <label
			for="password"> <fmt:message key="login.label.password" />:
		</label> <input type="password" id="password" name="password" />
		<fmt:message key="login.button.submit" var="buttonValue" />
		<input type="submit" name="submit" value="${buttonValue }" />



	</form>




</body>
</html>