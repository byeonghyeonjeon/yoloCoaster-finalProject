<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    chatBoardCreate.jsp
    
        
    <!-- chatBookCreate script -->
   <script>
	$(function() {	
		
		/* 게시판 상세내역 생성 버튼 페이지 이동*/		
		$('#CreateBoard').click(function(){
			document.location = "${pageContext.request.contextPath }/chatBoard/main/"
		});
		/* end 게시판 생성 버튼 페이지 이동**/	
		
	});
</script>
<!-- end chatBookCreate script -->

				<!--chatBookCreate-->
				<div class="col-sm-10 col-xs-12 well chatContent">
					<div class="row">
						<div class="well">
							<h2>Board LIST</h2>
							<p>게시판을 작성 합시다!!!</p>
						</div>
						<button id="CreateBoard" class="btn btn-default" type="button">추가</button>						
																
					</div>
				</div>
				<!-- end chatBookCreate-->
    