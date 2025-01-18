<!DOCTYYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>START</title>
    <link rel="stylesheet" href="style1.css">
		<link
  rel="stylesheet"
  href="https://unpkg.com/swiper@8/swiper-bundle.min.css"
/>
	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jost:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">



</head>
<body>
	<header>
	  <?php include 'header/header1.php' ?>
	</header>
	<section class="navi">
		<?php include 'nav/navi1.php' ?>
	</section>
	<section class="iklan" >
		
		<!-- Slider main container -->
		<div class="swiper">
		  <!-- Additional required wrapper -->
		  <div class="swiper-wrapper">
			<!-- Slides -->
		
			<div class="swiper-slide">
				
				<div class="image">
				<img src="img/iklan1.png">
				</div>
				<div class="swiper-button-prev"></div>
		  <div class="swiper-button-next"></div>

			</div>
			<div class="swiper-slide">
				<div class="image">
				<img src="img/iklan2.png">
				</div>
				<div class="swiper-button-prev"></div>
		  <div class="swiper-button-next"></div>

			</div>
			
			</div>

		</div>
	</section>
	
	<script src="https://unpkg.com/scrollreveal"></script>
	
	<!---------Link to js--------->
	
	<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
	<script>const swiper = new Swiper('.swiper', {
  // Optional parameters
  direction: 'horizontal',
  loop: true,

  

  // Navigation arrows
  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },

});</script>
<script type="text/javascript" src="js/script.js"></script>
</body>
	<section class="foot">
		<?php include 'footer.php' ?>
	</section>
</body>
</html>