<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for Incident details of SyntBotsITOps Application
 ********************************************************************/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incident Details</title>
<% 
String strIncdntDtlsId= "";
if( request.getParameter("incdntDtlsId") != null){
	strIncdntDtlsId = request.getParameter("incdntDtlsId");
	//System.out.println("strIncdntDtlsId is not null");
}

%>

<script type="text/javascript">

$('#sopList').html('');
$('#workFlowList').html('');

var varSopName = '';
var varWorkFlowName = '';

var varSopList='';
var varWorkFlowList='';
var varWorkFlowParamList='';


var varIncidentIdForWorkflowRun = '';
var varIncdntDtlsIdForWorkflowRun = '';
var varApplnNameForWorkflowRun = '';
var varQueIdForWorkflowRun = '';
var varSopIdForWorkflowRun = '';
var varWrkflwIdForWorkflowRun = '';

var varUsrApplmQueExeFlag = '';

var varParam1ForWorkflowRun = '';
var varParam2ForWorkflowRun = '';
var varParam3ForWorkflowRun = '';
var varParam4ForWorkflowRun = '';
var varParamnames;
/**
 *This method is used to intiate an ajax call to get incident details by Id
 * @param incident details Id
 * @return success function/ error function
*/		
function getIncidentDetailsById() {
		var getIncidentByIdJsonObj = {};
		getIncidentByIdJsonObj['incdntDtlsId'] = <%=strIncdntDtlsId%>;
		var strJSON = JSON.stringify(getIncidentByIdJsonObj);
		fnCommonDoAjaxForGet("<%=request.getContextPath()%>/pages/listIncidentById", strJSON,  "fnAfterGetIncidentDetailsById", "fnErrAfterGetIncidentDetailsById");
}
/**This method is called on success of fnCommonDoAjaxForGet util method with action get incident details by Id
* @param incident details
*/	
function fnAfterGetIncidentDetailsById(data)
{
		
	document.getElementById('incdntId').innerHTML = data['incdntId'];
	document.getElementById('incdntAssgnmntGrp').innerHTML = data['incdntAssgnmntGrp'];
	document.getElementById('incidentOriginalSeverity').innerHTML = data['incidentOriginalSeverity'];
	/* document.getElementById('incdntStatus').innerHTML = data['incdntStatus']; */
	document.getElementById('incdntAppName').innerHTML = data['incdntAppName'];
	document.getElementById('incdntSrtDsc').innerHTML = data['incdntSrtDsc'];
	document.getElementById('incdntDesc').innerHTML = data['incdntDesc'];
	document.getElementById('incidentOpenedDate').innerHTML = data['strIncidentOpenedDate'];
	/* document.getElementById('incdntCtgory').innerHTML = data['incdntCtgory']; */
	/* document.getElementById('incdntPriority').innerHTML = data['incdntPriority']; */
	document.getElementById('incdntState').innerHTML = data['incdntState'];
	document.getElementById('incdntAssgndTo').innerHTML = data['incdntAssgndTo'];
	/* document.getElementById('incidentStatus').innerHTML = data['incdntStatus']; */

	//alert("incdntDtlsId:"+data['incdntDtlsId']+":");
	varIncdntDtlsIdForWorkflowRun = data['incdntDtlsId'];
	varIncidentIdForWorkflowRun = data['incdntId'];
	varApplnNameForWorkflowRun = data['incdntAppName'];
	varQueIdForWorkflowRun = data['incdntAssgnmntGrp'];
	varUsrApplmQueExeFlag = data['usrApplnQueLnk'].usrAppQLinkToExecuteFlag

	var tmpsopList= data['sopList'];
	var tmpWrkflwList= data['workFlowList'];
	var tmpWrkflwParms= data['workFlowParamList'];

	if( (typeof(tmpsopList) !="undefined")  && (tmpsopList != 'undefined') && (tmpsopList != null) && (tmpsopList.length > 0)  ){
		varSopList= data['sopList'];
				//alert("varSopList:"+varSopList);
		var tempSopName = data['sopList'][0].sopName;
				if( (typeof(tempSopName) !="undefined")  && (tempSopName != 'undefined') && (tempSopName != null)  ){
					varSopIdForWorkflowRun= data['sopList'][0].sopId;
					varSopName = data['sopList'][0].sopName;
						//alert("varSopName:"+varSopName);
				}
	}



	if( (typeof(tmpWrkflwList) !="undefined")  && (tmpWrkflwList != 'undefined') && (tmpWrkflwList != null) && (tmpWrkflwList.length > 0)  ){
		varWorkFlowList= data['workFlowList'];
	//alert("varWorkFlowList:"+varWorkFlowList);

	var tempWorkFlowName = data['sopList'][0].sopName;

	if( (typeof(tempWorkFlowName) !="undefined")  && (tempWorkFlowName != 'undefined') && (tempWorkFlowName != null)  ){
		varWrkflwIdForWorkflowRun = data['workFlowList'][0].wrkflwId;
		varWorkFlowName = data['workFlowList'][0].wrkflwName;
		//alert("varWrkflwIdForWorkflowRun:"+varWrkflwIdForWorkflowRun+":varWorkFlowName:"+varWorkFlowName);
	}
	}
	if( (typeof(tmpWrkflwParms) !="undefined")  && (tmpWrkflwParms != 'undefined') && (tmpWrkflwParms != null) && (tmpWrkflwParms.length > 0)  ){
		varWorkFlowParamList=data['workFlowParamList'];
	//alert("varWorkFlowParamList:"+varWorkFlowParamList);
	}
	/* document.getElementById('incdntcreatedDate').innerHTML = fnGetDateInDDMMMYYYY(data['incdntcreatedDate']);
	document.getElementById('incdntmodifiedDate').innerHTML = fnGetDateInDDMMMYYYY(data['incdntmodifiedDate']); */
	document.getElementById('sopName').innerHTML = varSopName;
    fnPopulateSopData(varSopList);
	fnPopulateWorkFlowData(varWorkFlowList);
	fnPopulateWorkflowparams(varWorkFlowParamList);	
	//alert("before::" +varUsrApplmQueLnk+":");
	fndisableExecutebutton(varUsrApplmQueExeFlag);
}


