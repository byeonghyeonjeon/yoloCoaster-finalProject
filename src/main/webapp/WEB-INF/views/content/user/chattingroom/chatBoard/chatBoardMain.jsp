<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    chatBoardMain.jsp
    
    <!-- chatBoardMain script -->
   <script>
	$(function() {
		
		/* 게시판 조회 버튼 페이지 이동*/
		$('#boardSearch').click(function(){					
			 document.location = "${pageContext.request.contextPath }/chatBoard/main/search?" 
		});		
		/* end 게시판 조회 버튼 페이지 이동*/
		
		/* 게시판 작성 버튼 페이지 이동*/		
		$('#boardCreate').click(function(){
			document.location = "${pageContext.request.contextPath }/chatBoard/main/create"
		});
		/* end 게시판 작성 버튼 페이지 이동**/
		
		/* 게시판 디테일 페이지로 이동*/
		$('.boardList').click(function(){
			document.location = "${pageContext.request.contextPath }/chatBoard/main/detail"
		});
		/* end 게시판 디테일 페이지로 이동*/
		
	});
</script>



<!-- end chatBoardMain script -->
				<!--chatBookMain-->
				<div class="col-sm-10 col-xs-12 well chatContent" >
					<div class="row">
						<div class="well">
							<h2>Book LIST</h2>
							<p>게시판을 작성 합시다!!!</p>
						</div>
						<button id="boardSearch" class="btn btn-default" type="button">검색</button>						
						<button id="boardCreate" class="btn btn-default" type="button">게시판 작성</button>	
						<button class="btn btn-default boardList" type="button">계시판 자세히보기</button>										
					</div>
				</div>
				<!-- end chatBookMain-->
      