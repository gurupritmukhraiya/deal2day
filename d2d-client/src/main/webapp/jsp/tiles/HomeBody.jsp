<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="container">
	<div class="women_main">
      	<div class="col-md-12">
      		<jsp:include page="./Slider.jsp" />
  			<div class="row" style="color: rgb(51, 51, 51); border: 1px solid rgb(204, 204, 204); box-shadow: 0 -8px 7px -4px rgb(128, 128, 128); padding: 10px 30px;margin-top:20px;">
                 <a id="offline-offer-type" href="#" style="font-weight:bold;color:#333; background:none;">OFFLINE DEALS</a><a href="" class="text-primary" style="float:right;">VIEW ALL</a>
            </div>
            <div class="row" style="margin:0;">
   			   <jsp:include page="./OfflineOfferGridTile.jsp" />
	        </div>
		    
            <div class="row" style="color: rgb(51, 51, 51); border: 1px solid rgb(204, 204, 204); box-shadow: 0 -8px 7px -4px rgb(128, 128, 128); padding: 10px 30px;margin-top:20px;">
                  <a id="offline-offer-type" href="#" style="font-weight:bold;color:#333; background:none;">ONLINE OFFERS</a><a href="" class="text-primary" style="float:right;">VIEW ALL</a>
            </div>
            <div class="row">
  			   <jsp:include page="./OnlineCouponGridTile.jsp" />
	        </div>
            
            <div class="row" style="color: rgb(51, 51, 51); border: 1px solid rgb(204, 204, 204);box-shadow: 0 -8px 7px -4px rgb(128, 128, 128); padding: 10px 30px;margin-top:20px;">
                  <a id="offline-offer-type" href="#" style="font-weight:bold;color:#333; background:none;">PROMO CODES</a><a href="" class="text-primary" style="float:right;">VIEW ALL</a>
            </div>
            <div class="row">
  			   <jsp:include page="./PromoCodeDealTile.jsp" />
	        </div>
            
            <div class="row" style="color: rgb(51, 51, 51); border: 1px solid rgb(204, 204, 204); box-shadow: 0 -8px 7px -4px rgb(128, 128, 128); padding: 10px 30px;margin-top:20px;">
                  <a id="offline-offer-type" href="#" style="font-weight:bold;color:#333; background:none;">WALKIN DEALS</a><a href="" class="text-primary" style="float:right;">VIEW ALL</a>
            </div>
            <div class="row">
  			   <jsp:include page="./WalkInDealsTile.jsp" />
	        </div>
		</div>
		<div class="clearfix"></div>		
	</div>
</div>