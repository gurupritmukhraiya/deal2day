<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="idsMap" value="${model.ids}" />
<div class="container">
	<c:if test="${not empty model}">
		<c:forEach var="model" items="${model}">
			<c:if test="${not empty model.key && fn:containsIgnoreCase(model.key, 'COUPON TYPE') == false}">
				<c:set var="modelKeyArr" value="${fn:split(model.key, '<#id#>')}" />
				<c:if test="${not empty model.value}">
					<div class="row home-intro text-center" id="offline">
						<div class="col-lg-12">
							<h2 class="tagline">${modelKeyArr[0]}</h2>
							<hr class="small">
						</div>
					</div>
					<div class="row text-center">
						<c:forEach var="offer" items="${model.value}">
							<c:set var="offer" value="${offer}" scope="request"/>	
							<jsp:include page="offer-tile-1.jsp" />
						</c:forEach>
					</div>
					<div class="text-center btn-home">
						<a href="${context}/offer/getFilteredOffer.htm?category=${modelKeyArr[1]}" class="btn btn-info">VIEW MORE</a>
					</div>
					<hr class="small">
				</c:if>
			</c:if>
		</c:forEach>
	</c:if>
