<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for Login page of SyntBotsITOps Application
 ********************************************************************/
%>
<!DOCTYPE html>
<%@page import="java.util.Map"%>
<%@ page import="com.syntel.syntbots.itops.util.SyntBotsITOpsConstants"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="com.syntel.syntbots.itops.dto.UserDetails"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%

String loginErrorCode = "";
String loginErrorMsg = "";
if(request.getParameter("login_error") != null)
{
	loginErrorCode = request.getParameter("login_error");
	System.out.println("inside request.getParameter('login_error') != null... loginErrorCode is:"+loginErrorCode+":");
}


if( (loginErrorCode.equals("1")) && (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null) && ((session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")) instanceof com.syntel.syntbots.itops.util.ApplicationSecurityException) )
{
	//System.out.println("SPRING_SECURITY_LAST_EXCEPTION is not null");
	com.syntel.syntbots.itops.util.ApplicationSecurityException appSecExcp = (com.syntel.syntbots.itops.util.ApplicationSecurityException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	if(appSecExcp != null)
	{
		loginErrorMsg = appSecExcp.getMessage();		
		
	}	
	System.out.println("loginErrorMsg is:"+loginErrorMsg);
	
}
else
{
	//System.out.println("SPRING_SECURITY_LAST_EXCEPTION is null");
}
%>

<%
	Map userDetailsMap = null;
	UserDetails userDetails = null;
	if(SecurityContextHolder.getContext() != null)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
		if((auth != null) && ( auth.getPrincipal() instanceof Map) )
		{			
			userDetailsMap = (Map) auth.getPrincipal();
			userDetails = (UserDetails) userDetailsMap.get("UserDetails");	
		//	System.out.println("login.JSP > through SecurityContextHolder, userDetails:" + userDetails);			
		}		
	}
	
	if(userDetails != null)
	{
		String strContextPath = request.getContextPath();
		//System.out.println("login.JSP > inside if(userDetails != null)...");
		response.sendRedirect(strContextPath+"/pages/itopsMain");
	}
%>



<html lang="en-us" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title> IT Ops - Login Page</title>
		<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/smartadmin/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/smartadmin/css/font-awesome.min.css" />

<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-production-plugins.min.css" />
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-production.min.css" />
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-skins.min.css" />

<!-- SmartAdmin RTL Support -->
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-rtl.min.css" />

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css"  href="css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp 
<link rel="stylesheet" type="text/css" 
	href="css/demo.min.css">
-->
<!-- FAVICONS -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/smartadmin/img/favicon/favicon.ico"
	type="image/x-icon"/>
	
<link rel="icon" href="<%=request.getContextPath()%>/smartadmin/img/favicon/favicon.ico" type="image/x-icon"/>

<!-- GOOGLE FONT -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700"/>

<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link rel="apple-touch-icon" href="<%=request.getContextPath()%>/smartadmin/img/splash/sptouch-icon-iphone.png"/>
<link rel="apple-touch-icon" sizes="76x76"
	href="<%=request.getContextPath()%>/smartadmin/img/splash/touch-icon-ipad.png"/>
<link rel="apple-touch-icon" sizes="120x120"
	href="<%=request.getContextPath()%>/smartadmin/img/splash/touch-icon-iphone-retina.png"/>
<link rel="apple-touch-icon" sizes="152x152"
	href="<%=request.getContextPath()%>/smartadmin/img/splash/touch-icon-ipad-retina.png"/>

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>

<!-- Startup image for web apps -->
<link rel="apple-touch-startup-image"
	href="<%=request.getContextPath()%>/smartadmin/img/splash/ipad-landscape.png"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)"/>
<link rel="apple-touch-startup-image"
	href="<%=request.getContextPath()%>/smartadmin/img/splash/ipad-portrait.png"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)"/>
<link rel="apple-touch-startup-image" href="<%=request.getContextPath()%>/smartadmin/img/splash/iphone.png"
	media="screen and (max-device-width: 320px)"/>
	
	
	<style>
			
			#pageFooterId {
			   margin-left: 63%;"
			}
			
			
		</style>

<!--================================================== -->

<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
<script data-pace-options='{ "restartOnRequestAfter": true }'
	src="<%=request.getContextPath()%>/smartadmin/js/plugin/pace/pace.min.js"></script>

<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
<script
	src="<%=request.getContextPath()%>/smartadmin/js/libs/jquery-2.1.1.min.js"></script>

<script
	src="<%=request.getContextPath()%>/smartadmin/js/libs/jquery-ui-1.10.3.min.js"></script>


		
<!-- IMPORTANT: APP CONFIG -->
<script src="<%=request.getContextPath()%>/smartadmin/js/app.config.js"></script>

<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>

<!-- BOOTSTRAP JS -->
<script src="<%=request.getContextPath()%>/smartadmin/js/bootstrap/bootstrap.min.js"></script>

<!-- CUSTOM NOTIFICATION -->
<script src="<%=request.getContextPath()%>/smartadmin/js/notification/SmartNotification.min.js"></script>

<!-- JARVIS WIDGETS -->
<script src="<%=request.getContextPath()%>/smartadmin/js/smartwidgets/jarvis.widget.min.js"></script>

<!-- EASY PIE CHARTS -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

<!-- SPARKLINES -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/sparkline/jquery.sparkline.min.js"></script>

<!-- JQUERY VALIDATE -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/jquery-validate/jquery.validate.min.js"></script>

<!-- JQUERY MASKED INPUT -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

<!-- JQUERY SELECT2 INPUT -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/select2/select2.min.js"></script>

