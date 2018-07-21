<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	$(function() {
		//페이징처리
		$(".page-link").click(function() {
			var tempNum = $(this).attr("type");
			
			if('${tag_content}' == '') {//검색이 아닌경우
				//이동할 페이지 입력
				$("#pageForm").attr("action","${pageContext.request.contextPath}/adminTravel/adminTag");
			} else {//검색인 경우
				//이동할 페이지 입력 
				$("#pageForm").attr("action","${pageContext.request.contextPath}/adminTravel/adminTagSearch?keyword=${tag_content}");
			}
			$("#pageNo").val(tempNum);
			$("#pageForm").submit();
		});
		
		//검색
		$("#search").click(function() {
			if($('input[name=keyword]').val() == '')
				return;
			$("#searchTravelForm").submit();
		})
		
		//삭제하기(리스트)
		$('.removeBtn').on('click', function(){
			var tag_content = $($(this).parents().get(1)).attr('title');
			deleteReview(tag_content);
		});
		
		
		function deleteReview(tag_content){
			$('#deleteFormInput').val(tag_content);
			$('#deleteForm').submit();
		}
	});
</script>



<div id="page-wrapper">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">태그 관리</h1>
			
			<!-- 삭제시 쓰이는 폼태그 -->
			<form action="${pageContext.request.contextPath}/adminTravel/adminTagDelete" id="deleteForm">
				<input type="hidden" name="tag_content" id="deleteFormInput">
			</form>
			
			
			
			<!-- 검색 창-->
			<div class="row">
				<div class="col-sm-4 col-sm-offset-8">
					<div class="input-group">
						<form id="searchTravelForm" class="navbar-form" role="search"
							action="${pageContext.request.contextPath}/adminTravel/adminTagSearch"
							method="get">
							<input type="text" name="keyword" class="form-control"
								placeholder="검색할 내용을 입력하세요">
							<div class="input-group-btn">
								<button type="button" id="search" class="btn btn-default">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-sm-offset-1 col-sm-10">
				<table class="table table-hover">
					<tr>
						<th>번호</th>
						<th>태그내용</th>
						<th>태그개수</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${tagList}" var="tagCountVO" varStatus="i">
						<tr class="tr" title="${tagCountVO.tag_content}">
							<c:choose>
								<c:when test="${i.count ne 10}">
									<td>${pageVO.pageNo - 1}${i.count}</td>
								</c:when>
								<c:otherwise>
									<td>${pageVO.pageNo * i.count}</td>
								</c:otherwise>
							</c:choose>
							
							<td>${tagCountVO.tag_content}</td>
							<td>${tagCountVO.tag_count}</td>
							<td><input type="button" name="removeBtn" class="removeBtn btn btn-sm btn-danger" value="삭제"></td>
						</tr>
					</c:forEach>
				</table>

				<!--페이지 네이션 -->
				<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp"%>
			</div>
			<!-- /.row -->
			<div class="row col-sm-offset-1 col-sm-10">
				
				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${stat1}</div>
									<div>전체 태그</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${stat2}</div>
									<div>오늘 등록된 태그</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${stat3}</div>
									<div>오늘 보내진 메세지</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
<!-- /#page-wrapper -->