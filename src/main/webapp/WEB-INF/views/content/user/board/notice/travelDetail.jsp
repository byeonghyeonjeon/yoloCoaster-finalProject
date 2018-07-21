<%@page import="com.yolo.model.BoardVO"%>
<%@page import="com.yolo.model.File_addVO"%>
<%@page import="com.yolo.model.TagVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	$(function() {
		
		$('#travelList').click(function(){
			location.href = "${pageContext.request.contextPath }/board/travelMain";
		})
		
		
		var board_seq = '${boardVO.board_seq}';
		var board_title = '${boardVO.board_title}';
		var board_content = '${boardVO.board_content}';
		//쿠키에 최근 본 게시글로 저장
		function addRecentBoard(board_seq, board_title, board_content) {
			var recentBoardVO = {
				board_seq : board_seq,
				board_title : board_title,
				board_content : board_content,
				link : window.location.href
			};

			var jsonRecentBoardVO = JSON.stringify(recentBoardVO); //최근 본 게시글 객체 -> json
			var arr;
			if (getCookie("recentBoardList") == undefined) {//쿠키에 값이 없는경우 담아줄 배열 생성
				arr = new Array();
			} else {
				arr = JSON.parse(getCookie("recentBoardList"));//쿠키에 값이 있는경우 받아옴
				for (var i = 0; i < arr.length; i++) {
					var recentBoardVO = JSON.parse(arr[i]);
						if(i==9){
							arr.shift();
						}
					if (recentBoardVO.board_seq == board_seq) {//이미 배열에 해당 여행지가 있는경우 저장 안함
						return;
					}
				}
			}
			//최근본여행지객체를 배열에 저장후 쿠키에 저장
			arr.push(jsonRecentBoardVO);
			var jsonRecentBoardVOs = JSON.stringify(arr);
			setCookie("recentBoardList", jsonRecentBoardVOs, 30);
		}
		addRecentBoard(board_seq, board_title, board_content); //페이지 로딩후 바로 실행

		/* 수정*/
		$("#travelUpdate").click(function() {
			
			$("#updateTravelForm").attr("action","${pageContext.request.contextPath}/board/travelDetail");
			$("#updateTravelForm").submit();
		});

		/* 삭제 */
		$("#travelDelete").click(function() {
			$("#updateTravelForm").attr("action","${pageContext.request.contextPath}/board/travelDelete");
			$("#updateTravelForm").submit();
		});
		
		
		$("#reply-Btn").click(function() {
			if (cnt == 0 || cnt > 100) {
				return;
			}
			$("#replyForm").submit();
		})
		var cnt = 0
		$("#textArea").keyup(function() {
			cnt = $(this).val().length;
			if (cnt > 100) {
				alert("초과 입력하였습니다.");
				return;
			}
			$("#count").text(cnt + "/100");
		});
		
		
		$('.reply-modify').on('click', function(){
			var reply_seq = $($(this).parents().get(1)).find('input[type=hidden]').val();
			var reply_content = $($(this).parents().get(1)).find('textarea').val();
			
			if($(this).html()=='수정'){
				$($(this).parents().get(1)).find('.replyList-content').attr('readonly', false);
				$(this).html('저장');
			}else{
				$($(this).parents().get(2)).attr("action","${pageContext.request.contextPath}/board/replyModify");
				$($(this).parents().get(1)).find('.replyList-content').attr('readonly', true);
				$(this).html('수정');
				$($(this).parents().get(2)).submit();
			}
			
		})
		
		// 댓글 삭제
		$('.reply-delete').on('click', function(){
			ttt = $(this);
			var reply_seq = $($(this).parents().get(1)).find('input[type=hidden]').val();
			$($(this).parents().get(2)).attr("action","${pageContext.request.contextPath}/board/replyDelete");
			$($(this).parents().get(2)).submit();
		})
		
		
		
		

	});
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
</script>
<style>
<!--
.rowBoard {
	border: solid 1px #EEEEEE;
	border-radius: 3px;
}

 /* Make the image fully responsive */
 .carousel-inner img {
     width: 100%;
     height: 100%;
 }
-->

.labelTitle{
	font-size: 14pt;
	color: gray;
}
.detailContent{
	font-size: 12pt;
	margin-left: 12px;
	margin-right: 12px;
}
.lineSero{
    vertical-align: middle;
    line-height: 45px;
}

