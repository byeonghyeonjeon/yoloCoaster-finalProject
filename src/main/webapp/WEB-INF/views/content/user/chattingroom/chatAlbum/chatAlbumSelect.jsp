<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
  <h2>Carousel Example</h2>  
  <div id="myCarousel" class="carousel slide col-sm-9 .col-md-9" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="http://placehold.it/80x60&amp;text=two" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="http://placehold.it/80x60&amp;text=two" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="http://placehold.it/80x60&amp;text=two" alt="New york" style="width:100%;">
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
<!--/.Carousel Wrapper-->
</div>
<a></a>
 <a href="${pageContext.request.contextPath}/chatAlbum/main">목록으로 돌아가기</a><br>
 <a href="${pageContext.request.contextPath}/chatAlbum/download">다운로드</a><br>
 <a href="${pageContext.request.contextPath}/chatAlbum/delete">사진삭제</a><br>