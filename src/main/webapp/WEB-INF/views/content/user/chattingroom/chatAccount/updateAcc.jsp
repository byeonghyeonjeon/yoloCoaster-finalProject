<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
더치페이 업데이트 화면

 <script>
		$(function() {
			/*업데이트 사항 저장하고 조회 화면으로 이동  */
			$("#yesBtn").click(function() {
				$("#insertAcc").submit();
			});
	
			/*취소하고 목록으로 돌아가기*/
			$("#noBtn").click(function() {
				$("#insertAcc").attr("action","${pageContext.request.contextPath}/chatAccount/main");
				$("#insertAcc").submit();
			});
		});
	</script>
	
	<!--수정사항 작성-->
	작성페이지
<form class="form-horizontal" id="insertAcc" action="${pageContext.request.contextPath}/chatAccount/updateAccReg">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
</form>
	<!--수정사항 작성-->

<!--저장 완료 버튼  -->
  <button id="yesBtn" type="button" class="btn btn-default">저장</button>
<!--저장 취소 버튼  -->
  <button id="noBtn" type="button" class="btn btn-default">취소</button>