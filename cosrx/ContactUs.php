<html>

<head>
<title>
</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gulzar&family=Inter:wght@300&family=Lato:wght@300;400&family=Poppins:wght@300;400&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<style>

.column3 input
{
	
	padding: 15px 10px;
	width:80%;
	border:0;
	border-radius: 5px;
	outline: none;
	
}

</style>
</head>


<body style="background: #fff6ec;">

<header>
	  <?php include 'header/header2.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi2.php' ?>
	</section>
	
<br><br><br><br>
<div class="headingrecommend">
<center>

<p  style="font-family: 'Lato', sans-serif;, sans-serif; font-size:25px;"> <b>CONTACT US </b>

</center>

<hr style="width:1400px; color:black;"><br>

<div class="row">

<div class="column1" style="float:left; padding-left:100px; font-family:'Lato', sans-serif;">

<h2> Headquarters </h2>
<br>
<p> Building M Tower 2nd Floor,COSRX Inc.<br>
  8, Gumi-ro, Bundang-gu, Seongnam-si, <br>
  Gyeonggi-do, KR, 13638
</p>

<br><br><br><br>
<h2> Phone </h2><br>

<p>
<b>Customer Service : </b>
031-714-9488
</p>

</div>

<div class="column3" style="float:right; font-family:'Lato', sans-serif; padding-right:80px; padding-bottom: 100px;">
<br>
<h2> Send your queries to us :  </h2>
<br><br>
<textarea id="queries" rows="7" cols="50" style= "background-color: #e1e0e0; text-align:center;">Write your message here</textarea>


<br><br>

<hr style="width:450px; color:black;"><br>

<h3>Your information </h3>

<br>
<p>Name <br><form><input type="text" id="emai;" name="email"><br></form> 
<br>Email<br> <form><input type="text" id="emai;" name="email"><br></form> 
<br>Phone number <br><form><input type="text" id="emai;" name="email"><br></form> 
<br></p>
<button type="button" style="background-color:black;  float:right;  color:white;" width=4px; height=2px; onclick="messagebox()"> SEND</button>



</div>

<script>
function messagebox(){
alert("Your message has been sent successfully!")
}
</script>

<center>
<br>
<div class="column2" style="font-family:'Lato', sans-serif; padding-right:390px;">

<h2> Working Hours </h2>
<br>
<p style=";"> Reprensentives and Beauty Advisors are available : <br>
  MON-FRI : 10am to 5pm (KST) <br>
  SAT-SUN : Closed
</p>

<br><br><br><br>
<h2> Email Us </h2>
<br>

<p>
Customer Service : <b>global@cosrx.co.kr</b>
</p>
<p style="padding-left:380px;">
Wholesales : <b>selltogether@cosrx.co.kr</b>

</p>

</div>
</center>



</div>
	<section class="foot">
		<?php include 'footer.php' ?>
	</section>
</body>

</html>