<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:t_page>

	<jsp:body>
						<h1>Register</h1>
				<p style="color: red; font-weight: 900">${msg }</p>
				<form class="form-horizontal" action="<c:url value='/UserServlet'/>"
					method="post">
					
					<input type="hidden" name="method" value="regist"/>

					<div class="form-group">
						<label class="control-label col-sm-2" for="userName">Email:</label>
						<div class="col-sm-10">
							<input type="text" name="username" value="${form.username }"
								class="form-control" id="userName" placeholder="Enter User Name" />
							<span style="color: red; font-weight: 900">${errors.username }</span>
						</div>

					</div>


					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Password:</label>
						<div class="col-sm-10">
							<input type="password" name="password" value="${form.password }"
								class="form-control" id="pwd" placeholder="Enter password" /> <span
								style="color: red; font-weight: 900">${errors.password }</span>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-10">
							<input type="email" name="email" value="${form.email }"
								class="form-control" id="email" placeholder="Enter email" /> <span
								style="color: red; font-weight: 900">${errors.email }</span>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" value="register" class="btn btn-default">Register</button>
						</div>
					</div>
				</form>
    </jsp:body>
</t:t_page>