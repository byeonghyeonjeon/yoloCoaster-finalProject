<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	chatBoardDetail.jsp
	
	<!-- chatBoardDetail script -->
   <script>
	$(function() {
		
		/* 가계부 상세내역 확인 버튼 페이지 이동*/
		$('#boardOk').click(function(){					
			 document.location = "${pageContext.request.contextPath }/chatBoard/main" 
		});		
		/*  end 가계부 상세내역 확인 버튼 페이지 이동*/
		
		/* 가계부 상세내역 수정 버튼 페이지 이동*/
		$('#boardUpdate').click(function(){					
			 document.location = "${pageContext.request.contextPath }/chatBoard/detail/update" 
		});		
		/*  end 가계부 상세내역 수정 버튼 페이지 이동*/
		
		/* 가계부 상세내역 삭제 버튼 페이지 이동*/		
		$('#boardDelete').click(function(){
			document.location = "${pageContext.request.contextPath }/chatBoard/detail/delete"
		});s
		/* end 가계부 삭제 버튼 페이지 이동**/	
		
	});
</script>
<!-- end chatBoardDetail script -->


				<!--chatBoardDetail-->
				<div class="col-sm-10 col-xs-12 well chatContent">
					<div class="row">
						<div class="well">
							<h2>Board LIST</h2>
							<p>게시판를 작성 합시다!!!</p>
						</div>
						<button id="boardOk" class="btn btn-default" type="button">확인</button>
						<button id="boardUpdate" class="btn btn-default" type="button">수정</button>						
						<button id="boardDelete" class="btn btn-default" type="button">삭제</button>
																
					</div>
				</div>
				<!-- end chatBoardDetail-->
	