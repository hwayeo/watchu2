var windowHeight;
var windowWidth;
$(document).ready(function(){
	windowHeight = $(document).scrollTop();
	windowWidth = $(document).width();

	//초기값
	headerClassControl();
	
	//브라우저 사이즈가 변동되었을때 동작
	$(window).on('resize',function(){
		windowWidth = $(document).width();
		windowHeight = $(document).scrollTop();
		headerClassControl();
	});

	//스크롤을 내리거나 올릴때 동작 //300
	$(window).on('scroll',function(){
		windowWidth = $(document).width();
		windowHeight = $(document).scrollTop();
		headerClassControl();
		if(windowHeight > 325 && windowWidth >= 768){
			$('#top-header').hide();
			$('#scroll-header').show();
		}else if(windowHeight <= 325 && windowWidth >= 768){
			$('#top-header').show();
			$('#scroll-header').hide();
		}
	});

	//메인 배너 이미지 교체 메서드
	function showBannerImage(){
		$('#img-test').css('background-image','url(imageView.do?id=deft)');
	};

	function headerClassControl(){
		if(windowWidth < 768){
			if(windowHeight < 20){
				$('.search-form').attr('class','form-group search-form-top');
			}else if(windowHeight >= 21){
				$('.search-form-top').attr('class','form-group search-form');
			}
		}else if(windowWidth >= 768){
			$('.search-form-top').attr('class','form-group search-form');
		}

	}

	showBannerImage();
});