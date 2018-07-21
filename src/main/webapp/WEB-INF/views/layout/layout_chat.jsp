<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" /></title>

<%@include file="/include/jquery.jsp"%>
<%@include file="/include/bootstrap.jsp"%>
<%@include file="/include/datetimepicker.jsp"%>
<%@include file="/include/datepicker.jsp"%>
<script src="${pageContext.request.contextPath}/js/jscolor.js"></script>

<%-- 기본 템플릿 설정 --%>
<style type="text/css">


nav.navbar {
	background: linear-gradient(to right, #a1f276, #5ce09b);
}

.tobNavbarName {
	color: black;
}

.nav>li>a:focus,
.nav>li>a:hover {
	background-color: #eee;
}

.navbar-header .navbar-toggle {
	background-color: #1BA39C;
}

.navbar-header .icon-bar {
	background-color: #5ce09b;
}

/* .navbar-brand img { */
/* 	width: 10%; */
/* } */

#searchForm {
	text-align: center;
}

@media (max-width: 768px) {
	#content,
	#chattingroom {
		padding-top: 160px;
	}

}

@media (min-width: 768px) {
	#content,
	#leftbar,
	#rightbar,
	#chattingroom {
		padding-top: 110px;
	}
	.mainYoloLogo{
		width: 140px;
		height:50px;
	}
}
@media (min-width: 200px) {
	.mainYoloLogo{
		width: 140px;
		height:50px;
	}
}

@media(min-width: 1024px) {
	.mainYoloLogo{
		width: 200px;
		height: 80px;
	}
}

#footer img {
	width: 60px;
}

#footer table {
	display: inline-block;
}

#footer td {
	padding-left: 10px;
	padding-right: 10px;
}



.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.row.content {
	height: 100%;
}

.sidenav {
	padding-top: 20px;
	height: 100%;
}

footer {
	background-color: #ffffff;
	color: white;
	padding: 15px;
}

@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>

<style>
.well{
	background-color : white;
}
.chatContent{
	overflow-y:scroll;
	height:710px;
}
.extend{
	width:100%;
	
}
</style>

</head>
<body>

	<%-- header --%>
	<tiles:insertAttribute name="header"/>

	<div class="container-fluid text-center">
    <div class="row content">

			<%-- 채팅방 자리 --%>
			<div class="col-sm-3 " id="chattingroom">
				<tiles:insertAttribute name="chattingroom" />
			</div>

			
			<%-- content 캘린더 +rightmunubar --%>
			<div class="col-sm-9" id="content">
			
				<tiles:insertAttribute name="chatMenubar"/>
				
				<div id="chatContent" class="col-sm-10">
					<tiles:insertAttribute name="content" />
				</div>
				
			</div>




		</div>
	</div>

	<%-- footer --%>
	<tiles:insertAttribute name="footer" />

</body>
</html>
