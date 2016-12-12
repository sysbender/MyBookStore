<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="web_language"
	value="${not empty param.web_language ? param.web_language : not empty web_language ? web_language : pageContext.request.locale}"
	scope="session" />

<fmt:setLocale value="${web_language }" />
<fmt:setBundle basename="com.voxwalker.bookstore.i18n.text" />

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<a class="navbar-brand" href="#"> <span
			style="color: navy; font-weight: bold">My</span><span
			style="color: navy" class="glyphicon glyphicon-book"></span><span
			style="color: navy">Store</span>
		</a>
		
		<a class="navbar-brand" href="<c:url value='/WebLanguageServlet?web_language=en'/>">En</a>
		<a class="navbar-brand" href="<c:url value='/WebLanguageServlet?web_language=fr'/>">Fr</a>

		<ul class="nav navbar-nav ">
			<c:choose>
				<c:when test="${empty sessionScope.session_user }">
					<li><a href="<c:url value='/UserServlet?method=rememberLogin'/>"> <fmt:message key="top.login"/> </a></li>
					<li><a href="<c:url value='/jsps/user/regist.jsp'/>"> <fmt:message key="top.register"/></a></li>
				</c:when>
				<c:otherwise>


					<li><a href="#">Hello：${sessionScope.session_user.username}</a></li>
		<li><a href="<c:url value='/CartServlet?method=list'/>"><fmt:message key="top.myShoppingCart"/></a></li>
					<li><a href="<c:url value='/OrderServlet?method=getOrdersByUser'/>"><fmt:message key="top.myOrders"/></a></li>
					<li><a href="<c:url value='/UserServlet?method=quit'/>"><fmt:message key="top.logout"/></a></li>




				</c:otherwise>

			</c:choose>
			

		</ul>
	</div>

</nav>