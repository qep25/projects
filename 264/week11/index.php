<!DOCTYYPE html>
<html>
<head>
	<title>E11</title>
</head>
<body>
	<h1 style = "text-align:center">CSC264 Survey</h1>

	<form action="student_info.php" method="post">

	<fieldset style="width:500px;margin:auto">
	<legend style="font-weight:bold">Student Information</legend>
	
		Student ID &emsp; &emsp; : &nbsp;
		<input type="text" id="textfield" name="id" placeholder="Enter your student ID" > <br><br>
		
		Full Name &emsp; &emsp; : &nbsp; 
		<input type="text" id="textfield" name="fullname" placeholder="Enter your full name" > <br><br>
		
		E-mail &emsp; &emsp; &emsp; &nbsp; :  &nbsp;
		<input type="email" id="textfield" name="email" placeholder="Enter your email" > <br><br>
		
		Phone Number &ensp; : &nbsp;
		<input type="text" id="textfield" name="phonenum" placeholder="Enter your phone number" > <br><br>
		
	</fieldset><br>
	<fieldset style="width:500px;margin:auto">
	<legend style="font-weight:bold">Reference</legend>
	
		What kind of reference do you consider the most useful? <br><br>

		<input type="radio" name="reference" value="Text Books">
		Text Books 
		<input type="radio" name="reference" value="Lecture Slides">
		Lecture Slides
		<input type="radio" name="reference" value="Manual">
		Manual 

	</fieldset><br>
	
	<fieldset style="width:500px;margin:auto">
	<legend style="font-weight:bold">Local Server</legend>
		What local server do you enjoy using?<br><br>
		
		<select name="server">
		<option value="XAMPP" selected> XAMPP Server</option>
		<option value="WAMP">WAMP Server</option>
		</select>
	</fieldset>
	
	<p style="text-align:center">
	<input type="submit" id="button" name="submit" value="SUBMIT"></p>
	
	</form>
</body>
</html>