<!DOCTYYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SIGN IN</title>
    <link rel="stylesheet" href="style1.css">
	
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
		<?php include 'nav/navi1.php' ?>
	</section>
	
	<section class="logi">

		<h1>PLEASE SIGN-IN</h1><br>
		<form action="" method="POST">
			<b>Email :</b><br>
			<input type="text" name="email" placeholder="Please Enter Your Email Address"><br><br><br>
			<b>Password :</b><br>
			<input type="password" name="password" placeholder="Please Enter Your Password"><br><br>
			
			<input type="submit" name="login" value="LOGIN" class="button">
		</form>
		<center>
		<a href="alogin.php" style="color:black; ">ADMIN ACCESS</a>
		<br><br>
		
	</section>
	<section class="foot">
		<?php include 'footer.php' ?>
	</section>
</body>
</html>

<?php
    session_start();
   include 'con.php';
                
    if(!empty($_SESSION['email_login']) && !empty($_SESSION['pass_login'])){
        header("Location: login.php");
    }
    if(isset($_POST["login"])){
        $login_email = $_POST["email"];
        $login_pass = $_POST["password"];
        
        $query = "SELECT *
                FROM customer
                WHERE CUSTOMER_EMAIL = '$login_email'
                AND CUSTOMER_PASSWORD = '$login_pass'";
        
        $sendsql = mysqli_query($connect, $query);
        
        $data = mysqli_fetch_array($sendsql);
        
        if(mysqli_num_rows($sendsql) == 1){
            header("Location: Recommmendations.php");
            $_SESSION["email_login"] = $login_email;
		}
        else{
            echo 
            '<script>
                $(document).ready(function(){
                    $(".notregister").show();
                });
            </script>
            '
            ;
        }
        
        
    }
?>