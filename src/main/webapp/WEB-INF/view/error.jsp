<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%/********************************************************************
  Author 				: Syntel
  Version 				: 1.0
  Purpose				: This is error page used when an error occured in the case of Ajax call  
 ********************************************************************/%>
<%@ page import="com.syntel.syntbots.itops.util.SyntBotsITOpsConstants" %>
<%@ page import="com.syntel.syntbots.itops.util.Logger" %>


<%
//System.out.println("Entered inside error.jsp");
String excepDisplayMsg ="";
String displayStackTrace ="";
if(request.getAttribute(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_MESSAGE) != null)
{
	excepDisplayMsg = (String)request.getAttribute(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_MESSAGE);
}
if(request.getAttribute(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_TRACE) != null)
{
	displayStackTrace = (String)request.getAttribute(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_TRACE);
}
out.print(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_MESSAGE+":"+excepDisplayMsg);
out.print(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_TRACE+":"+displayStackTrace);
//System.out.println("just before leaving error.jsp");
%>

