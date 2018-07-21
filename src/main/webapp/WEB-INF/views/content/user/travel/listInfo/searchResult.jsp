<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<!-- 상세검색 결과 페이지 -->
<div>
	<div>
		<h5 style="color: gray;">&nbsp; ${totalCount}곳의
			<c:choose>
				<c:when test="${contentTypeId == '12'}">관광지</c:when>
				<c:when test="${contentTypeId == '14'}">문화시설</c:when>
				<c:when test="${contentTypeId == '25'}">여행코스</c:when>
				<c:when test="${contentTypeId == '28'}">레포츠</c:when>
			</c:choose>
		</h5>
	</div>
	<!--row  첫번째 행 -->
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

	<!-- 페이지네이션 바-->
	<div class="row">
		<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
	</div>
	<!--end 리스트 더보기-->
</div>