$(document).ready(function () {
    var tableUsers = $('#tableUsers').DataTable();
    $.get("/getusers", function (data) {
        var count = 0;
        data.forEach(function (item, i, arr) {
            var html = "";
            var htmlRole = "";
            html += "<div id = 'amountBlock" + item.id + "'>" +
                "<select class = 'target' id = 'selectAmountUser" + item.id +
                "' onmouseover = 'getAmount(" + item.id + ")'" +
                "</select> </div>";
            /*htmlRole += "<select>";
            item.roles.forEach(function (itemRole, i, arr) {
                if (itemRole.role_id === 1) {
                    htmlRole += "<option value='admin'>Admin</option>";
                    htmlRole += "<option value='user'>User</option>";
                }
                else {
                    htmlRole += "<option value='user'>User</option>";
                    htmlRole += "<option value='admin'>Admin</option>";
                }
            });
            htmlRole += "</select>";*/
            tableUsers.row.add([item.id, item.name, html, item.role]);
        });
        tableUsers.draw();
    }).done(attachChangeAccountEvent());
});

function attachChangeAccountEvent() {
    $(document).on("change", ".target", function (event) {
        var selectedOption = $("#" + event.target.id + " option:selected").html();
        var amount = selectedOption.substring(selectedOption.indexOf(":") + 2, selectedOption.length)
        var userId = event.target.id.substring(16, event.target.id.length);
        addEditAmountBlock(userId, amount);
    });
}

function getAmount(userId) {
    if ($('#selectAmountUser' + userId).children('option').length === 0) {
        $.get("/accounts", {id: userId}, function (accountsData, status) {
            $("#selectAmountUser" + userId).append($("<option>Select...</option>"));
            accountsData.forEach(function (accountItem, i, arr) {
                $("#selectAmountUser" + userId).append($("<option></option>")
                    .attr('value', accountItem.id)
                    .text("Account " + accountItem.id + ": " + accountItem.amount));
            });
        });
    }
}

function addEditAmountBlock(userId, amount) {
    if (!$('input').is("#amountInput" + userId)) {
        $('#amountBlock' + userId).append("<input type='number' id='amountInput" + userId +
            "' value='" + amount + "'>" +
            "<button id='buttonSaveAmount" + userId + "' type='button' " +
            "onclick='onClickSaveAmount(" + userId + ")'>Ok</button>");
    }
}

function onClickSaveAmount(userId) {
    var curAccount = $("#selectAmountUser" + userId + " option:selected").val();
    var amount = $("#amountInput" + userId).val();
    var html = "<div id = 'amountBlock" + userId + "'>" +
        "<select class = 'target' id = 'selectAmountUser" + userId +
        "' onmouseover = 'getAmount(" + userId + ")'" +
        "</select> </div>";
    $.post("/updateaccount", {account_id: curAccount, amount: amount})
        .done(function () {
            $("#amountBlock" + userId).html(html);
            getAmount(userId);
        });
}