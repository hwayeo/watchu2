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
});

//genreModify 모달에 데이터 넘기기
$(document).ready(function() {
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
});

//======자동완성=====//
$(function(){
	$("#auto_actor").autocomplete({
		minLength: 1,
		source: function(request, response){
			var param = {value:request.term};
			$.ajax({
				url: "/admin/auto",
				
			});
		}
	});
});
/*$(function(){
	var actorList = [
		"가나다",
		"가나",
		"가나다라",
		"가나바바",
		"가라마",
		"가위바위",
		"가ㅏ가가",
		"가어ㅏ악",
		"apple",
		"apply",
		"approve",
		"나라"
		];
	$("#auto_actor").autocomplete({
		source: actorList
	});
});
*/
$(function(){
	var directorList = [
		"박보검",
		"박한솔",
		"박찬욱",
		"박원영",
		"박박박"
	];
	$('#auto_director').autocomplete({source: directorList});
});
