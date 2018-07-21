<%@page import="com.yolo.model.FriendMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.yolo.model.MessageVO"%>
<%@page import="java.util.List"%>

<!-- 채팅방 -->
<style>
#chattingBox {
	background-color: #F5F5F5;
	height: 540px;
	overflow-y: auto;
	overflow-x: hidden;
	overflow
	word-break: break-all;
}

#chattingForm [name="message_content"] {
	resize: none;
	width: 100%;
}

.messageBox {
	text-align: left;
}

.profileImg {
	width: 100%;
	border: 1px solid lightgray;
}

.messageTimeBox {
	font-size: 8pt;
}

.senderBox {
	word-break: break-all;
}

.nopadding {
	padding: 0 !important;
	margin: 0 !important;
}

.messageContentBox, .messageContentBoxMe {
	word-break: break-all;
	border-radius: 10px;
}
.messageContentBox {
	background-color: lightgreen;
}
.messageContentBoxMe {
	background-color: #69ffcd;
}

.imageBox {
	width: 50%;
}

.imgInModal {
	width: 100%;
}

.chatTitle {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 1; /* 라인수 (빨강되는게 맞음)*/
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-height: 1.2em;
	height: 1.2em;
	font-size: 18pt;
}

.messageGap {
	height: 10px;
}

.enterDiv {
	border: 2px solid lightskyblue;
}

</style>

<!-- 채팅 소켓을 다른 서버에서 참조받음 -->
<!-- <script src="http://localhost:3000/socket.io/socket.io.js"></script> -->
<script src="http://192.168.0.102:3000/socket.io/socket.io.js"></script>

