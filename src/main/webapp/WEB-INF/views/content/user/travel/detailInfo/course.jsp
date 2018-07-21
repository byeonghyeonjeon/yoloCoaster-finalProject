<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	ul li h2 {
    	font-weight: 600;
    	font-size: 20px;
    }
    ul{
    	list-style: none;
   		list-style-image: none;
    }
    
    .courseImg {
/*      	width: 100%;  */
/* 		width : 50%; */
/* 		height: 300px; */
/* 		border: 1px solid lightgray; */
/* 		height: 120px; */
		max-width: 100%;
		    border: 0;
   	    vertical-align: top;
    }
    
    .cour{
     	padding-bottom: 20px; 
    }
    
    .cour2{
    	padding-top : 30px;
    	padding-bottom : 10px;
    }
    
    .CourText{
    	font-size: 15px;
    }
</style>

<div>
	<ul>
		<li>
<!-- 			<h2><strong>코스 정보</strong></h2> -->
			<ul>
				<c:forEach items="${courseVOs }" var="courseVO" >
					<li class="cour2"><h4><strong>${courseVO.subnum+1} 코스 : ${courseVO.subname}</strong></h4></li>
					<li class="cour">
						<c:if test="${courseVO.subdetailimg ne '없음'}">
							<img class="courseImg" alt="대표 이미지" src="${courseVO.subdetailimg}" 
							onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
						</c:if>
					</li>
					<li class="CourText">${courseVO.subdetailoverview }</li>
				</c:forEach>
			</ul>
		</li>
	</ul>
</div>