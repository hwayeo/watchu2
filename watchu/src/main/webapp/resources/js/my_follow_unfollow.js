$(document).ready(function(){
	
	//팔로우
	$('.follow').click(function(){
		
		var preBtn = $(this);
		
		var follow_id = $(this).attr('data-id');
		var user_id = $('#user_id').val();
		
		$.ajax({
			url:'following.do',
			type:'post',
			data:{follow_id:follow_id,user_id:user_id},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					preBtn.parent().find('.unfollow').show(); //이벤트발생한 버튼의 부모영역에서 찾아야함
					preBtn.hide(); 
					
				}else{
					
				}			
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
	});
	
	
	//언팔
	$('.unfollow').click(function(){
		var preBtn = $(this);
		var unfollow_id = $(this).attr('data-id');
		var user_id = $('#user_id').val();
		
		$.ajax({
			url:'unfollow.do',
			type:'post',
			data:{unfollow_id:unfollow_id,user_id:user_id},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){
					preBtn.parent().find('.follow').show(); 
					preBtn.hide(); 
					
				}else{
					
				}			
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
		
	});
});