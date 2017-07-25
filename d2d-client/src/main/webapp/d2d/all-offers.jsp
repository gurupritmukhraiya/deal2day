<!DOCTYPE html>
<html lang="en">
  <head>
		 <jsp:include page="./tiles/FaviconTile.jsp" />
	     <jsp:include page="./tiles/import.jsp" />
	     <jsp:include page="./tiles/seo.jsp"/> 
	     <link href="http://mistic100.github.io/jQCloud/assets/css/style.css" rel="stylesheet">
  		 <link rel="stylesheet" href="http://mistic100.github.io/jQCloud/dist/jqcloud2/dist/jqcloud.min.css">
		 <script src="http://mistic100.github.io/jQCloud/dist/jqcloud2/dist/jqcloud.min.js"></script>
  </head>
  <body>	
  		<%-- <jsp:include page="./tiles/view-offer.jsp" /> --%>
		<jsp:include page="./tiles/header.jsp" />
		<jsp:include page="./tiles/filtered-offers-tile.jsp" />
		<jsp:include page="./tiles/footer.jsp" />
		<jsp:include page="./tiles/send-coupon-model.jsp"/>  		
  </body>
</html>
