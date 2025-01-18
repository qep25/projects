<?php
include 'con.php';

if(isset($_POST['update'])){

 
   $prodid = $_POST['proid'];
   $id = $_POST['id'];
   $name = $_POST['name'];
   $desc = $_POST['desc'];
   $price = $_POST['price'];
   
   
   
   
   $query= "UPDATE product SET PRODUCT_ID = '$id', PRODUCT_NAME = '$name' ,PRODUCT_DESC = '$desc', PRODUCT_PRICE = '$price' WHERE PRODUCT_ID = '$prodid';" OR DIE ('query failed');
   $query_run = mysqli_query($connect,$query);
   
   if($query_run)
   {
	   echo "<script>alert('UPDATE PRODUCT SUCCESSFUL!!')</script>";
	   echo "<script>window.open('adminPro.php','_self')</script>";
   }
   
   else 
	   {
		   echo "<script>alert('UPDATE PRODUCT UNSUCCESSFUL!!')</script>";
	   header("Location: adminPro.php");
   }
};
?>

<!DOCTYPE html>
<html lang="en">
<head>

    <!-- cdn link -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<link rel="stylesheet" href="navistyle.css"> -->
    <title>PRODUCT</title>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- font awesome cdn link  -->
   <script src="https://kit.fontawesome.com/a076d05399.js"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="https://kit.fontawesome.com/36d0859930.js" crossorigin="anonymous"></script>

    <!-- custom css file link  -->
    <link rel="stylesheet" href="style1.css">
	
</head>
<body>
<header>
	  <?php include 'header/header2.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi3.php' ?>
	</section>
    <h1>UPDATE PRODUCTS</h1>
	<section id="cart-container" class="container my-5">
        <table width="100%">
            <thead>
                <tr>
                    <td>Product ID</td>
                    <td>Image</td>
                    <td>Product Name</td>
                    <td>Description</td>
                    <td>Price</td>
                </tr>
            </thead>

            <tbody>
			  <?php
					
					session_start();
					$idpro = $_SESSION["idpro"];
					
					
                    
                    $sql = "SELECT * FROM product WHERE PRODUCT_ID='$idpro'";
                    $sendsql = mysqli_query($connect, $sql);
					$data = mysqli_fetch_array($sendsql);

                     echo "<tr><form method=\"POST\">
                    <td><h5 id=\"prodID\">".$data["PRODUCT_ID"]."</h5>
					<input type='text' name='proid' value='".$data["PRODUCT_ID"]."' style='display:none'></td>
                    <td><img src= \"data:image;base64,".base64_encode($data["PRODUCT_IMAGE"]) ."\" alt=\"\"></td>
                    <td>
                        <h5>".$data["PRODUCT_NAME"]."</h5>
                    </td>
                    <td>
                        <h5 id=\"desc\">".$data["PRODUCT_DESC"]."</h5>
                    </td>
                    <td><h5 id=\"price\">RM ".$data["PRODUCT_PRICE"]."</h5></td>
                    </tr>
					
					";
					
					
				;
		
				echo "<br><br><br><form method='POST'> 
				
				PRODUCT ID :
				<input type='text' name='id' ><br>
				
				PRODUCT NAME :
				<input type='text' name='name' ><br>
				
				PRODUCT DESCRIPTION :
				<input type='text' name='desc' ><br>
				
				PRODUCT PRICE : RM
				<input type='text' name='price' ><br>
				
				
				<input type=\"submit\" name=\"update\" value=\"UPDATE\" class=\"button\"> <br><br><br> ";
				
				?>
		
</body>