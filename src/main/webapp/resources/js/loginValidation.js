let errorLogin=$('#errorLoginDescription');
let errorPass=$('#errorPassDescription');

function passwordIsValid(pass){
    errorPass.html("");
    if(!(/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/.test(pass))){
        errorPass.html("<p class='errorDescription'>Password must contain latin characters, digits, underscores (_) and minus(-) symbols only</p>");
        return false;
    }
    else {
        if (pass.length <= 12 && pass.length >= 4) {
            return true;
        }
        else {
            errorPass.html("<p class='errorDescription'>Password length have to be from 5 to 12 symbols</p>");
            return false;
        }
    }

}

function loginIsValid(login){
    errorLogin.html("");
    if(!(/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/.test(login))){
        errorLogin.html("<p class='errorDescription'>Login must contain latin characters, digits, underscores (_) and minus(-) symbols only</p>");
        return false;
    }
    else {
        if (login.length <= 12 && login.length >= 4) {
            return true;
        }
        else {
            errorLogin.html("<p class='errorDescription'>Login length have to be from 5 to 12 symbols</p>");
            return false;
        }
    }
}

function setSendButtonDisabledAttribute(){
    if(loginIsValid($( "#user" ).val()) & passwordIsValid($( "#pwd" ).val())){
        $("#send_button").attr('disabled',false);
    }
    else $("#send_button").attr('disabled',true);
}

$('#user').on("input",setSendButtonDisabledAttribute);
$('#pwd').on("input",setSendButtonDisabledAttribute);

