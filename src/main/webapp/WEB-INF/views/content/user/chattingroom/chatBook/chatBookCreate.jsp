<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <!-- datetimepicker script -->
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format: "YYYY.MM.DD HH:mm"	
		});
	});

</script>

<script>
function onlyNumber(obj) {
    $(obj).keyup(function(){
         $(this).val($(this).val().replace(/[^0-9]/g,""));
    }); 
}

</script>
<!-- end datetimepicker script -->
  
    <!-- chatBookCreate script -->
   <script>
	$(function() {
		 //오늘 날짜로 설정
		var current = new Date();	
		//시간 담기	
		var yyyy = current.getFullYear().toString();
		var mm = "0"+(current.getMonth()+1).toString();
		mm = mm.slice(-2);
		var dd = "0"+current.getDate().toString();
		dd = dd.slice(-2);	
		var hh = "00"+current.getHours().toString();
		hh = hh.slice(-2);
		var MM = "00"+current.getMinutes().toString();
		MM = MM.slice(-2);		
		
		var today = yyyy+"."+mm+"."+dd+" "+hh+":"+MM;
		var book_day = $('#book_day').val(today);
		
		/* 가계부 상세내역 생성 버튼 페이지 이동*/		
		$('#CreateBook').click(function(){
			//bookCreate insert 가계부 추가 요청
			var book_inout=$('#book_inout').find(':selected').val();
			book_day= $('#book_day').val();		
			
			var book_detail= $('#book_detail').val();
			if(book_detail.trim() == "" || book_detail.length == 0){
				alert("가계 내역을 입력해주세요");
				return;
			}
			var book_cate = $('#book_cate').val();
			if(book_cate.trim() == "" || book_cate.length == 0){
				alert("가계 카테고리를 입력해주세요");
				return;
			}
			
			var book_money = $('#book_money').val();
			if(book_money.trim() == "" || book_money.length == 0){
				alert("가계 금액을 입력해주세요");
				return;
			}
			var book_method = $('#book_method').val();
			if(book_method.trim() == "" || book_method.length == 0){
				alert("결제 수단을 입력해주세요");
				return;
			}		
			var book_memo = $('#book_memo').val();
			
				
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatBook/create/insert", 
				data : JSON.stringify({
					book_inout:book_inout,
					book_day:book_day,
					book_detail:book_detail,
					book_cate:book_cate,
					book_money:book_money,
					book_method:book_method,
					book_memo:book_memo			
				}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) {
					console.log(data)
					$("#chatContent").html("");
					
					//bookMain 페이지 요청
					$.ajax({
						method : "post",
						url : "${pageContext.request.contextPath }/chatBook/main", 
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
					//end bookMain 페이지 요청
					
				},
				error : function(xhr) {
					console.log("실패");
					console.log(xhr);
				}   					
			})
		})
			
			// end bookCreate insert 가계부 추가 요청		
			/* document.location = "${pageContext.request.contextPath }/chatBook/main/" */
			
		/* end 가계부 생성 버튼 페이지 이동**/	
		
		/* 가계부 상세내역 취소 버튼 페이지 이동*/		
		/* $('#cancel').click(function(){
			
			
			
			document.location = "${pageContext.request.contextPath }/chatBook/main/"
		});		 */
		/* end 가계부 생성 취소 페이지 이동**/
		
		
		
		
		
		
	});
</script>
<!-- end chatBookCreate script -->

				<!--bookCreate-->
				<div class="col-sm-10 col-xs-12 well extend" style="overflow-y:scroll; height:710px;">
					<div class="row text-center">
						<div class="well">
							<form id="bookFrm">
								<div class="row" style="margin-bottom: 10px;">
									<div class="col-sm-2 col-sm-offset-2" style="width: 130px;">
										<select id="book_inout" class="form-control text-center">
											<option value="OUT">지출</option>
											<option value="IN">수입</option>
										</select>
									</div>

									<div class='input-group date col-sm-3' style="margin-left: 15px; width: 210px;" id='datetimepicker1'>
										<input type='text' id="book_day" name="book_day" class="form-control" placeholder="작성시간을 입력하세요" />
										<span class="input-group-addon">					
					                <span class="glyphicon glyphicon-calendar"></span>
										</span>

									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>내 역 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id = "book_detail" type="text" class="form-control col-sm-10">
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>카 테 고 리 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id="book_cate" type="text" class="form-control col-sm-10">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>금 액 :</b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id="book_money" type="text" class="form-control col-sm-10" onkeydown="onlyNumber(this)">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>결 제 수 단 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id = "book_method" type="text" class="form-control col-sm-10">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>메 모 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<textarea id = "book_memo" class="form-control" rows="5" id="comment"></textarea>
									</div>
								</div>
							</form>
						</div>

						<button id ="CreateBook" class="btn btn-default" type="button">추가</button>
						<button id="bookCancel" class="btn btn-default" type="button">취소</button>
					</div>
				</div>
				<!--bookCreate-->    