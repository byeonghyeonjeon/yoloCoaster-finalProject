<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(function() {
	$("#qnaInsert").click(function() {
		$("#insertQnaForm").submit();
	});

	$("#cancel").click(
			function() {
				$("#submitForm").attr("action",
						"${pageContext.request.contextPath}/qna/qnaMain");
				$("#insertQnaForm").submit();
			});
	
});
</script>
<style>

</style>
<h2> Q&A 작성 페이지 </h2>

<form id="insertQnaForm"
	action="${pageContext.request.contextPath}/qna/insertQnaReg" method="post">
	
	<div class="row">
		<h3>제목</h3>
        <div class="form-group">
            <div class="col-sm-12 col-md-12 col-lg-12">
                <input type="search" class="form-control" id="board_title" name="board_title" placeholder="제목을 입력해주세요">
            </div>
        </div>
    </div>
     <div class="row">
   
    	<div class="checkbox checkbox-info">
            <input type="radio" name="board_private" id="radio1" value="Y">
            <label for="radio1">공개</label>
        </div>
        <div class="checkbox checkbox-warning">
            <input type="radio" name="board_private" id="radio2" value="N">
            <label for="radio2">비공개</label>
        </div>
	</div>
    <div class="row">
		<h3>내용</h3>
        <div class="form-group">
            <div class="col-sm-12 col-md-12 col-lg-12">
            	<textarea class="form-control textarea" rows="3" name="board_content" id="board_content" placeholder="내용을 입력하세요"></textarea>
            </div>
        </div>
    </div>
   
	
	
	<div class="form-group">
		<button type="button" id="qnaInsert" class="btn btn-link">저장</button>
		<button type="button" id="cancel" class="btn btn-link">취소</button>
		
	</div>
</form>