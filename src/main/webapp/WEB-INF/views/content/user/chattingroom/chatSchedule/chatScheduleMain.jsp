<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	var dragId = 0; //드래그로 선택한 일정의 ID값을 저장하는 전역변수
	var deleteNum = ""; //클릭한 일정의 ID값을 저장하는 전역변수
	var yyyy = "";
	var mm = "";
	var dd = "";
	var dt_end = "";
	var endDay = "";
	var modifyColor = "";
	
	var mem_id;
	var chat_seq;
	var cal;
	var dragList;
	
	$(document).ready(function() {
		//jscolor 초기화
		jscolor.installByClassName("jscolor");
		
		mem_id = '${memberVO.mem_id}';
		chat_seq = '${chatNameVO.chat_seq}';
		
		// 지정 namespace /cal 에 접속한다
// 		cal = io('http://localhost:3000/cal');
		cal = io('http://192.168.0.102:3000/cal');
		
		/* 채팅방 접속 함수 */
		cal.emit("enter room", {
			chat_seq : chat_seq,
			mem_id : mem_id
		});
		
		
		
		//스케쥴 드래그시 서버에 위치를 보냄
		$('#chatContent').on('mousemove', '.fc-dragging', function(event){
			var topStr = $(this).css('top').replace(/[^-\d\.]/g, '');
			var left = $(this).css('left');
			var top = Number(topStr) + 60 + 'px';
			cal.emit("dragging", {top : top, left : left, mem_id : mem_id, chat_seq : chat_seq});
		});
		
		//서버로부터 drag start가 온경우
		cal.on("recieve drag start", function(data) {
			var calendarTitle = $('div#calendar div.fc-center').text();
			var year = calendarTitle.slice(0,4);
			var month = calendarTitle.slice(6,8);
			console.log(year + ' .. ' + month);
			console.log(data);
			
			//다른 유저가 같은년도 같은 달을 보는 경우만 표시
			if((month == data.month) && (year == data.year) && (mem_id != data.mem_id)) {
				var draggingBox = 
					'<div class="draggingBox" ' + 'id="' + data.mem_id + '"' + 
					'style="background-color:'+ data.eventObj.color+';border-color:'+ data.eventObj.color+';color:'+data.eventObj.textColor+
					';" data-original-title="" title="">'+data.eventObj.title+'</div>';
				$('div.fc-view-container').append(draggingBox);
				console.log(draggingBox);
			}
		});
		
		//서버로부터 dragging이 온경우
		cal.on("recieve dragging", function(data){
			var selector = '.draggingBox#'+data.mem_id;
			$(selector).css('top', data.top).css('left', data.left);
		})
			
		//서버로부터 drag stop이 온경우
		cal.on("recieve drag stop", function(data){
			var selector = '.draggingBox#'+data.mem_id;
			$(selector).remove();
		})
		
		//서버로부터 reload page가 온경우
		cal.on("recieve reload page", function(data){
			if (data.sort == 'i') {
				var insertObj = {
					id : data.obj.schedule_seq,
					title : data.obj.schedule_title,
					start : data.obj.schedule_start,
					end : moment(data.obj.schedule_end).format("YYYY-MM-DD 24"),
					color : '#'+data.obj.schedule_color,
					textColor : "black",
					allDay : true
				}
				console.log(insertObj);
				
				$('#calendar').fullCalendar('renderEvent', insertObj, true);
				$('#calendar').fullCalendar('refetchEvents');
				
			} else if(data.sort == 'm') {//수정인 경우
				var item = $("#calendar").fullCalendar('clientEvents', data.obj.schedule_seq);
	 			item[0].title = data.obj.schedule_title;
	 			item[0].start = data.obj.schedule_start;
	 			item[0].end = moment(data.obj.schedule_end).format("YYYY-MM-DD 24");
	 			item[0].color = "#"+data.obj.schedule_color;
				$("#calendar").fullCalendar('updateEvent', item[0]);
				$('#calendar').fullCalendar('refetchEvents');
			} else if(data.sort == 'd') {//드래그인 경우
				var item = $("#calendar").fullCalendar('clientEvents', data.obj.schedule_seq);
	 			item[0].title = data.obj.schedule_title;
	 			item[0].start = data.obj.schedule_start;
	 			item[0].end = moment(data.obj.schedule_end).format("YYYY-MM-DD 24");
	 			item[0].color = data.obj.schedule_color;
				$("#calendar").fullCalendar('updateEvent', item[0]);
				$('#calendar').fullCalendar('refetchEvents');
			} else if(data.sort == 'r') {//삭제인 경우
				$('#calendar').fullCalendar('removeEvents', data.obj.schedule_seq, true);
			}
		});
		
		
		
		$.ajax({
			url: "${pageContext.request.contextPath}/chatSchedule/getchatScheduleList",
			dataType: "JSON",
			success : function(list){
				makeEventList(list);
			}/* success End */
		
		})

	
	
	});
	
	var scheduleListLength = "";
	
	function makeEventList(scheduleList){
		scheduleListLength = scheduleList;
		eventsList = new Array();
		for (var i = 0; i < scheduleList.length; i++) {
			var val = scheduleList[i];
			
			eventsList.push({
				id : val.schedule_seq,
				title : val.schedule_title, 
				start : moment(val.schedule_start).format("YYYY-MM-DD"),
				end : moment(val.schedule_end).format("YYYY-MM-DD 24"), 
				color : "#"+val.schedule_label, 
				textColor : "black",
				allDay : true
			})
		}
		makeChatSchedule();
	}
	
	function updateEventList(scheduleList){
		var eventsListTemp = new Array();
		for (var i = 0; i < scheduleList.length; i++) {
			var val = scheduleList[i];
			
			eventsListTemp.push({
				id : val.schedule_seq,
				title : val.schedule_title, 
				start : moment(val.schedule_start).format("YYYY-MM-DD"),
				end : moment(val.schedule_end).format("YYYY-MM-DD 24"), 
				color : "#"+val.schedule_label, 
				textColor : "black",
				allDay : true
			})
		}
		return eventsListTemp;
	}
	
	function makeChatSchedule(){
		
		$('#calendar').fullCalendar({
			
			header : {
				left : "prev, next ",
				center : 'title',
				right : 'today',
			},
			
			eventDurationEditable  : false,  /* Resize 막기 */
			
		  	height: 800,	/* 상하 사이즈 */
			
			buttonIcons : true, /* 버튼 아이콘 선택 */
	
			// 일자 클릭에 대한 메서드명 true시 선택가능
			navLinks : true, // can click day/week names to navigate views
	
			//drag 모션을 줄지 안줄지 여부 true면 드래그 가능
			editable : true,
	
			//즐겨찾기 창에서 꺼내오기
			droppable : true,
			
			eventLimit : true,
			
			events : eventsList,
			
			eventClick : function(event, jsEvent, date ) {
				
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
				
				modifyColor = event.color;
				deleteNum = event.id;
				

				
				$('#chatModifyModalSeq').val(event.id);
				$('#chatModifyModalInputTitle').val(event.title);
				$('#chatModifyModalInputDateStart').val(event.start.format());
				$('#chatModifyModalInputDateEnd').val(dt_endDay);
				$('#chatModifyModalColor').val(modifyColor.substring(1,7))
										  .css("background", modifyColor);
				$('#chatScheduleEventClick').modal({backdrop: "static"}, 'show');			
			},
	
			//해당 일자를 클릭했을때의 메서드 ( 빈공간 클릭했을때 )
			dayClick : function(date, jsEvent, view) {
				$('#chatSchedule_title').val("");
				$('#chatSchedule_start').val(date.format());
				$('#chatSchedule_end').val("");
				$('#inserChatScheduleModel').modal({backdrop: "static"}, "show");
			}, /* dayClick 종료 */
			
			//월 숫자를 클릭했을때의 메서드
			navLinkDayClick : function(date, jsEvent) {
				$('#chatSchedule_title').val("");
				$('#chatSchedule_start').val(date.format());
				$('#inserChatScheduleModel').modal({backdrop: "static"}, "show");		
			}, /* navLinkDayClick 종료 */
			
			// 이벤트를 선택했을때 일정의 아이디값을 전역변수로 옮긴다.
			eventDragStart : function(event, jsEvent){
				dragId = event.id;
				
				//일정 드래그시작한 객체만 추출
				var eventObj = {
						allDay : event.allDay,
						color : event.color,
						id : event.id,
						start : event.start._i,
						end : event.end._i,
						textColor : event.textColor,
						title : event.title
				}
				
				var calendarTitle = $('div#calendar div.fc-center').text();
				var year = calendarTitle.slice(0,4);
				var month = calendarTitle.slice(6,8);
				
				// 서버로 스케쥴객체를 전송한다.
				cal.emit("drag start", {eventObj : eventObj, mem_id : mem_id, chat_seq : chat_seq, year:year, month:month});
			},	/* eventDragStart 종료 */
			
			// 이벤트를 놓았을때 놓은곳의 일정의 start시간과 end시간을 가지고 업데이트 한다.
			eventDrop : function(event){
				
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
				
				$.ajax({
					url: "${pageContext.request.contextPath}/chatSchedule/chatDragScheduleModify",
					data : {
							"schedule_seq":dragId ,
							"schedule_start":event.start.format(),
							"schedule_end":drop_endDay
							},
					dataType: "json",
					success : function(list){
						eventsList = updateEventList(list);
 						var obj = {
								schedule_seq : dragId,
								schedule_title : event.title, 
								schedule_start : event.start.format(), 
								schedule_end : dt_end, 
								schedule_color : event.color
						};
						
						cal.emit("reload page", {chat_seq : chat_seq, mem_id : mem_id, obj : obj, sort : 'd'});
					},
					error : function(xhr) {
					}
				})/* ajax 종료 */
			},
			eventDragStop : function(event,jsEvent){
				// 서버로 dragstop 이벤트를 전송한다.
 				cal.emit("drag stop", {mem_id : mem_id, chat_seq : chat_seq});
				
			},
			
			/* 일정 즐겨찾기에서 즐겨찾기한 항목을 놓았을때 생성되는 메서드 */
			drop : function() {
				
				
				// 즐겨찾기 실행문 체크했을때 삭제하는 명령문
				if ($('#drop-remove').is(':checked')) {
					$(this).remove();
				}
			} /* drop 종료 */
			
		});/* fullCalendar End */
		
		

		
		
	}
