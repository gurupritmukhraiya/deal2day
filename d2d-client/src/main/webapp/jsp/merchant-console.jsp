<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>Merchant Console</title>
	<script type='text/javascript' src="${context}/js/jquery-1.11.1.min.js"></script>
	
	<link href="${context}/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="${context}/css/style_old.css" rel='stylesheet' type='text/css' />
	<link href="${context}/css/jquery-ui.css" rel='stylesheet' type='text/css' />
	
	<script src="${context}/js/jquery-ui.min.js"></script>
	<script src="${context}/js/bootstrap.min.js"></script>
	<script src="${context}/js/jquery.validate.min.js"></script>
	<script src="${context}/js/menu_jquery.js"></script>
	<script src="${context}/js/jquery.form.js"></script>
	
	<script src="${context}/js/main.js"></script>
	<script src="../js/mer-console.js"></script>

</head>
	<body>
		<jsp:include page="./tiles/Header.jsp" />
		<jsp:include page="./tiles/mer-console-tab.jsp" />
		<jsp:include page="./tiles/Footer.jsp" /> 
	</body>
</html> 