
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
        <link href="./resources/css/style.css" type="text/css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
<script src="./resources/js/user.js"></script>
    <body>
        <div class="container">
          <h2 class="text-primary">User accounts:</h2>
          <hr>
          <form role="form" class="form-horizontal" id="parent">
          </form>
          <hr>
          <button class="btn btn-warning" id="logout" onclick="logoutOnClick()">Log out</button>
      </div>
    </body>  
</html>
