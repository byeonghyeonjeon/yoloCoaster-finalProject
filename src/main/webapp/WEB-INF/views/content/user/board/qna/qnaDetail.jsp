<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	$(function() {
		$("#qnaUpdate").click(function() {
			$("#updateQnaForm").submit();
		});		

		$('#qnaList').click(function(){
			location.href = "${pageContext.request.contextPath }/qna/qnaMain";
		})
		

	});
</script>

<h2> Q & A </h2>

<div class="row">


	<div class="listBack text-right">
		<button type="button" id="qnaList" class="btn btn-default">목록보기</button>			
		<hr>
	</div>
</div>
<div class="row">
		<div class="lineSero">
			<div class="col-sm-1 text-right">
				<label class="labelTitle label-control">제 목</label>
			</div>
				<span class="detailContent">${board.board_title}</span>
		</div>
	</div><!-- row End -->

	<div class="row ">
		<div class="lineSero">
			<div class="col-sm-1 text-right">
				<label class="labelTitle label-control">작 성 자</label>
			</div>
				<span class="detailContent">${board.board_mem_id}</span>
		</div>
	</div><!-- row End -->

	<div class="row ">
		<div class="lineSero">
			<div class="col-sm-1 text-right">
				<label class="labelTitle label-control">작 성 일</label>
			</div>
				<span class="detailContent"><fmt:formatDate value="${board.board_dt}" pattern="yyyy-MM-dd"/> </span>
		</div>
	</div><!-- row End -->
	
	<div class="row ">
		<div class="lineSero">
			<div class="col-sm-1 text-right">
				<label class="labelTitle label-control">조 회 수</label>
			</div>
				<span class="detailContent">${board.board_hit}</span>
		</div>
	</div><!-- row End -->


	<div class="margin-bottom30">
	</div>
	<div class="row">
		<div class="col-sm-1 text-right">
				<label class="labelTitle label-control">내 용</label>
		</div>
		
			<span class="detailContent">${board.board_content}</span>
		
	</div>
	<div class="margin-bottom30"></div>
	<hr>



	<!-- <div class="row">
        <div class="table-responsive col-md-12">
        <table id="sort2" class="grid table table-bordered table-sortable">
            <thead>
                <tr>
                <th class="col-sm-2">제목</th><td>Title</td>
                </tr>
                <tr>
                <th>작성자</th><td>Title</td>
                </tr>
            </thead>
            <tbody>
            	<tr>
               		<th style="height: 200px;">내용</th><td>Title</td>
                </tr>
                <tr>
                	<th style="height: 200px;">답변</th><td>Title</td>
                </tr>
            </tbody>
        </table>
        </div>
    </div> -->	
