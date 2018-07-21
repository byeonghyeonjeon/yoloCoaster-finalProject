<%@page import="java.util.ArrayList"%>
<%@page import="com.yolo.model.Content_detailVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
$(function() {
    var wrapper = $(".addlink"); //Fields wrapper
	var rowNum=${maxNum};
	console.log(rowNum);
    $(".btn-addpoint").click(function(e) { //on add input button click
        rowNum++;
        e.preventDefault();
            $('.wrapper').append(
            	'<div class="row">'+
            		'<div class="row">'+     		
	            		'<div class="line-heightSize">'+
	            		   '<h2>포인트</h2>'+
	            		'</div>'+
            	 	'</div>'+
            		'<div class="form-group">'+
	           		 	'<div>'+
		           			'<div class="col-sm-1">'+
		           				'<img id="pointImg" src="https://image.flaticon.com/icons/svg/149/149060.svg">'+
		           			'</div>'+
	           				'<div class="col-sm-7">'+
	           					'<input type="hidden" name="list['+rowNum+'].detail_seq" value="${detail_seq}">'+
	           					'<input type="hidden" name="list['+rowNum+'].content_order" value="'+rowNum+'">'+
	           					'<input type="hidden" name="list['+rowNum+'].content_title" value="2">'+
	           					'<input type="hidden" name="list['+rowNum+'].content_shape" value="01">'+
	           					'<input type="text" name="list['+rowNum+'].content_content" class="marginSize4 form-control addPoint" placeholder="위치">'+
	           				'</div>'+
	           			'</div>'+			
	           				'<button class="btn btn-danger btn-delete" >삭제</button>'+				
           			'</div>'+ 
           		'</div> '
               );
            
        
    });
    
    
        /* 세부일정 요약  */
    $(".btn-addLoca").click(function(e) { //on add input button click
    	rowNum++;
        e.preventDefault();
        $('.bs-wizard').append(
	            		'<div class="col-xs-2 bs-wizard-step complete">'+
	            			'<input type="hidden" name="list['+rowNum+'].detail_seq" value="${detail_seq}">'+
	            			'<input type="hidden" name="list['+rowNum+'].content_title" value="1">'+
	            			'<input type="hidden" name="list['+rowNum+'].content_order" value="'+rowNum+'">'+
	            			'<input type="hidden" name="list['+rowNum+'].content_shape" value="00">'+
		                    '<div class="text-center bs-wizard-stepnum">'+
		                    '<div class="input-group">'+
		                    '<input class="form-control" type="text" name="list['+rowNum+'].content_content" placeholder="위치">'+
							'<span class="input-group-addon danger btn-delete"><span class="glyphicon glyphicon-remove"></span></span>'+
							'</div>'+
		                    '</div>'+
		                    	'<div class="progress"><div class="progress-bar"></div></div>'+
		                    '<a href="#" class="bs-wizard-dot"></a>'+
	                 	'</div>'
        );
        
            
            		
            		
    });
    
    
    $(".btn-adddetail").click(function(e) { //on add input button click
    	rowNum++;
        e.preventDefault();
            $('.wrapper').append(
            		'<div class="row">'+
	            		'<div class="row">'+
	            	 		'<h2>세부일정</h2>'+
	            		'</div>'+
	            	
	            		'<div class="form-group">'+
	            		 '<div>'+
	            			'<div class="col-sm-1">'+
	            				'<img id="pointImg" src="https://image.flaticon.com/icons/svg/854/854854.svg">'+
	            			'</div>'+
	            		
	            				'<div class="col-sm-7">'+
		            				'<input type="hidden" name="list['+rowNum+'].detail_seq" value="${detail_seq}">'+
		           					'<input type="hidden" name="list['+rowNum+'].content_shape" value="02">'+
	            					'<input type="hidden" name="list['+rowNum+'].content_title" value="2">'+
	            					'<input type="hidden" name="list['+rowNum+'].content_order" value="'+rowNum+'">'+
	            					'<input type="text" name="list['+rowNum+'].content_content" class="marginSize4 form-control" placeholder="세부내용">'+
	            				'</div>'+
	            				
	            	
	            			'</div>	'+		
	            				'<button class="btn btn-danger btn-delete">삭제</button>	'+				
	            		'</div>'+
	            	'</div>'
               );
    });
    
    /*링크  */
        $(".btn-addlink").click(function(e) {
        	rowNum++;
        e.preventDefault();
            $('.wrapper').append(
            		'<div class="row">'+
	            		'<div class="row">'+
	            	 		'<h2>링크</h2>'+
	            	 		'<div class="form-group">'+
	            	 		'<input type="hidden" name="list['+rowNum+'].detail_seq" value="${detail_seq}">'+
           					'<input type="hidden" name="list['+rowNum+'].content_shape" value="03">'+
	            	 		'<input type="hidden" name="list['+rowNum+'].content_title" value="2">'+
	            	 		'<input type="hidden" name="list['+rowNum+'].content_order" value="'+rowNum+'">'+
	            	 		 '<label for="sel1">Select list:</label>'+
	            	 		  '<select class="form-control" id="sel1">'+
	            	 		    '<option>1</option>'+
	            	 		    '<option>2</option>'+
	            	 		    '<option>3</option>'+
	            	 		    '<option>4</option>'+
	            	 		  '</select>'+	
		            				'<button class="btn btn-danger btn-delete">삭제</button>	'+				
	            		'</div>'+
	            	'</div>'
               );
            
          
    });
   /*end link  */
   /*start file  */
       $(".btn-addphoto").click(function(e) {
    	   rowNum++;
        e.preventDefault();
            $('.wrapper').append(
            		'<div class="row">'+
	            		'<div class="form-group">'+
	            			'<input type="hidden" name="list['+rowNum+'].detail_seq" value="${detail_seq}">'+
       						'<input type="hidden" name="list['+rowNum+'].content_shape" value="04">'+
	            			'<input type="hidden" name="list['+rowNum+'].content_title" value="2">'+
		            		'<input type="hidden" name="list['+rowNum+'].content_order" value="'+rowNum+'">'+
		            		'<input class="img-input" name="file['+rowNum+']" type="file" multiple>'+
		            		'<div id="preview"></div>'+
		            		'<button class="btn btn-danger btn-delete">삭제</button>	'+
	   		         	'</div>'+
	            	'</div>'
               );
    });
   
   /*end file  */
   
	
   
   
    $('.wrapper').on("click", ".btn-delete", function(e) { 
        e.preventDefault();
        $(this).parent().parent().remove();
    })
    
    //위치 요약 추가
     $('.bs-wizard').on("click", ".btn-delete", function(e) { 
        e.preventDefault();
        $(this).parent().parent().parent().remove();
    })
    
     $('.addPoint').on("change", ".targetPoint", function(e) { 
    	 var tempval = $(this).val();
        e.preventDefault();
    	 $('.targetPoint').text(tempval);
    })
    
    //저장하기 버튼
   	$("#saveBtn").click(function() {
   		if(rowNum==0){
   			alert("내용을 입력해주세요");
   			return;
   		}
		$("#saveForm").submit();
	});
	
   //취소 버튼
	$("#cancelBtn").click(function() {
		history.back();
	});
    
	
});


