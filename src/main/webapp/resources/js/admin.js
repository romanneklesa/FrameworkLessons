$(document).ready(function () {
    tableUsers = $('#tableUsers').DataTable();
    getUsers();
});

function getUsers() {
    $.get("/getusers", function (data) {
        var count = 0;
        data.forEach(function (item, i, arr) {
            var html = "";
            var htmlRole = "";
            var htmlDeleteButton = "";
            html += "<div id = 'amountBlock" + item.id + "'>" +
                "<div>" +
                "<select class = 'target amountSelects' id = 'selectAmountUser" + item.id +
                "' onmouseover = 'getAmount(" + item.id + ")'>" +
                "<option>Select...</option>" +
                "</select> </div> </div>";
            htmlRole += "<div id = 'role" + item.id + "' onclick='onClickChangeRole(" + item.id + ")'>" +
                item.role + "</div>";
            htmlDeleteButton = "<button type='button' class='btn btn-light' onclick='deleteUser(" +
                item.id + ")'>Delete</button>"
            tableUsers.row.add([item.id, item.name, html, htmlRole, htmlDeleteButton]);
        });
        tableUsers.draw();
    }).done(attachChangeAccountEvent());
}

function addUserOnClick() {
    var html = $("tbody").html();
    var htmlRole = "<div id = 'roleNewUser' onclick='onClickChangeRoleNewUser()'>USER</div>";
    html += "<tr id = 'trNewUser' role='row' class='even'><td>...</td>" + // id
        "<td><input type='text' id='newUserNameInput'</td>" +             // new user name
        "<td style='text-align: center'>0, 0, 0</td>" +                   // accounts
        "<td>" + htmlRole + "</td>" +                                     // role
        "<td><button type='button' class='btn btn-light' onclick='saveNewUser()'>Save</button></td></tr>";
    $("tbody").html(html);
}

function saveNewUser() {
    var userName = $("#newUserNameInput").val();
    var role = $("#roleNewUser").html();
    $("#trNewUser").remove();
    tableUsers.clear();
    $.post("/adduser", {user_name: userName, role_name: role})
        .done(getUsers());
}

function onClickChangeRoleNewUser() {
    var curRole = $("#roleNewUser").html();
    if (curRole === "USER") curRole = "ADMIN";
    else curRole = "USER";
    $("#roleNewUser").html(curRole);
}

function deleteUser(userId) {
    tableUsers.rows(function (idx, data, node) {
        return data[0] === userId;
    }).remove().draw();
    $.post("/deleteuser", {user_id: userId});
}

function onClickChangeRole(userId) {
    var curRole = $("#role" + userId).html();
    if (curRole === "USER") curRole = "ADMIN";
    else curRole = "USER";
    $("#role" + userId).html(curRole);
    $.post("/updateuserrole", {user_id: userId, role_name: "ADMIN"});
}

function attachChangeAccountEvent() {
    $(document).on("change", ".target", function (event) {
        var selectedOption = $("#" + event.target.id + " option:selected").html();
        var amount = selectedOption.substring(selectedOption.indexOf(":") + 2, selectedOption.length)
        var userId = event.target.id.substring(16, event.target.id.length);
        addEditAmountBlock(userId, amount);
    });
}

function getAmount(userId) {
    var selectId = '#selectAmountUser' + userId;
    if ($(selectId).children('option').length === 1) {
        $.get("/accounts", {id: userId}, function (accountsData, status) {
            //$(selectId).append($("<option>Select...</option>"));
            accountsData.forEach(function (accountItem, i, arr) {
                $(selectId).append($("<option></option>")
                    .attr('value', accountItem.id)
                    .text("Account " + accountItem.id + ": " + accountItem.amount));
                $(selectId).addClass('amountSelects');
            });
        });
    }
}

function addEditAmountBlock(userId, amount) {
    if (!$('input').is("#amountInput" + userId)) {
        $('#amountBlock' + userId).append("<input type='number' class='editAmountInputs' id='amountInput" + userId +
            "' value='" + amount + "'>" +
            "<button id='buttonSaveAmount" + userId + "' type='button' " +
            "onclick='onClickSaveAmount(" + userId + ")'>Ok</button>");
    }
}

function onClickSaveAmount(userId) {
    var curAccount = $("#selectAmountUser" + userId + " option:selected").val();
    var amount = $("#amountInput" + userId).val();
    var html = "<div>" +
        "<select class = 'target' id = 'selectAmountUser" + userId +
        "' onmouseover = 'getAmount(" + userId + ")'>" +
        "<option>Select...</option>" +
        "</select>" +
        "</div>";
    $.post("/updateaccount", {account_id: curAccount, amount: amount})
        .done(function () {
            $("#amountBlock" + userId).html(html);
            getAmount(userId);
        });
}