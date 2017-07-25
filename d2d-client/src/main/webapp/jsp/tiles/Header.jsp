<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<%@page import="com.d2d.service.CategoryService" %>
<%@page import="com.d2d.service.common.beans.Category"%>
<%@page import="java.util.*"%>
         
<%CategoryService categoryService = CategoryService.getInstanse();%>
<c:set var="categories" value="<%=categoryService.getAllCategory() %>" />

<div style="position:fixed;width:100%;z-index:1000;">
<div class="row" style="padding:0 3%;background: rgba(3, 3, 3, 0.8);margin:0;">
	<div class="header_top row">
		<div class="col-md-2 top_left" style="margin:5px 0 0 0">
			<h2><b><a href="${context}">DEAL2DAY.IN</a></b></h2>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
		    <div class="col-md-6" style="text-transform: uppercase;">
				<ul class="nav nav-pills">
					<c:if test="${not empty couponTypes}">
						<c:forEach var="couponType" items="${couponTypes}">
							<li class="active" style="background:none;padding:0 1%;"><a style="color:#fff;font-weight:bold;background:none; padding: 3%;" href="${context}/offer/getFilteredOffer.htm?category=${couponType.idx}">${couponType.name }</a></li>
						</c:forEach>
			  		</c:if>	
			    </ul>
            </div>
       	</c:if>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<div class="top_right">
				<ul>	
					<li class="login" >						
						<sec:authorize access="hasRole('MERCHANT_ROLE')">
							<div id="loginContainer"><a href="#" id="loginButton"><span>${pageContext.request.userPrincipal.name} &#9660;</span></a>
								<div id="loginBox">										
									<a href="${context}/mer/login.htm" class="btn btn-primary" style="padding:10px;">My Profile</a>  
									<c:url value="/j_spring_security_logout" var="logoutUrl" />
									<form action="${logoutUrl}" method="post" id="loginForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										<fieldset id="body">  
											<input type="submit" id="login" value="Logout" />
										</fieldset>
									</form>										
								</div>
							</div>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN_ROLE')">
							<div id="loginContainer"><a href="#" id="loginButton"><span>${pageContext.request.userPrincipal.name} &#9660;</span></a>
								<div id="loginBox">										
									<a href="${context}/admin/login.htm" class="btn btn-primary" style="padding:10px;">My Profile</a>  
									<c:url value="/j_spring_security_logout" var="logoutUrl" />
									<form action="${logoutUrl}" method="post" id="loginForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										<fieldset id="body">  
											<input type="submit" id="login" value="Logout" />
										</fieldset>
									</form>										
								</div>
							</div>
						</sec:authorize>					
					</li>		
				</ul>
			</div> 
		</c:if>
		<div class="clearfix"> </div>
	</div>
</div>
</div>