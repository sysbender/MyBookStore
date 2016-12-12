<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<t:t_page>

	<jsp:body>
						<!-- ============================login.jsp -->

				<h2 class="form-signin-heading">Please sign in</h2>
				<p style="color: red; font-weight: 900">${msg }</p>
				<form class="form-horizontal" action="<c:url value='/UserServlet'/>"
			method="post">



					<input type="hidden" name="method" value="login" />

					<div class="form-group">
						<label class="control-label col-sm-2" for="userName">User
							Name:</label>
						<div class="col-sm-10">
							<input type="text" name="username" value="${form.username }"
						class="form-control" id="userName" placeholder="Enter User Name" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Password:</label>
						<div class="col-sm-10">
							<input type="password" name="password" class="form-control"
						id="pwd" placeholder="Enter password" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="remember_me">Remember Me:</label>
						<div class="col-sm-1">
							<input type="checkbox" name="remember" value="true" class="form-control"
						id="remember_me"  />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" value="Log In" class="btn btn-default"/>
						</div>
					</div>
				</form>
    </jsp:body>
</t:t_page>