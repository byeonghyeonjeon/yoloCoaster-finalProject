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
   	   
    }
    
    .etc{
/*      	padding-bottom: 20px;  */
    }
    
    .etc2{
    	width : 16%;
    }
    
    .etc2Text{
    	font-size: 15px;
    }
    
    .etcTr{
    	width : 300px;
    }
</style>

<div>
	<c:choose>
		<c:when test='${etcVOs ne "없음" }'>
			<table class="table">
				<c:forEach items="${etcVOs}" var="etcVO" >
					<tr class="tr">
						<td class="etc2 td"><h4><strong>${etcVO.infoname}</strong></h4></td>
						<td class="etc2Text td">${etcVO.infotext }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test='${etcVOs eq "없음" }'>
			<div>
				<div>
					<h5 style="color: gray;" class="etc2Text">&nbsp; 없음.</h5>
				</div>
			</div>
		</c:when>
	</c:choose>
		
</div>