/**This method is used to disable and enable the execute button 
*/
function fndisableExecutebutton(varUsrApplmQueExeFlag)
{
	if(varUsrApplmQueExeFlag == 1)
	{
		document.getElementById("excuteBtn").disabled = false; 
	}else if(varUsrApplmQueExeFlag == 0) {
	
		document.getElementById("excuteBtn").disabled = true; 
	}
	
	}


/**This method is called on failure of fnCommonDoAjaxForGet util method with action get cident details by Id
*/
function fnErrAfterGetIncidentDetailsById() {
		alert("Inside fnErrAfterGetIncidentDetailsById");
}
/**This method is called to set values in SOP details portion 
* @param SOP details list
*/
function fnPopulateSopData(sopList){
	
	//alert("inside ::fnPopulateSopData");
	$('#sopList').html('');
	var varSOPListOptions ='';
	for (i = 0; i < sopList.length; i++) {
		varSOPListOptions += '<option value="' +sopList[i].sopId + '">'+ sopList[i].sopName + '</option>';
	}
	$('#sopList').append(varSOPListOptions);
}
/**This method is called to set values in workflow details portion 
* @param workflow details list
*/
function fnPopulateWorkFlowData(varWorkFlowList){
	$('#workFlowList').html('');
	var varWrkflwListOptions ='';
	for (i = 0; i < varWorkFlowList.length; i++) {
		varWrkflwListOptions += '<option value="' +varWorkFlowList[i].wrkflwId + '">'+ varWorkFlowList[i].wrkflwName + '</option>';
	}
	$('#workFlowList').append(varWrkflwListOptions); 
}
/**This method is called to set values in workflow param details portion 
* @param workflow param details list
*/
function fnPopulateWorkflowparams(wrkparmlist){
	  var varParamnames = '<table class="table table-hover"><tbody>';
	for (var i = 0, len =wrkparmlist.length; i < len; ++i) {
		 var vartype='text';
		 varParamnames += '<tr>';
			if(wrkparmlist[i].paramValToBeShown =='0')
			{
			vartype ='password';
			}
			varParamnames += '<th>'+wrkparmlist[i].paramName +'</th>';
			varParamnames += '<td> <input type ='+vartype+ ' name ='+wrkparmlist[i].paramCode+' id ='+wrkparmlist[i].paramCode+'><td> <br>';

		varParamnames += "</tr>"; 
	}
	varParamnames += '</tbody></table>';
	
	$(varParamnames).appendTo('#workflowparam');
}

