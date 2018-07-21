<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 모달창 - 로그인 -->
<%@include file="/WEB-INF/views/content/user/main/modalLogin.jsp" %>
<%@include file="/include/fullcalendar.jsp" %>

<!-- 로그인한 유저 아이디 -->
<script type="text/javascript">
var mem_id = '${memberVO.mem_id}';
$(function(){
	$('.aTagPost').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		var f = $('#aTagForm');
		f.attr('action', href);
		f.submit();
	})
	
	$('#logoutBtn').on('click', function(event){
	 	var location = window.location.href;
		event.preventDefault();	//href 속성해제
	 	$.ajax({
	        method : "post",
	        url : "${pageContext.request.contextPath}/login/logout",
	        data : location,
	       	contentType : "application/json; charset=UTF-8",
	       	dataType : "text",
	        success : function(result){
	        	//세션 : user정보, result = yes/no 로 받음 
	        	if(result=="yes"){
	            	location.href=window.location.reload(true);		//현재페이지 상태유지
	        	}else{
	            	alert("다시 시도해 주세요");
	        	}
	        },
	        error : function(xhr){
	        	alert("상태 : "+ xhr.status);
	        }  
	        
		}); 
	})
	
	
	
	
   

})
</script>
<style>

</style>
<form method="post" id="aTagForm">
	<input type="hidden" name="mem_id" value="${memberVO.mem_id}" id="mem_id_hidden">
</form>

<!-- 상단 메뉴바 -->
<nav class="navbar navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">

			<!-- id가 topNavbar인 nav를 목록으로 만듬 -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#topNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<!-- index페이지로 이동 -->
			<a class="navbar-brand" href="${pageContext.request.contextPath }/main"> 
				<img class="mainYoloLogo" src="${pageContext.request.contextPath}/image/logo/yolocoaster_font.png">
			</a>
		</div>

		<!-- 메뉴 목록 -->
		<div class="collapse navbar-collapse navbar-right" id="topNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath }/explain/compSummary" class="tobNavbarName">회사개요</a>
				<li><a href="${pageContext.request.contextPath }/travel/search?selected=location" class="tobNavbarName">지역검색</a></li>
				<li><a href="${pageContext.request.contextPath }/travel/search?selected=event" class="tobNavbarName">축제검색</a></li>
				<li><a href="${pageContext.request.contextPath}/scheBoard/selectScheBoardList" class="tobNavbarName">일정검색</a></li>
				<c:if test="${memberVO ne null}">
					<li><a href="${pageContext.request.contextPath}/chat/chattingroomlist" class="tobNavbarName aTagPost">채팅방</a></li>
				</c:if>
				<li><a href="${pageContext.request.contextPath }/board/travelMain" class="tobNavbarName">게시판</a></li>
				<li class="dropdown"><a href="#"
					class="dropdown-toggle tobNavbarName" data-toggle="dropdown"
					role="button" aria-expanded="false"> <i
						class="glyphicon glyphicon-user"></i><span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						
						<c:choose>
							<c:when test="${memberVO == null}">
								<li><a href="#" data-toggle="modal" data-target="#loginModal" class="tobNavbarName">로그인</a></li>
								<li><a href="${pageContext.request.contextPath }/join/joinForm" class="tobNavbarName">회원가입</a></li>
							</c:when>
							<c:otherwise>
								<c:if test="${memberVO.mem_id ne 'admin'}">
									<li><a href="${pageContext.request.contextPath }/myPage/main" class="tobNavbarName aTagPost">마이페이지</a></li>
								</c:if>
								<c:if test="${memberVO.mem_id eq 'admin'}">
									<li><a href="${pageContext.request.contextPath}/adminBoard/adminNotice" class="tobNavbarName aTagPost">관리자페이지</a></li>
								</c:if>
								<li><a href="${pageContext.request.contextPath }/friend/selectFriendList" class="tobNavbarName aTagPost">친구목록</a></li>
								<li><a href="#" class="tobNavbarName" id="logoutBtn">로그아웃</a></li>
								<form action="${pageContext.request.contextPath}/login/logout" method="post" id="localForm"><input type="hidden" name="location" id="pageInfo"></form>
							</c:otherwise>
						</c:choose>
					</ul>
			</ul>
		</div>
	</div>

	<!-- 검색창 -->
	<div class="container-fluid">
		<form class="navbar-form" action="${pageContext.request.contextPath }/travel/search" id="searchForm" autocomplete="off" method="get">
			<select class="form-control" name="selected">
				<option value="keyword">키워드</option>
				<option value="tag">태그</option>
			</select>
			<div class="input-group">
				<input type="text" class="form-control searchText" placeholder="검색할 내용을 입력하세요" id="searchText" name="keyword">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
</nav>
