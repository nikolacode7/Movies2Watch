function main() {
  
  $('.projects-button').on('click', function() {
	  
	  if (typeof (Storage) !== "undefined") {
			if (localStorage.clickcount) {
			    localStorage.clickcount = Number(localStorage.clickcount) + 1;
			} else {
				localStorage.clickcount = 1;
			}

			$(this).next().text(localStorage.clickcount); 
		} else {
			$(this).next().text("Sorry"); 
		}  
		
  });
  
}
/*https://www.codesd.com/item/saving-multiple-values-using-html5-local-storage.html
	$('.projects-button').on('click',function addClick() {
		var clicks = 0;
	}
		if (typeof (Storage) !== "undefined") {
			if (localStorage.clickcount) {
				localStorage.clickcount = Number(localStorage.clickcount) + 1;
			} else {
				localStorage.clickcount = 1;
			}

			document.getElementById("clicks").innerHTML = localStorage.clickcount;
		} else {
			document.getElementById("clicks").innerHTML = "Sorry";
		}
	

	function showCounter() {
		document.getElementById("clicks").innerHTML = localStorage.clickcount;
	}
</script>*/

  
$(document).ready(main);