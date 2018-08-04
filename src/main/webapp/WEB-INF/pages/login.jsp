<%--
    Document   : index
    Created on : 10.07.2018, 9:35:37
    Author     : dn091097zia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
        <link href="./resources/css/style.css" type="text/css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="./resources/js/signup.js"></script>
    </head>
    <body>
        <%  String showWrongAuthDescription = "none";
            if(request.getAttribute("WasWrongAuth")== null || request.getAttribute("WasWrongAuth").equals("false")) showWrongAuthDescription = "none";
            else showWrongAuthDescription = "block";
        %>
        <div class="container">
            <div class="header col-lg-10 col-lg-offset-1">
                <div class="col-lg-6 col-lg-offset-3">
                    <div class="col-lg-12 col-lg-offset-3">
                            <img src="./resources/registration.png" class="col-lg-6" alt="Cinque Terre">
                    </div>
                    <c:url value="/j_spring_security_check" var="loginUrl" />
                    <form class="form-horizontal" action="${loginUrl}" method="POST">
                          <div class="form-group">
                            <label for="user">Логин :</label>
                            <input type="text" name="j_username" class="form-control" id="user">
                          </div>
                          <div id="errorLoginDescription">
                          </div>
                          <div class="form-group">
                            <label for="pwd">Пароль :</label>
                            <input type="password" name="j_password" class="form-control" id="pwd">
                          </div>
                          <div id="errorPassDescription">
                          </div>
                          <div class="col-lg-6" id="buttonsForLogin">
                          <button type="submit" class="btn btn-default" id="send_button" disabled="true">Отправить</button>
                          </div>

                           <div class="col-lg-6" id="buttonsForSignup">
                               <button type="button" class="btn btn-default" id="signupButton">Sign up</button>
                            </div>

                          <div class="errorDescription col-lg-12" style="display: <%= showWrongAuthDescription %>; ">
                              <p align="center">Не верная авторизация, повторите вход !</p>
                          </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
            <%@ include file="../tpl/signup.jsp" %>
            <script src="./resources/js/loginValidation.js"></script>
</html>
