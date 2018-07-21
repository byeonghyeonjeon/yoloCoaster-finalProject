<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>

</script>

<style>

</style>


  <!-- Modal창 -->
  <div class="modal fade" role="dialog" aria-labelledby="scheduleDeleteLabel" aria-hidden="true" id="scheduleDeleteModal">
    <div class="modal-dialog">
      <div class="modal-content">

       <form action="${pageContext.request.contextPath}/myCalendar/deleteScheduleModal" id="DeleteModal" class="form-horizontal" autocomplete="off">
          <input type="hidden" class="form-control" id="deleteModalSeq" name="schedule_seq">
	<!--  modal header(title) -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="scheduleDeleteLabel">일정 삭제</h4>
        </div>

        <!-- modal body (content) -->
        <div class="modal-body">
          <div class="container-fluid">
	            <div class="form-group">
	            	<label class="control-label">일정을 삭제 하시겠습니까?</label>
	            </div>
          </div>
        </div>
        
        <!-- modal footer ( footer ) -->
		<div class="modal-footer">
	        <div class="form-group">
	          <div class="col-sm-12" style="text-align: center;">
	            <button type="submit" class="btn btn-danger">삭제</button>
	            <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	          </div>
		    </div>
		</div>

       </form>


      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
  
  
  
