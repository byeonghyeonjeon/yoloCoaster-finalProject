<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	$(function() {
		//페이징처리
		$(".page-link").click(function() {
			var tempNum = $(this).attr("type");
			
			if('${cate_name}' == '') {//검색이 아닌경우
				//이동할 페이지 입력
				$("#pageForm").attr("action","${pageContext.request.contextPath}/adminTravel/adminCategory");
			} else {//검색인 경우
				//이동할 페이지 입력 
				$("#pageForm").attr("action","${pageContext.request.contextPath}/adminTravel/adminCategorySearch?keyword=${cate_name}");
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
			var cate_seq = $($(this).parents().get(1)).attr('title');
			$('#deleteFormInput').val(cate_seq);
			$('#deleteForm').submit();
		});
		
		//활성화 하기
		$('.nBtn').on('click', function(){
			var cate_seq = $($(this).parents().get(1)).attr('title');
			$('#updateYFormInput').val(cate_seq);
			$('#updateYForm').submit();
		});
		
		//비활성화 하기
		$('.yBtn').on('click', function(){
			var cate_seq = $($(this).parents().get(1)).attr('title');
			$('#updateNFormInput').val(cate_seq);
			$('#updateNForm').submit();
		});
		
		//추가하기
		$("#search").click(function() {
			if($('input[name=cate_name]').val() == '')
				return;
			$("#insertTravelForm").submit();
		});
	});
</script>



<div id="page-wrapper">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">카테고리 관리</h1>
			
			<!-- 삭제시 쓰이는 폼태그 -->
			<form action="${pageContext.request.contextPath}/adminTravel/adminCategoryDelete" id="deleteForm">
				<input type="hidden" name="cate_seq" id="deleteFormInput">
			</form>
			
			<!-- 활성화시 쓰이는 폼태그 -->
			<form action="${pageContext.request.contextPath}/adminTravel/adminCategoryUpdateY" id="updateYForm">
				<input type="hidden" name="cate_seq" id="updateYFormInput">
			</form>
			
			<!-- 비활성화시 쓰이는 폼태그 -->
			<form action="${pageContext.request.contextPath}/adminTravel/adminCategoryUpdateN" id="updateNForm">
				<input type="hidden" name="cate_seq" id="updateNFormInput">
			</form>
			
			
			<div class="row">
				<div class="col-sm-5 col-sm-offset-1">
					<!-- 카테고리 추가 창 -->
					<div class="input-group"">
						<form id="insertTravelForm" class="navbar-form" role="search"
							action="${pageContext.request.contextPath}/adminTravel/adminCategoryInsert"
							method="get">
							<input type="text" name="cate_name" class="form-control"
								placeholder="추가할 이름을 입력하세요">
							<div class="input-group-btn">
								<button type="button" id="search" class="btn btn-default">
									<i class="glyphicon glyphicon-plus"></i>
								</button>
							</div>
						</form>
					</div>
				</div>
				<div class="col-sm-4 col-sm-offset-2">
					<!-- 검색 창-->
					<div class="input-group">
						<form id="searchTravelForm" class="navbar-form" role="search"
							action="${pageContext.request.contextPath}/adminTravel/adminCategorySearch"
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
						<th>카테고리명</th>
						<th>날짜</th>
						<th>관리</th>
					</tr>
					<c:forEach items="${categoryList}" var="categoryVO">
						<tr class="tr" title="${categoryVO.cate_seq}">
							<td>${categoryVO.cate_seq}</td>
							<td>${categoryVO.cate_name}</td>
							<td>${categoryVO.cate_dt}</td>
							<td>
								<c:choose>
									<c:when test="${categoryVO.cate_st == 'Y'}">
										<input type="button" class="yBtn btn btn-sm btn-info" value="활성화">
									</c:when>
									<c:otherwise>
										<input type="button" class="nBtn btn btn-sm btn-default" value="비활성">
									</c:otherwise>
								</c:choose>
								<input type="button" name="removeBtn" class="removeBtn btn btn-sm btn-danger" value="삭제">
							</td>
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
									<div>전체 카테고리</div>
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
									<div>활성화 카테고리</div>
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
									<div>비활성화 카테고리</div>
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