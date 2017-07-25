<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.d2d.service.category.CategoryPropertiesUtil"%>
<%@page import="com.d2d.service.category.CategoryBean"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%
    String backURL = request.getHeader("Referer");
	String category = "";
	if(backURL != null){
        String[] categoryArr = backURL.split("\\?");          
        if(categoryArr.length >= 2){
           category = categoryArr[1].split("\\=")[1];
           category = CategoryPropertiesUtil.getInstance().getNameById(category);
        }
	}
%>

<c:set var="offer" value="${model.offer}"/>  
<c:set var="locations" value="${model.locations}"/>  
<style>
.deal-fin-3{
    border-right: 1px solid #E8E8E8;
    color: #666666;
    font-size: 14px;
}

.deal-fin-4{
    border-right: 1px solid #E8E8E8;
    color: #666666;
    font-size: 12px;
}


.deal-fin-4 h4{
    color: #333;
    font-size: 12px;
    text-decoration: underline;
}

.deal-fin-3 h4{
    color: #333;
    font-weight: bold;
    font-size: 14px;
}

.coupon-send-box{
	background: -moz-linear-gradient(center top , #FFFFFF, #F1F5F8) repeat scroll 0 0 transparent;
	border-bottom: 1px solid #D3D3D3;
	border-top: 1px solid #D3D3D3;
	box-shadow: 0 8px 10px -7px #E4E4E4 inset;
	padding: 10px 10px;
}
</style>
<div class="container">
	<div class="women_main main">
		<div class="row">
			<ol class="breadcrumb">
			  	<li><a href="http://deal2day.in">Home</a></li>
			  	<%if(backURL != null && !category.equals("")){%>
			  			<li><a href="<%=backURL%>"><%=category%></a></li>
			  	<%} %>
			  	<li class="active">${offer.merchantName}</li>
			</ol>
		</div>
		
		<div class="row" style="margin-bottom:2%;">
			<div class="col-md-3" style="width:20%;">
			     <img src="http://image.deal2day.in/offOffer/${offer.merchantId}/${offer.coverImage}" class="img-responsive" width="210"/>
			</div>
            <div class="col-md-9" style="width:80%;">
			    <div class="desc1" style="float:none;">
           			<p style="margin:0;font-size:1.4em;text-transform: capitalize;"><b>${offer.merchantName}</b></p>
					<h4><span class="actual">${offer.offerSummary}</span></h4>
					<div class="row" style="text-align:center;margin: 18px 0;">
						<div class="col-md-4 deal-fin-3">
	   						<h4>VALID ON MINIMUM BILL OF</h4>Rs. ${offer.minBillAmt}
						</div>
						<div class="col-md-4 deal-fin-3">
   							<h4>YOU SAVE</h4>${offer.discount} %
        				</div>
        				<div class="col-md-4 deal-fin-3">
           					<h4>COUPON PRICE</h4>FREE
        				</div>
					</div>
					<div id="sent-coupon" class="coupon-send-box">
						<img src="../images/mob.png" style="width:40px"></img>
						<b style="width:30%;font-size:1.6em; float: left;">Redeem Coupon</b>
						<div style="width:auto; float: right;" class="search">
							<form>
								<input type="text" id="mob-no-${offer.idx}" style="width:360px" placeholder="Enter 10 digit mobile no i.e. 9890xxxxxx" value="">
								<div class="create_btn">
									<button type="button" class="btn btn-primary" onclick="sendCoupon('offerId=${offer.idx}&providerName=${offer.merchantName}&endDate=${offer.endDate}&location=multiple',${offer.idx})">Get Coupon</button>
								</div>
							</form>
						</div>
					</div>
				</div>
		   </div>
           <div class="clearfix"></div>
		</div>
        <div class="row">
			<div class="col-md-4" style="height: 300px; overflow: scroll;overflow-x:hidden;">>
				<h4>Address</h4>
				<c:if test="${not empty locations}">
					<c:forEach var="location" items="${locations}">
						<p class="prod-desc">
	              			${offer.merchantName},<br>
						    ${location.address},<br>
							${location.area},${location.city}-${location.pincode}.<br>
							Contact - ${location.contactNo}
						</p>
         			</c:forEach>
				</c:if>
			</div>
			<div class="col-md-4" style="height: 300px; overflow: scroll;overflow-x:hidden;">>
				<h4>Deal Description</h4>
                <c:if test="${not empty offer.description}">
					<c:forEach var="highlight" items="${offer.description}">
                   		<p class="prod-desc"><b>&raquo;</b> ${highlight}</p>					
         			</c:forEach>
			    </c:if>
            </div>
			<div class="col-md-4" style="height: 300px; overflow: scroll;overflow-x:hidden;">>
				<h4>Deal Terms</h4>
               	<c:if test="${not empty offer.termsAndConditions}">
					<c:forEach var="term" items="${offer.termsAndConditions}">
						<p class="prod-desc"><b>&raquo;</b> ${term}</p>
			        </c:forEach>
		    	</c:if>               	
			</div>
            <div class="clearfix"></div>			
		</div>	
		<div class="clearfix"></div>			
	</div>
</div>