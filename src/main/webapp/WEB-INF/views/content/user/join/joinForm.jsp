<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
 	$(function(){
         //아이디 입력안했을 경우, 형식이 다른경우
         //성공했을 때 라벨을 띄움(라벨이 안뜬경우 중복검사)
         //+아이디 확인하는 모달창만들기(아이디를 사용할지 물어보고, 안쓸경우 아이디 다시입력받음)
         $('#inputId').blur(function(){
             var label = $('#idCheckLabel').text();
             if(label==""){
             	//$('#checkEnd').html("<label id='idCheckLabel' style='color: red'>ID 확인 후, 중복검사를 실행해주세요</label>");
             }
         })
             
 		
 		//이메일 형식 확인
         $('#inputEmail').blur(function(){
            $('#emailCheckLabel').text("");
             var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
             if($(this).val().trim()==""){
                //alert("필수입력 사항입니다. 이메일을 입력 해 주세요.");
                //$('#inputEmail').focusin();
                //return false;
                 $('#emailCheckLabel').text("이메일을 입력해주세요.");
             } else { 
                 var mail = $(this).val();
                 if(!mail.match(regExp)) {
                     $('#emailCheckLabel').text("잘못된 이메일 형식입니다.");
                   //alert("잘못된 이메일 형식입니다. 다시 입력해주시기 바랍니다.");
                   //$(this).clear();
                   //$('#inputEmail').focusin(); 
                   //return false; 
                }
             }
         })
         
         //비밀번호 입력안했을 경우
         $('#inputPass').blur(function(){
             $('#passCheckLabel').text("");
             if($(this).val().trim()==""){
                 $('#passCheckLabel').text("비밀번호를 입력해주세요.");
             }
             
         })
         
         //비밀번호 일치여부 확인
         $('#inputPasswordCheck').blur(function(){
             $('#passCheckLabel').text("");
             if($('#inputPass').val()=="" || $(this).val()!=$('#inputPass').val()){
                 $('#passCheckLabel').text("비밀번호를 다시 입력해주세요");
                 //$('#inputPass').focusin;
             }    
         })
         
         //이름입력(한글,길이제한)
         $('#inputName').blur(function(){
             $('#nameCheckLabel').text("");
             var regExp = /^[가-힣]{2,20}$/i;
             var name = $(this).val();
             if(name=="" || name.length>14 || !name.match(regExp)){
                 $('#nameCheckLabel').text("한글 14자 이내로 입력해주세요.");
                 //$('#inputPass').focusin;
                 return false;
             }    
         })
 		
 		//'+'버튼 클릭시 액션 : 셀렉트박스에서 선택한 내용 동적 생성
		$("#addArea").on(
			"click",
			function() {
				areaList = $("input[name='area_code']"); //선택한 지역번호 리스트
				areaCode = $("#selectLikeArea option:selected")
						.val(); //셀렉트박스에서 선택한 지역번호
				if (areaList.length > 2) {
					alert("선택한도를 초과했습니다.");
					return;
				}

				if (areaCode == "") {
					alert("지역을 선택해 주세요");
				} else {

					for (var i = 0; i < areaList.length; i++) {
						if (areaList[i].value == areaCode) {
							alert("같은 지역을 선택하셨습니다.");
							return;
						}
					}

					var area = $("#selectLikeArea option:selected")
							.text();
					$("#likeArea")
							.append(

									'<div class="col-sm-2">'
											+ '<div class="input-group">'
											+ '<input class="form-control" type="text" value="'+area+'" readonly="readonly">'
											+ '<span class="delLikeArea input-group-addon input-group-addon-remove">'
											+ '<span class="glyphicon glyphicon-remove">'
											+ '</span>'
											+ '</span> '
											+ '<input type="hidden" name="area_code" value="'
									+areaCode+'">'
											+ '</div>' + '</div>');
					$('.delLikeArea').on("click", function() {
						$(this).parent().parent().remove();
					});
					$("#selectLikeArea").val('');

				}

		});
         
         //주소검색 클릭시 액션
         $("#zipsearch").on("click",function(){
        	 goPopup();
         });
         
         function goPopup(){
 			// 주소검색을 수행할 팝업 페이지를 호출합니다.
 			// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)호출
 			if(document.body.clientWidth < 800){	//작은 사이즈용 팝업
				var pop = window.open("${pageContext.request.contextPath}/popup/mobile_ver_jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
 			}else{	//웹용 팝업
				var pop = window.open("${pageContext.request.contextPath}/popup/jusoPopup.jsp","pop","width=590,height=420, scrollbars=yes, resizable=yes");     				
 			}
 		}
         

        //가입하기 버튼 클릭 액션
        $("#join").on("click",function(){
        	
            
            //조건 : 필수 입력 조건을 안쓰는 경우 회원 가입 방지
            if($('#inputId').val()=="" || $('#inputEmail').val()=="" || $('#inputPass').val()=="" || $('#inputPasswordCheck').val()=="" || $('#inputName').val()=="" || $('#sido').val()==""){
            	alert("필수입력사항이 모두 입력되지 않은 경우 \n 회원가입을 진행 할 수 없습니다.");
            	return;
            //조건2 : 추가입력받은 정보가 올바르지 않을경우 회원 가입 방지
            }else if($('#emailCheckLabel').text()!="" || $('#passCheckLabel').text()!="" || $('#nameCheckLabel').text()!=""){
            	alert("필수입력사항이 모두 충족되지 않은 경우 \n 회원가입을 진행 할 수 없습니다.");
            	return;
            }
	            
			var index = $("input[name='like_area_code']").length;
	    	var option_contentList = new Array(index);
	    	for(var i=0; i<index; i++){                          
	    		option_contentList[i] = $("input[name='like_area_code']")[i].value;
	    	}
            
            var obj = new Object(); // JSON형식으로 변환 할 오브젝트
            obj.mem_id = $("#inputId").val(); // form의 값을 오브젝트에 저장
            obj.mem_mail = $("#inputEmail").val();
            obj.mem_pass = $("#inputPass").val();
            obj.mem_name = $("#inputName").val();
            obj.mem_gen = $("input:radio[name='mem_gen']:checked").val();
            obj.mem_age = $("#age option:selected").val();
            obj.mem_addr1 = $("#sido").val();
            obj.mem_addr2 = $("#addr").val(); 
            obj.mem_tel = $("#inputTel").val(); 
            obj.mem_nick = $("#inputNick").val();
            obj.join_path = $("#inputJoinpath").val(); 
            if(obj.join_path==""){obj.join_path="01"}
            obj.like_area = option_contentList;	//배열
            
            
            var json_data = JSON.stringify(obj); // form의 값을 넣은 오브젝트를 JSON형식으로 변환
            //{"obj":{"user_id":"sdfs"}, "arr":["1","2"]}
            
 			$.ajax({
	          method : "post",
	          url : "${pageContext.request.contextPath}/join/insertMember",
	          data : json_data,
	          contentType : "application/json; charset=UTF-8",
	          dataType : "text",
	          success : function(result){
	           	//세션 : user정보, result = yes/no 로 받음 
	              if(result=="yes"){
		            alert("우리의 동료가 되었습니다. 로그인해주세요");
		            location.href="${request.pageContext.contextPath}/yoloCoaster/main";
	              }else{
		            alert("어쩌죠?;; 다시 가입하셔야 할 듯 ㅈㅅㅈㅅ");
		            location.reload();
	              }
              },
              error : function(xhr){
            	alert("상태 : "+ xhr.status);
              } 
		    }); 
            	
        });//가입하기 버튼클릭 액션
 		
 		
 	});
 	
 //검색 결과 출력
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd,
	rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm,
	buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	 //주소값 넣기
	 //$('#inputZipcode').val(zipNo);		//우편번호
	 $('#addr').val(roadAddrPart1);		//주소
} 
</script>

