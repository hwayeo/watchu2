$(document).ready(function(){
	var windowHeight;
	
	$(window).scroll(function(){
		windowHeight = $(document).scrollTop();
		
		if(windowHeight == 0){
		}
 	});
	
	function showBannerImage(){
		$('#img-test').css('background-image','url(imageView.do?id=deft)');
	};
	
	showBannerImage();
});