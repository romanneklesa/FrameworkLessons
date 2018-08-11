function run(parent){
	$.get("/currentuseraccounts",function(data){
		var html=""
			data.forEach(function(item, i, arr) {
         		html= html +
         			'<div class="form-group">'+
         				'<label class="col-sm-4">Account № ' + item.id + ':</label>'+
         				'<div class="col-sm-2">'+
         					'<label class="text-primary col-sm-2">' + item.amount + '</label>'+
         				'</div>'+
         				'<label class="col-sm-1">$</label>'+
         			'</div>';
         	});

         	parent.innerHTML=html;
         	setBind();
	}).done(function(data){setBind();});

}

function saveValue(elementId)
{
    /*поулчаем текущее значение*/
    var current_value = $("#" + elementId).val();

    /*получаем аккаунт пользователя из входящего параметр tmp_1 => 1*/
    var current_user_id =  elementId.replace(/[^0-9]/gi, '');

    /*отправляем данные для сохранения на сервер*/
    $.post("/updateamount", {account_id:current_user_id, amount:current_value})

        /*если данные дошли до сервера, то меняем input=text обратно на label*/
        .done(function( data ) {
        $("#" + elementId).parent().html('<label class="text-primary col-sm-2">'  + current_value + '</label>');

        /*запускаем переустановку событий на элементы (наше событие слетело вместе с уделаением/добавлением элемента)*/
        setBind();
    });

}

function setBind()
{
    /*ставив событие, которое сработает при click*/
    $( ".text-primary").on( "click", function() {

        /*получаем текущее значение*/
         var current_value = $(this).html();

         /*получаем текущий аккаунт - берем значение вида "Account #1" и проходимся по нему регуляркой, вырезая всё что не цифры*/
         var current_user_id = $(this).parent().parent().find("label.col-sm-4").html().replace(/[^0-9]/gi, '');

         /*формируем специальный ID вида tmp_1*/
         var current_special_user_id = 'tmp_' + current_user_id;

         /*заменяем label на input text со значением из label и пририсовываем кнопку save, вешая на нее функцию seveValue с параметром аккаунта который будем менять*/
        $(this).replaceWith("<input style='color:red;width:100px;' value='" + current_value + "' id='" + current_special_user_id +"'/><input type='button' value='Save' onclick='saveValue(\"" + current_special_user_id + "\")'/>");

    });
}

$(document).ready(function(){
	var parent=document.getElementById('parent');
	run(parent);
});

