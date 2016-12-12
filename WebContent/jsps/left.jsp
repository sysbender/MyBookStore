
<%@ page language="java" import="java.util.*, com.voxwalker.bookstore.service.CategoryService, com.voxwalker.bookstore.domain.Category, com.voxwalker.bookstore.service.BookService" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%

CategoryService g = new CategoryService();
List<Category> categoryList = g.findAll();
request.setAttribute("categoryList", categoryList);

BookService bs = new BookService();
List<String> languageList = bs.findAllLanguage();
request.setAttribute("languageList", languageList);
%>
<ul>
<li> <a href="<c:url value='/BookServlet?method=findAll'/>"> <h3>All Books</h3></a> </li>
<li>by categories</li>
<ul>
<c:forEach var="category" items="${categoryList }">
<li> <a href="<c:url value='/BookServlet?method=findByCategory&category_id=${category.category_id }'/>">${category.category_name }</a> </li>
</c:forEach>
</ul>

<li>by Language</li>
<ul>
<c:forEach var="language" items="${languageList }">
<li>
<a href="<c:url value='/BookServlet?method=findByLanguage&language=${language }'/>">${language }</a>
</li>
</c:forEach>
</ul>



</ul>


