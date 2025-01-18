<!DOCTYPE html>
<html>
	<body>
		<?php
			$sandwich = array("bread", "tuna spread", "lettuce", "tomatoes");
			
			echo "The ingredients that I need to make a sandwich are:<br>";
			
			for($i = 0 ; $i< count($sandwich)-1 ; $i++){
				echo $sandwich[$i] ; 
				echo ", ";
			}
			
			echo $sandwich[$i] . ".";
		?>
	</body>
</html>