<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 장르 등록 및 수정 -->
<div class="admin_main">
	<div id="genre_list">
		<h2>영화 장르 목록</h2>
		<br>
		<div class="content-header">
			<!-- 검색 -->
			<select name="category">
				<option value="genre_num">장르 코드</option>
				<option value="genre_name">장르명</option>
			</select> <input type="text"> <input type="button" value="검색"><br>
			<Br>
		</div>

		<div class="content-body">
			<!-- 장르 목록 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-3">장르 코드</th>
					<th class="col-md-7">장르명</th>
					<th class="col-md-2">선택</th>
				</tr>
				<tr>
					<td>00</td>
					<td>스릴러</td>
					<td><input type="checkbox" name="checked"></td>
				</tr>
			</table>
			<br>

			<!-- 장르 등록 및 삭제버튼 -->
			<div class="edit_btn" align="right">
				<input type="button" value="장르 등록" id="register_genre" data-toggle="modal" data-target="#genreModal">
				<input type="submit" value="선택 삭제" id="delete_genre">
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

<!-- 장르 등록 모달창 -->
<div class="modal fade" id="genreModal" tabindex="-1" role="dialog" aria-labelledby="genreModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title" id="genreModalLabel">장르 등록</h4>
        </div>
        <div class="modal-body">
        
		<form:form commandName="command" action="genreList.do" id="genre_form">
         	<div class="form-group">
         		<form:hidden path="genre_num"/>
         	</div>
         	<div class="form-group">
         		<label for="genre">장르명</label>
         		<form:input path="genre"/>
         		<form:errors path="genre" cssClass="error-color"/>
         		<!-- 장르명 중복체크 -->
         	</div>
         	
        <div class="modal-footer">
        	<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        	<button type="submit" class="btn btn-default">전송</button>
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
</div>
