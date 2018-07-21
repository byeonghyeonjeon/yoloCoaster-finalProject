<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
		overflow-y:auto;
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
	.friendMember {
		font-size: 20px;
		display: -webkit-box;
		-webkit-line-clamp: 1;
		-webkit-box-orient: vertical;
		line-height: 1.2em;
		height: 1.2em;
	}
	
	.margin50{
		margin: 90px;
	}
	.margin50auto{
		margin: 50px auto;
	}
	.margin14{
		margin: 14px;
	}
	.paddingTop10{
		padding: 20px;
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
	
	
}
	
	
</style>

<div class="row margin50auto">
	<!-- 채팅방 멤버 -->
	<div class="col-sm-6 col-xs-12 boxing">
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12">
						<img alt="그룹아이콘" src="${pageContext.request.contextPath}/image/logo/glyphicons-group.png" id="glyphicons-group" >
						<span class="h3"> 채팅방 멤버 </span><span class="badge badge-primary">${fn:length(memberList)}</span>
					</div>
				</div>
			</div>
		</div><hr class="callList-headerLine">
		<div class="row">
			<div class="col-xs-12 scrollBox">
				<!-- 채팅방 목록 -->
				<c:forEach items="${memberList}" var="memberVO">
					<div class="row requestBoxing">
						<div class="col-sm-3 hidden-xs">
							<img alt="프로필사진" src="${pageContext.request.contextPath}${memberVO.mem_profile}" id="glyphicons-group" class="img-circle" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
						</div>
						
						<div class="col-sm-9 col-xs-12">
							<span class="friendMember friendName paddingTop10">${memberVO.mem_id}</span>
						</div>
					</div><hr class="callList-line">
				</c:forEach>
			</div>
		</div>
	</div>
	
	<!-- 친구 목록 -->
	<div class="col-sm-6 col-xs-12 boxing">
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12">
						<img alt="그룹아이콘" src="${pageContext.request.contextPath}/image/logo/glyphicons-group.png" id="glyphicons-group" >
						<span class="h3"> 친구 목록 </span><span class="badge badge-primary">${fn:length(friendList)}</span>
					</div>
				</div>
			</div>
		</div><hr class="callList-headerLine">
		<div class="row">
			<div class="col-xs-12 scrollBox">
				<c:forEach items="${friendList}" var="friendMemberVO">
					<div class="row">
						<div class="col-sm-3 hidden-xs">
							<img alt="프로필사진" src="${pageContext.request.contextPath}${friendMemberVO.mem_profile}" id="glyphicons-group" class="img-circle" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
						</div>
						
						<div class="col-sm-9 col-xs-9">
							<span class="friendTitle friendName">${friendMemberVO.mem_id}</span>
						</div>
						<div class="col-sm-9 col-xs-9">
							<button type="button" class="btn btn-success friendInvite">초대</button>
						</div>
					</div><hr class="callList-line">
				</c:forEach>
			</div>
		</div>
	</div>
	
</div>