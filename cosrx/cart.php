<?php

include 'con.php';
if(isset($_POST['del'])){

 
   $oid = $_POST['oid'];
   
   $query= "DELETE FROM orders WHERE  ORDER_ID = '$oid';" OR DIE ('query failed');
   $query_run = mysqli_query($connect,$query);
   
   if($query_run)
   {
	   echo "<script>alert('DELETE CART SUCCESSFUL!!')</script>";
   }
   
   else 
	   {
	   header("Location: cart.php");
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
    <title>SHOPPING CART</title>
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
		<?php include 'nav/navi2.php' ?>
	</section>
    <h1>SHOPPING CART</h1>
    <br>
    <section id="cart-container" class="container my-5">
        <table width="100%">
            <thead>
                <tr>
                    <td>IMAGE</td>
                    <td>PRODUCT</td>
                    <td>PRICE</td>
                    <td>QUANTITY</td>
                    <td>TOTAL</td>
					<td>DELETE</td>
                </tr>
            </thead>

            <tbody>
                <?php 
				session_start();
					$email = $_SESSION["email_login"];
                    
                    $sql = "SELECT * FROM product P , orders O, customer C where P.PRODUCT_ID = O.PRODUCT_ID and C.CUSTOMER_EMAIL = O.CUSTOMER_EMAIL and O.CUSTOMER_EMAIL = '$email'";
                    
                    $sendsql = mysqli_query($connect, $sql);
                    $num =1;
                    $totalSub = 0.0;
                    $totalSubPrice = 0.0;
                    foreach($sendsql as $row){

                     echo "<tr>
                    
                    <td><img src= \"data:image;base64,".base64_encode($row["PRODUCT_IMAGE"]) ."\" alt=\"\"  onload=\"calcTotal('price".$num."','qty".$num."','Total".$num."')\"></td>
                    <td>
                        <h5>".$row["PRODUCT_NAME"]."</h5>
                    </td>
                    <td>
                        <h5 id=\"price".$num."\">".$row["PRODUCT_PRICE"]."</h5>
                    </td>
                    <td> <h5 id=\"price".$num."\">".$row["ORDER_QUANTITY"]."</h5></td>

                    <td>
                        <h5 id=\"t".$num."\" value=\"\">RM".($row['PRODUCT_PRICE'] * $row['ORDER_QUANTITY'])."</h5>
                    </td>
					<td>
						<form method=post>
						<input type=\"text\" name=\"oid\" value='".$row['ORDER_ID']."' ' style='display:none' >
						<input type=\"submit\" name=\"del\" value=\"DELETE\" class=\"button\">
						</form>						
					</td>
                    </tr>";

                    $num++;
                    $totalSubPrice = ($row["PRODUCT_PRICE"]*$row["ORDER_QUANTITY"]);
                     $totalSub +=  $totalSubPrice;
					$_SESSION["totalsub"]= $totalSub;
                    // echo "<script>
                    // var totalSubPrice = <?php echo $totalSubPrice ;
                    // <!-- document.getElementById('totalSubPrice').innerHTML = totalSubPrice.toFixed(2); -->
                    // <!-- </script>"; -->
                    // <!-- // $totalSub += "<h5 id=\"Total".$num."\"></h5>."; -->

                  } 
				  
				  

                ?>
                
            </tbody>
        </table>

        <div id="total-box">
            <h4>TOTAL PRICE</h4>

            <h5>Total Price : </h5> <span id="totalSub" ></span>
            <h5> Shipping : RM 5 </h5>
            
            <div id="check-btn">
			<form action="payment.php">
               <input type="submit" value="CHECKOUT" class="button"><br><br><br><br><br>
			   </form>
            </div>
        </div>


    </section>

    <script>
        function calcTotal(p,q,t) {
            var qty = document.getElementById(q).value;
            var price = document.getElementById(p).innerHTML;
            price = price.replace("RM","");
            var subtotal = parseInt(qty) * parseDecimal(price);
            document.getElementById(t).innerHTML = subtotal.toFixed(2);
           
        }

        var totalSub = <?php echo $totalSub ?>;
        document.getElementById('totalSub').innerHTML = "RM "+totalSub.toFixed(2);

        // var totalSubPrice = <?php echo $totalSubPrice ?>;
        // document.getElementById('totalSubPrice').innerHTML = totalSubPrice.toFixed(2);

        //window.addEventListener('load',calcTotal)//
        //<td><a href=\"#\"><i class=\"fas fa-trash-alt\"></i></a></td>//  
    </script>


</body>