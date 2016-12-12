<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:t_page>
	<jsp:body>
		 
		 
						<div class=" col-md-9">

						 <img src="<c:url value='/${book.image}'/>"
							alt="${book.book_name }" height="300" width="200">
						 
						<div class="caption">
						<h3>${book.book_name }</h3>
						
			<c:if test="${not empty sessionScope.cart }">
				<form id="form" action="<c:url value='/CartServlet'/>"
					method="post">
					<input type="hidden" name="method" value="add" />
					<input type="hidden" name="book_id" value="${book.book_id }"/>
					<input type="text" size="3" name="count" value="1" />
					<input type="submit" name="submit" value="Add to Cart"/>
				</form>
			</c:if>
							<ul>

								<li>Author： ${book.author }</li>
								<li>Language:${book.language }</li>
								<li>Price ： ${book.price }</li>
								<li>ISBN: ${book.isbn }</li>
								<li>Description : ${book.description } </li>
							</ul>
						</div>

					</div>
    </jsp:body>
</t:t_page>
			