/**This method is called to get date in DDMMYYYY format
* @param date in string
* @return date in DDMMYYYY
*/
function fnGetDateInDDMMMYYYY(dateAsFromServerSide){
	   
    var jsDate = new Date(dateAsFromServerSide);
    var dateInDDMMMYYYYHHMMSS = jsDate.getMonth()+"/"+jsDate.getDate()+"/"+jsDate.getFullYear()+" "+jsDate.getHours()+":"+jsDate.getMinutes()+":"+jsDate.getSeconds();
    return dateInDDMMMYYYYHHMMSS;
}
/**This method is called to validate param values entered to execute incident
*/
function fnValidParamsExecuteIncident(){
	 var varExecIncidentErrMsg = '';
					
	    var varTempWorkflowParamCode = '';
		var varTempWorkflowParamName = '';
		var varTempWorkflowParamValue = '';
		for(var i=0; i<varWorkFlowParamList.length;i++)
		{		
			 varTempWorkflowParamCode = '';
		     varTempWorkflowParamName = '';
			 varTempWorkflowParamValue = '';
			varTempWorkflowParamName = varWorkFlowParamList[i].paramName;
			varTempWorkflowParamCode = varWorkFlowParamList[i].paramCode;
			varTempWorkflowParamValue = document.getElementById(varTempWorkflowParamCode).value
			incidentParamJsonObj = {};
			incidentParamJsonObj['paramCode'] = varTempWorkflowParamCode;
			incidentParamJsonObj['paramName'] = varTempWorkflowParamName;
			incidentParamJsonObj['paramValue'] = varTempWorkflowParamValue;
			//alert('paramName is:'+varTempWorkflowParamName+':paramvalue is:'+varTempWorkflowParamValue+':');
			
			if(varTempWorkflowParamValue == ''){
				varExecIncidentErrMsg += 'Please Enter Value for '+varTempWorkflowParamName+'.';
			}
		}
	
		if(varExecIncidentErrMsg.length > 0)
		{
			alert(varExecIncidentErrMsg);
		}
		else
		{
			 $('#MsgBoxBack').show();
		}
}
/**This method is called on success of fnCommonDoAjaxForSaveForRequest util method with action execute incident
*/
function fnAfterSuccesOfExecuteIncident() {
		
   	$('#itOpsWrkflwParamsPopUp').modal('hide');
		//alert("Process initiated successfully!");
   	
   	setTimeout(function(){
   		fnIncidentList();
   		},1000);
		//fnIncidentList();
		//$('#dialog_simple').dialog('open');
}
/**This method is called on failure of fnCommonDoAjaxForSaveForRequest util method with action execute incident
*/
function fnAfterErrorOfExecuteIncident() {
		alert("Process initiation unsuccessful!");
}
/**
 *This method is used to intiate an ajax call to execute incident
 * @return success function/ error function
*/
function fnExecuteIncident() {
					
		//alert("inside fnExecuteIncident()");
		//var varExecInc
		var objJSON = {};
		objJSON['incdntDtlsId'] = varIncdntDtlsIdForWorkflowRun;
		objJSON['incidentId'] = varIncidentIdForWorkflowRun;
		objJSON['applnName'] = varApplnNameForWorkflowRun;
		objJSON['queName'] = varQueIdForWorkflowRun;
		objJSON['sopId'] = varSopIdForWorkflowRun;
		objJSON['wrkflwId'] = varWrkflwIdForWorkflowRun;				
		var incidentParamJSONArray = new Array();
		var incidentParamJsonObj = {};
		var varTempWorkflowParamName = '';
		var varTempWorkflowParamValue = '';
		var varTempWorkflowParamCode = '';
		for(var i=0; i<varWorkFlowParamList.length;i++)
		{			
			//alert(varWorkFlowParamList[i].paramName);
			varTempWorkflowParamName = '';
			varTempWorkflowParamCode = '';
			varTempWorkflowParamValue = '';
			varTempWorkflowParamName = varWorkFlowParamList[i].paramName;
			varTempWorkflowParamCode = varWorkFlowParamList[i].paramCode;
			varTempWorkflowParamValue = document.getElementById(varTempWorkflowParamCode).value
			incidentParamJsonObj = {};
			incidentParamJsonObj['paramName'] = varTempWorkflowParamName;
			incidentParamJsonObj['paramCode'] = varTempWorkflowParamCode;
			incidentParamJsonObj['paramValue'] = varTempWorkflowParamValue;
			//alert('paramName is:'+varTempWorkflowParamName+':paramvalue is:'+varTempWorkflowParamValue+':paramCode is:'+varTempWorkflowParamCode+':');
			incidentParamJSONArray.push(incidentParamJsonObj);
			}
		objJSON['execIncidentParamsData'] = incidentParamJSONArray;
		//alert('objJSON is:'+objJSON);
		var stringifiedJSON = JSON.stringify(objJSON);
		//alert('stringifiedJSON is:'+stringifiedJSON);
		debugger;
			fnCommonDoAjaxForSaveForRequest("<%=request.getContextPath()%>/pages/executeIncident", 'execIncidentJSON', encodeURIComponent(stringifiedJSON), "fnAfterSuccesOfExecuteIncident", "Incident Ran Successfully", "fnAfterErrorOfExecuteIncident");	
		$('#MsgBoxBack').hide();
}
/**
 *This method is used to load incident details list page
 * @return incident details list jsp page
*/
function fnIncidentList()
{
	      fnLoadITOpsMainDownPortionDiv('incidentDetailsList.jsp', 'itopsIncidentListId', 'Incidents List', '', 'Incidents > Open Incidents','itopsPrimeMenuIncidentsUlId','','');
}
/**
 *This method is used to load workflow params form
*/
function fnItOpsGetWrkflwParamsForm() {
	    $('#itOpsWrkflwParamsPopUp').modal('show');
}

