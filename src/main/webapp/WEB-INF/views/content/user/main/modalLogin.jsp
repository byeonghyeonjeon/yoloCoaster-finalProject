<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- login modal -->
<style>
<!--
#formLogin {
	text-align: center;
}

#btnLogin {
	height: 68px;
}

#naverIdLogin a img {
	width: 100%;
}
-->
</style>
<script>
$(function(){
	$('#joinBtnInLoginModal').on('click', function(){
		location.href = "${pageContext.request.contextPath }/join/joinForm";
	})
	
})
</script>

<!-- naver login -->
<!-- LoginWithNaverId Javscript SDK -->
<%@include file="/include/oauth.jsp"%>

<!-- (3) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
<script>
	$(function() {
		
		var naverLogin = new naver.LoginWithNaverId({
			clientId : "tBELWPh_hKy9AINnRWHn",
			callbackHandle : true,

			//login버튼클릭시 -> callbackUrl로 이동 -> callbackUrl에서 로그인한 유저의 정보를 받음 -> 회원가입창으로 이동하게끔
			callbackUrl : "http://"
					+ window.location.hostname
					+ ((location.port == "" || location.port == undefined) ? ""
							: ":" + location.port) + "/yoloCoaster/join/naverLoginCallBack",
			isPopup : false, //팝업로그인 여부

			//로그인 버튼 사이즈 및 색깔 지정
			loginButton : {
				color : "green",
				type : 3,
				height : 40
			}
		});
		/* (4) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4-1) 임의의 링크를 설정해줄 필요가 있는 경우 */
		$("#gnbLogin").attr("href", naverLogin.generateAuthorizeUrl());
	})
</script>



<!-- facebook login -->
<div id="fb-root"></div>
<script>
	// This is called with the results from from FB.getLoginStatus().
	function statusChangeCallback(response) {
		console.log('statusChangeCallback');
		console.log(response);
		// The response object is returned with a status field that lets the
		// app know the current login status of the person.
		// Full docs on the response object can be found in the documentation
		// for FB.getLoginStatus().
		if (response.status === 'connected') {
			// Logged into your app and Facebook.
			testAPI();
		}
	}

	// This function is called when someone finishes with the Login
	// Button.  See the onlogin handler attached to it in the sample
	// code below.
	function checkLoginState() {
		console.log('function checkLoginState()');
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '1808603842555097',
			cookie : true, // enable cookies to allow the server to access
			// the session
			xfbml : true, // parse social plugins on this page
			version : 'v3.0' // use graph api version 2.8
		});

		//로그인 상태를 확인함
		// FB.getLoginStatus(function(response) {
		//   console.log('FB.getLoginStatus')
		//   statusChangeCallback(response);
		// });

	};

	// Load the SDK asynchronously
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.0&appId=1808603842555097&autoLogAppEvents=1";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	//페이스북으로 로그인한 유저의 정보가 담긴 객체
	var userData;

	//로그인 완료시 실행되는 함수 (회원가입창으로 이동 필요)
	function testAPI() {
		FB.api('/me', 'GET', {
			"fields" : "id,name,email,location,gender,age_range"
		}, function(response) {
			console.log('Successful login for: ' + response.name);
			console.log('response.name: ' + response.name);
			console.log('response.id: ' + response.id);
			console.log('response.email: ' + response.email);
			console.log('response.location: ' + response.location);
			console.log('response.gender: ' + response.gender);
			console.log('response.age_range.min: ' + response.age_range.min);

			userData = response;
			//데이터를 변경하고
			//인풋 히든에다가 넣고
			$('input[name=mem_mail]').val(response.email);
			$('input[name=mem_gen]').val(response.gender);
			$('input[name=mem_age]').val(response.age_range.min);
			//폼태그로 요청 post방식
			$('#faceBookInfo').submit();
			//회원가입c
		});

	}
</script>

