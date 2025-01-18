<?php
session_start();

                    include 'con.php';
if(isset($_POST['register'])){

 
   $fname = $_POST['first_name'];
   $lname = $_POST['last_name'];
   $email = $_POST['email'];
   $pass = $_POST['password'];
   
   $query= "INSERT INTO customer(CUSTOMER_EMAIL,CUSTOMER_FNAME,CUSTOMER_LNAME, CUSTOMER_PASSWORD) VALUES('$email', '$fname', '$lname', '$pass')" OR DIE ('query failed');
   $query_run = mysqli_query($connect,$query);
   
   if($query_run)
   {
	   $_SESSION['status']="Inserted successfully";
	   echo "<script>alert('SIGN UP SUCCESSFUL!!')</script>";
		echo "<script>window.open('login.php','_self')</script>";
   }
   
   else 
	   {
	   $_SESSION['status']="Inserted unsuccessfully";
	   header("Location: register.php");
   }
};



 ?>

<!DOCTYYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>REGISTER</title>
    <link rel="stylesheet" href="style1.css">
	
	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body style="background: url(img/bg.jpg); background-size: cover;">
	<header>
		<?php
		if(isset($_SESSION['status']))
		{
		echo"<h4>".$_SESSION['status']."</h4>";
		unset($_SESSION['status']);
		}
		?>
	  <?php include 'header/header1.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi1.php' ?>
	</section>
	<section class="registration-form" >
		<br><h1 align="center" style="font-family: Times New Roman;"> REGISTER </h1>
			<h4><center><i> Start your journey with us </i></center></h4><br>

			<form style="font-family:Arial;" action="#" method="post">

			<br>
			First Name    : <br><br>

			<center>
			<input class="firstname" type="text" name="first_name" placeholder="Please enter your last name" ><br> <br></center>

			Last Name     : <br><br>
			<center>
			<input class="lastname" type="text" name="last_name" placeholder="Please enter your last name" ><br> <br></center>

			E-mail        : <br><br>
			<center>
			<input class="email" type="text" name="email" placeholder="Please enter your email" ><br> <br></center>

			Password  : <br><br>
			<center>
			<input  class="passwordd" type="password" name="password" placeholder="Please your password"><br> <br></center>

			Re-enter Password  : <br><br>
			<center>
			<input  class="reenterpassword" type="password" name="repassword" placeholder="Please re-enter your password" ><br> <br></center>


			<input type="submit" name="register" value="REGISTER" class="button">
			<br><br><br>

			<i> Already have account ? </i> 
			<a href="login.php" style="color:black;"> <b> SIGN IN </b> </a>


			</form>	
			
	</section>
	</section>
</body>
</html>