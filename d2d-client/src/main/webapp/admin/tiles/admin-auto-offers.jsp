<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<%@page import="com.d2d.service.CategoryService" %>
<%@page import="com.d2d.service.common.beans.Category"%>
<%@page import="java.util.*"%>
<%CategoryService categoryService = CategoryService.getInstanse();%>
<c:set var="categories" value="<%=categoryService.getAllCategory() %>" />

<div class="row">
	<p class="bg-primary" style="padding: 10px;font-weight:bold;">Manage Automated Offers</p>
</div>

<!--Fetch Online Offers  -->
<div class="row" style="margin-top:10px;">
	<p class="text-primary col-sm-4"><strong>Fetch Online Offers</strong></p>
	<form method="post" action="${context}/admin/executeAffilateAPI.htm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="col-sm-4">
	    	<select name="affilateName">
	    		<option value="">Select Affilate Client</option>
	    		<option value="PAYOOM">PAYOOM</option>
	    		<option value="VCOMMISION">V-COMMISSION</option>
	    	</select>
	    </div>
	    <div class="col-sm-4">
	    	<input type="submit" class="btn btn-info" value="Execute API" />
	    </div>
    </form>
	<div class="clearfix"></div>
</div>

<HR WIDTH=50% ALIGN=CENTER noshade size=4 style="border: 1px solid;">

<div class="row">
	<p class="text-primary col-sm-4"><strong>Read Coupon CSV</strong></p>
	<form method="post" action="${context}/admin/readAffilateCSV.htm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="col-sm-4">
	    	Affilate<select name="affilateName">
	    		<option value="">Select Affilate Client</option>
	    		<option value="PAYOOM">PAYOOM</option>
	    		<option value="VCOMMISION">V-COMMISSION</option>
	    	</select>
	    	Category<select name="category" multiple>
	    		<option value="">Select Category</option>
	    		<c:if test="${not empty categories}">
					<c:forEach var="category" items="${categories}">
						<c:if test="${(category.type != 'd2d') && (category.type != 'Subcat')}">
							<option  value="${category.idx}">${category.name}</option>
						</c:if>
		  			</c:forEach>
	  			</c:if>
	    	</select>
	    </div>
	    <div class="col-sm-4">
	    	<input type="submit" class="btn btn-info" value="Read CSV" />
	    </div>
    </form>
	<div class="clearfix"></div>
</div>

<HR WIDTH=50% ALIGN=CENTER noshade size=4 style="border: 1px solid;">

<div class="row">
	<p class="text-primary"><strong>Upload Coupon CSV</strong></p>
	<div class="row">
		<form class="form-horizontal" id="uploadCSVForm" method="post" action="${context}/fileUpload/uploadCSV.htm" enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="col-sm-4">
		    	<select name="affilateName">
		    		<option value="">Select Affilate Client</option>
		    		<option value="PAYOOM">PAYOOM</option>
		    		<option value="VCOMMISION">V-COMMISSION</option>
		    	</select>
		    </div>
		    <div class="col-sm-4">
	    		<input type="file" name="file" class="form-control" style="height:auto;width:100%;">	        		
		    </div>
		    <div class="col-sm-4">
		    	<input type="submit" class="btn btn-info" value="Upload CSV" />
		    </div>
	    </form>
    </div>
	<div class="clearfix"></div>
</div>

<HR WIDTH=50% ALIGN=CENTER noshade size=4 style="border: 1px solid;">

<div class="clearfix"></div>