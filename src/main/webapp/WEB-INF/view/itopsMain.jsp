<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for Main page of SyntBotsITOps Application
 ********************************************************************/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="com.syntel.syntbots.itops.util.SyntBotsITOpsConstants"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.syntel.syntbots.itops.dto.UserDetails"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="-1" />
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
		
		<title>SyntBots ITOps </title>
		<meta name="description" content="" />
		<meta name="author" content="" />
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/smartadmin/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/smartadmin/css/font-awesome.min.css" />

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-production-plugins.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-production.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-skins.min.css" />

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/smartadmin/css/smartadmin-rtl.min.css" />
		
		<!-- We recommend you use "your_style.css" to override SmartAdmin
				     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
				<link rel="stylesheet" type="text/css"  href="css/your_style.css"> -->
		
		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.min.css" />
		
		
		<!-- FAVICONS -->
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/smartadmin/img/favicon/favicon.ico" type="image/x-icon"/>
		<link rel="icon" href="<%=request.getContextPath()%>/smartadmin/img/favicon/favicon.ico" type="image/x-icon"/>
		
		<!-- GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700" />

		<!-- Specifying a Webpage Icon for Web Clip 
		 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
			<!-- <link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png">
		
		iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		Startup image for web apps
		<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)">
 -->
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
			
		<!-- custom css -->	
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/custom.css" />	
		
		<style>
			#syntBotsLogo {
				margin-top: -4%;
			}
			
			#pageFooterId {
			   margin-left: 69%;"
			}
			
			
		</style>
		
				<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<!-- <script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script> -->
		<%-- <script data-pace-options='{ "restartOnRequestAfter": true }' src="<%=request.getContextPath()%>/smartadmin/js/plugin/pace/pace.min.js"></script> --%>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
		
		<script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		var varsyntbotsitopsContextPath = '<%=request.getContextPath()%>';
		var varITOpsAjaxSaveInProgress = false;
		</script>
		
		<script src="<%=request.getContextPath()%>/smartadmin/js/libs/jquery-2.1.1.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');
			}
			if(window.history.next){
				window.history.forward();
			}
		</script>

		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/libs/jquery-ui-1.10.3.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/app.config.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> 

		<!-- BOOTSTRAP JS -->
		<!-- <script src="js/bootstrap/bootstrap.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<!-- <script src="js/notification/SmartNotification.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/smartwidgets/jarvis.widget.min.js"></script>

		<!-- EASY PIE CHARTS -->
		<!-- <script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

		<!-- SPARKLINES -->
		<!-- <script src="js/plugin/sparkline/jquery.sparkline.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/sparkline/jquery.sparkline.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<!-- <script src="js/plugin/jquery-validate/jquery.validate.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<!-- <script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

		<!-- JQUERY SELECT2 INPUT -->
		<!-- <script src="js/plugin/select2/select2.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<!-- <script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

		<!-- browser msie issue fix -->
		<!-- <script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

		<!-- FastClick: For mobile devices -->
		<!-- <script src="js/plugin/fastclick/fastclick.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/fastclick/fastclick.min.js"></script>

		<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

		<!-- Demo purpose only -->
		<script src="js/demo.min.js"></script>

		<!-- MAIN APP JS FILE -->
		<!-- <script src="js/app.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/app.min.js"></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<!-- <script src="js/speech/voicecommand.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/speech/voicecommand.min.js"></script>
		
		<!-- SmartChat UI : plugin -->
		<!-- <script src="js/smart-chat-ui/smart.chat.ui.min.js"></script>
		<script src="js/smart-chat-ui/smart.chat.manager.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/smart-chat-ui/smart.chat.ui.min.js"></script>
		<script src="<%=request.getContextPath()%>/smartadmin/js/smart-chat-ui/smart.chat.manager.min.js"></script>

		<!-- PAGE RELATED PLUGIN(S) -->
		<!-- <script src="js/plugin/datatables/jquery.dataTables.min.js"></script>
		<script src="js/plugin/datatables/dataTables.colVis.min.js"></script>
		<script src="js/plugin/datatables/dataTables.tableTools.min.js"></script>
		<script src="js/plugin/datatables/dataTables.bootstrap.min.js"></script>
		<script src="js/plugin/datatable-responsive/datatables.responsive.min.js"></script> -->
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/dataTables.colVis.min.js"></script>
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/dataTables.tableTools.min.js"></script>
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/dataTables.bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/smartadmin/js/plugin/datatable-responsive/datatables.responsive.min.js"></script>
		

		<script src="<%=request.getContextPath()%>/javascript/app-constants.js"></script>
		<script src="<%=request.getContextPath()%>/javascript/app-validations.js"></script>
		<script src="<%=request.getContextPath()%>/javascript/syntbots-util.js"></script>
		<script src="<%=request.getContextPath()%>/javascript/jquery.ui.tabs.js"></script>	
		<script src="<%=request.getContextPath()%>/javascript/tab.js"></script>
		<script src="<%=request.getContextPath()%>/javascript/jquery.oLoader.min.js"></script>

	
		<script type="text/javascript">
	
		/**
		 *This is method is called during jsp is loaded
		 */
		$(document).ready(function() {
			fnLoadITOpsMainDownPortionDiv('dashboard.jsp', 'dvpDashBoardId', 'DashBoard', '', 'DashBoard','itopsPrimeMenuDashBoardUlId','','');
			fnInitializeItOpsValidationDialog();
			
		})
		
		

		</script>

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
			var _gaq = _gaq || [];
			_gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
			_gaq.push(['_trackPageview']);
			
			(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
			})();
			
			
			
			

		</script>
		
		<script  type="text/javascript">
		/**
		 *	This function loads the down portion with the corresponding URL for the menu that is selected.
		 */
		 function fnLoadITOpsMainDownPortionDiv(pageName, selectedMenuId, selectedMenuName, additionalParam, pageBreadCrumb, menuHighlightId, varRestAtr1, varRestAtr2)
		 {
			var varItOpsPopulateNewPage = true;
			var varItOpsMainPageURL = pageName;
			varItOpsMainPageURL= varItOpsMainPageURL+'?paradummy=1'
			 if( ( typeof(additionalParam) != "undefined" ) && (additionalParam != null) && (additionalParam.length > 0) ){
				varItOpsMainPageURL = varItOpsMainPageURL+'&'+additionalParam;
			 }
			 
			 varItOpsMainPageURL = varItOpsMainPageURL+'&pseudoParam='+new Date().getTime();
			// alert('varItOpsMainPageURL is:'+varItOpsMainPageURL);
			 if(varItOpsPopulateNewPage)
			 {	 
				$('#content').empty();
				$("#content").load(varItOpsMainPageURL);
						
			}
			// alert(menuHighlightId);
			 fnLoadBreadCrumb(pageBreadCrumb);
			 fnHighlightMenuSelected(menuHighlightId);
			 
		 }
		 /**
		   *This function loads the bread crumb portion.
		   */
		 function fnLoadBreadCrumb(pageBreadCrumb){
			//alert("pageBreadCrumb:"+pageBreadCrumb);
			 document.getElementById('pageBreadCrumb').innerHTML = pageBreadCrumb;
			 
		 }
		 /**
		  *	This function is used to high light menu which is selected
		  */
		 function fnHighlightMenuSelected(menuHighlightId){
			 //alert("menuHighlightId:"+menuHighlightId);
			jQuery("#itopsPrimeMenuUlId").children(".active").removeClass("active");
			jQuery('#'+menuHighlightId+'').addClass("active");
		 }
		
		
		 

			
	  /**
	    * This function initializes Error Jquery Dialog.
	  */
	 function fnITOpsMainModelDialogError()
	 {
	 	//$("#itopsMainErrorDialogModal").dialog("destroy");
	 	$("#itopsMainErrorDialogModal").dialog({
	 		height:180,
	 		width:750,
	 		modal: true,
	 		autoOpen:false,
	 		draggable:false,
	 		resizable:false
	 	});			
	 }


	 /**
	 *	This function gets called on getting error in application to open error dialog.
	 */
	 function fnAssignErrorDetailsForITOps(errorDetails) {
	 	debugger;
		 //alert('inside itopsMain.jsp, errorDetails is:'+errorDetails);
	 		
	 	var displayErrorMessage = "";
	 	var displayErrorTrace = "";
	 	var errorDetailsLength = errorDetails.length;
	 	var displayMessageIndex = errorDetails.indexOf('<%=SyntBotsITOpsConstants.EXCEPTION_DISPLAY_MESSAGE%>');
	 	var displayTraceIndex = errorDetails.indexOf('<%=SyntBotsITOpsConstants.EXCEPTION_DISPLAY_TRACE%>');
	 	var sessTimeoutErrMsgIndex = errorDetails.indexOf('document.location.href=\"<%=request.getContextPath()%>/pages/login.jsp\"');
	 
	 	if(sessTimeoutErrMsgIndex > 0)
	 	{
	 		//jAlert("Session Expired. Please login again","Error");
	 		 window.location.reload();
	 	}
	 	else
	 	{
	 		fnITOpsMainModelDialogError();
	 		if ((displayMessageIndex >= 0) && (errorDetailsLength > (displayMessageIndex + 26))) {
	 			displayErrorMessage = errorDetails.substring(displayMessageIndex + 26, displayTraceIndex);			
	 		}
	 		
	 		if ((displayTraceIndex >= 0)&& (errorDetailsLength > (displayTraceIndex + 24))) {
	 			displayErrorTrace = errorDetails.substring(displayTraceIndex + 24);
	 		}
	 		
	 		$("#itopsMainShortErrorMessage").html("Error Occured " + displayErrorMessage);
	 		$("#itopsMainDetailErrorMessage").html(displayErrorTrace);
	 		
	 		var imgType = document.getElementById("itopsMainExpandCollapseImg").src;
	 		if (imgType.indexOf("collapse.png") > 0) {
	 			
	 			document.getElementById("itopsMainExpandCollapseImg").src = "<%=request.getContextPath()%>/images/expand.png";		
	 			$("#itopsMainErrorOuterDiv").height(20);
	 			$('#itopsMainErrorOuterDiv').hide("slow");
	 			$("#itopsMainErrorDialogModal").width(700);
	 			$("#itopsMainErrorDialogModal").height(130);		
	 		}
	 		$("#itopsMainErrorDialogModal").dialog('open');
	 	}
	 		
	 }



	 /**
	 *	This function is part of error dialog window to hide / show error description
	 */
	 function fnItOpsMainExpandCollapseErrorInfo() {

	 	var imgType = document.getElementById("itopsMainExpandCollapseImg").src;
	 	if (imgType.indexOf("arrow-down-blue.png") > 0) {
	 		document.getElementById("itopsMainExpandCollapseImg").src = "<%=request.getContextPath()%>/images/arrow-up-blue.png";
	 	
	 		$("#itopsMainErrorOuterDiv").height(250);
	 		$('#itopsMainErrorOuterDiv').show("slow");
	 		$("#itopsMainErrorDialogModal").width(700);
	 		$("#itopsMainErrorDialogModal").height(380);
	 		
	 	} else if (imgType.indexOf("arrow-up-blue.png") > 0) {
	 		document.getElementById("itopsMainExpandCollapseImg").src = "<%=request.getContextPath()%>/images/arrow-down-blue.png";
	 		
	 		$("#itopsMainErrorOuterDiv").height(20);
	 		$('#itopsMainErrorOuterDiv').hide("slow");
	 		$("#itopsMainErrorDialogModal").width(700);
	 		$("#itopsMainErrorDialogModal").height(130);
	 	}	
	 }

	 /**
	 *	This function is used to close the error dialog window on clicking 'OK' in JQuery Error dialog.
	 */
	 function fnItOpsMainErrorClose()
	 {
	 	$("#itopsMainErrorDialogModal").dialog("close");
	 }


		 

		</script>



