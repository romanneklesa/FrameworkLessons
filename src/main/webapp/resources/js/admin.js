function run(parent){
    $.get("/getusers",function(data) {
        var html = "";
        data.forEach(function (item, i, arr) {
            html = html +
                "<tr>" +
                "<td>" + item.id + "</td>" +
                "<td>" + item.name + "</td>" +
                "</tr>";
        });
        $(parent).find('tbody').append(html);
    });
}
     
$(document).ready(function(){    
	var parent=document.getElementById('tableUsers');
    $('#tableUsers').DataTable();
	run(parent);
})
