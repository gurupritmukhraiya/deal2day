<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script>

$().ready(function() {
	$("#mer-register-f").validate({
		rules: {
			merchantName: {required: true,minlength: 2,	maxlength:30},
			contactNo: {required: true,minlength: 10,maxlength:10,number: true},
			emailId: {required: true,email: true},			
			password: {required: true,minlength: 5},
			cpassword: {required: true,minlength: 5,equalTo: "#_cred"},
			acceptCheck: {required: true}
		},
		messages: {
			merchantName: "Please enter Provider Name between 2 to 30 characters",
			contactNo: "Please provide the valid contact number",
			emailId: "Please enter a valid email address",	
			password: "Please provide a password at least 5 characters long",
			cpassword: "Confirm password must match password",
			acceptCheck:"Please accept the terms and condition"
		}	
	});
});

</script>
<div class="container" style="width:50%">
	<div class="main" style="padding:0;margin-top:15%;">
		<div>
				<p class="bg-primary" style="padding: 10px;font-weight:bold;">Merchant Signup</p>
		</div>
 		<c:if test="${result != null && result.status == 'fail'}">
			<div><p class="bg-danger" style="padding: 5px;font-weight:bold;margin-top:2%;">${ result.massage }</p></div>
		</c:if>
		<c:if test="${result != null && result.status == 'success'}">
			<div><p class="bg-success" style="padding: 5px;font-weight:bold;margin-top:2%;">${ result.massage }</p></div>
		</c:if>
		
		<div class="row" id="mer-sign-up" style="margin:4%;">				
			<div id="offer-request-ride-div">
				<form class="form-horizontal" id="mer-register-f" method="POST" action="${context}/mer/registerMerchant.htm">
					<div class="form-group">
				    	<label for="merchantName" class="col-sm-4 control-label">Merchant Name</label>
				    	<div class="col-sm-8">
				      		<input type="text" class="form-control" name="merchantName">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="contactNo" class="col-sm-4 control-label">Contact Number</label>
				    	<div class="col-sm-8">
				      		<input type="text" class="form-control" name="contactNo">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="emailId" class="col-sm-4 control-label">Email Id</label>
				    	<div class="col-sm-8">
				      		<input type="email" class="form-control" name="emailId">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="password" class="col-sm-4 control-label">Password</label>
				    	<div class="col-sm-8">
				      		<input type="password" class="form-control" name="password" id="_cred">
				    	</div>
				  	</div>
				  	<div class="form-group">
				    	<label for="cpassword" class="col-sm-4 control-label">Confirm Password</label>
				    	<div class="col-sm-8">
				      		<input type="password" class="form-control" name="cpassword">
				    	</div>
				  	</div>
			  		<div class="form-group">
			  			<label for="cpassword" class="col-sm-4 control-label"></label>
				    	<div class="col-sm-8">
				      		<input type="checkbox" name="acceptCheck"> Accept <a class="terms" href="TermsAndCondition.jsp" target="_blank">Terms & Conditions</a>
		      			</div>
		      		</div> 
			    	<div class="form-group">
			    		<label for="cpassword" class="col-sm-4 control-label"></label>
				    	<div class="col-sm-8">
				      		<button type="submit" class="btn btn-primary">Register Merchant</button>
				      		<a href="../jsp/merchant-login.jsp" class="btn btn-info">Login</a>
				    	</div>
				 	</div>
				</form>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>	
</div>