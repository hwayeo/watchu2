<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 장르 등록 및 수정 -->
<div class="admin_main">
	<div id="genre_list">
		<h2>영화 장르 목록</h2>
		<br>
		<div class="content-header">
			<!-- 데이터 없을 경우 -->
			<c:if test="${genre_count == 0}">
			<div align="center">등록된 장르가 없습니다.</div><br><br>
			<div class="edit_btn" align="center">
				<input type="button" value="장르 등록" id="register_genre" data-toggle="modal" data-target="#genreModal">
			</div>
			</c:if>
			<c:if test="${genre_count > 0 }">
			<!-- 검색 -->
			<form action="genreList.do" id="genre_search" method="get">
			<select name="keyfield">
				<option value="genre_num">장르 코드</option>
				<option value="genre">장르명</option>
			</select>
			<input type="text" name="keyword" id="keyword"> 
			<input type="submit" value="검색">
			</form>
			<br><Br>
			
		</div>

		<div class="content-body">
			<!-- 장르 목록 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-2">장르 코드</th>
					<th class="col-md-8">장르명</th>
					<th class="col-md-2">선택</th>
				</tr>
				<c:forEach var="genre" items="${genre_list}">
				<tr>
					<td>${genre.genre_num}</td>
					<td>${genre.genre}</td>
					<td><input type="checkbox" name="checked"></td>
				</tr>
				</c:forEach>
			</table>
			<br>

			<!-- 장르 등록 및 삭제버튼 -->
			<div class="edit_btn" align="right">
				<input type="button" value="장르 등록" id="register_genre" data-toggle="modal" data-target="#genreModal">
				<input type="submit" value="선택 삭제" id="delete_genre">
			</div>
			<br>

			<!-- 페이지버튼 -->
			<div align="center">${pagingHtml}</div>
			<!-- <nav align="center">
				<ul class="pagination pagination-sm">
					<li class="disabled"><a href="#" aria-label="Previous"><span
							aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				</ul>
			</nav> -->
			</c:if>
			<br>
		</div>
	</div>
</div>

<!-- 장르 등록 모달창 -->
<div class="modal fade" id="genreModal" tabindex="-1" role="dialog" aria-labelledby="genreModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
		<form:form commandName="genre_command" action="genreList.do" id="genre_form">
        <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title" id="genreModalLabel">장르 등록</h4>
        </div>
        <div class="modal-body">
        
         	<div class="form-group">
         		<label for="genre">장르명</label>
         		<form:input path="genre"/>
         		<form:errors path="genre" cssClass="error-color"/>
         	</div>
        </div>
         	
        <div class="modal-footer">
        	<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        	<button type="submit" class="btn btn-default">등록</button>
        </div>
        </form:form>
		
		
			<%-- <form id="genre_form">
               <div class="form-group">
                  <label for="genre_num">장르 코드</label>
                  <input type="text" name="genre_code" class="form-control">
                  <input type="button" value="중복 체크">
               </div>
               <div class="form-group">
                  <label for="genre">장르명</label>
                  <input type="text" name="genre" class="form-control">
               </div>
            </form>
         </div>

         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
            <button type="button" class="btn btn-primary">등록</button>
         </div> --%>
   </div>
   </div>
</div>
