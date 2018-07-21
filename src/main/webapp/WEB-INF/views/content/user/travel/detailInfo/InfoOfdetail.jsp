<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.noo{
		width : 150px;
		vertical-align: top;
	}

</style>

<script>
	$(function(){
		var regEx = /\\n/g;
		var printBoxArr = $('.noo').siblings();
		var len = printBoxArr.length;
		for(var i = 0; i < len; i++){
			var printBox = $($('.noo').siblings()[i]);
			var str = printBox.html();
			printBox.html(str.replace(regEx,""));
			//printBox.html(str.replace(regEx,"<br>"));
		}
	});
</script>
 

<div>
	<c:choose>
		<c:when test="${contenttypeid == '12'}">
			<div>
				<table>
					<c:if test="${tourVO.accomcount ne '없음'}">
						<tr>
							<td class="noo">수용 인원</td>		
							<td>${tourVO.accomcount}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.opendate ne '없음'}">
						<tr>
							<td class="noo">개장일</td>		
							<td>${tourVO.opendate}</td>
						</tr>
					</c:if>
					<c:if test="${!empty tourVO.parking and tourVO.parking ne '없음'}">
						<tr>
							<td class="noo">주차시설</td>		
							<td>${tourVO.parking}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.useseason ne '없음'}">
						<tr>
							<td class="noo">이용시기</td>		
							<td>${tourVO.useseason}</td>
						</tr>
					</c:if>
					<c:if test="${!empty tourVO.usetime and tourVO.usetime ne '없음'}">
						<tr>
							<td class="noo">이용시간</td>		
							<td>${tourVO.usetime}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.chkbabycarriage ne '없음'}">
						<tr>
							<td class="noo">유모차 대여 여부</td>		
							<td>${tourVO.chkbabycarriage}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.chkcreditcard ne '없음'}">
						<tr>
							<td class="noo">신용카드 가능 여부</td>		
							<td>${tourVO.chkcreditcard}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.chkpet ne '없음'}">
						<tr>
							<td class="noo">애완동물 가능 여부</td>		
							<td>${tourVO.chkpet}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.expagerange ne '없음'}">
						<tr>
							<td class="noo">체험가능 연령</td>		
							<td>${tourVO.expagerange}</td>
						</tr>
					</c:if>
					<c:if test="${!empty tourVO.expguide and tourVO.expguide ne '없음' }">
						<tr>
							<td class="noo">체험 안내</td>		
							<td>${tourVO.expguide}</td>
						</tr>
					</c:if>
					<c:if test='${tourVO.heritage1 ne "0" and tourVO.heritage1 ne "없음"}'>
						<tr>
							<td class="noo">세계  문화유산 유무</td>		
							<td>${tourVO.heritage1}</td>
						</tr>
					</c:if>
					<c:if test='${tourVO.heritage2 ne "0" and tourVO.heritage2 ne "없음"}'>
						<tr>
							<td class="noo">세계 자연유산 유무</td>		
							<td>${tourVO.heritage2}</td>
						</tr>
					</c:if>
					<c:if test='${tourVO.heritage3 ne "0" and tourVO.heritage3 ne "없음"}'>
						<tr>
							<td class="noo">세계 기록유산 유무</td>		
							<td>${tourVO.heritage3}</td>
						</tr>
					</c:if>
					<c:if test="${tourVO.infocenter ne '없음'}">
						<tr>
							<td class="noo">문의 및 안내</td>		
							<td>${tourVO.infocenter}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</c:when>
		<c:when test="${contenttypeid == '14'}">
			<div>
				<table>
					<c:if test="${!empty cultureVO.usefee and cultureVO.usefee ne '없음'}">
						<tr>
							<td class="noo">이용 요금</td>		
							<td id="jungu2">${cultureVO.usefee}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.usetimeculture ne '없음'}">
						<tr>
							<td class="noo">이용 시간</td>		
							<td id="introTime">${cultureVO.usetimeculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.restdateculture ne '없음'}">
						<tr>
							<td class="noo">쉬는 날</td>		
							<td>${cultureVO.restdateculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.accomcountculture ne '없음'}">
						<tr>
							<td class="noo">수용 인원</td>		
							<td>${cultureVO.accomcountculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.chkbabycarriageculture ne '없음'}">
						<tr>
							<td class="noo">유모차 대여 여부</td>		
							<td>${cultureVO.chkbabycarriageculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.chkcreditcardculture ne '없음'}">
						<tr>
							<td class="noo">신용카드 가능 여부</td>		
							<td>${cultureVO.chkcreditcardculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.chkpetculture ne '없음'}">
						<tr>
							<td class="noo">애완동물 가능 여부</td>		
							<td>${cultureVO.chkpetculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.discountinfo ne '없음'}">
						<tr>
							<td class="noo">할인 정보</td>		
							<td>${cultureVO.discountinfo}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.infocenterculture ne '없음'}">
						<tr>
							<td class="noo">문의 및 안내</td>		
							<td>${cultureVO.infocenterculture}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.parkingculture ne '없음'}">
						<tr>
							<td class="noo">주차 시설</td>		
							<td>${cultureVO.parkingculture}</td>
						</tr>
					</c:if>
					<c:if test="${!empty cultureVO.parkingfee and cultureVO.parkingfee ne '없음'}">
						<tr>
							<td class="noo">주차 요금</td>		
							<td>${cultureVO.parkingfee}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.scale ne '없음'}">
						<tr>
							<td class="noo">규모</td>		
							<td>${cultureVO.scale}</td>
						</tr>
					</c:if>
					<c:if test="${cultureVO.spendtime ne '없음'}">
						<tr>
							<td class="noo">관람 소요시간</td>		
							<td>${cultureVO.spendtime}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</c:when>
		<c:when test="${contenttypeid == '28'}">
			<div>
				<table>
					<c:if test="${leportsVO.accomcountleports ne '없음'}">
						<tr>
							<td class="noo">수용 인원</td>		
							<td>${leportsVO.accomcountleports}</td>
						</tr>
					</c:if>
					<c:if test="${!empty leportsVO.usefeeleports}">
						<tr>
							<td class="noo">입장료</td>		
							<td>${leportsVO.usefeeleports}</td>
						</tr>
					</c:if>
					<c:if test="${!empty leportsVO.usetimeleports}">
						<tr>
							<td class="noo">이용 시간</td>		
							<td id="leports2">${leportsVO.usetimeleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.reservation ne '없음'}">
						<tr>
							<td class="noo">예약 안내</td>		
							<td id="leports3">${leportsVO.reservation}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.restdateleports ne '없음'}">
						<tr>
							<td class="noo">쉬는 날</td>		
							<td>${leportsVO.restdateleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.chkbabycarriageleports ne '없음'}">
						<tr>
							<td class="noo">유모차 대여 여부</td>		
							<td>${leportsVO.chkbabycarriageleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.chkcreditcardleports ne '없음'}">
						<tr>
							<td class="noo">신용카드 가능 여부</td>		
							<td>${leportsVO.chkcreditcardleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.chkpetleports ne '없음'}">
						<tr>
							<td class="noo">애완동물 가능 여부</td>		
							<td>${leportsVO.chkpetleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.expagerangeleports ne '없음'}">
						<tr>
							<td class="noo">체험 가능 연령</td>		
							<td>${leportsVO.expagerangeleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.infocenterleports ne '없음'}">
						<tr>
							<td class="noo">문의 및 안내</td>		
							<td id="leports">${leportsVO.infocenterleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.openperiod ne '없음'}">
						<tr>
							<td class="noo">개장 기간</td>		
							<td>${leportsVO.openperiod}</td>
						</tr>
					</c:if>
					<c:if test="${!empty leportsVO.parkingfeeleports}">
						<tr>
							<td class="noo">주차 요금</td>		
							<td>${leportsVO.parkingfeeleports}</td>
						</tr>
					</c:if>
					<c:if test="${!empty leportsVO.parkingleports}">
						<tr>
							<td class="noo">주차 시설</td>		
							<td>${leportsVO.parkingleports}</td>
						</tr>
					</c:if>
					<c:if test="${leportsVO.scaleleports ne '없음'}">
						<tr>
							<td class="noo">규모</td>		
							<td>${leportsVO.scaleleports}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</c:when>
		<c:when test="${contenttypeid == '25'}">
			<div>
				<table>
					<c:if test="${courseVO.distance ne '없음'}">
						<tr>
							<td class="noo">코스 총거리</td>		
							<td>${courseVO.distance}</td>
						</tr>
					</c:if>
					<c:if test="${courseVO.infocentertourcourse ne '없음'}">
						<tr>
							<td class="noo">문의 및 안내</td>		
							<td>${courseVO.infocentertourcourse}</td>
						</tr>
					</c:if>
					<c:if test="${courseVO.schedule ne '없음'}">
						<tr>
							<td class="noo">코스 일정</td>		
							<td>${courseVO.schedule}</td>
						</tr>
					</c:if>
					<c:if test="${courseVO.taketime ne '없음'}">
						<tr>
							<td class="noo">코스 총 소요시간</td>		
							<td>${courseVO.taketime}</td>
						</tr>
					</c:if>
					<c:if test="${courseVO.theme ne '없음'}">
						<tr>
							<td class="noo">코스 테마</td>		
							<td>${courseVO.theme}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</c:when>
		<c:when test="${contenttypeid == '15'}">
			<div>
				<table>
					<c:if test="${!empty eventVO.playtime}">
						<tr>
							<td class="noo">공연 시간</td>		
							<td>${eventVO.playtime}</td>
						</tr>
					</c:if>
					<c:if test="${!empty eventVO.program and eventVO.program ne '없음'}">
						<tr>
							<td class="noo">행사 프로그램</td>		
							<td id="event2">${eventVO.program}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.spendtimefestival ne '없음'}">
						<tr>
							<td class="noo">관람 소요시간</td>		
							<td>${eventVO.spendtimefestival}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.sponsor1 ne '없음'}">
						<tr>
							<td class="noo">주최자 정보</td>		
							<td>${eventVO.sponsor1}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.sponsor1tel ne '없음'}">
						<tr>
							<td class="noo">주최자 연락처</td>		
							<td>${eventVO.sponsor1tel}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.sponsor2 ne '없음'}">
						<tr>
							<td class="noo">주관사 정보</td>		
							<td>${eventVO.sponsor2}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.sponsor2tel ne '없음'}">
						<tr>
							<td class="noo">주관사 연락처</td>		
							<td>${eventVO.sponsor2tel}</td>
						</tr>
					</c:if>
					<c:if test="${!empty eventVO.subevent }">
						<tr>
							<td class="noo">부대 행사</td>		
							<td id="event4">${eventVO.subevent}</td>
						</tr>
					</c:if>
					<c:if test="${!empty eventVO.usetimefestival}">
						<tr>
							<td class="noo">이용 요금</td>		
							<td id="event3">${eventVO.usetimefestival}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.agelimit ne '없음'}">
						<tr>
							<td class="noo">관람 가능 연령</td>		
							<td>${eventVO.agelimit}</td>
						</tr>
					</c:if>
					<c:if test="${!empty eventVO.bookingplace and eventVO.bookingplace ne '없음'}">
						<tr>
							<td class="noo">예매처</td>		
							<td>${eventVO.bookingplace}</td>
						</tr>
					</c:if>
					<c:if test="${!empty eventVO.discountinfofestival}">
						<tr>
							<td class="noo">할인 정보</td>		
							<td>${eventVO.discountinfofestival}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.eventstartdate ne '없음'}">
						<tr>
							<td class="noo">행사 시작일</td>		
							<td>${eventVO.eventstartdate}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.eventenddate ne '없음'}">
						<tr>
							<td class="noo">행사 종료일</td>		
							<td>${eventVO.eventenddate}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.eventhomepage ne '없음'}">
						<tr>
							<td class="noo">행사 홈페이지</td>		
							<td>${eventVO.eventhomepage}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.eventplace ne '없음'}">
						<tr>
							<td class="noo">행사 장소</td>		
							<td>${eventVO.eventplace}</td>
						</tr>
					</c:if>
					<c:if test="${eventVO.festivalgrade ne '없음'}">
						<tr>
							<td class="noo">축제 등급</td>		
							<td>${eventVO.festivalgrade}</td>
						</tr>
					</c:if>
					<c:if test="${!empty eventVO.placeinfo and eventVO.placeinfo ne '없음'}">
						<tr>
							<td class="noo">행사장 위치 안내</td>		
							<td id="event">${eventVO.placeinfo}</td>
						</tr>
					</c:if>
				</table>
			</div>
		</c:when>
	</c:choose>
</div>