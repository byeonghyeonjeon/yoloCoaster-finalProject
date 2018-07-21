<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
							<table id ="bookTable" class="table table-hover text-center" style="background-color: white">
								<thead>
									<tr>
										<th style="text-align:center; font-size:18px; width: 15%;">일자</th>
										<th style="text-align:center; font-size:18px; width: 15%;">구분</th>
										<th style="text-align:center; font-size:18px; width: 15%;">카테고리</th>
										<th style="text-align:center; font-size:18px; width: 35%;">내용</th>
										<th style="text-align:center; font-size:18px; width: 20%;">금액</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bookVOList }" var="bookVO">
										<tr class = "chatBookTr">
											<td>
												<input class="book_seq" type="hidden" value=${bookVO.book_seq }>
												<div style="font-size:16px;">
													${bookVO.book_dt }
												</div>
											</td>
											<td>
												<c:choose>
													<c:when test="${bookVO.book_inout eq 'IN' }" >
														수입
													</c:when>
													<c:when test="${bookVO.book_inout eq 'OUT' }" >
														지출
													</c:when>
												</c:choose>
											</td>
											<td>${bookVO.book_cate }</td>
											<td>${bookVO.book_detail }</td>
											<td><fmt:formatNumber value="${bookVO.book_money }" pattern="#,###"></fmt:formatNumber></td>
										</tr>									
									</c:forEach>
								</tbody>
							</table>