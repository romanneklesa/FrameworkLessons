 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Registration form</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">

            <form method="post" id="regForm" role="form" modelAttribute="user" action="<c:url value="/registration"/>">
            <fieldset><legend class="text-center">Valid information is required to register. <span class="req"><small> required *</small></span></legend>

            <div class="form-group">
                <label for="email"><span class="req">* </span> Email Address: </label>
                    <input class="form-control" required type="text" name="email" id = "email"  onblur="email_validate(this.value);" />
                        <div class="status" id="status"></div>
            </div>

            <div class="form-group">
                <label for="name"><span class="req">* </span> User name:  <small>This will be your login user name</small> </label>
                    <input class="form-control" type="text" name="name" id = "name"
                    onblur="return Validate(this)" placeholder="from 5 to 12 letters" required />
                <div class="nameValid" id="nameValid"></div>

            </div>

            <div class="form-group">
                <label for="password"><span class="req">* </span> Password: </label>
                    <input required name="password" type="password" class="form-control inputpass" id="pass1" onkeyup="checkPass();" /> </p>

                <label for="password1"><span class="req">* </span> Password Confirm: </label>
                    <input required name="password1" type="password" class="form-control inputpass" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass();" />
                        <span id="confirmMessage" class="confirmMessage"></span>
            </div>

            <div class="form-group">
                <input id="reg" class="btn btn-success" type="submit" onclick="return beforeSubmit()" name="submit_reg" value="Register">
                           </div>
            </fieldset>
            </form>

          </div>

	</div>
    </div>
  </div>