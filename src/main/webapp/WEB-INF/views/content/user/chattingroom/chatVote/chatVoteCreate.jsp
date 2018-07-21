<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- datetimepicker script -->
<script type="text/javascript">
	$(function(){
		$('#datetimepicker1').datetimepicker({			
			format: "YYYY.MM.DD HH:mm"			
		});
		
		 
	});
</script>
<!-- end datetimepicker script -->

<!-- chatVoteCreate script -->
 <script>
$(function() {
	
	var itemCnt = 2;
	/* 항목 추가 클릭시 항목 추가시키기 */
	$('#add_item').click(function() {
		itemCnt = itemCnt+1;
		$('#vote_item').append('<div class="form-group col-sm-12" id="item'+itemCnt+'">						<label class="sr-only" for="exampleInputPassword1" >항목</label>						<input type="text" class="form-control vote_option" name="option_content" placeholder="항목을 입력하세요">					</div>')
		
		if(itemCnt>=10){
			$('#add_item').attr('disabled',true);			
		}else{
			$('#add_item').removeAttr('disabled');
			$('#remove_item').removeAttr("disabled");
		}
	})
	
	/* 초기에 항목제거 막기*/
	if(itemCnt==2){
		$('#remove_item').attr('disabled',true);
	}
	
	/* 항목 추가 클릭시 항목 제거시키기 */
	$('#remove_item').click(function() {
		$('#item'+itemCnt).remove();
		itemCnt = itemCnt-1;
		
		if(itemCnt<=2){
			$('#remove_item').attr('disabled',true);	
			
		}else{
			$('#remove_item').removeAttr("disabled");
			$('#add_item').removeAttr('disabled');
		}	
	})
	
	/*체크박스*/
	$('#vote_blind').click(function(){
		var vote_blind =$('#vote_blind').attr('checked'); 
	})
	
});
</script>
<script>
$(function(){
	
	
	
	
	//투표생성 버튼
	$('#CreateVote').on('click', function(event){
		event.preventDefault();
		
		//채팅방 번호 
		var chat_seq = $('#chat_seq_hidden').val();
		
		//투표제목
		var vote_title = $('#vote_title').val();
		if(vote_title.trim() == "" || vote_title.length == 0){
			alert("투표제목을 입력해주세요");
			return;
		}
		
		//익명여부
		var vote_blind = "";
		if($('#vote_blind').prop('checked')){
			vote_blind = "Y";	
		}else{
			vote_blind = "N";
		}	
		
		//마감시간
		var vote_end ="";
		//마감시간 설정안 했을 경우
		if($('#vote_end').val().trim()==""|| $('#vote_end').val().length==0){
			
			var current = new Date();
			var currentYear = current.getFullYear().toString();
			var currentMonth = (current.getMonth()+1).toString();
			var currentDate = current.getDate().toString();
			var currentHours = current.getHours().toString();
			var carrentMinutes = current.getMinutes().toString();
			
			var future = new Date(currentYear, currentMonth, currentDate);
			var futuretYear = future.getFullYear();
			var futureMonth = future.getMonth().toString;
			
			future.setDate(future.getDate()+7);
			
			var futureDate = future.getDate().toString();
			
			//월 추가
			if(currentDate.length > futureDate.length){
				futureMonth = future.setMonth(future.getMonth()+1);
				
				//년도 추가
				if(currentMonth.length > futureMonth.length ){
					future.setFullYear(future.getFullYear()+1);	
				}
			}		
			//시간 담기	
			var yyyy = future.getFullYear().toString();
			var mm = "0"+future.getMonth().toString();
			mm = mm.slice(-2);
			var dd = "0"+future.getDate().toString();
			dd = dd.slice(-2);
			var hh = "00"+currentHours;
			hh = hh.slice(-2);
			var MM = "00"+carrentMinutes;
			MM = MM.slice(-2);			
			
			var user_endTime = yyyy+"."+mm+"."+dd+" "+hh+":"+MM;
			
			vote_end =  user_endTime;
		}
		//마감시간 설정한 경우 마감 시간 비교  
		else{
			//현재 시간
			var current = new Date();
			
			//사용자가 지정한 시간
			var user_setTime = $('#vote_end').val();
			
			var yyyy = user_setTime.substring(0, 4)		
			var mm = user_setTime.substring(5,7).toString();
			var dd = user_setTime.substring(8,10).toString()
			var hh = user_setTime.substring(11, 13).toString()
			var MM = user_setTime.substring(14,17).toString()
			
			//사용자가 지정한 시간 >> Date()
			var end = new Date(yyyy,mm,dd,hh,MM);
			
			//현재시간과 사용자가 지정한 시간 비교
			if(current > end){
				alert("마감시간은 현재시간 이후로 설정 해주세요");
			}else{
				//Date() >> 문자열 
				var user_endTime = yyyy+"."+mm+"."+dd+" "+hh+":"+MM;
				
				vote_end = user_endTime;	
			}			
		}
		
		//항목리스트
		var optionCnt = $("input[name='option_content']").length;
    	var option_contentList = new Array(optionCnt);    	
    	for(var i=0; i<optionCnt; i++){                          
    		option_contentList[i] = $("input[name='option_content']")[i].value;
    	}	
		
    	if(option_contentList[0].trim()=="" || option_contentList[1].trim()==""){
    		alert("항목은 2개 이상 입력해주세요");
    		return;
    	}
    	
		//ajax 처리
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath}/chatVote/voteCreating",
			data : JSON.stringify({
								   chat_seq:chat_seq,
								   vote_title:vote_title, 
								   vote_blind:vote_blind,
								   vote_end:vote_end,
								   option_contentList:option_contentList
								   }),
			contentType : "application/json; charset=UTF-8",
			dataType : "",
			success : function(data) { 
				console.log(data);
				//성공
				data.insertCnt > 0

					$("#chatContent").html("");
					/* $("#chatContent").html(data); */
					
					
					$.ajax({
						method : "post",
						url : "${pageContext.request.contextPath}/chatVote/main",
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
					
					/* $(location).attr('href',"${pageContext.request.contextPath}/chatVote/main"); */
					
				//실패
				
			},
			error : function(xhr) {
				console.log("실패");
				console.log(xhr);
			}				
		})
	});

	//투표생성 취소 버튼	
	$('#cancel').on('click', function(event){
		event.preventDefault();
		
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatVote/main",
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
})
</script>
<!-- end chatVoteCreate script -->

				<!--chatVoteCreate-->
				<div class="col-sm-10 col-xs-12 well chatContent extend">
					<div class="row">
						<div class="well">
							<form id ="voteCreatefrm" action="${pageContext.request.contextPath }/chatVote/voteCreating" method="post">
								<div class="form-group col-sm-12">
									<label class="sr-only" for="exampleInputEmail1">투표제목</label>
									<input type="text" class="form-control"  id="vote_title" name ="vote_title" placeholder="투표제목을 입력하세요">
								</div>
								
								<div id="vote_item">
									<div class="form-group col-sm-12" id="item1">
										<label class="sr-only" for="exampleInputPassword1" >항목</label>
										<input type="text" class="form-control option_content"  name="option_content" placeholder="항목을 입력하세요" >
									</div>
									
									<div class="form-group col-sm-12" id="item2">
										<label class="sr-only" for="exampleInputPassword1" >항목</label>
										<input type="text" class="form-control option_content"  name="option_content" placeholder="항목을 입력하세요" >
									</div>								
									

								</div>
								
								<div class="col-sm-8 col-xs-8">
									<div class="form-group"  style="text-align: left; float:left;">
										<button id="remove_item" type="button" class="btn btn-default "><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>&nbsp;항목제거</button>
									</div>
											
									<div class="form-group " style="text-align: left; ">
										<button id="add_item" type="button" class="btn btn-default "><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;항목추가</button>
									</div>											
								</div>	
							
								
								<!-- datetimePicker  -->
								<div class='input-group date col-sm-5 col-xs-8' style="margin-left: 15px;" id='datetimepicker1'>
					              <input  type='text' id ="vote_end" name="vote_end" class="form-control"  placeholder="마감시간을 입력하세요" />					
					              <span class="input-group-addon">					
					                <span class="glyphicon glyphicon-calendar"></span>					
					              </span>					
					            </div>					            
					            <!-- end datetimePicker  -->							
								
								<div class="checkbox" style="text-align:left; margin-left: 15px;">
									<label>
									  <input type="checkbox" id="vote_blind" name="vote_blind" value="vote_blind" style="text-align: left; height: 30px; width: 30px;" > <h4>&nbsp;&nbsp;&nbsp;익명선택</h4>
									</label>
								</div>
								
							</form>
						</div>
						<button id ="CreateVote" class="btn btn-default" type="button">투표 생성하기</button>
						<button id ="cancel" class="btn btn-default" type="button">취소</button>
					</div>					
				</div>				
				<!-- end chatVoteCreate-->