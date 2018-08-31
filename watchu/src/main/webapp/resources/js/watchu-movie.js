$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	      
	//영화 홈 화면 출력
	function selectHome(pageNum,movie_num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('.mlist').empty();
			$('.mlist2').empty();
			$('.mlist3').empty();
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
						var mlist = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
						mlist += '<div class="thumbnail" onclick="location.href=\'movieDetail.do?movie_num='+item.movie_num+'\'"><img src="../resources/images/img4.jpg"></div>';
						mlist += '<div class="sub-category caption">';
						mlist += '<p class="ptitle">'+item.title+'</p>';
						mlist += '</div>';
						mlist += '</div>';
						
						$('.mlist').append(mlist);						
						$('.mlist2').append(mlist);
						$('.mlist3').append(mlist);
					});
				}
			},error:function(){
				alert('에러페이지');
			}
		});
	}
  selectHome(1,$('#movie_num').val());
  
  
  //영화 평가 화면
  function selectEva(pageNum){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('.mlist4').empty();
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
						var mlist4 = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
						mlist4 += '<div class="thumbnail"><img src="${pageContext.request.contextPath}/resources/images/'+item.poster_img+'"></div>';
						mlist4 += '<div class="sub-category caption">';
						mlist4 += '<p class="ptitle">'+item.title+'</h3>';
						mlist4 += '<p class="pgeren">★★★★☆</p>';
						mlist4 += '</div>';
						mlist4 += '</div>';
						
						$('.mlist4').append(mlist4);						
					});
				}
			},error:function(){
				alert('에러페이지');
			}
		});
	}
  selectEva(1);

  $('#mscroll').scroll(function(){
	  var scrollT = $(this).scrollTop();
	  var scrollH = $(this).height();
	  var contentH = $('.container').height();
	  
	  if(scrollT + scrollH >= contentH){
		  var pageNum = currentPage + 1;
		  selectData(pageNum,$('#movie_num').val());
	  }
  });
});