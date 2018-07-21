<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	$(function() {
		$("#drop").click(function() {
			var check1=$("#check1").is(':checked');
			check2=$("#check2").is(':checked');
			check3=$("#check3").is(':checked');
			check4=$("#check4").is(':checked');

			if(check1&&check2&&check3&&check4){
				$("#submitForm").submit();
			}else{
				alert("항목에 동의해주세요");
				return;
			}
		});

		$('checkbox').prop('indeterminate', true)
		
		$("#cancel").click(function() {	$("#submitForm").attr("action",
							"${pageContext.request.contextPath}/myPage/main");
					$("#submitForm").submit();
				});
		
		
			
	
		
	});
</script>
<style>
.mem_id{
font-size: 20px;
 color: #ff3300;
}
.custom-control-label{
color: #005c99;

}
</style>

<div class="row">

<div class="col-sm-8 col-sm-offset-2">


		<br><br>
		

		<h1 class="custom-control-label display-3">탈퇴 안내</h1>
		<p class="custom-control-label lead">회원탈퇴를 진행하기 전에 안내 사항을 꼭 확인해 주세요</p>
		
		
		
		<br>
		
		
		<div class="custom-control custom-checkbox">
		  <input type="checkbox" class="custom-control-input" id="check1">
		  <label class="custom-control-label" for="customCheck1"><p>사용하고 계시는 아이디 '<span class="mem_id">${mem_id }</span>' 는 탈퇴할 경우 재사용 및 복구가 불가능 합니다.</p></label>
		</div>
		
		<br>
		
		<div class="custom-control custom-checkbox">
		  <input type="checkbox" class="custom-control-input" id="check2">
		  <label class="custom-control-label" for="customCheck1"><p>탈퇴 후 회원 정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</p></label>
		</div>
		
		<br>
		<br>
		
		<div class="custom-control custom-checkbox">
		  <input type="checkbox" class="custom-control-input" id="check3">
		  <label class="custom-control-label" for="customCheck1"><p>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아있습니다.</p></label>
		</div>
		 <p class="custom-control-label">삭제를 원하는 게시글이 있다면 반드시 탈퇴전 비공개 처리나 삭제하시기 바랍니다</p>
		
		<br>
		<br>

		<div class="custom-control custom-checkbox">
		  <input type="checkbox" class="custom-control-input" id="check4">
		  <label class="custom-control-label" for="customCheck1"><p >탈퇴 후에는 아이디()로 다시 가입할수 없으며 아이디와 데이터는 복구 할 수 없습니다.</p></label>
		</div>
		<p class="custom-control-label">게시판형 서비스에 남아있는 게시글은 탈퇴 후 삭제 할 수 없습니다.</p>
		<p class="custom-control-label">안내사항을 모두 확인하였으며, 이에 동의합니다.</p>
		
		
		<br>
		<br>
		
		<form method="post" id="submitForm"
			action="${pageContext.request.contextPath}/myPageDrop/dropMemCheckPass">
			<div class="form-group col-sm-8 col-sm-offset-2">
				<button type="button" id="drop" class="btn btn-default">동의합니다</button>
				<button type="button" id="cancel" class="btn btn-default">취소</button>
		</form>
	</div>
		
</div><!--end row-->


		