.margin-bottom30{
	margin-bottom: 30px;
}
.margin-bottom20{
	margin-bottom: 20px;
}
.margin-bottom10{
	margin-bottom: 10px;
}
.padding-top10{
	padding-top: 10px;
}

#reply-profile{
	width: 90px;
	height: 90px;
    border-radius: 50%;
}

#textArea{
	height: 100px;
}

#reply-Btn{
	height: 100px;
}

.reply-header-color{
	color: gray;
}

.replyList-header{
	font-size: 10pt;
	font-weight: bold;
}
.reply-content{
	color: gray;
	width: 700px;
}

.replyList-content{
	width : 100%;
}



</style>


<!-- 앞 여백 -->
<!-- <div class="col-sm-1"></div> -->

<div class="col-sm-12">
	<div class="row">
	<div class="detailHeader">
		<h2>상세페이지</h2>
	</div>
		<div class="listBack text-right">
			<button type="button" id="travelList" class="btn btn-default">목록보기</button>
			<%-- <a href="${pageContext.request.contextPath }/board/travelMain">목록보기</a> --%>
			<hr>
		</div>

		<form id="updateTravelForm"
			action=""
			method="get">
			<div class="form-group text-right">
				
				
				<%
				if(session.getAttribute("mem_id")!=null){
				String user_id = session.getAttribute("mem_id")+"";
				String reg_id = ((BoardVO)request.getAttribute("boardVO")).getBoard_mem_id();
				
				if(user_id.equals(reg_id)){ %>
				<button type="button" id="travelUpdate" class="btn btn-default">수정</button>
				<input type="hidden" name="link" value="${link }">
				<input type="hidden" name="update" value="${link }">
				<button type="button" id="travelDelete" class="btn btn-default">삭제</button>
				<%}} %>
				
				
			</div>
		</form>

	</div>
	<div class="row">
		<div class="lineSero">
			<div class="col-sm-2 text-right">
				<label class="labelTitle label-control">제 목</label>
			</div>
				<span class="detailContent">${boardVO.board_title}</span>
		</div>
	</div><!-- row End -->

	<div class="row ">
		<div class="lineSero">
			<div class="col-sm-2 text-right">
				<label class="labelTitle label-control">작 성 자</label>
			</div>
				<span class="detailContent">${boardVO.board_mem_id}</span>
		</div>
	</div><!-- row End -->

	<div class="row ">
		<div class="lineSero">
			<div class="col-sm-2 text-right">
				<label class="labelTitle label-control">작 성 일</label>
			</div>
				<span class="detailContent"><fmt:formatDate value="${boardVO.board_dt}" pattern="yyyy-MM-dd HH:MM"/> </span>
		</div>
	</div><!-- row End -->
	
	<div class="row ">
		<div class="lineSero">
			<div class="col-sm-2 text-right">
				<label class="labelTitle label-control">조 회 수</label>
			</div>
				<span class="detailContent">${boardVO.board_hit}</span>
		</div>
	</div><!-- row End -->

	<!--사진 -->
	<div class="margin-bottom30"></div>
	<div class="row">
		<div class="col-sm-2 text-right">
				<label class="labelTitle label-control">사 진</label>
		</div>
		
		<div class="col-sm-9 col-sm-offset-1">
			
			<%
			if(request.getAttribute("imageList")!=null){
				List<File_addVO> imageList =(List<File_addVO>)request.getAttribute("imageList");
				if(imageList.size()>0){
			%>				
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
	  			<ul class="carousel-indicators">
			   <%
			   for(int i =0 ; i <imageList.size();i++){ 
					if(i==0){
						%>
						 <li  data-target="#myCarousel" data-slide-to="0" class="active"></li>
						
					<%}else{%>
						<li  data-target="#myCarousel" data-slide-to="<%=i+1%>"></li>					
					<%} 
				}%>
				</ul>		
<div class="carousel-inner">
		<%
	for(int i =0 ; i <imageList.size();i++){ 
		File_addVO image = imageList.get(i);
		%>
	  <!-- The slideshow -->
		  <%if(i==0){ %>
		    <div class="item active">
		      <img src="${pageContext.request.contextPath}<%=image.getAdd_path()%>" alt="<%=image.getAdd_oriname()%>" width="400" height="200" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
		    </div>
		    <%}else{ %>
		    <div class="item">
		      <img src="${pageContext.request.contextPath}<%=image.getAdd_path()%>" alt="<%=image.getAdd_oriname()%>" width="400" height="200" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
		    </div>
		  <% }%>
    
		<% }%>
		  <!-- Left and right controls -->
</div><!-- 	<div class="carousel-inner"> -->
	
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right"></span>
	      <span class="sr-only">Next</span>
	    </a>
	    
</div>
	<% }%>

<% }%>
  
		</div>
	</div>
	<div class="margin-bottom30">
	</div>
	<div class="row">
		<div class="col-sm-1 text-right">
				<label class="labelTitle label-control">내 용</label>
		</div>
		<div class="col-sm-9">
			<span class="detailContent">${boardVO.board_content}</span>
		</div>
	</div>
	<div class="margin-bottom30"></div>
	<hr>
	
	<%
	if(request.getAttribute("tagList")!=null){
		List<TagVO> tagList =(List<TagVO>)request.getAttribute("tagList");
		if(tagList.size()>0){			
	%>
	
	<div class="row">
		<div class="rowBoard col-sm-2">
			<h5 class="card-title">태그</h5>
		</div>
		<div class="rowBoard col-sm-9">
		<%for(int i =0 ; i <tagList.size();i++){ 
			TagVO tagVO = tagList.get(i);
		%>
			<div class="col-sm-6">
				<div class="input-group">
					<input class="form-control" name="tag_content" type="text" value="<%=tagVO.getTag_content() %>" readonly="readonly">
						<span class="delTag input-group-addon input-group-addon-remove">
							<span class="glyphicon glyphicon-remove">'
						</span>
					</span> 
				</div>
			</div>
		<%}%>
		</div>
	</div>
	<%}%>
<%}%>



	<!-- 댓글 -->
	
	<div class="reply-header-color">
		<h2>댓글목록</h2>
	</div><hr>
	
		<div class="row col-sm-12" id="replyzone">
			<c:forEach var="j" items="${replyList }">
				<div class="row">
