<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.boxing input, .chattingRoomUpdateOkBtn {
	display: none;
}

</style>


<script type="text/javascript">
	$(function(){
		var mem_id = $('#mem_id_hidden').val().trim();
		
		/* 채팅방 삭제시 */
		$('.chattingRoomDeleteBtn').on('click', function(){
			var titleDiv = $(this).parent().parent().find('.chattingTitle');
			var chat_seq = titleDiv.attr('title');
			var parameterValue = 'mem_id='+mem_id+'&chat_seq='+chat_seq;
			location.href = '${pageContext.request.contextPath}/chat/chattingroomlist/delete?' + parameterValue;
		});
		
		/* 채팅방 이름 수정 버튼 클릭시 */
		$('.chattingRoomUpdateBtn').on('click', function(){
			var btn = $(this).parent().find('.chattingRoomUpdateOkBtn');
			$(this).css('display', 'none');
			btn.css('display', 'unset');
			
			var title = $(this).parent().parent().find('.chattingTitle');
			var input = $(this).parent().parent().find('input');
			title.css('display', 'none');
			input.css('display', 'unset');
			
		});
		
		//수정완료 버튼 클릭시(ajax이용)
		$('.chattingRoomUpdateOkBtn').on('click', function(){
			var titleDiv = $(this).parent().parent().find('.chattingTitle');
			var chat_seq = titleDiv.attr('title');
			
			
			var title = $(this).parent().parent().find('.chattingTitle');
			var input = $(this).parent().parent().find('input');
			
			var changeText = input.val().trim();
			//수정하기
			if(changeText != ''){
				$.ajax({
					method: "post",
					url: "${pageContext.request.contextPath}/chat/chattingroomlist/update",
					data: JSON.stringify({chat_seq : chat_seq, mem_id : mem_id, name : changeText}),
					contentType: "application/json; charset=UTF-8",
					dataType : "text",
					success: function(data) {
						if(data == "Y") {
							alert('채팅방 이름이 ' + changeText + '로 수정되었습니다');
						} else {
							alert('채팅방 이름 수정 에러 발생');
						}
					},
					error : function(xhr) {
						console.log(xhr);
					}
				})
			} else {
				alert('채팅방의 이름을 입력하세요');
				return;
			}
			
			title.text(changeText);
			
			title.css('display', 'unset');
			input.css('display', 'none');
			
			var btn = $(this).parent().find('.chattingRoomUpdateBtn');
			$(this).css('display', 'none');
			btn.css('display', 'unset');
		})
		
		
		//방이름 클릭시 방이동
		$('.chattingTitle').on('click', function(){
			var chat_seq = $(this).attr('title');
			var parameterValue = 'mem_id='+mem_id+'&chat_seq='+chat_seq;
			location.href = '${pageContext.request.contextPath}/chat/main?' + parameterValue;
		})
		
	})
</script>

<style>
	#glyphicons-group {
		width: 35px;
		margin : 7px;
		
	}
	
	#glyphicons-alarm {
		width: 10px;
	}
	
	.badge-primary{
		background-color: #ff6868;
	}
	
	.badge-success{
		background-color: #5CB85C;
	}
	
	.boxing {
		border: 1px solid black;
		border-radius: 10px;
	}
	.outboxing {
		border: 1px solid gray;
		border-radius: 10px;
	}
	
	.scrollBox {
		overflow-y: auto;
		height: 500px;
	}
	
	.chattingTitle {
		font-size: 15px;
		overflow: hidden;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-line-clamp: 1; /* 라인수 (빨강되는게 맞음)*/
		-webkit-box-orient: vertical;
		word-wrap: break-word;
		line-height: 1.2em;
		height: 1.2em;
	}
	
	.requestBoxing {
		background-color: lightgray;
	}
	.margin50{
		margin: 90px;
	}
	.callList-headerLine{
		margin: 10px auto;
		border-color: gray;
	}
	.callList-line{
		margin: 10px auto;
		border-color: lightgray; 
	}
</style>

<div class="row margin50">
	<!-- 채팅목록 -->
	<div class="col-sm-6 col-sm-offset-3 col-xs-12 boxing">
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12 text-center">
						<img alt="그룹아이콘" src="${pageContext.request.contextPath}/image/logo/glyphicons-group.png" id="glyphicons-group" >
						
							<span class="h3">채팅 목록 </span>
						<c:set var="length" value="${fn:length(chattingRoomList)}"/>	
						<%-- <c:if test="${length} ne '0'"> --%>
							<span class="badge badge-primary">${fn:length(chattingRoomList)}</span>
						<%-- </c:if> --%>
					</div>
				</div>
				<hr class="callList-headerLine">
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 scrollBox ">
				
				<!-- 채팅 목록 -->
				<c:forEach items="${chattingRoomList}" var="chattingRoomVO">
					<div class="row">
						<div class="col-sm-5 col-xs-5">
							<a href="#" class="chattingTitle" title="${chattingRoomVO.chat_seq}">${chattingRoomVO.name}</a>
							<input type="text" title="${chattingRoomVO.chat_seq}" value="${chattingRoomVO.name}">
						</div>
						<c:if test="${chattingRoomVO.messageCount ne 0}">
							<div class="col-sm-1 col-xs-1">
								<span class="badge badge-primary">${chattingRoomVO.messageCount}</span>
							</div>
						</c:if>
						
						<div class="col-sm-3 col-xs-3">
							<button type="button" class="btn btn-default chattingRoomUpdateBtn">이름변경</button>
							<button type="button" class="btn btn-default chattingRoomUpdateOkBtn">변경하기</button>
						</div>
						<div class="col-sm-3 col-xs-3">
							<button type="button" class="btn btn-default chattingRoomDeleteBtn">삭제하기</button>
						</div>
					</div>
					<hr class="callList-line">
				</c:forEach>
				
			</div>
		</div>
	</div>
</div>