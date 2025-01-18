<!DOCTYPE html>
<html>
	<body>
		<?php
			echo "<h1>List of Days:</h1>";
			
			$days = array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
			
			for($i = 0 ; $i< count($days) ; $i++){
				echo "Day " . ($i+1) . ": ";
				echo $days[$i] . "<br>";
			}
			
			echo "<h1>List of Days:</h1>";
			
			sort($days);
			
			echo "<ul>";
			for($x = 0 ; $x< count($days) ; $x++){
				echo "<li>" . $days[$x] . "</li>";
			}
			
			echo "</ul>";
		?>
	</body>
</html>