<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/introduce.jsp" %>
<style>
.service-item{
    margin-left: auto;
    margin-right:  auto;
    }
    
.img-team {
	width: 300px;
	height: 350px;
	border-radius: 15%;
	
}
.img-about{
	height: 155px;
}
</style>

<div id="page-top" class="index">   

    <!-- Services Section -->
    <section id="services">
        <div class="">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <img class="img-responsive service-item" src="${pageContext.request.contextPath }/image/company/YOLO COASTER_Font.png" alt="">
                    <h3 class="section-subheading text-muted"> 국내 여행자들에게 관광 정보 및 축제 정보를 제공합니다.</h3>
                    <h3 class="section-subheading text-muted"> 여행자들간의 정보 공유를 통해 보다 많은 정보로 같지만 다른 여행을 선사 합니다.</h3>                       
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                	<div class="timeline-image">                    
                    	<img class="img-circle img-responsive service-item" src="${pageContext.request.contextPath }/image/company/calendar.png" alt="">
                    </div>
                
                	
                 
                    <h4 class="service-heading">Time</h4>
                    <p class="text-muted">효율적인 시간 관리를 위한 스케줄링 서비스 </p>
                </div>
                <div class="col-md-4">
                	<div class="timeline-image text-center">                    
                    	<img class="img-circle img-responsive service-item" src="${pageContext.request.contextPath }/image/company/money-bag.png" alt="">
                    	
                    </div>
                    
                    <h4 class="service-heading">Money</h4>
                    <p class="text-muted">효과적인 경비 관리를 위한 가계부, 더치페이 서비스</p>
                </div>
                <div class="col-md-4">
                	<div class="timeline-image">                    
                    	<img class="img-circle img-responsive service-item" src="${pageContext.request.contextPath }/image/company/concert.png" alt="">
                    </div>
                    
                    <h4 class="service-heading">Fun</h4>
                    <p class="text-muted">다양한 재미를 더해줄 다양한 일정 공유 서비스</p>
                </div>
            </div>
        </div>
    </section>
  
    <!-- About Section -->
    <section id="about">
        <div class="">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">About</h2>
                    <h3 class="section-subheading text-muted">회사 연혁</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <ul class="timeline">
                        <li>
                            <div class="timeline-image">
                                <img class="img-circle img-responsive img-about" src="${pageContext.request.contextPath }/image/line_char/conference.PNG" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2018.06.15</h4>
                                    <h4 class="subheading">Yolo Coaster 구축 발표</h4>
                                </div>
                                <div class="timeline-body">
                             	    <p class="text-muted">문화관광정보 공개 포털 시스템 구축 발표</p>
                                    
                                </div>
                            </div>
                        </li>
                        <li class="timeline-inverted">
                            <div class="timeline-image">
                                <img class="img-circle img-responsive img-about" src="${pageContext.request.contextPath }/image/line_char/digarin.PNG" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2018.06.15 ~ 2018.06.22</h4>
                                    <h4 class="subheading">Yolo Coaster UI 구현</h4>
                                </div>
                                <div class="timeline-body">
                             	    <p class="text-muted">화면정의서에 따른 화면 UI구현</p>
                                    
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="timeline-image">
                                <img class="img-circle img-responsive img-about" src="${pageContext.request.contextPath }/image/line_char/developerImg1.PNG" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2018.06.22 ~ 2018.07.11</h4>
                                    <h4 class="subheading">Yolo Coaster 기능 구현</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">기 설계 산출물에 따른 기능 로직 설계</p>
                                </div>
                            </div>
                        </li>

                        <li class="timeline-inverted">
                            <div class="timeline-image">
                                <img class="img-circle img-responsive img-about" src="${pageContext.request.contextPath }/image/line_char/openSite.PNG" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2018.07.16</h4>
                                    <h4 class="subheading">Yolo Coaster 공개포털 오픈</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">최종 프로젝트 발표 및  공개포털 오픈</p>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>

    <!-- Team Section -->
    <section id="team">
        <div class="">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Our Amazing Team</h2>
                    <h3 class="section-subheading text-muted">팀원 소개</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="${pageContext.request.contextPath }/image/line_char/KimSangJun.jpg" class="img-responsive img-circle img-team" alt="">
                        <h4>김 상 준</h4>
                        <p class="text-muted">Project Leader</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="https://www.facebook.com/profile.php?id=100003325894524"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="https://www.instagram.com/devsangjun/"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="https://github.com/sangjunkimDev"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="${pageContext.request.contextPath }/image/line_char/KimGyuYoung.png" class="img-responsive img-circle img-team" alt="">
                        <h4>김 규 영</h4>
                        <p class="text-muted">Technical Architect</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="https://www.facebook.com/profile.php?id=100003971056670"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="https://www.instagram.com/gyuyoungkim"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="https://github.com/gyoung0210"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="${pageContext.request.contextPath }/image/line_char/KimYoungRim.jpg" class="img-responsive img-circle img-team" alt="">
                        <h4>김 영 림</h4>
                        <p class="text-muted">Database Architect</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="https://www.facebook.com/youngrim.kim.18"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="https://www.instagram.com/oso7coda"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="https://github.com/oso7coda"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>              
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="${pageContext.request.contextPath }/image/line_char/BaekSeonKyeong.jpg" class="img-responsive img-circle img-team" alt="">
                        <h4>백 선 경</h4>
                        <p class="text-muted">Application Architect</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="https://www.facebook.com/seonkyeong.baek.94"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="https://www.instagram.com/saek_ya"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="https://github.com/dmsgktnekfl"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="${pageContext.request.contextPath }/image/line_char/GoJeeHee.jpg" class="img-responsive img-circle img-team" alt="">
                        <h4>고 지 희</h4>
                        <p class="text-muted">Application Architect</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="#"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="https://www.instagram.com/jihee12"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="https://github.com/wlgml0873"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="${pageContext.request.contextPath }/image/line_char/JeonByungHyen.jpg" class="img-responsive img-circle img-team" alt="">
                        <h4>전 병 현</h4>
                        <p class="text-muted">UserInterface Architecture</p>
                        <ul class="list-inline social-buttons">
                            <li><a href="https://www.facebook.com/profile.php?id=100002441373462"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="https://github.com/byeonghyeonjeon"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                 
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <p class="large text-muted">최적의 팀원들로 구성되어 욜로코스터 공개포털 웹사이트를 구축 하였습니다.</p>
                </div>
            </div>
        </div>
    </section>

    
   
  
</div>
