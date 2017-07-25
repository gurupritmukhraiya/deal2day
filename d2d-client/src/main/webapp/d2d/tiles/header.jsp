<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="reqURL" value="${pageContext.request.requestURL}" />
<%@page import="com.d2d.service.CategoryService" %>
<%@page import="com.d2d.cache.CategoryCache" %>
<%@page import="com.d2d.service.common.beans.Category"%>
<%@page import="java.util.*"%>
<%CategoryCache categoryCache = CategoryCache.getInstanse();%>
<%CategoryService categoryService = CategoryService.getInstanse();%>

<c:set var="couponTypes" value='<%=categoryCache.getCategoryByType("COUPON TYPE") %>' />
	<div class="header">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <!-- <a class="navbar-brand" href="http://deal2day.in"><i class="fa fa-magic" style="color:#BFFF00;"></i><b style="background:#BFFF00;color:#fff;">&nbsp;DEAL&nbsp;</b><b style="color:#BFFF00;">2DAY.IN</b></a><p style="color:#fff;margin-left:20px;">my city, my offer</p> -->
			  <a class="navbar-brand" href="http://deal2day.in"><img src="${context }/d2d/img/logo.png" alt="deal2day.in my city, my offer" class="img-responsive" style="height:45px;" /></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<c:if test="${fn:containsIgnoreCase(reqURL, 'map') == false}">
				  <ul class="nav navbar-nav">
					<li class="dropdown">
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">COUPON TYPE<span class="caret"></span></a>
					  <ul class="dropdown-menu text-uppercase" >
					  	<c:if test="${not empty couponTypes}">
							<c:forEach var="couponType" items="${couponTypes}">
								<li class="dropdown-header">${couponType.name }</li>
								<li><a href="${context}/offer/getFilteredOffer.htm?category=${couponType.idx}">All</a></li>
								<c:if test="${not empty couponType.children}">
									<c:forEach var="childId" items="${couponType.children}">
										<c:set var="childIdx" value="${childId}" />
										<c:set var="childName" value='<%=categoryService.getCategoryById(Integer.parseInt(pageContext.getAttribute("childIdx").toString())).getName() %>' />
										<li><a href="${context}/offer/getFilteredOffer.htm?category=${childId }">${childName }</a></li>
									</c:forEach>
								</c:if>
								<li role="separator" class="divider"></li>													
					  		</c:forEach>
				  		</c:if>						
					  </ul>
					</li>
					<%-- <li class="dropdown">
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">TOP MERCHANTS<span class="caret"></span></a>
					  <ul class="dropdown-menu">
						<li class="dropdown-header">ONLINE OFFERS</li>
						<li><a href="#">FLIPKART</a></li>
						<li><a href="#">PAYTM</a></li>
						<li><a href="#">MYNTRA</a></li>
						
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">OFFLINE OFFERS</li>
						<li><a href="#">REGALIA</a></li>
						<li><a href="#">SHIV SAGAR</a></li>
					  </ul>
					</li> --%>
				  </ul>
				 </c:if>
		  	<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				  	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">SELECT CITY<span class="caret"></span></a>
			  		<ul class="dropdown-menu">
						<li class="dropdown-header"><a href="${context}/offer/getFilteredOffer.htm?city=MUMBAI">MUMBAI</a></li>
						<li role="separator" class="divider"></li>							
						<li class="dropdown-header"><a href="${context}/offer/getFilteredOffer.htm?city=PUNE">PUNE</a></li>
						<li role="separator" class="divider"></li>							
						<li class="dropdown-header"><a href="${context}/offer/getFilteredOffer.htm?city=INDORE">INDORE</a></li>
						<li role="separator" class="divider"></li>							
			  		</ul>
				</li>
				<c:choose>
				    <c:when test="${fn:containsIgnoreCase(reqURL, 'map')}">
				        <li><a href="${context}/offer/Home.htm" class="text-muted"><i class="fa fa-desktop" data-toggle="tooltip" data-placement="bottom" title="STANDARD-VIEW"></i></a></li>
						<li class="active"><a href="${context}/d2d/map-view.jsp" class="text-muted"><i class="fa fa-map-marker" data-toggle="tooltip" data-placement="bottom" title="MAP-VIEW"></i></a></li>
				    </c:when>
				    <c:otherwise>
				        <li class="active"><a href="${context}/offer/Home.htm" class="text-muted"><i class="fa fa-desktop" data-toggle="tooltip" data-placement="bottom" title="STANDARD-VIEW"></i></a></li>
						<li><a href="${context}/d2d/map-view.jsp" class="text-muted"><i class="fa fa-map-marker" data-toggle="tooltip" data-placement="bottom" title="MAP-VIEW"></i></a></li>
				    </c:otherwise>
				</c:choose>
				
			</ul>
				<%-- <div class="col-sm-4 col-md-4 right">
					<form class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search..." name="srch-term" id="srch-term">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
							</div>
						</div>
					</form>
				</div>--%>
			</div>
		  </div>
		</nav>
	</div>