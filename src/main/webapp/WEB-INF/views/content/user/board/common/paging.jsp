<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--페이지 네이션  -->
<jsp:include page="/WEB-INF/views/content/user/board/common/page.jsp" flush="true">
			<jsp:param name="firstPageNo" value="${page.firstPageNo}" />
			<jsp:param name="prevPageNo" value="${page.prevPageNo}" />
			<jsp:param name="startPageNo" value="${page.startPageNo}" />
			<jsp:param name="pageNo" value="${page.pageNo}" />
			<jsp:param name="endPageNo" value="${page.endPageNo}" />
			<jsp:param name="nextPageNo" value="${page.nextPageNo}" />
			<jsp:param name="finalPageNo" value="${page.finalPageNo}" />
</jsp:include> 