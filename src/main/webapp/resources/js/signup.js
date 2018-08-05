$(document).ready(function () {
    $("#signupButton").click(function () {
        $("#myModal").modal();
    });

});

function validateBeforeSubmit(name, email) {
    return email_validate(email) && checkPass()&& name.length>4;

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
                document.getElementById("status").innerHTML = "<span class='warning'>Such email already exists</span>";
                return false;
            }

            if(data=='wrongName'){
                document.getElementById("nameValid").innerHTML = "<span class='warning'>Such name already exists</span>";
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
    if(pass1.value.length<4){
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
    txt.value = txt.value.replace(/[^a-zA-Z-'\n\r.]+/g, '');
    if(txt.value.length>4){
        document.getElementById("nameValid").innerHTML = "<span class='valid'>Name is OK</span>"
        document.getElementById("nameValid").focus();
    } else {
        document.getElementById("nameValid").innerHTML = "<span class='warning'>Name is too short</span>";
    }

}

// validate email
function email_validate(email) {
    var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

    if (regMail.test(email) == false) {
        document.getElementById("status").innerHTML = "<span class='warning'>Email address is not valid yet.</span>";
        return false
    }
    else {
        document.getElementById("status").innerHTML = "<span class='valid'>Thanks, you have entered a valid Email address!</span>";
        document.getElementById('email').style.backgroundColor = "#fff";
    }
    return true;
}
