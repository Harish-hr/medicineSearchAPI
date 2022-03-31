<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Drugs</title>
</head>
<body>    
	<h3 style="color: red;">Show All Drugs</h3>
	<ul>
		<c:forEach var="listValue" items="${drugs}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>
</body>
</html>