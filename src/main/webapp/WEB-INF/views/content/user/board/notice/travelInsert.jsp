<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script>
	$(function() {
		
		
		
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

		$("#cancel").click(
				function() {
					$("#submitForm").attr("action",
							"${pageContext.request.contextPath}/board/main");
					$("#insertTravelForm").submit();
			});
		
		//이미지 미리보기
		function readURL(input) {
		 
		    if (input.files <= 6 && input.files[0] <= 6) {
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
		
	});
</script>

<script>
	
<%@ include file="/WEB-INF/views/content/user/board/notice/imageInsert.js" %>
	
</script>

<script>
$(function(){
	
	
	$("#tag-Btn").on("click",function() {
	var tempTag = $("#tagInput").val();
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
	
			

			
	
	
})

</script>

<style>
<%@include file="/WEB-INF/views/content/user/board/notice/imageInsert.css"%>

	.margin70auto{
		margin: 70px auto;
	}
	
	.margin40auto{
		margin: 40px auto;
	}
	
	.img_zone{
		width: 1000px;
	}
	.seroSort{
		vertical-align: middle;
		line-height: 20px;
	}
	.label_title{
		font-size: 18pt;
	}
	
	.filebox input[type="file"] {
	  position: absolute;
	  width: 1px;
	  height: 1px;
	  padding: 0;
	  margin: -1px;
	  overflow: hidden;
	  clip:rect(0,0,0,0);
	  border: 0;
	}
	
	.filebox label {
	  display: inline-block;
	  padding: .5em .75em;
	  color: #585858;
	  font-size: inherit;
	  line-height: normal;
	  vertical-align: middle;
	  background-color: #D8D8D8;
	  cursor: pointer;
	  border: 1px solid #ebebeb;
	  border-bottom-color: #e2e2e2;
	  border-radius: .25em;
	}
	
	@media (min-width 1024px) {
	
		.imgs_wrap img{
			width: 200px;
		}
}
	
</style>

	<div class="margin70auto">

	<form class="form-horizontal" id="insertTravelForm"	action="${pageContext.request.contextPath}/board/insertTravelReg" method="post" enctype="multipart/form-data"	>
  	<div class="form-group seroSort">
	    <label for="inputEmail3" class="col-sm-2 control-label label_title">제목</label>
		<div class="col-md-6">
			<div class="form-group">
				<input type="text" class="form-control" name="board_title" autocomplete="off" id="board_title" placeholder="제목">
			</div>
		</div>
	</div>
	<hr class="col-sm-offset-2 col-sm-9">

<div class="row">
	<div class="col-sm-offset-2">
		<div class="preview-images-zone imgs_wrap text-center"><img src="https://image.flaticon.com/icons/svg/214/214333.svg"> </div>
	</div>
	<div class="margin40auto">
		<div class="filebox col-sm-offset-10">
		 <label for="input_imgs">사진 업로드</label>
		 <input type="file" id="input_imgs" name="file[]" class="multi afile1" maxlength="6" multiple accept="image/*"/>
		</div>
	</div>
</div>
<hr class="col-sm-offset-2 col-sm-9">

<div class="form-group">
	<label for="board_content" class="col-sm-2 control-label label_title">내용</label>
	
	<div class="col-sm-9">
		<div class="form-group">
			<textarea class="form-control textarea" rows="8" name="board_content" id="board_content" placeholder="내용을 입력해주세요" style="resize:none;"></textarea>
		</div>
	</div>
</div>



<!-- 태그-->
<div class="form-group seroSort">
	<!-- 	태그라벨 -->
	<label for="tagBox" class="col-sm-2 control-label label_title">태그</label>
	
	<!-- 	태그입력창 -->
	<div class="col-sm-7">
		<div class="form-group">
			<input type="text" class="form-control text" id="tagInput" placeholder="태그를 입력해주세요">
		</div>
	</div>
	
	<!-- 	태그추가 버튼 -->
	<div class="col-sm-2">
		<button type="button" class="btn btn-default" id="tag-Btn">태그추가</button>
	</div>
	
	<!-- 	태그 추가지역 -->
	<div class="col-sm-offset-2 col-sm-7">
		<div class="form-group" id="tagZone">
			
		</div>
	</div>
</div>





</form>
	<div class="form-group col-sm-offset-2 col-sm-10">
		<button type="button" id="travelInsert" class="btn btn-default pull-right">저장</button>
		<button type="button" id="cancel" class="btn btn-default pull-right">취소</button>

	</div>

</div>
	
       
 
 
	