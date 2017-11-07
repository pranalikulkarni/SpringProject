
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>

      <link rel="stylesheet" href="AssetStyle.css">

  
</head>

<body>
<form action="checkLogin.asset">
  <div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
		<div class="login-form">
			<div class="sign-in-htm">
				<div class="group">
					<label for="user" class="label">Username</label>
					<input name="userName" type="text" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input name="userPassword" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">User Type</label>
					<input type="radio" name="userType" value="USER">User
                    <input type="radio" name="userType" value="ADMIN">Admin
				</div>
				
				<div class="group">
					<input type="submit" class="button" value="Sign In">
				</div>
				<div class="hr"></div>
				
			</div>
			
		</div>
	</div>
</div>
  
  </form>
</body>
</html> 
