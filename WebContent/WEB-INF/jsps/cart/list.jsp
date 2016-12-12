<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:t_page>
	<jsp:body>
		<h1>My Shopping Cart:</h1>

			 
			<a href="<c:url value='/CartServlet?method=clear' />" style="font-size: 15pt; font-weight: 900">empty cart</a>

<table border="1" width="100%" cellspacing="0" background="black">

	<tr>
		<th>image</th>
		<th>title</th>
		<th>author</th>
		<th>price</th>
		<th>quantity</th>
		<th>subtotal</th>
		<th>operation</th>
	</tr>
<c:forEach var="cartItem" items="${sessionScope.cart.cartItems }">
	<tr>
		<td>
				
		<img src="<c:url value='/${cartItem.book.image }'/>" height="100" width="60" />
		
		</td>
		<td>${cartItem.book.book_name}</td>
		<td>${cartItem.book.author }</td>
		<td>${cartItem.book.price }</td>
		<td>${cartItem.count }</td>
		<td>${cartItem.subtotal }</td>
		<td><a href="<c:url value='/CartServlet?method=delete&book_id=${cartItem.book.book_id }' />">delete</a></td>
	</tr>
	</c:forEach>
 
 

	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			Total：${sessionScope.cart.total }
		</td>
	</tr>
	
</table>
	
	<c:if test="${not ( empty sessionScope.cart || fn:length(sessionScope.cart.cartItems) eq 0 ) }">
 

			<a id="buy" href="<c:url value='/OrderServlet?method=add'/>"   style="font-size: 15pt; font-weight: 900"> order </a>
 
 
	</c:if>
	

    </jsp:body>
</t:t_page>




  




