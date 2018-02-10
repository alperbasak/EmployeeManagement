<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../static/images/favicon.ico">

    <title>Employee Registration</title>

    <!-- Bootstrap core CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../static/css/dashboard.css" rel="stylesheet">
    <link href="../static/css/sticky-footer.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">Employee Management</div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <form action="<c:url value="/logout"/>" method="post" class="navbar-form navbar-right">
                <button type="submit" class="btn btn-default">Logout</button>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
        </div>
    </div>
</nav>
<h2>Registration Form</h2>

<div class="col-md-6">
<form:form method="POST" modelAttribute="employee">
    <form:input type="hidden" path="id" id="id"/>
    <table class="table table-bordered">
        <tr>
            <td><label for="name">Name: </label> </td>
            <td><form:input path="name" id="name"/></td>
            <td><form:errors path="name" /></td>
        </tr>

        <tr>
            <td><label for="joiningDate">Joining Date: </label> </td>
            <td><form:input path="joiningDate" id="joiningDate"/></td>
            <td><form:errors path="joiningDate" /></td>
        </tr>

        <tr>
            <td><label for="salary">Salary: </label> </td>
            <td><form:input path="salary" id="salary"/></td>
            <td><form:errors path="salary" /></td>
        </tr>

        <tr>
            <td><label for="ssn">SSN: </label> </td>
            <td><form:input path="ssn" id="ssn"/></td>
            <td><form:errors path="ssn"/></td>
        </tr>
    </table>
    <br/>
    <c:choose>
        <c:when test="${edit}">
            <input type="submit" value="Update"/>
        </c:when>
        <c:otherwise>
            <input type="submit" value="Register"/>
        </c:otherwise>
    </c:choose>
</form:form>
</div>

<br/>
<a href="<c:url value='/list' />"><button type="button" class="btn btn-info">List of All Employees</button></a>

<footer class="footer">
    <div class="container">
        <p class="text-muted">By Alper Basak</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>