<%@ page language="java" contentType="text/html; charSet=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="row">
	<form id="pageForm" action="" method="post">
	<input type="hidden" id="pageNo" name="pageNo" value="">
	<ul class="pagination">
		<li class="page-item"><a  type="${page.firstPageNo}" class="page-link">처음</a></li>
		<li class="page-item"><a type="${page.prevPageNo}" class="page-link">이전</a></li>
		<c:forEach var="i" begin="${page.startPageNo}" end="${page.endPageNo}" step="1">
			<c:choose>
				<c:when test="${i eq page.pageNo}">
					<li class="page-item active"><a class="page-link" type="${i}" class="selected">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" type="${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<li class="page-item"><a type="${page.nextPageNo}" class="page-link">다음</a></li>
		<li class="page-item"><a type="${page.finalPageNo}" class="page-link">마지막</a></li>
	</ul>
	</form>
</div>