<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- datepicker 파일 include -->
<%@include file="/include/datepicker.jsp"%>

<script type="text/javascript">
	$(function() {
		$('.datepicker').datepicker({
			autoclose : true,
			format : "yyyy.mm.dd",
			maxViewMode : 1,
			todayBtn : "linked",
			language : "kr",
			orientation : "bottom auto",
			todayHighlight : true
		});

	})
</script>


<!-- 상세검색 페이지 -->
<script type="text/javascript">
	$(function() {
		$('.areacode').on('change', function() {
			$('.areacode').val($(this).val());
		});

		$('.contenttypeid').on('change', function() {
			$('.contenttypeid').val($(this).val());
		});

		$('.inputDateStart').on('change', function() {
			$('.inputDateStart').val($(this).val());
		});

		$('.inputDateEnd').on('change', function() {
			$('.inputDateEnd').val($(this).val());
		});

		$('.searchText').on('keyup', function() {
			$('.searchText').val($(this).val());
		});

	
		// 날짜를 YYYYMMDD 형태로 변환
		function dateFormat(date) {
			var yyyy = date.getFullYear();
			var mm = date.getMonth(); // getMonth() is zero-based
			var dd  = date.getDate();
			return String(10000*yyyy + 100*mm + dd);
		} 
		
		// 현재 날짜를 YYYYMMDD 형태로 변환
		function todayFormat(date){
			var yyyy = date.getFullYear().toString();
			var mm = (date.getMonth()+1).toString();
			var dd = date.getDate().toString();
			return yyyy + (mm[1] ? mm : '0'+mm[0]) + (dd[1] ? dd : '0'+dd[0]);
		}
		
		// YYYYMMDD형태로 DATE타입으로 변환
		function format(p1){
			var yyyy = p1.substring(0,4);
			var mm = p1.substring(4,6);
			var dd = p1.substring(6,8);
			return new Date(yyyy,mm,dd);
		}
		
		//한달 추가 함수
		function add1Month(date) {
			var month = date.getMonth() + 1;//getMonth : 0~11
			if (month == '12') {
				month = '1';
			}
			return new Date(date.getFullYear(), month , date.getDate());
		}
		
		
		// 상세 검색버튼 클릭시 submit 막고 validate 처리
		$('.searchBtn').on('click', function(){
			console.log('클릭함');
			search("1");
			
		});
		
		
	
		
		function search(pageNum){
			
			//ajax를 통한 요청
			var selected = $('#selected').text();
			if(selected == 'event'){
				var today = new Date();
				var todayFormatted = todayFormat(today);
				
				
				if ($('.inputDateStart').val() == '') {
					$('.inputDateStart').val(todayFormatted);
				}

				var inputDateStart = $('.inputDateStart').val();
				var fomattedInputDateStart = format(inputDateStart);
				var add1MonthFomattedInputDateStart = add1Month(fomattedInputDateStart);
				var added1MonthFormatted = dateFormat(add1MonthFomattedInputDateStart);
				console.log('inputDateStart : ' + inputDateStart);
				console.log('fomattedInputDateStart : ' + fomattedInputDateStart);
				console.log('add1MonthFomattedInputDateStart : ' + add1MonthFomattedInputDateStart);
				console.log('added1MonthFormatted : ' + added1MonthFormatted);

				if ($('.inputDateEnd').val() == '') {
					$('.inputDateEnd').val(added1MonthFormatted);
				}
			}

			var keyword = $('.searchDetailForm [name="keyword"]').val();
			var contentTypeId = $('.searchDetailForm [name="contentTypeId"]').val();
			var areaCode = $('.searchDetailForm [name="areaCode"]').val();
			var eventStartDate = $('.searchDetailForm [name="eventStartDate"]').val();
			var eventEndDate = $('.searchDetailForm [name="eventEndDate"]').val();
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/travel/search/result",
				data : JSON.stringify({selected : selected, pageNum : pageNum,
						keyword : keyword, areaCode : areaCode, contentTypeId : contentTypeId,
						eventStartDate : eventStartDate, eventEndDate : eventEndDate}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 
					$("#searchResult").html("");
					$("#searchResult").html(data);
					console.log("성공");
					
					//페이징처리
			 		$(".page-link").click(function(){
			 			var pageNum = $(this).attr("type");
			  			search(pageNum);
			 		});
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}
					
			})
		}
		
		
		//카테고리를 이용한 키워드 검색
		if ($('#keyword').text() != "") {
			$('.searchDetailForm [name="keyword"]').val($('#keyword').text());
			search("1");
		};
		
	})
</script>


<h3>
	<c:choose>
		<c:when test="${selected == 'location'}">지역기반 검색</c:when>
		<c:when test="${selected == 'event'}">축제 검색</c:when>
		<c:when test="${selected == 'keyword'}">키워드 검색</c:when>
	</c:choose>