</script>
<style>
.chat_schedule_size{
	margin: 20px 20px 20px 0px;
}



/* 일정들의 텍스트 */
.fc-title{
	text-shadow: 0px 0 #FFFFFF, 0 1px #FFFFFF, 1px 0 #FFFFFF, 0 0px #FFFFFF;
	-moz-text-shadow: 0px 0 #FFFFFF, 0 1px #FFFFFF, 1px 0 #FFFFFF, 0 0px #FFFFFF;
	-webkit-text-shadow: 0px 0 #FFFFFF, 0 1px #FFFFFF, 1px 0 #FFFFFF, 0 0px #FFFFFF;
}

.fc-center h2{font-size: 20pt;}
.fc-sun {background-color:#FBEFEF;}
.fc-sat {background-color:#EFF8FB;}

/* 드래그 되는 가상 일정 */
.draggingBox {
	position: absolute;
	right: auto;
	bottom: auto;
	opacity: 0.75;
	z-index: 2;
}


</style>


							<%@include file="/WEB-INF/views/content/user/chattingroom/chatSchedule/modal/modal_chatScheduleInsertForm.jsp"%>
							<%@include file="/WEB-INF/views/content/user/chattingroom/chatSchedule/modal/modal_chatScheduleEventClick.jsp"%>

							<div class="row">
								<div class="chat_schedule_size">
									<div id="calendar"></div>
								</div>
							</div>
