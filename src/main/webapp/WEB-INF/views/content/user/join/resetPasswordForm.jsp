<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
   $(function(){
	   $('#reset_btn').on('click', function(){
		   var a = $('#inputpass').val().trim();
		   var s = $('#inputpass2').val().trim();
		   if(a.length>20){
			   alert("비밀번호가 너무 깁니다 \n다시 설정해주세요");
			   $('#inputpass').val("");
			   $('#inputpass2').val("");
			   $('#inputpass').focus();
			   return;
		   }
		   if(a == s){
			   //비밀번호가 일치하면 submit
			   $('#resetPassForm').submit();
		   }else{
			   alert("입력하신 비밀번호가 일치하지 않습니다. \n다시 설정해주세요");
			   $('#inputpass').val("");
			   $('#inputpass2').val("");
			   $('#inputpass').focus();
			   return;
			   
		   }
	   })
   })
</script>
<!-- 가운데 공간 -->
<div>
<!-- 회원가입 상단 부분 -->
    <div class="row">
        <p></p>
        <div class="col-md-12">
        	<h3>비밀번호 변경</h3>
        </div>
    </div>
    <hr>
<!-- 본문 부분 -->
	<form class="form-horizontal" action="${pageContext.request.contextPath}/findInfo/resetPassword" id="resetPassForm" method="post" autocomplete="off">
        <div class="form-group">
          <div class="col-lg-12">
              ${userId} 님의 비밀번호를 새로운 비밀번호로 변경합니다.
          </div>
        </div>    
        <div class="form-group">
          <label for="inputpass" class="col-lg-2 control-label">비밀번호</label>
          <div class="col-lg-4">
              <input type="password" class="form-control" id="inputpass" name="mem_pass" placeholder="변경할 비밀번호를 입력하세요">
          </div>
        </div>
        <div class="form-group">
          <label for="inputpass" class="col-lg-2 control-label">비밀번호 확인</label>
          <div class="col-lg-4">
              <input type="password" class="form-control" id="inputpass2" placeholder="비밀번호를 한번 더 입력하세요">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-2 control-label"></label>
          <div class="col-lg-4">
              <input type="button" class="form-control btn-success" id="reset_btn" value="비밀번호 변경">
              <input type="hidden" name="mem_id" value="${userId}">
          </div>
        </div>
	</form>
</div>	
