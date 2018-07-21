<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- main rightmenubar style  -->
<style>
/* rightBar 설정 */
.rightBox {
	width: 100px;
	position: fixed;
}

.rightBox .right_menu {
	width: 180px;
	height: 60px;
	position: relative;
	overflow: hidden;
}

.right_menu_img {
	width: 60px;
	height: 60px;	
	position: absolute;
	left: 0px;
	top: 0px;
	display: inline;
	text-align: center;
}

.right_menu_info {
	background-color: #fff;
	height: 60px;
	width: 120px;
	display: none;
	position: absolute;
	left: 60px;
	top: 0px;
}

#rightBox1 {
	top: 180px;
}
#rightBox2 {
	top: 491px;
}
#rightBox3 {
	top: 105px;
}
/* end-rightBar 설정*/
</style>
<!-- end main rightmenubar style  -->

<!-- main rightmenubar script  -->
<script>
	$(function() {
		/* rightmenubar mouseover시 정보제공  */
		$('.rightBox').on('mouseover', '.right_menu',function() {
			$(this).find('.right_menu_info').css('display', 'block');
			$(this).css('border','1px solid black');
			
		})
		$('.rightBox').on('mouseout', '.right_menu',function() {
			$(this).removeAttr("Style");
			$(this).find('.right_menu_info').css('display', 'none');
		})
		/* end rightmenubar mouseover시 정보제공 */
		
		
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
				if(count == 2)
					break;
				var recentTravelVO = recentTravelVOArr[i];
				
				var result = '<div class="right_menu">';
				result += '<a href="' + recentTravelVO.link + '">';
				result += '<div class="right_menu_info">';
				result += '<span>' + recentTravelVO.title + '</span>';
				result += '</div>';
				result += '<img class="right_menu_img"';
				result += 'src="' + recentTravelVO.firstimage2 + '" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'">';
				result += '</a></div><br>';
				count++;
				$('#rightBoxRecentTravelList').append(result);
			}
			if(recentTravelArr.length >= 3){
				var btn = '<button type="button" id="leftBtnRecentTravle">&lt;</button>';
				btn += '<button type="button" id="rightBtnRecentTravle">&gt;</button>';
				$('#rightBoxRecentTravelList').append(btn);
			}
		}
		recentTravelArrShow(recentTravelVOArr);
		
		//최근본 여행지 페이지네이션 함수
		function recentTravelArrMoveShow(recentTravelVOArr, recentRoomNum, plusminus){
			$('#rightBoxRecentTravelList').html('');
			
			var startRoomNum = recentRoomNum + plusminus;
			if(startRoomNum >= recentTravelVOArr.length){
				startRoomNum = 0;
			} else if(startRoomNum < 0){
				if(recentTravelVOArr.length % 2 == 0 ){
					startRoomNum = recentTravelVOArr.length - 2;
				} else {
					startRoomNum = recentTravelVOArr.length - 1;
				}
			}
			//출력
			var count = 0;
			for (var i = startRoomNum; i < recentTravelArr.length; i++) {
				if(count == 2)
					break;
				var recentTravelVO = recentTravelVOArr[i];
				
				var result = '<div class="right_menu">';
				result += '<a href="' + recentTravelVO.link + '">';
				result += '<div class="right_menu_info">';
				result += '<span>' + recentTravelVO.title + '</span>';
				result += '</div>';
				result += '<img class="right_menu_img"';
				result += 'src="' + recentTravelVO.firstimage2 + '" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'">';
				result += '</a></div><br>';
				count++;
				$('#rightBoxRecentTravelList').append(result);
			}
			if(recentTravelArr.length >= 3){
				var btn = '<button type="button" id="leftBtnRecentTravle">&lt;</button>';
				btn += '<button type="button" id="rightBtnRecentTravle">&gt;</button>';
				$('#rightBoxRecentTravelList').append(btn);
			}
			return startRoomNum;
		}
		
		//최근 본 여행지 왼쪽버튼 클릭
		$('#rightBoxRecentTravelList').on('click', '#leftBtnRecentTravle',function() {
			recentRoomNum = recentTravelArrMoveShow(recentTravelVOArr, recentRoomNum, -2);
		});
		//최근 본 여행지 오른쪽버튼 클릭
		$('#rightBoxRecentTravelList').on('click', '#rightBtnRecentTravle',function() {
			recentRoomNum = recentTravelArrMoveShow(recentTravelVOArr, recentRoomNum, 2);
		});
		
		
		/* 여행지 즐겨찾기 */
		var pageNo = 1;
		function getBookmarkList(pageNo){
			$('#rightBoxBookMarkList').html('');
			$.ajax({
				method: "post",
				url: "${pageContext.request.contextPath}/bookmarkPaging",
				data: JSON.stringify({pageNo : pageNo}),
				contentType: "application/json; charset=UTF-8",
				dataType : "json",
				success: function(data) {
					var bookmarkAreaVOs = data.bookmark_areaVOs;
					$('#bookMarkLength').text(data.totalCnt);
					bookmarkTotalCnt = data.totalCnt;
					
					for(var i = 0; i < bookmarkAreaVOs.length; i++){
						var bookmarkAreaVO = bookmarkAreaVOs[i];
						var result = '<div class="right_menu">';
						result += '<a href="' + bookmarkAreaVO.link + '">';
						result += '<div class="right_menu_info">';
						result += '<span>' + bookmarkAreaVO.title + '</span>';
						result += '</div>';
						result += '<img class="right_menu_img"';
						result += 'src="' + bookmarkAreaVO.firstimage2 + '" onError="this.src=\'${pageContext.request.contextPath}/image/logo/noImage.png\'">';
						result += '</a></div><br>';
						$('#rightBoxBookMarkList').append(result);
					}
					
					if(data.totalCnt >= 3){
						var btn = '<button type="button" id="leftBtnBookmark">&lt;</button>';
						btn += '<button type="button" id="rightBtnBookmark">&gt;</button>';
						$('#rightBoxBookMarkList').append(btn);
					}
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		}
		
		if(mem_id != ''){
			getBookmarkList(pageNo);
		}
		
		//즐겨찾기 왼쪽버튼 클릭
		$('#rightBoxBookMarkList').on('click', '#leftBtnBookmark',function() {
			pageNo -= 1;
			if(pageNo == 0)
				pageNo = Math.floor(bookmarkTotalCnt/2) + bookmarkTotalCnt%2;
			getBookmarkList(pageNo);
		});
		//즐겨찾기 오른쪽버튼 클릭
		$('#rightBoxBookMarkList').on('click', '#rightBtnBookmark',function() {
			pageNo += 1;
			if(bookmarkTotalCnt <= (pageNo-1)*2)
				pageNo = 1;
			getBookmarkList(pageNo)
		});
		
		
	});
</script>
<!-- end main rightmenubar script  -->

<!-- main right navbar -->
<!--RightMenu 최근 본 여행지-->
<div class="well rightBox" id="rightBox1">
	<a href="${pageContext.request.contextPath}/myPage/selectRecentTrevel">
		<p>최근 본 여행지</p>
		<p id="recentTravleLength">0</p>
	</a>
	<div id="rightBoxRecentTravelList">
		
	</div>
</div>
<!-- end RightMenu 최근 본 여행지 -->

<!-- RightMenu 여행지 즐겨찾기 -->
<div class="well rightBox" id="rightBox2">
	<a href="${pageContext.request.contextPath}/myPage/selectBookmarkArea">
		<p>여행지<br>즐겨찾기</p>
		<p id="bookMarkLength">0</p>
	</a>
	<div id="rightBoxBookMarkList">
		
	</div>
</div>
<!-- RightMenu 여행지 즐겨찾기 -->

<div class="well rightBox" style="text-align: center" id="rightBox3">
	<a href="#aTagForm">
		<button type="button" class="btn btn-sm" aria-label="Left Align" onclick="">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
			TOP
		</button>
	</a>
</div>

<!-- end main right navbar -->