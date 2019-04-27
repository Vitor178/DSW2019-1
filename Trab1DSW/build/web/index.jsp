<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang='eng' dir='ltr'>
<head>
	<meta charset="utf-8"http-equiv="Content-Type" content="text/html;" >
	<title>Login Form</title>
	<link rel="styleSheet" type="text/css" href="css/style.css" media="screen" >
</head>
<body>
    <fmt:bundle basename="i18n.Messages">
	<form class="box" action="index.jsp" method="post">
		<h1>Login</h1>
			<input type="text" placeholder="<fmt:message key="Username"/>">
			<input type="password" placeholder="<fmt:message key="Password"/>">
			<input type="submit" value="<fmt:message key="Login"/>">
                        <a href="/site" ><fmt:message key="Sites"/></a>
                        <a href="/teatro" ><fmt:message key="Theaters"/></a>
                        <a href="/promocao" ><fmt:message key="promotions"/></a>
		</form>
    </fmt:bundle>
</body>
</html>