<%
	String strUserName = "User";	
	Map userDetailsMap = null;
	UserDetails userDetails = null;
	if(SecurityContextHolder.getContext() != null)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
		if((auth != null) && ( auth.getPrincipal() instanceof Map) )
		{			
			userDetailsMap = (Map) auth.getPrincipal();
			if(userDetailsMap != null)
			{
				userDetails = (UserDetails) userDetailsMap.get("UserDetails");
				if(userDetails != null)
				{
					strUserName = userDetails.getUsrShortName();			
						
				}
			}
		}		
	}
%>

</head>
	
	<!--

	TABLE OF CONTENTS.
	
	Use search to find needed section.
	
	===================================================================
	
	|  01. #CSS Links                |  all CSS links and file paths  |
	|  02. #FAVICONS                 |  Favicon links and file paths  |
	|  03. #GOOGLE FONT              |  Google font link              |
	|  04. #APP SCREEN / ICONS       |  app icons, screen backdrops   |
	|  05. #BODY                     |  body tag                      |
	|  06. #HEADER                   |  header tag                    |
	|  07. #PROJECTS                 |  project lists                 |
	|  08. #TOGGLE LAYOUT BUTTONS    |  layout buttons and actions    |
	|  09. #MOBILE                   |  mobile view dropdown          |
	|  10. #SEARCH                   |  search field                  |
	|  11. #NAVIGATION               |  left panel & navigation       |
	|  12. #RIGHT PANEL              |  right panel userlist          |
	|  13. #MAIN PANEL               |  main panel                    |
	|  14. #MAIN CONTENT             |  content holder                |
	|  15. #PAGE FOOTER              |  page footer                   |
	|  16. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  17. #PLUGINS                  |  all scripts and plugins       |
	
	===================================================================
	
	-->
	
	<!-- #BODY -->
	<!-- Possible Classes

		* 'smart-style-{SKIN#}'
		* 'smart-rtl'         - Switch theme mode to RTL
		* 'menu-on-top'       - Switch to top navigation (no DOM change required)
		* 'no-menu'			  - Hides the menu completely
		* 'hidden-menu'       - Hides the main menu but still accessable by hovering over left edge
		* 'fixed-header'      - Fixes the header
		* 'fixed-navigation'  - Fixes the main menu
		* 'fixed-ribbon'      - Fixes breadcrumb
		* 'fixed-page-footer' - Fixes footer
		* 'container'         - boxed layout mode (non-responsive: will not work with fixed-navigation & fixed-ribbon)
	-->
	<body class="menu-on-top">

		<!-- HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img id="syntBotsLogo" src="../images/SyntBots1.png" alt="SYNTBOTS" /></span>
								<!-- END LOGO PLACEHOLDER -->
				
			</div>

			<!-- pulled right: nav area -->
			<div class="pull-right">
				
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end collapse menu -->
				
				<div class="project-context hidden-xs">
          
                <span class="label">
                </span>
                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                   <i class="fa fa-user"></i>
                   <span> Welcome ,<%=strUserName%></span>
                 </a>
           </div>
				
				<span>
                   <a style="border-radius: 2px;cursor: default !important;display: inline-block;font-weight: 700;height: 30px;line-height: 24px;min-width: 30px;
                             padding: 2px;text-align: center;text-decoration: none !important;-moz-user-select: none;background-color: #F8F8F8;
                             background-image: -moz-linear-gradient(center top , #F8F8F8, #F1F1F1);border: 1px solid #BFBFBF;color: #6D6A69;font-size: 17px;
                             margin: 10px 0px 0px;" href="<%=request.getContextPath()%>/logout" title="Sign Out" data-action="userLogout"
                             data-logout-msg="You can improve your security further after logging out by closing this opened browser">
                           <i class="fa fa-sign-out"></i>
                    </a>
             </span>
			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">

			<!-- NAVIGATION : This navigation is also responsive-->
			<nav>
				<ul id="itopsPrimeMenuUlId">
				
					<li id='itopsPrimeMenuDashBoardUlId'>
			                    <a href="javaScript:fnLoadITOpsMainDownPortionDiv('dashboard.jsp', 'dvpDashBoardId', 'DashBoard', '', 'DashBoard','itopsPrimeMenuDashBoardUlId','','')" title="DashBoard">
			                        <i class="fa fa-lg fa-fw fa-home"></i><span class="menu-item-parent">Dashboard</span>
			                    </a>
		             </li>
					<li id="itopsPrimeMenuIncidentsUlId">
						<a href="#"><i class="glyphicon glyphicon-tasks"></i> <span class="menu-item-parent">Incidents</span></a>
						<ul>
							
							<li id='itopsL1MenuOpenIncidentId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('incidentDetailsList.jsp', 'itopsIncidentListId', 'Incidents List', '', 'Incidents > Open Incidents','itopsPrimeMenuIncidentsUlId','','')" title="IncidentMain Details" >
											<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">Open Incidents</span>
									</a>
							</li>
							
							<li id='itopsL1MenuClosedIncidentId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('closedIncidentDetailsList.jsp', 'dvpClsdIncidentMainId',  'Closed Incidents','', 'Incidents > Closed Incidents','itopsPrimeMenuIncidentsUlId','','')" title="IncidentClosed Details">
										<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">Closed Incidents</span>
									</a>
							</li>
							
							
						</ul>
					</li>
					
					<li id='itopsPrimeMenuSOPExecutionUlId'>
	                    <a href="javaScript:fnLoadITOpsMainDownPortionDiv('sopExecution.jsp', 'dvpSopExecutionId', 'SOPExecution', '', 'SOP Execution','itopsPrimeMenuSOPExecutionUlId','','')" title="SOPExecution">
	                        <i class="fa fa-gears"></i><span class="menu-item-parent">SOP Execution</span>
	                    </a>
                   </li>
                   
                   
                   <li id="itopsPrimeMenuMasterPagesUlId">
						<a href="#"><i class="fa fa-sitemap"></i> <span class="menu-item-parent">Master Pages</span></a>
						
						<ul>
							
							<li id='itopsL1MenuApplicationDetailsId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('applicationDetails.jsp', 'itopsL1MenuApplicationDetailsId', 'Application Details', '', 'Master Pages > Application Details','itopsPrimeMenuMasterPagesUlId','','')" title="Application Details" >
											<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">Application Details</span>
									</a>
							</li>
							
							<li id='itopsL1MenuQueueDetailsId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('queueDetails.jsp', 'itopsL1MenuQueueDetailsId',  'Queue Details','', 'Master Pages > Queue Details','itopsPrimeMenuMasterPagesUlId','','')" title="Queue Details">
										<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">Queue Details</span>
									</a>
							</li>
							
							<li id='itopsL1MenuAppQueSopLinkId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('appQueSopLink.jsp', 'itopsL1MenuAppQueSopLinkId', 'Application Queue SOP Link Details', '', 'Master Pages > Application Queue SOP Link Details','itopsPrimeMenuMasterPagesUlId','','')" title="Application Queue SOP Link Details" >
											<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">App Que SOP Link</span>
									</a>
							</li>
							
							<li id='itopsL1MenuSopWorkflowLinkId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('sopWorkflowLink.jsp', 'itopsL1MenuSopWorkflowLinkId',  'SOP Workflow Link','', 'Master Pages > SOP Workflow Link','itopsPrimeMenuMasterPagesUlId','','')" title="SOP Workflow Link">
										<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">SOP Workflow Link</span>
									</a>
							</li>
							<li id='itopsPrimeMenuSOPExecutionUlId'>
			                    <a href="javaScript:fnLoadITOpsMainDownPortionDiv('sopMsgLink.jsp', 'itOpsSopMsgLinkId', 'SOPMessageLink', '', 'SOPMessageLink','itopsPrimeMenuSOPMessageLinkLiId','','')" title="SOPMessageLink">
			                        <i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">SOP Message Link</span>
			                    </a>
		                   </li>
							<li id='itopsL1MenuSopDetailsId'>
									<a href="javaScript:fnLoadITOpsMainDownPortionDiv('sopDetails.jsp', 'itopsL1MenuSopDetailsId', 'SOP Details', '', 'Master Pages >  SOP Details','itopsPrimeMenuMasterPagesUlId','','')" title="SOP Details" >
											<i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">SOP Details</span>
									</a>
							</li>
							<li id='itopsPrimeMenuSOPExecutionUlId'>
			                    <a href="javaScript:fnLoadITOpsMainDownPortionDiv('usrApplnQueueLink.jsp', 'itOpsAppQueSopLinkId', 'UserApplicationQueueLink', '', 'UserApplicationQueueLink','itopsPrimeMenuUserApplicationQueueLinkLiId','','')" title="UserApplicationQueueLink">
			                        <i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent">User Application Queue Link</span>
			                    </a>
		                   </li>
		                   <li id='itopsPrimeMenuSOPExecutionUlId'>
			                    <a href="javaScript:fnLoadITOpsMainDownPortionDiv('usrApplnQueSopExclsn.jsp', 'itOpsAppQueSopLinkId', 'UserApplicationQueueSOPExclusion', '', 'UserApplicationQueueSOPExclusion','itopsPrimeMenuUserApplicationQueueSOPExclusionLiId','','')" title="UserApplicationQueueSOPExclusion">
			                        <i class="fa fa-lg fa-fw fa-play-circle-o"></i><span class="menu-item-parent"> User Application Queue SOP Exclusion</span>
			                    </a>
		                   </li>
		                   <li id='itopsL1MenuUserDetailsId'>
	                   				 <a href="javaScript:fnLoadITOpsMainDownPortionDiv('userDetails.jsp', 'itopsL1MenuUserDetailsId', 'userDetails', '', 'Master Pages > User Details','itopsPrimeMenuMasterPagesUlId','','')" title="User Details">
	                       					 <i class="fa fa-play-circle-o"></i><span class="menu-item-parent">User Details</span>
	                   				 </a>
	                   		</li>
							<li id='itopsL1MenuWorkflowDetailsId'>
	                   				 <a href="javaScript:fnLoadITOpsMainDownPortionDiv('workflowDetails.jsp', 'itopsL1MenuWorkflowDetailsId', 'workflowDetails', '', 'Master Pages > Workflow Details','itopsPrimeMenuMasterPagesUlId','','')" title="Workflow Details">
	                       					 <i class="fa fa-gears"></i><span class="menu-item-parent">Workflow Details</span>
	                   				 </a>
	                   		</li>
	                   		
	                   	<!-- <i class="fa fa-stack-exchange"><i class="fa fa-paste "> -->
						</ul>
					</li>
					
                  </ul>
			</nav>
		</aside>
		<!-- END NAVIGATION -->

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					 <li id="pageBreadCrumb"></li>
				</ol>
				<!-- end breadcrumb -->
			</div>
			<!-- END RIBBON -->

			<!-- MAIN CONTENT -->
			<div id="content">

							
			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->

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
		
		
		<!-- From here is for Error Dialog -->
	
	<div id="itopsMainErrorDialogModal" height="100%" width="100%" title="Error" style="display:none;overflow: auto;font-size: 12px;">	
	
		<table width="100%" height="70px" id="devOpsMainErrorDialogModalTbl" border="0" >
			
			<tr width="100%" height="40px">
				<td width="7%" align="left" valign="middle">
					<img src="<%=request.getContextPath()%>/images/error.png" border="0" height="30px" width="30px" id="devOpsMainErrorImg"/>
				</td>
				<td width="93%" align="left" valign="middle">
					<font color="red"><b><div id="itopsMainShortErrorMessage"></div></b></font>
				</td>
			</tr>			
	
			<tr width="100%" height="30px" class="errorWithPad" valign="middle">
				<td width="7%" align="left">
		 			&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/images/arrow-down-blue.png" border="0" id="itopsMainExpandCollapseImg" onClick="javaScript:fnItOpsMainExpandCollapseErrorInfo()" />
				</td>
				<td>&nbsp;</td>
			</tr>

		</table>
				
		<div id="itopsMainErrorOuterDiv" style="display:None;overflow: auto;font-size:10px;" height="20px"  width="90%">
			<div id="devOpsMainErrorEffect" class="ui-widget-content ui-corner-all" >					
				<div id="itopsMainDetailErrorMessage" border="3"></div>					
			</div>
		</div>
		
		<div class="clearBoth"></div>
		
		<div id="devOpsMainErrorBtnControls" align="right" height="30px" valign="bottom"  width="90%">
			<input name="devOpsMainErrorBtnOk" type="button" value="OK" class="submitButton" onclick="javascript:fnItOpsMainErrorClose();" />
		</div>			
	</div>
	
	<!-- Till here is for Error Dialog -->
	
	<!-- Form Validation Dialog start -->
		<div id="itopsValidationDialog"></div> 
    <!-- Form Validation Dialog End -->

	</body>

</html>