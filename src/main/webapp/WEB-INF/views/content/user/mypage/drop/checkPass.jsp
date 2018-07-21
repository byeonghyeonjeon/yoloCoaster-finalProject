<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<script>
	$(function() {
		$("#update").click(function() {
			$("#submitForm").submit();
		});
		
		$("#cancel").click(function() {
			$("#submitForm").attr("action","${pageContext.request.contextPath}/myPage/main");
			$("#submitForm").submit();
		});
	});
</script>

<div class="row">
	<div class="col-md-4"></div>
	<form method="post" id="submitForm"	action="${pageContext.request.contextPath}/myPageDrop/dropMemReg">
		<div class="form-group col-md-4">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" id="mem_pass" name="mem_pass">
			<button type="button" id="update" class="btn btn-default">확인</button>
			<button type="button" id="cancel" class="btn btn-default">취소</button>
	</form>
</div>
</div>
<div class="col-md-4"></div>