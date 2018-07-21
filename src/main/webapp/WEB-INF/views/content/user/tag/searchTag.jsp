<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
/*리스트 이미지*/
.list_img {
	width: 120px;
	height: 120px;
	float: left;
}
/*리스트 제목*/
.list_title {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 1; /* 라인수 (빨강되는게 맞음)*/
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-height: 1.2em;
	height: 1.2em;
	/* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
}
/*리스트 주소*/
.list_addr {
	color: gray;
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 2; /* 라인수 (빨강되는게 맞음)*/
	-webkit-box-orient: vertical;
	word-wrap: break-word;
	line-height: 1.2em;
	height: 2.4em;
	/* line-height 가 1.2em 이고 3라인을 자르기 때문에 height는 1.2em * 3 = 3.6em */
}
</style>


<script type="text/javascript">
/* 페이징 처리 */
$('div.row').on('click', '.page-link', function(){
	var pageNum = $(this).attr("type");
	var parameter = 'selected=tag&keyword=' + '${keyword}' + '&pageNo=' + $(this).attr('type'); 
	var href = '${pageContext.request.contextPath }/travel/search?' + parameter;
	window.location.href = href;
});
</script>

<!-- 상세검색 결과 페이지 -->
<div>
	<div>
		<h2><span style="color: blue;">#${keyword}</span> 의 결과</h2>
	</div>
	
	<c:choose>
		<c:when test="${fn:length(travelVOs) == 0}">
			<div class="row">
				&nbsp;&nbsp;${keyword}에 대한 검색결과가 없습니다.
				<br><br>
				<ul>
					<li>단어의 철자가 정확한지 확인해 보세요.</li>
					<li>한글을 영어로 혹은 영어를 한글로 입력했는지 확인해 보세요.</li>
					<li>검색어의 단어 수를 줄이거나, 보다 일반적인 검색어로 다시 검색해 보세요.</li>
				</ul>
			</div>
		</c:when>
		
		<c:otherwise>
			<div class="row">
				<c:forEach items="${travelVOs}" var="travelVO" varStatus="status">
					<div class="col-lg-6 col-xs-12">
						<div>
							<c:choose>
								<c:when test="${travelVO.firstimage2 == '없음'}">
									<img class="img-rounded list_img" src="${pageContext.request.contextPath }/image/logo/noImage.png">
								</c:when>
								<c:otherwise>
									<img class="img-rounded list_img" src="${travelVO.firstimage2}">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-8 col-sm-8 col-xs-12">
							<a href="${pageContext.request.contextPath}/basicInfo/basicInfo?contentid=${travelVO.contentid}&contentTypeId=${travelVO.contenttypeid}"> <!--text overFlow 1줄 STYLE-->
								<h4 class="list_title">${status.count}.${travelVO.title}</h4>
							</a>
							<!--text overFlow 2줄 STYLE-->
							<div class="col-md-12 col-sm-12 col-xs-12 list_addr">
								${travelVO.addr1}
							</div>
							<br><br>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"
										style="font-size: 30px;"></span> <span class="badge">${travelVO.goodCount}</span>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<span class="glyphicon glyphicon-comment" aria-hidden="true"
										style="font-size: 30px;"></span> <span class="badge">${travelVO.reviewCount}</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<br>
		
			<div class="row">
				<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
			</div>
		</c:otherwise>
	</c:choose>
</div>