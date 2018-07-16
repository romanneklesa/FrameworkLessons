<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="/action_page.php">
    <div class="container">
      <h1>Sign Up</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input class="input-popup" type="text" placeholder="Enter username" name="email" required>

      <label for="email"><b>Email</b></label>
      <input class="input-popup" type="text" placeholder="Enter Email" name="email" required>

      <label for="psw"><b>Password</b></label>
      <input class="input-popup" type="password" placeholder="Enter Password" name="psw" required>

      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input class="input-popup" type="password" placeholder="Repeat Password" name="psw-repeat" required>


      <div class="clearfix">
        <button id="btn1" type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button id="btn2" type="submit" class="signupbtn">Sign Up</button>
      </div>
    </div>
  </form>
</div>