/**
 *This is method is called during jsp is loaded
 */
$(document).ready(function() {
		getIncidentDetailsById();
		
		});
/**
 *This method is used to call validation method of params for incident execution
*/
function fnLoad()
{
     // $('#itOpsWrkflwParamsPopUp').show();
   	  //$('#MsgBoxBack').show();
      fnValidParamsExecuteIncident();
}
/**
 *This method is used to cancle execution during execution conformation
*/
function fnAfterCancelExecuteIncident(){
		$("#MsgBoxBack").hide(); 
}




</script>

</head>
<body>
		
				
			
			<!-- MAIN CONTENT -->
			<div id="content">
			
				<div class="row"  id="rowId">
               
               
               		<article class="col-sm-12 col-md-12 col-lg-12">
				<!-- Widget ID (each widget will need unique ID)-->
							
							<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-2" data-widget-editbutton="false">
								
								<header>
								<!-- 	<span class="widget-icon"> <i class="fa fa-table"></i> </span> -->
									<h2>Incident Details</h2>
								</header>
								<!-- widget div-->
								<div>
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
									</div>
									<!-- end widget edit box -->
									<!-- widget content -->
									<div class="widget-body no-padding">
										<div class="table-responsive">
											<table id="table2" class="table table-hover">
                                       
                                                <tbody>
                                               
                                                   <tr>
                                                        <th>Incident ID</th>
                                                        <td id='incdntId'></td>
                                                        <th>Assignment Group</th>
                                                        <td id='incdntAssgnmntGrp'></td>
                                                    </tr>
                                                    
                                                
                                                    <tr>
                                                        <th>Original Severity</th>
                                                        <td id='incidentOriginalSeverity'></td>
                                                        <th>Incident Application Name</th>
                                                        <td id='incdntAppName'></td>
                                                    </tr>
                                               
                                                    <tr>
                                                 
                                                  
                                                        <th>Short Description</th>
                                                        <td><textarea id="incdntSrtDsc" rows="4" cols="50" disabled="disabled">
                                                        </textarea></td>
                                                         
                                                       
                                                        <th>Description</th>
                                                          <td><textarea id="incdntDesc" rows="4" cols="50" disabled="disabled">
                                                        </textarea></td>
                                                        
                                                    </tr>
                                                   
                                                    
                                                    <tr>
                                                   
                                                         <th>Open Date</th>
                                                         <td id='incidentOpenedDate'></td>
                                                          <th>Assigned To</th>
                                                        <td id='incdntAssgndTo'></td>
                                                           
                                                       
                                                    </tr>
                                               
                                                    <tr>
                                                        <th>Incident State</th>
                                                        <td id='incdntState'></td>
                                                        <th>&nbsp;</th>
                                                        <td>&nbsp;</td>
                                                        <!-- <th>SOP Name</th>
                                                        <td id='sopName'></td> -->
                                                    </tr>
                                                   
                                                   
                                               <!-- 
                                                    <tr>
                                                         <th>Modified Date</th>
                                                        <td id='incdntmodifiedDate'></td>
                                                         <th>Created Date</th>
                                                        <td id='incdntcreatedDate'></td>
                                                    </tr> -->
                                                   
                                                   
                                                  
                                                    
                                                </tbody>
                                            </table>
										</div>
										<!--  <div id='div1'> </div>  -->
									</div>
									<!-- end widget content -->

								</div>
								<!-- end widget div -->

							</div>
							<!-- end widget -->

				</article>
				

                </div>
                            <!-- end widget -->
                            
  
                      
						<!-- END COL -->
						
						
						
				
				
				<section id="widget-grid" class="">
	<div class="row">
		<div class="pull-right"></div>
	</div>
	<!-- row -->
	<div class="row">
		<!-- NEW WIDGET START -->
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> <!-- Widget ID (each widget will need unique ID)-->
		<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-11"
			data-widget-colorbutton="false" data-widget-colorbutton="false"
			data-widget-editbutton="false" data-widget-togglebutton="false"
			data-widget-deletebutton="false" data-widget-fullscreenbutton="false"
			data-widget-custombutton="false">

										<header>
								<!-- 	<span class="widget-icon"> <i class="fa fa-table"></i> </span> -->
									<h2>SOP Details</h2>
								</header>
		<div id="row">
			
				<div>	
				
				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
							<label for="category"><b>SOP Name : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
							<b><span id='sopName'></span> 	</b>					
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<div class="pull-right" style="padding-right: 2%;">
               		 <button type="button" class="btn btn-primary enableOnInput"  id ="excuteBtn" data-toggle="modal"  data-target="#itOpsWrkflwParamsPopUp">
													Execute
												</button>
               		 <button type="button" class="btn btn-primary" onclick="javaScript:fnIncidentList()">
													Back
												</button>
											
            	</div>	
						</div>	
					</div>
					
			</div>
			
		</div>			
            
		</div>
		
			</div>
			</article>
			</div>
			</section>						
						
						
			
		
		
					<!-- END ROW-->
					<!-- Modal popup for  Workflow Params -->
        <div class="modal fade" id="itOpsWrkflwParamsPopUp" tabindex="-1" role="dialog" aria-labelledby="itOpsSopParamsModal" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="itOpsSopParamsModal">
                            <b>SOP Parameters</b>
                        </h4>
                    </div>
                    
                   
                    <div class="modal-body">
                     <table class="table table-hover">
										<tr>
										<td>
										<div id='workflowparam'> </div>
										</td>
										</tr>
					</table>
										     	
                        </div>
                    <!-- -/.modal-body -->
                    
                     <div class="modal-footer">
                           
						<button type="button" class="btn btn-primary" onclick="fnLoad();">Execute</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
						
                        </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->

        </div>
        <!-- /.modal -->
    <!-- modal popup end for Workflow Params - -->



