<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8" />
<link href="${pageContext.request.contextPath}/css/fullcalendar.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/fullcalendar.print.min.css" rel="stylesheet" media="print" />
<script src="${pageContext.request.contextPath}/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fullcalendar.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ko.js"></script>


<!-- bootstrapcdn -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>

  $(document).ready(function() {
	  

  //즐겨찾기 항목을 가져오는 구문
    $('#external-events .fc-event').each(function() {

      // 즐겨찾기에서 끌어올렸을때 저장하는 구문
      $(this).data('event', {
        title: $.trim($(this).text()), // use the element's text as the event title
        stick: true // maintain when user navigates (see docs on the renderEvent method)
      });

      // 즐겨찾기 항목을 선택 드랍할 수 있도록 해주는 구문
      $(this).draggable({
        zIndex: 999,
        revert: true,      // 테이블 안으로 정렬해주는 구문 반드시 true로 되어 있어야 함
        revertDuration: 0  //  드래그 후 원래 위치로 이동
      });

    });


    $('#calendar').fullCalendar({
    	
      header: {
        left : "",
        center: 'prev, title, next',
        right : 'today',
      },

      //택스트로 '다음달 / 이전달 표시방법 여부'
      buttonIcons: true, // show the prev/next text

      //몇번째 주인지 확인 false는 보여지지 않기
      weekNumbers: false,

      // 일자 클릭에 대한 메서드명 true시 선택가능
      navLinks: true, // can click day/week names to navigate views

      //drag 모션을 줄지 안줄지 여부 true면 드래그 가능
      editable: true,

      //즐겨찾기 창에서 꺼내오기
      droppable: true,

      //하루에 많은 일정이 있을경우 more로 표시하여 숨기기 (숨겼을때 +개수 표시)
      eventLimit: true, // allow "more" link when too many events
      events: [
        {
          title: 'All Day Event',
          start: '2018-06-01'
        },
        {
          title: 'Long Event',
          start: '2018-06-07',
          end: '2018-06-10'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2018-06-09T16:00:00'
        },
        {
          id: 998,
          title: 'Repeating Event',
          start: '2018-06-16T16:00:00'
        },
        {
          title: 'Conference',
          start: '2018-06-11',
          end: '2018-06-13'
        },
        {
          title: 'Lunch',
          start: '2018-06-12T12:00:00'
        },
        {
          title: 'Click for Google',
          // url: 'http://google.com/',
          start: '2018-06-28'
        }
      ]
      ,eventClick:function(event){
        alert("title : " + event.title);
      },

      //해당 일자를 클릭했을때의 메서드 ( 빈공간 클릭했을때)
      dayClick: function(date, jsEvent, view) {

        alert('Clicked on: ' + date.format());
        // 좌표값을 구하는 메서드명 (jsEvent)
        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
        // 뷰의 이름을 구하는 메서드 ( 사용안할거 같음 )
        // alert('Current view: ' + view.name);

        // 선택했을때 배경색 변경
        // change the day's background color just for fun
        $(this).css('background-color', 'lightblue');

      },
      //월 숫자를 클릭했을때의 메서드
      navLinkDayClick: function(date, jsEvent) {
        alert( "날짜를 클릭하면 모달창 뛰울거임" + date.format());
      },
      eventDragStop:function( event, jsEvent, ui, view) {

        //alert(event.start);
        //alert(event.end)
        //alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
      },

      // 즐겨찾기 실행문 체크했을때 삭제하는 명령문
      drop: function() {
        if ($('#drop-remove').is(':checked')) {
          $(this).remove();
        }
      }
      

    });
    
      $('#calendar').fullCalendar('option','height',"auto");
    
  });
  
  


</script>
<style>

  body {
    margin: 20px 10px auto;
    text-align: center;
    font-size: 10pt;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
  }

  #wrap {
    width: 700px;
	margin: 0 auto;
  }

  #external-events {
    margin: 52px auto;
    float: right;
    width: 130px;
    padding: 0 10px;
    border: 1px solid #ccc;
    /* background: #eee; */
    text-align: left;
  }

  #external-events h4 {
    font-size: 16px;
    margin-top: 0;
    padding-top: 1em;
  }

  #external-events .fc-event {
    margin: 10px 0;
    cursor: pointer;
  }

  #external-events p {
    margin: 1.5em 0;
    font-size: 11px;
    color: #666;
  }

  #external-events p input {
    margin: 0;
    vertical-align: middle;
  }

  #calendar {
    float: left;
    max-width: 700px;
    height:600px;
    margin: 0 auto;
    
  }

</style>





