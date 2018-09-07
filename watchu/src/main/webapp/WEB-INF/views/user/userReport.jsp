<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<div id="page-register">
	<div id="form-register">
		<div class="text-center">
			<h3><b>신고페이지</b></h3>			
		</div>				
	</div>

<div class="container">  
         <div class="row"> 

            <div class="col-xs-12 col-md-12"><!-- 시작 -->
            
            	<div class="col-md-2">
            	</div>
            	
            	<div class="col-md-6">
            		
            		<form:form id="report_Form" commandName="reportCommand">
            			
            			
            			<div>
	            			<label>신고내용</label>
	            			<div>
	            				<form:textarea path="report_content"/>
	            			</div>
            			</div>
            			
            			<div >
                           <input type="submit" class="btn btn-primary" value="신고하기">
                           <input type="button" class="btn btn-primary" value="취소" onclick="location.href='userPage.do?id=${user2.id}'">
                       </div>
            		
            		</form:form>
            	</div>
            	
            	
            	<div class="col-md-2">
            	</div>
            
            
            </div><!-- 끝 -->
            
         </div>
         
</div>
</div>