$(document).ready(function(){
    var tableUsers = $('#tableUsers').DataTable();
    $.get("/getusers",function(data) {
        data.forEach(function (item, i, arr) {
            var html = "";
            $.get("/accounts?id=1",function(accountsData) {
                accountsData.forEach(function (accountItem, i, arr) {
                    html += accountItem.amount + ",";
                });
            });
            tableUsers.row.add([item.id,item.name,html,"Role"]);
        });
        tableUsers.draw();

    });
})
