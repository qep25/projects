<html>
	 <body>
	 
	 <?php
	 
		 $word = array("madam", "glue", "eye", "racecar", "jump"); 
		 
		 for($i=0; $i<count($word); $i++ ){
			  echo "Word to check: " . $word[$i]. "<br>";
			  strrev($word[$i]);
			  
			  if ($word[$i] == strrev($word[$i]))
				echo "The word \"" . $word[$i] . "\" is a palindrome.";
			  else 
				echo "The word \"" . $word[$i] . "\" is not a palindrome.";
			 
			  echo "<br><br>";
		 }  
	 ?>
	  </body>
</html>