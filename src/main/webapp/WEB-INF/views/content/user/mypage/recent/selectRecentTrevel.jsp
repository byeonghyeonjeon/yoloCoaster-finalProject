<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.right_menu_img{
height: 150px;
width: 150px;
}
</style>
<script>
//쿠키 저장 함수(쿠키이름, 쿠키이름에 저장할 값, 쿠키를 유지할 일수)
function setCookie(cookieName, value, exdays) {
	$.cookie(cookieName, value, {
		expires : exdays,
		path : '/yoloCoaster'
	});
}

//쿠키 지우기 함수(쿠키이름)
function deleteCookie(cookieName) {
	$.removeCookie(cookieName, {
		path : '/yoloCoaster'
	});
}

//쿠키 읽어오는 함수(쿠키이름) -> 쿠키값 반환
function getCookie(cookieName) {
	return $.cookie(cookieName);
}



	$(function() {
	
	/* 최근 본 여행지 */
	/* recentTravelVO의 속성 : contentid, title, firstimage2 */
	var recentRoomNum = 0;
	
	recentTravelVOArr = new Array();//페이지네이션 처리 및 값을 띄워줄 array
	var recentTravelArr;
	if(getCookie("recentTravelList") == undefined){//쿠키에 값이 없는경우 담아줄 배열 생성
		recentTravelArr = new Array();
	} else {
		recentTravelArr = JSON.parse(getCookie("recentTravelList"));//쿠키에 값이 있는경우 받아옴
		$('#recentTravleLength').text(recentTravelArr.length);
		for (var i = 0; i < recentTravelArr.length; i++) {
			var recentTravelVO = JSON.parse(recentTravelArr[i]);
			recentTravelVOArr.push(recentTravelVO);
		}
	}
	
	
	
	
	
	/* 최근 본 여행지 페이지네이션 처리 및 출력 함수 */
	/* 최근 본 여행지 배열 및 증가감소값만 받음 */
	function recentTravelArrShow(recentTravelVOArr) {
		var count = 0;
		for(var i = 0; i < recentTravelVOArr.length; i++){
			
			var recentTravelVO = recentTravelVOArr[i];
			
			var res ='<tr class="tr" title="'+recentTravelVO.contentid+'">';
				res +='<td><input type="hidden" class="checkbox" name="delBookmark" value="'+recentTravelVO.contentid+'" />'+recentTravelVO.contentid+'</td>';
				res +='<td><img src="'+recentTravelVO.firstimage2+'" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'" width="100px;" height="100px;"></td>';
				res +='<td>';
				res +='<a href="' + recentTravelVO.link + '">'+recentTravelVO.title;
				res +='</td>';
				res +='<td>';
				res +='<button type="button" value="'+recentTravelVO.contentid+'" class="btn btn-default btn-lg delBtn">';
				res +='<span class="glyphicon glyphicon-trash"></span>';
				res +='</button>';
				res +='</td>';
				res +='</tr>';
		
			$(".tbody").append(res);
		
		}
	
	}
	recentTravelArrShow(recentTravelVOArr);
	
	
	
		
	$(".delBtn").click(function(){
		var tempNum = $(this).parent().parent().find('.checkbox').val();
			recentTravelArr = JSON.parse(getCookie("recentTravelList"));//쿠키에 값이 있는경우 받아옴
			for (var i = 0; i < recentTravelArr.length; i++) {
				
				
				recentTravelVO = JSON.parse(recentTravelArr[i]);
				if(recentTravelVO.contentid==tempNum){
 					console.log(recentTravelVO.contentid);
 					console.log(tempNum);
 					var byebye= recentTravelArr.splice(i,1);
 					
 					//배열
 					console.log(recentTravelArr);
 					
 					var jsonRecentTrevelVOs = JSON.stringify(recentTravelArr);
 					
 					//json
 					console.log(jsonRecentTrevelVOs);
 					
 					setCookie("recentTravelList", jsonRecentTrevelVOs, 30);
 					location.href="${pageContext.request.contextPath}/myPage/selectRecentTrevel";
				}
			}
		
	});

	var delList = [];
	$(".checkbox").change(function(){
		var tempVal = $(this).val()
		if(delList.indexOf(tempVal)!=null){
			var delNum = delList.indexOf(tempVal);
			delList.splice(delNum,1);
		}else{
			delList.push(tempVal);
		}
		
	});
	
	
	
	
	});
	
	
	
	
</script>

<h2>최근 본 여행지</h2>
<div id="tempZone"></div>
<form
	action="${pageContext.request.contextPath}/myPage/updateRecentBoard"
	id="updateRecentBoardForm" method="get"></form>

<a class="btn btn-default btn-lg active"
	href="${pageContext.request.contextPath}/myPage/selectRecentTrevel" role="button ">최근본
	여행지</a>
<a class="btn btn-default btn-lg "
	href="${pageContext.request.contextPath}/myPage/selectRecentBoard" role="button">최근 본
	게시글</a>


<div class="row">
	<div class="col-sm-12">
		 <table class="table table-hover">
		    <thead>
		    	<tr>
			        <th><h4>번호<h4></th>
			        <th><h4>사진<h4></th>
			        <th><h4>제목<h4></th>
			        <th><h4>삭제<h4></th>
		    	</tr>
		    </thead>
		    <tbody class="tbody">
		    
		     </tbody>
		  </table>	

	</div>
</div>
