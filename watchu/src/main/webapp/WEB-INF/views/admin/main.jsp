<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 관리자 화면 레이아웃 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12" id="sidemenu">
				<!-- 상단메뉴 -->
				<ul class="nav nav-tabs">
					<li class="dropdown active"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">영화 관리 <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#movie_list" data-toggle="tab">영화 등록 및 수정</a></li>
							<li><a href="#movie_rating" data-toggle="tab">영화 별점 관리</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">회원 관리 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#user_list" data-toggle="tab">회원 등급 관리</a></li>
							<li><a href="#reported_user" data-toggle="tab">신고 회원 관리</a></li>
						</ul></li>
					<li><a href="#support" data-toggle="tab">고객지원</a></li>
				</ul>

				<!-- 내용 -->
				<div class="tab-content">
					<div class="tab-pane active" id="movie_list">
						<h2>영화 목록</h2>
						<br>
						<div class="content-header">
							<!-- 검색 -->
							<select name="category">
								<option value="movie_name">영화명</option>
								<option value="movie_director">감독명</option>
								<option value="movie_actor">배우명</option>
								<option value="movie_genre">장르</option>
							</select> <input type="text"> <input type="button" value="검색"><br><Br>
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
							</table><br>
							
							<!-- 영화 등록 및 삭제버튼 -->
							<div class="edit_btn" align="right">
								<input type="button" value="영화 등록" id="register_movie" data-toggle="modal" data-target="#registerModal">
								<input type="submit" value="선택 삭제" id="delete_movie">
							</div><br>
							
							<!-- 페이지버튼 -->
							<nav align="center">
  								<ul class="pagination pagination-sm">
   									<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
   									<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
  								</ul>
							</nav>
							<br>
						</div>
					</div>

					<div class="tab-pane" id="movie_rating">
						<h2>영화 별점 관리</h2>
					</div>
					
					<div class="tab-pane" id="user_list">
						<h2>회원 목록</h2>
						<br>
						<div class="content-header">
							<!-- 검색 -->
							<select name="category">
								<option value="user_name">이름</option>
								<option value="user_id">ID</option>
							</select> <input type="text"> <input type="button" value="검색"><br><Br>
						</div>

						<div class="content-body">
							<!-- 회원 목록 -->
							<table class="table table-hover table-condensed">
								<tr>
									<th class="col-md-2">번호</th>
									<th class="col-md-8">회원명</th>
									<th class="col-md-2">등급</th>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#modifyModal" data-toggle="modal">홍길동</a></td>
									<td><input type="number"></td>
								</tr>
							</table><br>
							
							<!-- 회원 등급 수정 -->
							<div class="edit_btn" align="right">
								<input type="submit" value="수정 저장" id="modify_level">
							</div>
							<br>
							
							<!-- 페이지버튼 -->
							<nav align="center">
  								<ul class="pagination pagination-sm">
   									<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
   									<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
  								</ul>
							</nav>
							<br>
						</div>
					</div>
					
					<div class="tab-pane" id="reported_user">
						<h2>회원 신고 내역</h2>
						<br>
						<div class="content-header">
							<!-- 처리여부 -->
							<input type="radio" name="status" value="all" checked> 전체
							<input type="radio" name="status" value="incomplete"> 미처리<br><Br>
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
							</table><br>
														
							<!-- 페이지버튼 -->
							<nav align="center">
  								<ul class="pagination pagination-sm">
   									<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
   									<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
  								</ul>
							</nav>
							<br>
						</div>
					</div>
					
					<div class="tab-pane" id="support">
						<h2>고객 문의 관리</h2>
						<br>
						<div class="content-header">
							<!-- 처리여부 -->
							<input type="radio" name="status" value="all" checked> 전체
							<input type="radio" name="status" value="incomplete"> 미처리<br><Br>
						</div>

						<div class="content-body">
							<!-- 고객 문의 내역 -->
							<table class="table table-hover table-condensed">
								<tr>
									<th class="col-md-4">
									<div class="dropdown">
            							<a href="#" class="dropdown-toggle" data-toggle="dropdown">카테고리<b class="caret"></b></a>
              							<ul class="dropdown-menu">
	                  						<li><a href="#">영화 등록 및 수정 요청</a></li>
	                  						<li><a href="#">이용 관련 문의</a></li>
	                  						<li><a href="#">회원 신고</a></li>
	                  						<li><a href="#">기타</a></li>
               							</ul>
           							</div>
									</th>
									<th class="col-md-8">글 제목</th>
								</tr>
								<tr>
									<td>개인정보</td>
									<td>비밀번호 변경
									<br>홍길동 | 2018-08-21</td>
								</tr>
							</table><br>
														
							<!-- 페이지버튼 -->
							<nav align="center">
  								<ul class="pagination pagination-sm">
   									<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
   									<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
  								</ul>
							</nav>
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 영화등록 모달창 -->
		<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
  			<div class="modal-dialog">
    		<div class="modal-content">
     		<div class="modal-header">
      			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        		<h4 class="modal-title" id="registerModalLabel">영화 등록</h4>
      		</div>
      		
      		<div class="modal-body">
      			<form id="register_form">
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
      				</div>
      				<div class="form-group">
      					<label for="movie_name">영화명</label>
      					<input type="text" name="movie_name" class="form-control"> <input type="button" value="중복체크">
      				</div>
      				<div class="form-group">
      					<label for="movie_year">개봉연도</label>
      					<input type="number" name="movie_year" class="form-control">
      				</div>
      				<div class="form-group">
      					<label for="movie_director">감독</label>
      					<input type="text" name="movie_director" class="form-control">
      				</div>
      				<div class="form-group">
      					<label for="movie_actor">주연배우</label>
      					<input type="text" name="movie_actor" class="form-control">
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
