<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.imageBox2 {
	width: 100%;
}
</style>

<script>
	$(function() {
		//이미지 클릭시 모달창 띄움(deligate방식)
		$('#chatContent').on('click', '.imageBox2', function(){
			var imgBox= $(this);
			var imgSrc = imgBox[0].src;
			var imgTitle = imgBox[0].title;
			
			var newImgBox = '<img class="imgInModal" src="' + imgSrc + '" title="' + imgTitle + '">';
			$('#imgModal .modal-body').html(newImgBox);
		});
		
	});
</script>

<div id="albumBox">
	<div class="row">
		<div class="row">
			<c:forEach items="${messageVOList}" var="messageVO" begin="0" end="2">
				<div class="col-sm-4">&nbsp;
					<img src="${pageContext.request.contextPath}/${messageVO.message_content}" title="${messageVO.message_content}" class="imageBox2 img-responsive" data-toggle="modal" data-target="#imgModal"/>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<c:forEach items="${messageVOList}" var="messageVO" begin="3" end="5">
				<div class="col-sm-4">&nbsp;
					<img src="${pageContext.request.contextPath}/${messageVO.message_content}" title="${messageVO.message_content}" class="imageBox2 img-responsive" data-toggle="modal" data-target="#imgModal"/>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<c:forEach items="${messageVOList}" var="messageVO" begin="6" end="8">
				<div class="col-sm-4">&nbsp;
					<img src="${pageContext.request.contextPath}/${messageVO.message_content}" title="${messageVO.message_content}" class="imageBox2 img-responsive" data-toggle="modal" data-target="#imgModal"/>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<!-- 페이지네이션 바-->
	<div class="row">
		<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
	</div>
</div>