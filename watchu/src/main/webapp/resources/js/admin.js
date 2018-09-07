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

var director_value = $('.input_director').val();
var director_count = 0;
$('.auto_director').keydown(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'DIRECTOR';
	
	director_List(keyword,keyfield);
	
	//감독 목록
	if (event.keyCode === 13) {
		event.preventDefault();
		if(director_value != ''){
			director_count++;
			if(director_count > 0) director_value += ',';
			director_value += $(this).val();
			$('.input_director').val(director_value);
			$('.auto_director').val('').focus();
			director_count++;
			//수정 시 기존 값 지우고 새로 입력할 경우 기존 값도 다시 불러옴.. 왜...?
		}
		
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

var actor_value = $('.input_actor').val();
//var actor_count = 0;
$('.auto_actor').keydown(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'ACTOR';
	
	actor_List(keyword,keyfield);
	
	//배우 목록
	if (event.keyCode === 13) {
		event.preventDefault();
		if(actor_value != '') actor_value += ',';
		actor_value += $(this).val();
		$('.input_actor').val(actor_value);
		$('.auto_actor').val('').focus();
		//actor_count++;
    }
});

$('.auto_actor').keypress(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'ACTOR';
	
	actor_List(keyword,keyfield);
	$('.auto_actor').val('').focus();
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

//======장르_자동완성=====//
var genreList = new Array();
$('.auto_genre').keyup(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'genre';
	
	genre_List(keyword,keyfield);
});

$('.auto_genre').keydown(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'genre';

	genre_List(keyword,keyfield);
	
	if (event.keyCode === 13) event.preventDefault();
});

$('.auto_genre').keypress(function (event) {
	
	var keyword = $(this).val();
	var keyfield = 'genre';
	
	genre_List(keyword,keyfield);
});

function genre_List(keyword,keyfield){
	$.ajax({
		type: 'post',
		url: '/watchu/admin/auto_genreList.do',
		data: {keyword:keyword,keyfield:keyfield},
		dataType: 'json',
		success: function (data) {
			genreList = [];
			$(data).each(function (index, element) {
				$(element.genre_list).each(function (index, value) {
					genreList.push(value.genre);
					$('.auto_genre').autocomplete({source: genreList});
				});
			});
			console.log(genreList);
		},
		error:function(){
			console.log('목록 호출 실패');
		}
	});	
}

//======장르_선택항목 삭제=====//
function check_genreDelArr(){
	var c_genreArr = [];
	$("input[name:'genreChecked']:checked").each(function(i){
		c_genreArr.push($(this).val());
	});
	console.log(c_genreArr);
	$.ajax({
		url: ''
	});
	//https://m.blog.naver.com/PostView.nhn?blogId=genesis1343&logNo=220484120985&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
}


});