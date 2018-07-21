<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- datetimepicker script -->
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format: "YYYY.MM.DD"	
		});
	});

</script>
<!-- end datetimepicker script -->	
<script>
function onlyNumber(obj) {
    $(obj).keyup(function(){
         $(this).val($(this).val().replace(/[^0-9]/g,""));
    }); 
}

</script>


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
			
			var today = yyyy+"."+mm+"."+dd;
			var account_dt = $('#account_dt').val(today);
			
			
			$('#accountCreate').click(function(){
				account_dt = $('#account_dt').val();				
				var account_memo = $('#account_memo').val();
				
				//bookCreate insert 가계부 추가 요청
				var account_detail = $('#account_detail').val();
				if(account_detail.trim() == "" || account_detail.length == 0){
					alert("더치페이 내역을 입력해주세요");
					return;
				}
				
				
				var account_total = $('#account_total').val();
				if(account_total.trim() == "" || account_total.length == 0){
					alert("더치페이 금액을 입력해주세요");
					return;
				}
				
				 
				var account_num = $('#account_num').val(); // String
				if(account_num.trim() == "" || account_num.length == 0){
					alert("계좌번호을 입력해주세요");
					return;
				}
				
				var account_info = $('#account_info').val();
				if(account_info.trim() == "" || account_info.length == 0){
					alert("계좌번호을 입력해주세요");
					return;
				}
				
				// 더치 항목리스트 .dutchMemberList dutchMoneyList
				
				var account_cnt = $("input[name='dutchMoneyList']").length;
				//dutchMoney List에 담기
		    	var dutchMoneyList = new Array(account_cnt);		    	
		    	for(var i=0; i<account_cnt; i++){                          
		    		dutchMoneyList[i] = $("input[name='dutchMoneyList']")[i].value;
		    	}		    	
		    	//dutchMember List에 담기
		    	var dutchMemberList = new Array(account_cnt);
		    	for(var i = 0; i<account_cnt; i++){
		    		dutchMemberList[i] =$($("label[name='dutchMemberList']")[i]).text().trim();
		    		
		    	}
		    	if($($("label[name='dutchMemberList']")[0]).text().trim()==""|| $($("label[name='dutchMemberList']")[0]).text().length == 0){
		    		alert("항목을 입력해주세요");
		    	}
		    	
				//account insert 요청	
				$.ajax({
					method : "post",
					url : "${pageContext.request.contextPath }/chatAccount/create/insert", 
					data : JSON.stringify({			
						account_detail:account_detail,
						account_memo:account_memo,
						account_total:account_total,
						account_dt:account_dt,
						account_num:account_num,
						account_info:account_info,
						account_cnt:account_cnt,
						dutchMoneyList:dutchMoneyList,
						dutchMemberList:dutchMemberList					
						
					}),
					contentType : "application/json; charset=UTF-8",
					dataType : "html",
					success : function(data) {
						$("#chatContent").html("");
						
						//accountMain 페이지 요청
						$.ajax({
							method : "post",
							url : "${pageContext.request.contextPath }/chatAccount/main", 
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
						//end bookMain 페이지 요청
						
					},
					error : function(xhr) {
						console.log("실패");
						console.log(xhr);
					}   					
				})
				
				
			});
			
			
			/*금액 변경시 자동으로 나눠서 입력*/
			$('#accountMoney').change(function(){
				var accountMoney = $('#accountMoney').val();
				$('.dutchMoney').val(Math.ceil(accountMoney/(memberCnt-1)));
			});
			
			/*멤버추가 하기*/			
			var memberCnt =1;
			function memPlus() {
				
				if ($('#input_name').val().trim() == 0) {
					alert("인원의 이름을 입력해주세요");
				} else {
					
					$('#memList').append('<div  class="row member'+memberCnt+'"><div class="col-sm-1 col-sm-offset-2">											<label name="dutchMemberList"><h5><b>'+$('#input_name').val()+'</b></h5></label>										</div>										 <div class="col-sm-3">											<input name="dutchMoneyList" type="text" class="form-control col-sm-10 dutchMoney" onkeydown="onlyNumber(this)">										</div>										<div class="col-sm-1 row">											<button type="button" class="btn btn-default removeMem">										 <span class="glyphicon glyphicon-remove" aria-hidden="true" style="font-size:15px; color:red"></span>										 </button>									</div></div>');

					$('#input_name').val("");
					$('#input_name').focus();
					memberCnt +=1;
					
				}
			}
			/*더치페이할 인원 추가시 리스트 추가, 금액 나누기*/
			$('#plusMem').click(function() {					
				memPlus();
				var accountMoney = $('#account_total').val();
				$('.dutchMoney').val(Math.ceil(accountMoney/(memberCnt-1)));
			})
			/* end 멤버추가 하기*/
			
			/* 멤버 제거하기*/
			$('#memList').delegate('.removeMem','click',function() {
				$(this).parent().parent().remove();												
				var accountMoney = $('#account_total').val();				
				memberCnt -=1;
				$('.dutchMoney').val(Math.ceil(accountMoney/(memberCnt-1)));
			})
			/* end 멤버 제거하기*/
			
		});

	</script>
	
				<!--accountCreate-->
				<div class="col-sm-10 col-xs-12 well extend" style="overflow-y:scroll; height:710px;">
					<div class="row text-center">
						<div class="well">
							<form id="accountFrm">
								<div class="row" style="margin-bottom: 10px;">
									<div class='input-group date col-sm-3 ' style="margin-left: 205px; " id='datetimepicker1'>
										<input type='text' id="account_dt" name="vote_end" class="form-control" placeholder="시간을 입력하세요" />
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
										<input id="account_detail" type="text" class="form-control col-sm-10">
									</div>
								</div>
								
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>금 액 :</b></h5></label>
									</div>
									<div class="col-sm-10">
										<input type="text" id="account_total" class="form-control col-sm-10" onkeydown="onlyNumber(this)">
									</div>
								</div>								
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>메 모 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<textarea id ="account_memo" class="form-control" rows="5" id="comment"></textarea>
									</div>
								</div>
								<div id="memList" class="form-group row">
									<div class="row" style="margin-left: 1px;">
										<div class="col-sm-2">
											<label><h5><b> 인 원 : </b></h5></label>
										</div>
										<div class="col-sm-5">
											<input type="text"  id='input_name' class="form-control col-sm-10">
										</div>
										<div class="col-sm-1 row">
											<button type="button" id="plusMem" class="btn btn-default">
										 <span  class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:29px; color: #5ce09b"></span>
										 </button>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>입금 계좌 : </b></h5></label>
									</div>
									<div class="col-sm-2">
										<input id = "account_info" type="text" class="form-control" placeholder="입금은행">
									</div>
									<div class="col-sm-6">
										<input id= "account_num" type="text" class="form-control" placeholder="계좌번호">
									</div>
								</div>

							</form>
						</div>

						<button id ="accountCreate" class="btn btn-default" type="button">추가</button>
						<button id ="accountDetailBack" class="btn btn-default" type="button">뒤로</button>
					</div>
				</div>
				<!-- end accountCreate-->