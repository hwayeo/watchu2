$(document).ready(function(){
	
	$('.follow').click(function(){
		
		var id = $(this).attr('data-id');
		alert(id);
		
		$.ajax({
			url:'following.do',
			type:'post',
			data:{id:id},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'success'){				
					$(this).attr('class','unfollow').show();
					$(this).attr('class','follow').hide();
				}else{
					
				}			
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
	});
	
 
	$('#unfollow').click(function(){
		
	});
});
