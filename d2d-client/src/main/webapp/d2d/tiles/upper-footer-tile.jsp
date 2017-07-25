<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="row home-intro text-center">
	 <div class="col-lg-12">
				<h2 class="tagline">TOP SEARCH</h2>
				<hr class="small">
				<div class="row">
				    <div class="container bs-docs-container">
		              <div class="bs-example">
		               	<div id="demo-link" class="demo">
				      </div>
		      			<jsp:include page="cloud-word.jsp" />
					  </div>
				</div>   
			</div>						
	 </div>
</div>