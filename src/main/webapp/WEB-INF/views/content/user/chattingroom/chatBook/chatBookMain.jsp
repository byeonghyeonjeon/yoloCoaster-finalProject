<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	$(function() {
		$('.datepicker').datepicker({
			autoclose: true,
			format: "yyyymmdd",
			maxViewMode: 1,
			todayBtn: "linked",
			language: "kr",
			orientation: "bottom auto",
			todayHighlight: true
		});

	});

</script>
  
	
    <!-- chatBookMain script -->    
   <script>
	$(function() {
		//bookSearch
		$('#bookSearch').on('click',function(){	
			//데이터 입력
			var selectMonth = $('#selectMonth').find(':selected').val();
			var selectInOut = $('#selectInOut').find(':selected').val();
			var selectContent = $('#selectContent').find(':selected').val();
			var searchText = $('#searchBookText').val();
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatBook/main/search", 
				data : JSON.stringify({
					selectMonth:selectMonth,
					selectInOut:selectInOut,
					selectContent:selectContent,
					searchText:searchText				
				}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 
					$("#bookTable").html("");
					$("#bookTable").html(data);
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}   					
			})
		});
		
		//end bookSearch
		
	
		
		
	});
</script>

<style>

.line{
			background: linear-gradient(to left, #a1f276, #5ce09b);		
			height: 3px;		
		}
		

option.first{
    display:none;
    height:0;
    visibility:hidden;
    overflow:hidden;
}

.width_max{
	width:100%;
}

</style>
<!-- end chatBookMain script -->

				<!--bookMain-->
				<div class="col-sm-10 col-xs-12 well extend" style="overflow-y:scroll; height:710px;">
					<div class="row">
						<div id="bookTableParent"class="well">
						
							<div class="row">
								<div class="col-sm-3 col-sm-offset-3">
									<h1>현재 보유 금액</h1>
								</div>
								<div class="col-sm-6" style="color:darkorchid; text-align: left;">
									<h1>￦ <i><fmt:formatNumber value="${currentMoney}" pattern="#,###"></fmt:formatNumber></i></h1>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-1 col-sm-offset-3" style="text-align: right;">
									<h2>지출</h2>
								</div>
								<div class="col-sm-2" style="color:darkcyan">
									<h2>￦ <fmt:formatNumber value="${thisOutCome }" pattern="#,###"></fmt:formatNumber></h2>
								</div>

								<div class="col-sm-1" style="text-align: right;">
									<h2>수입</h2>
								</div>
								<div class="col-sm-2" style="color:brown">
								
									<h2>￦ <fmt:formatNumber value="${thisInCome }" pattern="#,###"></fmt:formatNumber></h2>
								</div>
							</div>
							
							<div class="line"></div>
							<br>

							<div class="row">
								<div class="col-sm-3">
									<select id="selectMonth" class="form-control width_max">	
										<option class="first" value="ALL">기간</option>
										<option value="01">1월</option>
										<option value="02">2월</option>
										<option value="03">3월</option>
										<option value="04">4월</option>
										<option value="05">5월</option>
										<option value="06">6월</option>
										<option value="07">7월</option>
										<option value="08">8월</option>
										<option value="09">9월</option>
										<option value="10">10월</option>
										<option value="11">11월</option>
										<option value="12">12월</option>
									</select>
								</div>
								<div class="col-sm-3  text-center">
									<select id="selectInOut" class="form-control width_max" >										
										<option value="ALL">전체</option>
										<option value="OUT">지출</option>
										<option value="IN">수입</option>										
									</select>
								</div>
								<div class="col-sm-3 text-center">
									<select id="selectContent" class="form-control width_max" >										
										<option value="ALL">카테고리+내역</option>
										<option value="CATEGORY">카테고리만</option>
										<option value="DETAIL">내역만</option>										
									</select>
								</div>
								<div class="col-sm-3">
                                   	<div class="row">
                                   		<div class="col-sm-10 row">
                                    	<input id="searchBookText" type="text"  class="form-control width_max" placeholder="검색할 내용을 입력하세요" >
                                    	</div>
                                    	<div class="col-sm-2 row">
											<div class="input-group-btn" >
												<button id ="bookSearch" type="button" class="btn btn-default" >
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
					


							<table id ="bookTable" class="table table-hover text-center" style="background-color: white">
								<thead>
									<tr>
										<th style="text-align:center; font-size:18px; width: 15%;">일자</th>
										<th style="text-align:center; font-size:18px; width: 15%;">구분</th>
										<th style="text-align:center; font-size:18px; width: 15%;">카테고리</th>
										<th style="text-align:center; font-size:18px; width: 35%;">내용</th>
										<th style="text-align:center; font-size:18px; width: 20%;">금액</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bookVOList }" var="bookList">
										<tr class = "chatBookTr">
											<td>
												<input class="book_seq" type="hidden" value=${bookList.book_seq }>
												<div style="font-size:16px;">
													${bookList.book_dt }
												</div>
											</td>
											<td>
												<c:choose>
													<c:when test="${bookList.book_inout eq 'IN' }" >
														수입
													</c:when>
													<c:when test="${bookList.book_inout eq 'OUT' }" >
														지출
													</c:when>
												</c:choose>
											</td>
											<td>${bookList.book_cate }</td>
											<td>${bookList.book_detail }</td>
											<td><fmt:formatNumber value="${bookList.book_money }" pattern="#,###"></fmt:formatNumber></td>
										</tr>									
									</c:forEach>
								</tbody>
							</table>
						</div>
						<button id ="bookCreate" class="btn btn-default" type="button" style="float:right;">가계부 생성하기</button>
					</div>
				</div>
				<!--end bookMain-->
    