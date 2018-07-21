<%@page import="java.io.Writer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.yolo.model.ScheduleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<ScheduleVO> scheduleVO = null;
	if((List<ScheduleVO>)request.getAttribute("calendarList") != null){	
	scheduleVO =  (List<ScheduleVO>)request.getAttribute("calendarList"); 
	}
%>


<script type="text/javascript">

	var dragId = 0; // 드레드 선택했을때의 아이디d
	var endDay = "";
	var drop_end = "";
	var changeTimeTest = "";
	var lastDay = "";
	
	$(document).ready(function() {

		//즐겨찾기 항목을 가져오는 구문
		$('#external-events .fc-event').each(function() {

			// 즐겨찾기에서 끌어올렸을때 저장하는 구문
			$(this).data('event', {
				title : $.trim($(this).text()), // use the element's text as the event title
				stick : true,
				
			// maintain when user navigates (see docs on the renderEvent method)
			});

			// 즐겨찾기 항목을 선택 드랍할 수 있도록 해주는 구문
			$(this).draggable({
				scroll: true,
				zIndex : 999,
				revert : true, // 테이블 안으로 정렬해주는 구문 반드시 true로 되어 있어야 함
				revertDuration : 0	//  드래그 후 원래 위치로 이동
			});

		});/* 즐겨찾기 구문 종료 */

		/* -------------------------------------------------------------------------- */
		

		
		$('#calendar').fullCalendar({

			header : {
				left : "prev, next ",
				center : 'title',
				right : 'today',
			},
			
			eventDurationEditable  : false,  /* Resize 막기 */
			//택스트로 '다음달 / 이전달 표시방법 여부'
			buttonIcons : true, 
			
			//풀캘린더 상하 사이즈 조정
		    height: 750 ,
		    dragOpacity : 1.0,
			
			// 일자 클릭에 대한 메서드명 true시 선택가능
			navLinks : true,

			//drag 모션을 줄지 안줄지 여부 true면 드래그 가능
			editable : true,

			//즐겨찾기 창에서 꺼내오기
			droppable : true,
			
			//하루에 많은 일정이 있을경우 more로 표시하여 숨기기 (숨겼을때 +개수 표시)
			eventLimit : true, // allow "more" link when too many events
			events :
				[
				 
				 <%
				 	for(int i=0; i < scheduleVO.size(); i++ ){
				 		ScheduleVO schedule = scheduleVO.get(i);
				 	   	if(i > 0) out.print(",");
				 		%>
						 {
							 
							id 		: "<%=schedule.getSchedule_seq()%>",
							title 	: "<%=schedule.getSchedule_title()%>",
							start 	: "<%=schedule.getSchedule_start()%>",
							end 	: "<%=schedule.getSchedule_end().substring(0, 10)%> 24",
							color 	: "#<%=schedule.getSchedule_label()%>",
							textColor : "#000000",
							allDay:true
							
						}
				 		<%
				 	}
				 %>
				 
			],/* 배열 종료 */
			
			eventClick : function(event, jsEvent, view,date) {
				
				var yyyy = event.end._d.getFullYear();
				var mm = event.end._d.getMonth()+1;
				var dd = event.end._d.getDate()-1;
				lastDay = ( new Date( yyyy, mm, 0) ).getDate()
				if(dd == 0){
					dd = lastDay;
					mm = event.start._d.getMonth()+1;
					yyyy = event.start._d.getFullYear();
				}
				var dt_end = yyyy+"-"+mm+"-"+dd;
				var dt_endDay =  moment(dt_end).format("YYYY-MM-DD");
					
				$('#schedule_seq').val(event.id);
				$('#deleteModalSeq').val(event.id);
				$('#modifyModalSeq').val(event.id);
				$('#modifyModalInputTitle').val(event.title);
				$('#modifyModalInputDateStart').val(event.start.format());
				$('#modifyModalInputDateEnd').val(dt_endDay);
				$('#modifyModalColor').val(event.color.substring(1, 7))
									  .css("background", event.color);
				$('#scheduleEventClick').modal({backdrop: "static"}, 'show');
			},

			//해당 일자를 클릭했을때의 메서드 ( 빈공간 클릭했을때 )
			dayClick : function(date, jsEvent, view) {
				$('#schedule_start').val(date.format());
				$('#schedule_end').val("");
				$('#inserScheduleModel').modal({backdrop: "static"}, "show");

			}, /* dayClick 종료 */
			
			//월 숫자를 클릭했을때의 메서드
			navLinkDayClick : function(date, jsEvent) {
				$('#schedule_start').val(date.format());
				$('#inserScheduleModel').modal({backdrop: "static"}, "show");
			}, /* navLinkDayClick 종료 */
			
			// 이벤트를 선택했을때 일정의 아이디값을 전역변수로 옮긴다.
			eventDragStart : function(event, jsEvent){
				dragId = event.id;
			},	/* eventDragStart 종료 */
			
			// 이벤트를 놓았을때 놓은곳의 일정의 start시간과 end시간을 가지고 업데이트 한다.
			eventDrop : function(event, view){
				
				var yyyy = event.end._d.getFullYear();
				var mm = event.end._d.getMonth()+1;
				dd = event.end._d.getDate()-1;
				if(dd == 0){
					dd = lastDay;
					mm = event.start._d.getMonth()+1;
					yyyy = event.start._d.getFullYear()
				}
				lastDay = ( new Date( yyyy, mm, 0) ).getDate()
				
				var dt_end = yyyy+"-"+mm+"-"+dd;
				var drop_endDay =  moment(dt_end).format("YYYY-MM-DD");
				console.log("drop_endDay : " + drop_endDay )
				
				
				

				$.ajax({
					url: "${pageContext.request.contextPath}/myCalendar/dragScheduleModify",
					data : {
							"schedule_seq":dragId ,
							"schedule_start":event.start.format(),
							"schedule_end":drop_endDay
							},
					success : function(data){
						
					},error : function(xhr){
						console.log("dragScheduleModify : " + xhr.status)
					}
				})/* ajax 종료 */
				
				
			},
			
			drop : function(date, jsEvent, resourceId ) {
				
				var bookMarkTitle = $("input", this).attr("bookmark_title");
				var bookMarkStartEnd = date.format();
				var bookMark_seq = $("input", this).val();
				
				// 즐겨찾기 제외 체크했을때 삭제하는 명령문
				if ($('#drop-remove').is(':checked')) {
					
					$.ajax({
						url : "${pageContext.request.contextPath}/myCalendar/myCalendarBookMarkCheckDelete",
						data : {
							"schedule_title" : bookMarkTitle,
							"schedule_start" : bookMarkStartEnd,
							"schedule_end" : bookMarkStartEnd,
							"bookmark_seq" : bookMark_seq
						},
						dataType: "json",
						success : function(data1){
						
						},error : function(xhr1){
							console.log(" dropCheck 오류 : "+xhr.status);
						}
						
					})/* ajax End */
					$(this).remove();
				}else{
					$.ajax({
						url : "${pageContext.request.contextPath}/myCalendar/bookMarkScheduleInsert",
						data : {
							"schedule_title" : bookMarkTitle,
							"schedule_start" : bookMarkStartEnd,
							"schedule_end" : bookMarkStartEnd
						},
						dataType: "json",
						success : function(data2){
							
						},error : function(xhr2){
							console.log(" drop 오류 : "+xhr.status);
						}
						
					})
				}/* if문 End */
				

			} /* drop 종료 */

		}); 


	});
