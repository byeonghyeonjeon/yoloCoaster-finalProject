<%@page import="com.yolo.model.BoardVO"%>
<%@page import="com.yolo.model.File_addVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yolo.model.TagVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<script>

$(function() {

	$(".btn-goback").click(function() {
		history.back();
	});
});

</script>

<div id="page-wrapper">


             <!-- Page Heading -->
             <div class="row">
                 <div class="col-lg-12">
                     <h1 class="page-header">게시글  상세보기</h1>
                     
    
    
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
.detailHeader{
}

#myCarousel{

}

</style>


<!-- 앞 여백 -->
<div class="col-sm-2"></div>

<div class="col-sm-9">
	<div class="row">
	<div class="detailHeader">
		<h2>상세페이지</h2>
	</div>
		<div class="listBack text-right">
			<button class="btn btn-default btn-goback">뒤로가기</button>
		</div>

		<form id="updateTravelForm"
			action=""
			method="get">
			<div class="form-group">
				
				
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
	<div class="row ">
		<div class="col-sm-2 text-right">
				<label class="labelTitle label-control">사 진</label>
		</div>
		
		<div class="col-sm-9">
		
		
<%if(request.getAttribute("imageList")!=null){
	List<File_addVO> imageList =(List<File_addVO>)request.getAttribute("imageList");
	if(imageList.size()>0){
	%>
		
		
		
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	  <ul class="carousel-indicators">
	   <%for(int i =0 ; i <imageList.size();i++){ 
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

	<div class="row">
		<div class="rowBoard col-sm-2">
			<h5 class="card-title">내용</h5>
		</div>
		<div class="rowBoard col-sm-9">
			<h5 class="card-title">${boardVO.board_content}</h5>
		</div>
	</div><hr>

<%if(request.getAttribute("tagList")!=null){
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
	<div class="row ">
		<div class="rowBoard col-sm-offset-2 col-sm-9">
					<header class="text-left">
						<div class="comment-user">
							<i class="fa fa-user"></i> ${mem_id}
						</div>
					</header>
					<div class="row">
						<form id="replyForm"
							action="${pageContext.request.contextPath}/board/travelReply">
							<div class="comment-post">
								<textarea id="textArea" name="reply_content" class="form-control"
									rows="3"></textarea>
							</div>
							<input type="hidden" name=board_seq value="${boardVO.board_seq }">
							<input type="hidden" name=reply_group value="0">
						</form>
					</div>
						<div class="row">
							<div class="col-sm-offset-7 col-sm-3">
								<button type="button" class="btn btn-default" id="reply-Btn">
									댓글추가</button>
							</div>
							<div class="col-sm-2">
							</div>
						</div>
						<div class="row col-sm-12" id="replyzone">
								<c:forEach var="j" items="${replyList }">
									<div class="row rowBoard " row=8>
										<div class="row" row=2>
											<div class="col-sm-3">
												${j.reply_member_id}
											</div>
											<div class="col-sm-3">
												
											</div>
										</div>
										<div class="row" row=3>
											<div class="col-sm-offset-2 col-sm-8">
												${j.reply_content}
											</div>
										</div>
										<div class="row" row=3>
											<div class="col-sm-4">
												${j.reply_dt}
											</div>
											<div class="col-sm-offset-6 col-sm-2">
											</div>
										</div>
									</div>
								</c:forEach>
						</div>

		</div>
	</div>
</div>
<div class="col-sm-1"></div>
    

   