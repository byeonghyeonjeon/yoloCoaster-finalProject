# yoloCoaster - 여행 커뮤니티 사이트 - tomcat
### 개요
- 대덕인재개발원에서 진행한 최종 프로젝트 (2018.06.15 ~ 2018.07.16)
- 국내관광API를 이용한 여행정보 조회 및 커뮤니티 사이트
- Spring Framework를 사용하여 구현

### 기능 소개
- 한국관광공사에서 제공하는 REST API를 이용하여 여행지 정보 및 여행지 위치(네이버 지도)를 제공
- 실시간 기능을 제공하기 위하여 Node.js 서버를 추가적으로 이용 (기본 톰캣)
- socket.io를 이용하여 실시간 채팅 기능 제공
- fullCalendar와 socket.io를 이용하여 실시간 일정 공유 기능 제공
- 네이버 및 페이스북을 이용한 OAuth인증 기능 제공
- 구글의 Cloud Vision API를 이용한 게시글 사진 필터링 기능 제공
- js-cookie를 이용한 최근 본 여행지 저장 기능 제공

### 참여자
이름|역할|github
---|---|---
김상준  |  PL  | [sangjunkimDev](https://github.com/sangjunkimDev)
김규영  |  TA  | [gyoung0210](https://github.com/gyoung0210)
김영림  |  DA  | [oso7coda](https://github.com/oso7coda)
전병현  |  UA  | [byeonghyeonjeon](https://github.com/byeonghyeonjeon)
백선경  |  AA  | [dmsgktnekfl](https://github.com/dmsgktnekfl)
고지희  |  AA  | [수정필요](https://www.google.com)

### 사용 언어
이름 | 버전
---|---  
java  |  1.7
jsp  |  2.2
html  |  5
css  |  3
javascript  |  5

### 개발 환경
구분 | 이름 | 버전
---|---|---
OS  | window  |  7 & 10
IDE  |  eclipse  |  3.7
editor  |  atom  |  1.27.2
DB 관리  |  SQL developer  |  4.0
데이터모델링  |  eXERD  |  2.5.1
UML모델링  |  StarUML  | 5.0
프로젝트 관리  |  maven  |  3.1
형상관리  | SVN  |  4.2.4
데이터베이스  |  oracle  |  11g
was  |  tomcat  |  7.0.85
채팅서버  |  node.js  |  8.11.1

### 외부API
이름 | 용도 | 참고
--- | --- | ---
네이버 OAuth | 네이버로 로그인 |  https://developers.naver.com/products/login/api
페이스북 OAuth | 페이스북으로 로그인 | https://developers.facebook.com/products/account-creation
네이버 검색  | 블로그 정보 조회  |  https://developers.naver.com/docs/search/blog
네이버 Map  | 여행지 위치 표시 지도  |  https://developers.naver.com/products/map
국내 관광 정보  | 여행지 정보 조회  |  http://api.visitkorea.or.kr/main.do
도로명주소  | 회원가입시 주소 입력  |  https://www.juso.go.kr/CommonPageLink.do?link=/addrlink/devAddrLinkRequestSample
google cloud vision  | 게시글 이미지 필터링  |  https://cloud.google.com/vision
full calendar  | 일정 관리  |  https://fullcalendar.io
socket.io  | 채팅 및 일정 공유  |  https://socket.io
java mail  | 이메일 본인인증  |  http://www.oracle.com/technetwork/java/javamail/javamail145-1904579.html

### 로고
![yolocoaster_logo2](https://user-images.githubusercontent.com/29705928/43036661-d3ad8122-8d40-11e8-89f2-2000f581d8e4.png)

### 논리ERD
![table](https://user-images.githubusercontent.com/29705928/43036715-6ebb38da-8d41-11e8-8f1a-9e339986edb8.png)

***
### 페이스북 OAuth인증 - 구현사진
![facebookloginview](https://user-images.githubusercontent.com/29705928/43036765-3d9a71fc-8d42-11e8-815b-648f488e75d5.png)

### 페이스북 OAuth인증 - 소스코드
```
<!-- facebook login -->
<div id="fb-root"></div>
<script>
	// This is called with the results from from FB.getLoginStatus().
	function statusChangeCallback(response) {
		console.log('statusChangeCallback');
		console.log(response);
		// The response object is returned with a status field that lets the
		// app know the current login status of the person.
		// Full docs on the response object can be found in the documentation
		// for FB.getLoginStatus().
		if (response.status === 'connected') {
			// Logged into your app and Facebook.
			testAPI();
		}
	}

	// This function is called when someone finishes with the Login
	// Button.  See the onlogin handler attached to it in the sample
	// code below.
	function checkLoginState() {
		console.log('function checkLoginState()');
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : 'appid',
			cookie : true, // enable cookies to allow the server to access
			// the session
			xfbml : true, // parse social plugins on this page
			version : 'v3.0' // use graph api version 2.8
		});

		//로그인 상태를 확인함
		// FB.getLoginStatus(function(response) {
		//   console.log('FB.getLoginStatus')
		//   statusChangeCallback(response);
		// });

	};

	// Load the SDK asynchronously
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.0&appId=1808603842555097&autoLogAppEvents=1";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	//페이스북으로 로그인한 유저의 정보가 담긴 객체
	var userData;

	//로그인 완료시 실행되는 함수 (회원가입창으로 이동 필요)
	function testAPI() {
		FB.api('/me', 'GET', {
			"fields" : "id,name,email,location,gender,age_range"
		}, function(response) {
			console.log('Successful login for: ' + response.name);
			console.log('response.name: ' + response.name);
			console.log('response.id: ' + response.id);
			console.log('response.email: ' + response.email);
			console.log('response.location: ' + response.location);
			console.log('response.gender: ' + response.gender);
			console.log('response.age_range.min: ' + response.age_range.min);

			userData = response;
			//데이터를 변경하고
			//인풋 히든에다가 넣고
			$('input[name=mem_mail]').val(response.email);
			$('input[name=mem_gen]').val(response.gender);
			$('input[name=mem_age]').val(response.age_range.min);
			//폼태그로 요청 post방식
			$('#faceBookInfo').submit();
			//회원가입c
		});

	}
</script>
```
```
@RequestMapping("/faceBookJoinForm")
public String getFaceBookJoinFormPage(@RequestParam String mem_mail, String mem_gen, String mem_age, @ModelAttribute("infoVO")MemberVO memVO, Model model) {
	//페이스북 회원가입 폼 호출
	memVO = new MemberVO();
	//정보를 객체에 담음
	memVO.setMem_mail(mem_mail);
	if(mem_gen!=""){if(mem_gen.equals("female")){memVO.setMem_gen("W");}else{memVO.setMem_gen("M");}}
	memVO.setMem_age(Integer.toString((Integer.parseInt(mem_age)/10)*10));
	model.addAttribute("infoVO", memVO);
	model.addAttribute("join_path", "03");

	return "joinForm";
}
```
***
### 네이버 OAuth인증 - 구현사진
![naverloginview](https://user-images.githubusercontent.com/29705928/43036855-dadfdc40-8d42-11e8-8d9a-f87abc6d3008.png)
![naverjoin](https://user-images.githubusercontent.com/29705928/43036926-0cf165be-8d43-11e8-990e-b6aa6c77465e.png)

### 네이버 OAuth인증 - 소스코드
```
<!-- naver login -->
<!-- LoginWithNaverId Javscript SDK -->
<%@include file="/include/oauth.jsp"%>

<!-- (3) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
<script>
	$(function() {

		var naverLogin = new naver.LoginWithNaverId({
			clientId : "clientId",
			callbackHandle : true,

			//login버튼클릭시 -> callbackUrl로 이동 -> callbackUrl에서 로그인한 유저의 정보를 받음 -> 회원가입창으로 이동하게끔
			callbackUrl : "http://"
					+ window.location.hostname
					+ ((location.port == "" || location.port == undefined) ? ""
							: ":" + location.port) + "/yoloCoaster/join/naverLoginCallBack",
			isPopup : false, //팝업로그인 여부

			//로그인 버튼 사이즈 및 색깔 지정
			loginButton : {
				color : "green",
				type : 3,
				height : 40
			}
		});
		/* (4) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4-1) 임의의 링크를 설정해줄 필요가 있는 경우 */
		$("#gnbLogin").attr("href", naverLogin.generateAuthorizeUrl());
	})
</script>
```
```
@RequestMapping("naverJoinForm")
public String getNaverJoinFormPage(@RequestParam String mem_mail, String mem_gen, String mem_age, @ModelAttribute("infoVO")MemberVO memVO, Model model) {
	//네이버 회원가입 폼 호출
	memVO = new MemberVO();
	//정보를 객체에 담음
	memVO.setMem_mail(mem_mail);
	if(mem_gen.equals("F")){memVO.setMem_gen("W");}else{memVO.setMem_gen("M");}
	memVO.setMem_age(mem_age.substring(0, 2));
	model.addAttribute("infoVO", memVO);
	model.addAttribute("join_path", "02");
	System.out.println(memVO);

	return "joinForm";
}
```
***
### 도로명주소API - 구현사진
![joinjusoapi](https://user-images.githubusercontent.com/29705928/43036986-38c96722-8d43-11e8-8f62-c6b3527e2dc8.png)

### 도로명주소API - 소스코드
```
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
//검색 결과 출력
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd,
rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm,
buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	//주소값 넣기
	//$('#inputZipcode').val(zipNo);		//우편번호
	$('#addr').val(roadAddrPart1);		//주소
}
```
***
### 자바 Mail API - 구현사진
![findidview](https://user-images.githubusercontent.com/29705928/43037130-b1285c68-8d44-11e8-949b-5d645156e6d9.png)
![findinfomaillingview](https://user-images.githubusercontent.com/29705928/43037133-b543e4de-8d44-11e8-8c62-b0f3c1a72602.png)
![findidlistview](https://user-images.githubusercontent.com/29705928/43037136-b8af45a0-8d44-11e8-9034-2f5d32abc0a0.png)

### 자바 Mail API - 소스코드
```
<script>
$(function(){
	//인증번호 받기 버튼 클릭 이벤트
	$('#sendCertify_btn').on('click',function(){
	var mem_name = $('#inputName').val().trim();
	var mem_mail = $('#inputEmail').val().trim();
	var userInfo = '{"mem_name":"' + mem_name + '", "mem_mail":"'+mem_mail+'"}';

	$.ajax({
		method : "post",
		url : "${pageContext.request.contextPath}/findInfo/matchFindId",
		data : userInfo,
			contentType : "application/json; charset=UTF-8",
			dataType : "text",
		success : function(result){
			//일치하는 경우 인증번호 보내기(혹은 인증번호를 result로 받아옴)
			if(result =="yes"){
				$("#infoMent").text("");
				$("#inputCertify").prop("readonly",false);
				$("#infoMent").append("인증번호를 메일주소로 전송했습니다. 인증번호를 입력해주세요");
			}else{
				$("#infoMent").text("");
				$("#infoMent").append("메일을 못받으셨다면 이름과 이메일을 확인해 주시길 바랍니다.");
				$("#inputCertify").prop("readonly",true);
			}
		},
		error : function(xhr){
			alert("상태 : "+ xhr.status);
		}
	});
});
</script>
```
```
@RequestMapping("/matchFindId")
@ResponseBody
public String matchFindId(@RequestBody Map<String, String> userInfo) {
	//회원 아이디 찾기 (이름, 이메일 주소 맞으면 메일보내기 & 성공 리턴하면 인증번호입력칸 활성화
	MemberVO memVO = new MemberVO();
	memVO.setMem_name(userInfo.get("mem_name"));
	memVO.setMem_mail(userInfo.get("mem_mail"));
	int result = findInfoService.findMemId(memVO);
	if(result!=0){
		//메일보내기
		EmailVO mailVO = new EmailVO();
		mailVO.setReceiver(memVO.getMem_mail());
		mailVO.setSubject(memVO.getMem_name() + "님의 아이디 찾기 인증번호 입니다.");
		mailVO.setContent("yolocoaster 인증번호 : " + findInfoService.getjoinCertify(memVO).get(0));
		boolean res = findInfoService.sendMail(mailVO);
		if(res){
			return "yes";				
		}else{
			return "no";
		}
	}else{
		return "no";
	}
}
```
***
### 국내관광API - 구현사진
![api_](https://user-images.githubusercontent.com/29705928/43037190-a9fdcc42-8d45-11e8-8417-d6cda7a07d46.PNG)

### 국내관광API - 소스코드
```
// 공공데이터포털에서 받은 인증키
private static final String ServiceKey = "******************";
private String numOfRows = "10";

private final Gson gson = new Gson();

/**
 * Method : detailPage
 * 최초작성일 : 2018. 6. 26.
 * 작성자 : JiHee
 * 변경이력 :
 * @param contentid 콘텐츠ID
 * @param contenttypeid 관광타입ID
 * @return
 * Method 설명 : 상세 정보 전부 조회
 */
@Override
public Map<String, Object> detailPage(String contentId) {
	Map<String, Object> resultMap = new HashMap<String, Object>();

	BasicinfoVO result = basicInfoDao.getBasicInfo(contentId);
	resultMap.put("basicinfoVO", result);

	if (result == null) {
		BasicinfoVO basicinfoVO = new BasicinfoVO();

		// URL 만듬
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/"); /*URL*/

		/*요청할 데이터*/
		try {
			urlBuilder.append(URLEncoder.encode("detailCommon", "UTF-8"));

			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + ServiceKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("SERVICE_KEY", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과수*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰), AND(안드로이드), WIN(원도우폰), ETC*/
			urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(contentId, "UTF-8")); /*콘텐츠ID*/
			urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*기본정보 조회*/
			urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*대표이미지 조회*/
			urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드 조회*/
			urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스분류코드 조회*/
			urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*주소 조회*/
			urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*좌표 조회*/
			urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*개요 조회*/
			urlBuilder.append("&" + "_type=json"); /*반환타입 json*/

			URL url = new URL(urlBuilder.toString());

			// URL을 이용한 연결
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			BufferedReader readResult;

			// url 연결의 응답 결과가 200 ~ 300 이내이면 통과
			// 그 이외인 경우 에러코드 출력 (예 : 404 에러)
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				readResult = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				readResult = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder resultJson = new StringBuilder();
			String line;
			while ((line = readResult.readLine()) != null) {
				resultJson.append(line);
			}
			readResult.close();
			conn.disconnect();

			//============================================================================
			//==결과(String)를 Json으로 저장===============================
			//============================================================================
			String json = resultJson.toString();
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(json);
			JsonElement response = element.getAsJsonObject().get("response");

			JsonElement response_header = response.getAsJsonObject().get("header");
			JsonElement response_header_resultCode = response_header.getAsJsonObject().get("resultCode");
			JsonElement response_header_resultMsg = response_header.getAsJsonObject().get("resultMsg");

			// 결과 코드가 정상(0000) 이 아닌 경우 반환 없음
			if (!response_header_resultCode.getAsString().equals("0000")) {
				System.out.println("결과값이 정상이 아닙니다");
				System.out.println("response_header_resultMsg : " + response_header_resultMsg);
				return null;
			}

			JsonElement response_body = response.getAsJsonObject().get("body");
			JsonElement response_body_items = response_body.getAsJsonObject().get("items");
			JsonElement response_body_items_item = response_body_items.getAsJsonObject().get("item");

			basicinfoVO = gson.fromJson(response_body_items_item, BasicinfoVO.class);

			basicInfoDao.insertBasicInfo(basicinfoVO);
			resultMap.put("basicinfoVO", basicinfoVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	return resultMap;
}
```
***
### 네이버 지도 API - 구현사진
![default](https://user-images.githubusercontent.com/29705928/43037205-18294a84-8d46-11e8-9635-db511b8a04f5.PNG)

### 네이버 지도 API - 소스코드
```
/* 네이버 지도 */
var mapx = $('#mapx').val();
var mapy = $('#mapy').val();
var mlevel = $('#mlevel').val();

if(mapx=="없음" || mapy=="없음"){
	var noDiv = "<div class=\"jumbotron hidden\" >";
	noDiv += "<div id=\"map\" class=\"container text-center\"></div>";
	noDiv += "</div>"
	$('#mapDiv').html(noDiv);
}else{
	var noDiv = "<div id=\"map\" class=\"container text-center\"></div>";
	$('#mapDiv').html(noDiv);
}

// 지도 생성
var map = new N.Map('map', {
	center: new N.LatLng(mapy, mapx),
	zoom: 10
});

// 마커 생성
var marker = new N.Marker({
	position: new N.LatLng(mapy, mapx),
	map: map
});
```
***
### 페이지네이션 - 소스코드
```
<!--페이지 네이션 jsp -->
<div class="row">
<form id="pageForm" action="" method="post">
<input type="hidden" id="pageNo" name="pageNo" value="">
<ul class="pagination">
	<li class="page-item"><a  type="${page.firstPageNo}" class="page-link">처음</a></li>
	<li class="page-item"><a type="${page.prevPageNo}" class="page-link">이전</a></li>
	<c:forEach var="i" begin="${page.startPageNo}" end="${page.endPageNo}" step="1">
		<c:choose>
			<c:when test="${i eq page.pageNo}">
				<li class="page-item active"><a class="page-link" type="${i}" class="selected">${i}</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" type="${i}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<li class="page-item"><a type="${page.nextPageNo}" class="page-link">다음</a></li>
	<li class="page-item"><a type="${page.finalPageNo}" class="page-link">마지막</a></li>
</ul>
</form>
</div>
```
```
<!-- 관리자용 페이지네이션 쿼리-->
<select id="adminSelectListboard" parameterType="PageVO" resultType="BoardVO">
<![CDATA[
	SELECT X.*
	FROM
			 (SELECT ROWNUM rnum, A.* FROM
			(SELECT * FROM board
				where pboard_seq = #{pboard_seq}
			ORDER BY board_seq DESC) A
				WHERE ROWNUM <= #{pageNo}*10) X
	WHERE
		X.rnum >= (#{pageNo}-1)*10 + 1
]]>
</select>
```
```
/* 페이지네이션 컨트롤러 */
public String travelMainForm(PageVO page, Model model,HttpSession session){

	if(page!=null){
		page.setPageNo(page.getPageNo()); // 현재 페이지 번호
	}

	//페이지 블록 사이즈
	page.setBlockSize(10);
	//전체 게시물 수 (게시판번호)
	page.setTotalCount(boardService.selectBoardCnt(1));
	//게시판선택(게시판번호): 페이지객체에 입력
	page.setPboard_seq(1);
	session.setAttribute("pboardSeq", 1);
	//페이징객체 만들기
	page.makePaging();
	//해당 페이지의 리스트 가져오기
	List<BoardVO> boardList = boardService.getboardList(page);
	//모델에 담기
	model.addAttribute("page", page);
	model.addAttribute("boardList", boardList);
	return "travelMain";
}
```
***
### 세부일정작성 - 구현사진
![multirow](https://user-images.githubusercontent.com/29705928/43037283-1d59c442-8d47-11e8-9152-4672a6177577.PNG)

### 세부일정작성 - 소스코드
```
// jsp
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
```
```
/* 컨트롤러 */
@RequestMapping("insertScheReg")
	public String insertScheReg(
			HttpSession session,
			Model model,
			HttpServletRequest request,
			@ModelAttribute ContentForm list,
			MultipartHttpServletRequest multipartRequest)
			throws IllegalStateException, IOException {
		List<Content_detailVO> paramContentList = list.getList();

		scheService.insertContent(paramContentList, multipartRequest,session);
}
```
```
/* VO */
import java.util.List;

public class Content_detailVO {

	private int content_seq;
	private int detail_seq;
	private String content_title;
	private int content_order;
	private String content_shape;
	private String content_content;

	public Content_detailVO() {
		super();
	}

	public Content_detailVO(int content_seq, int detail_seq,
			String content_title, int content_order, String content_shape,
			String content_content) {
		super();
		this.content_seq = content_seq;
		this.detail_seq = detail_seq;
		this.content_title = content_title;
		this.content_order = content_order;
		this.content_shape = content_shape;
		this.content_content = content_content;
	}

	public int getContent_seq() {
		return content_seq;
	}

	public void setContent_seq(int content_seq) {
		this.content_seq = content_seq;
	}

	...

	@Override
	public String toString() {
		return "Content_detailVO [content_seq=" + content_seq + ", detail_seq="
				+ detail_seq + ", content_title=" + content_title
				+ ", content_order=" + content_order + ", content_shape="
				+ content_shape + ", content_content=" + content_content + "]";
	}
}
```
***
### google vision API를 통한 이미지 필터링 - 구현사진
![googlevision](https://user-images.githubusercontent.com/29705928/43037351-970c66d2-8d47-11e8-98a5-738c211c1482.PNG)

### google vision API를 통한 이미지 필터링 - 소스코드
```
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.Likelihood;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Service;

@Service("imageFilterService")
public class ImageFilterService implements ImageFilterServiceInf {

	public String imageFiltering(String imgPath) throws IOException {		

		String result ="GOOD";

		// Instantiates a client
	    try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {	    	

	    	  // The path to the image file to annotate
	  	      String fileName = imgPath;

              //"C:/Users/PC15/Pictures/help.jpg"
	  	      // Reads the image file into memory
	  	      Path path = Paths.get(fileName);
	  	      byte[] data = Files.readAllBytes(path);
	  	      ByteString imgBytes = ByteString.copyFrom(data);

	  	      // Builds the image annotation request
	  	      List<AnnotateImageRequest> requests = new ArrayList<>();
	  	      Image img = Image.newBuilder().setContent(imgBytes).build();
	  	      Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
	  	      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
	  	          .addFeatures(feat)
	  	          .setImage(img)
	  	          .build();
	  	      requests.add(request);

	  	      // Performs label detection on the image file
	  	      BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
	  	      List<AnnotateImageResponse> responses = response.getResponsesList();

	  	    for (AnnotateImageResponse res : responses) {
		        if (res.hasError()) {
		          System.out.println("error");
		          System.out.printf("Error: %s\n", res.getError().getMessage());
		          return null; //null
		        }

		        //feat의 타입에 맞게 Annotation을 설정해야한다.
		        //https://cloud.google.com/vision/docs/detecting-safe-search?hl=ko
		        SafeSearchAnnotation annotation =res.getSafeSearchAnnotation();

		        if(annotation.getAdult().name().equals("POSSIBLE")
                   || annotation.getAdult().name().equals("LIKELY")
                   || annotation.getAdult().name().equals("VERY LIKELY")
        		   || annotation.getMedical().name().equals("LIKELY")
		           || annotation.getMedical().name().equals("VERY LIKELY")
		           || annotation.getSpoof().name().equals("LIKELY")
        		   || annotation.getSpoof().name().equals("VERY LIKELY")        		   
        		   || annotation.getViolence().name().equals("LIKELY")
        		   || annotation.getViolence().name().equals("VERY LIKELY")
        		   || annotation.getRacy().name().equals("LIKELY")
        		   || annotation.getRacy().name().equals("VERY LIKELY")
        		   ){
		        	result= "BAD";
		        }
		      }	    		
	    	}

      return result;
	}
}
```
***
### 투표 기능 - 구현사진
![votemain](https://user-images.githubusercontent.com/29705928/43037443-f945868a-8d47-11e8-9ed9-2ed243b07d63.PNG)
![default](https://user-images.githubusercontent.com/29705928/43037447-fb4c3bea-8d47-11e8-9dd4-2b5d261ddf39.PNG)
![votedetail](https://user-images.githubusercontent.com/29705928/43037448-fcc97bae-8d47-11e8-9496-24bab47d2e4f.PNG)


### 투표 기능 - 소스코드
```
//투표생성 버튼
$('#CreateVote').on('click', function(event){
	event.preventDefault();

	//채팅방 번호
	var chat_seq = $('#chat_seq_hidden').val();

	//투표제목
	var vote_title = $('#vote_title').val();
	if(vote_title.trim() == "" || vote_title.length == 0){
		alert("투표제목을 입력해주세요");
		return;
	}

	//익명여부
	var vote_blind = "";
	if($('#vote_blind').prop('checked')){
		vote_blind = "Y";
	}else{
		vote_blind = "N";
	}

	//마감시간
	var vote_end ="";
	//마감시간 설정안 했을 경우
	if($('#vote_end').val().trim()==""|| $('#vote_end').val().length==0){

		var current = new Date();
		var currentYear = current.getFullYear().toString();
		var currentMonth = (current.getMonth()+1).toString();
		var currentDate = current.getDate().toString();
		var currentHours = current.getHours().toString();
		var carrentMinutes = current.getMinutes().toString();

		var future = new Date(currentYear, currentMonth, currentDate);
		var futuretYear = future.getFullYear();
		var futureMonth = future.getMonth().toString;

		future.setDate(future.getDate()+7);

		var futureDate = future.getDate().toString();

		//월 추가
		if(currentDate.length > futureDate.length){
			futureMonth = future.setMonth(future.getMonth()+1);

			//년도 추가
			if(currentMonth.length > futureMonth.length ){
				future.setFullYear(future.getFullYear()+1);
			}
		}		
		//시간 담기
		var yyyy = future.getFullYear().toString();
		var mm = "0"+future.getMonth().toString();
		mm = mm.slice(-2);
		var dd = "0"+future.getDate().toString();
		dd = dd.slice(-2);
		var hh = "00"+currentHours;
		hh = hh.slice(-2);
		var MM = "00"+carrentMinutes;
		MM = MM.slice(-2);			

		var user_endTime = yyyy+"."+mm+"."+dd+" "+hh+":"+MM;

		vote_end =  user_endTime;
	}
	//마감시간 설정한 경우 마감 시간 비교  
	else{
		//현재 시간
		var current = new Date();

		//사용자가 지정한 시간
		var user_setTime = $('#vote_end').val();

		var yyyy = user_setTime.substring(0, 4)		
		var mm = user_setTime.substring(5,7).toString();
		var dd = user_setTime.substring(8,10).toString()
		var hh = user_setTime.substring(11, 13).toString()
		var MM = user_setTime.substring(14,17).toString()

		//사용자가 지정한 시간 >> Date()
		var end = new Date(yyyy,mm,dd,hh,MM);

		//현재시간과 사용자가 지정한 시간 비교
		if(current > end){
			alert("마감시간은 현재시간 이후로 설정 해주세요");
		}else{
			//Date() >> 문자열
			var user_endTime = yyyy+"."+mm+"."+dd+" "+hh+":"+MM;

			vote_end = user_endTime;
		}			
	}

	//항목리스트
	var optionCnt = $("input[name='option_content']").length;
  	var option_contentList = new Array(optionCnt);    	
  	for(var i=0; i<optionCnt; i++){                          
  		option_contentList[i] = $("input[name='option_content']")[i].value;
  	}

  	if(option_contentList[0].trim()=="" || option_contentList[1].trim()==""){
  		alert("항목은 2개 이상 입력해주세요");
  		return;
  	}

	//ajax 처리
	$.ajax({
		method : "post",
		url : "${pageContext.request.contextPath}/chatVote/voteCreating",
		data : JSON.stringify({
							   chat_seq:chat_seq,
							   vote_title:vote_title,
							   vote_blind:vote_blind,
							   vote_end:vote_end,
							   option_contentList:option_contentList
							   }),
		contentType : "application/json; charset=UTF-8",
		dataType : "",
		success : function(data) {
			console.log(data);
			//성공
			data.insertCnt > 0

				$("#chatContent").html("");
				/* $("#chatContent").html(data); */


				$.ajax({
					method : "post",
					url : "${pageContext.request.contextPath}/chatVote/main",
					data : JSON.stringify({}),
					contentType : "application/json; charset=UTF-8",
					dataType : "html",
					success : function(data) {
						$("#chatContent").html("");
						$("#chatContent").html(data);
					},
					error : function(xhr) {
						console.log("실패");
						console.log(xhr);
					}

				})

				/* $(location).attr('href',"${pageContext.request.contextPath}/chatVote/main"); */

			//실패

		},
		error : function(xhr) {
			console.log("실패");
			console.log(xhr);
		}				
	})
});
```
