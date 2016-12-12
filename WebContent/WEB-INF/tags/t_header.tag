<%@tag description="Page navigate header template" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<a class="navbar-brand" href="#"> <span
			style="color: navy; font-weight: bold">My</span><span
			style="color: navy" class="glyphicon glyphicon-book"></span><span
			style="color: navy">Store</span>
		</a>
		<ul class="nav navbar-nav ">
			<c:choose>
				<c:when test="${empty sessionScope.session_user }">
					<li><a href="<c:url value='/jsps/user/login.jsp'/>">Login</a></li>
					<li><a href="<c:url value='/jsps/user/regist.jsp'/>">Register</a></li>
				</c:when>
				<c:otherwise>
				
		
		<li><a href="#">Hello：${sessionScope.session_user.username}</a></li>>
		<li><a href="<c:url value='/jsps/cart/list.jsp'/>">My
							Shopping Cart</a></li>
					<li><a href="<c:url value='/jsps/order/list.jsp'/>">My
							Orders</a></li>
					<li><a href="<c:url value='/UserServlet?method=quit'/>">Logout</a></li>

				</c:otherwise>

			</c:choose>
		</ul>
	</div>

</nav>