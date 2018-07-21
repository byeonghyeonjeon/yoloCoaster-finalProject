<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.reviewMem_id {
	
}
</style>

<script type="text/javascript">
$(function(){
	$('.reviewDeleteBtn').on('click', function(){
		parentBox = $(this).parent();
		var review_seq = parentBox.find('input[name=review_seq]').val();
		var contentidValue = $(contentid).val();
		var contentTypeId = $(contenttypeid).val();
		parentBox.find('input[name=contentid]').val(contentidValue);
		parentBox.find('input[name=contentTypeId]').val(contentTypeId);
		$(this).parent().find('form').submit();
	});
	
})

</script>


<div class="col-xs-12 titleBox">포토리뷰</div>
<div class="row">
	<div class="col-xs-12">
		<c:forEach items="${reviewList}" var="reviewVO">
			<div class="row">
				<div class="col-xs-2 nopadding"><img alt="프로필사진" src="${pageContext.request.contextPath}${reviewVO.mem_profile}" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'" class="img-circle profileImg"></div>
				<div class="col-xs-10">
					<div class="row">
						<div class="reviewMem_id col-md-4 col-xs-4">작성자 : ${reviewVO.review_mem_id}</div>
						<div class="reviewDt col-md-4 col-xs-4">${fn:substring(reviewVO.review_dt,0,4)}년${fn:substring(reviewVO.review_dt,5,7)}월${fn:substring(reviewVO.review_dt,8,10)}일</div>
						<c:if test="${mem_id eq reviewVO.review_mem_id}">
							<div class="col-md-4 col-xs-4" style="text-align: right;">
								<button class="btn btn-default btn-danger reviewDeleteBtn">삭제</button>
								<form action="${pageContext.request.contextPath}/basicInfo/reviewDelete">
									<input type="hidden" name="review_seq" value="${reviewVO.review_seq}">
									<input type="hidden" name="contentid">
									<input type="hidden" name="contentTypeId">
								</form>
							</div>
						</c:if>
					</div>
					<div class="row">
						<div class="reviewTitle col-xs-12">제목 : ${reviewVO.review_title}</div>
						<div class="reviewContent col-xs-12">내용 : ${reviewVO.review_content}</div>
						<div class="reviewImage col-xs-12">
							<c:forEach items="${reviewVO.review_imgList}" var="file_addVO" >
								<div class="col-sm-4">
									<img src="${pageContext.request.contextPath}${file_addVO.add_path}" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'" class="profileImg img-thumbnail">
								</div>
							</c:forEach>
						</div>
						<div class="tagContent col-xs-12">
							<c:forEach items="${reviewVO.review_tagList}" var="tagVO">
								<span class="reviewTag">${tagVO.tag_content}</span>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<hr>
		</c:forEach>
		<!-- 페이지네이션 바-->
		<div class="col-xs-12">
			<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
		</div>
	</div>
</div>