</script>
<style>


#external-events {
	margin: 40px auto;
	float: left;
	width: 220px;
	padding: 0 10px;
	border: 1px solid #ccc;
	text-align: left;
	height: 700px;
	z-index: 10;
}

#external-events h4 {
	font-size: 20px;
	text-align: center;
	padding: 0.5em;
}
.fc-event{
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 1; /* 라인수 (빨강되는게 맞음)*/
	-webkit-box-orient: vertical;
	color: black;
	background-color: lightgray;
	border-color: gray;
}


#external-events .fc-event {
	margin: 10px 0;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 10px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

.overList-scrollable{
	overflow-y: scroll;
	height: 600px;
	overflow-x: auto;
}

#size-calendar{
	margin: 48px 48px;
}

.fc-title{
	
	text-shadow: 0px 0 #FFFFFF, 0 1px #FFFFFF, 1px 0 #FFFFFF, 0 0px #FFFFFF;
	-moz-text-shadow: 0px 0 #FFFFFF, 0 1px #FFFFFF, 1px 0 #FFFFFF, 0 0px #FFFFFF;
	-webkit-text-shadow: 0px 0 #FFFFFF, 0 1px #FFFFFF, 1px 0 #FFFFFF, 0 0px #FFFFFF;
}

.glyphicon glyphicon-trash{
	width: 100px;
	height: 100px;
}


.fc-center h2{font-size: 20pt;}
.fc-sun {background-color:#FBEFEF}
.fc-sat {background-color:#EFF8FB}
</style>

	<%@ include file="/WEB-INF/views/content/user/mypage/modal/modal_scheduleInsertForm.jsp" %>
	<%@ include file="/WEB-INF/views/content/user/mypage/modal/modal_scheduleEventClick.jsp" %>

	<div>

		<div id="size-calendar" class="col-xs-12 col-sm-12 col-md-12">
				<div id="calendar" class="col-xs-9 col-sm-9 col-md-9"></div>
				<div id="external-events" class="hidden-xs hidden-md hidden-sm col-xs-5 col-sm-5 col-md-5">
				<h4>일정 즐겨찾기</h4>
					<!-- 일정 즐겨찾기는 20개 까지만 출력이 됨 -->
					<c:forEach var="bookMarkList" items="${bookMarkList}" end="20">
						<!-- 즐겨찾기 -->
						<div class="fc-event">${bookMarkList.schedule_title}
						<input type="hidden" class="bookmark_seq" value="${bookMarkList.bookmark_seq}" bookmark_title="${bookMarkList.schedule_title}">
						</div>
					</c:forEach>
						<p>
							<input type="checkbox" id="drop-remove" />
							<label for="drop-remove">즐겨찾기에서 제외</label>
						</p>
						<label class="form-control">즐겨찾기는 20개까지 표시.</label>
				</div> <!-- external-events 종료 -->

				<div style="clear: both"></div>

		</div>
	</div>
	
	
