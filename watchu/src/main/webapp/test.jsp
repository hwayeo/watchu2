<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8"> 
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<script type="text/javascript">
$(function(){
	  $('.bxslider').bxSlider({
	    mode: 'fade',
	    captions: true,
	    slideWidth: 600
	  });
	});
</script>
</head>
<body>
	<div class="bxslider">
  <div><img src="/assets/images/coffee1.jpg" title="Funky roots"></div>
  <div><img src="/assets/images/coffee2.jpg" title="The long and winding road"></div>
  <div><img src="/assets/images/coffee3.jpg" title="Happy trees"></div>
</div>
</body>
</html>