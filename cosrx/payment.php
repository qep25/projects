<?php
session_start();
$total = $_SESSION["totalsub"]; 
$ship = $total+5;

                    include 'con.php';
if(isset($_POST['placeorder'])){

 
   $payment_method = $_POST['paymentmet'];
  
   $query= "INSERT INTO payment(PAYMENT_METHOD,PAYMENT_TIME,PAYMENT_DATE, PAYMENT_STATUS,PAYMENT_AMOUNT) VALUES('$payment_method', now(), curdate(), 'PAID','$ship')" OR DIE ('query failed');
   $query_run = mysqli_query($connect,$query);
   
   if($query_run)
   {
	   $_SESSION['status']="Inserted successfully";
	   header("Location: payment.php");
   }
   
   else 
	   {
	   $_SESSION['status']="Inserted unsuccessfully";
	   header("Location: payment.php");
   }
};



 ?>
	
<html>

<head>
<title> PAYMENT
</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gulzar&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style1.css">

</head>

<body>

	 
<header>

<?php
if(isset($_SESSION['status']))
{
echo"<h4>".$_SESSION['status']."</h4>";
unset($_SESSION['status']);
}
?>
	  <?php include 'header/header2.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi2.php' ?>
	</section>
<div class="paymentheader">
<p align="left" style="font-family: Times new roman; font-size:25px; padding-left:65px; font-family: 'Gulzar', serif;"> <br><b>Secure your payment</b></p>
</div>
<!--registration form-->
<div class="payment-form" style="padding-left: 80px;">
<form style="font-family:Arial;" action="#" method="post">


<br>
Shipping Address    : </b><br><br>


<input class="addressline1" type="text" name="address1" placeholder="Address line 1" style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; size=10; maxlength=30; width: 900px; height: 50px; border:none;"><br> <br>
<input class="addressline2" type="text" name="address2" placeholder="Address line 2" style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; size=10; maxlength=30; width: 900px; height: 50px;border:none;" ><br> <br>
<input class="addressline3" type="text" name="poscode" placeholder="Poscode"  style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; size=10; maxlength=30; width: 400px; height: 50px;border:none;"><br> <br>
<input class="addressline4" type="text" name="city" placeholder="City"  style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; size=10; maxlength=30; width: 600px; height: 50px;border:none;"><br> <br>

<br>
<b>State : &nbsp;</b>
<select name="state" style=" background-color: #989298; width: 200px; height:30px; border:none;">
   <option value="Kuala Lumpur">Kuala Lumpur</option>
   <option value="Kedah">Kedah</option>
   <option value="Selangor ">Selangor</option>
   <option value="Johor ">Johor </option>
   <option value="Terengganu ">Terengganu</option>
   <option value="Perlis ">Perlis</option>
   <option value="Perak ">Perak</option>
   <option value="Sabah ">Sabah</option>
   <option value="Sarawak ">Sarawak</option>
   <option value="Pahang ">Pahang</option>
   <option value="Melaka ">Melaka</option>
   <option value="NegeriSembilan ">Negeri Sembilan</option>
   <option value="Kelantan ">Kelantan</option>
   <option value="PulauPinang">Pulau Pinang</option>
</select>

<br><br>



<b>Payment method : </b>
<?php 

echo"<div id=\"box\" style=\"padding-right: 100px; align-items : top;\">
<div id=\"totalbox\" style=\"float:right; border:none; background-color : #DEDCDE; padding: 40 40 40 40;\" >
<p><b>Subtotal : RM $total</b><br>Shipping fee : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RM 5<br><br><hr><br></p>

<h1 style=\"font-size: 25px;\">TOTAL &nbsp;&nbsp; RM $ship</h1>"
?>
<br><br>
<center>
<a href="product.php">
<button class="btnPlaceorder" type="submit" name="placeorder"style="background-color:#cc0000 ; color: white; border:0px; size:25px; padding: 13 50; font-size: 15px;">
 <b>PLACE ORDER</b></button><br>
</a>


</center><br><br>
</div>
</div>

<br><br><br>

<div class="paymentmethod" style="padding-left:200px;">
<input type="radio" name="paymentmet"  value="visamastercard" style="width : 25px;"> <img id= "imgvisa" src="img/visa.png" style="width:100px; length:15px; height:100px;">
<span></span>

<input type="radio" name="paymentmet"  value="americanexpress"style="width : 25px;">  <img id="imgamerican" src="img/fpx.png" style="width:190px; length:15px; height:100px;" >

<input type="radio" name="paymentmet"  value="duitnow" style="width : 25px;">    <img id="imgduitnow" src="img/duitnow.png" style="width:100px; length:15px; height:100px;" >
</div>


<br><br><br><br>
<b>Credit/Debit Card</b> <br><br>

<div id="card" style="padding-left:50px;>

Name on Card <br>
<input class="cname" type="text" name="cardname"  style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; width:800px; height:50px;border:none;" size="10" maxlength="30"><br> <br>
Card Number <br><br>
<input class="cnum" type="text" name="cardnum"  style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; width:800px; height:30px;border:none;" size="10" maxlength="30"><br> <br><br>

CVC &nbsp; &nbsp;  <input class="cnum" type="text" name="cardnum" style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; width:200px; height:30px;border:none;" size="10" maxlength="30"> <span></span> &nbsp;&nbsp;
Exp Date &nbsp; &nbsp; <input class="cnum" type="text" name="cardnum" style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298;  width:200px; height:30px;border:none;" size="10" maxlength="30"><br><br>
TAC &nbsp; &nbsp;  <input class="cnum" type="text" name="cardnum" style="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: #989298; width:200px; height:30px;border:none;" size="10" maxlength="30"> 
&nbsp;&nbsp;
<a href="request.html" style="color:blue;">  <b> Request </b> </a>

</div>

<br><br><br><br>




<!--button
<button type="button" style="background-color:#eba9a4 " width=4px; height=2px; > REGISTER </button>
<br><br><br>

<i> Already have account ? </i> 
<a href="login.html" style="color:black;"> <b> Request </b> </a>

-->

</form>
</div>
<!--page background-->
	<section class="foot">
		<?php include 'footer.php' ?>
	</section>

</body>
</html>