<script>
  $(function(){
	  
 	// 아이디 패스워드 입력시 로그인버튼활성화
	 $('#input_pass').on('input', $(this), function(){  
		if($('#input_id').val().trim()!="" && $('#input_pass').val().trim()!=""){
			$('#btnLogin').attr('disabled', false);
		}
	  
	 });
	
	//아이디 기억하기 (쿠키로 7일간 저장)
	var remembered_id = getCookie("input_id");
	$("input[name='memId']").val(remembered_id); 
	 
	if($("input[name='memId']").val() != ""){ 	// 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
	    $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
	}
	 
	$("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
	    if($("#idSaveCheck").is(":checked")){ 	// ID 저장하기 체크했을 때,
	        var input_id = $("input[name='memId']").val();
	        setCookie("input_id", input_id, 7); // 7일 동안 쿠키 보관
	    }else{ // ID 저장하기 체크 해제 시,
	        deleteCookie("input_id");
	    }
	});
	 
	// ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
	$("input[name='memId']").keyup(function(){ 	// ID 입력 칸에 ID를 입력할 때,
	    if($("#idSaveCheck").is(":checked")){ 	// ID 저장하기를 체크한 상태라면,
	        var input_id = $("input[name='memId']").val();
	        setCookie("input_id", input_id, 7); // 7일 동안 쿠키 보관
	    }
	}); 
	
	//엔터키 누른 경우 로그인
	$('#input_pass').keypress(function(event){
		if($('#input_id').val().trim()!="" && $('#input_pass').val().trim()!=""){
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if(keycode == '13'){
				login();
			}
			
		}
	});
	
	//로그인 버튼 클릭시 액션
	$('#btnLogin').on('click', function(){
		login();   
	});
	
  })
  	
  	//로그인 함수
  	function login(){
		var userId = $('#input_id').val();
		var userPass = $('#input_pass').val();
		var userInfo = '{"mem_id":"' + userId + '", "mem_pass":"'+userPass+'"}';
		$.ajax({
		        method : "post",
		        url : "${pageContext.request.contextPath}/login/getMemberLogin",
		        data : userInfo,
		       	contentType : "application/json; charset=UTF-8",
		       	dataType : "text",
		        success : function(result){
		        	//세션 : user정보, result = yes/no 로 받음 
		        	if(result=="yes"){
		           	location.href=window.location.href;		//현재페이지 상태유지
		           	//location.href="${request.pageContext.contextPath}/yoloCoaster/main";
		        	}else if(result=="admin"){
		        		location.href="${pageContext.request.contextPath}/adminBoard/adminNotice";
		        	}else{
		        	
		           	alert("회원정보가 일치하지 않습니다. \n회원가입 정보를 확인해주세요.");
		           	$('#input_pass').val('');
		           	$('#input_id').focus();
		        	}
		        },
		        error : function(xhr){
		        	alert("상태 : "+ xhr.status);
		        } 
		});
  	}
  
  	//쿠키 저장 함수(쿠키이름, 쿠키이름에 저장할 값, 쿠키를 유지할 일수)
	function setCookie(cookieName, value, exdays){
	  $.cookie(cookieName, value, { expires: exdays, path: '/yoloCoaster' });
	}
	
  	//쿠키 지우기 함수(쿠키이름)
	function deleteCookie(cookieName){
		$.removeCookie(cookieName, { path: '/yoloCoaster' });
	}
	
  	//쿠키 읽어오는 함수(쿠키이름) -> 쿠키값 반환
	function getCookie(cookieName) {
		return $.cookie(cookieName);
	}
  
  
</script>


<!-- Login Modal창 -->
<div class="modal fade" role="dialog"
	aria-labelledby="gridSystemModalLabel" aria-hidden="true"
	id="loginModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- modal header(title) -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="gridSystemModalLabel">로그인</h4>
			</div>

			<!-- modal body (content) -->
			<div class="modal-body">
				<div class="container-fluid">
					<form id="formLoginInfo">

						<div class="row col-xs-10">

							<div class="row">
								<div class="col-xs-12">
									<input type="text" class="form-control"
										placeholder="아이디를 입력하세요" id="input_id" name="memId">
								</div>
							</div>

							<div class="row">
								<div class="col-xs-12">
									<input type="password" class="form-control"
										placeholder="비밀번호를 입력하세요" id="input_pass" name="memPass">
								</div>
							</div>

						</div>

						<div class="col-xs-2">
							<button class="btn btn-success btn-lg" type="button"
								id="btnLogin" disabled="disabled">로그인</button>
						</div>

					</form>
				</div>


				<div class="container-fluid">

					<div class="row">

						<div class="col-xs-12 col-sm-6">
							<div class="checkbox">
								<label> <input type="checkbox" id="idSaveCheck">아이디기억하기
								</label>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6">
							<div class="checkbox">
								<a href="${pageContext.request.contextPath}/findInfo/findId">아이디 찾기</a>&nbsp;/&nbsp;<a href="${pageContext.request.contextPath}/findInfo/findPasswordForm">비밀번호 찾기</a>
							</div>
						</div>

					</div>


					<div class="row">

						<!-- naver login button -->
						<div class="col-xs-6">
							<div id="naverIdLogin">
								<a id="naverIdLogin_loginButton" href="${pageContext.request.contextPath}/join/naverLoginCallBack" role="button"></a>
							</div>
						</div>

						<!-- facebook login button -->
						<div class="col-xs-6">
							<!-- scope에 원하는 정보를 입력하면 된다 -->
							<fb:login-button
								scope="public_profile,email,user_location,user_gender,user_age_range"
								onlogin="checkLoginState();" data-max-rows="1" data-size="large"
								data-button-type="continue_with" data-show-faces="false"
								data-auto-logout-link="false" data-use-continue-as="false">
							</fb:login-button>
						</div>

					</div>

					<br>
					<div class="row">
						<div class="col-md-12">
							<button type="button" class="btn btn-info btn-block" id="joinBtnInLoginModal">회원가입</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
<!-- /.modal -->
<form id="faceBookInfo" action="${pageContext.request.contextPath}/join/faceBookJoinForm " method="post" >
<input type="hidden" name="mem_mail">
<input type="hidden" name="mem_gen">
<input type="hidden" name="mem_age">
</form>

<form id="naverInfo" action="" method="post" >
</form>


