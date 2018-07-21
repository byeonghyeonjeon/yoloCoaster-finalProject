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
<%@include file="/include/bootstrap.jsp" %>

</head>

<body style="background-color:#fff">
    <div class="container" id="">    
	<tiles:insertAttribute name="header"/>
	
		
	<tiles:insertAttribute name="content" />
	</div>
	<!-- /#wrapper -->
	
<%@include file="/include/admin.jsp" %>
</body>

</html>