<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="admin_main">
	<div id="user_list">
		<h2>회원 목록</h2>
		<br>
		<div class="content-header">
			<!-- 검색 -->
			<select name="category">
				<option value="user_name">이름</option>
				<option value="user_id">ID</option>
			</select> <input type="text"> <input type="button" value="검색"><br>
			<Br>
		</div>
 
		<div class="content-body">
			<!-- 회원 목록 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-2">회원 코드</th>
					<th class="col-md-2">아이디</th>
					<th class="col-md-3">회원명</th>
					<th class="col-md-2">누적 신고 수</th>
					<th class="col-md-2">누적 좋아요 수</th>
					<th class="col-md-1">선택</th>
				</tr>
				<tr>
					<td>1</td>
					<td>admin</td>
					<td>홍길동</td>
					<td>3</td>
					<td>12</td>
					<td><input type="checkbox"></td>
				</tr>
			</table>
			<br>

			<!-- 회원 등급 수정 -->
			<div class="edit_btn" align="right">
				<input type="submit" value="선택 삭제" id="modify_level">
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
	
	<!-- 회원 상세정보 모달창 -->
		<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel" aria-hidden="true">
  			<div class="modal-dialog">
    		<div class="modal-content">
     		<div class="modal-header">
      			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        		<h4 class="modal-title" id="modifyModalLabel">회원 상세 정보</h4>
      		</div>
      		
      		<div class="modal-body">
      			<form id="modify_form">
      				<div class="form-group">
      					<label for="user_id">회원 ID</label>
      					<input type="text" name="user_id" class="form-control">
      				</div>
      				<div class="form-group">
      					<label for="user_name">회원명</label>
      					<input type="number" name="user_name" class="form-control">
      				</div>
      				<div class="form-group">
      					<label for="user_email">이메일</label>
      					<input type="email" name="user_email" class="form-control">
      				</div>
      				<div class="form-group">
      					<label for="user_level">회원등급</label>
      					<input type="text" name="user_email" class="form-control">
      				</div>
      			</form>
      		</div>
      		
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">뒤로</button>
       			<button type="button" class="btn btn-primary">수정</button>
     		</div>
    		</div>
 		 </div>
		</div>
	
</div>