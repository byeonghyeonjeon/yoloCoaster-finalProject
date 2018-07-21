<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	$(function() {
		
		$("#search").click(function() {
			if($('#searchTravelForm input[name=keyword]').val().trim() == ''){
				return;
			}
			$("#searchTravelForm").submit();
		});

			
		//글 자세히보기 이동
		$(".tr").click(function(){
			var link = $(this).attr("title");
			location.href="${pageContext.request.contextPath}/board/travelDetail?link="+link;
		});
		
		
 		if ('${keyword}' != '') {
			//페이징처리(검색후)
	 		$(".page-link").click(function(){
	 			var tempNum = $(this).attr("type");
	 			var keyword = '${keyword}';
	 			//이동할 페이지 입력
	 			$("#pageForm").attr("action","${pageContext.request.contextPath}/board/travelSearch?keyword="+keyword);
				$("#pageNo").val(tempNum);
				$("#pageForm").submit();
	 		});
		} else {
			//페이징처리
	 		$(".page-link").click(function(){
	 			var tempNum = $(this).attr("type")
	 			//이동할 페이지 입력
	 			$("#pageForm").attr("action","${pageContext.request.contextPath}/board/travelMain");
				$("#pageNo").val(tempNum);
				$("#pageForm").submit();
	 		});
		}
		
			
 		
 		//글 쓰기로 이동
		$(".btn-insertTravel").click(function(){
			var link = $(this).attr("title");
			location.href="${pageContext.request.contextPath}/board/travelInsert";
		});
		
	});
	

</script>

	<h2>여행후기게시판</h2>
	
		<!-- 검색 창-->
				
<div class="row">
<div class="col-sm-5 col-sm-offset-7">
		<div class="input-group pull-right">
			<form id="searchTravelForm"  class="navbar-form" role="search" action="${pageContext.request.contextPath}/board/travelSearch"	method="get" style="margin-left: 25px;margin-right: -20px;">
				<input type="text" name="keyword" class="form-control" placeholder="검색할 내용을 입력하세요">
				<div class="input-group-btn">
					<button type="button" id="search" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
				</div>
			</form>
		</div>
	</div>
</div>
	
	
	
	<table class="table table-hover">
	<tr>
	<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
	</tr>
	<c:forEach items="${boardList }" var="list">
		<tr class="tr" title="${list.board_seq}">
			<td>${list.board_seq}</td>
			<td>${list.board_title}</td>
			<td>${list.board_mem_id}</td> 
			<td>
			<fmt:formatDate value="${list.board_dt}"  type="date" pattern="yyyy-MM-dd"/>
			</td>
			<td>${list.board_hit}</td>
		</tr>
	</c:forEach>
	
	
</table>
<div class="row">
	<div class="col-sm-offset-11 col-sm-1">
	<%if(request.getAttribute("mem_id")+""!=null){ %>
			<button class="btn btn-default btn-insertTravel">
			글쓰기
			</button>
	<%} %>
	</div>
</div>
	
	<!--페이지 네이션 -->
	<div class="text-center" >
	<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
	</div>
	
