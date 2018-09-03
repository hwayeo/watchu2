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
$('#genreModify').on('show.bs.modal', function(e) {

    //get data-id attribute of the clicked element
    var genre_num = $(e.relatedTarget).data('book-id');

    //populate the textbox
    $(e.currentTarget).find('input[name="bookId"]').val(bookId);
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