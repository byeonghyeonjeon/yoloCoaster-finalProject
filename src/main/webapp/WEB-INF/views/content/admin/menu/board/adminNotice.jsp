<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script>
 
$(function() {
	//검색버튼
	$("#search").click(function() {
		if($('#searchForm input[name=keyword]').val().trim() == ''){
			return;
		}
		$("#searchForm").submit();
	});

	//상세게시글 보기
	$(".a").click(function(){
		var pboardNum =$(this).parent().parent().attr("boardNum"); /* 게시물번호 */
		location.href="${pageContext.request.contextPath}/adminBoard/adminNoticeDetail?link="+pboardNum;
	});
	
	if ('${keyword}' != '') {
		//페이징처리(검색후)
 		$(".page-link").click(function(){
 			var tempNum = $(this).attr("type");
 			var keyword = '${keyword}';
 			//이동할 페이지 입력
 			$("#pageForm").attr("action","${pageContext.request.contextPath}/adminBoard/adminNotice?keyword="+keyword);
			$("#pageNo").val(tempNum);
			$("#pageForm").submit();
 		});
	} else {
		//페이징처리(기본)
 		$(".page-link").click(function(){
 			var tempNum = $(this).attr("type")
 			//이동할 페이지 입력
 			$("#pageForm").attr("action","${pageContext.request.contextPath}/adminBoard/adminNotice");
			$("#pageNo").val(tempNum);
			$("#pageForm").submit();
 		});
	}
	

	//글 삭제
	$(".btn-del").click(function(){
		var link = $(this).parent().parent().attr("boardNum");
	
		var confirmflag = confirm("정말 삭제하시겠습니까?");
	
	          if(confirmflag){
	
	             //확인 버튼 클릭 true 
		           
				
				$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/adminBoard/deleteQna",
				data : JSON.stringify({link : link}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 
					if(data==1){
						alert("삭제되었습니다.");
					}else{
						return;
					}
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}
				})
				
				location.reload(true);
	          }else{
				return;
	             //취소 버튼 클릭 false
	
	           }
	});
	
	//비활성 & 활성
	$(".btn-reset").click(function(){
		var link = $(this).parent().parent().attr("boardNum");
		var board_st = $(this).parent().parent().find(".btn-reset").val();
	
	            //확인 버튼 클릭 true 
			
			$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath}/adminBoard/reSetting",
			data : JSON.stringify({link : link, board_st :board_st }),
			contentType : "application/json; charset=UTF-8",
			dataType : "html",
			success : function(data) { 
				if(data==1){
					alert("변경되었습니다.");
				}else{
					return;
				}
			},
			error : function(xhr) {
				console.log("실패");
				console.log(xhr);
			}
			})
			
			location.reload(true);
	
	});
 });
 
 </script>
 
 
<style>

</style>
<div id="page-wrapper">


                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">게시글 관리</h1>
                        
                        
                        		<!-- 검색 창-->
				
<div class="row">
<div class="col-sm-4 col-sm-offset-8">
		<div class="input-group">
		
			<form id="searchForm"  class="navbar-form" role="search" action="${pageContext.request.contextPath}/adminBoard/adminNotice"	method="get">
				<input type="text" name="keyword" class="form-control" placeholder="검색할 내용을 입력하세요">
				<div class="input-group-btn">
					<button type="button" id="search" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
				</div>
			</form>
		</div>
	</div>
</div>
	
	<div class="col-sm-offset-1 col-sm-10">
		<table class="table table-hover">
		<tr>
		<th>번호</th><th>제목</th>
	
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>관리</th>
		</tr>
		<c:forEach items="${boardList }" var="list">
			<tr class="tr" boardNum="${list.board_seq}">
				<td>${list.board_seq}</td>
				<td><a class="a">${list.board_title}</a></td>
				
				<td>${list.board_mem_id}</td> 
				<td>
				<fmt:formatDate value="${list.board_dt}"  type="date" pattern="yyyy-MM-dd"/>
				</td>
				<td>${list.board_hit}</td>
				
				<td>
					<c:choose>
					<c:when test="${list.board_st eq 'Y'}">
						<button  class="btn btn-info btn-reset"  value="${list.board_st}">활성화</button><button class="btn btn-default btn-del">삭제</button>
					</c:when>
					<c:otherwise >
						<button  class="btn btn-default btn-reset" value="${list.board_st}">비활성</button><button class="btn btn-default btn-del">삭제</button>
					</c:otherwise>
					</c:choose>
				
				</td>
				
				
			</tr>
		</c:forEach>
		</table>
		
			<!--페이지 네이션 -->
	<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
	                        
	                    
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
                       <div class="huge">${stat1 }</div>
                       <div>전체 게시글</div>
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
	                       <div class="huge">${stat2 }</div>
	                       <div>오늘 등록된 게시물</div>
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
		                       <div class="huge">${stat3 }</div>
		                       <div>활성화 게시글</div>
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