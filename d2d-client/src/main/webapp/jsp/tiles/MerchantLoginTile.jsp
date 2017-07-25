<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script>

$().ready(function() {
	$("#login_form").validate();
});
</script>
<div class="container" style="width:50%">
	<div class="main" style="padding:0;margin-top:15%">
		<div>
			<p class="bg-primary" style="padding: 10px;font-weight:bold;">Merchant Login</p>
		</div>
 		<%if(request.getParameter("error") != null){ %>
			<div><p class="bg-danger" style="padding: 5px;font-weight:bold;margin-top:2%;"><%=request.getParameter("error").toString() %></p></div>
		<%}if(request.getParameter("success") != null){ %>
			<div><p class="bg-success" style="padding: 5px;font-weight:bold;margin-top:2%;"><%=request.getParameter("success").toString() %></p></div>
		<%} %>
		
		<div class="row" id="mer-sign-up" style="margin:4%;">	
			<form class="form-horizontal" id="offer-add-f" method="POST" action="<c:url value='/j_spring_security_check' />">
			  	<div class="form-group">
			    	<label for="_loginId" class="col-sm-3 control-label">User Id</label>
			    	<div class="col-sm-8">
			      		<input type="email" class="form-control" name="_loginId">
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label for="_cred" class="col-sm-3 control-label">Password</label>
			    	<div class="col-sm-8">
			      		<input type="password" class="form-control" name="_cred">
			    	</div>
			  	</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    	<div class="form-group">
		    		<label for="password" class="col-sm-3 control-label"></label>
			    	<div class="col-sm-8">
			      		<button type="submit" class="btn btn-primary">Login</button>
			      		<a href="../jsp/ProviderRegistration.jsp" class="btn btn-info">Sign Up</a>
			      	</div>
			 	</div>
			</form>
		</div>
		<div class="clearfix"></div>
	</div>
</div>