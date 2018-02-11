<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../static/images/favicon.ico">

    <title>Employee Management Portal</title>

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
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">Employee Management</div>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-form">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value='/list' />">List of Employees</a></li>
                <li><form action="<c:url value="/logout"/>" method="post" class="navbar-form">
                    <button type="submit" class="btn btn-default">Logout</button>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form></li>
            </ul>
        </div>
    </div>
</nav>
<body>
<div class="container theme-showcase" role="main">
    <div class="jumbotron">
        <h2>Success</h2>
        <p>${success}</p>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">By Alper Basak</p>
    </div>
</footer>
</body>
<script>
    window.setTimeout(function(){
        window.location.href = "/";
    }, 5000);
</script>
</html>
