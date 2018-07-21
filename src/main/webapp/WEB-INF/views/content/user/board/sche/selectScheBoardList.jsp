<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(function() {
		$("#search").click(function() {
			if($('#scheBoardForm input[name=keyword]').val().trim() == ''){
				return;
			}
			$("#scheBoardForm").submit();
		});

		

		//글 보기
		$('.shceTr').on('click', function(){
 			var link = $(this).attr("title")
 			$("#link").val(link);
			location.href="${pageContext.request.contextPath}/scheBoard/selectScheBoardUnit?link="+link;
 		});
		
 		if ('${keyword}' != '') {
			//페이징처리(검색후)
	 		$(".page-link").click(function(){
	 			var tempNum = $(this).attr("type");
	 			var keyword = '${keyword}';
	 			//이동할 페이지 입력
	 			$("#pageForm").attr("action","${pageContext.request.contextPath}/scheBoard/search?keyword="+keyword);
				$("#pageNo").val(tempNum);
				$("#pageForm").submit();
	 		});
		} else {
			//페이징처리
	 		$(".page-link").click(function(){
	 			var tempNum = $(this).attr("type")
				//이동할 페이지 입력
	 			$("#pageForm").attr("action","${pageContext.request.contextPath}/scheBoard/selectScheBoardList");
				$("#pageNo").val(tempNum);
				$("#pageForm").submit();
	 		});
		}
		
	});
</script>

<h2>일정조회게시판</h2>

<!-- 게시판 내부 검색 -->
<div class="row">
<div class="col-xs-5 col-xs-offset-7">
		<div class="input-group pull-right">
			<form id="scheBoardForm" class="navbar-form" role="search" action="${pageContext.request.contextPath}/scheBoard/search"
				method="get"    style="margin-left: 35px; margin-right: -21px;">
				<input type="text" name="keyword" class="form-control" placeholder="검색할 내용을 입력하세요">
				<div class="input-group-btn">
					<button type="button" id="search" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>					
				</div>
			</form>
		</div>
	</div>
</div>

<div class="row">

	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th>번호</th>
	      <th>제목</th>
	      <th>일정</th>
	      <th>시작일</th>
	      <th>종료일</th>
	      <th>여행지</th>
	    </tr>
	  </thead>
	  <tbody>
	  <form id="scheBoard" action="${pageContext.request.contextPath}/scheBoard/selectScheBoardUnit">
	  <input id="link" type="hidden" name="sche_seq" value="">
	  </form>
	  <c:forEach items="${scheList }" var="i">
	   <tr class="shceTr" title="${i.schedule_seq}">
	      <th scope="row">${i.schedule_seq}</th>
	      <td>${i.schedule_title}</td>
	      <td>${i.schedule_date}</td>
	      <td>${i.schedule_start}</td>
	      <td>${i.schedule_end}</td>
	      <td>${i.schedule_count}</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>

</div>

<hr>
<!--페이지 네이션 -->
	<div class="text-center">		
			<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>		
	</div>
