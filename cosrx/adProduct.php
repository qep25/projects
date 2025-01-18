<?php


                    include 'con.php';
if(isset($_POST['delete'])){
session_start();
 
   $prodid = $_POST['proid'];
   $_SESSION['id'] = $prodid;
   
   
   $query= "DELETE FROM product WHERE  PRODUCT_ID = '$prodid';" OR DIE ('query failed');
   $query_run = mysqli_query($connect,$query);
   
   if($query_run)
   {
	   echo "<script>alert('DELETE PRODUCT SUCCESSFUL!!')</script>";
   }
   
   else 
	   {
		   echo "<script>alert('DELETE PRODUCT UNSUCCESSFUL!!')</script>";
	   header("Location: aproduct.php");
   }
};

if(isset($_POST['update'])){
session_start();
 
  echo "<script>window.open('login.php','_self')</script>";
}
   
   else 
	   {
		   echo "<script>alert('UPDATE PRODUCT UNSUCCESSFUL!!')</script>";
	   header("Location: product.php");
   }
;




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
    <h1>PRODUCTS</h1>
    <section id="cart-container" class="container my-5">
        <table width="100%">
            <thead>
                <tr>
                    <td>Product ID</td>
                    <td>Image</td>
                    <td>Product Name</td>
                    <td>Description</td>
                    <td>Price</td>
					<td>UPDATE</td>
					<td>DELETE</td>
                </tr>
            </thead>

            <tbody>
			  <?php

					include 'con.php';
                    
                    $sql = "SELECT * FROM product ";
                    
                    $sendsql = mysqli_query($connect, $sql);
                    $num =1;
                    foreach($sendsql as $row){

                     echo "<tr><form method=\"POST\">
                    <td><h5 id=\"prodID".$num."\">".$row["PRODUCT_ID"]."</h5>
					<input type='text' name='proid' value='".$row["PRODUCT_ID"]."' style='display:none'></td>
                    <td><img src= \"data:image;base64,".base64_encode($row["PRODUCT_IMAGE"]) ."\" alt=\"\"></td>
                    <td>
                        <h5>".$row["PRODUCT_NAME"]."</h5>
                    </td>
                    <td>
                        <h5 id=\"desc".$num."\">".$row["PRODUCT_DESC"]."</h5>
                    </td>
                    <td><h5 id=\"price".$num."\">RM ".$row["PRODUCT_PRICE"]."</h5></td>
					<td>
					<input type=\"submit\" name=\"update\" value=\"UPDATE\" class=\"button\">
					</td>
					<td><input type=\"submit\" name=\"delete\" value=\"DELETE\" class=\"button\">
					</form></td>
                    </tr>
					
					";
					
					
				};
									$num++;

									
									
                ?>
                  <script>
					
					
					</script>  
            </tbody>
        </table>
         </section>

    <script>
	
    </script>
	
        

</body>