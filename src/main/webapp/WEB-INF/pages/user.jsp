<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User's JSP Page</title>
    </head>
    <body>

    <h1></h1>
    Hello !
    <a href="${pageContext.request.contextPath}/user/events.html">Home page form user</a><br/></p>
    <a href="${pageContext.request.contextPath}/user/purchases.html">Home page form user</a><br/></p>
    <a href="<c:url value="/j_spring_security_logout" />" >Logout</a> <br/>
</body>
</html>
