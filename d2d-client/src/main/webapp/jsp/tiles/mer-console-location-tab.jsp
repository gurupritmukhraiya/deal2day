<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="row">
	<p class="bg-primary" style="padding: 10px;font-weight:bold;">Manager Locations</p>
</div>

<!--Location List Table -->
<div class="row" id="loc-list-d">
	<div class="row">
		<p class="text-primary col-sm-6"><strong>Registered Address</strong></p>
		<div class="col-sm-6">
	    	<button type="submit" class="btn btn-primary" onclick="letAddLoc()" style="float:right;">Add Location</button>
	    </div>
    </div>
    <c:if test="${(not empty model.locations)}">
	 	<table class="table">
	      	<thead>
	        	<tr>
		          	<th>#</th>
		          	<th>City</th>
		          	<th>Area</th>
		          	<th>Landmark</th>
		          	<th>Contact No</th>
		          	<th>Action</th>
	        	</tr>
	      	</thead>
	      	<tbody id="loc-list-tb">
	      		<c:forEach items="${model.locations}" var="location" varStatus="serialNo">
				  <tr>
				  	<th scope="row">${serialNo.index}</th>
				  	<td>${location.city}</td>
	          		<td>${location.area}</td>
	          		<td>${location.address}</td>
	          		<td>${location.contactNo}</td>
	          		<td>
		          		<form class="form-horizontal" method="post" onsubmit="return confirm('Do you really want to delete the location?');" action="${context }/mer/delete-location.htm">
		          			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		          			<input type="hidden" name="idx" value="${location.idx }" />
		          			<input style="font-size:10px;" type="submit" class="btn btn-primary del-loc-row" value="Delete" />
		          		</form>		
		          	</td>
	          	  </tr>
				</c:forEach>
	      	</tbody>
	    </table>
    </c:if>
    <c:if test="${(empty model.locations)}">
    	<p class="bg-info" style="padding: 5px;font-weight:bold;margin-top:2%;">OOPS!!! No registered locations :(</p>
    </c:if>
	<div class="clearfix"></div>
</div>

<!--Create Location Form  -->
<div class="row" id="loc-add-d" style="display:none;">	
	<p class="text-primary"><strong>New Address</strong></p>	
	<form class="form-horizontal" id="loc-add-f" method="post" action="${context }/mer/add-location.htm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	  	<div class="form-group">
	    	<label for="inputEmail3" class="col-sm-2 control-label">Select City</label>
	    	<div class="col-sm-3">
		        <select name="city" class="frm-field required" style="border-radius:0;">
					<option value="-1">Select City</option>
					<option value="Mumbai">Mumbai</option>         
					<option value="Pune">Pune</option>
					<option value="Nagpur">Nagpur</option>
					<option value="Indore">Indore</option>
					<option value="Jabalpur">Jabalpur</option>
			    </select>
			 </div>
			<label for="inputEmail3" class="col-sm-2 control-label">Area</label>
	    	<div class="col-sm-3">
	      		<input type="text" class="form-control" name="area">
	    	</div>
	   	</div>
	  	<div class="form-group">
	  		<label for="inputEmail3" class="col-sm-2 control-label">Landmark</label>
	    	<div class="col-sm-8">
	      		<input type="text" class="form-control" name="address">
	    	</div>
	  	</div>
	  	<div class="form-group">
	  		<label for="inputEmail2" class="col-sm-2 control-label">Pin code</label>
	    	<div class="col-sm-2">
	      		<input type="text" class="form-control" name="pincode">
	    	</div>
	    	<label for="inputEmail2" class="col-sm-3 control-label">Contact Number</label>
	    	<div class="col-sm-3">
	      		<input type="text" class="form-control" name="contactNo">
	    	</div>
	  	</div>
	  	<div class="form-group">
	    	<div class="col-sm-offset-2 col-sm-10">
	      		<button type="submit" class="btn btn-primary">Add Location</button>
	      		<input type="button" class="btn btn-info" onclick="canAddLoc()" value="Cancel" />
	    	</div>
	 	</div>
	</form>						
	<div class="clearfix"></div>
</div>

<div class="clearfix"></div>