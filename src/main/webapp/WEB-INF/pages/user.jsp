<%-- 
    Document   : user
    Created on : 22.07.2018, 17:08:00
    Author     : papus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= request.getAttribute("userName") %>!</h1>
    </body>
</html>
