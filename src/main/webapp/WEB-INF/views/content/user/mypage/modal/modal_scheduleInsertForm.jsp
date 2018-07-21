<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script src="${pageContext.request.contextPath}/js/jscolor.js"></script>

<script>
	var date = new Date();

	// 	var toDay = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
	var today = moment().format('YYYY-MM-DD');

	$(function() {
		
	$('#endTimeAlert').hide();
	$('#startTimeAlert').hide();

		$('#insertDatePicker').datepicker({
			maxViewMode : 1,
			format : "yyyy-mm-dd",
			todayBtn : "linked",
			language : "kr",
			autoclose : true,
			todayHighlight : true,
			beforeShowMonth : function(date) {
				if (date.getMonth() == 8) {
					return false;
				}
			}
		});

		
		$('.modal-hide').on('click', function(){
			$('#startTimeAlert').hide();
			$('#endTimeAlert').hide();
		})

		$('#insertScheduleBtn').on('click', function() {

			if ($('#schedule_start').val().trim() == "") {
				$('#startTimeAlert').show();
				return;
			} else if ($('#schedule_end').val().trim() == "") {
				$('#endTimeAlert').show();
				return;	
			}
			
			if ($('#schedule_title').val().trim() == "") {
				$('#schedule_title').val(today + "일에 등록한 일정 입니다.");
			} else {
				$('#insertCalenderModal').submit();
			}

		})
		

	})
</script>
<style>
nav.navbar {
	background: linear-gradient(to right, #a1f276, #5ce09b);
}

.tobNavbarName {
	color: black;
	78
	i
}

.nav>li>a:focus, .nav>li>a:hover {
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

@media ( max-width : 768px) {
	#body {
		padding-top: 160px;
	}
}

@media ( min-width : 768px) {
	#body, #leftbar, #rightbar {
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
<div class="modal fade" role="dialog"	aria-labelledby="gridSystemModalLabel" aria-hidden="true" id="inserScheduleModel">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- modal header(title) -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="gridSystemModalLabel">일정 생성</h4>
			</div>

			<!-- modal body (content) -->
			<div class="modal-body">
				<div class="container-fluid">

					<form
						action="${pageContext.request.contextPath}/myCalendar/insertSche"	method="post" id="insertCalenderModal" class="form-horizontal"
						autocomplete="off">
						<div class="form-group">
							<label for="inputTitle" class="col-sm-2 control-label">제목</label>
							<div class="col-sm-10">
								<input type="text" class="form-control modal-hide" name="schedule_title" id="schedule_title" placeholder="일정 제목을 입력하세요">
							</div>
						</div>

						<div id="insertDatePicker" class="input-daterange input-group">
							<div class="form-group">
								<label for="inputDateStart" class="col-sm-2 control-label">시작일</label>
								<div class="col-sm-10">
									<input type="text" class="form-control modal-hide" name="schedule_start" id="schedule_start" placeholder="시작일을 입력하세요">
								</div>
							</div>

							<div class="form-group">
								<label for="inputDateEnd" class="col-sm-2 control-label">종료일</label>
								<div class="col-sm-10">
									<input type="text" class="form-control modal-hide" id="schedule_end" name="schedule_end" placeholder="종료일을 입력하세요">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="inputColor" class="col-sm-2 control-label">라벨</label>
							<div class="col-sm-10">
								<input id="schedule_label" class="form-control jscolor modal-hide"	name="schedule_label" value="F3FFC4">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">공개설정</label>
							<div class="col-sm-10">
								<div class="btn-group modal-hide" data-toggle="buttons">
									<label class="btn btn-primary active">
									 <input	type="radio" name="schedule_private" value="Y" id="option1"	autocomplete="off" checked>공개
									</label> <label class="btn btn-primary">
									 <input type="radio" name="schedule_private" value="N" id="option2"	autocomplete="off">비공개
									</label>
								</div>
							</div>
						</div>


					</form>
				</div>
			</div>

			<div class="modal-footer">
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<button id="insertScheduleBtn" type="button" class="btn btn-success">일정 만들기</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		
			<div id="endTimeAlert" class="alert alert-warning">
				<strong>End Time!</strong> 종료일이 설정되지 않았습니다.
			</div>

			<div id="startTimeAlert" class="alert alert-warning">
				<strong>Start Time!</strong> 시작일이 설정되지 않았습니다.
			</div>
			

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
