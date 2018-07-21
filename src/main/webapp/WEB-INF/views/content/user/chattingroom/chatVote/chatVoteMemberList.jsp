<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <script>
    $(function(){
    	$('#back').click(function(){
    		document.location="${pageContext.request.contextPath}/chatVote/main/detail"    		
    	})
    })
    </script>
				<!--chatVoteMemberList-->
				<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
				<div class="col-sm-10 col-xs-12 well chatContent extend">
					<div class="row">
						<div class="col-sm-12 well " style="text-align:left;">
							<h1>${vote_optionVO.option_content }</h1><br>	
						
							 <input id="vote_seq" type = "hidden" value="${vote_optionVO.vote_seq}">
										
							<ul class="w3-ul w3-card-4">						
							
							<c:forEach items="${memberImgList }" var="memberList">					
								<li class="w3-bar">
									<img src="${pageContext.request.contextPath }${ memberList.mem_profile}" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
									<div class="w3-bar-item">
										<span class="w3-large">${memberList.mem_id}</span><br>										
									</div>
								</li>
								
							</c:forEach>						
								
								<!-- <li class="w3-bar">
									<img src="img_avatar6.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
									<div class="w3-bar-item">
										<span class="w3-large">Jane</span><br>
										<span>Accountant</span>
									</div>
								</li> -->
								
							</ul>
						</div>
						<button id ="voteMemberBack" class="btn btn-default" type="button">뒤로</button>
						<br>
					</div>
				</div>
				<!-- end chatVoteMemberList-->