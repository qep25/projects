<!DOCTYPE html>
<html>
	<head>
		<title>Log In</title>
	</head>
	<body>
		<h1>Log-In Page</h1>
		
		<form action="" method="post">
			Username:<br>
			<input type="text" name="uname"><br>
			Password:<br>
			<input type="password" name="pass"><br><br>
			<input type="submit" value="Login" name="submit">
		</form><br>
		<?php
			if(isset($_POST["submit"])){
				$uname = $_POST["uname"];
				$pass = $_POST["pass"];
				
				$user = "michael_j";
				$pword = "michael123";
				if( $uname == $user ){
					if( $pass == $pword ){
						echo "Hi Michael";
					}
					else {
						echo "<font color=red>Log-in Unsuccessful!<br>Try again.<font>";
					}
				}
				else {
					echo "<font color=red>Log-in Unsuccessful!<br>Try again.<font>";
				}
			}
		?>
		
	</body>
</html>