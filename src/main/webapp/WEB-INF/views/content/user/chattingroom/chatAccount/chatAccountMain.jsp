<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	$(function() {
		$('.datepicker').datepicker({
			autoclose: true,
			format: "yyyy.mm.dd",
			maxViewMode: 1,
			todayBtn: "linked",
			language: "kr",
			orientation: "bottom auto",
			todayHighlight: true
		});

	})
</script>
    

	<script>
	$(function() {
		
		$('#accountSearchStart').change(function(){			
			var tmp =$('#accountSearchStart').val();
			
			if($('#accountSearchStart').val()!=""){
				 $('#accountSearchEnd').removeAttr('disabled'); 		
			}
			
			$('#accountSearchEnd').val(tmp);
			
		}) 
		
		
		
		
		/* 가계부 조회 버튼 페이지 이동*/
		$('#accountSearch').click(function(){				
			var accountSearchStart  = $('#accountSearchStart').val();
			var accountSearchEnd = $('#accountSearchEnd').val();
			/* var selectContent  = $('#selectContent').find(':selected').val(); */
			var searchAccountText  = $('#searchAccountText').val();
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatAccount/main/search", 
				data : JSON.stringify({
					accountSearchStart:accountSearchStart,
					accountSearchEnd:accountSearchEnd ,
					/* selectContent:selectContent, */
					searchAccountText:searchAccountText
				}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 
					$("#accountTable").html("");
					$("#accountTable").html(data);
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}   					
			})
		});		
		/* end 가계부 조회 버튼 페이지 이동*/		
		
		
		/* 투표생성하기 버튼 페이지 이동*/
		$('#accountCreate').click(function(){
			
				$.ajax({
					method : "post",
					url : "${pageContext.request.contextPath }/chatAccount/main/create", 
					data : JSON.stringify({
							
					}),
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

				<!--accountMain-->
				<div class="col-sm-10 col-xs-12 well extend" style="overflow-y:scroll; height:710px;">
					<div class="row">
						<div class="well">
							<h1>GIVE ME THE $MONEY$</h1>
						
							<div class="line"></div>
							<br>

						<!-- 	<div class="row text-center" >
								
								<div class="col-sm-2"><h4>시작일</h4></div>
								<div class="col-sm-2"><h4>종료일</h4></div>
							</div> -->
							<div class="row">
								
								<div class="col-sm-2">
									<input id = "accountSearchStart" type="text" class="form-control datepicker inputDateStart" name="eventStartDate" placeholder="시작일을 입력하세요">
								</div>
								<div class="col-sm-2">
									<input id = "accountSearchEnd" type="text" class="form-control datepicker inputDateStart" name="eventStartDate" placeholder="종료일을 입력하세요" disabled="disabled">
								</div>
						<!-- 		<div class="col-sm-2 col-sm-offset-3 row">
									<select  id="selectContent"  class="form-control text-center" style="width:130px; margin-left: 15px;">									
										<option value = "ALL">내역+카테고리</option>										
										<option value = "DETAIL">내용</option>										
										<option value = "CATEGORY">카테고리</option>
									</select>
								</div> -->								
								<div class="col-sm-3 col-sm-offset-5">
                                   	<div class="row ">
                                   		<div class="col-sm-10 row">
                                    		<input id="searchAccountText" type="text" class="form-control" placeholder="검색할 내용을 입력하세요"  name="keyword">
                                    	</div>
                                    	<div class="col-sm-2 row">
										<div class="input-group-btn" style="">
											<button id="accountSearch" class="btn btn-default" type="submit">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</div>
										</div>							
									</div>							
								</div>
							</div>
							<br>
							<div class="line"></div>
							<br>
							<table id="accountTable"class="table table-hover text-center" style="background-color: white">
								<thead>
									<tr>										
										<th style="text-align:center; font-size:18px; width: 20%;">일자</th>
										<th style="text-align:center; font-size:18px; width: 40%;">내용</th>							
										<th style="text-align:center; font-size:18px; width: 15%;">인원수</th>		
										<th style="text-align:center; font-size:18px; width: 15%;">금액</th>
										<th style="text-align:center; font-size:18px; width: 10%;">작성자</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${accountVOList}" var="accountVO">
										<tr class="chatAccountTr">
											<input class ="account_seq" type="hidden" value="${accountVO.account_seq}">									
											<td>
												<div style="font-size:16px;">
												${accountVO.account_dt }											
												</div>
											</td>					
											<td>${accountVO.account_detail}</td>
											<td>${accountVO.account_cnt}</td>
											<td><fmt:formatNumber value="${accountVO.account_total}" pattern="#,###"></fmt:formatNumber></td>
											<td>${accountVO.mem_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<button id="accountCreate" class="btn btn-default" type="button" style="float:right;">더치페이 생성하기</button>
					</div>
				</div>
				<!--end accountMain-->