</script>

<style>
<%@ include file="/css/scheduleView.css" %>
</style>


  <div class="row" >
    <div class="col-sm-11  col-sm-offset-1  form-group center top-marginSize20 center-block">
			<h2>일정 작성</h2>
    </div>
  </div> <!--row End -->



<div class="row">

    <div class="form-group">
      <div class="btn-center top-marginSize20">
  
      </div>
    </div>
  </div> <!-- row End -->
  	
  	<div class="row">
  		<div class="col-sm-12 form-group backcolor">
  				<label class="control-label col-sm-3">1일차</label>
					<label class="control-label col-sm-9">날짜</label>
  		</div>
  		
  	</div>


	<form action="${pageContext.request.contextPath}/scheDetail/insertScheReg" id="saveForm" method="post" enctype="multipart/form-data">	
		<div class="wrapper">	
			<div class="row">
				<div class="col-sm-12 form-group bordar-line">
	            		<div class="row bs-wizard" style="border-bottom:0;">
	            		
		            		<c:forEach items="${contentList}" var="item" step="1">
								<c:if test="${item.content_title eq 1 }">
									<div class="col-xs-4 bs-wizard-step complete">
										<div class="text-center bs-wizard-stepnum">${item.content_content }</div>
										<div class="progress">
											<div class="progress-bar"></div>
										</div>
										<a href="#" class="bs-wizard-dot"></a>
									</div>
								</c:if>
							</c:forEach>
	            		
						</div>
				</div>
				<div class="row col-sm-3 col-sm-offset-9">
			        <button style="width: 120px;" class="btn btn-link btn-addLoca">
			        	<span class="glyphicon glyphicon-link" aria-hidden="true"></span>
			        	위치 추가
			        </button>
		    	</div>
			</div> <!-- row End -->
		</div>
	</form>	
	
