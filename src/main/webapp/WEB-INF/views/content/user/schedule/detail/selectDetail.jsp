<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script>
$(function() {
	//캘린더 수정페이지 이동ㄹ
	$("#updateBtn").click(function() {
		$("#updateDetailForm").submit();
	});

	
	
	
	//캘린더로 돌아가기
	$("#cancel").click(
			function() {
				history.back();
			});
	
});
</script>
<style>
<%@ include file="/css/scheduleView.css" %>
</style>


  <div class="row">
    <div class="col-sm-11 col-sm-offset-1  form-group">
			<h2>일정 상세보기</h2>
    </div>
  </div> <!--row End -->



<div class="row">
    <div class="form-group">
      <div class="btn-center top-marginSize20">
        <button type="button" class="btn btn-fresh"><a>1일차 보기</a></button>
        <button type="button" class="btn btn-fresh"><a>2일차 보기</a></button>
        <button type="button" class="btn btn-fresh"><a>3일차 보기</a></button>
        <button type="button" class="btn btn-fresh"><a>4일차 보기</a></button>
      </div>
    </div>
  </div> <!-- row End -->
  	
  	<div class="row">
  		<div class="col-sm-12 form-group backcolor">
  				<label class="control-label col-sm-3">1일차</label>
					<label class="control-label col-sm-9">날짜</label>
  		</div>
  	</div>
			
		<div class="row">
			<div class="col-sm-12 form-group">
				<div class="bordar-line">
            <div class="row bs-wizard" style="border-bottom:0;">
                
                <div class="col-xs-4 bs-wizard-step complete">
                  <div class="text-center bs-wizard-stepnum">포인트</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                </div>
                
                <div class="col-xs-4 bs-wizard-step complete"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">세부일정</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                </div>
                
                <div class="col-xs-4 bs-wizard-step active"><!-- complete -->
                  <div class="text-center bs-wizard-stepnum">사진</div>
                  <div class="progress"><div class="progress-bar"></div></div>
                  <a href="#" class="bs-wizard-dot"></a>
                </div>
						
						</div>
				</div>
			</div>
		</div> <!-- row End -->

	<div class="row">
		<div class="line-heightSize">
		   <h2>포인트</h2>
		</div>
	 </div>

	<div class="row">
		<div class="form-group">
		 <div>
			<div class="col-sm-1">
				<img id="pointImg" src="https://image.flaticon.com/icons/svg/149/149060.svg">
			</div>
		
				<div class="col-sm-7">
					<input type="text" id="inputPointText" class="marginSize4 form-control" placeholder="포인트 글쓰기 입니다">
				</div>
				
				<button class="btn btn-danger">삭제</button>						
	
			</div>				
		</div> <!-- form-group End -->
	</div> <!--row End-->
	
	 <div class="row">
 	  <h2>세부일정</h2>
	 </div>

	<div class="row">
	
		<div class="form-group">
		 <div>
			<div class="col-sm-1">
				<img id="pointImg" src="https://image.flaticon.com/icons/svg/854/854854.svg">
			</div>
		
				<div class="col-sm-7">
					<input type="text" id="inputDetailScheduleText" class="marginSize4 form-control" placeholder="포인트 글쓰기 입니다">
				</div>
				
				<button class="btn btn-danger">삭제</button>						
	
			</div>				
		</div> <!-- form-group End -->
	</div> <!--row End-->


	 <div class="row">
 	  <h2>사진 이미지</h2>
	 </div>

	<div class="row">
	
		<div class="form-group">
		 <div>
			<div class="col-sm-1">
				<img id="pointImg" src="https://www.flaticon.com/premium-icon/icons/svg/974/974368.svg">
			</div>
		
				<div class="col-sm-11">
						<div id="myCarousel" class="carousel slide maxSize50" data-ride="carousel">

											<!-- Wrapper for slides -->
											<div class="carousel-inner">
												<div class="item active">
													<img src="https://cdn.pixabay.com/photo/2018/05/02/10/33/computer-3368242_1280.jpg" alt="Los Angeles" style="width:100%;">
												</div>

												<div class="item">
													<img src="https://cdn.pixabay.com/photo/2018/06/11/09/36/beach-3468107_1280.jpg" alt="Chicago" style="width:100%;">
												</div>

												<div class="item">
													<img src="https://cdn.pixabay.com/photo/2017/03/26/16/06/architecture-2175925_1280.jpg" alt="New york" style="width:100%;">
												</div>
											</div>

							<!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left"></span>
								<span class="sr-only">Previous</span>
							</a>
							<a class="right carousel-control" href="#myCarousel" data-slide="next">
								<span class="glyphicon glyphicon-chevron-right"></span>
								<span class="sr-only">Next</span>
							</a>
						</div>
				</div> <!-- myCarousel End -->
				
			</div>	
		</div> <!-- form-group End -->
	</div> <!--row End-->
	
	<div class="row">
		<div class="col-sm-offset-1">
				<button type="button" class="btn btn-default form-control">사진 업로드</button>
		</div>
	</div> 
	
	<div class="row">
		<div class="col-sm-offset-1">
				<button type="button" class="btn btn-danger form-control">사진 삭제</button>
		</div>
	</div> <!-- row End -->
		
	
	
	<div class="row">
		<div class="form-group line-heightSize">
			<form id="updateDetailForm" action="${pageContext.request.contextPath}/scheDetail/insertSche" method="get">
			<div class="col-sm-2 col-sm-offset-4">
				<button type="button" id="updateBtn" class="btn btn-success form-control" >수정 하기</button>
			</div>
			<div class="col-sm-2">
				<button type="button" id="cancelBtn" class="btn btn-default form-control">돌아가기</button>
			</div>
			</form>

		</div>
	</div> <!-- row End -->
	
