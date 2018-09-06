$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	var keyfield = $('#ajx_keyfield').val();
	var keyword = $('#ajx_keyword').val();;
		
		$('.glist').on('change',function(){
			var genre = $(this).find('option:selected');		
			console.log(genre.text());
			console.log(keyfield);
			console.log(keyword);
		});
	
	//영화 목록 화면
	function selectGenre(pageNum){
		currentPage = pageNum;

		if(pageNum == 1){
			$('.glist').empty();
		}

		$.ajax({ 
			type:'post',
			data:{pageNum:pageNum},
			url:'genreList.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;

				if(count < 0 || list == null){
				}else{
					$(list).each(function(index,item){
						var glist = '<option valie="'+item.genre_num+'">'+item.genre+'</option>';     
 
						$('.glist').append(glist);
					});
				}
			},error:function(){

			}
		});
	}
	selectGenre(1);

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
				}else{
					$(list).each(function(index,item){
						if(item.country != ''){
							var mlist = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
							mlist += '<div class="thumbnail" onclick="location.href=\'movieDetail.do?movie_num='+item.movie_num+'\'"><img src="../resources/images/img4.jpg"></div>';
							mlist += '<div class="sub-category caption">';
							mlist += '<p class="ptitle">'+item.title+'</p>';
							mlist += '</div>';
							mlist += '</div>';    
						}   
						if(item.country == '미국'){
							var mlist2 = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
							mlist2 += '<div class="thumbnail" onclick="location.href=\'movieDetail.do?movie_num='+item.movie_num+'\'"><img src="../resources/images/img4.jpg"></div>';
							mlist2 += '<div class="sub-category caption">';
							mlist2 += '<p class="ptitle">'+item.title+'</p>';
							mlist2 += '</div>';
							mlist2 += '</div>';
						}
						if(item.country == '한국' || item.country == '대한민국'){
							var mlist3 = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
							mlist3 += '<div class="thumbnail" onclick="location.href=\'movieDetail.do?movie_num='+item.movie_num+'\'"><img src="../resources/images/img4.jpg"></div>';
							mlist3 += '<div class="sub-category caption">';
							mlist3 += '<p class="ptitle">'+item.title+'</p>';
							mlist3 += '</div>';
							mlist3 += '</div>';
						}               
						$('.mlist').append(mlist);                  
						$('.mlist2').append(mlist2);
						$('.mlist3').append(mlist3);
					});
				}
			},error:function(){
			}
		});
	}
	selectHome(1,$('#movie_num').val());

	//영화 목록 화면
	function selectList(pageNum,movie_num,keyword,keyfield){
		currentPage = pageNum;

		if(pageNum == 1){
			$('.slist').empty();
		}

		$.ajax({ 
			type:'post',
			data:{pageNum:pageNum,keyfield:keyfield,keyword:keyword},
			url:'movieMlist2.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;

				if(count < 0 || list == null){
					var slist = '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
					slist += '검색 결과가 없습니다';
					slist += '</div>';
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

			}
		});
	}
	selectList(1,$('#movie_num').val(),keyword,keyfield);   

	//영화 평가 화면
	function selectEva(pageNum,movie_num,keyword,keyfield){
		var elist = '';
		currentPage = pageNum;

		if(pageNum == 1){
			$('#elist').empty();
		}

		$.ajax({
			type:'post',
			data:{pageNum:pageNum,keyfield:keyfield,keyword:keyword},
			url:'movieMlist2.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				count = data.count;
				rowCount = data.rowCount;
				var list = data.list;

				if(count < 0 || list == null){

				}else{
					$(list).each(function(index,item){
						elist += '<div class="col-sm-6 col-md-3 col-xs-6" id="main-category">';
						elist += '<div class="thumbnail">';
						elist += '<img src="../resources/images/img4.jpg" class="mimg">';
						elist += '<div class="overlay">';
						elist += '<div class="list-contents">';
						elist += '<p class="subtitle">'+item.title+'</p>';
						elist += '<p class="year">'+item.released+'</p>';
						elist += '<div class="starRating" data-num="'+item.movie_num+'">';
						elist += '<fieldset class="rating">';
						elist += '<input type="radio" id="star5" class="test-test" name="rating" value="5" data-num="'+item.movie_num+'"/>';
						elist += '<label class = "full" for="star5" title="Awesome - 5 stars"></label>';
						elist += '<input type="radio" id="star4half" name="rating" value="4.5" data-num="'+item.movie_num+'"/>';
						elist += '<label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>';
						elist += '<input type="radio" id="star4" name="rating" value="4" data-num="'+item.movie_num+'"/>';
						elist += '<label class = "full" for="star4" title="Pretty good - 4 stars"></label>';
						elist += '<input type="radio" id="star3half" name="rating" value="3.5" data-num="'+item.movie_num+'"/>';
						elist += '<label class="half" for="star3half" title="better than good - 3.5 stars"></label>';
						elist += '<input type="radio" id="star3" name="rating" value="3" data-num="'+item.movie_num+'"/>';
						elist += '<label class = "full" for="star3" title="Good - 3 stars"></label>';
						elist += '<input type="radio" id="star2half" name="rating" value="2.5" data-num="'+item.movie_num+'"/>';
						elist += '<label class="half" for="star2half" title="so so - 2.5 stars"></label> ';
						elist += '<input type="radio" id="star2" name="rating" value="2" data-num="'+item.movie_num+'"/>';
						elist += '<label class = "full" for="star2" title="not bad - 2 stars"></label>';
						elist += '<input type="radio" id="star1half" name="rating" value="1.5" data-num="'+item.movie_num+'"/>';
						elist += '<label class="half" for="star1half" title="bad - 1.5 stars"></label>';
						elist += '<input type="radio" id="star1" name="rating" value="1" data-num="'+item.movie_num+'"/>';
						elist += '<label class = "full" for="star1" title="so bad - 1 star"></label>';
						elist += '<input type="radio" id="starhalf" name="rating" value="0.5" data-num="'+item.movie_num+'"/>';
						elist += '<label class="half" for="starhalf" title="Worst - 0.5 stars"></label>';
						elist += '</fieldset>';
						elist += '</div>';
						elist += '</div>';
						elist += '</div>';
						elist += '</div>';
						elist += '</div>';

					});
					$('#elist').append(elist);
				}
			},error:function(){
			}
		});
	}

	selectEva(1,$('#movie_num').val(),keyword,keyfield);

	//스크롤 이벤트 발생시 pageNum값을 증가 시킨다.
	$(window).scroll(function(){
		if($(window).scrollTop() == $(document).height() - $(window).height()){ 
			if(currentPage>=Math.ceil(count/rowCount)){
			}else{
				console.log("keyfield : "+keyfield);
				console.log("keyword : "+keyword);
				console.log("page : "+currentPage);
				console.log("count : "+count);
				console.log("rowCount : "+rowCount);

				pageNum = currentPage + 1;
				selectList(pageNum,$('#movie_num').val(),keyword,keyfield);
				selectEva(pageNum,$('#movie_num').val(),keyword,keyfield);
			}
		}
	});
});