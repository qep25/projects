<html>
<head>
<?php
	$hostname = "localhost";
	$username = "root";
	$password = "";
	$dbname = "first_database";
	
	$connect = mysqli_connect($hostname, $username, $password, $dbname) OR DIE ("Connection failed");
				
	if(isset($_POST["submit"])){
				
				$id = $_POST["id"];
				$fullname = $_POST["fullname"];
				$email = $_POST["email"];
				$phoneno = $_POST["phonenum"];
				$reference = $_POST["reference"];
				$server = $_POST["server"];

				$sql = "INSERT INTO students (studentID, fullName, email, phoneNum, reference, server)
				VALUES ('$id', '$fullname' ,'$email' ,'$phoneno' ,'$reference' ,'$server')";
				$sendsql = mysqli_query($connect,$sql);
				
				if ($sendsql) {
				
					header("location:students_list.php"); // redirects to students list page
					exit;
				}
				else
				{
					echo mysqli_error();
				} 
	}
?>
</head>
</html>