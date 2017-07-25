<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.d2d.service.CategoryService" %>
<%@page import="com.d2d.service.common.beans.Category"%>
<%@page import="java.util.*"%>
         
<%--<c:set var="context" value="${pageContext.request.contextPath}" />

<%CategoryService categoryService = CategoryService.getInstanse();%>
<c:set var="categories" value="<%=categoryService.getAllCategory() %>" />
<div class="col-md-3">
	<div style="background:#428bca;margin-bottom:10px;text-align:right;">
		<c:if test="${not empty categories}">
			<c:forEach var="category" items="${categories}">
				<c:if test="${(category.type != 'd2d') && (category.type != 'Subcat')}"> 
				<ul class="nav nav-list">
					<li class="dropdown">
						<a class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" href="${context}/offer/getFilteredOffer.htm?category=${category.idx}"><b>${category.name} </b></a>
						--%><%-- <ul class="dropdown-menu">
							<c:set var="childrenIds" value="${category.children}" />
							<c:if test="${not empty childrenIds}">
								<c:forEach var="childId" items="${childrenIds}">
									<li><a href="${context}/offer/getFilteredOffer.htm?category=${childId}"><%= CategoryService.getInstanse().getCategoryById(Integer.parseInt(pageContext.getAttribute("childId").toString())).getName()%></a></li>
								</c:forEach>
							</c:if>
	    	        	</ul> --%><%--
			    	</li>
        		</ul>
        	</c:if>
		  	</c:forEach>
	  	</c:if>
    	</div>
</div>--%>