<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<table id="accountTable"class="table table-hover text-center" style="background-color: white">
								<thead>
									<tr>										
										<th style="text-align:center; font-size:18px; width: 20%;">일자</th>
										<th style="text-align:center; font-size:18px; width: 40%;">내용</th>							
										<th style="text-align:center; font-size:18px; width: 15%;">인원수</th>		
										<th style="text-align:center; font-size:18px; width: 15%;">금액</th>
										<th style="text-align:center; font-size:18px; width: 10%;">작성자</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${accountVOList}" var="accountVO">
										<tr class="chatAccountTr">
											<input class ="account_seq" type="hidden" value="${accountVO.account_seq}">									
											<td>
												<div style="font-size:16px;">
												${accountVO.account_dt }											
												</div>
											</td>					
											<td>${accountVO.account_detail}</td>
											<td>${accountVO.account_cnt}</td>
											<td><fmt:formatNumber value="${accountVO.account_total}" pattern="#,###"></fmt:formatNumber></td>
											<td>${accountVO.mem_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>