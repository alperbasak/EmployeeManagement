<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Login Page</title>
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Spring Security Custom Login Form (XML)</h1>

<div id="login-box">

    <h2>Login with Username and Password</h2>

    <c:if test="${param.error != null}">
        <p style='color:red'>
            Invalid username or password.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p style='color:blue'>
            You have been logged out.
        </p>
    </c:if>

    <form name='loginForm'
          action="<c:url value="/login"/>" method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><label>
                    <input type='text' name='username' value=''>
                </label></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><label>
                    <input type='password' name='password'/>
                </label></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="reset" type="reset" />
                </td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>
</div>

</body>
</html>