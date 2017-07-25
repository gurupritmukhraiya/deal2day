<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div id="show-notification"></div>
<div id="overlay"><img src="${context}/images/loading.gif" style="left:50%;top:50%;position:absolute;width:20%;transform: translate(-50%, -50%);"></div>
<div class="container">
	<div class="main">
		<div class="row">
			<c:if test="${result != null && result.status == 'fail'}">
				<div><p class="bg-danger" style="padding: 5px;font-weight:bold;margin-top:2%;">${ result.massage }</p></div>
			</c:if>
			<c:if test="${result != null && result.status == 'success'}">
				<div><p class="bg-success" style="padding: 5px;font-weight:bold;margin-top:2%;">${ result.massage }</p></div>
			</c:if>
      		<div class="tabbable tabs-left">
      			<div class="col-md-3">
	        		<ul class="nav nav-tabs nav-stacked nav-pills" style="background-color:#337AB7;">
	        			<li class="active"><a href="#merchat-tab" data-toggle="tab">Manager Merchants</a></li>
			  			<li><a href="#auto-offer-tab" data-toggle="tab">Automated Offers</a></li>
						<li><a href="#options-tab" data-toggle="tab">Manage Options</a></li>
			  		</ul>
        		</div>
	        	<div class="tab-content col-md-9">
	        		<div class="tab-pane active" id="merchat-tab">
						<jsp:include page="admin-merchant.jsp" />
					</div>
		        	<div class="tab-pane" id="auto-offer-tab">	
		        		<jsp:include page="admin-auto-offers.jsp" />
		        	</div>
		       		<div class="tab-pane" id="options-tab">
						<jsp:include page="admin-category.jsp" />
					</div>
				</div>
      		</div>
    	</div>
	</div>
</div>
