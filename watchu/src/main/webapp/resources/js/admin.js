//장르 검색
$(document).ready(function(){
	//검색 유효성 체크
	$('#genre_search').submit(function(){
		if($('#keyword').val() == ''){
			alert('검색어를 입력하세요!');
			$('#keyword').focus();
			return false;
		}
	});

//genreModify 모달에 데이터 넘기기
	$('.modify_btn').on('click', function () {
		var num = $(this).attr('data-whatever');
		var data = $(this).text();
		$('#genre_num').val(num);
		$('#show-num').text(num);
		$('#name').val(data);
		//장르 삭제 버튼
		var modify = "location.href='genreDelete.do?genre_num=";
		var modifyUrl = modify+num+"'";
		$('#modifyBtn').attr("onclick", modifyUrl);
	});

//======감독_자동완성=====//
var directorList = new Array();
$('.auto_director').keyup(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'DIRECTOR';
	
	director_List(keyword,keyfield);
});
$('.auto_director').keydown(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'DIRECTOR';
	
	director_List(keyword,keyfield);
	
	if (event.keyCode === 13) {
        event.preventDefault();
    }
});
$('.auto_director').keypress(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'DIRECTOR';
	
	director_List(keyword,keyfield);
});

function director_List(keyword,keyfield){
	$.ajax({
		type: 'post',
		url: '/watchu/admin/auto_offList.do',
		data: {keyword:keyword,keyfield:keyfield},
		dataType: 'json',
		success: function (data) {
			directorList = [];
			$(data).each(function (index, element) {
				$(element.list).each(function (index, value) {
					directorList.push(value.name);
					$('.auto_director').autocomplete({source: directorList});
				});
			});
		},
		error:function(){
			console.log('목록 호출 실패');
		}
	});	
}

//======배우_자동완성=====//
var actorList = new Array();
$('.auto_actor').keyup(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'ACTOR';
	
	actor_List(keyword,keyfield);
});
$('.auto_actor').keydown(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'ACTOR';
	
	actor_List(keyword,keyfield);
	
	//배우 목록
	var actor_value = new Array();
	if (event.keyCode === 13) {
		event.preventDefault();
		$(this).each(function(){
			actor_value += $(this).val() + ", ";
		});
		$('.input_actor').val(actor_value);
		$('.auto_actor').val('').focus();
    }
});
$('.auto_actor').keypress(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'ACTOR';
	
	actor_List(keyword,keyfield);
});

function actor_List(keyword,keyfield){
	$.ajax({
		type: 'post',
		url: '/watchu/admin/auto_offList.do',
		data: {keyword:keyword,keyfield:keyfield},
		dataType: 'json',
		success: function (data) {
			actorList = [];
			$(data).each(function (index, element) {
				$(element.list).each(function (index, value) {
					actorList.push(value.name);
					$('.auto_actor').autocomplete({source: actorList});
				});
			});
		},
		error:function(){
			console.log('목록 호출 실패');
		}
	});	
}


});