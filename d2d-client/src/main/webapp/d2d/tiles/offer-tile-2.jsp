<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@page import="com.d2d.constants.ImageConstant" %>
<div class="col-sm-6 col-md-3">
    <div class="thumbnail">
    	<div style="height:130px;overflow:hidden;">
        	<c:if test="${fn:containsIgnoreCase(offer.imageURL, 'true')}">
			    <img src="<%=ImageConstant.MERCHANT_OFFER_IMG_URL %>${offer.merchantId}/${offer.idx}.jpg" alt="${offer.offerSummary}" class="img-responsive">
			</c:if>
			<c:if test="${fn:containsIgnoreCase(offer.imageURL, 'true') == false}">
			    <img src="${offer.imageURL}" alt="${offer.offerSummary}" class="img-responsive">
			</c:if>
        </div>
        <div class="caption">
            <h4 class="pull-right text-info">${offer.couponPrice}</h4>
            <h4 class="text-primary text-uppercase title">${offer.merchantName}</h4>
            <p  class="title">${offer.offerSummary}</p>
        </div>
        <div class="caption">
	       	<p>
				<a href="${context }/offer/viewOfferPage.htm?o_d=${offer.idx}&p_d=${offer.merchantId}" class="btn btn-primary">View It!</a> 
				<button type="button" class="btn btn-warning" data-toggle="modal" data-id="${offer.idx}" data-target="#send-coupon-model">Grap It!</button>							
			</p>
		</div>
    </div>
</div>