<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tsyklop
  Date: 13.07.2018
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
               <link href="<c:url value="/resources/css/signup.css" />" rel="stylesheet">
               <script src="<c:url value="/resources/js/signup.js" />"></script>
    </head>
<body>

        <form method="POST" action="<c:url value="/login"/>">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input name="username" type="text">
            <input name="password" type="password">
            <button type="submit">Login</button>
        </form>

        <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Sign Up</button>
        <%@ include file="../tpl/signup.jsp" %>
    </body>
</html>
