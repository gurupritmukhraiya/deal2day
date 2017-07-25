<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="row">
	<p class="bg-primary" style="padding: 10px;font-weight:bold;">Manage Categories</p>
</div>

<div class="row" id="cat-list-d">
	<div class="row">
		<p class="text-primary col-sm-6"><strong>Categories</strong></p>
		<div class="col-sm-6">
	    	<button class="btn btn-info" onclick="letAddCat()" style="float:right;">Add Category</button>
	    </div>
    </div>
    <c:if test="${(not empty model.categories)}">
	 	<table class="table">
	      	<thead>
	        	<tr>
		          	<th>#</th>
		          	<th>Name</th>
		          	<th>Parent</th>
		          	<th>Type</th>
		          	<th>Action</th>
	        	</tr>
	      	</thead>
	      	<tbody id="loc-list-tb">
	      		<c:forEach items="${model.categories}" var="category" varStatus="serialNo">
				  <tr>
				  	<th scope="row">${serialNo.index}</th>
				  	<td>${category.name}</td>
	          		<td>${category.parent}</td>
	          		<td>${category.type}</td>
	          		<td>
	          			<%-- <form action="${context}/admin/updateCategory.htm" target="_blank">
	          				<input type="hidden" value="${category.idx}" name="id" /> --%>
	          				<input type="submit" style="font-size:10px;" type="button" class="btn btn-info" value="Update" onClick="viewCat(${category.idx})"/>
	          			<!-- </form> -->
	          		</td>
	          		<td>
	          			<form action="${context}/admin/deleteCategory.htm" method="post">
	          				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	          				<input type="hidden" value="${category.idx}" name="id" />
	          				<input type="submit" style="font-size:10px;" type="button" class="btn btn-info" value="Delete"/>
	          			</form>
	          		</td>
	          	  </tr>
				</c:forEach>
	      	</tbody>
	    </table>
    </c:if>
    <c:if test="${(empty model.categories)}">
    	<p class="bg-info" style="padding: 5px;font-weight:bold;margin-top:2%;">OOPS!!! No Categories :(</p>
    </c:if>
	<div class="clearfix"></div>
</div>

<div class="row" style="display:none;" id="cat-add-d" >	
	<p class="text-primary"><strong>Add New Category</strong></p>	
	<div id="offer-request-ride-div">
		 <form class="form-horizontal" id="cat-add-f" method="post" action="${context}/admin/addCategory.htm?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Name</label>
		    	<div class="col-sm-8">
		      		<input type="text" class="form-control" name="name">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Parent</label>
		    	<div class="col-sm-3">
			    	<select name="parent" style="width: 100%;" class="form-control">
						<c:if test="${not empty model.categories}">
							<c:forEach var="parent" items="${model.categories}">
								<option value="${parent.idx}">${parent.name}</option>
							</c:forEach>
				  		</c:if>
				  		<c:if test="${empty model.categories}">
							<option selected="selected" value="0">D2D</option>
				  		</c:if>
				  	</select> 
				</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Type</label>
		    	<div class="col-sm-3">
			    	<select name="type" style="width: 100%;" class="form-control" id="typeSelect">
						<c:if test="${not empty model.categories}">
							<c:forEach var="type" items="${model.categories}">
								<option  value="${type.name}">${type.name}</option>
							</c:forEach>
							<option value="other">Other</option>
				  		</c:if>
				  		<c:if test="${empty model.categories}">
							<option selected="selected" value="0">D2D</option>
				  		</c:if>
				  	</select> 
				 </div>
			  	<div class="col-sm-3" id="newTypeInput" style="display:none;">
	      			<input type="text" class="form-control" name="newType">
	    		</div>
		  	</div>
		  	<div class="form-group">
	    		<label class="col-sm-2 control-label">Category Image</label>
	    		<div class="col-md-6">
	      			<input type="file" id="catImageInput" name="imagePath" class="form-control" style="height:auto;">	        		
		        </div>
		  	</div>
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result-update"></div>
		  	</div>
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result"></div>
		  	</div>
		  	<div class="form-group">
	    	<div class="col-sm-offset-2 col-sm-10">
	      		<input type="submit" class="btn btn-primary" value="Create Offer" />
	      		<input type="button" class="btn btn-info" onclick="canCatAdd()" value="Cancel" />
	    	</div>
	 	</div>
		</form>
	</div>
</div>

<div id="cat-update-d" class="row" style="display:none;">	
	<p class="text-primary"><strong>Update Category</strong></p>	
	<div id="cat-update-div">
		<form enctype="multipart/form-data" action="${context}/admin/updateCategory.htm?${_csrf.parameterName}=${_csrf.token}" method="post" id="cat-update-f" class="form-horizontal">
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <input type="hidden" class="form-control" name="idx" value="">
			<div class="form-group">
		    	<label class="col-sm-2 control-label" for="inputEmail3">Name</label>
		    	<div class="col-sm-8">
		      		<input type="text" name="name" class="form-control">
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Parent</label>
		    	<div class="col-sm-3">
			    	<select name="parent" style="width: 100%;" class="form-control">
						<c:if test="${not empty model.categories}">
							<c:forEach var="parent" items="${model.categories}">
								<option value="${parent.idx}">${parent.name}</option>
							</c:forEach>
				  		</c:if>
				  		<c:if test="${empty model.categories}">
							<option selected="selected" value="0">D2D</option>
				  		</c:if>
				  	</select> 
				</div>
		  	</div>
		  	<div class="form-group">
		    	<label for="inputEmail3" class="col-sm-2 control-label">Type</label>
		    	<div class="col-sm-3">
			    	<select name="type" style="width: 100%;" class="form-control" id="typeSelect">
						<c:if test="${not empty model.categories}">
							<c:forEach var="type" items="${model.categories}">
								<option  value="${type.name}">${type.name}</option>
							</c:forEach>
							<!-- <option value="other">Other</option> -->
				  		</c:if>
				  		<c:if test="${empty model.categories}">
							<option selected="selected" value="0">D2D</option>
				  		</c:if>
				  	</select> 
				 </div>
			  	<div class="col-sm-3" id="newTypeInput" style="display:none;">
	      			<input type="text" class="form-control" name="newType">
	    		</div>
		  	</div>
		  	
		  	<div class="form-group">
	    		<label class="col-sm-2 control-label">Category Image</label>
	    		<div class="col-md-6">
	      			<input type="file" id="catUpdateImageInput" style="height:auto;" class="form-control" name="imagePath">	        		
		        </div>
		  	</div>
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result-update"></div>
		  	</div>
		  	<div class="form-group row">
		  		<label class="col-sm-2 control-label"></label>
		  		<div id="result"></div>
		  	</div>
		  	<div class="form-group">
	    	<div class="col-sm-offset-2 col-sm-10">
	      		<input type="submit" value="Update Category" class="btn btn-primary" onclick="submitUpdateCategoryForm()">
	      		<input type="button" value="Cancel" onclick="canCatAdd()" class="btn btn-info">
	    	</div>
	 	</div>
		</form>
	</div>
</div>
<div class="clearfix"></div>