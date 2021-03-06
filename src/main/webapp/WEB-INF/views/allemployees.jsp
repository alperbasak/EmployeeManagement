<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../static/images/favicon.ico">

    <title>Employee Management</title>

    <!-- Bootstrap core CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../static/css/dashboard.min.css" rel="stylesheet">
    <link href="../static/css/sticky-footer.min.css" rel="stylesheet">

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
        <div id="navbar" class="navbar-collapse collapse navbar-form">
            <ul class="nav navbar-nav navbar-right">
                <li><a style="display: inline-block" href="<c:url value='/new' />"><img src="../static/images/addnew.png"></a></li>
                <li><a style="display: inline-block" href="<c:url value='/list' />"><img src="../static/images/whitelist.png" ></a></li>
                <li><form action="<c:url value="/logout"/>" method="post" class="navbar-form">
                    <button type="submit" class="btn btn-default">Logout</button>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-1 main">
            <h2 class="sub-header">Employees</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Joining Date</th>
                        <th>Salary</th>
                        <th>% Commission</th>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:useBean id="employees" scope="request" type="java.util.List"/>
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td><a href="<c:url value='/edit-${employee.id}-employee' />">${employee.id}</a></td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.email}</td>
                            <td>${employee.phoneNumber}</td>
                            <td>${employee.joiningDate}</td>
                            <td>${employee.salary}</td>
                            <td>${employee.commissionPrc}</td>
                            <td><a href="<c:url value='/delete-${employee.id}-employee' />">
                                    <button type="button" class="btn btn-danger btn-sm">Delete</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">By Alper Basak</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>
