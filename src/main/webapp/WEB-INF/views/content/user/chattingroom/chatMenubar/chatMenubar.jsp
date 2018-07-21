<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
/* ajax를 이용한 페이지 변경 */
$(function(){
	$('.chatMenubar').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.ajax({
			method : "post",
			url : href,
			data : JSON.stringify({}),
			contentType : "application/json; charset=UTF-8",
			dataType : "html",
			success : function(data) {
				cal.disconnect();
				$("#chatContent").html("");
				$("#chatContent").html(data);
			},
			error : function(xhr) {
				console.log("실패");
				console.log(xhr);
			}
		})
	});
	
	
	/* 친구 초대시 */
	$('#chatContent').on('click', '.friendInvite',function(){
		var friend_id = $(this).parent().parent().find('.friendTitle').text().trim();
		var href = '${pageContext.request.contextPath}/chatGroup/inviteChat';
		
		$.ajax({
			method: "post",
			url: href,
			data: JSON.stringify({mem_id : friend_id}),
			contentType: "application/json; charset=UTF-8",
			dataType : "html",
			success: function(data) {
				$("#chatContent").html("");
				$("#chatContent").html(data);
			},
			error : function(xhr) {
				console.log("실패");
				console.log(xhr);
			}
		})
	})
	

	/* 사집첩에서 페이징 처리 */
	$('#chatContent').on('click', '.page-link', function(){
		var pageNum = $(this).attr("type");
		var href = '${pageContext.request.contextPath }/chatAlbum/main';
		$.ajax({
			method : "post",
			url : href,
			data : JSON.stringify({pageNum : pageNum}),
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
	});
	
	//*********************************************************************vote****************************************************************	
	/* voteMain 페이지: vote 리스트 클릭시 main>> detail 페이지 이동*/		
	$('#chatContent').on('click', '#voteTitleList tr', function(){
		//vote_seq 가져오기
		var vote_seq = $(this).attr('class');
	
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatVote/main/detail",
			data : JSON.stringify({
				vote_seq:vote_seq
				
			}),
			contentType : "application/json; charset=UTF-8",
			dataType : "html",
			success : function(data) { 
				$("#chatContent").html("");
				$("#chatContent").html(data);		
				 
			},
			error : function(xhr) {
				console.log("AJAXDATA 실패");
				console.log(xhr);
			}				
		});				
	});
	/* end vote 리스트 클릭시 main>> detail 페이지 이동*/
	
	/* voteDetail 페이지: 취소버튼  voteDetail >> voteMain */
	$('#chatContent').on('click', '#voteDetailBack', function(){		
   			$.ajax({
   				method : "post",
   				url : "${pageContext.request.contextPath }/chatVote/main",
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
   		});
	/* end 취소버튼  voteDetail >> voteMain */
	
	/* voteMemberList 페이지: 취소버튼  voteMemberList >> voteDetail*/
	$('#chatContent').on('click', '#voteMemberBack', function(){		
			var vote_seq = $('#vote_seq').val();			
			
   			$.ajax({
   				method : "post",
   				url : "${pageContext.request.contextPath }/chatVote/main/detail",
   				data : JSON.stringify({
   					vote_seq:vote_seq
   				}),
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
   		});
	/* end 취소버튼  voteDetail >> voteMain */
	
	/* 투표하기 update 하기 controller 요청 >> ajax*/
	$('#chatContent').on('click', '#votting', function(){
		//vote_seq 가져오기
		var vote_seq = $('.vote_seq').val();		
		var option_seq = $('.glyphicon-ok').find('input').val();
	 	var voter_st = $('#vote_st').val();
		var userOption_seq = $('#userOption_seq' ).val();
		
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatVote/detail/votting",
			data : JSON.stringify({
				vote_seq:vote_seq,
				option_seq:option_seq,
				voter_st:voter_st,	
				userOption_seq:userOption_seq
			}),
			contentType : "application/json; charset=UTF-8",
			dataType : "html",
			success : function(data) { 				
				$("#chatContent").html("");
				$("#chatContent").html(data);		
				 
			},
			error : function(xhr) {
				console.log("AJAXDATA 실패");
				console.log(xhr);
			}				
		});	
	
	})
	/* end 투표하기 update 하기 controller 요청 >> ajax*/
	
	
	//투표를 한경우 option을 클릭했을때 MemberList ajax 요청
	$('#chatContent').on('click','.voteItem',function(){		
		var voter_st = $('#vote_st').val();
		//this. option_seq 가져오기
		var option_seq = $(this).find('.option_seq').val();
		
		//vostr_st가 Y인 경우 ajax 요청
		if(voter_st=="Y" ){
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/chatVote/detail/memberList",
				data : JSON.stringify({
					option_seq:option_seq
				}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 				
					$("#chatContent").html("");
					$("#chatContent").html(data);					 
				},
				error : function(xhr) {
					console.log("AJAXDATA 실패");
					console.log(xhr);
				}				
			});	
		}
	})
	/* end 투표한 경우, item을 클릭한 경우 VoteMemberList 페이지로 이동*/
	
	
	/* 투표 마감하기 >> Controller */
	$('#chatContent').on('click','#voteEnd',function(){
		var vote_seq = $('.vote_seq').val();	
		$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatVote/detail/endVote", 
				data : JSON.stringify({
					vote_seq:vote_seq					
				}),
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
		
	})	
	/* end 투표 마감하기 >> Controller */
	
	/* 투표삭제하기 >> Controller */
	$('#chatContent').on('click','#deleteVote',function(){
		var vote_seq = $('.vote_seq').val();
		
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatVote/detail/delete", 
			data : JSON.stringify({										
				vote_seq:vote_seq					
			}),
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
		
	})	
	/* end 투표삭제하기 >> Controller */
	//*********************************************************************vote*************************************************************
	
	//*********************************************************************Book*************************************************************
	//bookMain 에서 bookCreate로 페이지 이동
	$('#chatContent').on('click','#bookCreate',function(){		
		
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatBook/main/create", 
			data : JSON.stringify({
					
			}),
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
	});
	// end bookMain 에서 bookCreate 페이지로 이동
	
	
	
	//bookMain에서 bookDetail페이지로 이동
	$('#chatContent').on('click','.chatBookTr',function(){
		var book_seq = $(this).find('.book_seq').val();		
		
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/chatBook/main/detail",
				data : JSON.stringify({
					book_seq:book_seq
				}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 				
					$("#chatContent").html("");
					$("#chatContent").html(data);					 
				},
				error : function(xhr) {
					console.log("AJAXDATA 실패");
					console.log(xhr);
				}				
			});
		
	})
	//end bookMain에서 bookDetail페이지로 이동
	
	/* 가계부 상세내역 뒤로 버튼 페이지 이동*/
		$('#chatContent').on('click','#bookDetailBack',function(){		
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatBook/main", 
				data : JSON.stringify({	}),
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

			
		});		
		/*  end 가계부 상세내역 확인 버튼 페이지 이동*/
		
		/* 가계부 상세내역 수정 버튼 페이지 이동*/
		$('#chatContent').on('click','#bookUpdate',function(){
			var book_seq = $('#book_seq').val();			
			//bookCreate insert 가계부 추가 요청		
			var book_inout=$('#book_inout').find(':selected').val();
			var book_day= $('#book_day').val();
			var book_detail= $('#book_detail').val();
			var book_cate = $('#book_cate').val();
			var book_money = $('#book_money').val();
			var book_method = $('#book_method').val();
			var book_memo = $('#book_memo').val();
				
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatBook/detail/update", 
				data : JSON.stringify({
					book_seq:book_seq,
					book_inout:book_inout,
					book_day:book_day,
					book_detail:book_detail,
					book_cate:book_cate,
					book_money:book_money,
					book_method:book_method,
					book_memo:book_memo			
				}),
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
			  
		});		
		/*  end 가계부 상세내역 수정 버튼 페이지 이동*/
		
		/* 가계부 상세내역 삭제 버튼 페이지 이동*/		
		$('#chatContent').on('click','#bookDelete',function(){
			var book_seq = $('#book_seq').val();
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatBook/detail/delete", 
				data : JSON.stringify({										
					book_seq:book_seq					
				}),
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
		});
		/* end 가계부 삭제 버튼 페이지 이동**/
	
	
	
	
	//*********************************************************************Book*************************************************************
	//*********************************************************************account**********************************************************
	/*더치페이  리스트 클릭시 투표 정보화면으로 페이지 이동*/
		$('#chatContent').on('click','.chatAccountTr',function(){
			/* document.location = "${pageContext.request.contextPath }/chatAccount/selectAcc?" */
			var account_seq = $(this).find('.account_seq').val();
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath}/chatAccount/main/detail",
				data : JSON.stringify({
					account_seq:account_seq
				}),
				contentType : "application/json; charset=UTF-8",
				dataType : "html",
				success : function(data) { 				
					$("#chatContent").html("");
					$("#chatContent").html(data);					 
				},
				error : function(xhr) {
					console.log("AJAXDATA 실패");
					console.log(xhr);
				}				
			});

		});		
	/* end 더치페이  리스트 클릭시 투표 정보화면으로 페이지 이동*/
	
	/* account insert에서 취소하기  */
	$('#chatContent').on('click','#accountDetailBack',function(){
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatAccount/main", 
			data : JSON.stringify({	}),
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
	})
	/* account insert에서 취소하기  */
	
	/* book insert에서 취소하기  */
	$('#chatContent').on('click','#bookCancel',function(){
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatBook/main", 
			data : JSON.stringify({	}),
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
	})
	/* book insert에서 취소하기  */
	
	
	
	/* 더치페이 상세내역 뒤로 버튼 페이지 이동*/
	$('#chatContent').on('click','#accountDetailBack',function(){		
		
		$.ajax({
			method : "post",
			url : "${pageContext.request.contextPath }/chatAccount/main", 
			data : JSON.stringify({	}),
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
	});		
	/*  end 더치페이 상세내역 확인 버튼 페이지 이동*/
	
	/* 가계부 상세내역 삭제 버튼 페이지 이동*/		
		$('#chatContent').on('click','#accountDelete',function(){
			var account_seq = $('#account_seq').val();
			
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/chatAccount/detail/delete", 
				data : JSON.stringify({										
					account_seq:account_seq					
				}),
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
		});
	/* end 가계부 삭제 버튼 페이지 이동**/
	
	
	/* 가계부 상세내역 수정 버튼 페이지 이동*/
		$('#chatContent').on('click','#accountUpdate',function(){
			//bookCreate insert 가계부 추가 요청
			var account_seq = $('#account_seq').val();			
			var account_memo = $('#account_memo').val();
			var account_detail = $('#account_detail').val();
			var account_total = $('#account_total').val();
			var account_dt = $('#account_dt').val();
			 
			var account_num = $('#account_num').val(); // String
			var account_info = $('#account_info').val();				
			
			// 더치 항목리스트 .dutchMemberList dutchMoneyList
			
			var account_cnt = $("input[name='dutchMoneyList']").length;
			//dutchMoney List에 담기
	    	var dutchMoneyList = new Array(account_cnt);		    	
	    	for(var i=0; i<account_cnt; i++){                          
	    		dutchMoneyList[i] = $("input[name='dutchMoneyList']")[i].value;
	    	}
	    	//dutchMember List에 담기
	    	var dutchMemberList = new Array(account_cnt);
	    	for(var i = 0; i<account_cnt; i++){
	    		dutchMemberList[i] =$($("label[name='dutchMemberList']")[i]).text().trim();
	    		
	    	}		    	
			
			
			$.ajax({				
				method : "post",
				url : "${pageContext.request.contextPath }/chatAccount/detail/update", 
				data : JSON.stringify({										
					account_seq:account_seq,
					account_detail:account_detail,
					account_memo:account_memo,
					account_total:account_total,
					account_dt:account_dt,
					account_num:account_num,
					account_info:account_info,
					account_cnt:account_cnt,
					dutchMoneyList:dutchMoneyList,
					dutchMemberList:dutchMemberList			
				}),
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
			
		})
	/* end 가계부 상세내역 수정 버튼 페이지 이동*/
	
	//*********************************************************************account**********************************************************
})


</script>


<!-- right menubar -->
<div class="col-sm-2 col-xs-12 list-group" style="float:right; z-index: 1000">
	<a href="${pageContext.request.contextPath }/chatSchedule/main" class="col-sm-12 col-xs-4 list-group-item chatMenubar">캘린더</a>
	<a href="${pageContext.request.contextPath }/chatVote/main" class="col-sm-12 col-xs-4 list-group-item chatMenubar">투표</a>
	<a href="${pageContext.request.contextPath }/chatBook/main" class="col-sm-12 col-xs-4 list-group-item chatMenubar">가계부</a>
	<a href="${pageContext.request.contextPath }/chatAccount/main" class="col-sm-12 col-xs-4 list-group-item chatMenubar">더치페이</a>
	<a href="${pageContext.request.contextPath }/chatAlbum/main" class="col-sm-12 col-xs-4 list-group-item chatMenubar">사진첩</a>
	<a href="${pageContext.request.contextPath }/chatGroup/main" class="col-sm-12 col-xs-4 list-group-item chatMenubar">친구초대</a>	
</div>
<!-- end right menubar -->