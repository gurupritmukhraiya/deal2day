<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
	<div class="women_main" style="margin-top:5%;">
    	<jsp:include page="./SideBar.jsp" /> 
		<div class="col-md-12 w_content">
      		<c:if test="${not empty model.offlineOffers}">
				<div class="women" style="background:#fff;opacity:.9;padding-top:10px;padding-left:10px;">
					<h4><span>${fn:length(model.offlineOffers)}</span> - offer(s) available for selected category</h4>
                    <div class="clearfix"></div>
				</div>		
				<jsp:include page="./OfflineOfferGridTile.jsp" />
			</c:if>
			<c:if test="${empty model.offlineOffers}">
            	<div class="women" style="background-image: url('../images/no-offer-found.jpg'); padding:9%;">
					 <p style="color: #fff;font-size: 40px;padding: 3%;font-family: 'Open Sans', sans-serif;">Sorry!! No Offer(s) available for this category. &#33;</p>
				</div>
         	</c:if>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>	
	</div>
</div>