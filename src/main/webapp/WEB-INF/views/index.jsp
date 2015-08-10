<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Translator</title>
	</head>
	<body>
		<h1>Translator</h1>
		<h3><spring:message code="field2" /></h3>
		<a href='<c:url value="/translate?lang=en" />'>English</a><br/>
		<a href='<c:url value="/translate?lang=fr" />'>Fran&ccedil;ais</a><br/>
		<a href='<c:url value="/translate?lang=es" />'>Espa&ntilde;ol</a><br/>
	</body>
</html>