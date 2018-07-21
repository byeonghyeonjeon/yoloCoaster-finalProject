<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">


$(function(){
		

	
})

</script>

<div class="row">
				<div class="row">
    	 		<div class="form-group col-sm-offset-1 col-sm-6">
    	 		<input type="hidden" name="list[${rowNum }].detail_seq" value="${detail_seq}">
					<input type="hidden" name="list[${rowNum }].content_shape" value="03">
    	 		<input type="hidden" name="list[${rowNum }].content_title" value="2">
    	 		<input type="hidden" name="list[${rowNum }].content_order" value="${rowNum }">
    	 		 <label for="sel1">여행지 즐겨찾기</label>
    	 		  <select name="list[${rowNum }].content_content" class="form-control .selectBox" id="sel1">
    	 		  
    	 		  <c:forEach items="${bookmarkList}" var="i">
					<option value="${i.contentid }">${i.title}</option>
    	 		  </c:forEach>
				
				</select>	
  				<button class="btn btn-danger btn-delete">삭제</button>					
				</div>
				</div>