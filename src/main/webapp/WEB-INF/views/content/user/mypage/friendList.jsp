<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
	$(function(){
		var mem_id = $('#mem_id_hidden').val().trim();
		
		/* 친구 수락시 */
		$('.friendY').on('click', function(){
			var friend_id = $(this).parent().parent().find('.friendTitle').text();
			var parameterValue = 'mem_id='+mem_id+'&friend_id='+friend_id;
			location.href = '${pageContext.request.contextPath}/friend/addFriend?' + parameterValue;
		})
		
		/* 친구 거절시 */
		$('.friendN').on('click', function(){
			var friend_id = $(this).parent().parent().find('.friendTitle').text();
			var parameterValue = 'mem_id='+mem_id+'&friend_id='+friend_id;
			location.href = '${pageContext.request.contextPath}/friend/refuseFriend?' + parameterValue;
		})
		
		/* 친구 초대시 */
		$('.friendInvite').on('click', function(){
			var friend_id = $(this).parent().parent().find('.friendTitle').text();
			console.log(friend_id);
			var parameterValue = 'mem_id='+mem_id+'&friend_id='+friend_id;
			location.href = '${pageContext.request.contextPath}/friend/startChat?' + parameterValue;
		})
		
		/* 친구 삭제시 */
		$('.friendDelete').on('click', function(){
			var friend_id = $(this).parent().parent().find('.friendTitle').text().trim();
			var parameterValue = 'mem_id='+mem_id+'&friend_id='+friend_id;
			location.href = '${pageContext.request.contextPath}/friend/deleteFriend?' + parameterValue;
		})
		
		/* 친구 찾기 검색시(ajax를 이용) */
		$('.searchFriendBtn').on('click', function(){
			var searchMem_id = $('#searchFriendId').val().trim();
			
			if(searchMem_id != ''){//공백이 아닌 경우
				$.ajax({
					method: "post",
					url: "${pageContext.request.contextPath}/friend/searchFriend",
					data: JSON.stringify({searchMem_id : searchMem_id, mem_id : mem_id}),
					contentType: "application/json; charset=UTF-8",
					dataType : "html",
					success: function(data) {
						$('#searchFriendList').html();
						$('#searchFriendList').html(data);
					},
					error : function(xhr) {
						console.log(xhr);
					}
				})
			
			} else {//공백입력시 아무런 반응 없음
				return;
			}
		})
	})
</script>

<style>
	#glyphicons-group {
		width: 70px;
		height: 70px;
	}
	
	#glyphicons-alarm {
		width: 10px;
	}
	
	.badge-primary{
		background-color: #337AB7;
	}
	
	.badge-success{
		background-color: #5CB85C;
	}
	
	.boxing {
		border: 1px solid lightgray;
		border-radius: 10px;
		border-color: gray;
	}
	
	.scrollBox {
		overflow-y: auto;
		height: 500px;
	}
	
	.friendTitle {
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
		background-color: lightyellow;
	}
	.margin50{
		margin: 90px;
	}
	.margin14{
		margin: 14px;
	}
	
	.callList-line{
		margin: 10px auto;
		border-color: lightgray; 
	}
	.callList-headerLine{
		margin: 10px auto;
		border-color: gray;
	}
	.friendName{
		color: gray;
		padding-bottom: 25px;
	}
	
</style>

<div class="row margin50">
	<!-- 친구목록 -->
	<div class="col-sm-6 col-xs-12 boxing">
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12 text-center">
						<img alt="그룹아이콘" src="${pageContext.request.contextPath}/image/logo/glyphicons-group.png" id="glyphicons-group" >
						<span class="h3">친구 목록 </span><span class="badge badge-primary">${fn:length(friendList)}</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="h5 text-right"><i class="glyphicon glyphicon-bell"></i> 친구 요청 <span class="badge badge-success">${fn:length(friendRequestList)}</span></div>
					</div>
				</div><hr class="callList-headerLine">
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 scrollBox">
				
				<!-- 친구 요청 목록 -->
				<c:forEach items="${friendRequestList}" var="friendMemberVO">
					<div class="row requestBoxing">
						<div class="col-sm-3 hidden-xs text-center">
							<img alt="프로필사진" src="${pageContext.request.contextPath}${friendMemberVO.mem_profile}" id="glyphicons-group" class="img-circle" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
						</div>
						
						<div class="col-sm-7 col-xs-7 friendName">
							<span class="friendTitle">${friendMemberVO.mem_id}</span>
						</div>
						
						<div class="col-sm-1 col-xs-1">
							<c:if test="${friendMemberVO.friend_st == 'Y'}">
								<img alt="알람" src="${pageContext.request.contextPath}/image/logo/alarm.png" id="glyphicons-alarm">
							</c:if>
						</div>
						<div class="col-sm-4 col-xs-6">
							<button type="button" class="btn btn-success friendY">수락</button>
						</div>
						<div class="col-sm-4 col-xs-6">
							<button type="button" class="btn btn-danger friendN">거절</button>
						</div>
					</div>
				</c:forEach>
				
				<!-- 친구 목록 -->
				<c:forEach items="${friendList}" var="friendMemberVO">
					<div class="row">
						<div class="col-sm-3 hidden-xs text-center">
							<img alt="프로필사진" src="${pageContext.request.contextPath}${friendMemberVO.mem_profile}" id="glyphicons-group" class="img-circle" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
						</div>
						
						<div class="col-sm-7 col-xs-7">
							<span class="friendTitle friendName">${friendMemberVO.mem_id}</span>
						</div>
						
						<div class="col-sm-1 col-xs-1">
							<c:if test="${friendMemberVO.friend_st == 'Y'}">
								<img alt="알람" src="${pageContext.request.contextPath}/image/logo/alarm.png" id="glyphicons-alarm">
							</c:if>
						</div>
						<div class="col-sm-4 col-xs-6">
							<button type="button" class="btn btn-success friendInvite">초대</button>
						</div>
						<div class="col-sm-4 col-xs-6">
							<button type="button" class="btn btn-danger friendDelete">삭제</button>
						</div>
					</div><hr class="callList-line">
				</c:forEach>
				
			</div>
		</div>
	</div>
	<!-- 친구찾기 -->
	<div class="col-sm-6 col-xs-12 boxing">
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12 text-center">
						<h3>친구 찾기</h3>
					</div>
				</div>
				<div class="row margin14">
					<div class="col-xs-9">
						<input type="text" class="form-control" id="searchFriendId" name="mem_id" data-rule-required="true" placeholder="찾을 회원의 아이디를 입력하세요" autocomplete="off">
					</div>
					<div class="col-xs-3">
						<button type="button" class="btn btn-info btn-md searchFriendBtn">검색</button>
					</div>
				</div><hr class="callList-headerLine">
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 scrollBox" id="searchFriendList">
				<!-- 친구 찾은 목록 ajax로 리로딩 -->
				
			</div>
		</div>
	</div>
</div>