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
	

		$("#deletebtn").click(function() {
			$("#updateRecentBoardForm").submit();
		});

	
	
	
	

	
	/* 최근 본 여행지 */
	/* recentBoardVO의 속성 : contentid, title, firstimage2 */
	var recentRoomNum = 0;
	
	recentBoardVOArr = new Array();//페이지네이션 처리 및 값을 띄워줄 array
	var recentBoardArr;
	if(getCookie("recentBoardList") == undefined){//쿠키에 값이 없는경우 담아줄 배열 생성
		recentBoardArr = new Array();
	} else {
		recentBoardArr = JSON.parse(getCookie("recentBoardList"));//쿠키에 값이 있는경우 받아옴

		for (var i = 0; i < recentBoardArr.length; i++) {
			var recentBoardVO = JSON.parse(recentBoardArr[i]);
			recentBoardVOArr.push(recentBoardVO);
		}
	}
	
	
	
	/* 최근 본 여행지 페이지네이션 처리 및 출력 함수 */
	/* 최근 본 여행지 배열 및 증가감소값만 받음 */
	function recentBoardArrShow(recentBoardVOArr) {
		var count = 0;
		for(var i = 0; i < recentBoardVOArr.length; i++){
			
			var recentBoardVO = recentBoardVOArr[i];
			
			var res ='<tr class="tr" title="'+recentBoardVO.board_seq+'">';
				res +='<td><input type="hidden" class="checkbox" name="delBookmark" value="'+recentBoardVO.board_seq+'" />'+recentBoardVO.board_seq+'</td>';
				//res +='<td><img src="'+recentBoardVO.firstimage2+'" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\' width="100px;" height="100px;"></td>';
				res +='<td>';
				res +='<a href="' + recentBoardVO.link + '">'+recentBoardVO.board_title;
				res +='</td>';
				res +='<td>';
				res +=recentBoardVO.board_title;
				res +='</td>';
				res +='<td>';
				res +='<button type="button" value="'+recentBoardVO.board_seq+'" class="btn btn-default btn-lg delBtn">';
				res +='<span class="glyphicon glyphicon-trash"></span>';
				res +='</button>';
				res +='</td>';
				res +='</tr>';
		
			$(".tbody").append(res);
		
		}
	
	}
	recentBoardArrShow(recentBoardVOArr);
	
	
	
	
	$(".delBtn").click(function(){
		var tempNum = $(this).parent().parent().find('.checkbox').val();
			recentBoardArr = JSON.parse(getCookie("recentBoardList"));//쿠키에 값이 있는경우 받아옴
			for (var i = 0; i < recentBoardArr.length; i++) {
				
				
				recentBoardVO = JSON.parse(recentBoardArr[i]);
				if(recentBoardVO.board_seq==tempNum){
 					recentBoardArr.splice(i,1);
 					
 					var jsonRecentBoardVOs = JSON.stringify(recentBoardArr);
 					
 					setCookie("recentBoardList", jsonRecentBoardVOs, 30);
 					location.href="${pageContext.request.contextPath}/myPage/selectRecentBoard";
				}
			}
		
	});
	
	
	
	
	
	});
	
	
	
	
</script>

<h2>최근 본 게시글</h2>
<form
	action="${pageContext.request.contextPath}/myPage/updateRecentBoard"
	id="updateRecentBoardForm" method="get"></form>

<a class="btn btn-default btn-lg "
	href="${pageContext.request.contextPath}/myPage/selectRecentTrevel" role="button ">최근본
	여행지</a>
<a class="btn btn-default btn-lg active" 
	href="${pageContext.request.contextPath}/myPage/selectRecentBoard" role="button">최근 본
	게시글</a>




<div class="row">
	<div class="col-sm-12">
		 <table class="table table-hover">
		    <thead>
		    	<tr>
			        <th><h4>번호<h4></th>
			        <th><h4>제목<h4></th>
			        <th><h4>내용<h4></th>
			        <th><h4>삭제<h4></th>
		    	</tr>
		    </thead>
		    <tbody class="tbody">
		    
		     </tbody>
		  </table>	

	</div>
</div>
