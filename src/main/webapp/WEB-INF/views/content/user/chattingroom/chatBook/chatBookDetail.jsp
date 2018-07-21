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
<!-- end datetimepicker script -->
    
<!-- chatBookDetail script -->
   <script>
	$(function() {
		//작성자와 동일한지 확인
		var user_id = '${user_id}';
		var mem_id = '${bookVO.book_mem_id }';
		
		if(mem_id == user_id){	/*작성자인지 판별*/
			//삭제 버튼 보이기
			$('#updating').css('display','inline');
			$('#bookDelete').css('display','inline');
			/* $('#bookUpdate').css('display','inline'); */
		}else if(mem_id!=(user_id)){
			//삭제 버튼 사라지게 하기
			$('#updating').css('display','none');
			$('#bookUpdate').css('display','none');
			$('#bookDelete').css('display','none');
		}
		
		$('#updating').click(function(){
			$('input').removeAttr('readonly');
			$('textarea').removeAttr('readonly');
			$('select').removeAttr('readonly');
			//수정버튼 누르면 수정버튼 숨기고, 완료버튼 보이기
			$('#bookUpdate').css('display','inline');		
			$('#updating').css('display','none');
		})	
			
				
	});
</script>
<!-- end chatBookMain script -->
						<!--bookDetail-->
				<div class="col-sm-10 col-xs-12 well extend" style="overflow-y:scroll; height:710px;">
					<div class="row text-center">
						<div class="well">
							<form id="bookFrm">
								<div class="row" style="margin-bottom: 10px;">
									<div class="col-sm-2 col-sm-offset-2" style="width: 130px;">
										<select id = "book_inout" class="form-control text-center" readonly>
										<option value="OUT">지출</option>
										<option value="IN">수입</option>
									</select>
									</div>

									<div class='input-group date col-sm-3' style="margin-left: 15px; width: 210px;" id='datetimepicker1'>
										<input type='text' id="book_day" name="vote_end" class="form-control"  readonly value="2017.07.04"/>
										
										<span class="input-group-addon">					
					                <span class="glyphicon glyphicon-calendar"></span>
										</span>

									</div>
									<div class="col-sm-2 col-sm-offset-10 row">
										<label><h4><b>작성자&nbsp;:&nbsp;  ${bookVO.book_mem_id }</b></h4></label>
										<input id = book_seq type="hidden" value="${bookVO.book_seq}">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>내 역 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id = "book_detail" type="text" class="form-control col-sm-10" readonly value="${bookVO.book_detail }">
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>카 테 고 리 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id = "book_cate" type="text" class="form-control col-sm-10" readonly value="${bookVO.book_cate }">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>금 액 :</b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id = "book_money" type="text" class="form-control col-sm-10" readonly value="${bookVO.book_money }">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>결 제 수 단 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<input id = "book_method" type="text" class="form-control col-sm-10" readonly value="${bookVO.book_method }">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-2">
										<label><h5><b>메 모 : </b></h5></label>
									</div>
									<div class="col-sm-10">
										<textarea class="form-control" rows="5" id="book_memo" readonly >${bookVO.book_memo}</textarea>
									</div>
								</div>
							</form>
						</div>
						
						<button id="bookDetailBack" class="btn btn-default" type="button">뒤로</button>
						<button id="updating" class="btn btn-default" type="button" style="display: none;">수정</button>
						<button id="bookUpdate" class="btn btn-default" type="button" style="display: none;">완료</button>
						<button id="bookDelete" class="btn btn-default" type="button" style="display: none;">삭제</button>
					</div>
				</div>

    