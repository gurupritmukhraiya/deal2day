<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="offer" value="${model.offer}" />
<c:set var="locations" value="${model.locations}" />
<%@page import="com.d2d.constants.ImageConstant" %>
<script>
$( document ).ready(function() {
	$('#myTabs a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	});
});
</script>
<div class="container" style="margin:30px auto;">
<div class="panel panel-primary">
  	<div class="panel-heading">
    	<h3 class="panel-title text-uppercase">${offer.merchantName}</h3>
  	</div>
  	<div class="panel-body">
  	<div class="row">
		<div class="col-md-6">
			<c:if test="${fn:containsIgnoreCase(offer.imageURL, 'true')}">
			    <img src="<%=ImageConstant.MERCHANT_OFFER_IMG_URL %>${offer.merchantId}/${offer.idx}.jpg" alt="${offer.offerSummary}" class="img-responsive">
			</c:if>
			<c:if test="${fn:containsIgnoreCase(offer.imageURL, 'true') == false}">
			    <img src="${offer.imageURL}" alt="${offer.offerSummary}" class="img-responsive">
			</c:if>
		</div>
		<div class="col-md-6">
			<div class="row"><div class="col-md-12 text-primary lead" >${offer.offerSummary}</div></div>
			<div class="row text-center">
				<div class="col-md-4">
					<h4><small>ON MIN BILL</small></h4><p id="min-bill">${offer.minBillAmt}</p>
				</div>
				<div class="col-md-4">
					<h4><small>YOU SAVE</small></h4><p id="discount">${offer.discount } %</p>
				</div>
				<div class="col-md-4">
					<h4><small>COUPON PRICE</small></h4>FREE
				</div>
			</div>
			<c:if test="${not empty offer.promoCode && fn:containsIgnoreCase(offer.promoCode, 'NA') == false}">
				<div class="row text-center">
					<div class="col-md-6 bg-info text-muted text-uppercase" style="border: 2px dashed orange;">
						<h4>${offer.promoCode }</h4>
					</div>		
					<div class="col-md-6">
						<button type="button" class="btn btn-warning" data-toggle="modal" data-oid="${offer.idx}" data-code="${offer.promoCode}" data-pid="${offer.merchantId}" onclick="sendCoupon()" data-target="#send-coupon-model">Get Coupon!</button>	
					</div>		
				</div>		
			</c:if>	
			</div>		
		</div>					
	</div>
	<hr class="small">

	<div class="row">
		<div class="col-md-12">
			<ul role="tablist" class="nav nav-pills tab-justify" id="myTabs">
				<c:if test="${not empty offer.description}">
		      		<li class="active" role="presentation"><a aria-expanded="true" aria-controls="home" data-toggle="tab" role="tab" id="desc-tab" href="#desc">Description</a></li>
		      	</c:if>
		      	<c:if test="${not empty offer.termsAndConditions}">
					<li role="presentation"><a aria-controls="profile" data-toggle="tab" id="term-tab" role="tab" href="#term">T&C</a></li>
				</c:if>
		      	<c:if test="${not empty locations}">
		      		<li role="presentation"><a aria-controls="profile" data-toggle="tab" id="loc-tab" role="tab" href="#loc">Location</a></li>
		      	</c:if>
		    </ul>
		    <div class="tab-content" id="myTabContent">
		      	<div aria-labelledby="desc-tab" id="desc" class="tab-pane fade in active" role="tabpanel">
		        	<ol>
						<c:if test="${not empty offer.description}">
							<c:forEach var="highlight" items="${offer.description}">
	                  				<li>${highlight}</li>					
	        					</c:forEach>
			    		</c:if>
		        	</ol>
			     </div>
			      <div aria-labelledby="term-tab" id="term" class="tab-pane fade" role="tabpanel">
			        <ol>
						<c:if test="${not empty offer.termsAndConditions}">
							<c:forEach var="term" items="${offer.termsAndConditions}">
								<li>${term}</li>
					        </c:forEach>
				    	</c:if>
		        	</ol>
			      </div>
			    <div aria-labelledby="loc-tab" id="loc" class="tab-pane fade" role="tabpanel">
			    	<div class="row">
				    	<c:if test="${not empty locations}">
							<c:forEach var="location" items="${locations}">
								<div class="col-md-4 text-info">
									<address>
						  				<strong>${offer.merchantName},</strong><br>
					  					${location.address},<br>
					  					${location.area},${location.city}-${location.pincode}<br>
					  					<abbr title="Phone"><i class="fa fa-phone"></i></abbr> ${location.contactNo}
									</address> 
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
  </div>
<hr class="small">