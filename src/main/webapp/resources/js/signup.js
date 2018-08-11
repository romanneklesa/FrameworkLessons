$(document).ready(function () {
    $("#signupButton").click(function () {
        $("#myModal").modal();
    });

});

function validateBeforeSubmit(name, email) {
    return email_validate(email) && checkPass()&& Validate(name);

}

function  beforeSubmit() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;

    if (validateBeforeSubmit(name, email)) {

        $.post("./checkInputs", {'name': name, 'email': email}, function (data, status) {
            if(data=='success'){
                document.getElementById("regForm").submit();
                return true;
            }

            if(data=='wrongEmail'){
                document.getElementById("status").innerHTML = "<span class='errorDescription'>Such email already exists</span>";
                return false;
            }

            if(data=='wrongName'){
                document.getElementById("nameValid").innerHTML = "<span class='errorDescription'>Such name already exists</span>";
                return false;
            }
        });
    }

    return false;
}

function checkPass() {
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field
    //and the confirmation field

    if(!(/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/.test(pass1.value))){
        message.style.color = badColor;
        message.innerHTML = "Password must contain latin characters, digits, underscores (_) and minus(-) symbols only";
        return false;
    }

    if(pass1.value.length<4){
        message.style.color = badColor;
        message.innerHTML = "Password is too short";
        pass1.focus();
    return false;
    }

    if (pass1.value == pass2.value) {
        //The passwords match.
        //Set the color to the good color and inform
        //the user that they have entered the correct password
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match"
        return true;
    } else {
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
        return false;
    }
}

// validates text only
function Validate(txt) {
    if(!(/^[a-zA-Z](.[a-zA-Z0-9_-]*)$/.test(txt.value))){
        document.getElementById("nameValid").innerHTML =
            "<span class='errorDescription'> Login must contain latin characters, digits, underscores (_) and minus(-) symbols only</span>";
        document.getElementById("nameValid").focus();
        return false;
    } else document.getElementById("nameValid").innerHTML ="<span></span>";

    if (txt.length > 12 && txt.length < 5) {
        document.getElementById("nameValid").innerHTML = "<span class='errorDescription'>Login length have to be from 5 to 12 symbols</span>";
        document.getElementById("nameValid").focus();
        return false;
    } else document.getElementById("nameValid").innerHTML ="<span></span>";
    return true;

}

// validate email
function email_validate(email) {
//    var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (!re.test(String(email).toLowerCase())) {
        document.getElementById("status").innerHTML = "<span class='errorDescription'>Email address is not valid yet.</span>";
        return false
    }
    else {
        document.getElementById("status").innerHTML = "<span class='valid'>Thanks, you have entered a valid Email address!</span>";
        document.getElementById('email').style.backgroundColor = "#fff";
    }
    return true;
}
