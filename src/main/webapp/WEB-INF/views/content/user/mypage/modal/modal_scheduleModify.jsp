<%@page import="com.yolo.model.ScheduleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


 <script src="${pageContext.request.contextPath}/js/jscolor.js"></script>

<script>
	$(function() {
				
		
			
		$('#modifyDatePicker').datepicker({
		    maxViewMode: 1,
		    format: "yyyy-mm-dd",
		    todayBtn: "linked",
		    language: "kr",
		    autoclose: true,
		    todayHighlight: true,
		    beforeShowMonth: function(date){
		                  if (date.getMonth() == 8) {
		                    return false;
		                  }
           }
		});

		/* 시작일 DatePicker */
		$('#modifyModalInputDateStart').datepicker('option', 'onClose', function(selectedDate){
			$('#modifyModalInputDateEnd').datepicker('option', 'minDate', selectedDate);
		});
		
		
		
// 		/* 종료일 DatePicker*/
		$('#modifyModalInputDateEnd').datepicker('option', 'onClose', function(selectedDate){
			$('#modifyModalInputDateStart').datepicker('option', 'maxDate', selectedDate);
		});
		
		
			
		
		
		
		
	    
	    
	    
	    
	
	  })
</script>
<style>
    nav.navbar {
      background: linear-gradient(to right, #a1f276, #5ce09b);
    }

    .tobNavbarName {
      color: black;
    }

    .nav>li>a:focus,
    .nav>li>a:hover {
      background-color: #eee;
    }

    .navbar-header .navbar-toggle {
      background-color: #1BA39C;
    }

    .navbar-header .icon-bar {
      background-color: #5ce09b;
    }

    #searchForm {
      text-align: center;
    }

    @media (max-width: 768px) {
      #body {
        padding-top: 160px;
      }
    }

    @media (min-width: 768px) {
      #body,
      #leftbar,
      #rightbar {
        padding-top: 110px;
      }
    }

    #footer img {
      width: 60px;
    }

    #footer table {
      display: inline-block;
    }

    #footer td {
      padding-left: 10px;
      padding-right: 10px;
    }
    
    /* Remove the navbar's default margin-bottom and rounded borders */

    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */

    .row.content {
      height: 450px
    }

    /* Set gray background color and 100% height */

    .sidenav {
      padding-top: 20px;
      height: 100%;
    }

    /* Set black background color, white text and some padding */

    footer {
      background-color: #ffffff;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */

    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {
        height: auto;
      }
    }
  </style>


  <!-- Modal창 -->
  <div class="modal fade" role="dialog" aria-labelledby="modifyModalLabel" aria-hidden="true" id="modifyScheduleModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <form action="${pageContext.request.contextPath}/myCalendar/modifyScheduleModal" id="modifyCalenderModalFrm" class="form-horizontal" autocomplete="off">
          <input type="hidden" class="form-control" id="modifyModalSeq" name="schedule_seq">

        <!-- modal header(title) -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="modifyModalLabel">일정 수정</h4>
        </div>

        <!-- modal body (content) -->
        <div class="modal-body">


              <div class="form-group">
                <label for="inputTitle" class="col-sm-2 control-label">제목</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="modifyModalInputTitle" name="schedule_title" placeholder="일정 제목을 입력하세요">
                </div>
              </div>
              
			 <div id="modifyDatePicker" class="input-daterange input-group">
	              <div class="form-group">
	                <label for="inputDateStart" class="col-sm-2 control-label">시작일</label>
	                <div class="col-sm-10">
	                  <input type="text" class="form-control datepicker" id="modifyModalInputDateStart" name="schedule_start" placeholder="시작일을 입력하세요">
	                </div>
	              </div>
	
	              <div class="form-group">
	                <label for="inputDateEnd" class="col-sm-2 control-label">종료일</label>
	                <div class="col-sm-10">
	                  <input type="text" class="form-control datepicker" id="modifyModalInputDateEnd" name="schedule_end" placeholder="종료일을 입력하세요">
	                </div>
	              </div>
			 </div>
              
              <div class="form-group">
                <label for="inputColor" class="col-sm-2 control-label">라벨</label>
                <div class="col-sm-10">
                	<input id="modifyModalColor" class="form-control jscolor" name="schedule_label">
<!--                   <input type="color" class="form-control" id="detailColor"> -->
                </div>
              </div>

	              <div class="form-group">
	                <label for="modifyModalprivate" class="col-sm-2 control-label">공개설정</label>
	                <div class="col-sm-10">
	                  <div class="btn-group" data-toggle="buttons">
	                    <label class="btn btn-primary active">
	                      <input type="radio" name="schedule_private" value="Y" id="modifyModalOption1" autocomplete="off" checked>공개
	                    </label>
	                    <label class="btn btn-primary">
	                      <input type="radio" name="schedule_private" value="N" id="modifyModalOption2" autocomplete="off">비공개
	                    </label>
	                  </div>
	                </div>
	              </div>      
	                      
          		</div> <!-- modal-body 종료 --> 
          
				<div class="modal-footer">
					<div class="form-group">
			            <div class="col-sm-12" style="text-align: center;">
			                 <button type="submit" class="btn btn-success">수정</button>
			                 <button id="detailCancel" type="button" class="btn btn-default" data-dismiss="modal">취소</button>
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
  
  
  
