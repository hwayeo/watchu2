<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 영화 관계자 등록 및 수정 -->
<div class="admin_main">
	<div id="official_list">
		<h2>영화 관계자 목록</h2>
		<br>
		<div class="content-header">
			<!-- 검색 -->
			<select name="category">
				<option value="movie_name">주요영화명</option>
				<option value="movie_director">감독명</option>
				<option value="movie_actor">배우명</option>
			</select> <input type="text"> <input type="button" value="검색"><br>
			<Br>
		</div>

		<div class="content-body">
			<!-- 영화 목록 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-2">번호</th>
					<th class="col-md-4">영화명</th>
					<th class="col-md-2">감독명</th>
					<th class="col-md-2">배우명</th>
					<th class="col-md-2">선택</th>
				</tr>
				<tr>
					<td>1</td>
					<td>제목</td>
					<td>감독이름</td>
					<td>배우이름</td>
					<td><input type="checkbox" name="checked"></td>
				</tr>
			</table>
			<br>

			<!-- 영화 관계자 등록 및 삭제버튼 -->
			<div class="edit_btn" align="right">
				<input type="button" value="영화관계자등록" id="officials_movie"
					data-toggle="modal" data-target="#officialsModal">
				<!-- <input type="button" value="영화 등록" id="register_movie" data-toggle="modal" data-target="#registerModal"> -->
				<input type="submit" value="선택 삭제" id="delete_movie">
			</div>
			<br>

			<!-- 페이지버튼 -->
			<nav align="center">
				<ul class="pagination pagination-sm">
					<li class="disabled"><a href="#" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				</ul>
			</nav>
			<br>
		</div>
	</div>
</div>


<!-- 영화관계자 등록 모달창 -->
<div class="modal fade" id="officialsModal" tabindex="-1" role="dialog"
	aria-labelledby="officialsModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="officialsModalLabel">영화 등록</h4>
			</div>

			<div class="modal-body">
				<form id="officials_form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="jobs">직업</label> <select name="main_category">
							<option value="movie_director">영화감독</option>
							<option value="movie_actor">영화배우</option>
						</select>
					</div>

					<div class="form-group">
						<label for="name">이름</label> <input type="text" name="name"
							class="form-control">
					</div>

					<div class="form-group">
						<label for="movie_name">주요영화</label> <input type="text"
							name="movie_name" class="form-control">
					</div>
					<div class="form-group">
						<label for="movie_photo">사진</label> <input type="file"
							name="movie_photo" class="form-control">
					</div>

				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary">등록</button>
			</div>
		</div>
	</div>
</div>


</div>
