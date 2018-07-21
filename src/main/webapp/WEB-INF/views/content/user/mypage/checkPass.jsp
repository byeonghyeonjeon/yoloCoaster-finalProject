<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	$(function() {
		$("#update").click(function() {
			var tempPass = $('#mem_pass').val().trim();
			if (tempPass == "") {
				$("#mem_pass").attr("placeholder", "비밀번호를 입력해주세요");
				return;
			}
			$("#submitForm").submit();
		});

		$("#cancel").click(
				function() {
					$("#submitForm").attr("action",
							"${pageContext.request.contextPath}/myPage/main");
					$("#submitForm").submit();
				});
	});
</script>
<style>
.top-buffer { margin-top:100px; }
</style>
<div class="row row-sm-6 top-buffer">
</div>
<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="text-center">
					<h3>
						<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
						<form method="post" id="submitForm"	action="${pageContext.request.contextPath}/myPage/update">
							<div class="form-group col-md-12">
							<label for="pwd">Password:</label> 
							<input type="password" placeholder="${message}" class="form-control" id="mem_pass" name="mem_pass">
							<input type="hidden"   id="mem_id" name="mem_id" value="${mem_id}">
							<button type="button" id="update" class="btn btn-default">확인</button>
							<button type="button" id="cancel" class="btn btn-default">취소</button>
							</div>
						</form>
					</h3>
				</div>
			</div>
		</div>
	</div>
</div>

