<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<script>
	
	$(function() {
	var tempBookmarkNum=0;
		$("#deletebtn").click(function() {
			
			$("#selectBookmarkAreaForm").attr("action","${pageContext.request.contextPath}/myPage/deleteBookmarkAreaList");
			$("#selectBookmarkAreaForm").submit();
		});

		$('.delBtn').on('click', function(){
 			var link = $(this).val();
			location.href="${pageContext.request.contextPath}/myPage/deleteBookmarkArea?link="+link;
 		});
	});
</script>
<div class="row">
	<form action="${pageContext.request.contextPath}/myPage/selectBookmarkArea" id="selectBookmarkAreaForm" method="get">
		 <h2>여행지 즐겨찾기</h2>
		 <%if(request.getAttribute("bookmarkAreaList")!=null){
			 %>
		  <table class="table table-hover">
		    <thead>
		    	<tr>
			        <th>번호</th>
			        <th>사진</th>
			        <th>제목</th>
			        <th>삭제</th>
		    	</tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${bookmarkAreaList }" var="i">
		    	<tr class="tr" title="${i.bookmark_area_seq }">
			        <td><input type="checkbox" class="checkbox" name="delBookmark" value="${i.bookmark_area_seq }" />${i.bookmark_area_seq }</td>
			        <td><img src="${i.firstimage2 }" width="150px;" height="150px;"></td>
			        <td>
			        <a href="/yoloCoaster/basicInfo/basicInfo?contentid=${i.contentid}">
			        	${i.title }</a>
		        	</td>
			        <td>
			        	<button type="button" value="${i.bookmark_area_seq }" class="btn btn-default btn-lg delBtn">
			        		<span class="glyphicon glyphicon-trash"></span>
			        	</button>
			        </td>

		      	</tr>
		    	</c:forEach>
		    </tbody>
		  </table>	
		  <% }else{
		 %>
		 <h2>
		 즐겨찾기한 내역이 없습니다.
		 </h2>
		 <%
		 }
		 %>
	</form>
</div>

<!-- 선택삭제 -->
	<div class="row">
			<div class="col col-xs-4">
				<button type="button" id="deletebtn" class="btn btn-default">선택삭제</button>
			</div>
	</div>
	
<!--페이지 네이션 -->
	<div class="row">
		<div class="col col-xs-8">
			<%@include file="/WEB-INF/views/content/user/board/common/paging.jsp" %>
		</div>
	</div>


