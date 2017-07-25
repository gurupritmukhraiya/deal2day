<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	 <head>
	     <jsp:include page="./tiles/import.jsp" />
	     <jsp:include page="./tiles/seo.jsp"/> 
	 </head>
  <body>	
  		<%-- <jsp:include page="./tiles/view-offer.jsp" /> --%>
  		<jsp:include page="./tiles/header.jsp" />
		<jsp:include page="./tiles/500tile.jsp"/>
		<jsp:include page="./tiles/footer.jsp" />
		<jsp:include page="./tiles/send-coupon-model.jsp"/> 		
  </body>
</html>
