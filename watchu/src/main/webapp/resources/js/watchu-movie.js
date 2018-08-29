$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	      
	//영화 목록 출력
	function selectData(pageNum){
		currentPage = pageNum; 
		
		if(pageNum == 1){
			$('#mlist').empty(); 
		}
		
		$.ajax({ 
			type:'post',
			data:{pageNum:pageNum},
			url:'movieMlist.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;
				
				if(count < 0 || list == null){
					alert('if문으로 빠짐');
				}else{
					$(list).each(function(index,item){
						var mlist = '<div class="col-sm-6 col-md-3" id="main-category">';
						mlist += '<a href="#" class="thumbnail"><img src="../resources/images/'+item.poster_img+'"></a>';
						mlist += '<div class="sub-category">';
						mlist += '<h4>'+item.title+'</h4>';
						mlist += '</div>';
						mlist += '</div>';
						
						$('#mlist').append(mlist);
					});
				}
			},error:function(){
				alert('에러페이지');
			}
		});
	}
	selectData(1);
});