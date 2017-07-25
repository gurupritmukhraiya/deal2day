<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@page import="com.d2d.constants.ImageConstant" %>
<div class="col-md-3 col-sm-6 hero-feature">
	<div class="thumbnail">
		<div style="height:150px;overflow:hidden;">
			<c:if test="${fn:containsIgnoreCase(offer.imageURL, 'true')}">
			    <img src="<%=ImageConstant.MERCHANT_OFFER_IMG_URL %>${offer.merchantId}/${offer.idx}.jpg" alt="${offer.offerSummary}" class="img-responsive">
			</c:if>
			<c:if test="${fn:containsIgnoreCase(offer.imageURL, 'true') == false}">
			    <img src="${offer.imageURL}" alt="${offer.offerSummary}" class="img-responsive">
			</c:if>
		</div>
		<div class="caption">
			<h3 class="text-primary text-uppercase title">${offer.merchantName}</h3>
			<p class="title">${offer.offerSummary}</p>
			<p>
				<a href="${context }/offer/viewOfferPage.htm?o_d=${offer.idx}&p_d=${offer.merchantId}" class="btn btn-primary">Show More</a>
				<button type="button" class="btn btn-warning" data-toggle="modal" data-oid="${offer.idx}" data-code="${offer.promoCode}" data-pid="${offer.merchantId}" data-target="#send-coupon-model">Send Offer</button>								
			</p>
		</div>
	</div>
</div>