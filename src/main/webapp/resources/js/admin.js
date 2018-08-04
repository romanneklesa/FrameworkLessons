$(document).ready(function () {
    var tableUsers = $('#tableUsers').DataTable();
    $.get("/getusers", function (data) {
        var count = 0;
        data.forEach(function (item, i, arr) {
            var html = "";
            var htmlRole = "";
            html += "<select>";
            $.get("/accounts", {id: item.id}, function (accountsData, status) {
                accountsData.forEach(function (accountItem, i, arr) {
                    html += "<option value='" + accountItem.amount + "'>" + accountItem.amount + "</option>";
                });
            }).done(function () {
                html += "</select>";
                tableUsers.cell(count, 2).data(html);
                count += 1;
            });
            htmlRole += "<select>";
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
            htmlRole += "</select>";
            tableUsers.row.add([item.id, item.name, "", htmlRole]);
        });
        tableUsers.draw();
    });
});
