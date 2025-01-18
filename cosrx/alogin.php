<!DOCTYYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SIGN IN</title>
    <link rel="stylesheet" href="style2.css">
	
	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body style="background: url(img/signin.jpg); background-size: cover;">
	<header>
	  <?php include 'header/header1.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi4.php' ?>
	</section>
	<section class="logi">
		<h1>PLEASE SIGN-IN FOR ADMIN ACCESS</h1><br>
		<form method="POST">
			<b>Admin Email :</b><br>
			<input type="text" name="email" placeholder="Please Enter Your Email"><br><br><br>
			<b>Password :</b><br>
			<input type="password" name="password" placeholder="Please Enter Your Password"><br><br>
			
			<input class="button" type="submit" name="submit" value="LOGIN" >
		</form>
		<br>
	</section>

</body>
</html>

<?php

include 'con.php';

if(isset($_POST['submit'])){

$id = mysqli_real_escape_string($connect,$_POST['email']);

$password = mysqli_real_escape_string($connect,$_POST['password']);

$get_admin = "select * from administrator where ADMIN_EMAIL='$id' AND ADMIN_PASSWORD='$password'";

$run_admin = mysqli_query($connect,$get_admin);

$count = mysqli_num_rows($run_admin);

if($count==1){

$_SESSION['AdminId']=$id;

echo "<script>alert('SIGN IN SUCCESSFUL!!')</script>";
header("Location: adminPro.php");

}
else {

echo "<script>alert('Email or Password is Wrong')</script>";

}

}

?>