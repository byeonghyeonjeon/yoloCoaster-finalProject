<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	$(function() {
		$("#search").click(function() {
			if($('#searchQnaForm input[name=keyword]').val().trim() == ''){
				return;
			}
			$("#searchQnaForm").submit();
		});
		
		var sessionCheck =0;
		
		//글 자세히보기 이동
		$(".tr").click(function(){
			var link = $(this).attr("type");
			var qndPrivate = $(this).find("td").eq(5).html(); 
			var userId = $(this).find("td").eq(3).html(); 

			if(qndPrivate!="Y"){
				//세션아이디와 같을때만 이동
				//에이젝스처리
				
				
				$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/qna/sessionCheck",
				data : JSON.stringify({userId : userId}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 
					sessionCheck=data
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}
					
			})
				
				
				
				
				if(sessionCheck!=1){
					alert("본인만 확인가능합니다.");
					return;
				}
			}
			location.href="${pageContext.request.contextPath}/qna/qnaDetail?boardNo="+link;
		});

		
		if ('${keyword}' != '') {
			//페이징처리(검색후)
	 		$(".page-link").click(function(){
	 			var tempNum = $(this).attr("type");
	 			var keyword = '${keyword}';
	 			//이동할 페이지 입력
	 			$("#pageForm").attr("action","${pageContext.request.contextPath}/qna/qnaSearch?keyword="+keyword);
				$("#pageNo").val(tempNum);
				$("#pageForm").submit();
	 		});
		} else {
			//페이징처리(기본)
	 		$(".page-link").click(function(){
	 			var tempNum = $(this).attr("type")
	 			//이동할 페이지 입력
	 			$("#pageForm").attr("action","${pageContext.request.contextPath}/qna/qnaMain");
				$("#pageNo").val(tempNum);
				$("#pageForm").submit();
	 		});
		}
			
	});
</script>


<h2>Q&A</h2>

		<!-- 게시판 내부 검색 -->
		<div class="row ">
			<div class="col-sm-5 col-sm-offset-7">
					<div class="input-group pull-right">
						<form id="searchQnaForm" class="navbar-form" role="search" action="${pageContext.request.contextPath}/qna/qnaSearch" method="get"
						style="margin-left: 25px;    margin-right: -20px;">
							<input type="text" name="keyword" class="form-control" placeholder="검색할 내용을 입력하세요">
							<div class="input-group-btn">
								<button type="button" id="search" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
							</div>
						</form>
					</div>
			</div>
		</div>
		
		<!--게시글 자세히 보기  -->
			<table class="table table-hover">
				<tr>
 				<th class="col-sm-1">번호</th><th class="col-sm-4">제목</th><th class="col-sm-2">상태</th>
				<th class="col-sm-2">작성자</th><th class="col-sm-2">작성일</th><th class="col-sm-1">공개여부</th>
				</tr>
				<c:forEach items="${boardList }" var="list">
					<tr type="${list.board_seq}" class="tr">
						<td >${list.board_seq}</td>
						<td>
							${list.board_title}
						</td>
						
						<c:choose>
							<c:when test="${list.board_reply eq '0'}">
								<td><button class="btn btn-default">답변대기</button></td> 
							</c:when>
							<c:otherwise >
								<td><button class="btn btn-info">답변완료</button></td> 
							</c:otherwise>
						</c:choose>
						
						
						<td>${list.board_mem_id}</td> 
						<td>
						<fmt:formatDate value="${list.board_dt}"  type="date" pattern="yyyy-MM-dd"/>
						</td>
						<td class=".qndPrivate" id="${list.board_private}">${list.board_private}</td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
			<%if(request.getAttribute("mem_id")+""!=null){ %>
		<div class="col-sm-offset-11 col-sm-1">
			<a class="btn btn-default" href="${pageContext.request.contextPath}/qna/qnaInsert">QNA작성</a>
		</div>
			<%} %>
	<!--페이지 네이션 -->
	<div class="row">
		<div class="text-center">
			<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
		</div>
	</div>

