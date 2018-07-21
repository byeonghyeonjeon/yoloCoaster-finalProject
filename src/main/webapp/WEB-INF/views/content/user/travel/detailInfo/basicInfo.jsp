<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/include/map.jsp"%>
<style>
#map, #nearMap{
	width:100%;
	height:300px;
}

#mapInfoList{
	height : 300px;
	overflow-y : scroll;
}

.titleBox {
	background-color: #f5f5f5;
    border-color: #ddd;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
    border-radius: 4px;
    font-size: 16px;
}

.profileImg {
	width: 100%;
	border: 1px solid lightgray;
	height: 120px;
}

#reviewFile {
	display: inline;
}

.reviewTag {
	background-color: lightskyblue;
	margin: 10px;
	border-radius: 5px;
}
.reviewTagCount {
	background-color: #b5e2a8;
	margin: 10px;
	border-radius: 5px;
}
#travelSummInfo{
	padding-top:35px;
	padding-bottom: 15px;
}

#imageUploadForm {
	display: inline;
}

.innerTitle {
	background-color: lightblue;
	padding: 5px;
}


</style>
<script>
	$(function() {
		// 콘텐츠 정보 
		var contenttypeid = $('#contenttypeid').val();
		var contentid = $('#contentid').val();
		var title = '${basicinfoVO.title}';
		var firstimage2 = '${basicinfoVO.firstimage2}';
		
		//쿠키에 최근 본 여행지로 저장
		function addRecentTravel(contentid, title, firstimage2) {
			var recentTravelVO = {
					contentid : contentid,
					title : title,
					firstimage2 : firstimage2,
					link : window.location.href
			};
			
			var jsonRecentTravelVO = JSON.stringify(recentTravelVO);//최근 본 여행지 객체 -> json
			var arr;
			if(getCookie("recentTravelList") == undefined){//쿠키에 값이 없는경우 담아줄 배열 생성
				arr = new Array();
			} else {
				arr = JSON.parse(getCookie("recentTravelList"));//쿠키에 값이 있는경우 받아옴
				for (var i = 0; i < arr.length; i++) {
					var recentTravelVO = JSON.parse(arr[i]);
					if(recentTravelVO.contentid == contentid){//이미 배열에 해당 여행지가 있는경우 저장 안함
						return;
					}
				}
			}
			//최근본여행지객체를 배열에 저장후 쿠키에 저장
			arr.push(jsonRecentTravelVO);
			var jsonRecentTravelVOs = JSON.stringify(arr);
			setCookie("recentTravelList", jsonRecentTravelVOs, 30);
			
			//최근본 여행지 개수가 9개가 넘는 경우
			while(arr.length >= 9){
				arr.shift();
			}
			
			jsonRecentTravelVOs = JSON.stringify(arr);
			setCookie("recentTravelList", jsonRecentTravelVOs, 30);
		}
		addRecentTravel(contentid, title, firstimage2);//페이지 로딩후 바로 실행
		
		
		/* 좋아요 하트 색채우기*/
		$('#give_love')
			.click(
				function() {
					if(mem_id.length != 0){
						$.ajax({
							method : "post",
							url : "${pageContext.request.contextPath}/basicInfo/good?contentid="+contentid,
							data : JSON.stringify({contentid : contentid }),
							contentType : "application/json; charset=UTF-8",
							dataType : "json",
							success : function(data) {
								dd = data;
								// 좋아요 선택시 
								if (data.resultBool == true) {
			 						$('#give_love span').attr('class', 'glyphicon glyphicon-heart');
			 					} else {
			 						$('#give_love span').attr('class', 'glyphicon glyphicon-heart-empty');
			 					}
								window.location.reload();
							},
							error : function(xhr) {
								console.log('실패');
								console.log(xhr);
							}
						});
					}else{
						alert("로그인 하쒀요");
					}
// 					
				});
		/* end 좋아요 하트 색채우기 */
		
		/* 네이버 지도 */
// 		var title = $('#title').val();
		var mapx = $('#mapx').val();
		var mapy = $('#mapy').val();
		var mlevel = $('#mlevel').val();
		
		console.log("mapx : " + mapx);
		console.log("mapy : " + mapy);
		console.log("mlevel : " + mlevel);
		
		if(mapx=="없음" || mapy=="없음"){
			var noDiv = "<div class=\"jumbotron hidden\" >";
			noDiv += "<div id=\"map\" class=\"container text-center\"></div>";
			noDiv += "</div>"
			$('#mapDiv').html(noDiv);
		}else{
			var noDiv = "<div id=\"map\" class=\"container text-center\"></div>";
			$('#mapDiv').html(noDiv);
		}
		
		// 지도 생성
		var map = new N.Map('map', {
            center: new N.LatLng(mapy, mapx),
            zoom: 10
        });
		
		// 마커 생성
		var marker = new N.Marker({
            position: new N.LatLng(mapy, mapx),
            map: map
        });
		/* 네이버 지도 end */
		
		/* 주변 여행지 */
		$('#infoTravel').on('click',function(){
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/nearbyTravel",
				data : JSON.stringify({contenttypeid : contenttypeid, mapy : mapy, mapx : mapx}),
				contentType : "application/json; charset=UTF-8",
				dataType : "json",
				success : function(data) {
					
					// 지도 생성
					var nearMap = new N.Map('nearMap', {
			            center: new N.LatLng(mapy, mapx),
			            zoom: 9
			        });
					
					// 주변 관광지 전부 마크 생성
					var mapAry = new Array();
					
					for (var i = 0; i < data.basicinfoVOs.length; i++) {
						// 마커 생성
						var marker = new N.Marker({
			                position: new N.LatLng(data.basicinfoVOs[i].mapy, data.basicinfoVOs[i].mapx),
			                map: nearMap
			            });
						
						// 객체 선언
						var mapObj = new Object();
						var mapObj = {};
						mapObj.addr1 = data.basicinfoVOs[i].addr1;
						mapObj.mapx = data.basicinfoVOs[i].mapx;
						mapObj.mapy = data.basicinfoVOs[i].mapy;
						mapObj.tel = data.basicinfoVOs[i].tel;
						mapObj.title = data.basicinfoVOs[i].title;
						mapObj.contenttypeid = data.basicinfoVOs[i].contenttypeid;
						mapObj.contentid = data.basicinfoVOs[i].contentid;
						
						mapAry.push(mapObj);
						
						// 주변 관광지 정보 출력
						$("#mapInfoList").append('<h5><a class="mapInfoLink">'+data.basicinfoVOs[i].title+'</a><button class="moveInfoPage" value="'+data.basicinfoVOs[i].contentid+'">이동</button></h5>');
						$("#mapInfoList").append(data.basicinfoVOs[i].addr1+'<br>');
						$("#mapInfoList").append(data.basicinfoVOs[i].tel + '<br>');
						$("#mapInfoList").append('<hr>');
					}
					
					// 주변 관광지 마커 클릭시 좌표 이동
					$('.mapInfoLink').click(function(){
						var maptitle = $(this).text();
						for(var i=0; i<mapAry.length; i++){
							// 선택한 마크로 좌표 이동
							if(mapAry[i].title == maptitle){
								console.log("resultMapy " + mapAry[i].mapy + "resultMapx" + mapAry[i].mapx)
								var mapxy = new N.LatLng(mapAry[i].mapy, mapAry[i].mapx);
								nearMap.setCenter(mapxy); // 중심 좌표 이동
								nearMap.setZoom(10);
							}
						}
					});
					
					// 선택한 여행지의 상세페이지로 이동
					$('.moveInfoPage').click(function(){
						var contentid = $(this).attr('value');
						location.href = "${pageContext.request.contextPath}/basicInfo/basicInfo?contentid="+contentid;
					});
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		});
		/* 주변 여행지  end */
		
		/* 소개 정보 */
		$('#travelDetailInfo').on('click',function(){
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/intro/"+contenttypeid,
				data : JSON.stringify({contenttypeid : contenttypeid, contentid : contentid }),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) {
					$("#detailInfo").html(data);
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		});
		/* 소개 정보  end */
		/* 추가 정보 */
		$('#travelAddInfo').on('click',function(){
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/addInfo",
				data : JSON.stringify({contenttypeid : contenttypeid, contentid : contentid }),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) {
					$("#addDetailInfo").html(data);
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		});
		/* 추가 정보  end */
		/* 기본 정보 */

			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/mainInfo",
				data : JSON.stringify({contentid : contentid}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) {
					aa = data;
					$("#mainBasicInfo").html(data);
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}
			});

		/* 기본 정보 end */
		/* 개요 */

			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/summary",
				data : JSON.stringify({contentid : contentid}),
				contentType : "application/json; charset=UTF-8",
				dataType : "json",
				success : function(data) {
					$("#travelSummInfo").append(data.basicinfoVO.overview.replace(/\\n/g, " "));
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}
			});

		
		/* 개요 end */
		/* 포토리뷰 작성 */
		//태그 추가시
		$('#review_tagBtn').on('click', function(){
			var tagName = $("[name='review_tag']").val().trim();
			if(tagName == ''){
				return
			} else {
				var tagSpan = '<span class="reviewTag">#' + tagName + '<span class="glyphicon glyphicon-remove tagRemove"/></span>';
				$('#tagList').append(tagSpan);
				$("[name='review_tag']").val('');
			}
		});
		
		//포토리뷰 작성 클릭시
		$('#reviewWrite').on('click', function(){
			var review_title = $("[name='review_title']").val();
			var review_content = $("[name='review_content']").val();
			if(review_title == '' || review_content == ''){
				return;
			}
			
			var reviewTag = $($('#reviewWrite').parents().get(2)).find('.reviewTag');
			var reviewTagArr = new Array();
			for (var i = 0; i < reviewTag.length; i++) {
				reviewTagArr.push($(reviewTag[i]).text());
			}
			
			var parameter = {
				contentid : contentid,
				review_title : review_title,
				review_content : review_content,
				tag_content : reviewTagArr
			};
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/addReview",
				data : JSON.stringify(parameter),
				contentType : "application/json; charset=UTF-8",
				dataType : "json",
				success : function(data) {
					//data : review_seq
					$("[name='review_title']").val('');
					$("[name='review_content']").val('');
					$('#tagList').html('');
					
					//파일 전송
					$("[name='parent_seq']").val(data);
					$('#imageUploadForm').submit();
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
			
		});
		
		//파일 전송 ajax
		$('#imageUploadForm').ajaxForm({
			success: function(data,status){
				window.location.reload();//페이지 리로드
	        },
	        error: function(){
	            //에러발생을 위한 code페이지
	            alert("업로드 에러!")
	        }                              
	    });
		
		//태그 삭제 버튼 클릭
		$('#tagList').on('click', '.tagRemove', function(){
			$(this).parent().remove();
		});
		
		
		//리뷰 호출
		function reviewCall(pageNo){
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/reviewInfo",
				data : JSON.stringify({contentid:$('#contentid').val(), pageNo:pageNo}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) {
					$('#Info-Review').html(data);
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		}
		reviewCall('1');//기본 1 페이지 호출
		
		//리뷰 페이징처리
 		$("div#Info-Review").on('click', '.page-link', function(){
 			var pageNo = $(this).attr("type")//이동할 페이지 입력
 			reviewCall(pageNo);
 		});
		
		$('#starBtn').on('click', function(){
			var score_point = $('input[name="starCount"]:checked').val();
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/basicInfo/insertStar",
				data : JSON.stringify({contentid:$('#contentid').val(), score_point:score_point}),
				contentType : "application/json; charset=UTF-8",
				dataType : "json",
				success : function(data) {
					location.href = window.location.href;
				},
				error : function(xhr) {
					console.log(xhr);
				}
			});
		});
		
		/* 즐겨찾기 추가 버튼 */
		$('#bookmarkBtn').on('click', function(){
			if(mem_id == ''){//로그인을 하지 않은 경우
				alert('로그인을 해주세요');
			} else {//로그인을 한 경우
				bookmark_area = {
					contentid : contentid,
					link : window.location.href
				};
				
				$.ajax({
					method: "post",
					url: "${pageContext.request.contextPath}/basicInfo/addBookmark",
					data: JSON.stringify(bookmark_area),
					contentType: "application/json; charset=UTF-8",
					dataType : "json",
					success: function() {
					},
					error : function(xhr) {
						$('#rightBoxBookMarkList').html('');
						$.ajax({
							method: "post",
							url: "${pageContext.request.contextPath}/bookmarkPaging",
							data: JSON.stringify({pageNo : 1}),
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
				})
			}
		});
});	
</script>
<style>
	#map, #nearMap{
		width:100%;
		height:300px;
	}
	
	#mapInfoList{
		height : 300px;
		overflow-y : scroll;
	}
	
	.accorBottom{
		padding-bottom: 30px;
	}
	
