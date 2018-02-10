<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<h1>You do not have permission to access this page!
</h1>
<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
    <input type="submit" value="Logout">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
</body>
</html>