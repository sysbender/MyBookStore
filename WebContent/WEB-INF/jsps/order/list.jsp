<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:t_page>
	<jsp:body>
		
		<h1>My Orders:</h1>



<c:forEach var="order" items="${orderList }">

			Order ID ：${order.order_id }　Order Time ：${order.order_time }　Total ：<font color="red"><b>${order.total }</b></font>　
		<c:choose >
		<c:when test="${order.state eq 1 }"> <a href="#" style="font-size: 16pt; font-weight: bold ;  text-decoration: line-through">Check Out</a> </c:when>
		<c:when test="${order.state eq 4 }"> Archived Order </c:when>
		</c:choose>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr bordercolor="gray" align="center">
		<td width="15%">
			Book
		</td>
		<td>Title</td>
		<td>Price</td>
		<td>Author</td>
		<td>Quantity</td>
		<td>Subtotal </td>
	</tr>
	<c:forEach var="orderItem" items="${order.orderItems }"  >
	<tr bordercolor="gray" align="center">
		<td width="15%">
			<div><img src="<c:url value='/${orderItem.book.image }'/>" height="75"/></div>
		</td>
		<td> ${orderItem.book.book_name }</td>
		<td> ${orderItem.book.price }</td>
		<td> ${orderItem.book.author }</td>
		<td> ${orderItem.count }</td>
		<td> ${orderItem.subtotal }  </td>
	</tr>
	</c:forEach>
	</table>
</c:forEach>

		
		
		
    </jsp:body>
</t:t_page>

