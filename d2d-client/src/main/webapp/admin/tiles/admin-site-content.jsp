<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<%@page import="com.d2d.service.CategoryService" %>
<%@page import="com.d2d.service.common.beans.Category"%>
<%@page import="java.util.*"%>
<%CategoryService categoryService = CategoryService.getInstanse();%>
<c:set var="categories" value="<%=categoryService.getAllCategory() %>" />

<div class="row">
	<p class="bg-primary" style="padding: 10px;font-weight:bold;">Manage Offers</p>
</div>

<!--Offer List Grid  -->
<div class="row" id="offer-list-d">
	<div class="row">
		<p class="text-primary col-sm-6"><strong>Registered Offers</strong></p>
		<div class="col-sm-6">
			<c:if test="${(not empty model.locations)}">
	    		<button type="submit" class="btn btn-primary" onclick="letAddOffer()" style="float:right;">Add Offer</button>
	    	</c:if>
	    	<c:if test="${(empty model.locations)}">
	    		<button type="submit" class="btn btn-primary disabled" onclick="letAddOffer()" style="float:right;">Add Offer</button>
	    	</c:if>
	    </div>
    </div>
    <c:if test="${(not empty model.locations) && (not empty model.offers)}">
    	<c:forEach items="${model.offers}" var="offer" varStatus="serialNo">
		 	<div id="offer-grid-${offer.idx}" class="span_1_of_3"  style="box-shadow: 0 0 5px #aaaaaa;margin:2% 0;padding: 10px;"> 
				<p>${offer.offerSummary}</p>
				<p class="title">Discount : ${offer.discount} | Min Bill Amt : ${offer.minBillAmt} | Coupon Price : ${offer.couponPrice} | <fmt:formatDate pattern="dd/MMM/yyyy" value="${offer.startDate}" /> - <fmt:formatDate pattern="dd/MMM/yyyy" value="${offer.endDate}" /></p>
				<input type="button" class="btn btn-warning" value="Edit" onClick="viewOffer(${offer.idx})"/>
				<input type="button" class="btn btn-primary offer-del-b" value="Delete" id="${offer.idx}" />		      			
				<div class="clear"></div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${(not empty model.locations) && (empty model.offers)}">
    	<p class="bg-info" style="padding: 5px;font-weight:bold;margin-top:2%;">OOPS!!! No offers :(</p>
    </c:if>
     <c:if test="${(empty model.locations)}">
   		<p class="bg-info" style="padding: 5px;font-weight:bold;margin-top:2%;">Please register location to add offer</p>
   	</c:if>
	<div class="clearfix"></div>
</div>

<!--Create offer Form  -->
<div class="row" style="display:none;" id="offer-add-d" >	
	<p class="text-primary"><strong>New Offer</strong></p>	
	<div id="offer-request-ride-div">
		<%-- <form class="form-horizontal" id="offer-add-f" method="POST" action="${context}/mer/createOffer.htm" enctype="multipart/form-data"> --%>
		<form class="form-horizontal" id="offer-add-f" action="${context}/mer/addOffer.htm">
			<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Offer Summary</label>
		    	<div class="col-sm-8">
		      		<input type="text" class="form-control" name="offerSummary">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Category</label>
		    	<div class="col-sm-3">
    	<select multiple="multiple" id="categorySelect" name="categories" size="5" style="width: 100%;" class="form-control">
		<c:if test="${not empty categories}">
			<c:forEach var="category" items="${categories}">
				<c:if test="${(category.type != 'd2d') && (category.type != 'Subcat')}">
				<option  value="${category.idx}">${category.name}</option>
				<%-- <optgroup value="${category.idx}" label="${category.name}">
					<c:set var="childrenIds" value="${category.children}" />
						<c:if test="${not empty childrenIds}">
							<c:forEach var="childId" items="${childrenIds}">
							<option  value="${childId}"><%= CategoryService.getInstanse().getCategoryById(Integer.parseInt(pageContext.getAttribute("childId").toString())).getName()%></option>
							</c:forEach>
						</c:if>	
				</optgroup> --%>
        		</c:if>
		  	</c:forEach>
	  	</c:if>
	  </select> 
				</div>
					<label for="inputEmail3" class="col-sm-2 control-label">Locations</label>
		    		<div class="col-sm-3">
			      		<select size="5" multiple="multiple" id="categorySelect2" name="locations" size="5" style="width: 100%;overflow-x:scroll; " class="form-control">
							<c:forEach items="${model.locations}" var="location" varStatus="serialNo">
							  	<option value="${location.idx}">${location.address}, ${location.area}, ${location.city}</option>
							</c:forEach>
						</select>
		    		</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Start Date</label>
		    	<div class="col-sm-3">
		      		<input type="text" name="startDate" class="date form-control" id="departure" placeholder="22/02/2014">
		    	</div>
		    	<label for="inputEmail4" class="col-sm-2 control-label">End Date</label>
		    	<div class="col-sm-3">
		      		<input type="text" name="endDate" class="date form-control" id="departure2" placeholder="22/02/2014">
		    	</div>
		  	</div>
			<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">On Min Bill</label>
		    	<div class="col-sm-3">
		      		<input type="text" class="form-control" name="minBillAmt">
		    	</div>
		    	<label for="inputEmail3" class="col-sm-2 control-label">Discount</label>
		    	<div class="col-sm-3">
		      		<input type="text" class="form-control" name="discount">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Highlights</label>
		    	<div class="col-sm-8">
		    		<textarea class="form-control" rows="3" cols="7" name="highlights"></textarea>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Terms & Conditions</label>
		    	<div class="col-sm-8">
		    		<textarea class="form-control" rows="3" cols="7" name="termsAndConditions"></textarea>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Coupon Price</label>
		    	<div class="col-sm-5">
		      		<input type="text" class="form-control" name="couponPrice">
		    	</div>
		    	<div class="col-sm-3">
		      		<div class="checkbox">
			        	<label>
			        		<input type="checkbox" checked="checked" id="status" value="A" name="status">Is Offer Active
			        	</label>
		      		</div> 
		    	</div>
		  	</div>		 
		  	<input type="hidden" name="coverImage" id="addImageField" />
		</form>
		<form id="image-upload-form" method="post" action="${context}/imageUpload/offOffer.htm" enctype="multipart/form-data">
			<div class="form-group row">
	    		<label class="col-sm-2 control-label">Offer Image</label>
	    		<div class="col-sm-5">
	      			<input type="file" name="offerImage" id="addOfferImageInput" class="form-control" style="height:auto;">	        		
		        </div>
		    	<div class="col-sm-3">
	      	    	<button value="Submit" onclick="uploadImage()" class="btn btn-warning" id="uploadImageB" disabled="disabled">Upload</button><br/>
		      	</div>
		  	</div>
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result"></div>
		  	</div>		  	
		 </form>
		 <div class="row form-group">
	    	<div class="col-sm-offset-2 col-sm-10">
	      		<button type="button" class="btn btn-primary" onclick="submitAddOfferForm()">Create Offer</button>
	      		<input type="button" class="btn btn-info" onclick="canAddOffer()" value="Cancel" />
	    	</div>
	 	</div>
	</div>
</div>

<!--Update offer Form  -->
<div class="row" style="display:none;" id="offer-update-d" >	
	<p class="text-primary"><strong>Update Offer</strong></p>	
	<div id="offer-request-ride-div">
		<%-- <form class="form-horizontal" id="offer-add-f" method="POST" action="${context}/mer/createOffer.htm" enctype="multipart/form-data"> --%>
		<form class="form-horizontal" id="offer-update-f" action="${context}/mer/updateOffer.htm">
			<input type="hidden" class="form-control" name="idx" value="">
			<div class="form-group">
		    	<label for="offerSummary" class="col-sm-2 control-label">Offer Summary</label>
		    	<div class="col-sm-8">
		      		<input type="text" class="form-control" name="offerSummary">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="categories" class="col-sm-2 control-label">Category</label>
		    	<div class="col-sm-3">
		      		<select multiple="multiple" id="categorySelect" name="categories" size="5" style="width: 100%;" class="form-control">
						
						<c:forEach var="category" items="${categories}">
				<c:if test="${(category.type != 'd2d') && (category.type != 'Subcat')}">
				<option  value="${category.idx}">${category.name}</option>
				</c:if>
				</c:forEach>
				
						<!-- <optgroup label="Group One">
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
						</optgroup>
						<optgroup label="Group Two" >
							<option value="4">Option 4</option>
							<option value="5">Option 5</option>
							<option value="6">Option 6</option>
							<option value="7">Option 7</option>
						</optgroup> -->
					</select></div>
					<label for="inputEmail3" class="col-sm-2 control-label">Locations</label>
		    		<div class="col-sm-3">
			      		<select size="5" multiple="multiple" id="categorySelect2" name="locations" size="5" style="width: 100%;overflow-x:scroll; " class="form-control">
							<c:forEach items="${model.locations}" var="location" varStatus="serialNo">
							  	<option value="${location.idx}">${location.address}, ${location.area}, ${location.city}</option>
							</c:forEach>
						</select>
		    		</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="departure" class="col-sm-2 control-label">Start Date</label>
		    	<div class="col-sm-3">
		      		<input type="text" name="startDate" class="date form-control" id="updateOfferStartDate" placeholder="22/02/2014">
		    	</div>
		    	<label for="departure2" class="col-sm-2 control-label">End Date</label>
		    	<div class="col-sm-3">
		      		<input type="text" name="endDate" class="date form-control" id="updateOfferEndDate" placeholder="22/02/2014">
		    	</div>
		  	</div>
			<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">On Min Bill</label>
		    	<div class="col-sm-3">
		      		<input type="text" class="form-control" name="minBillAmt">
		    	</div>
		    	<label for="inputEmail3" class="col-sm-2 control-label">Discount</label>
		    	<div class="col-sm-3">
		      		<input type="text" class="form-control" name="discount">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Highlights</label>
		    	<div class="col-sm-8">
		    		<textarea class="form-control" rows="3" cols="7" name="highlights"></textarea>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Terms & Conditions</label>
		    	<div class="col-sm-8">
		    		<textarea class="form-control" rows="3" cols="7" name="termsAndConditions"></textarea>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Coupon Price</label>
		    	<div class="col-sm-5">
		      		<input type="text" class="form-control" name="couponPrice">
		    	</div>
		    	<div class="col-sm-3">
		      		<div class="checkbox">
			        	<label>
			        		<input type="checkbox" checked="checked" id="status" value="A" name="status">Is Offer Active
			        	</label>
		      		</div> 
		    	</div>
		  	</div>		  	
		  	<input type="hidden" name="coverImage" id="updateImageField" />
		</form>
		<form id="image-upload-form-update" method="post" action="${context}/imageUpload/offOffer.htm" enctype="multipart/form-data">
			<div class="form-group row">
	    		<label class="col-sm-2 control-label">Offer Image</label>
	    		<div class="col-sm-5">
	      			<input type="file" name="offerImage" id="updateOfferImageInput" class="form-control" style="height:auto;">	        		
		        </div>
		    	<div class="col-sm-3">
	      	    	<button value="Submit" onclick="uploadUpdateImage()" class="btn btn-warning" id="uploadImageBUpdate" disabled="disabled">Upload</button><br/>
		      	</div>
		  	</div>
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result-update"></div>
		  	</div>		  	
		 </form>
		 <div class="row form-group">
    		<div class="col-sm-offset-2 col-sm-10">
	      		<button type="button" onclick="submitUpdateOfferForm()" class="btn btn-primary">Update Offer</button>
	      		<input type="button" class="btn btn-info" onclick="canAddOffer()" value="Cancel" />
	    	</div>
	 	</div>
	</div>
</div>

<div class="clearfix"></div>