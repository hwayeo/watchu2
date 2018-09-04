$(document).ready(function(){
   $('.thumbnail').each(function(){
      //이미지에 마우스를 올렸을 시 평점 오버레이
      $(this).mouseover(function(){
         $(this).find('.overlay').css('display','block');
      });

      //이미지에서 마우스가 벗어날 시 원상태 복귀
      $(this).mouseout(function(){
         $(this).find('.overlay').css('display','none');
      });
   });
});