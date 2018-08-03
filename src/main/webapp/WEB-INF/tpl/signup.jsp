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
                    <input class="form-control" required type="text" name="email" id = "email"  onchange="email_validate(this.value);" />
                        <div class="status" id="status"></div>
            </div>

            <div class="form-group">
                <label for="username"><span class="req">* </span> User name:  <small>This will be your login user name</small> </label>
                    <input class="form-control" type="text" name="username" id = "txt" minlength="6" maxlength="16"
                    onkeyup = "Validate(this) return false;" placeholder="minimum 6 letters" required />

            </div>

            <div class="form-group">
                <label for="password"><span class="req">* </span> Password: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16"  id="pass1" /> </p>

                <label for="password"><span class="req">* </span> Password Confirm: </label>
                    <input required name="password" type="password" class="form-control inputpass" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                        <span id="confirmMessage" class="confirmMessage"></span>
            </div>

            <div class="form-group">
                <input id="reg" class="btn btn-success" type="submit" name="submit_reg" value="Register">
                <input id="send" type="submit" style="display: none"/>
            </div>
            </fieldset>
            </form>

          </div>

	</div>
</div>