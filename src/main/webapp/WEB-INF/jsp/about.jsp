<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<spring:url value="/resources/static/css/main.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<h1>1. Test CSS</h1>

<h2>2. Test JS</h2>
<div id="msg"></div>

</body>
</html>