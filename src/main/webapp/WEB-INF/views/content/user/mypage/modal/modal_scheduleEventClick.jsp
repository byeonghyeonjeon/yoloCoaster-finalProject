<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/datepicker.jsp" %>
 <script >
 
 $(function(){
	 
	 $('#detailPageMove').on('click', function(){
		 console.log("detailPageMove");
		 $("#schedule_seq").val();
		 $('#frm').submit();
// 		 alert("상세정보 페이지로 이동합니다.");
	 });
	 
	 $('#scheduleModify').on('click', function(){
		 if(this){
			 $(this).attr("data-dismiss", "modal");
			 $('#modifyScheduleModal').modal({backdrop: "static"}, "show");
		 }
	 });
	 
	 $('#scheduleDelete').on('click', function(){
		 if(this){
			 $(this).attr("data-dismiss", "modal");
			 $('#scheduleDeleteModal').modal({backdrop: "static"}, "show");
		 }
	 });
	 
	 
	 
 })
 
</script>
<style>


.groupHover{

	text-align: center;
}

.groupHover:HOVER {
	background-color: #E0F8F1;
	
}

.pointer{
	cursor: pointer;
}

</style>

	<%@ include file="/WEB-INF/views/content/user/mypage/modal/modal_scheduleModify.jsp" %>
	<%@ include file="/WEB-INF/views/content/user/mypage/modal/modal_scheduleDelete.jsp" %>
	

  
  <form id="frm" action="${pageContext.request.contextPath}/myCalendar/scheduleDetailPage">
  		<input type="hidden" id="schedule_seq" name="schedule_seq">
  </form>
  
  <!-- Modal창 -->
  <div class="modal fade" role="dialog" aria-labelledby="scheduleEventLabel" aria-hidden="true" id="scheduleEventClick">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- modal header(title) -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="scheduleEventClick">항목 선택</h4>
        </div>

        <!-- modal body (content) -->
        <div class="modal-body">
          <div class="container-fluid">
          
            <form action="" id="EventClick" class="form-horizontal" autocomplete="off">
            	

				<div class="form-group groupHover">
					<label id="detailPageMove" class="col-sm-12 control-label pointer" style="text-align: center;">일정 상세보기</label>
				</div><hr>
				
				<div class="form-group groupHover">
					<label id="scheduleModify" class="col-sm-12 control-label pointer" style="text-align: center;">일정 수정하기</label>
				</div><hr>
				
				<div class="form-group groupHover">
					<label id="scheduleDelete" class="col-sm-12 control-label pointer" style="text-align: center;">일정 삭제하기</label>
				</div><hr>

				<div class="form-group groupHover">
					<label class="col-sm-12 control-label pointer" style="text-align: center;" data-dismiss="modal">나가기</label>
				</div>

            </form>
          </div>
        </div>

      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
  
  
  
