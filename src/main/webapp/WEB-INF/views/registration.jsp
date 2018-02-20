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
    <link href="../static/css/dashboard.min.css" rel="stylesheet">
    <link href="../static/css/sticky-footer.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../static/css/jquery-ui.min.css">

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
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header" style="display: inline-block">Registration Form</h2>
            <div class="table-responsive">
                <form:form method="POST" modelAttribute="employee">
                <form:input type="hidden" path="id" id="id"/>
                <table class="table table-condensed" style="table-layout: fixed">

                    <tr>
                        <td><label for="firstName" style="width: 15%;text-align: right">First Name: </label>
                            <form:input path="firstName" id="firstName"/>
                            <form:errors path="firstName" cssStyle="color: red"/></td>
                    </tr>

                    <tr>
                        <td><label for="lastName" style="width: 15%;text-align: right">Last Name: </label>
                            <form:input path="lastName" id="lastName"/>
                         <form:errors path="lastName" cssStyle="color: red"/></td>
                    </tr>

                    <tr>
                        <td><label for="email" style="width: 15%;text-align: right">Email: </label>
                            <form:input path="email" id="email"/>
                          <form:errors path="email" cssStyle="color: red"/></td>
                    </tr>

                    <tr>
                        <td><label for="phoneNumber" style="width: 15%;text-align: right">Phone Number: </label>
                            <form:input path="phoneNumber" id="phoneNumber"/>
                          <form:errors path="phoneNumber" cssStyle="color: red;"/></td>
                    </tr>

                    <tr>
                        <td><label for="joiningDate" style="width: 15%;text-align: right">Joining Date: </label>
                        <form:input path="joiningDate" id="joiningDate"/>
                        <form:errors path="joiningDate" cssStyle="color: red"/></td>
                    </tr>

                    <tr>
                        <td><label for="salary" style="width: 15%;text-align: right">Salary: </label>
                        <form:input path="salary" id="salary"/>
                          <form:errors path="salary" cssStyle="color: red"/></td>
                    </tr>

                    <tr>
                        <td><label for="commissionPrc" style="width: 15%;text-align: right">% Commission: </label>
                        <form:input path="commissionPrc" id="commissionPrc"/>
                        <form:errors path="commissionPrc" cssStyle="color: red"/></td>
                    </tr>
                </table>
                    <br/>
                        <c:choose>
                        <c:when test="${edit}">
                            <button type="submit" class="btn btn-success" value="Update">Update</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-success" value="Register">Register</button>
                        </c:otherwise>
                    </c:choose>
                </form:form>
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
<script src="../static/js/jquery-ui.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
<script>
    $( function() {
        $( "#joiningDate" ).datepicker({
            showOn: "button",
            dateFormat: "dd/mm/yy",
            buttonImage: "../static/images/calendar.gif",
            buttonImageOnly: true,
            buttonText: "Select date",
            changeMonth: true,
            changeYear: true
        });
    } );
</script>
</body>
</html>