<script type="text/javascript">
$(function(){
	var chatGroupVOs = new Array();
	<%List<FriendMemberVO> chatGroupVOs = (List<FriendMemberVO>)request.getAttribute("chatGroupVOs");%>
	<%for (FriendMemberVO friendMemberVO : chatGroupVOs) {%>
		var chatMember = {
			mem_id : '<%=friendMemberVO.getMem_id()%>',
			mem_profile : '<%=friendMemberVO.getMem_profile()%>'
		}
		chatGroupVOs.push(chatMember);
	<%}%>
		
	//읽지 않은 메세지가 있는경우 메세지 출력
	<%List<MessageVO> notReadMessageList = (List<MessageVO>)request.getAttribute("notReadMessageList");%>
	<%if(notReadMessageList != null){%>
   		<%for(int i = 0; i < notReadMessageList.size(); i++){%>
   			<%MessageVO messageVO = notReadMessageList.get(i);%>
   			 	var data = {
   					chat_seq : '<%=messageVO.getChat_seq()%>',
   					message_mem_id : '<%=messageVO.getMessage_mem_id()%>',
   					message_content : '<%=messageVO.getMessage_content()%>',
   					message_sort : '<%=messageVO.getMessage_sort()%>',
   					message_dt : '<%=messageVO.getMessage_dt()%>',
   					message_seq : <%=messageVO.getMessage_seq()%>
   				}
				printMessage(data);
   		<%}%>
	<%}%>
	
	
	// 지정 namespace /chat에 접속한다
// 	const chat = io('http://localhost:3000/chat');
	const chat = io('http://192.168.0.102:3000/chat');
	
	var message_mem_id = $('#mem_id_hidden').val().trim();
	var chat_seq = $("#chat_seq_hidden").val();
	
	/* 채팅방 접속 함수 */
	chat.emit("enter room", {
		chat_seq : chat_seq,
		mem_id : message_mem_id
	});
	
	/* 채팅방 접속 알람 함수 */
	chat.on("alarm entered mem_id", function(mem_id) {
		var infoBox = '<div class="enterDiv">' + mem_id + '님이 입장하셨습니다</div>';
		$('#chattingBox').append(infoBox);
	});
	
	
	/* 채팅 관련 함수 */
	//엔터키 누른 경우 채팅 전송
	$('#chattingForm textarea').keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			sendMessage();
		}
	});
	
	//전송버튼 클릭시
	$('#sendMessageBtn').on('click', function(){
		sendMessage();
	});
	
	//메세지 전송 함수
	function sendMessage(){
		var message_content = $('#chattingForm textarea').val().trim();
		
		$('#chattingForm textarea').val('');
		$('#chattingForm textarea').focus();
		if (message_content.length == 0) {
			return;
		}
		var message_sort = "01";
		
		//ajax를 이용하여 메세지정보를 db에 저장
		$.ajax({
			method: "post",
			url: "${pageContext.request.contextPath}/chat/sendMessage",
			data: JSON.stringify({chat_seq : chat_seq, 
								message_mem_id : message_mem_id, 
								message_content : message_content, 
								message_sort : message_sort, 
								}),
			contentType: "application/json; charset=UTF-8",
			dataType : "json",
			success: function(data) {
				if (data != null) {
					// 서버로 자신의 메세지를 전송한다.
					chat.emit("send message", {
						chat_seq : chat_seq,
						message_mem_id : data.message_mem_id,
						message_content : data.message_content,
						message_sort : data.message_sort,
						message_dt : data.message_dt,
						message_seq : data.message_seq
					});
				}
			},
			error : function(xhr) {
				console.log(xhr);
			}
		})
	}
	
	
	//서버로부터 메세지가 수신된 경우
	chat.on("recieve message", function(data) {
		//메세지 출력
		printMessage(data);
		
		//채팅창 스크롤바 자동으로 내리기
		gotoBottom('chattingBox');
	});
	
	//과거 메세지 출력 함수
	function printBeforeMessage(data){
		//메세지 받은 후 출력 요소
		//프로필 이미지
		var profileSrc = '';
		for (var i = 0; i < chatGroupVOs.length; i++) {
			if(chatGroupVOs[i].mem_id == data.message_mem_id){
				profileSrc = '${pageContext.request.contextPath}' + chatGroupVOs[i].mem_profile;
				break;
			}
		}
		var profileImg = '<img alt="프로필사진" src="' + profileSrc + '" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'" class="img-circle profileImg">';
		var messageImageBox = '<div class="col-xs-2 col-sm-3 nopadding">' + profileImg + '</div>';
		var messageBox;
		
		//내가 보낸 경우
		if(message_mem_id == data.message_mem_id){
			/* 메세지 보내기 */
			//채팅시간
			var messageTimeBox = '<div class="messageTimeBox">' + data.message_dt + '</div>';
			//채팅내용
			var messageContentBox = '';	
			if (data.message_sort == '01') {//텍스트인 경우
				messageContentBox = '<div class="col-xs-10 col-xs-offset-2 col-sm-11 col-sm-offset-1 messageContentBoxMe">' + data.message_content + messageTimeBox + '</div>';
			} else if (data.message_sort == '02') {//이미지인 경우
				var imageBox = '<img src="${pageContext.request.contextPath}/' + data.message_content + '" title="' + data.message_content + '" class="imageBox" data-toggle="modal" data-target="#imgModal"/>';
				messageContentBox = '<div class="col-xs-10 col-xs-offset-2 col-sm-11 col-sm-offset-1 messageContentBoxMe">' + imageBox + messageTimeBox + '</div>';
			}
			
			//메세지 출력
			messageBox = '<div class="messageBox row nopadding" id="' + data.message_seq + '">' + messageContentBox + '</div><div class="messageGap"/>';
			
		} else {//남이 보낸 경우
			//작성자아이디
			var senderBox = '<div class="col-xs-10 col-sm-9 senderBox nopadding">' + data.message_mem_id + '</div>';
			//채팅시간
			var messageTimeBox = '<div class="messageTimeBox">' + data.message_dt + '</div>';
			
			//채팅내용
			var messageContentBox = '<div class="col-xs-10 col-sm-9 messageContentBox">' + data.message_content + messageTimeBox + '</div>';
			if (data.message_sort == '01') {//텍스트인 경우
				messageContentBox = '<div class="col-xs-10 col-sm-9 messageContentBox">' + data.message_content + messageTimeBox + '</div>';
			} else if (data.message_sort == '02') {//이미지인 경우
				var imageBox = '<img src="${pageContext.request.contextPath}/' + data.message_content + '" title="' + data.message_content + '" class="imageBox" data-toggle="modal" data-target="#imgModal"/>';
				messageContentBox = '<div class="col-xs-10 col-sm-9 messageContentBox">' + imageBox + messageTimeBox + '</div>';
			}
			
			//메세지 출력
			messageBox = '<div class="messageBox row nopadding" id="' + data.message_seq + '">' + messageImageBox + senderBox + messageContentBox + '</div><div class="messageGap"/>';
		}
		
		
		$('#chattingBox').prepend(messageBox);
	}
	
	
	//메세지 출력 함수
	function printMessage(data){
		//메세지 받은 후 출력 요소
		//프로필 이미지
		var profileSrc = '';
		for (var i = 0; i < chatGroupVOs.length; i++) {
			if(chatGroupVOs[i].mem_id == data.message_mem_id){
				profileSrc = '${pageContext.request.contextPath}' + chatGroupVOs[i].mem_profile;
				break;
			}
		}
		var profileImg = '<img alt="프로필사진" src="'+ profileSrc + '" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'" class="img-circle profileImg">';
		var messageImageBox = '<div class="col-xs-2 col-sm-3 nopadding">' + profileImg + '</div>';
		var messageBox;
		//내가 보낸 경우
		if(message_mem_id == data.message_mem_id){
			/* 메세지 보내기 */
			//채팅시간
			var messageTimeBox = '<div class="messageTimeBox">' + data.message_dt + '</div>';
			//채팅내용
			var messageContentBox = '';	
			if (data.message_sort == '01') {//텍스트인 경우
				messageContentBox = '<div class="col-xs-10 col-xs-offset-2 col-sm-11 col-sm-offset-1 messageContentBoxMe">' + data.message_content + messageTimeBox + '</div>';
			} else if (data.message_sort == '02') {//이미지인 경우
				var imageBox = '<img src="${pageContext.request.contextPath}/' + data.message_content + '" title="' + data.message_content + '" class="imageBox" data-toggle="modal" data-target="#imgModal"/>';
				messageContentBox = '<div class="col-xs-10 col-xs-offset-2 col-sm-11 col-sm-offset-1 messageContentBoxMe">' + imageBox + messageTimeBox + '</div>';
			}
			
			//메세지 출력
			messageBox = '<div class="messageBox row nopadding" id="' + data.message_seq + '">' + messageContentBox + '</div><div class="messageGap"/>';
			
		} else {//남이 보낸 경우
			//작성자아이디
			var senderBox = '<div class="col-xs-10 col-sm-9 senderBox nopadding">' + data.message_mem_id + '</div>';
			//채팅시간
			var messageTimeBox = '<div class="messageTimeBox">' + data.message_dt + '</div>';
			
			//채팅내용
			var messageContentBox = '<div class="col-xs-10 col-sm-9 messageContentBox">' + data.message_content + messageTimeBox + '</div>';
			if (data.message_sort == '01') {//텍스트인 경우
				messageContentBox = '<div class="col-xs-10 col-sm-9 messageContentBox">' + data.message_content + messageTimeBox + '</div>';
			} else if (data.message_sort == '02') {//이미지인 경우
				var imageBox = '<img src="${pageContext.request.contextPath}/' + data.message_content + '" title="' + data.message_content + '" class="imageBox" data-toggle="modal" data-target="#imgModal"/>';
				messageContentBox = '<div class="col-xs-10 col-sm-9 messageContentBox">' + imageBox + messageTimeBox + '</div>';
			}
			
			//메세지 출력
			messageBox = '<div class="messageBox row nopadding" id="' + data.message_seq + '">' + messageImageBox + senderBox + messageContentBox + '</div><div class="messageGap"/>';
		}
		
		$('#chattingBox').append(messageBox);
	}
	
	//스크롤위치 맨 아래로 이동하는 함수
	function gotoBottom(id){
		var element = document.getElementById(id);
		element.scrollTop = element.scrollHeight - element.clientHeight;
		//console.log('element.scrollHeight 내부스크롤 크기: ' + element.scrollHeight)
		//console.log('element.clientHeight 채팅창크기 : ' + element.clientHeight)
		//console.log('element.scroll 위치값 : ' + element.scrollTop)
	}
	
	//스크롤 위치가 맨 위인 경우 예전 메세지 출력
	$('#chattingBox').on('scroll',function(){
		if ($(this).scrollTop() == '0') {
			var messageBox = $(this).find('.messageBox')[0];
			var message_seq = messageBox.id;
			
			$.ajax({
				method: "post",
				url: "${pageContext.request.contextPath}/chat/selectBeforeMessage",
				data: JSON.stringify({message_seq : message_seq, 
									chat_seq : chat_seq
									}),
				contentType: "application/json; charset=UTF-8",
				dataType : "json",
				success: function(data) {
					if (data != null) {
						for (var i = 0; i < data.length; i++) {
							printBeforeMessage(data[i]);
						}
					}
				},
				error : function(xhr) {
					console.log(xhr);
				}
			})
		}
    });
	
	/* 채팅창 초기화*/
	$('.clearBtn').on('click', function(){
		$('#chattingBox').html('');
	});
	
	
	/* 파일 관련 함수 */
	//파일 사이즈 출력 함수
	function returnFileSize(number) {
		if (number < 1024) {
			return number + 'bytes';
		} else if (number >= 1024 && number < 1048576) {
			return (number / 1024).toFixed(1) + 'KB';
		} else if (number >= 1048576) {
			return (number / 1048576).toFixed(1) + 'MB';
		}
	}
	
	
	/* 파일 읽기 */
	$('#fileInput').on('change', function(){
		$('#progress').css('width', '0%');
		
		//하나의 파일만 고름
		var file = $('#fileInput')[0].files[0];
		
		//파일정보 출력
		//console.log(file.name);
		//console.log(file.type);
		//console.log(file.size);
		//console.log(returnFileSize(file.size));
		
		//파일을 읽는 객체생성
		var reader = new FileReader();
		
		//파일이 있을 경우 파일을 binary타입으로 읽는다
		if (file) {
			reader.readAsArrayBuffer(file);
		}
		
		
		//파일 읽는중 (진행상태 표현 => 나중에 막대그래프?)
		reader.onprogress = function (data) {
			if (data.lengthComputable) {
				var progress = parseInt(((data.loaded / data.total) * 100), 10) + '%';
				$('#progress').css('width', progress);
			}
		}
		
		//파일 읽기가 완료된 후
		reader.onload = function (event) {
			filebuffer = reader.result
			//result가 ArrayBuffer인 것을 알수있다.
			console.log(reader.result);
			//ArrayBuffer의 byteLength 출력
			console.log(reader.result.byteLength);
			
			$('#imageUploadForm').submit();
		}
		
	});
	
	
	//파일 전송 ajax
	$('#imageUploadForm').ajaxForm({
		success: function(data,status){
			//socket을 이용한 메세지(이미지경로) 전송
			chat.emit("send message", data);
            
			$('#progress').css('width', '0%');
        },
        error: function(){
            //에러발생을 위한 code페이지
            alert("업로드 에러!")
        }                              
    });
	
	//메세지의 이미지 클릭시 모달창 띄움(deligate방식)
	$('#chattingBox').on('click', '.imageBox', function(){
		var imgBox= $(this);
		var imgSrc = imgBox[0].src;
		var imgTitle = imgBox[0].title;
		
		var newImgBox = '<img class="imgInModal" src="' + imgSrc + '" title="' + imgTitle + '">';
		$('#imgModal .modal-body').html(newImgBox);
	});
	
	//모달창의 다운하기 버튼 클릭시(deligate방식)
	$('#imgModal').on('click', '#imgDownBtnInImgModal', function(){
		location.href = '${pageContext.request.contextPath}/file/imageDownload?filepath='+ $('.imgInModal').attr('title');
	});
})
</script>

