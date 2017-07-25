<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="row">
	<p class="bg-primary" style="padding: 10px;font-weight:bold;">My Profile</p>
</div>

<!--Merchant Profile  -->
<div class="row" id="mer-profile-d">	
	<div class="row">
		<p class="text-primary col-sm-6"><strong>Personal Details</strong></p>
		<div class="col-sm-6" style="float:right;width:auto;">
	    	<button type="submit" class="btn btn-primary" onclick="letMerUpdate()">Update Profile</button>
	    	<button type="submit" class="btn btn-primary" onclick="letChangePassword()">Change Password</button>
	    </div>
    </div>	
	<div class="form-group" style="color:#555;padding:10px;">			
		<div class="col-md-3" style="color:#777;text-align:right;">
			<p>Merchant Name</p>
			<p>Contact Number</p>
			<p>Mail Id</p>
			<p>URL</p>
			<p>Logo</p>
		</div>
		<div class="col-md-8" style="color:#333;">
			<p>${model.profile.merchantName}</p>
			<p id="mer-contact-p">${model.profile.contactNo}</p>
			<p>${model.profile.emailId}</p>
			<p>${model.profile.URL}</p>
			<p>
				<c:if test="${fn:containsIgnoreCase(model.profile.imagePath, 'mer/true') == false}">
      				<img src="http://img.deal2day.in/site/default.jpg" class="img-responsive" width="300"/>
      			</c:if>
      			<c:if test="${fn:containsIgnoreCase(model.profile.imagePath, 'mer/true')}">
      				<img src="http://img.deal2day.in/mer_offer/${model.profile.idx}/logo.jpg" class="img-responsive" width="300"/>
      			</c:if>  
      		</p>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>

<!--Merchant Update Form  -->
<div class="row" id="mer-update-d" style="display:none;">
	<p class="text-primary"><strong>Update Profile</strong></p>
	<form class="form-horizontal" action="${context}/mer/update-profile.htm?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>
		<div class="form-group">
	    	<label for="merchantName" class="col-sm-3 control-label">Merchant Name</label>
	    	<div class="col-sm-8">
	      		<input class="form-control" name="merchantName" value="${model.profile.merchantName}" disabled="disabled" />
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<label for="contactNo" class="col-sm-3 control-label">Contact Number</label>
	    	<div class="col-sm-8">
	      		<input class="form-control" name="contactNo" value="${model.profile.contactNo}" />
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<label for="emailId" class="col-sm-3 control-label">Email Id</label>
	    	<div class="col-sm-8">
	      		<input type="email" class="form-control" name="emailId" value="${model.profile.emailId}" disabled="disabled">
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<label for="emailId" class="col-sm-3 control-label">URL</label>
	    	<div class="col-sm-7">
	      		<input type="text" class="form-control" name="URL" value="${model.profile.URL}">
	    	</div>
	  	</div>
	  	<div class="form-group">
    		<label class="col-sm-3 control-label">Merchant Image/Logo</label>
    		<div class="col-sm-5">
      			<input type="file" id="updateMerchantImageInput" name="imagePath" class="form-control" style="height:auto;">	        		
	        </div>
	        <div class="col-sm-4">
	        	<c:if test="${fn:containsIgnoreCase(model.profile.imagePath, 'mer/true') == false}">
      				<img src="http://img.deal2day.in/site/default.jpg" class="img-responsive"/>
      			</c:if>
      			<c:if test="${fn:containsIgnoreCase(model.profile.imagePath, 'mer/true')}">
      				<img src="http://img.deal2day.in/mer_offer/${model.profile.idx}/logo.jpg" class="img-responsive"/>
      			</c:if>      			       		
	        </div>
  		</div>
  		<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result-update"></div>
		</div>
	  	<div class="form-group">
	    	<div class="col-sm-offset-3 col-sm-10">
	      		<input type="submit" class="btn btn-primary" value="Save Changes" />
	      		<input type="button" class="btn btn-info" onclick="canMerUpdate()" value="Cancel" />
	    	</div>
	 	</div>
	</form>
	<div class="clearfix"></div>
</div>

<!--Merchant Change Password  -->
<div class="row" id="mer-change-pass-d" style="display:none;">
	<p class="text-primary"><strong>Change Password</strong></p>
	<form class="form-horizontal" id="mer-change-pass-f" action="${context }/mer/changeCred.htm" method="post">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>
	  	<div class="form-group">
	    	<label for="oldPassword" class="col-sm-3 control-label">Old Password</label>
	    	<div class="col-sm-8">
	      		<input type="password" class="form-control" name="oldPassword">
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<label for="password" class="col-sm-3 control-label">Password</label>
	    	<div class="col-sm-8">
	      		<input type="password" class="form-control" id="password" name="password">
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<label for="cpassword" class="col-sm-3 control-label">Confirm Password</label>
	    	<div class="col-sm-8">
	      		<input type="password" class="form-control" name="cpassword">
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<div class="col-sm-offset-3 col-sm-10">
	      		<input type="submit" class="btn btn-primary" value="Change Password" />
	      		<input type="button" class="btn btn-info" onclick="canChangePass()" value="Cancel" />
	    	</div>
	 	</div>
	</form>
	<div class="clearfix"></div>
</div>
<div class="clearfix"></div>