<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for Dashboard details of SyntBotsITOps Application
 ********************************************************************/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DashBoard</title>

<script type="text/javascript">
/**
 *This is method is called during jsp is loaded
 */	
// DO NOT REMOVE : GLOBAL FUNCTIONS!
$(document).ready(function() {
	
	$('.carousel.slide').carousel({
		interval : 3000,
		cycle : true
	});
})

		</script>
</head>
<body>

			<div id="content">
			
			
			<!-- start row -->
					<div class="row">
				
						<div class="col-sm-12">
				
							<div class="row">
				
								<div class="col-sm-12 col-md-12 col-lg-6">
				
									<!-- well -->
									<div class="well">
									
										<div id="myCarousel-2" class="carousel slide">
											<ol class="carousel-indicators">
												<li data-target="#myCarousel-2" data-slide-to="0" class="active"></li>
												<li data-target="#myCarousel-2" data-slide-to="1" class=""></li>
												<li data-target="#myCarousel-2" data-slide-to="2" class=""></li>
											</ol>
											<div class="carousel-inner">
												<!-- Slide 1 -->
													<div class="item active">
													<img src="<%=request.getContextPath()%>/images/ApplicationAutomation.jpg" alt="">
													<div class="carousel-caption">
													<!-- <h4>Application Automation</h4> -->
														<br>
													</div>
												</div>
												
												<!-- Slide 2 -->
											<div class="item">
													<img src="<%=request.getContextPath()%>/images/InfrastructureAutomation.jpg" alt="">
													<div class="carousel-caption caption-left">
														<!-- <h4>Infrastructure Automation</h4> -->
														<p>
														</p>
														<br>
													</div>
												</div>
												
												
												<!-- Slide 3 -->
												
												<div class="item">
													<img src="<%=request.getContextPath()%>/images/ServiceModeling.jpg" alt="">
													<div class="carousel-caption caption-right">
														<!-- <h4>Service Modeling</h4> -->
														<p>
															
														</p>
														<br>

													</div>
												</div>
												
											</div>
											<a class="left carousel-control" href="#myCarousel-2" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span> </a>
											<a class="right carousel-control" href="#myCarousel-2" data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span> </a>
										</div>
				
									</div>
									<!-- end well-->
				
								</div>
								
					<div class="col-sm-6">
					
						<div class="well padding-10">
	
							<div class="row">
							    <div class="col-md-6">
								  <img src="<%=request.getContextPath()%>/images/supreme.png" class="img-responsive" alt="img"/>
							    </div>
	
								<div class="col-md-6 padding-left-0">
									<h3 class="margin-top-0">
									   <a href="javascript:void(0);">SyntBots for IT Operations</a>
									</h3>
									<ul>
									<li>App,Infra,Cloud</li>
									<li>Self Service</li>
									<li>Operations Management</li>
									<ul>
									<br>
									
								</div>
								
							</div>
						</div>
					</div>
					
					<!-- 
					<div class="col-sm-6">
					
						<div class="well padding-16">
	
							<div class="row">
							    <div class="col-md-3">
								<img src="<%=request.getContextPath()%>/images/Fusion-BW.jpg" class="img-responsive" alt="img"/>
							    </div>
	
								<div class="col-md-6 padding-left-0">
									<h3 class="margin-top-0">
									     <a href="javascript:void(0);">SyntBots for DevOps</a>
									</h3>
									<ul>
									<li>Test Design Automation</li>
									<li>Continuous Delivery</li>
									<li>Compilance</li>
									<ul>
									<br>
								</div>
								
							</div>
					
						</div>

					</div> -->
								
								</div>
				
						</div>
				
					</div>
					<!-- end row -->
				
		</div>
		
</body>
</html>