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

<div class="row" id="offer-list-d">
	<div class="row">
		<p class="text-primary col-sm-6"><strong>Registered Offers</strong></p>
		<div class="col-sm-6">
    		<button type="submit" class="btn btn-primary" onclick="letAddOffer()" style="float:right;">Add Offer</button>
	    </div>
    </div>
    <c:if test="${(not empty model.offers)}">
    	<c:forEach items="${model.offers}" var="offer" varStatus="serialNo">
		 	<div id="offer-grid-${offer.idx}" class="span_1_of_3"  style="box-shadow: 0 0 5px #aaaaaa;margin:2% 0;padding: 10px;"> 
				<p>${offer.offerSummary}</p>
				<p class="title">Discount : ${offer.discount} | Min Bill Amt : ${offer.minBillAmt} | Coupon Price : ${offer.couponPrice} | <fmt:formatDate pattern="dd/MMM/yyyy" value="${offer.startDate}" /> - <fmt:formatDate pattern="dd/MMM/yyyy" value="${offer.endDate}" /></p>
				<input type="button" class="btn btn-warning" value="Edit" onClick="viewOffer(${offer.idx})"/>
				<div class="clear"></div>
				<form class="form-horizontal" method="post" onsubmit="return confirm('Do you really want to delete offer?');" action="${context }/mer/delete-offer.htm">
          			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          			<input type="hidden" name="idx" value="${offer.idx}" />
          			<input style="font-size:10px;" type="submit" class="btn btn-primary del-loc-row" value="Delete" />
          		</form>
				<div class="clear"></div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${empty model.offers}">
    	<p class="bg-info" style="padding: 5px;font-weight:bold;margin-top:2%;">OOPS!!! No offers :(</p>
    </c:if>
    <div class="clearfix"></div>
</div>

<!--Create offer Form  -->
<div class="row" style="display:none;" id="offer-add-d" >	
	<p class="text-primary"><strong>New Offer</strong></p>	
	<div id="offer-request-ride-div">
		<form class="form-horizontal" id="offer-add-f" method="post" action="${context}/mer/add-offer.htm?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Title</label>
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
									<%
									    Category category = (Category)pageContext.getAttribute("category");
										String parentName = categoryService.getParentName(category.getIdx());
									%>
									<option value="${category.idx}" title="${category.name}, <% out.write(parentName); %>">${category.name}, <% out.write(parentName); %></option>
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
		    	<label for="inputEmail3" class="col-sm-2 control-label">Offer URL</label>
		    	<div class="col-sm-4">
		      		<input type="text" class="form-control" name="url" >
		    	</div>
		    	<label for="inputEmail4" class="col-sm-2 control-label">PROMO CODE</label>
		    	<div class="col-sm-2">
		      		<input type="text" class="form-control" name="promoCode" placeholder="Pormo Code">
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
		    		<textarea class="form-control" rows="3" cols="7" name="description"></textarea>
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
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Status</label>
		    	<div class="col-sm-5">
		      		<div class="radio"><input type="radio" id="status" checked="checked" name="status" value="A">Active</div>
		        	<div class="radio"><input type="radio" id="status"  name="status" value="Inactive">Inactive</div> 
		    	</div>
		  	</div>		 
		  	<div class="form-group">
	    		<label class="col-sm-2 control-label">Offer Image</label>
	    		<div class="col-sm-5">
	      			<input type="file" name="coverImage" id="addOfferImageInput" class="form-control" style="height:auto;">	        		
		        </div>
		  	</div>		  	
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result"></div>
		  	</div>
		  	<div class="form-group">
	    	<div class="col-sm-offset-2 col-sm-10">
	      		<input type="submit" class="btn btn-primary" value="Create Offer" />
	      		<input type="button" class="btn btn-info" onclick="canAddOffer()" value="Cancel" />
	      		<input type="reset" class="btn btn-info"  value="Reset" />
	    	</div>
	 	</div>
		</form>
	</div>
</div>
 <!-- update offer form -->
<div class="row" style="display:none;" id="offer-update-d" >	
	<p class="text-primary"><strong>Update Offer</strong></p>	
	<div id="offer-request-ride-div">
			<form class="form-horizontal" id="offer-update-f" method="post" action="${context}/mer/update-offer.htm?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
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
								<%
								    Category category = (Category)pageContext.getAttribute("category");
									String parentName = categoryService.getParentName(category.getIdx());
								%>
								<option value="${category.idx}" title="${category.name}, <% out.write(parentName); %>">${category.name}, <% out.write(parentName); %></option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<label for="locations" class="col-sm-2 control-label">Locations</label>
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
		      		<input type="text" name="startDate" class="date form-control" id="updateOfferStartDate" >
		    	</div>
		    	<label for="departure2" class="col-sm-2 control-label">End Date</label>
		    	<div class="col-sm-3">
		      		<input type="text" name="endDate" class="date form-control" id="updateOfferEndDate" >
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Offer URL</label>
		    	<div class="col-sm-4">
		      		<input type="text" class="form-control" name="url" >
		    	</div>
		    	<label for="inputEmail4" class="col-sm-2 control-label">PROMO CODE</label>
		    	<div class="col-sm-2">
		      		<input type="text" class="form-control" name="promoCode" placeholder="Pormo Code">
		    	</div>
		  	</div>
			<div class="form-group">
		    	<label for="minBillAmt" class="col-sm-2 control-label">On Min Bill</label>
		    	<div class="col-sm-3">
		      		<input type="text" class="form-control" name="minBillAmt">
		    	</div>
		    	<label for="discount" class="col-sm-2 control-label">Discount</label>
		    	<div class="col-sm-3">
		      		<input type="text" class="form-control" name="discount">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="description" class="col-sm-2 control-label">Highlights</label>
		    	<div class="col-sm-8">
		    		<textarea class="form-control" rows="3" cols="7" name="description" ></textarea>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="termsAndConditions" class="col-sm-2 control-label">Terms & Conditions</label>
		    	<div class="col-sm-8">
		    		<textarea class="form-control" rows="3" cols="7" name="termsAndConditions"></textarea>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inpcouponPriceutEmail3" class="col-sm-2 control-label">Coupon Price</label>
		    	<div class="col-sm-5">
		      		<input type="text" class="form-control" name="couponPrice">
		    	</div>
		  	</div>	
		  	<div class="form-group">
		    	<label for="inpcouponPriceutEmail3" class="col-sm-2 control-label">Status</label>
		    	<div class="col-sm-5">
		      		<div class="radio"><input type="radio" id="status"  name="status" value="A">Active</div>
		        	<div class="radio"><input type="radio" id="status"  name="status" value="Inactive">Inactive</div> 
		    	</div>
		  	</div>
		    <div class="form-group">
	    		<label class="col-md-2 control-label">Offer Image</label>
	    		<div class="col-md-5">
	      			<input type="file" name="coverImage" id="updateOfferImageInput" class="form-control" style="height:auto;">	        		
		        </div>
		        <div class="col-md-5"><img id="offer-img-u" src="" alt="No Image"></div>
		  	</div>		  	
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result-update"></div>
		  	</div>	
		  	<div class="row form-group">
    		<div class="col-sm-offset-2 col-sm-10">
	      		<button type="button" onclick="submitUpdateOfferForm()" class="btn btn-primary">Update Offer</button>
	      		<input type="button" class="btn btn-info" onclick="canAddOffer()" value="Cancel" />
	    	</div>
	 	</div>  	
		</form>
		
	</div>
</div>

<div class="clearfix"></div>