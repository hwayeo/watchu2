<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="detail">
	<h2>영화 상세 정보</h2>
	<div class="movieView">
	<table width="100%">
		<tr>
			<td colspan="2">배너  banner_img</td>
		</tr>
			
		<tr>
        	<td rowspan="6" width="40%">포스터 poster_img</td>
        </tr>
        <tr>
			<td>${movie.movie_num} | ${movie.reg_date}</td>
		</tr>
        <tr>
            <td>${movie.title} | ${movie.released}</td>
		</tr>
        <tr>
            <td>${movie.main_genre} | ${movie.sub_genre} | ${movie.country}</td>
		</tr>
        <tr>
            <td>${movie.director}</td>
		</tr>
        <tr>
            <td>${movie.trailer}</td>
		</tr>
        
		<tr>
			<td colspan="2">${movie.actors}</td>
		</tr>
		<tr>
			<td colspan="2">${movie.summary}</td>
		</tr>
	</table>
	</div>
	<div class="edit_btn" align="right">
	<input type="button" onclick="#" value="수정">
	<input type="button" onclick="location.href='movieList.do'" value="목록">
	</div>
</div> 