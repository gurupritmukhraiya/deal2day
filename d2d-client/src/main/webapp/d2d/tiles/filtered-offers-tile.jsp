<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="container">
	<c:if test="${not empty model.offers}">
		<div class="row home-intro text-center" id="offline">
			<div class="col-lg-12">
				<h2 class="tagline">Filtered Offer</h2>
				<hr class="small">
			</div>
		</div>
		<div class="row text-center">
			<c:forEach var="offer" items="${model.offers}">
				<c:set var="offer" value="${offer}" scope="request"/>
				<jsp:include page="offer-tile-1.jsp"/>				
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${not empty model.CLOUD}">
		<div class="row home-intro text-center" id="offline">
			<div class="col-lg-12">
				<h2 class="tagline">OFFERS</h2>
				<hr class="small">
			</div>
		</div>
		<div class="row text-center">
			<c:forEach var="offer" items="${model.CLOUD}">
				<c:set var="offer" value="${offer}" scope="request"/>
				<jsp:include page="offer-tile-1.jsp"/>				
			</c:forEach>
		</div>
	</c:if>
	
	<c:if test="${empty model.offers && empty model.CLOUD}">
		<div style="background-image: url('../images/no-offer-found.jpg'); padding:9%;">
			 <p style="color: #fff;font-size: 40px;padding: 3%;font-family: 'Open Sans', sans-serif;">Sorry!! No Offer(s) available for this category. &#33;</p>
		</div>
	</c:if>
	
	<hr class="small">
