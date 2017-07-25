<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="./tiles/FaviconTile.jsp" />
	<style>
		body{
			text-align: center;
		}
		.tile{
		 	background-color: #FF0097;
   			text-align: center;
   			padding: 30px;
   			float:left;
		}
		.tile-content{
			color: #FFFFFF;
		    font-size: 48px;  
		    padding: 30px;		   
		    font-weight: bold;
		}
		#Content {
			width:500px;
			margin:0px auto; 			
		}
	</style>
</head>
<body>
	<div id="Content">
		<div class="tile"><div class="tile-content">5</div></div>
		<div class="tile" style="background-color: #F09609;"><div class="tile-content">0</div></div>
		<div class="tile" style="background-color: #8CBF26;"><div class="tile-content">0</div></div>
	</div> 
</body>
</html>