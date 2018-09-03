<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="detail">
	<h2>영화 상세 정보</h2>
	<div class="movieView">
	<div class="banner_img">
	${movie.uploadBanner}
	<c:if test="${movie.uploadBanner == null}">
	등록된 배너 이미지 없음
	</c:if>
	</div>
	<table>
		<tr>
        	<td width="40%">
        	<div class="poster_img">
        	${movie.uploadPoster}
        	<c:if test="${movie.uploadPoster == null }">
        	등록된 포스터 없음
        	</c:if>
        	</div>
        	</td>
        	<td>
        		<ul>
        			<li><b>등록번호 </b>${movie.movie_num} | <b>등록일 </b>${movie.reg_date}</li>
        			<li><b>영화명 </b>${movie.title} | <b>개봉연도 </b>${movie.released}</li>
        			<li><b>메인 장르 </b>${movie.main_genre} | <b>서브 장르 </b>${movie.sub_genre} | <b>제작 국가 </b>${movie.country}</li>
        			<li><b>감독 </b>${movie.director}</li>
        			<li><b>예고편 </b>${movie.trailer}</li>
        			<%-- <label for="title">영화명</label>
        			<form:input path="title" />
					<form:errors path="title" cssClass="error-color" /> | 
					<label for="released">개봉연도</label>
					<input type="date" name="released" id="released"></li>
        			<li><label for="main_genre">메인 장르</label>
        			<form:input path="main_genre" />
        			<form:errors path="main_genre" cssClass="error-color" /> | 
        			<label for="sub_genre">서브 장르</label>
        			<form:input path="sub_genre" />
        			<form:errors path="sub_genre" cssClass="error-color" /> | 
        			<label for="country">제작 국가</label>
        			<form:input path="country" />
        			<form:errors path="country" cssClass="error-color" /></li>
        			<li><label for="director">감독</label>
        			<input type="text" name="director" class="auto" id="auto_director"></li>
        			<li><label for="trailer">예고편 코드</label>
        			<form:input path="trailer" />
        			<form:errors path="trailer" cssClass="error-color" /></li> --%>
        		</ul>
        	</td>
        </tr>
        
		<tr>
			<td colspan="2">출연배우</td>
		</tr>
		<tr>
			<td colspan="2">
			<div class="actors">
			<c:if test="${!empty movie.actors}">
			${movie.actors} 
			</c:if>
			<c:if test="${movie.actors == null}">
			등록된 출연배우 없음
			</c:if>
			</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">줄거리</td>
		</tr>
		<tr>
			<td colspan="2">
			<div class="summary">
			<c:if test="${!empty movie.summary}">
			${movie.summary}
			</c:if>
			<c:if test="${movie.summary == null}">
			등록된 줄거리 없음
			</c:if>
			</div>
			</td>
		</tr>
	</table>
	
	</div>
	<div class="edit_btn" align="right">
	<input type="button" onclick="location.href='admin_movieModify.do?movie_num=${movie.movie_num}'" value="수정">
	<input type="button" onclick="location.href='movieList.do'" value="목록">
	</div>
</div> 