<!-- JQUERY UI + Bootstrap Slider -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

<!-- browser msie issue fix -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

<!-- FastClick: For mobile devices -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/fastclick/fastclick.min.js"></script>

<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

<!-- Demo purpose only -->
<!-- 	<script src="js/demo.min.js"></script> -->

<!-- MAIN APP JS FILE -->
<script src="<%=request.getContextPath()%>/smartadmin/js/app.min.js"></script>

<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
<!-- Voice command : plugin -->
<script src="<%=request.getContextPath()%>/smartadmin/js/speech/voicecommand.min.js"></script>

<!-- SmartChat UI : plugin -->
<script src="<%=request.getContextPath()%>/smartadmin/js/smart-chat-ui/smart.chat.ui.min.js"></script>
<script src="<%=request.getContextPath()%>/smartadmin/js/smart-chat-ui/smart.chat.manager.min.js"></script>

<!-- PAGE RELATED PLUGIN(S) -->
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/dataTables.colVis.min.js"></script>
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/dataTables.tableTools.min.js"></script>
<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/dataTables.bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatable-responsive/datatables.responsive.min.js"></script>
	
<!-- MAIN APP JS FILE -->
<script src="<%=request.getContextPath()%>/javascript/app-constants.js"></script>
<script src="<%=request.getContextPath()%>/javascript/app-validations.js"></script>
<script src="<%=request.getContextPath()%>/javascript/syntbots-util.js"></script>
<script src="<%=request.getContextPath()%>/javascript/jquery.ui.tabs.js"></script>	
<script src="<%=request.getContextPath()%>/javascript/tab.js"></script>


		
		
       <script type="text/javascript">
       	function check() {
    		document.login.action="login";
     	}
      </script>
	</head>
	
	<body class="animated fadeInDown">
		<header id="header">	
          <div id="logo-group">
          <span> <img src="<%=request.getContextPath()%>/smartadmin/img/syntel-logo.png"
							width="100%" height="150%" alt="SYNTEL">
							
						</span>
				
		  </div>
		</header>

		<div id="main" role="main">
			<!-- MAIN CONTENT -->
			<div id="content" class="container">
				<div class="row">
				  <div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
					<div id="logo-group">
						<!--  <img src="<%=request.getContextPath()%>/images/Synbots_Logo_Small.png" alt="RoboGal" width="80%" height="78px"> -->
						 <img src="<%=request.getContextPath()%>/images/syntbots_original.png" alt="SYNTBOTS" height="60%" width="60%" style="margin-top: -20%;">
					</div>
				  </div>
				  
				 <div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
					<div class="well no-padding">
						<form action ="<%=request.getContextPath()%>/login" name ="login" id="login-form"  class="smart-form client-form" method="POST">
								<header>Sign In</header>
										      
								<fieldset>		
								
							 
								       							
									<section>
										<label class="label">UserName</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
										<input type="text" name="username" id ="username">
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Please enter username</b>
										</label>
									</section>

									<section>
										<label class="label">Password</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="password" id ="password" autocomplete="off">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> Enter your password</b> </label>
										
									</section>
									<!--
									<section>
										<label class="checkbox">
											<input type="checkbox" name="remember" checked="">
											<i></i>Stay signed in</label>
									</section>
									-->
									
								</fieldset>
								
								<footer>
									<button type="submit" id="submit" class="btn btn-primary" disabled>
										Sign in
									</button>
								</footer>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

        <!-- PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-8"></div>
				<div class="col-xs-12 col-sm-4">
					<span id="pageFooterId" class="txt-color-white">Syntel, Inc. © 2015</span>
				</div>
				
			</div>
		</div>
		<!-- END PAGE FOOTER -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<!-- <script src="js/plugin/pace/pace.min.js"></script>

	    Link to Google CDN's jQuery + jQueryUI; fall back to local
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script> if (!window.jQuery) { document.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');} </script>

	    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script> if (!window.jQuery.ui) { document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>

		IMPORTANT: APP CONFIG
		<script src="js/app.config.js"></script>

		BOOTSTRAP JS		
		<script src="js/bootstrap/bootstrap.min.js"></script>

		JQUERY VALIDATE
		<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		JQUERY MASKED INPUT
		<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>


		MAIN APP JS FILE
		<script src="js/app.min.js"></script> -->

		<script type="text/javascript">
		
		function fnEnblDsblSubmitBtnForLogin(){
			
			
			if($('#password').val() != "" && $('#username').val() != "") {

				$('#submit').removeAttr('disabled');

			} else {

				$('#submit').prop('disabled', true); 

			}
		}
		
		$(document).ready(function (){ 

			$('#password').keyup(function() {

				fnEnblDsblSubmitBtnForLogin();
			});
		
			$('#username').keyup(function() {
	
				fnEnblDsblSubmitBtnForLogin();
			});
			
			});


			runAllForms();

			$(function() {
				// Validation
				$("#login-form").validate({
					// Rules for form validation
					rules : {
						userName : {
							required : true
						},
						userPassword : {
							required : true,
							minlength : 3,
							maxlength : 20
						}
					},

					// Messages for form validation
					messages : {
						email : {
							required : 'Please enter your userId',
							
						},
						password : {
							required : 'Please enter your password'
						}
					},

					// Do not change code below
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					}
				});
			});
			
			var loginErrorMsg = '<%=loginErrorMsg%>';
			if(loginErrorMsg.length > 0)
			{
				alert(loginErrorMsg);
			}
		</script>

	</body>
</html>