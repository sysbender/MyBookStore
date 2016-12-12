<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:t_page>
	<jsp:body>
		
  
<h1>Checkout Current Order:</h1>

			Order ID：${order.order_id } Total：<font color="red"><b>${order.total }</b></font>

<table border="1" width="100%"  >
	<tr bordercolor="gray" align="center">
		<td width="15%">
			Image
		</td>
		<td>Title</td>
		<td>Price</td>
		<td>Author</td>
		<td>Quantity</td>
		<td>Subtotal</td>
	</tr>
<c:forEach var="orderItem" items="${order.orderItems }">
	<tr bordercolor="gray" align="center">
		<td width="15%">
			<div><img src="<c:url value='/${orderItem.book.image }'/>" height="75"/></div>
		</td>
		<td>${orderItem.book.book_name }</td>
		<td>${orderItem.book.price }</td>
		<td>${orderItem.book.author }</td>
		<td>${orderItem.count }</td>
		<td>${orderItem.subtotal }</td>
	</tr>
</c:forEach>
</table>
<br/>
<form method="post" action="javascript:alert('Sorry, Checkout is not supported yet!');" id="form">
	Put your address：<input type="text" name="address" size="50" value=""/>
	<input type="button" value="Checkout (not Supported yet)" />
</form>
<a id="pay" href="javascript:document.getElementById('form').submit();"></a>






    </jsp:body>
</t:t_page>
  
