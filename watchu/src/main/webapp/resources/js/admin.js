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

//======자동완성=====//
$(function() {
	var directorList = [
		  "오다영",
		  "이정은"
	];
	$("#auto_director").autocomplete({
	    source: directorList
	});
});
$(function() {
	var actorList = [
		"가나다",
		"라마바",
		"한국"
	];
	$("#auto_actor").autocomplete({
		source: actorList
	});
});