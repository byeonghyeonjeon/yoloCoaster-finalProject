<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	$(function() {
		$("#qnaUpdate").click(function() {
			$("#updateQnaForm").submit();
		});

	});
</script>


<h2>Q&A 수정 페이지</h2>

<form id="updateQnaForm"
	action="${pageContext.request.contextPath}/qna/qnaUpdateReg" method="get">
	<div class="form-group">
		<button type="button" id="qnaUpdate" class="btn btn-default">수정</button>
	</div>
</form>

<a href="${pageContext.request.contextPath }/qna/qnaMain" role="button">취소</a>