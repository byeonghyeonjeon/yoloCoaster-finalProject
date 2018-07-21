<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
--> /*카테고리 버튼 폭*/
/*리스트 이미지*/
.list_img {
	width: 120px;
	/* height: 120px; */
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

.area{
	font-size: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
	
}
</style>

<script type="text/javascript">
	$(function() {
		/* 카테고리 버튼 클릭 이벤트 */
		$('.categoryVO').on('click', function() {
			$('#cate_name').val($(this).text());
			$('#selected').val("02");
			$('#searchByKeyword').submit();
		})
		
		/* 관심지역 더보기 */
		$('#clickListMore').on('click', function(){
			location.href="${pageContext.request.contextPath}/areaMore?select=area";
		});
		
		/* 프로필 기반 더보기 */
		$('#profileListMore').on('click', function(){
			location.href="${pageContext.request.contextPath}/areaMore?select=profile";
		});
		
		/* 지역 축제 추천 여행지 더보기 */
		$('#eventListMore').on('click', function(){
			location.href="${pageContext.request.contextPath}/areaMore?select=event";
		});
	})
</script>
<!--추천 카테고리-->
<div>
	<div>
		<h3>추천 카테고리</h3>
		${totalCount}<br> ${pageNo}<br> ${travelVOs}<br>

		<form action="${pageContext.request.contextPath}/main"
			id="searchByKeyword" method="post">
			<input type="hidden" id="cate_name" name="cate_name"> <input
				type="hidden" id="selected" name="selected">
		</form>
		<!-- 카테고리 첫번째 row -->
		<div class="row">
			<div class="col-md-1 col-sm-1 col-xs-1"></div>
			<div class="col-md-10 col-sm-10 col-xs-10 ">
				<c:forEach items="${categoryVOs}" var="category" begin="0" end="5">
					<div class="col-md-2 col-sm-4 col-xs-6">
						<button type="button"
							class="btn btn-default btn-lg btn-block categoryVO">${category.cate_name}</button>
					</div>
				</c:forEach>
			</div>

		</div>
		<!-- end 카테고리 첫번째 row -->

		<!-- 카테고리 두번째 row -->
		<div class="row">
			<div class="col-md-1 col-sm-1 col-xs-1"></div>
			<div class="col-md-10 col-sm-10 col-xs-10 ">
				<c:forEach items="${categoryVOs}" var="category" begin="6" end="11">
					<div class="col-md-2 col-sm-4 col-xs-6">
						<button type="button"
							class="btn btn-default btn-lg btn-block categoryVO">${category.cate_name}</button>
					</div>
				</c:forEach>
			</div>

		</div>
		<!-- end 카테고리 두번째 row -->
	</div>
</div>
<!--end 추천 카테고리-->

<hr>

<!--관심 지역 기반 추천 여행지-->
<c:if test="${!empty areaCnt}">
	<div>
		<div>
			<h3>관심지역 기반 추천 여행지</h3>
				<h5 style="color: gray;">&nbsp; ${areaCnt }곳의 여행지</h5>
		</div>
		<!--row  첫번째 행 -->
		<div class="row">
			<c:forEach items="${basicinfoVO}" var="basicinfoVO" varStatus="status">
				<div class="col-lg-6 col-xs-12">
					<div>
						<c:choose>
							<c:when test="${basicinfoVO.firstimage2 == '없음'}">
								<img class="img-rounded list_img" src="${pageContext.request.contextPath }/image/logo/noImage.png">
							</c:when>
							<c:otherwise>
								<img class="img-rounded list_img" src="${basicinfoVO.firstimage2}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-12">
						<a href="${pageContext.request.contextPath}/basicInfo/basicInfo?contentid=${basicinfoVO.contentid}&contentTypeId=${basicinfoVO.contenttypeid}"> <!--text overFlow 1줄 STYLE-->
							<h4 class="list_title">${status.count}.${basicinfoVO.title}</h4>
						</a>
						<!--text overFlow 2줄 STYLE-->
						<div class="col-md-12 col-sm-12 col-xs-12 list_addr">
							${basicinfoVO.addr1}
						</div>
						<br><br>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"
									style="font-size: 30px;"></span> <span class="badge">${basicinfoVO.goodCount}</span>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<span class="glyphicon glyphicon-comment" aria-hidden="true"
									style="font-size: 30px;"></span> <span class="badge">${basicinfoVO.reviewCount}</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- end row 두번째 행-->
		<br>
		<!--리스트 더보기-->
		<div class="row">
			<div class="col-md-9"></div>
			<div class="col-md-3">
				<button type="button" class="btn btn-default btn-lg" id="clickListMore">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					리스트 더보기
				</button>
			</div>
		</div>
		<!--end 리스트 더보기-->
	</div>
</c:if>
<c:if test="${empty areaCnt}">
	<div>
		<div>
			<h3>관심지역 기반 추천 여행지</h3>
				<h5 style="color: gray;" class="area">&nbsp; 회원가입을 하시고 관심지역을 설정하시면 추천받을 수 있습니다.</h5>
		</div>
	</div>
</c:if>
<!-- end 관심 지역 기반 추천 여행지-->

<hr>
<!--프로필 기반 추천 여행지-->
<c:if test="${!empty profileCnt}">
	<div>
		<div>
			<h3>프로필 기반 추천 여행지</h3>
			<h5 style="color: gray;">&nbsp; ${profileCnt }곳의 여행지</h5>
		</div>
		<!--row  첫번째 행 -->
		<div class="row">
			<c:forEach items="${profileBasicVO}" var="basicinfoVO" varStatus="status">
				<div class="col-lg-6 col-xs-12">
					<div>
						<c:choose>
							<c:when test="${basicinfoVO.firstimage2 == '없음'}">
								<img class="img-rounded list_img" src="${pageContext.request.contextPath }/image/logo/noImage.png">
							</c:when>
							<c:otherwise>
								<img class="img-rounded list_img" src="${basicinfoVO.firstimage2}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-12">
						<a href="${pageContext.request.contextPath}/basicInfo/basicInfo?contentid=${basicinfoVO.contentid}&contentTypeId=${basicinfoVO.contenttypeid}"> <!--text overFlow 1줄 STYLE-->
							<h4 class="list_title">${status.count}.${basicinfoVO.title}</h4>
						</a>
						<!--text overFlow 2줄 STYLE-->
						<div class="col-md-12 col-sm-12 col-xs-12 list_addr">
							${basicinfoVO.addr1}
						</div>
						<br><br>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"
									style="font-size: 30px;"></span> <span class="badge">${basicinfoVO.goodCount}</span>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<span class="glyphicon glyphicon-comment" aria-hidden="true"
									style="font-size: 30px;"></span> <span class="badge">${basicinfoVO.reviewCount}</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- end row 두번째 행-->
		<br>
		<!--리스트 더보기-->
		<div class="row">
			<div class="col-md-9"></div>
			<div class="col-md-3">
				<button type="button" class="btn btn-default btn-lg" id="profileListMore">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					리스트 더보기
				</button>
			</div>
		</div>
		<!--end 리스트 더보기-->
	</div>
</c:if>

<c:if test="${empty profileCnt}">
	<div>
		<div>
			<h3>프로필 기반 추천 여행지</h3>
				<h5 style="color: gray;" class="area">&nbsp; 회원가입을 하시고 주소를 설정하시면 추천받을 수 있습니다.</h5>
		</div>
	</div>
</c:if>

<!-- end 프로필 기반 추천 여행지-->

<hr>
<!--지역 축제 정보-->
<c:if test="${!empty eventCnt}">
	<div>
		<div>
			<h3>지역 축제 추천 여행지</h3>
			<h5 style="color: gray;">&nbsp; ${eventCnt }곳의 여행지</h5>
		</div>
		<!--row  첫번째 행 -->
		<div class="row">
			<c:forEach items="${eventBasicVO}" var="basicinfoVO" varStatus="status">
				<div class="col-lg-6 col-xs-12">
					<div>
						<c:choose>
							<c:when test="${basicinfoVO.firstimage2 == '없음'}">
								<img class="img-rounded list_img" src="${pageContext.request.contextPath }/image/logo/noImage.png">
							</c:when>
							<c:otherwise>
								<img class="img-rounded list_img" src="${basicinfoVO.firstimage2}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-12">
						<a href="${pageContext.request.contextPath}/basicInfo/basicInfo?contentid=${basicinfoVO.contentid}&contentTypeId=${basicinfoVO.contenttypeid}"> <!--text overFlow 1줄 STYLE-->
							<h4 class="list_title">${status.count}.${basicinfoVO.title}</h4>
						</a>
						<!--text overFlow 2줄 STYLE-->
						<div class="col-md-12 col-sm-12 col-xs-12 list_addr">
							${basicinfoVO.addr1}
						</div>
						<br><br>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"
									style="font-size: 30px;"></span> <span class="badge">${basicinfoVO.goodCount}</span>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<span class="glyphicon glyphicon-comment" aria-hidden="true"
									style="font-size: 30px;"></span> <span class="badge">${basicinfoVO.reviewCount}</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- end row 두번째 행-->
		<br>
		<!--리스트 더보기-->
		<div class="row">
			<div class="col-md-9"></div>
			<div class="col-md-3">
				<button type="button" class="btn btn-default btn-lg" id="eventListMore">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					리스트 더보기
				</button>
			</div>
		</div>
		<!--end 리스트 더보기-->
	</div>
</c:if>
<c:if test="${empty eventCnt}">
	<div>
		<div>
			<h3>지역 축제 추천 여행지</h3>
				<h5 style="color: gray;" class="area">&nbsp; 회원가입을 하시고 주소를 설정하시면 추천받을 수 있습니다.</h5>
		</div>
	</div>
</c:if>


<!-- end 지역 축제 정보-->
<hr>