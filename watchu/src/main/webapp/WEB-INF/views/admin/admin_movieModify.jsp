<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modify">
	<h2>영화 상세 정보/수정</h2>
	<form:form commandName="movie_command" id="modify_form"
		action="admin_movieModify.do" enctype="multipart/form-data">
		<form:hidden path="movie_num" />
		<form:errors element="div" cssClass="error-color" />
		<div class="form-group">
			<label for="title">영화명</label>
			<form:input path="title" />
			<form:errors path="title" cssClass="error-color" />
		</div>
		<div class="form-group">
			<label for="country">제작 국가</label>
			<form:input path="country" />
			<form:errors path="country" cssClass="error-color" />
		</div>
		<div class="form-group">
			<label for="released">개봉연도</label> <input type="date" name="released"
				id="released">
		</div>
		<div class="form-group ui-widget">
			<label for="director">감독</label> <input type="text" name="director"
				class="auto" id="auto_director">
		</div>
		<div class="form-group ui-widget">
			<label for="actors">배우</label> <input type="text" name="actors"
				class="auto" id="auto_actor">
			<form:errors path="actors" cssClass="error-color" />
		</div>
		<div class="form-group">
			<label for="summary">줄거리</label>
			<form:textarea path="summary" cols="100" rows="5" />
			<form:errors path="summary" cssClass="error-color" />
		</div>
		<div class="form-group">
			<label for="uploadPoster">포스터 사진</label>
			<input type="file" name="uploadPoster" id="uploadPoster" />
			<c:if test="${!empty movie.uploadPoster}">
			<br><span>(${movie.uploadPoster})파일이 등록되어 있습니다.
			재 업로드 시 기존 파일은 삭제됩니다.</span>
			</c:if>
		</div>
		<div class="form-group">
			<label for="uploadBanner">배너 사진</label>
			<input type="file" name="uploadBanner" id="uploadBanner" />
			<c:if test="${!empty movie.uploadBanner}">
			<br><span>(${movie.uploadBanner})파일이 등록되어 있습니다.
			재 업로드 시 기존 파일은 삭제됩니다.</span>
			</c:if>
		</div>
		<div class="form-group">
			<label for="main_genre">메인 장르</label>
			<form:input path="main_genre" />
			<form:errors path="main_genre" cssClass="error-color" />
		</div>
		<div class="form-group">
			<label for="sub_genre">서브 장르</label>
			<form:input path="sub_genre" />
			<form:errors path="sub_genre" cssClass="error-color" />
		</div>
		<div class="form-group">
			<label for="trailer">예고편 코드</label>
			<form:input path="trailer" />
			<form:errors path="trailer" cssClass="error-color" />
		</div>
		<div class="edit_btn" align="right">
		<input type="submit" value="전송">
		<input type="button" onclick="location.href='movieList.do'" value="목록">
		</div>
	</form:form>
</div>