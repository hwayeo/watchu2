<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="detail">
<!-- 장르 수정 모달창 -->
<div class="modal fade" id="genreModify" tabindex="-1" role="dialog" aria-labelledby="genreModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
		<form:form commandName="genre_command" action="genreDetail.do" id="modify_form">
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
   </div>
   </div>
</div>
</div>