<div class="col-sm-12">
	<!-- 채팅방 이름 -->
	<div class="row">
		<div class="col-xs-10 col-sm-8">
			<span class="chatTitle">${chatNameVO.name}</span>
			<input type="hidden" id="chat_seq_hidden" value="${chatNameVO.chat_seq}">
		</div>
		<div class="col-xs-2 col-sm-4">
			<button type="button" class="btn btn-default btn-block clearBtn">
				<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
			</button>
		</div>
	</div>
	
	<!-- 채팅창 -->
	<div class="row">
		<div id="chattingBox">
		
		</div>
	</div>
	
	<!-- 이미지 첨부 -->
	<div class="row">
		<form action="${pageContext.request.contextPath}/chat/imageUpload" method="post" id="imageUploadForm" enctype="multipart/form-data">
			<input type="file" name="file" accept="image/*" id="fileInput">
		</form>
		<div class="progress" style="margin-bottom: 0px;">
		    <div id="progress" class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:0%"></div>
		</div>
	</div>
	
	<!-- 입력창 -->
	<div class="row">
		<form action="" autocomplete="off" id="chattingForm">
			<textarea rows="3" cols="50" name="message_content" autofocus="autofocus"></textarea>
			<button type="button" class="btn btn-info btn-sm btn-block" id="sendMessageBtn">전송</button>
		</form>
	</div>
	
	<!-- 이미지 모달 -->
	<div class="modal fade" id="imgModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<!-- 이미지 출력 -->
				</div>
				<div class="modal-footer">
					<button type="button" id="imgDownBtnInImgModal" class="btn btn-block btn-success">다운받기</button>
				</div>
			</div>
		</div>
	</div>

</div>
    