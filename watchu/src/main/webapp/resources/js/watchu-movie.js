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
  
  //영화 목록 화면
  function selectList(pageNum,movie_num,keyword,keyfield){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('.sList').empty();
		}
		
		$.ajax({ 
			type:'post',
			data:{pageNum:pageNum,movie_num:movie_num,keyword:keyword,keyfield:keyfield},
			url:'movieMlist.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				keyword = data.keyword;
				keyfield = data.keyfield;
				var list = data.list;
				
				if(count < 0 || list == null){
					alert('if문으로 빠짐');
				}else if(keyfield == 'title'){
					
				}else{
					$(list).each(function(index,item){
						var slist = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
						slist += '<div class="thumbnail" onclick="location.href=\'movieDetail.do?movie_num='+item.movie_num+'\'"><img src="../resources/images/img4.jpg"></div>';
						slist += '<div class="sub-category caption">';
						slist += '<p class="ptitle">'+item.title+'</p>';
						slist += '<p class="pgeren">'+item.country+'</p>';
						slist += '</div>';
						slist += '</div>';
						
						$('.slist').append(slist);
					});
				}
			},error:function(){
				alert('에러페이지');
			}
		});
	}
  selectList(1,$('#movie_num').val());
  
  //영화 평가 화면
  function selectEva(pageNum,movie_num){
		currentPage = pageNum;
		
		if(pageNum == 1){
			$('.eList').empty();
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
						var elist = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
						elist += '<div class="thumbnail"><img src="../resources/images/img4.jpg"></div>';
						elist += '<div class="sub-category caption"> ';
						elist += '<p class="ptitle">'+item.title+'</p>';
						elist += '<p class="ptitle">'+item.reg_date+'</p>';
						elist += '<p class="pgeren">★★★★☆</p>';
						elist += '</div>';
						elist += '</div>';
						
						$('.elist').append(elist);						
					});
				}
			},error:function(){
				alert('에러페이지');
			}
		});
	}
  $(window).scroll(function(){
	   if($(window).scrollTop() == $(document).height() - $(window).height()){ 
		   
		   console.log("1 : "+currentPage);
		   console.log("3 : "+count);
		   console.log("4 : "+rowCount);
		   
		   
		if(currentPage>=Math.ceil(count/rowCount)){
			
		}else{
			/*if(currentPage < 5){
				var pageNum = currentPage + 6;
				selectList(pageNum,$('#movie_num').val());
				selectEva(pageNum,$('#movie_num').val(),keyfield,keyword);
			}else{*/
				pageNum = currentPage + 1;
				selectList(pageNum,$('#movie_num').val());
				selectEva(pageNum,$('#movie_num').val());
		}		
	   }
	});
  
});