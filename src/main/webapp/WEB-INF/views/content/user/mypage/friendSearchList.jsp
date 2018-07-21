<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(function(){
	var mem_id = $('#mem_id_hidden').val().trim();
	
	/* 친구 요청시(ajax를 이용) */
	$('.friendRequestY').on('click', function(){
		var friend_id = $(this).parent().parent().find('.friendTitle').text();
		console.log(friend_id);
		
		var searchMem_id = $('#searchFriendId').val().trim();
		
		if(searchMem_id != ''){//공백이 아닌 경우
			$.ajax({
				method: "post",
				url: "${pageContext.request.contextPath}/friend/createFriend",
				data: JSON.stringify({searchMem_id : searchMem_id, mem_id : mem_id, friend_id : friend_id}),
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
	
	/* 친구 요청취소시(ajax를 이용) */
	$('.friendRequestN').on('click', function(){
		var friend_id = $(this).parent().parent().find('.friendTitle').text();
		console.log(friend_id);
		
		var searchMem_id = $('#searchFriendId').val().trim();
		
		if(searchMem_id != ''){//공백이 아닌 경우
			$.ajax({
				method: "post",
				url: "${pageContext.request.contextPath}/friend/cancelFriend",
				data: JSON.stringify({searchMem_id : searchMem_id, mem_id : mem_id, friend_id : friend_id}),
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
<!-- 친구 찾은 목록 ajax로 리로딩 -->
<c:forEach items="${searchFriendList}" var="friendMemberVO">
	<div class="row">
		<div class="col-sm-3 hidden-xs text-center">
			<img alt="그룹아이콘" src="${pageContext.request.contextPath}${friendMemberVO.mem_profile}" id="glyphicons-group" class="img-circle" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
		</div>
		
		<div class="col-sm-8 col-xs-8">
			<span class="friendTitle friendName">${friendMemberVO.mem_id}</span>
		</div>
		
		<div class="col-sm-4 col-xs-4">
			<c:choose>
				<c:when test="${friendMemberVO.friend_request == 'W'}">
					<button type="button" class="btn btn-danger friendRequestN">요청취소</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-success friendRequestY">친구요청</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div><hr class="callList-line">
</c:forEach>