</h3>
<hr>
<div class="row">
	<!-- 축제검색을 선택한 경우와 아닌경우 -->
	<c:choose>
		<c:when test="${selected == 'event'}">
			<div class="col-sm-4 hidden-xs">
				<label>지역</label>
			</div>
			<div class="col-sm-4 hidden-xs setEvent">
				<label>시작일</label>
			</div>
			<div class="col-sm-4 hidden-xs setEvent">
				<label>종료일</label>
			</div>
		</c:when>


		<c:otherwise>
			<div class="col-sm-offset-3 col-sm-3 hidden-xs">
				<label>지역</label>
			</div>
			<div class="col-sm-3 hidden-xs">
				<label>관광타입</label>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<div class="row hidden-xs">
	<form class="searchDetailForm" autocomplete="off">

		<!-- 축제검색을 선택한 경우와 아닌경우 -->
		<c:choose>
			<c:when test="${selected == 'event'}">
				<div class="col-sm-4 form-group">
			</c:when>

			<c:otherwise>
				<div class="col-sm-offset-3 col-sm-3 form-group">
			</c:otherwise>
		</c:choose>

		<select class="form-control areacode" name="areaCode">
			<option value="">전국</option>
			<option value="1">서울</option>
			<option value="2">인천</option>
			<option value="3">대전</option>
			<option value="4">대구</option>
			<option value="5">광주</option>
			<option value="6">부산</option>
			<option value="7">울산</option>
			<option value="8">세종</option>
			<option value="31">경기도</option>
			<option value="32">강원도</option>
			<option value="33">충청북도</option>
			<option value="34">충청남도</option>
			<option value="35">경상북도</option>
			<option value="36">경상남도</option>
			<option value="37">전라북도</option>
			<option value="38">전라남도</option>
			<option value="39">제주도</option>
		</select>
</div>

<!-- 축제검색이 아닌 경우만 출력 -->
<c:if test="${selected != 'event'}">
	<div class="col-sm-3 form-group">
		<select class="form-control contenttypeid" name="contentTypeId">
			<option value="12">관광지</option>
			<option value="14">문화시설</option>
			<option value="25">여행코스</option>
			<option value="28">레포츠</option>
		</select>
	</div>
</c:if>

<!-- 축제검색인 경우만 출력 -->
<c:if test="${selected == 'event'}">
	<div class="col-sm-4 form-group setEvent">
		<input type="text" class="form-control datepicker inputDateStart"
			name="eventStartDate" placeholder="시작일을 입력하세요">
	</div>


	<div class="col-sm-4 form-group setEvent">
		<input type="text" class="form-control datepicker inputDateEnd"
			name="eventEndDate" placeholder="종료일을 입력하세요">
	</div>
</c:if>

<!-- 키워드 검색인 경우만 출력 -->
<c:if test="${selected == 'keyword'}">
	<div class="row hidden-xs">
		<div class="col-sm-4 col-sm-offset-4">
			<input type="text" class="form-control searchText"
				placeholder="키워드를 입력하세요" name="keyword">
		</div>
	</div>
</c:if>

<br>
<div class="row hidden-xs">
	<div class="col-sm-4 col-sm-offset-4">
		<button class="btn btn-success btn-block searchBtn" type="button">검색</button>
	</div>
</div>
</form>
</div>

<!-- xs인 경우의 출력창 -->
<div class="visible-xs-block">
	<form class="form-horizontal searchDetailForm" autocomplete="off">
		<div class="form-group">
			<label class="col-xs-4 control-label">지역</label>
			<div class="col-xs-8">
				<select class="form-control areacode" name="areaCode">
					<option value="">전국</option>
					<option value="1">서울</option>
					<option value="2">인천</option>
					<option value="3">대전</option>
					<option value="4">대구</option>
					<option value="5">광주</option>
					<option value="6">부산</option>
					<option value="7">울산</option>
					<option value="8">세종</option>
					<option value="31">경기도</option>
					<option value="32">강원도</option>
					<option value="33">충청북도</option>
					<option value="34">충청남도</option>
					<option value="35">경상북도</option>
					<option value="36">경상남도</option>
					<option value="37">전라북도</option>
					<option value="38">전라남도</option>
					<option value="39">제주도</option>
				</select>
			</div>
		</div>


		<!-- 축제검색이 아닌 경우만 출력 -->
		<c:if test="${selected != 'event'}">
			<div class="form-group">
				<label class="col-xs-4 control-label">관광타입</label>
				<div class="col-xs-8">
					<select class="form-control contenttypeid" name="contentTypeId">
						<option value="12">관광지</option>
						<option value="14">문화시설</option>
						<option value="25">여행코스</option>
						<option value="28">레포츠</option>
					</select>
				</div>
			</div>
		</c:if>


		<!-- 축제검색인 경우만 출력 -->
		<c:if test="${selected == 'event'}">
			<div class="form-group setEvent">
				<label class="col-xs-4 control-label">시작일</label>
				<div class="col-xs-8">
					<input type="text" class="form-control datepicker inputDateStart"
						name="eventStartDate" placeholder="시작일을 입력하세요">
				</div>
			</div>


			<div class="form-group setEvent">
				<label class="col-xs-4 control-label">종료일</label>
				<div class="col-xs-8">
					<input type="text" class="form-control datepicker inputDateEnd"
						name="eventEndDate" placeholder="종료일을 입력하세요">
				</div>
			</div>
		</c:if>


		<!-- 키워드 검색인 경우만 출력 -->
		<c:if test="${selected == 'keyword'}">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<input type="text" class="form-control searchText"
						placeholder="키워드를 입력하세요" name="keyword">
				</div>
			</div>
		</c:if>


		<br>


		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<button class="btn btn-success btn-block searchBtn" type="button">검색</button>
			</div>
		</div>

	</form>
</div>

<hr>

<div id="keyword" hidden="true">${keyword}</div>
<div id="selected" hidden="true">${selected}</div>
<!-- <div id="pageNum">1</div> -->

<br>


<!-- ajax를 통한 결과값 출력-->
<div id="searchResult"></div>