<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="row">
	<p class="bg-primary" style="padding: 10px;font-weight:bold;">Manage Merchants</p>
</div>

<div class="row" id="assign-mer-d">
	<div class="row">
		<p class="text-primary col-sm-6"><strong>New Merchant Names</strong></p>
    </div>
    <form action="${context}/admin/assignMerchant.htm" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		New Merchants<select name="newMerchant">
			<c:if test="${(not empty model.merchantNamesWithoutId)}">
				<c:forEach items="${model.merchantNamesWithoutId}" var="newMerchant" varStatus="serialNo">
					<option value="${newMerchant.idx}<#>${newMerchant.merchantName}">${newMerchant.merchantName}</option>
				</c:forEach>
			</c:if>
		</select>
		Old Merchants<select name="oldMerchant">
			<c:if test="${(not empty model.merchants)}">
				<c:forEach items="${model.merchants}" var="merchant" varStatus="serialNo">
					<option value="${merchant.idx}">${merchant.merchantName}</option>
				</c:forEach>
			</c:if>			
		</select>
    	<input type="submit" style="font-size:10px;" type="button" class="btn btn-info" value="Assign Manager"/>
    </form>
 	<div class="clearfix"></div>
</div>

<!--Merchant List Table -->
<div class="row" id="mer-list-d">
	<div class="row">
		<p class="text-primary col-sm-6"><strong>Registered Merchant</strong></p>
		<div class="col-sm-6">
	    	<button class="btn btn-info" onclick="letAddMerchant()" style="float:right;">Add Merchant</button>
	    </div>
    </div>
    <c:if test="${(not empty model.merchants)}">
	 	<table class="table">
	      	<thead>
	        	<tr>
		          	<th>#</th>
		          	<th>Merchant Name</th>
		          	<th>Contact No</th>
		          	<th>Email Id</th>
		          	<th>Status</th>
		          	<th>Login</th>
	        	</tr>
	      	</thead>
	      	<tbody id="loc-list-tb">
	      		<c:forEach items="${model.merchants}" var="merchant" varStatus="serialNo">
				  <tr>
				  	<th scope="row">${serialNo.index}</th>
				  	<td>${merchant.merchantName}</td>
	          		<td>${merchant.contactNo}</td>
	          		<td>${merchant.emailId}</td>
	          		<c:if test = "${merchant.status == 'A'}">
	          			<td id="merchant-status-${merchant.idx}"><input style="font-size:10px;" type="button" class="btn btn-primary" onclick="updateMerchantStatus(${merchant.idx}, 'INACTIVE')" value="Inactive Merchant"/></td>
	          		</c:if>
	          		<c:if test = "${merchant.status == 'INACTIVE'}">
	          			<td id="merchant-status-${merchant.idx}"><input style="font-size:10px;" type="button" class="btn" onclick="updateMerchantStatus(${merchant.idx}, 'A')" value="Active Merchant"/></td>
	          		</c:if>
	          		<td>
	          			<form action="${context}/admin/loginMerchant.htm" target="_blank" method="POST">
	          				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	          				<input type="hidden" value="${merchant.emailId}" name="mer-login-id" />
	          				<input type="submit" style="font-size:10px;" type="button" class="btn btn-info" value="Login"/>
	          			</form>
	          		</td>
	          	  </tr>
				</c:forEach>
	      	</tbody>
	    </table>
    </c:if>
    <c:if test="${(empty model.merchants)}">
    	<p class="bg-info" style="padding: 5px;font-weight:bold;margin-top:2%;">OOPS!!! No Merchants :(</p>
    </c:if>
	<div class="clearfix"></div>
</div>

<!--Create Merchant Form  -->
<div class="row" id="mer-add-d" style="display:none;">	
	<p class="text-primary"><strong>New Merchant</strong></p>	
	<div class="row" id="mer-sign-up">				
		<div id="offer-request-ride-div">
			<form class="form-horizontal" id="mer-register-f" method="POST" action="${context}/admin/addMerchant.htm?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="form-group">
			    	<label for="merchantName" class="col-sm-3 control-label">Merchant Name</label>
			    	<div class="col-sm-7">
			      		<input type="text" class="form-control" name="merchantName">
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label for="contactNo" class="col-sm-3 control-label">Contact Number</label>
			    	<div class="col-sm-7">
			      		<input type="text" class="form-control" name="contactNo">
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label for="emailId" class="col-sm-3 control-label">Email Id</label>
			    	<div class="col-sm-7">
			      		<input type="email" class="form-control" name="emailId">
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label for="emailId" class="col-sm-3 control-label">URL</label>
			    	<div class="col-sm-7">
			      		<input type="text" class="form-control" name="URL" value="http://deal2day.in/">
			    	</div>
			  	</div>
			  	<div class="form-group">
		    		<label class="col-sm-3 control-label">Merchant Image/Logo</label>
		    		<div class="col-sm-5">
		      			<input type="file" name="imagePath" class="form-control" style="height:auto;">	        		
			        </div>
		  		</div>	
		  		<div class="form-group">
		  			<label class="col-sm-3 control-label">Merchant Status</label>
		      		<div class="col-sm-7">
	      				<input type="radio" checked="checked" id="status" value="A" checked name="status"> Active
		        		<input type="radio" checked="checked" id="status" value="Inactive" name="status"> Inactive
			        </div> 
		    	</div>
			  	<div class="form-group">
		    		<label for="cpassword" class="col-sm-3 control-label"></label>
			    	<div class="col-sm-7">
			      		<button type="submit" class="btn btn-primary">Register Merchant</button>
			      		<input type="button" class="btn btn-info" onclick="canMerAdd()" value="Cancel"/>
			    	</div>
			 	</div>
			</form>
		</div>
	</div>
</div>

<div class="clearfix"></div>