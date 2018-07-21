<%@page import="java.util.List"%>
<%@page import="com.yolo.model.Like_areaVO"%>
<%@page import="com.yolo.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

var tempMaxLikeAreaNum = 0;
tempMaxLikeAreaNum=${tempMaxLikeAreaNum}
	$(function() {
		
		
		//이미지 업로드
        var sel_files = [];
        
        $(document).ready(function() {
            $("#input_imgs").on("change", handleImgsFilesSelect);
        }); 
 
        function handleImgsFilesSelect(e) {
        	 $("#imgs_wrap").html("");
            var files = e.target.files;
            var filesArr = Array.prototype.slice.call(files);
 
            filesArr.forEach(function(f) {
                if(!f.type.match("image.*")) {
                    alert("확장자는 이미지 확장자만 가능합니다.");
                    return;
                }
 
                sel_files.push(f);
 
                var reader = new FileReader();
                reader.onload = function(e) {
                    var img_html = "<img style='width: 350px;' class='img-circle col-sm-12' class='avatar img-circle img-thumbnail' src=\"" + e.target.result + "\" />";
                    
                    
                    
                    $("#imgs_wrap").append(img_html);
                }
                reader.readAsDataURL(f);
            });
        }
		
		
		
		
		
		
		
		
		$('.delLikeArea').on("click", function() {
			$(this).parent().parent().remove();
		});
		
		$("#updateYes").click(function() {
			$("#updateMyInfo").submit();
		});
		$("#updateNo").click(
				function() {
					$("#updateMyInfo").attr("action",
							"${pageContext.request.contextPath}/myPage/main");
					$("#updateMyInfo").submit();
				});
		$("#dropMem")
				.click(
						function() {
							$("#updateMyInfo")
									.attr("action",
											"${pageContext.request.contextPath}/myPageDrop/dropMem");
							$("#updateMyInfo").submit();
						});

		$("#zipsearch").on("click", function() {
			goPopup();
		});

		function goPopup() {
			// 주소검색을 수행할 팝업 페이지를 호출합니다.
			// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)호출
			if (document.body.clientWidth < 800) { //작은 사이즈용 팝업
				var pop = window
						.open(
								"${pageContext.request.contextPath}/popup/mobile_ver_jusoPopup.jsp",
								"pop", "scrollbars=yes, resizable=yes");
			} else { //웹용 팝업
				var pop = window
						.open(
								"${pageContext.request.contextPath}/popup/jusoPopup.jsp",
								"pop",
								"width=590,height=420, scrollbars=yes, resizable=yes");
			}
		}

		//'+'버튼 클릭시 액션 : 셀렉트박스에서 선택한 내용 동적 생성
		$("#addArea")
				.on(
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

												'<div class="col-sm-4">'
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

		//비밀번호 입력안했을 경우
		$('#inputPass').blur(function() {
			$('#passCheckLabel').text("");
			if ($(this).val().trim() == "") {
				$('#passCheckLabel').text("비밀번호를 입력해주세요.");
			}

		})

		//비밀번호 일치여부 확인
		$('#inputPasswordCheck').blur(
				function() {
					$('#passCheckLabel').text("");
					if ($('#inputPass').val() == ""
							|| $(this).val() != $('#inputPass').val()) {
						$('#passCheckLabel').text("비밀번호를 다시 입력해주세요");
						//$('#inputPass').focusin;
					}
				});

		var tempAddr = "";
		//검색 결과 출력

	});

	function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
			roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
			detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
			buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
		//주소값 넣기
		//$('#inputZipcode').val(zipNo);		//우편번호
		$('#addr').val(roadAddrPart1); //주소
		tempAddr = $('#addr').val();
		var tempAdd1 = tempAddr.split(' ');
		$('#mem_add1').val(tempAdd1[0]);
	}
</script>

<div class="row">
	<h1 class="page-header">프로필 수정</h1>
