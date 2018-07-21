<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/datepicker.jsp" %>
 <script >
 
 $(function(){
	 
	 $('#chatDetailPageMove').on('click', function(){
		 console.log("chatDetailPageMove");
		 $('#chatSchedule_seq').val(deleteNum);
		 $('#frm').submit();
// 		 alert("상세정보 페이지로 이동합니다.");
		

	 });
	 
	 $('#chatScheduleModify').on('click', function(){
		 if(this){
			 $(this).attr("data-dismiss", "modal");
			 $('#chatModifyScheduleModal').modal({backdrop: "static"}, "show");
		 }
		 
	 });
	 
	 $('#chatScheduleDelete').on('click', function(){
		 if(this){
			 $(this).attr("data-dismiss", "modal");
			 $('#chatScheduleDeleteModal').modal({backdrop: "static"}, "show");
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

	<%@ include file="/WEB-INF/views/content/user/chattingroom/chatSchedule/modal/modal_chatScheduleModify.jsp" %>
	<%@ include file="/WEB-INF/views/content/user/chattingroom/chatSchedule/modal/modal_chatScheduleDelete.jsp" %>
	
  
  <form id="frm" action="${pageContext.request.contextPath}/myCalendar/scheduleDetailPage">
  	<input type="hidden" id="chatSchedule_seq" name="schedule_seq">
  </form>
  
  <!-- Modal창 -->
  <div class="modal fade" role="dialog" aria-labelledby="scheduleEventLabel" aria-hidden="true" id="chatScheduleEventClick">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- modal header(title) -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="scheduleEventClick">항목 선택</h4>
        </div>

        <!-- modal body (content) -->
        <div class="modal-body">
          
            <form action="" id="EventClick" class="form-horizontal" autocomplete="off">

				<div class="form-group groupHover">
					<label id="chatDetailPageMove" class="col-sm-12 control-label pointer" style="text-align: center;">일정 상세보기</label>
				</div><hr>
				
				<div class="form-group groupHover">
					<label id="chatScheduleModify" class="col-sm-12 control-label pointer" style="text-align: center;">일정 수정하기</label>
				</div><hr>
				
				<div class="form-group groupHover">
					<label id="chatScheduleDelete" class="col-sm-12 control-label pointer" style="text-align: center;">일정 삭제하기</label>
				</div><hr>

				<div class="form-group groupHover">
					<label class="col-sm-12 control-label pointer" style="text-align: center;" data-dismiss="modal">나가기</label>
				</div>

            </form>
        </div>

      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
  
  
  
