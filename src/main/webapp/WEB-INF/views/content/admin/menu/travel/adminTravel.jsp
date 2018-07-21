<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.reviewTag {
	background-color: lightskyblue;
	margin: 10px;
	border-radius: 5px;
}
</style>

<script>
	$(function() {
		var flag = true;
		
		$(".tr").click(function() {
			if(flag == false){
				flag = true;
				return;
			}
			var review_seq = $(this).attr("title");
			$.ajax({
				method: "post",
				url: "${pageContext.request.contextPath}/adminTravel/adminReviewDetail",
				data: JSON.stringify({review_seq : review_seq}),
				contentType: "application/json; charset=UTF-8",
				dataType : "json",
				success: function(data) {
					var contentBoxArr = $('#modal-body').find('div.row div.col-sm-10');
					
					$(contentBoxArr.get(0)).html(data.review_seq);
					$(contentBoxArr.get(1)).html(data.review_title);
					$(contentBoxArr.get(2)).html(data.review_content);
					
					//이미지 박스 생성
					var imgList = data.review_imgList;
					if (imgList.length != 0) {
						var imgBox = '<div id="myCarousel" class="carousel slide" data-ride="carousel">';

						imgBox += '<div class="carousel-inner">';
						for (var i = 0; i < imgList.length; i++) {
							var fileAddVO = imgList[i];
							if(i != 0) {
								imgBox+= '<div class="item">';
							} else {
								imgBox+= '<div class="item active">';
							}
							imgBox+= '<img src="${pageContext.request.contextPath}' + fileAddVO.add_path + '" alt="' + fileAddVO.add_oriname + '" style="width:100%;" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'">';
							imgBox+= '</div>';
						}
						imgBox += '</div>';

					    imgBox += '<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span><span class="sr-only">Previous</span></a>';
					    imgBox += '<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span><span class="sr-only">Next</span></a>';
					    imgBox += '</div>';
					    
					    $(contentBoxArr.get(3)).html(imgBox);
					} else {
						$(contentBoxArr.get(3)).html('없음');
					}
					
					
					//태그 박스 생성
					var tagList = data.review_tagList;
					var tagBox = '';
					if (tagList.length == 0) {
						$(contentBoxArr.get(4)).html('없음');
					} else {
						for (var i = 0; i < tagList.length; i++) {
							tagBox += '<span class="reviewTag">' + tagList[i].tag_content + '</span>';
						}
						$(contentBoxArr.get(4)).html(tagBox);
					}
					
					$('#myModal').modal('show');
				},
				error : function(xhr) {
					console.log(xhr);
				}
			})
			
		});

		//페이징처리
		$(".page-link").click(function() {
			var tempNum = $(this).attr("type");
			
			if('${review_title}' == '') {//검색이 아닌경우
				//이동할 페이지 입력
				$("#pageForm").attr("action","${pageContext.request.contextPath}/adminTravel/adminReview");
			} else {//검색인 경우
				//이동할 페이지 입력 
				$("#pageForm").attr("action","${pageContext.request.contextPath}/adminTravel/adminReviewSearch?keyword=${review_title}");
			}
			$("#pageNo").val(tempNum);
			$("#pageForm").submit();
		});
		
		//검색
		$("#search").click(function() {
			flag = false;
			if($('input[name=keyword]').val() == '')
				return;
			$("#searchTravelForm").submit();
		})
		
		//삭제하기(상세화면)
		$('#removeBtn').on('click', function(){
			var review_seq = $($($(this).parents()).find('div.row div.col-sm-10').get(0)).text();
			deleteReview(review_seq);
		});
		
		//삭제하기(리스트)
		$('.removeBtn').on('click', function(){
			flag = false;
			var review_seq = $($(this).parents().get(1)).attr('title');
			deleteReview(review_seq);
		});
		
		
		function deleteReview(review_seq){
			$('#deleteFormInput').val(review_seq);
			$('#deleteForm').submit();
			
		}
	});
</script>


<!-- modal 상세화면 -->
<div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="true" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="gridSystemModalLabel">상세정보</h4>
			</div>
			<div class="modal-body">
				<div class="container-fluid" id="modal-body">
					<div class="row">
						<div class="col-sm-2">번호</div>
						<div class="col-sm-10">번호~~</div>
					</div>
					<div class="row">
						<div class="col-sm-2">제목</div>
						<div class="col-sm-10">제목~~</div>
					</div>
					<div class="row">
						<div class="col-sm-2">내용</div>
						<div class="col-sm-10">내용~~</div>
					</div>
					<div class="row">
						<div class="col-sm-2">이미지</div>
						<div class="col-sm-10">이미지~~</div>
					</div>
					<div class="row">
						<div class="col-sm-2">태그</div>
						<div class="col-sm-10">태그~~</div>
					</div>
					
					
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" id="removeBtn">삭제</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- 페이지 -->
<div id="page-wrapper">
	<!-- Page Heading -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">리뷰 관리</h1>
			
			<!-- 삭제시 쓰이는 폼태그 -->
			<form action="${pageContext.request.contextPath}/adminTravel/adminReviewDelete" id="deleteForm">
				<input type="hidden" name="review_seq" id="deleteFormInput">
			</form>
			
			
			
			<!-- 검색 창-->
			<div class="row">
				<div class="col-sm-4 col-sm-offset-8">
					<div class="input-group">
						<form id="searchTravelForm" class="navbar-form" role="search"
							action="${pageContext.request.contextPath}/adminTravel/adminReviewSearch"
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
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${reviewList}" var="reviewVO">
						<tr class="tr" title="${reviewVO.review_seq}">
							<td>${reviewVO.review_seq}</td>
							<td>${reviewVO.review_title}</td>
							<td>${reviewVO.review_mem_id}</td>
							<td>${reviewVO.review_dt}</td>
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
									<div>전체 리뷰</div>
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
									<div>오늘 등록된 리뷰</div>
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
									<div>전체 메세지</div>
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