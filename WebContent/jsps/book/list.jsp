<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:t_page>

    <jsp:body>
    <div class="row" style="display:flex; flex-wrap: wrap;">
        <c:forEach var="book" items="${bookList }">
					<div class=" col-md-3">

						<a href="<c:url value='/BookServlet?method=load&book_id=${book.book_id }'/>" class="img-thumbnail"> <img
							src="<c:url value='/${book.image}'/>"
							alt="${book.book_name }" height="150" width="100">
						</a>
						<div class="caption">${book.book_name }</div>

					</div>
				</c:forEach>
		</div>		
    </jsp:body>
</t:t_page>