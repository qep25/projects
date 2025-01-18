<?php
session_start();

                    include 'con.php';
if(isset($_POST['registera'])){

 
   $email = $_POST['email'];
   $pass = $_POST['password'];
   
   //if($POST['code']=='cosrx2022'){
	   $query= "INSERT INTO administrator( ADMIN_EMAIL , ADMIN_PASSWORD ) VALUES('$email', '$pass')" OR DIE ('query failed');
	   $query_run = mysqli_query($connect,$query);
   
	   if($query_run)
	   {
		   
		   echo "<script>alert('SIGN UP SUCCESSFUL!!')</script>";
			echo "<script>window.open('alogin.php','_self')</script>";
	   }
	   
	   else 
		   {
		  
		   header("Location: aregister.php");
	   }
   //}
	//else{
		  
		//   echo "<script>alert('Email or Password is Wrong')</script>";
		//   header("Location: aregister.php");
	  // }
		
   
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

	  <?php include 'header/header1.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi4.php' ?>
	</section>
	<section class="registration-form" >
		<br><h1 align="center" style="font-family: Times New Roman;"> REGISTER </h1>
			<h4><center><i> Start your journey with us </i></center></h4><br>

			<form style="font-family:Arial;" action="#" method="post">

			<br>
			Admin Email   : <br><br>

			<center>
			
			<input class="email" type="text" name="email" placeholder="Please enter your email" ><br> <br></center>
			

			Admin Password  : <br><br>
			<center>
			<input  class="passwordd" type="password" name="password" placeholder="Please your admin password"><br> <br></center>

			Re-enter Password  : <br><br>
			<center>
			<input  class="reenterpassword" type="password" name="repassword" placeholder="Please re-enter your password" ><br> <br></center>

			
			
			<input type="submit" name="registera" value="REGISTER" class="button">
			<br><br><br>

			<i> Already have account ? </i> 
			<a href="alogin.php" style="color:black;"> <b> SIGN IN </b> </a>


			</form>	
			
	</section>

</body>
</html>