<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- chatVoteMain script -->
   <script>
	$(function() {		
		
		/* 투표생성하기 버튼 페이지 이동*/		
		$('#voteCreate').on('click', function(event){
			event.preventDefault();			
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatVote/main/create",
				data : JSON.stringify({}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 
					$("#chatContent").html("");
					$("#chatContent").html(data);
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}
					
			})
		});	
		/* end 투표생성하기 버튼 페이지 이동*/
		
		
		
	});
</script>
<style>
.line{
			background: linear-gradient(to left, #a1f276, #5ce09b);		
			height: 3px;		
		}
</style>
<!-- end chatVoteMain script -->  

				<!--chatVoteMain-->
				<div class="col-sm-10 col-xs-12 well chatContent extend">
					<div class="row">
						<div class="well" style="background-color:white;">
							<h2>VOTE LIST</h2>
							<div class="line"></div>
							<br>
							<p>투표를 합시다!!!</p>
							<div class="line"></div>
							<br>
							<table class="table table-hover" >
								<thead>
									<tr>
										<th style="text-align:center; font-size:18px;">투표이름</th>
										<th style="text-align:center; font-size:18px;">마감시간</th>
									</tr>
								</thead>
								<tbody id ="voteTitleList">
								
								<c:forEach items="${voteSeniorVOList}" var="voteSeniorList" >
									<tr class="${ voteSeniorList.vote_seq}">
										<td>
											<div class="vote_title" sstyle="text-align:left; font-size:16px;">${voteSeniorList.vote_title }</div>									
											
											<c:set var="voter_st" value="${voteSeniorList.voter_st}"></c:set>
											<div class="row" style="color:gray; text-align:right">&lt;
											<c:choose>
												<c:when test="${voter_st eq 'N'}">
													미참여
												</c:when>
												<c:when test="${voter_st eq 'Y'}">
													투표완료
												</c:when>											
											</c:choose>											
											 &gt;</div>
										</td>
										<td class="vote_end">${voteSeniorList.vote_end }</td>
										
										<input type="hidden" class="vote_st" value="${voteSeniorList.vote_st }">
										<input type="hidden" class="voter_st" value="${voteSeniorList.voter_st }">
										<input type="hidden" class="mem_id" value="${voteSeniorList.mem_id }">
										<input type="hidden" class="vote_blind" value="${voteSeniorList.vote_blind }">											
									</tr>
								</c:forEach>
									
								</tbody>
							</table>
						</div>
						<button id="voteCreate" class="btn btn-default" type="button">투표 생성하기</button>
					</div>
				</div>
				<!-- end chatVoteMain-->