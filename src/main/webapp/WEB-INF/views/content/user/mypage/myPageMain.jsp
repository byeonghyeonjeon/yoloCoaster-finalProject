<%@page import="com.yolo.model.MemberVO"%>
<%@page import="com.yolo.model.Like_areaVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<script>
	$(function() {
		$("#myBtn").click(function() {
			$("#updateForm").submit();
		});
		$("#btn-back").click(function() {
			$("#updateForm").attr("action","${pageContext.request.contextPath}/main");
			$("#updateForm").submit();
		});
		
	  
		
	});
</script>


	<div class="row" style="padding-top: 20px;">
	<h1 class="page-header">나의 정보</h1>
	
		<!-- left column -->
		<div class="col-md-4 col-sm-6 col-xs-12">
			<div class="text-center">
						<div class="col-xs-12 col-sm-12 col-md-12">
							<img style="width: 350px;" class="img-circle col-sm-12" onerror="${pageContext.request.contextPath}/image/logo/noImage.png"
								src="${pageContext.request.contextPath}/${memberVO.mem_profile}"
								class="avatar img-circle img-thumbnail">
						</div>
						
			</div>
		</div>
		
		<!-- edit form column -->
		<div class="col-md-8 col-sm-6 col-xs-12 personal-info">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-lg-3 control-label">이 름:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_name"
							value="${memberVO.mem_name}" type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">닉 네 임:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_nick"
							value="${memberVO.mem_nick}" type="text"
							placeholder="별명 15자 이내로 입력" maxlength="15" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">아 이 디:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_id"
							value="${memberVO.mem_id}" type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">이 메 일:</label>
					<div class="col-lg-8">
						<input class="form-control"
							value="${memberVO.mem_mail}" type="email" name="mem_mail"
							data-rule-required="true" data-rule-email="true" readonly="readonly">
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 control-label">성 별:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_gen"
							value="${memberVO.mem_gen}" type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group" id="divAge">
					<label class="col-lg-3 control-label">연 령:</label>
					<div class="col-lg-3">
						<input class="form-control" name="mem_age"
							value="${memberVO.mem_age}" type="text" readonly="readonly">
					</div>
				</div>
				<!-- d -->


				<div class="form-group">
					<label class="col-md-3 control-label">전 화 번 호:</label>
					<div class="col-md-8">
						<input class="form-control" name="mem_tel"
							value="${memberVO.mem_tel}" type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">주 소:</label>
					<div class="col-sm-5">
						<input class="form-control" name="mem_add1" id="mem_add1"
							value="${memberVO.mem_add1}" type="text" readonly="readonly">
					</div>
					

				</div>
				<div class="form-group" id="divAddr">
					<label class="col-md-3 control-label">상 세 주 소:</label>
					<div class="col-md-8">
						<input class="form-control" name="mem_add2" placeholder="주소"
							id="addr" data-rule-required="true" value="${memberVO.mem_add2}"
							type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">비 밀 번 호:</label>
					<div class="col-md-8">
						<input class="form-control" name="mem_pass"
							value="${memberVO.mem_pass}" id="inputPass"
							data-rule-required="true" data-msg-required="필수입력 사항입니다."
							placeholder="20자이내(영문자, 숫자, 특수문자 조합)" type="password" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">비밀번호 확인:</label>
					<div class="col-md-8">
						<input class="form-control" value="${memberVO.mem_pass}"
							data-rule-required="true" id="inputPasswordCheck"
							data-msg-required="필수입력 사항입니다."
							placeholder="20자이내(영문자, 숫자, 특수문자 조합)" type="password" readonly="readonly">
					</div>
				</div>
				<!-- 관심지역을 추가할 공간 -->
				<div class="form-group">
					<label for="inputLikeArea" class="col-md-3 control-label">관심지역:
					</label>
					<div class="col-sm-9" id="likeArea">
					
					<%if(request.getAttribute("likeAreaList")!=null){
						List<Like_areaVO> likeAreaList =(List<Like_areaVO>)request.getAttribute("likeAreaList");
						for(int i = 0 ; i <likeAreaList.size();i++){
						%>
						 <div class="col-sm-4">
							 <div class="input-group">
								 <input class="form-control" type="text" value="<%=likeAreaList.get(i).getMem_id() %>" readonly="readonly">
								 <span class="delLikeArea input-group-addon input-group-addon-remove">
								 	<span class="glyphicon glyphicon-remove"></span>
								 </span> 
								 <input type="hidden" name="area_code" value="<%=likeAreaList.get(i).getArea_code()%>">
							 </div>  
						 </div>			
						<%}%>
					<%}%>
					</div>
				</div>
				</form>
			</div>
			<form action="${pageContext.request.contextPath}/myPage/checkPass"
						method="get" id="updateForm"></form>
				<div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
						<input class="btn btn-primary" value="수정하기" type="button" id="myBtn">
						<span></span> <input class="btn btn-default" value="돌아가기" type="reset" id="btn-back">
					</div>
				</div>
		</div>
	</div>