<c:forEach items="${contentList}" var="item" step="1">
	<c:if test="${item.content_title eq 2 }">
		<c:if test="${item.content_shape eq 01 }">
			<div class="row">&nbsp;</div>
			<div class="row">
				<div class="form-group">
					<div>
						<div class="col-sm-1">
							<img src="${pageContext.request.contextPath}/upload/map.png">
						</div>
						<div class="col-sm-7">
							<h3>${item.content_content}</h3>
						</div>
					</div>
				</div>
				<!-- form-group End -->
			</div>
			<!--row End-->
		</c:if>

		<c:if test="${item.content_shape eq 02 }">
			<div class="row">&nbsp;</div>
			<div class="row">
				<div class="form-group">
					<div>
						<div class="col-sm-1">
							<img src="${pageContext.request.contextPath}/upload/list.png">
						</div>
						<div class="col-sm-7">
							<h3>${item.content_content}</h3>
						</div>
					</div>
				</div>
				<!-- form-group End -->
			</div>
			<!--row End-->
		</c:if>


	</c:if>

</c:forEach>

<%if(request.getAttribute("contentList")!=null){ %>
<div class="row">&nbsp;</div>
	<div class="col-sm-1">
		<img src="${pageContext.request.contextPath}/upload/photo.png">
	</div>
<div class="row">&nbsp;</div>
<div class="row">

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<%
				List<Content_detailVO> contList = (List<Content_detailVO>) request.getAttribute("contentList");
				List<Content_detailVO> photoList = new ArrayList();
				for (int i = 0; i < contList.size(); i++) {
					if (contList.get(i).getContent_shape().equals("04")) {
						photoList.add(contList.get(i));
					}
				}
			%>

			<%
				for (int i = 0; i < photoList.size(); i++) {
					String phtoStr = photoList.get(i).getContent_content();
					if (i == 0) {
			%>
			<li data-target="#myCarousel" data-slide-to="<%=i%>" class="active"></li>
			<%
				} else {
			%>
			<li data-target="#myCarousel" data-slide-to="<%=i%>"></li>
			<%
				}
				}
			%>


		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">



			<%
				for (int i = 0; i < photoList.size(); i++) {
					String phtoStr = photoList.get(i).getContent_content();
					if (i == 0) {
			%>
			<div class="item active">
				<img
					src="${pageContext.request.contextPath}/upload/imageFolder/<%=phtoStr %>"
					style="width: 100%; height: 300px;">
			</div>
			<%
				} else {
			%>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/upload/imageFolder/<%=phtoStr %>"
					style="width: 100%; height: 300px;">
			</div>
			<%
				}
				}
			%>


		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
<%
	}
%>
</div>




	<div class="row">
	<div class="form-group line-heightSize">

	</div>
</div>
	
	
	<div class="row">
		<div class="row col-sm-3 col-sm-offset-9">
	        <button style="width: 120px;" class="btn btn-link btn-addlink">
	        	<span class="glyphicon glyphicon-link" aria-hidden="true"></span>
	        	링크
	        </button>
	    </div>
		<div class="row col-sm-3 col-sm-offset-9">
	        <button style="width: 120px;" class="btn btn-link btn-addpoint">
	        	<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
	       		 포인트 추가
	       	</button>
	    </div>
		<div class="row col-sm-3 col-sm-offset-9">
	        <button style="width: 120px;" class="btn btn-link btn-adddetail">
		 	    <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
		       	세부 내용
	       	</button>
	    </div>
		<div class="row col-sm-3 col-sm-offset-9">
	        <button style="width: 120px;" class="btn btn-link btn-addphoto">
				<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
				사진 추가
		    </button>
	    </div>
	</div>
	
	
	<div class="row">
		<div class="form-group line-heightSize">
			<div class="col-sm-2 col-sm-offset-4">
				<button type="button" id="saveBtn" class="btn btn-success form-control">저장 하기</button>
			</div>
			<div class="col-sm-2">
				<button type="button" id="cancelBtn" class="btn btn-default form-control">취소</button>
			</div>

		</div>
	</div> <!-- row End -->
	
</script>