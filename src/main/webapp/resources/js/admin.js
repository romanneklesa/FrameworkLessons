$(document).ready(function () {
    var tableUsers = $('#tableUsers').DataTable();
    $.get("/getusers", function (data) {
        var count = 0;
        data.forEach(function (item, i, arr) {
            var html = "";
            var htmlRole = "";
            html += "<select class='target' id='selectAmountUser"+ item.id +"' onmouseover = 'getAmount("+ item.id +")'>";
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
    }).done(function () {
        $( ".target" ).change(function() {
            var ammountId = this.value;
            $.post("/updateaccount", {account_id:ammountId, amount:25})
        });
    });


});

function getAmount(userId) {
    $.get("/accounts", {id: userId}, function (accountsData, status) {
        accountsData.forEach(function (accountItem, i, arr) {
            if ( $('#selectAmountUser'+ userId).children('option').length < 3) {
                $("#selectAmountUser" + userId).append($("<option value='" + accountItem.id + "'>Account " + accountItem.id + ": " + accountItem.amount + "</option>"));
            }
        });
    });
}