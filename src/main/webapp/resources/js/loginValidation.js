/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var isLoginSuccess = false;
var isPasswordSuccess = false;

$( "#user" ).keydown(function() {
    isLoginSuccess = false;
    if($( "#user" ).val().length > 12 || $( "#user" ).val().length<4){
        $('#errorLoginDescription').html("<p class='errorDescription'> Логин должен быть в пределах : 5 - 12 симв. !</p>");
        $("#send_button").attr('disabled',true);
    }
    else{
        if(!(/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/.test($( "#user" ).val()))){
        $('#errorLoginDescription').html("<p class='errorDescription'> Используйте киррилицу и знаки ( - _ )!</p>");
        $("#send_button").attr('disabled',true);
        }
        else {
        $('#errorLoginDescription').html("");
        isLoginSuccess = true;
        if(isLoginSuccess == true && isPasswordSuccess == true)$("#send_button").removeAttr('disabled');
        }
    }
});
$( "#user" ).focusout(function() {
        if(( $( "#user" ).val().length <= 12 && $( "#user" ).val().length>=4 ) || $( "#user" ).val().length === 0 ){
             $('#errorLoginDescription').html("");
        }
});
$( "#pwd" ).keydown(function() {
    isPasswordSuccess = false;
    if($( "#pwd" ).val().length > 12 || $( "#pwd" ).val().length<4){
        $('#errorPassDescription').html("<p class='errorDescription'> Пароль должен быть в пределах : 5 - 12 симв. !</p>");
        $("#send_button").attr('disabled',true);
    }
    else{
        if(!(/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/.test($( "#pwd" ).val()))){
        $('#errorPassDescription').html("<p class='errorDescription'> Используйте киррилицу и знаки ( - _ )!</p>");
        $("#send_button").attr('disabled',true);
        }
        else {
        $('#errorPassDescription').html("");
        isPasswordSuccess = true;
        if(isLoginSuccess == true && isPasswordSuccess == true)$("#send_button").removeAttr('disabled');
        }
    }
});
$( "#pwd" ).focusout(function() {
        if(( $( "#pwd" ).val().length <= 12 && $( "#pwd" ).val().length>=4 ) || $( "#pwd" ).val().length === 0 ){
            $('#errorPassDescription').html("");
        }
});

