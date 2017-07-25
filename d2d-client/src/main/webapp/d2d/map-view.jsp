<!DOCTYPE html>
<html>
	 <head>
 	 	 <jsp:include page="./tiles/FaviconTile.jsp" />
 	 	 <jsp:include page="./tiles/seo.jsp"/> 
 	 	 <jsp:include page="./tiles/import.jsp" />
		 <style>
			html, body {
				height: 100%;
				margin: 0;
				padding: 0;
				overflow: hidden;
			}
			.navbar {
				margin-bottom: 0px;
			}
			#map {
				position:absolute; top:0px; bottom:0; margin:0;  padding: 0;
			}
			#offer-ls {
				position:absolute; bottom:0; overflow-x: hidden; overflow-y: auto; right: 0;background:#fafafa;margin:0;  padding: 0;top: 60px;    z-index: 2;
			}	
		</style> 
	</head>
	<body>	
		<jsp:include page="./tiles/header.jsp" />
		<jsp:include page="./tiles/map-view-tile.jsp" />
		<jsp:include page="./tiles/map-footer.jsp" />
		<jsp:include page="./tiles/send-coupon-model.jsp"/>	
  </body>
</html>

