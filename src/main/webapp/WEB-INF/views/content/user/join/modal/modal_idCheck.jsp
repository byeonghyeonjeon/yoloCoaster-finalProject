<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
	$(function(){
 		
 		//중복검사 버튼 액션
 		$("#idCheck").on("click",function(){
 			var id = $('#userId').val().trim();
 			var pattern = /[A-Za-z0-9_]{3,20}$/i;	//아이디 정규식(3자이상)
 			if(id != ""){
 				if(!id.match(pattern)){
     				alert("아이디 조건을 충족하지 않습니다 다시 입력해주세요.\n조건 : 알파벳,숫자,언더바 조합, 3~20자 사이");
     				return;
     			}else{
     				$.ajax({
     		            method : "post",
     		            url : "${pageContext.request.contextPath}/join/idCheck",
     		            data : id,
     		           	contentType : "application/json; charset=UTF-8",
     		           	dataType : "text",
     		            success : function(result){
     		            	//id가 사용가능할 때만 값이 넘어옴
     		            	if(result!=""){
	     		            	$('#ment').text( result + " 사용 가능합니다.");
	     		            	$('#user_id').val(result);
	     		            	$('#useBtn').attr('disabled', false);
	     		            	
     		            	}else{
	     		            	$('#ment').text("이미 사용중인 ID입니다. 다시 검색해 주세요.");
     		            	}
     		            },
     		            error : function(xhr){
     		            	alert("상태 : "+ xhr.status);
     		            }
     				});
     				
  					//document.location="${pageContext.request.contextPath}/join/idCheck?mem_id="+id;
                 	//controller에서 받아올 때 resultId가져오고, 중복검사 확인label 추가
                  	//$('#checkEnd').html("<label id='idCheckLabel' style='color: blue'>중복 검사 완료</label>");
     			}
 			}else{
 				alert("필수입력 사항입니다. ID를 입력해주세요.");
 				return;
 			}
            //var CheckedId = ${CheckedId} 
 		});
 		
 		//아이디입력란에 입력했을 때 버튼 활성화
 		$('#userId').on('input', $(this), function(){ // input에 변화가 있을 시 
 	        if(this.value != "") { // input value가 empty 아니면 실행 
 	            $('#idCheck').attr('disabled', false);
 	        }else{
 	            $('#idCheck').attr('disabled', true);
 	        }
 		});
 		
 		//사용하기 버튼 클릭시 액션
 		$('#useBtn').on("click", function(){
 			var id = $('#user_id').val();
 			$('#inputId').val(id);
 			$('#checkEnd').append("<label style='color: blue'>중복검사 완료</label>");	//라벨로 중복검사 확인 멘트
 			$('#modal_idCheck').modal('hide');
 			//parent.location.reload();	//모달창 닫기
 		});
 		
 		
	})
</script>

<style>

</style>

  <!-- Modal창 -->
  <div class="modal fade" role="dialog" aria-labelledby="scheduleDeleteLabel" aria-hidden="true" id="modal_idCheck">
    <div class="modal-dialog">
      <div class="modal-content">


		<!--  modal header(title) -->
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	          <h4 class="modal-title">ID 중복검사</h4>
	        </div>
	
    	<form action="" id="idform" class="form-horizontal" autocomplete="off">
	        <!-- modal body (content) -->
	        <div class="modal-body">
	        
				<div class="container-fluid">
				  <div class="form-group">
	                <label class="control-label">사용할 ID를 입력해서 검색해주세요</label>
	              </div>
			      <div class="form-group">
		            <div class="col-lg-7">
		                <input type="text" class="form-control" id="userId" name="modal_id" placeholder="알파벳,숫자,언더바 조합, 3~20자 사이" maxlength="20">
		            </div>
		            <div class="col-lg-3">
		                <input type="button" class="form-control"  id="idCheck" value="ID검색" disabled="disabled">
		            </div>
	              </div>
	              <div class="form-group">
	                <label class="control-label" id="ment"></label>
	                <input type="hidden" id="user_id">
	              </div>
	            </div>
	            
	            
	        </div>
       </form>
	        
	        <!-- modal footer ( footer ) -->
			<div class="modal-footer">
		        <div class="form-group">
		          <div class="col-sm-12" style="text-align: center;">
		            <button type="button" class="btn btn-success" disabled="disabled" id="useBtn">사용하기</button>
		            <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		          </div>
			    </div>
			</div>

      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->