<!-- 모달창 include -->
<%@ include file="/WEB-INF/views/content/user/join/modal/modal_idCheck.jsp" %>

<!-- 가운데 공간 -->
<div>
<!-- 회원가입 상단 부분 -->
    <div class="row">
        <p></p>
        <div class="col-md-12">
        	<h3>yolo coaster의 동료가 돼라!</h3>
        </div>
    </div>
    <hr>
<!-- 본문 부분 -->

    <form class="form-horizontal" action="${pageContext.request.contextPath}/join/insertMember" id="joinForm" role="form" method="post" autocomplete="off">
        <div class="form-group">
            <div class="col-lg-12">
                * 표시한 부분은 필수입력 사항입니다. 
            </div>
        </div>
        <input type="hidden" name="join_path" id="inputJoinpath" value="${join_path}">
        <div class="form-group" id="divId">
            <label for="inputId" class="col-lg-2 control-label">아이디*</label>
            <div class="col-lg-4">
                <input type="text" class="form-control onlyAlphabetAndNumber" id="inputId" name="mem_id" data-rule-required="true" data-msg-required="필수입력 사항입니다."
                placeholder="중복검사버튼을 눌러주세요" maxlength="20" readonly="readonly">
            </div>
            <div class="col-lg-2">
                <input type="button" class="form-control" data-toggle="modal" data-target="#modal_idCheck" id="idCheck_btn" value="중복검사">
            </div>
            <div class="col-lg-4" id="checkEnd">
                
            </div>
        </div>
        <div class="form-group" id="divEmail">
            <label for="inputEmail" class="col-lg-2 control-label">이메일*</label>
            <div class="col-lg-6">
                <input type="email" class="form-control" id="inputEmail" name="mem_mail" data-rule-required="true" data-msg-required="필수입력 사항입니다."
                data-rule-email="true" placeholder="이메일을 입력하세요" value="${infoVO.mem_mail}">
            </div>
            <div class="col-lg-4">
                <label id="emailCheckLabel" style="color: red"></label>
            </div>
        </div>
        <div class="form-group" id="divPassword">
            <label for="inputPass" class="col-lg-2 control-label">패스워드*</label>
            <div class="col-lg-5">
                <input type="password" class="form-control" id="inputPass" name="mem_pass" 
                data-rule-required="true" data-msg-required="필수입력 사항입니다." placeholder="20자이내(영문자, 숫자, 특수문자 조합)">
            </div>
        </div>
        <div class="form-group" id="divPasswordCheck">
            <label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인*</label>
            <div class="col-lg-5">
                <input type="password" class="form-control" id="inputPasswordCheck" 
                data-rule-required="true" data-msg-required="필수입력 사항입니다." placeholder="패스워드 확인" >
            </div>
            <div class="col-lg-5">
                <label id="passCheckLabel" style="color: red"></label>
            </div>
        </div>
        <div class="form-group" id="divName">
            <label for="inputName" class="col-lg-2 control-label">이름*</label>
            <div class="col-lg-3">
                <input type="text" class="form-control onlyHangul" id="inputName" name="mem_name" 
                data-rule-required="true" data-msg-required="필수입력 사항입니다." placeholder="한글, 14자이내">
            </div>
            <div class="col-lg-7">
                <label id="nameCheckLabel" style="color: red"></label>
              </div>
          </div>
          <div class="form-group" id="divGender">
              <label for="inputGender" class="col-lg-2 control-label">성별</label>

              <div class="col-lg-10">
                  <label class="radio-inline" for="inputM">
              		<input type="radio" id="inputM" name="mem_gen" value="M" <c:if test="${infoVO.mem_gen eq 'M'}">checked="checked"</c:if>> 남성
          		</label>
                  <label class="radio-inline" for="inputF">
              		<input type="radio" id="inputF" name="mem_gen" value="W" <c:if test="${infoVO.mem_gen eq 'W'}">checked="checked"</c:if>> 여성
          		</label>
              
              </div>
          </div>
          <div class="form-group" id="divAge">
              <label for="inputName" class="col-lg-2 control-label">연령</label>
              <div class="col-lg-3">
                  <select class="selectpicker form-control" name="mem_age" id="age">
                    <option value="" >연령선택</option>
                    <option value="10" <c:if test="${infoVO.mem_age eq '10'}">selected="selected"</c:if>>10대</option>
                    <option value="20" <c:if test="${infoVO.mem_age eq '20'}">selected="selected"</c:if>>20대</option>
                    <option value="30" <c:if test="${infoVO.mem_age eq '30'}">selected="selected"</c:if>>30대</option>
                    <option value="40" <c:if test="${infoVO.mem_age eq '40'}">selected="selected"</c:if>>40대</option>
                    <option value="50" <c:if test="${infoVO.mem_age eq '50'}">selected="selected"</c:if>>50대</option>
                    <option value="60" <c:if test="${infoVO.mem_age eq '60'}">selected="selected"</c:if>>60대</option>
                    <option value="70" <c:if test="${infoVO.mem_age eq '70'}">selected="selected"</c:if>>70대</option>
                  </select>  
              </div>
          </div>
          <div class="form-group" id="divZip">
              <label for="sido" class="col-lg-2 control-label">주소*</label>
              <div class="col-lg-2">
                  <select class="selectpicker form-control" name="mem_add1" id="sido">
                    <option value="">거주지역</option>
                    <option value="1">서울</option>
                    <option value="2">인천</option>
                    <option value="3">대전</option>
                    <option value="4">대구</option>
                    <option value="5">광주</option>
                    <option value="6">부산</option>
                    <option value="7">울산</option>
                    <option value="8">세종</option>
                    <option value="31">경기도</option>
                    <option value="32">강원도</option>
                    <option value="33">충청북도</option>
                    <option value="34">충청남도</option>
                    <option value="35">경상북도</option>
                    <option value="36">경상남도</option>
                    <option value="37">전라북도</option>
                    <option value="38">전라남도</option>
                    <option value="39">제주도</option>
                  </select>
              </div>
              <div class="col-lg-2">
                  <input type="button" class="form-control" id="zipsearch" value="주소검색">
              </div>
          </div>
          <div class="form-group" id="divAddr">
              <label for="inputAddr" class="col-lg-2 control-label">상세주소</label>
              <div class="col-lg-6">
                  <input type="text" class="form-control" name="mem_add2" id="addr" 
                  data-rule-required="true" placeholder="주소" title="주소검색 버튼을 눌러 검색해주세요" readonly>
              </div>
          </div>
          <div class="form-group" id="divPhoneNumber">
              <label for="inputTel" class="col-lg-2 control-label">전화 번호</label>
              <div class="col-lg-4">
                  <input type="text" class="form-control" name="mem_tel" id="inputTel" 
                  placeholder="-를 제외한 숫자만 입력하세요." maxlength="11">
              </div>
          </div>
          <div class="form-group" id="divNick">
              <label for="inputNick" class="col-lg-2 control-label">닉네임</label>
              <div class="col-lg-4">
                  <input type="text" class="form-control" name="mem_nick" id="inputNick" 
                  data-rule-required="true" placeholder="별명 15자 이내로 입력" maxlength="15">
              </div>
          </div>
          <div class="form-group">
              <label for="inputLikeArea" class="col-lg-2 control-label">관심지역(최대 3개)</label>
              <div class="col-lg-2">
                  <select class="selectpicker form-control" name="area_code" id="selectLikeArea">
                    <option value="">관심지역</option>
                    <option value="1">서울</option>
                    <option value="2">인천</option>
                    <option value="3">대전</option>
                    <option value="4">대구</option>
                    <option value="5">광주</option>
                    <option value="6">부산</option>
                    <option value="7">울산</option>
                    <option value="8">세종</option>
                    <option value="31">경기도</option>
                    <option value="32">강원도</option>
                    <option value="33">충청북도</option>
                    <option value="34">충청남도</option>
                    <option value="35">경상북도</option>
                    <option value="36">경상남도</option>
                    <option value="37">전라북도</option>
                    <option value="38">전라남도</option>
                    <option value="39">제주도</option>
                  </select>
              </div>
              <div class="col-lg-1">
				<button type="button" class="form-control" id="addArea">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</button>
              </div>
          </div>
              <!-- 관심지역을 추가할 공간 -->
        <div class="form-group">
        	<label for="inputLikeArea" class="col-lg-2 control-label">관심지역 : </label>
            <div class="col-lg-10" id="likeArea">
            	
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="button" id="join" class="btn btn-success">가입하기</button>
            </div>
        </div>
    </form>
</div>