<div class="divMessageBox animated fadeIn fast"  id="MsgBoxBack"  tabindex="-1" role="dialog" aria-labelledby="itOpsSOpConfirmModal" style="display: none;">

			             <div id="Msg1" class="MessageBoxContainer animated fadeIn fast" >
			              <div class="MessageBoxMiddle">
			                <span class="MsgTitle" style="align: center;">
									Are you sure to run the SOP now ?
																
								</span>
								<div class="MessageBoxButtonSection">
										
									<button type="button" class="btn btn-primary" data-dismiss="MsgBoxBack" onclick="fnAfterCancelExecuteIncident()"> No </button>
									<button id="bot2-Msg1" class="btn btn-default btn-sm botTempo" onclick="javascript:fnExecuteIncident();">
										
										     Yes
									</button>
			        			</div>
			   			 </div>

				</div>
	</div> 




<script>


$('#dialog_simple').dialog({
autoOpen : false,
width : 400,
resizable : false,
modal : true,
title: false,
buttons : [{
html : "Ok",
"class" : "btn btn-primary",
click : function() {

$(this).dialog("close");
fnIncidentList();
}
} /* , {
html : "Cancel",
"class" : "btn btn-default",
click : function() {
alert("cancel");
$(this).dialog("close");
} 
} */]
});

</script>




 

 
<div id="dialog_simple">
<h3><b>
Process initiated successfully
</b></h3>
</div> 



</body>
</html>