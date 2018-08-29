<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 영화 목록(관리자 메인) -->
<div class="admin_main">
	<div id="movie_list">
		<h2>영화 목록</h2>
		<br>
		<div class="content-header">
			<!-- 검색 -->
			<select name="category">
				<option value="movie_name">영화명</option>
				<option value="movie_director">감독명</option>
				<option value="movie_actor">배우명</option>
				<option value="movie_genre">장르</option>
			</select> <input type="text"> <input type="button" value="검색"><br>
			<Br>
		</div>

		<div class="content-body">
			<!-- 영화 목록 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-2">번호</th>
					<th class="col-md-8">영화명</th>
					<th class="col-md-2">선택</th>
				</tr>
				<tr>
					<td>1</td>
					<td>제목</td>
					<td><input type="checkbox" name="checked"></td>
				</tr>
			</table>
			<br>

			<!-- 영화 등록 및 삭제버튼 -->
			<div class="edit_btn" align="right">
				<input type="button" value="영화 등록" id="register_movie"
					data-toggle="modal" data-target="#registerModal"> <input
					type="submit" value="선택 삭제" id="delete_movie">
			</div>
			<br>

			<!-- 페이지버튼 -->
			<nav align="center">
				<ul class="pagination pagination-sm">
					<li class="disabled"><a href="#" aria-label="Previous"> <spanaria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				</ul>
			</nav>
			<br>
		</div>
	</div>
</div>


<!-- 영화등록 모달창 -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<form:form commandName="movie_command" action="main.do" id="movie_form" enctype="multipart/form-data">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="registerModalLabel">영화 등록</h4>
			</div>
			<div class="modal-body">

				<div class="form-group">
					<label for="title">영화명</label>
					<form:input path="title"/>
					<form:errors path="title" cssClass="error-color"/>
				</div>
				<div class="form-group">
					<label for="country">제작 국가</label>
					<form:input path="country"/>
					<form:errors path="country" cssClass="error-color"/>
				</div>
				<div class="form-group">
					<label for="released">개봉연도</label>
					<input type="date" name="released" id="released">
				</div>
				<div class="form-group">
					<label for="director">감독</label>
					<form:input path="director"/>
					<form:errors path="director" cssClass="error-color"/>
				</div>
				<div class="form-group">
					<label for="actors">배우</label>
					<form:input path="actors"/>
					<form:errors path="actors" cssClass="error-color"/>
				</div>
				<div class="form-group">
					<label for="summary">줄거리</label>
					<form:textarea path="summary" cols="50" rows="3" />
					<form:errors path="summary" cssClass="error-color"/>
				</div>
				<div class="form-group">
					<label for="uploadPoster">포스터 사진</label>
	         		<input type="file" name="uploadPoster" id="uploadPoster"/>
				</div>
				<div class="form-group">
					<label for="uploadBanner">배너 사진</label>
	         		<input type="file" name="uploadBanner" id="uploadBanner"/>
				</div>
				<div class="form-group">
					<label for="main_genre">메인 장르</label>
					<form:input path="main_genre"/>
					<form:errors path="main_genre" cssClass="error-color"/>
				</div>
				<div class="form-group">
					<label for="sub_genre">서브 장르</label>
					<form:input path="sub_genre"/>
					<form:errors path="sub_genre" cssClass="error-color"/> 
				</div>
				<div class="form-group">
					<label for="trailer">예고편 코드</label>
					<form:input path="trailer"/>
					<form:errors path="trailer" cssClass="error-color"/>
				</div>
			</div>
<!-- 			http://bbiyakbbiyak.tistory.com/1 참고	
				<div class="form-group">
					<label for="genre1">장르1</label>
					<select name="main_category">
						<option value="crime">범죄</option>
						<option value="drama">드라마</option>
						<option value="SF">SF</option>
						<option value="romance">로맨스</option>
					</select>
					<label for="genre2">장르2</label>
					<select name="sub_category">
						<option value="action">액션</option>
						<option value="comedy">코미디</option>
						<option value="thriller">스릴러</option>
						<option value="adventure">모험</option>
					</select>
				</div> -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="submit" class="btn btn-primary">등록</button>
			</div>
		</form:form>	
		</div>
	</div>
</div>