</div>
<div class="row">
	<form class="form-horizontal" role="form" id="updateMyInfo"
		action="${pageContext.request.contextPath}/myPage/updateMyInfo"
		method="post" enctype="multipart/form-data">
		<!-- left column -->
		<div class="col-sm-4">
			<div class="text-center">
				<div class="col-sm-12" id="imgs_wrap">
					<img style="width: 350px;" class="img-circle col-sm-12" 
						src="${pageContext.request.contextPath}/${memberVO.mem_profile}"
						class="avatar img-circle img-thumbnail">
				</div>
				<div class="col-sm-12">
					<h6>프로필 사진 선택</h6>
					<input type="file" id="input_imgs" name="file" class="text-center" accept="image/*">
				
					<input type="hidden" name="mem_profile" value="${memberVO.mem_profile}" class="text-center">
				</div>
			</div>
		</div>

		<!-- edit form column -->
		<div class="col-sm-8">
			<div class="row">
				<h3>개인 정보</h3>
			</div>
			<div class="row">



				<div class="form-group">
					<label class="col-lg-3 control-label">이 름:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_name"
							value="${memberVO.mem_name}" type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">닉 네 임:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_nick"
							value="${memberVO.mem_nick}" type="text"
							placeholder="별명 15자 이내로 입력" maxlength="15">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">아 이 디:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_id"
							value="${memberVO.mem_id}" type="text" readonly="readonly">
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">이 메 일:</label>
					<div class="col-lg-8">
						<input class="form-control"
							value="${memberVO.mem_mail}" type="email" name="mem_mail"
							data-rule-required="true" data-rule-email="true">
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 control-label">성 별:</label>
					<div class="col-lg-8">
						<input class="form-control" name="mem_gen"
							value="${memberVO.mem_gen}" type="text" readonly="readonly">
					</div>
				</div>
				<!-- d -->
				<div class="form-group" id="divAge">
					<label class="col-lg-3 control-label">연 령:</label>
					<div class="col-lg-3">
						<select class="selectpicker form-control" name="mem_age">
							<option value="${memberVO.mem_age}">연령선택</option>
							<%
								MemberVO memVO = (MemberVO) request.getAttribute("memberVO");
								int tempMem_age = 0;
								
									if(memVO.getMem_age()!=null){
										Integer.parseInt(memVO.getMem_age());
								}
								for (int i = 10; i < 80; i += 10) {
							%>
							<option value="<%=i%>" <%if (i == tempMem_age) {%> selected="selected"
								<%}%>><%=i%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<!-- d -->


				<div class="form-group">
					<label class="col-md-3 control-label">전 화 번 호:</label>
					<div class="col-md-8">
						<input class="form-control" name="mem_tel"
							value="${memberVO.mem_tel}" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">주 소:</label>
					<div class="col-sm-5">
						<input class="form-control" name="mem_add1" id="mem_add1"
							value="${memberVO.mem_add1}" type="text" readonly="readonly">
					</div>
					<div class="col-sm-3">
						<input type="button" class="form-control" id="zipsearch"
							value="주소검색">
					</div>

				</div>
				<div class="form-group" id="divAddr">
					<label class="col-md-3 control-label">상 세 주 소:</label>
					<div class="col-md-8">
						<input class="form-control" name="mem_add2" placeholder="주소"
							id="addr" data-rule-required="true" value="${memberVO.mem_add2}"
							type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">비 밀 번 호:</label>
					<div class="col-md-8">
						<input class="form-control" name="mem_pass"
							value="${memberVO.mem_pass}" id="inputPass"
							data-rule-required="true" data-msg-required="필수입력 사항입니다."
							placeholder="20자이내(영문자, 숫자, 특수문자 조합)" type="password">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">비밀번호 확인:</label>
					<div class="col-md-8">
						<input class="form-control" value="${memberVO.mem_pass}"
							data-rule-required="true" id="inputPasswordCheck"
							data-msg-required="필수입력 사항입니다."
							placeholder="20자이내(영문자, 숫자, 특수문자 조합)" type="password">
					</div>
				</div>

				<div class="form-group">
					<label for="inputLikeArea" class="col-md-3 control-label">관심지역(3개):</label>
					<div class="col-md-3">
						<select class="selectpicker form-control" id="selectLikeArea">
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
					<div class="col-lg-2">
						<button type="button" class="form-control" id="addArea">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						</button>
					</div>
				</div>
				<!-- 관심지역을 추가할 공간 -->
				<div class="form-group">
					<label for="inputLikeArea" class="col-md-3 control-label">관심지역:
					</label>
					<div class="col-sm-9" id="likeArea">
					
					<%if(request.getAttribute("likeAreaList")!=null){
						List<Like_areaVO> likeAreaList =(List<Like_areaVO>)request.getAttribute("likeAreaList");
						for(int i = 0 ; i <likeAreaList.size();i++){
						%>
						 <div class="col-sm-4">
							 <div class="input-group">
								 <input class="form-control" type="text" value="<%=likeAreaList.get(i).getMem_id() %>" readonly="readonly">
								 <span class="delLikeArea input-group-addon input-group-addon-remove">
								 	<span class="glyphicon glyphicon-remove"></span>
								 </span> 
								 <input type="hidden" name="area_code" value="<%=likeAreaList.get(i).getArea_code()%>">
							 </div>  
						 </div>			
						<%}%>
					<%}%>
					</div>
				</div>
			</div>
	</form>

	<div class="row">
		<form action="${pageContext.request.contextPath}/myPage/checkPass"
			method="get" id="updateForm"></form>
		<div class="form-group">
			<label class="col-md-3 control-label"></label>
			<div class="col-md-8">
				<button type="button" id="updateYes" class="btn btn-link">수정완료</button>
				<button type="button" id="updateNo" class="btn btn-link">취소</button>
				<button type="button" id="dropMem" class="btn btn-link">회원탈퇴</button>
			</div>
		</div>
	</div>
</div>
<!-- 여기부터 -->