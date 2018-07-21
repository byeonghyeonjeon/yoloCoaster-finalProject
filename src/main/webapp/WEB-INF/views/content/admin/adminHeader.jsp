<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="height: 90px; padding-top: 20px;">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath }/main" style="margin-left: 100px; font-size: 50px; color: #fff;">Yolo coaster</a>
            </div>
            
            <!-- 메뉴 목록 -->
			<div class="collapse navbar-collapse navbar-right" id="topNavbar">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand" href="${pageContext.request.contextPath }/adminBoard/adminNotice" style ="margin-left:80px; color: #fff;">게시글 관리</a></li>
					<li><a class="navbar-brand" href="${pageContext.request.contextPath }/adminBoard/adminQna" style ="color: #fff;">QnA 관리</a></li>
					<li><a class="navbar-brand" href="${pageContext.request.contextPath }/adminMember/memInfoList" style ="color: #fff;">회원관리</a></li>
	                <li><a class="navbar-brand" href="${pageContext.request.contextPath }/adminTravel/adminReview" style ="color: #fff;">리뷰관리</a></li>
	                <li><a class="navbar-brand" href="${pageContext.request.contextPath }/adminTravel/adminTag" style ="color: #fff;">태그관리</a></li>
	                <li><a class="navbar-brand" href="${pageContext.request.contextPath }/adminTravel/adminCategory" style ="color: #fff;">카테고리관리</a></li>
				</ul>
				
				<ul class="nav navbar-left top-nav">
	                <li class="dropdown">
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> 관리자 <b class="caret"></b></a>
	                    <ul class="dropdown-menu">                        
	                        <li>
	                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
	                        </li>
	                    </ul>
	                </li>
            	</ul>
			</div>
        </nav>