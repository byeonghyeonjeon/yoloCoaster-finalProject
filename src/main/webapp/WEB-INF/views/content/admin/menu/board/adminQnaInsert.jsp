<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
$(document).ready(function(){ 
    $('#characterLeft').text('1000 /1000');
    $('#message').keydown(function () {
        var max = 1000;
        var len = $(this).val().length;
        if (len >= max) {
            $('#characterLeft').text('You have reached the limit');
            $('#characterLeft').addClass('red');
            $('#btnSubmit').addClass('disabled');            
        } 
        else {
            var ch = max - len;
            $('#characterLeft').text(ch + ' /1000');
            $('#btnSubmit').removeClass('disabled');
            $('#characterLeft').removeClass('red');            
        }
    });  
    $(".btn-goback").click(function(){
    	window.history.back();
    });
});

</script>

<style>
.red{
    color:red;
    }
.form-area
{
    background-color: #FAFAFA;
	padding: 10px 40px 60px;
	margin: 10px 0px 60px;
	border: 1px solid GREY;
	}
</style>

<div id="page-wrapper">


             <!-- Page Heading -->
             <div class="row">
                 <div class="col-lg-12">
                     <h1 class="page-header">QnA게시판 관리</h1>
                     
                     
	
<div class="col-sm-offset-1 col-sm-10">
	<table class="table table-hover">
		<tr>
			<th class="td1-css">번호</th><td class="td2-css">${boardVO.board_seq}</td>
		</tr>
		<tr>
			<th>제목<th><td>${boardVO.board_title}</td>
		</tr>
		<tr>
			<th>작성자<th><td>${boardVO.board_mem_id}</td>
		</tr>
		<tr>
			<th>작성일<th>
			<td>
			<fmt:formatDate value="${boardVO.board_dt}"  type="date" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<th>내용<th><td>${boardVO.board_content}</td>
		</tr>
		<tr>
			<th>답변<th>
			<td>
				<form action="${pageContext.request.contextPath }/adminBoard/adminQnaInsertReg" method="post">
				
				
				<div class="form-group">
	                <textarea class="form-control" type="textarea" name="board_reply"
	                id="message" placeholder="답변을 입력하세요" maxlength="140" rows="7">${boardVO.board_reply}</textarea>
	                    <span class="help-block"><p id="characterLeft" class="help-block ">
	                    </p>
	                    </span>                    
                </div>
            	<input type="hidden" name="board_seq" value="${boardVO.board_seq}">
				<button type="submit" class="btn btn-default">저장</button>
				<button type="button" class="btn btn-default btn-goback">취소</button>
				</form>
			</td>
		</tr>
	
		
			
			
            
             

	</table>
                        
                    
</div>
 

</div>
</div>
</div>




  

		