<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- datetimepicker script -->
<script type="text/javascript">
	$(function() {
		$('#datetimepicker1').datetimepicker({
			format : "YYYY.MM.DD"
		});
	});
</script>
<!-- end datetimepicker script -->

<!-- chatBookDetail script -->
<script>
	$(function() {
		//작성자와 동일한지 확인
		var user_id = '${user_id}'; //로그인한 회원
		var mem_id = '${accountVO.mem_id }';//작성자

		if (mem_id == user_id) { /*작성자인지 판별*/
			//삭제 버튼 보이기
			$('#updating').css('display', 'inline');
			$('#accountDelete').css('display', 'inline');
		} else if (mem_id != (user_id)) {
			//삭제 버튼 사라지게 하기
			$('#updating').css('display', 'none');
			$('#accountUpdate').css('display', 'none');
			$('#accountDelete').css('display', 'none');
		}

		$('#updating').click(function() {
			$('input').removeAttr('readonly');
			$('textarea').removeAttr('readonly');
			$('select').removeAttr('readonly');
			//수정버튼 누르면 수정버튼 숨기고, 완료버튼 보이기
			$('#accountUpdate').css('display', 'inline');
			$('#updating').css('display', 'none');
		})
		
		/*금액 변경시 자동으로 나눠서 입력*/
		$('#accountMoney').change(function(){
			var accountMoney = $('#accountMoney').val();
			$('.dutchMoney').val(Math.ceil(accountMoney/(memberCnt-1)));
		});	
			
		
		/*멤버추가 하기*/			
		var memberCnt =${accountVO.account_cnt}+1;
		function memPlus() {
			
			if ($('#input_name').val().trim() == 0) {
				alert("인원의 이름을 입력해주세요");
			} else {
				
				$('#memList').append('<div  class="row member'+memberCnt+'"><div class="col-sm-1 col-sm-offset-2">											<label name="dutchMemberList"><h5><b>'+$('#input_name').val()+'</b></h5></label>										</div>										 <div class="col-sm-3">											<input name="dutchMoneyList" type="text" class="form-control col-sm-10 dutchMoney">										</div>										<div class="col-sm-1 row">											<button type="button" class="btn btn-default removeMem">										 <span class="glyphicon glyphicon-remove" aria-hidden="true" style="font-size:15px; color:red"></span>										 </button>									</div></div>');

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
		
		/*멤버 제거하기*/
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
<div class="col-sm-10 col-xs-12 well extend"
	style="overflow-y: scroll; height: 710px;">
	<div class="row text-center">
		<div class="well">
			<form id="accountFrm">
				<div class="row" style="margin-bottom: 10px;">
					<div class='input-group date col-sm-3 ' style="margin-left: 205px;"
						id='datetimepicker1'>
						<input type='text' id="account_dt" name="vote_end"
							class="form-control" value="${accountVO.account_dt }" readonly/> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-2">
						<input id ="account_seq" type="hidden" value="${accountVO.account_seq}">
						<label><h5>
								<b>내 역 : </b>
							</h5></label>
					</div>
					<div class="col-sm-10">
						<input id="account_detail" type="text"
							class="form-control col-sm-10" value="${accountVO.account_detail}" readonly>
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-2">
						<label><h5>
								<b>금 액 :</b>
							</h5></label>
					</div>
					<div class="col-sm-10">
						<input type="text" id="account_total"
							class="form-control col-sm-10" value="${accountVO.account_total}" readonly>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-2">
						<label><h5>
								<b>메 모 : </b>
							</h5></label>
					</div>
					<div class="col-sm-10">
						<textarea id="account_memo" class="form-control" rows="5"
							id="comment" readonly>${accountVO.account_memo }</textarea>
					</div>
				</div>
				<div id="memList" class="form-group row">
					<div class="row" style="margin-left: 1px;">
						<div class="col-sm-2">
							<label><h5>
									<b> 인 원 : </b>
								</h5></label>
						</div>
						<div class="col-sm-5">
							<input type="text" id='input_name' class="form-control col-sm-10">
						</div>
						<div class="col-sm-1 row">
							<button type="button" id="plusMem" class="btn btn-default">
								<span class="glyphicon glyphicon-plus" aria-hidden="true"
									style="font-size: 29px; color: #5ce09b"></span>
							</button>
						</div>
					</div>
					<!-- 멤버리스트 -->
					<c:forEach items="${dutchVOList }" var="dutchList" varStatus="status">
					<div  class="row member${status.count}">
						
						<div class="col-sm-1 col-sm-offset-2">
							<label name="dutchMemberList"><h5><b>${dutchList.dutch_mem_id }</b></h5></label>
						</div>
						<div class="col-sm-3">
							<input name="dutchMoneyList" type="text" class="form-control col-sm-10 dutchMoney" value="${dutchList.dutch_money }" readonly>
	     				</div>
						<div class="col-sm-1 row">
							<button type="button" class="btn btn-default removeMem">										 
								<span class="glyphicon glyphicon-remove" aria-hidden="true" style="font-size:15px; color:red"></span>
						    </button>									
						</div>
					</div>
					</c:forEach>					
					<!-- 멤버리스트 -->					
				</div>
				<div class="form-group row">
					<div class="col-sm-2">
						<label><h5><b>입금 계좌 : </b></h5></label>
					</div>
					<div class="col-sm-2">
						<input id = "account_info" type="text" class="form-control" value="${accountVO.account_info }">
					</div>
					<div class="col-sm-6">
						<input id= "account_num" type="text" class="form-control" value="${accountVO.account_num }">
					</div>
				</div>
			</form>
		</div>
		<button id="accountDetailBack" class="btn btn-default" type="button">뒤로</button>
		<button id="updating" class="btn btn-default" type="button" style="display: none;">수정</button>
		<button id="accountUpdate" class="btn btn-default" type="button" style="display: none;">완료</button>
		<button id="accountDelete" class="btn btn-default" type="button" style="display: none;">삭제</button>
	</div>
</div>
<!-- end accountCreate-->