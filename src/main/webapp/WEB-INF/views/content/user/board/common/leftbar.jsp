<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.leftFont{
    font-weight: bold;
    font-size: 25px;
}

</style>

<div class="navbar-default sidebar col-xs-12 col-sm-12" id="left-nav" style="height: 800px;" "navigation">

	<!-- Links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li>
				<a class="list-unstyled leftFont" href="${pageContext.request.contextPath}/board/travelMain" style="color:#000">여행후기</a>
				</li>
			
				<li>
					<a class="list-unstyled leftFont" href="${pageContext.request.contextPath }/qna/qnaMain" style="color:#000">Q&A</a>
				</li>
			</ul>
		</div>
	</div>
	

</div>
