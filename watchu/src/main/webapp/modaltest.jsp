<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모달테스트</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setup.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin-main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>

        
            <div class="input-group pb-modalreglog-input-group">
                <button class="btn btn-primary pb-modalreglog-submit" data-toggle="modal" data-target="#myModal2">Register</button>
                
                <div class="col-xs-1 col-md-1">
				<a href="setup.do" class="glyphicon glyphicon-cog" data-toggle="modal" data-target="#myModal2"></a>
			    </div>
            </div>
            
            <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel">설정</h4>
                        </div>
                        <div class="modal-body">
                        <!--     여기부터 넣어라 -->
                        	<!--  <ul class="list-group">
                
                    <li class="list-group-item">
                        <div class="">
                             <a href="updateUser.do"><label>내 설정</label></a>
                        </div>                    
                    </li>
                    
                    <li class="list-group-item">
                    </li>
                    
  
                   <li class="list-group-item">
	                    
	                        <div class="">
	                           <a href="#"><label>공지사항</label></a>
	                        </div>                    
	                </li>
	                    
                   
	                <li class="list-group-item">    
	                        <div class="">
	                            <a href="#"><label>고객센터</label></a>
	                        </div>                    
	                          
                    </li>
                    
                    <li class="list-group-item">
                    </li>
                    
                    <li class="list-group-item">    
	                        <div class="">
	                            <a href="logout.do"><label>로그아웃</label></a>
	                        </div>                    
	                          
                    </li>
                    
                    <li class="list-group-item">    
	                        <div class="">
	                            <a href="#"><label>회원탈퇴</label></a>
	                        </div>                    
	                          
                    </li>
      				
      				
      				
                </ul> -->
					<form class="pb-modalreglog-form-reg">
                                <div class="form-group">
                                    <div id="pb-modalreglog-progressbar"></div>
                                </div>
                                <div class="form-group">
                                    <label for="email">email address</label>
                                    <div class="input-group pb-modalreglog-input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="email" class="form-control" id="inputemail" placeholder="email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password">password</label>
                                    <div class="input-group pb-modalreglog-input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" class="form-control" id="inputpws" placeholder="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="confirmpassword">confirm password</label>
                                    <div class="input-group pb-modalreglog-input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" class="form-control" id="inputconfirmpws" placeholder="confirm password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="country">country</label>
                                    <div class="input-group pb-modalreglog-input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                        <input type="text" class="form-control" id="countries" placeholder="country">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="age">age</label>
                                    <div class="input-group pb-modalreglog-input-group">
                                        <input id="age">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" id="ch" name="chs">
                                    i agree with <a href="#">terms and conditions.</a>
                                </div>
                            </form>
                               <!--  여기까지다 -->
					
				</div>
                        <div class="modal-footer text-center">
                            Watchu♥
                        </div>
                    </div>
                </div>
            </div>
     

    


<style>
    .pb-modalreglog-container
    {
        margin-top: 100px;
    }

    .pb-modalreglog-legend
    {
        text-align: center;
    }

    .pb-modalreglog-input-group
    {
        margin: auto;
    }

    .pb-modalreglog-submit
    {
        margin-left: 5px;
    }

    .pb-modalreglog-form-reg
    {
        text-align: center;
    }

    .pb-modalreglog-footer p
    {
        text-align: center;
        margin-top: 20px;
    }

    #pb-modalreglog-progressbar
    {
        border-radius: 2px;
    }
</style>

<script>
    $(function () {
        var progress = $("#pb-modalreglog-progressbar").shieldProgressBar({
            value: 0
        }).swidget();

        $('#inputEmail').change(function () {
            if ($('#inputEmail').val().length > 1) {
                progress.value(progress.value() + 15);
            } else {
                progress.value(progress.value() - 15);
            }
        });

        $('#inputPws').change(function () {
            if ($('#inputPws').val().length > 1) {
                progress.value(progress.value() + 15);
            } else {
                progress.value(progress.value() - 15);
            }
        });

        $('#inputConfirmPws').change(function () {
            if ($('#inputConfirmPws').val().length > 1) {
                progress.value(progress.value() + 15);
            } else {
                progress.value(progress.value() - 15);
            }
        });

        $('#countries').change(function () {
            if ($('#countries').val().length > 1) {
                progress.value(progress.value() + 15);
            } else {
                progress.value(progress.value() - 15);
            }
        });

        $('#age').change(function () {
            if ($('#age').val().length > 1) {
                progress.value(progress.value() + 15);
            } else {
                progress.value(progress.value() - 15);
            }
        });

        $('#ch').change(function () {
            if ($('input[name="chs"]:checked').length > 0) {
                progress.value(progress.value() + 25);
            } else {
                progress.value(progress.value() - 25);
            }
        });

        $("#age").shieldMaskedTextBox({
            enabled: true,
            mask: "00/00/0000",
            value: "19/03/1032"
        });
    })
</script>


</body>
</html>