<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
   $(function(){
	   
	 //인증번호 받기 버튼 클릭 이벤트
	   $('#sendCertify_btn').on('click',function(){
	   	var mem_id = $('#inputId').val();
	   	var mem_name = $('#inputName').val();
	   	var mem_mail = $('#inputEmail').val();
	   	var userInfo = '{"mem_id":"' + mem_id + '", "mem_name":"' + mem_name + '", "mem_mail":"'+mem_mail+'"}';
	   	
 		$.ajax({
            method : "post",
            url : "${pageContext.request.contextPath}/findInfo/matchFindPassword",
            data : userInfo,
           	contentType : "application/json; charset=UTF-8",
           	dataType : "text",
            success : function(result){
            	//일치하는 경우 인증번호 보내기
            	if(result =="yes"){
            		$("#infoMent").text("");
            		$("#inputCertify").prop("readonly",false);
            		$("#infoMent").append("인증번호를 메일주소로 전송했습니다. 인증번호를 입력해주세요");
            	}else{
            		$("#infoMent").text("");
            		$("#infoMent").append("메일을 못받으셨다면 이름과 이메일을 확인해 주시길 바랍니다.");
            		$("#inputCertify").prop("readonly",true);
            	}
            },
            error : function(xhr){
            	alert("상태 : "+ xhr.status);
            } 
		});
		   
	   });
	   
	   //비밀번호 찾기 버튼 클릭 이벤트
	   $('#findPassword_btn').on('click',function(){
		   $('#findPasswordForm').submit();
	   });
   })

</script>
<!-- 가운데 공간 -->
<div>
<!-- 회원가입 상단 부분 -->
    <div class="row">
        <p></p>
        <div class="col-md-12">
        	<h3>비밀번호 찾기</h3>
        </div>
    </div>
    <hr>
<!-- 본문 부분 -->    
    <form class="form-horizontal" action="${pageContext.request.contextPath}/findInfo/resetPasswordForm" id="findPasswordForm" role="form" method="post" autocomplete="off">
    	
        <div class="form-group">
            <div class="col-lg-12">
                가입 정보와 가입시 입력한 이메일을 입력해 주세요.<br>
				해당 아이디의 가입정보와 회원님께서 입력한 정보가 일치 하여야 인증번호를 받을 수 있습니다.
            </div>
        </div>
        <div class="form-group">
          <label for="inputName" class="col-lg-2 control-label">이름</label>
          <div class="col-lg-6">
              <input type="text" class="form-control" id="inputName" name="mem_name" placeholder="이름을 입력하세요" >
          </div>
        </div>
        <div class="form-group">
          <label for="inputId" class="col-lg-2 control-label">아이디</label>
          <div class="col-lg-6">
              <input type="text" class="form-control" id="inputId" name="mem_id" placeholder="ID를 입력하세요" value="${userId}">
          </div>
        </div>
        <div class="form-group">
          <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
          <div class="col-lg-6">
              <input type="email" class="form-control" id="inputEmail" name="mem_mail" placeholder="이메일을 입력하세요">
          </div>
          <div class="col-lg-2">
              <input type="button" class="form-control" id="sendCertify_btn" value="인증번호 받기">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-2 control-label"></label>
          <div id="infoMent" class="col-lg-6">
          	
          </div>
        </div>
        <div class="form-group" id="divYesNumber">
          <label class="col-lg-2 control-label"></label>
          <div class="col-lg-6">
              <input type="text" class="form-control" id="inputCertify" name="join_certify" placeholder="인증번호를 입력해주세요" readonly="readonly">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-2 control-label"></label>
          <div class="col-lg-6">
              <input type="button" class="form-control btn-success" id="findPassword_btn" value="비밀번호 찾기">
          </div>
        </div>
	</form>
</div>	