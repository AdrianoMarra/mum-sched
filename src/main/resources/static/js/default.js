$(function() {
	
	var init = function() {
		activateMenu();
	};
	
	
	/* Identify the page and activate 
	 * the correct menu item */
	var activateMenu = function(){
		
	     var path = window.location.href;
	     $('ul a').each(function() {
	      if (this.href === path) {
	       $(this).addClass('active');
	      }
	     });
	};

	init();
});



