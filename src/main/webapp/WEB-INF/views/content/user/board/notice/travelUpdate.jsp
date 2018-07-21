<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(function() {
		$("#travelUpdate").click(function(){
			$("#updateTravelForm").attr("action","${pageContext.request.contextPath}/board/travelUpdateReg");
			$("#updateTravelForm").submit();
		})
		
		
		
		
		$("#travelInsert").click(function() {
			var tempContent = $("#board_content").val()
			var tempTitle = $("#board_title").val()
			if(tempContent==""){
				alert("내용을 입력해주세요");
				return;
			}
			if(tempTitle==""){
				alert("제목을 입력해주세요");
				return;
			}
			$("#insertTravelForm").submit();
		});

		$("#cancel").click(function() {
				$("#updateTravelForm").attr("action","${pageContext.request.contextPath}/board/travelMain");
				$("#updateTravelForm").submit();
			});
		
		//이미지 미리보기
		function readURL(input) {
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();
		 
		        reader.onload = function (e) {
		            $('#image_section').attr('src', e.target.result);
		        }
		 
		        reader.readAsDataURL(input.files[0]);
		    }
		}
		 
		$("#imgInput").change(function(){
		    readURL(this);
		});
		
		
		//태그추가
		$("#tag-Btn").on("click",function() {
			var tempTag = $("#tagInput").val();
				tempTag=compactTrim(tempTag);
			if(tempTag==""){
				return;
			}
			$("#tagZone").append(
							'<div class="col-sm-6">'
							+ '<div class="input-group">'
							+ '<input class="form-control" name="tag_content" type="text" value="'+tempTag+'" readonly="readonly">'
							+ '<span class="delTag input-group-addon input-group-addon-remove">'
							+ '<span class="glyphicon glyphicon-remove">'
							+ '</span>'
							+ '</span> '
							+ '</div>' + '</div>');
			
			$("#tagInput").val("");
			$('.delTag').on("click", function() {
				$(this).parent().parent().remove();
				});
			});
			
		$('.delTag').on("click", function(){
			$(this).parent().parent().remove();
		});
		
		
		
	});
	function compactTrim(str){
		return str.replace(/ /g, '');
	}
	
</script>

<script>
	<%@ include file="/WEB-INF/views/content/user/board/notice/imageInsert.js" %>
</script>
<h2> 여행 후기 수정 페이지 </h2>


<style>
<%@include file="/WEB-INF/views/content/user/board/notice/imageInsert.css"%>
</style>


	<form class="form-horizontal" id="updateTravelForm"	action="${pageContext.request.contextPath}/board/TravelUpdateReg"
	method="post" enctype="multipart/form-data"	>
  	<div class="form-group">
	    <label for="board_title" class="col-sm-2 control-label">제목</label>
		<div class="col-md-6">
			<div class="form-group">
				<input type="text" class="form-control" name="board_title" autocomplete="off" 
				value="${boardVO.board_title }"
				id="board_title" placeholder="제목">
			</div>
		</div>
	</div>









<div class="row">
	<div class="col-sm-offset-2 preview-images-zone imgs_wrap">
	
	<c:forEach items="${imageList}" var="j">
	
		<div class="col-sm-6">
			 <div class="input-group">
			 <img alt="${j.add_oriname }" src="${pageContext.request.contextPath}${j.add_path}">
				 <input class="hidden" name="add_seq" type="text" value="${j.add_seq }">
				 <input class="hidden" name="add_path" type="text" value="${j.add_path }">
				 <span class="delTag input-group-addon input-group-addon-remove">
				 <span class="glyphicon glyphicon-remove">
				 </span>
			 </span> 
			</div>
		</div>
	
	
	
	
	</c:forEach>
	
	</div>
	<div class="col-sm-offset-9">
	 <input type="file" id="input_imgs" name="file[]" multiple="multiple" />
	</div>
</div>







<div class="form-group">
	<label for="board_content" class="col-sm-2 control-label">내용</label>
	
	<div class="col-sm-9">
		<div class="form-group">
			<textarea class="form-control textarea"   rows="8" name="board_content" id="board_content" >${boardVO.board_content }</textarea>
		</div>
	</div>
</div>



<!-- 태그-->
<div class="form-group">
	<!-- 	태그라벨 -->
	<label for="tagBox" class="col-sm-2 control-label">태그</label>
	
	<!-- 	태그입력창 -->
	<div class="col-sm-7">
		<div class="form-group">
			<input type="text" class="form-control text" rows="2" id="tagInput" placeholder="태그를 입력해주세요">
		</div>
	</div>
	
	<!-- 	태그추가 버튼 -->
	<div class="col-sm-2">
		<button type="button" class="btn btn-default" id="tag-Btn">태그추가</button>
	</div>
	
	<!-- 	태그 추가지역 -->
	<div class="col-sm-offset-2 col-sm-7">
		<div class="form-group" id="tagZone">
			<c:forEach items="${tagList }" var="i">
			
			<div class="col-sm-6">
				 <div class="input-group">
					 <input class="form-control" name="tag_content" type="text" value="${i.tag_content }" readonly="readonly">
					 <span class="delTag input-group-addon input-group-addon-remove">
					 <span class="glyphicon glyphicon-remove">
					 </span>
				 </span> 
				</div>
			</div>
			
			
			</c:forEach>
			
			
			
			
			
			
			
			
			
		</div>
	</div>
</div>





</form>
	<div class="form-group col-sm-offset-2 col-sm-10">
		<button type="button" id="travelUpdate" class="btn btn-default pull-right">저장</button>
		<button type="button" id="cancel" class="btn btn-default pull-right">취소</button>

	</div>





	
