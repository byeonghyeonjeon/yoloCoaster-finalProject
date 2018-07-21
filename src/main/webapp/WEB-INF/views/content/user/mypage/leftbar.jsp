<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-default sidebar col-xs-12 col-sm-12" id="left-nav" style="height: 800px;" "navigation">
		<div class="navbar-default sidebar" role="navigation">
        	<div class="sidebar-nav navbar-collapse">
				<!-- Links -->
				<ul class="nav" id="side-menu">
				
							<li>
								<a class="list-unstyled" href="${pageContext.request.contextPath}/myPage/main">나의정보</a>
							</li>
							<li>
							<a class="list-unstyled" href="${pageContext.request.contextPath }/myCalendar/Calendar">나의일정</a>
							</li>
							<li>
								<a class="list-unstyled" href="${pageContext.request.contextPath}/myPage/selectRecentTrevel">활동정보</a>
							</li>
							<li>
							<a class="list-unstyled" href="${pageContext.request.contextPath}/myPage/selectBookmarkArea">즐겨찾기</a>
							</li>
				</ul>
			</div>
		</div>
	</div>
 </nav>

       