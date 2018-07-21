<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
    <!-- chatVoteDetail script -->
    <script>
		$(function() {
			
			//삭제 버튼 표시 여부
			var mem_id = '${voteVO.mem_id}'; //작성자 아이디			
			var user_id = '${voteUserVO.mem_id}'; //로그인 회원 아이디
			
			if(mem_id == user_id){	/*작성자인지 판별*/
				//삭제 버튼 보이기
				$('#deleteVote').css('display','inline');
				$('#voteEnd').css('display','inline');
			}else if(mem_id!=(user_id)){
				//삭제 버튼 사라지게 하기
				$('#deleteVote').css('display','none');
				$('#voteEnd').css('display','none');
			}
			
			/*투표 유무 확인하기*/			
			var voter_st = '${voteUserVO.voter_st }';
			if(voter_st=='Y'){
				$('#votting').css('display','none');
				$('#reVotting').css('display','inline');				
				
				//사용자가 선택했던 option 표시
				$('#'+ '${voteUserVO.option_seq }').parent().attr('class', "glyphicon glyphicon-ok");					
								
			}else if(voter_st=='N'){
				$('#votting').css('display','inline');
				$('#reVotting').css('display','none');
				vottingCheck();
			};
			
			/*vote_st ='N'인경우	& 투표마감 버튼 숨기기 x	*/
			var vote_st =  '${voteVO.vote_st}';
			if(vote_st=='N'){
				$('#votting').css('display','none');
				$('#reVotting').css('display','none');
				$('#voteEnd').css('display','none');
			}	
						
			/* 투표 클릭시 체크표시하기 중복 표시 방지*/			
			 function  vottingCheck(){				
				$('li.voteItem').click(function() {
					$('.voteItem').find('div:first span:first').attr('class', "");
					$(this).find("div span:first").attr('class', "glyphicon glyphicon-ok");					
					
				})
			};
			/* end 투표 클릭시 체크표시하기 */
		
			
			/* 다시 투표하기 */
			$('#reVotting').click(function(){
				$('#votting').css('display','inline');
				$('#reVotting').css('display','none');				
				vottingCheck();				
				
			})
			
   		
	    
		});
	</script>
	<!-- end chatVoteDetail script -->
				
				<!--chatVoteDetail-->
				<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
				<div class="col-sm-10 col-xs-12 well chatContent extend">
					<div class="row">
						<div class="col-sm-12 well " style="text-align:left;">
						
							<ul class="w3-ul ">
								<li class="w3-bar">
									<img src="${pageContext.request.contextPath}${memberImg }" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
									<div class="w3-bar-item" id = "voteVO">
										<span class="w3-large" > ${voteVO.mem_id }</span><r>
										<span>마감시간 :  ${voteVO.vote_end }</span>	
									</div>
								</li>
							</ul>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-12 well " style="text-align:left;">
							<h1>${voteVO.vote_title }</h1><br>							
							 <input type="hidden" class= "vote_seq" value="${vote_seq }"> 
							<ul class="w3-ul w3-card-4" style="vertical-align: middle;">
							<c:forEach items="${vote_optionVOList}" var="vote_optionList">					
							
								<li class="w3-bar voteItem" >		
									<div class="w3-bar-item check" style="font-size:35px;">										
										<span class="" aria-hidden="true" style="font-size:35px;">&nbsp;
											 <input id="${vote_optionList.option_seq}" type="hidden" class="option_seq" value="${vote_optionList.option_seq}">
											 <input id="vote_st" type="hidden" value="${voteUserVO.voter_st }">
											 <input id ="userOption_seq" type = "hidden" value="${voteUserVO.option_seq }"> 										
										</span>										
										${vote_optionList.option_content}
									</div>																				
									<div  class= "" style="font-size:35px; float:right;">	
										<span class="glyphicon glyphicon-user" aria-hidden="true">&nbsp;</span>
										<span class="badge" style="margin-bottom: 6px;  margin-left: -15px;">${vote_optionList.option_hit}</span>
									</div>																					
								</li>
							</c:forEach>
							
							</ul>
						</div>
						
						<button id = "voteDetailBack" class="btn btn-default" type="button">뒤로</button>
						<button id ="votting" class="btn btn-default" type="button" style=";">투표하기</button>						
						<!--toggle??-->
						<!--투표 한경우, 투표리스트 비활성, and 다시 투표하기로 text변경하기 -->
						<button id = "reVotting" class="btn btn-default" type="button" style=";">다시 투표하기</button>
						<!--투표 생성자만 보이게 만들기 -->
						<button id = "deleteVote" class="btn btn-default" type="button" style=";">투표 삭제</button>						
						<button id = "voteEnd" class="btn btn-default" type="button" style=";">투표 마감</button>

						<br>
					</div>
				</div>
				<!--end chatVoteDetail-->