<!-- 					<form class="form-horizontal"> -->
					<form class="form-reply-modify" action="" method="post">
						<div class="form-group">
							<input type="hidden" name="reply_seq" value="${j.reply_seq}">
							<input type="hidden" name="link" value="${link }">
							<div class="col-sm-2 text-center">
								<img id="reply-profile" src="${pageContext.request.contextPath}/${j.reply_img}" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
							</div>
							<div class="col-sm-7">
								<span class="replyList-header">작 성 자 : ${j.reply_member_id} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									    작성일자 : <fmt:parseDate var="replyDate" value="${j.reply_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
											 <fmt:formatDate value="${replyDate}" pattern="yyyy년 MM월 dd일 HH시mm분"/></span>
								<c:if test="${j.reply_member_id eq mem_id}">
									<button type="button" class="btn btn-default pull-right reply-delete">삭제</button>
									<button type="button" class="btn btn-default pull-right reply-modify">수정</button>
								</c:if>
								<div class="col-sm-10 padding-top10 reply-content">
									<textarea class="replyList-content form-control" name="reply_content" readonly="readonly" style="resize:none; outline: none; background-color: white;">${j.reply_content}</textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="row margin-bottom10"></div>
				
				
			</c:forEach>
		</div>
	
		<div class="row margin-bottom30"></div>
	
	
		<form id="replyForm" class="form-horizontal" action="${pageContext.request.contextPath}/board/travelReply">
			<div class="col-sm-2 text-center">
				<img id="reply-profile" src="${pageContext.request.contextPath}/${memberVO.mem_profile}" onError="this.src='${pageContext.request.contextPath}/image/logo/noImage.png'">
				<div>${mem_id}</div>
			</div>
				<div class="col-sm-9">
				
					<div class="comment-post">
						<textarea id="textArea" name="reply_content" class="form-control area-height" rows="3" style="resize:none;"></textarea>
					</div>
					<input type="hidden" name=board_seq value="${boardVO.board_seq }">
					<input type="hidden" name=reply_group value="0">
			</div>
			
			<div class="row">
				<div class="pull-right">
						<button type="button" class="btn btn-default" id="reply-Btn">댓글추가</button>
				</div>
			</div>
			<div class="margin-bottom30"></div>
		</form>
		<!-- /////////////////////////////// -->



		</div>
<!-- <div class="col-sm-1"></div> -->