</style>



<div class="row">
<!-- 네이버 지도 -->
	<div id="mapDiv">
	</div>
</div>

<input type="hidden" id="title" value="${basicinfoVO.title }">
<input type="hidden" id="mapx" value="${basicinfoVO.mapx}"> 
<input type="hidden" id="mapy" value="${basicinfoVO.mapy }">
<input type="hidden" id="mlevel" value="${basicinfoVO.mlevel }">
<input type="hidden" id="contenttypeid" value="${basicinfoVO.contenttypeid }">
<input type="hidden" id="contentid" value="${basicinfoVO.contentid }">

<!--제목바-->
<div class="row">
	<div class="container-fluid bg-3 text-center" style=" background: linear-gradient(to right, #a1f276, #5ce09b);">
		<div class="row">
			<!--제목바 내용-->
			<div class="col-md-12" style="color: aliceblue;">
	
				<h2 style="color: aliceblue; text-align: left">${basicinfoVO.title }</h2>
				<hr style="color: aliceblue;">
				<div class="col-md-5">
					<div class="row">
						<div class="col-xs-4">
							<div style="font-size: 30px;"><fmt:formatNumber value="${starListAvg}" pattern="0.00"/></div>
							<div style="font-size: 15px;">별점</div>
						</div>
						<div class="col-xs-4">
							<div style="font-size: 30px;">${basicinfoVO.goodCount}</div>
							<div style="font-size: 15px;">좋아요</div>
						</div>
						<div class="col-xs-4">
							<div style="font-size: 30px;">${basicinfoVO.reviewCount}</div>
							<div style="font-size: 15px;">리뷰</div>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-xs-6">
							<button type="button" class="btn btn-default btn-lg btn-block" id="bookmarkBtn">
								<div class="row" style="font-size: 15px;">
									즐겨찾기<br>추가
								</div>
							</button>
						</div>
						<div class="col-xs-6">
							<button type="button" id="give_love"
								class="btn btn-default btn-lg btn-block">
								<span class="${goodClass }" aria-hidden="false">
									<div class="row" style="font-size: 15px;">좋아요</div>
								</span>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!--제목바 내용-->
		</div>
	</div>
