<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
   $(function(){
	   
	   //확인 버튼 클릭 이벤트
	   $('#moveMain').on('click',function(){
		   //메인 홈페이지화면으로 이동
		   location.href="${request.pageContext.contextPath}/yoloCoaster/main";
	   });
	   
	   //비밀번호 찾기 버튼 클릭 이벤트
	   $('input[name=findPassword_btn]').on('click',function(){
		   var id = $(this).parent().parent().children('label').text();
		   $('#user_id').val(id);
		   $('#idForm').submit();
	   });
	   
   })

</script>
<!-- 가운데 공간 -->
<div>
<!-- 회원가입 상단 부분 -->
    <div class="row">
        <p></p>
        <div class="col-md-12">
        	<h3>${mem_name} 님의 아이디 목록</h3>
        </div>
    </div>
    <hr>
<!-- 본문 부분 -->    
    <div class="form-horizontal">
    
	      <c:forEach var="a" items="${memberIdList}" >
	      	<div class="form-group">
		      <label class="col-lg-2 control-label">${a}</label>
		      <div class="col-lg-2">
		          <input type="button" class="form-control" name="findPassword_btn" value="비밀번호 찾기">
		      </div>
		    </div>  
	      </c:forEach>
	      
	    <div class="form-group">
	      <label class="col-lg-1 control-label"></label>
	      <div class="col-lg-2">
	          <input type="button" class="form-control btn-success" id="moveMain" value="확인">
	      </div>
	    </div>
    </div>
    <form action="${pageContext.request.contextPath}/findInfo/findPasswordForm" method="post" id="idForm"><input type="hidden" id="user_id" name="id"></form>
    
</div>	