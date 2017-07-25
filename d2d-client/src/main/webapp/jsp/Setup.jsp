<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
	<head>
		
	</head>
	<body>
		<form action="${context}/SetupServlet">
			<select name="currEnv">
				<option value="dev">Development Environment</option>
				<option value="prod">Production Environment</option>
			</select>
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html> 