<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.checking{
		width : 150px;
		vertical-align: top;
		color: #2d58a0;
		display: block;
	}
	
	td {
		font-size: 17px;
	}
	
	.divTop{
		margin-top: 50px;
 		margin-bottom: 30px; 
	}
	.imgWid{
 		width:100%; 
	}
	
	h2{
		font-weight: normal;
		margin-bottom: 30px;
	}
	
	.hrColor {
		border-color: orange;
		margin-bottom: 25px;
	}
	
	
	.divRight{
		margin-left: 30px;
	}
	
</style>

<script>
	$(function(){
		var regEx = /\\n/g;
		var printBoxArr = $('.checking').siblings();
		var len = printBoxArr.length;
		for(var i = 0; i < len; i++){
			var printBox = $($('.checking').siblings()[i]);
			var str = printBox.html();
			printBox.html(str.replace(regEx,""));
			//printBox.html(str.replace(regEx,"<br>"));
		}
	});
</script>

<div class="divTop row">
	<c:if test="${basicinfoVO.firstimage ne '없음'}">
		<div class="col-sm-6" >
			<img class="imgWid" alt="대표 이미지" src="${basicinfoVO.firstimage}" 
						onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
		</div>
	</c:if>
	<div class="divRight col-sm-5">
		<hr class="hrColor">
		<h2>이용 안내</h2>
		<table id="basicRight">
			<c:if test="${basicinfoVO.title ne '없음'}">
				<tr>
					<td class="checking">여행지</td>		
					<td>${basicinfoVO.title}</td>
				</tr>
			</c:if>
			<c:if test="${basicinfoVO.tel ne '없음'}">
				<tr>
					<td class="checking">전화 번호</td>		
					<td>${basicinfoVO.tel}</td>
				</tr>
			</c:if>
			<c:if test="${basicinfoVO.addr1 ne '없음' || basicinfoVO.addr2 ne '없음'}">
				<tr>
					<td class="checking">주소</td>		
					<td>${basicinfoVO.addr1}${basicinfoVO.addr2}</td>
				</tr>
			</c:if>
			<c:if test="${basicinfoVO.eventstartdate ne '없음'}">
				<tr>
					<td class="checking">행사 시작일</td>		
					<td>${basicinfoVO.eventstartdate}</td>
				</tr>
			</c:if>
			<c:if test="${basicinfoVO.eventenddate ne '없음'}">
				<tr>
					<td class="checking">행사 종료일</td>		
					<td>${basicinfoVO.eventenddate}</td>
				</tr>
			</c:if>
			<c:if test="${basicinfoVO.zipcode ne '없음'}">
				<tr>
					<td class="checking">우편 번호</td>		
					<td>${basicinfoVO.zipcode}</td>
				</tr>
			</c:if>
			<c:if test="${basicinfoVO.homepage ne '없음'}">
				<tr>
					<td class="checking">홈페이지 주소</td>		
					<td><a ${basicinfoVO.homepage}></td>
				</tr>
			</c:if>
		</table>
	</div>
</div>