<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="page-register">
	<div id="form-register">
		<div class="text-center">
			<h3><b>신고접수</b></h3>			
		</div>				
	</div>
	
	<div class="container">  
         <div class="row"> 
            
            
            <div class="col-xs-12 col-md-12"><!-- 시작 -->
            	
				<div class="col-md-3">
				</div>
				
				<form:form commandName="reportCommand" action="report.do?id=${user2.id}" id="report_form">
					
					<div class="col-md-6" style="border:1px solid#e5e3e3;">
						<div class="form-group">
							<label>신고사유</label> 
							<select class="form-control" id="question_filename" name="question_filename">
								<option>욕설사용</option>
								<option>부적절한 내용</option>
								<option>기타</option>
							</select>
				        </div>
				       
						<div class="form group">
							<label>신고내용</label> 
							<div>
								<form:textarea path="report_content"/>					
							</div>
						
						</div>
						
						<div class="text-center">
							<input type="submit" class="btn btn-md btn-primary" value="접수">
							<input type="button" class="btn btn-primary" value="취소" onclick="location.href='userPage.do?id=${user2.id}'">
						</div>
					</div>
				</form:form>
				
				<div class="col-md-3">
				</div>
        	
          </div><!-- 끝 -->
    </div>
 </div>
</div>