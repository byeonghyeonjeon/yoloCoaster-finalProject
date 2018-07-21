<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
 
$(function() {
	//검색버튼
	$("#search").click(function() {
		if($('#searchTravelForm input[name=keyword]').val().trim() == ''){
			return;
		}
		$("#searchTravelForm").submit();
	});
	
	if ('${keyword}' != '') {
		//페이징처리(검색후)
 		$(".page-link").click(function(){
 			var tempNum = $(this).attr("type");
 			var keyword = '${keyword}';
			//이동할 페이지 입력
			$("#pageForm").attr("action","${pageContext.request.contextPath}/adminMember/memInfoList?keyword="+keyword);
			$("#pageNo").val(tempNum);
			$("#pageForm").submit();
 		});
	} else {
		$(".page-link").click(function(){
			//페이징처리(기본)
			var tempNum = $(this).attr("type")
			//이동할 페이지 입력
			$("#pageForm").attr("action","${pageContext.request.contextPath}/adminMember/memInfoList");
			$("#pageNo").val(tempNum);
			$("#pageForm").submit();
		});
	}
	
	
	//블랙리스트 처리
	$(".checkbox").change(function(){
		var link = $(this).attr("title");
		if(link==""||link==null){
			link='N';
		}
		var mem_id = $(this).val();
        //확인 버튼 클릭 true 
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath}/adminMember/blackList",
			data : JSON.stringify({mem_id : mem_id, link: link}),
			contentType : "application/json; charset=UTF-8",
			dataType : "html",
			success : function(data) { 
				if(data==1){
					location.reload(true);
				}else{
					location.reload(true);
					return;
				}
			},
			error : function(xhr) {
				console.log("실패");
				console.log(xhr);
			}
		})
		
				
	
	});

 });
 
 </script>


<div id="page-wrapper">

	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">회원 관리</h1>


			<!-- 검색 창-->

			<div class="row">
				<div class="col-sm-4 col-sm-offset-8">
					<div class="input-group">

						<form id="searchTravelForm" class="navbar-form" role="search"
							action="${pageContext.request.contextPath}/adminMember/memInfoList"
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
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>회원명</th>
							<th>성별</th>
							<th>사용여부</th>
							<th>가입일</th>
							<th>탈퇴일</th>
							<th>가입경로</th>
							<th>블랙리스트</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="info" items="${memInfoList}">
							<tr>
								<td>${info.mem_seq}</td>
								<td class=".mem_id">${info.mem_id}</td>
								<td>${info.mem_name}</td>
								<td><c:if test="${info.mem_gen eq 'M'}">남</c:if>
									<c:if test="${info.mem_gen eq 'W'}">여</c:if></td>
								<td>${info.mem_st}</td>
								<td><fmt:formatDate value="${info.join_dt}"
										pattern="yy-MM-dd" /></td>
								<td><fmt:formatDate value="${info.join_drop}"
										pattern="yy-MM-dd" /></td>
								<td>${info.join_path}</td>
								<td>
								
									<c:choose>
									<c:when test="${info.black_st eq 'N'}">
										${info.black_st}<input class="checkbox" checked value="${info.mem_id}" title="${info.black_st}" type="checkbox">
									</c:when>
									<c:otherwise >
										${info.black_st}<input class="checkbox" value="${info.mem_id}" title="${info.black_st}" type="checkbox">
									</c:otherwise>
									</c:choose>
								
								</td>
							</tr>
						</c:forEach>

					</tbody>
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
									<div class="huge">${totalCnt }</div>
									<div>회원 수</div>
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
									<div class="huge">${todayMember }</div>
									<div>오늘 가입자</div>
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
									<div class="huge">${todatDrop }</div>
									<div>오늘 탈퇴자</div>
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

