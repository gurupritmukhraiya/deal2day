<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:if test="${not empty model.offlineOffers}">
	<c:forEach var="offer" items="${model.offlineOffers}">
		<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">			
       		<div style="padding: 5px; position: relative; border: 1px solid rgb(221, 221, 221); box-shadow: 0px 0px 21px -2px rgb(125, 125, 125); margin-bottom: 10px;">
				<div style="overflow: hidden; width: 100%; position: relative; height: 200px;" class="product_image">
             		<img alt="${offer.offerSummary}" src="http://image.deal2day.in/offOffer/26/26925.jpg" class="img-responsive">
					<div style="background: none repeat scroll 0px 0px rgba(0, 0, 0, 0.5); bottom: 0px; color: rgb(255, 255, 255); position: absolute; padding: 5px; font-size: 12px;" class="col-md-12">
						<h4>${offer.merchantName}</h4>
						<p>
							<c:if test="${fn:length(offer.offerSummary) gt 50}">
								${fn:substring(offer.offerSummary, 0, 50)} ...
							</c:if>
							<c:if test="${fn:length(offer.offerSummary) le 50}">
								${offer.offerSummary}
 							</c:if>
 						</p>
	                   	<div class="clear"></div>
             		</div>
      			</div>			
				<div class="col-md-12" style="background: none repeat scroll 0% 0% rgb(243, 243, 243);font-weight:bold;text-transform:uppercase;color:#888;padding:3px;">
  					<div class="col-md-4">Free</div>
  					<div class="col-md-8" style="text-align:right;">${offer.endDate}</div>
				</div>
				<div class="btn btn-primary" style=" width: 100%;" onclick="window.open('http://affiliate.flipkart.com/install-app?affid=gurupritm')">VIEW DEAL</div>
           	</div>
       	</div>
   	</c:forEach>
</c:if>				   