</div>

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	
	<!-- 위치정보 -->
	<div class="row" id="Info-Location">
	    
	</div>
	
	<!-- 기본정보 -->
	<div id="mainBasicInfo" class="row"></div>
	
	<!-- 개요 -->
	<div class="row" id="Info-Basic">
		<div class="form-horizontal" id="travelSumm">
			<div class="col-xs-12 titleBox">개 요</div>
			<div id="travelSummInfo"></div>
		</div>
	</div>
	 
	<!-- 소개정보 -->
	<div id="Info-Intro" class="accorBottom" >
		<div class="panel panel-default row data0">
		  <div class="panel-heading" role="tab" id="headingOne">
			 <h4 class="panel-title">
			    <a aria-expanded="false" class="collapsed" id="travelDetailInfo" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-controls="collapseOne"> 
			         	소개정보
			    </a>
		     </h4>
		  </div>
		  <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
			 <div class="panel-body" id="detailInfo"> 
				
		     </div>
		  </div>
		</div>
	</div>
	
	
	<!-- 추가정보 -->  
	<div class="accorBottom" id="addDetailETC">
		<div class="panel panel-default row" >
		  <div class="panel-heading" role="tab" id="headingInfo">
			 <h4 class="panel-title">
			    <a aria-expanded="false" class="collapsed" id = "travelAddInfo" data-toggle="collapse" data-parent="#accordion" href="#collapseInfo" aria-controls="collapseInfo"> 
			         	추가정보
			    </a>
		     </h4>
		  </div>
		  <div id="collapseInfo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingInfo">
			 <div class="panel-body" id="addDetailInfo"> 
				
		     </div>
		  </div>
		</div>
	</div>


	<!-- 별점 주기 -->
	<div class="row" id="Info-Star" class="accorBottom" >
		<div class="col-xs-12 titleBox">평가 정보</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="col-sm-2">
					<h5 class="innerTitle">${starListAll} 건의 평가</h5>
					<h5 class="innerTitle"><fmt:formatNumber value="${starListAvg}" pattern="0.00"/> 점</h5>
				</div>
				<div class="col-sm-10">
					<table class="table table-bordered">
						<tr>
							<td width="10%">배점</td>
							<td width="5%">건수</td>
							<td width="85%">퍼센트</td>
						</tr>
						<c:forEach items="${starList}" var="starVO">
							<fmt:formatNumber var="percent" value="${starVO.count div starListAll}" type="percent"/>
							<tr>
								<td width="10%">${starVO.score_point}</td>
								<td width="5%">${starVO.count}</td>
								<td width="85%">
									<div class="progress">
										<div class="progress-bar progress-bar-success" style="width: ${percent}"></div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${memberVO ne null }">
						<div class="col-xs-2">
							<h5 class="innerTitle">별점주기</h5>
						</div>
						<div class="col-xs-10"></div>
						<div class="col-xs-12">
							<label class="radio-inline">
								<input type="radio" name="starCount" value="1">★
							</label>
							<label class="radio-inline">
								<input type="radio" name="starCount" value="2">★★
							</label>
							<label class="radio-inline">
								<input type="radio" name="starCount" value="3">★★★
							</label>
							<label class="radio-inline">
								<input type="radio" name="starCount" value="4">★★★★
							</label>
							<label class="radio-inline">
								<input type="radio" name="starCount" value="5">★★★★★
							</label>
							<button class="btn btn-success" id="starBtn">제출</button>
						</div>
					</c:if>
					<c:if test="${memberVO eq null }">
						<div class="col-xs-5">
							<h5 class="innerTitle">별점주기는 로그인한 회원만 가능합니다</h5>
						</div>
						<div class="col-xs-7"></div>
					</c:if>
				</div>
			</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="col-xs-2">
					<h5 class="innerTitle">태그</h5>
				</div>
				<div class="col-xs-10"></div>
				<div class="col-xs-12">
					<c:forEach items="${tagList}" var="tagCountVO">
						<span class="reviewTagCount">${tagCountVO.tag_content}(${tagCountVO.tag_count})</span>
					</c:forEach>
				</div>
			</div>
		</div>
		<br>
	</div>
	
	<!--포토리뷰 -->
	<div class="row" id="Info-Review">
		
	</div>
	
	<!-- 포토리뷰 작성하기 -->
	<c:if test="${memberVO ne null }">
		<div class="row form-horizontal" id="Write-Review">
			<div class="col-xs-12 titleBox">포토리뷰 작성하기</div>
			<div class="form-group">
				<div class="col-sm-2 control-label">제목</div>
				<div class="col-sm-10"><input type="text" name="review_title" class="form-control" placeholder="제목을 입력하세요"></div>
			</div>
			<div class="form-group">
				<div class="col-sm-2 control-label">내용</div>
				<div class="col-sm-10"><textarea rows="3" class="form-control" name="review_content"></textarea></div>
			</div>
			<div class="form-group">
				<div class="col-sm-2 control-label">태그</div>
				<div class="col-sm-3"><input type="text" name="review_tag" class="form-control" placeholder="태그를 입력하세요"></div>
				<div class="col-sm-7">
					<button class="btn btn-default btn-primary" id="review_tagBtn">추가</button>&nbsp;
					<form action="${pageContext.request.contextPath}/basicInfo/imageUpload" method="post" id="imageUploadForm" enctype="multipart/form-data">
						<input type="file" name="file" accept="image/*" class="btn btn-default" id="reviewFile" multiple>
						<input type="hidden" name="parent_seq">
					</form>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10" id="tagList">
					<!-- 추가된 태그목록 -->
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-6">
					<button class="btn btn-default btn-success form-control" id="reviewWrite">작성하기</button>
				</div>
			</div>
		</div>
	</c:if>
	
	
	<!-- 사진첩 -->
	<div class="row" id="Info-Photo">
		<div class="col-xs-12 titleBox">사진첩</div>
		<div class="col-sm-3">
			<a href="https://www.instagram.com/explore/tags/${fn:replace(basicinfoVO.title, ' ', '')}" target="_blank">
				<img src="${pageContext.request.contextPath}/image/logo/instagram.jpg" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'" class="profileImg img-thumbnail">
			</a>
		</div>
		<c:forEach items="${photoList}" var="photo">
			<div class="col-sm-3">
				<img src="${pageContext.request.contextPath}${photo.add_path}" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'" class="profileImg img-thumbnail">
			</div>
		</c:forEach>
	</div>
	
	<!-- 블로그 -->
	<div class="row" id="Info-Blog">
		<div class="col-xs-12 titleBox">관련 블로그</div>
		<c:forEach items="${naverBlogs}" var="blog">
			<div class="row">
				<div class="col-xs-12">
					<div class="col-xs-8">
						<h4><a href="${blog.link}" target="_blank">${blog.title}</a></h4>
						<div>${blog.description}</div>
					</div>
					<div class="col-xs-4">
						<div class="col-xs-12">${blog.postdate}</div>
						<br>
						<div class="col-xs-12"><a href="${blog.bloggerlink}" target="_blank">${blog.bloggername}</a></div>
					</div>
					<div class="col-xs-12"><hr></div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<!-- 주변 여행지 -->
	<div class="panel panel-default row" id="Info-SurLocation">
		<div class="panel-heading" role="tab" id="headingTravel">
			<h4 class="panel-title">
				<a aria-expanded="false" class="collapsed" id="infoTravel" class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTravel" aria-controls="collapseTravel"> 주변 관광지 </a>
			</h4>
		</div>
		<div id="collapseTravel" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTravel">
			<div class="panel-body">
				<div class="col-xs-8">
					<div id="nearMap"></div>
				</div>
				<div class="col-xs-4" id="mapInfoList"></div>
			</div>
		</div>
	</div>
</div>


<!-- ajax를 통한 결과값 출력-->
<div id="searchMap"></div>