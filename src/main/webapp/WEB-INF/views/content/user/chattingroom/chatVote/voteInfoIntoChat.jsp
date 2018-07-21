<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- voteInfoIntoChat script -->
    <script>
		$(function() {
			/* 투표하러 가기 */
			$('#goVote').click(function() {
				/* document.location = "${pageContext.request.contextPath }/voteInfo" */
			})
			/* end 투표하러 가기 */
			
			/* 투표 아이템 클릭시 투표자 정보화면으로 이동 */
			$('.itemList').click(function(){					
				/* document.location = "${pageContext.request.contextPath }/voteMemberList?" */
			});
			/* end 투표 아이템 클릭시 투표자 정보화면으로 이동*/
			
		});
	</script>
	<!-- end voteInfoIntoChat script -->
    
    
				
				
				<!--voteInfoIntoChat-->
				<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
				<div class="col-sm-10 col-xs-12 well chatContent extend">
					<div class="row">
						<div class="col-sm-12 well " style="text-align:left;">
							<h1>오늘 머 먹? 오늘 머 먹?</h1><br>
							<ul class="w3-ul w3-card-4 ">
								<li class="w3-bar itemList">
									<div class="w3-bar-item">
										<h2>햄벅이 좋아</h2>
									</div>
								</li>

								<li class="w3-bar itemList">
									<div class="w3-bar-item">
										<h2>치킨이 좋아</h2>
									</div>
								</li>

								<li class="w3-bar itemList">
									<div class="w3-bar-item">
										<h2>피자가 좋아</h2>
									</div>
								</li>

								<li id="goVote" class="w3-bar" style="background-color: dimgrey">
									<div style="float:right">
										<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
									</div>
									<div>
										<b>&emsp;투표하러 가기</b>
									</div>
								</li>
							</ul>

						</div>
					</div>
				</div>
				<!-- end voteInfoIntoChat-->			