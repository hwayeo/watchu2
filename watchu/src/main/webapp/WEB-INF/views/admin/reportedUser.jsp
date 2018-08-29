<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="admin-main">
	<div class="tab-pane" id="reported_user">
		<h2>회원 신고 내역</h2>
		<br>
		<div class="content-header">
			<!-- 처리여부 -->
			<input type="radio" name="status" value="all" checked> 전체 <input
				type="radio" name="status" value="incomplete"> 미처리<br>
			<Br> 
		</div>

		<div class="content-body">
			<!-- 회원 신고 내역 -->
			<table class="table table-hover table-condensed">
				<tr>
					<th class="col-md-2">번호</th>
					<th class="col-md-8">글 제목</th>
					<th class="">작성자</th>
				</tr>
				<tr>
					<td>1</td>
					<td>스포일러</td>
					<td>홍길동</td>
				</tr>
			</table>
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