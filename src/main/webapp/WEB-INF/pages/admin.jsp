<sec:authorize url="/admin">
  <%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ADMIN</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="./resources/css/style.css" type="text/css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>

  </head>
  <script src="./resources/js/admin.js"></script>
  <body>
  <div class="container">
    <h2 class="text-primary">Users:</h2>
    <hr>
    <div>
        <table id="tableUsers" class="table table-striped table-bordered" style="width:100%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody id="listUsers">
            </tbody>
        </table>
    </div>
    <hr>
    <button class="btn btn-warning" id="logout" onclick="logoutOnClick()">Log out</button>
  </div>
  </body>
  </html>

</sec:authorize>