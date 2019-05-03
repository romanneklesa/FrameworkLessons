<sec:authorize url="/admin">
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              type="text/css" rel="stylesheet" crossorigin="anonymous">
        <link href="./resources/css/admin.css" type="text/css" rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css" type="text/css"
              rel="stylesheet"/>
        <link href="https://cdn.datatables.net/1.10.19/css/dataTables.material.min.css" type="text/css"
              rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                crossorigin="anonymous"></script>

    </head>
    <script src="./resources/js/admin.js"></script>
    <body>
    <div>
        <h2 class="text-primary">All users:</h2>
        <div class="container" align="center">
            <hr>
            <table id="tableUsers" class="mdl-data-table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Ammount</th>
                    <th>Role</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

            <hr>
            <button class="btn btn-warning" id="addUser" onclick="addUserOnClick()">New user</button>
            <a class="btn btn-warning" id="logout" href="<c:url value="/logout" />" role="button">Log out</a>
        </div>
    </div>
    </body>
    </html>

</sec:authorize>